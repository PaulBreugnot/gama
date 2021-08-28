/*******************************************************************************************************
 *
 * GamaWorkbenchAdvisor.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.workbench;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.PluginActionBuilder;
import org.eclipse.ui.internal.ide.application.DelayedEventsProcessor;
import org.eclipse.ui.internal.ide.application.IDEWorkbenchAdvisor;
import org.eclipse.ui.statushandlers.AbstractStatusHandler;
import org.eclipse.ui.statushandlers.StatusAdapter;

import gama.common.preferences.GamaPreferences;
import gama.common.ui.IEventLayerDelegate;
import gama.common.ui.IGui;
import gama.common.util.FileUtils;
import gama.core.dev.utils.DEBUG;
import gama.outputs.layers.EventLayerStatement;
import gama.runtime.GAMA;
import gama.runtime.concurrent.GamaExecutorService;
import gama.ui.base.bindings.GamaKeyBindings;
import gama.ui.base.commands.TestsRunner;
import gama.ui.base.shared.SwtGui;
import gama.ui.base.utils.CleanupHelper;
import gama.ui.base.utils.PerspectiveHelper;
import gama.ui.base.utils.ThemeHelper;
import gama.ui.base.workspace.WorkspaceModelsManager;

/**
 * The Class GamaWorkbenchAdvisor.
 */
public class GamaWorkbenchAdvisor extends IDEWorkbenchAdvisor {

	{
		DEBUG.ON();
	}

	/**
	 * The Class OpenDocumentEventProcessor.
	 */
	public static class OpenDocumentEventProcessor extends DelayedEventsProcessor {

		/**
		 * Instantiates a new open document event processor.
		 *
		 * @param display
		 *            the display
		 */
		OpenDocumentEventProcessor(final Display display) {
			super(display);
		}

		/** The files to open. */
		private final ArrayList<String> filesToOpen = new ArrayList<>(1);

		@Override
		public void handleEvent(final Event event) {
			if (event.text != null) {
				filesToOpen.add(event.text);
				DEBUG.OUT("RECEIVED FILE TO OPEN: " + event.text);
			}
		}

		@Override
		public void catchUp(final Display display) {
			if (filesToOpen.isEmpty()) return;

			final String[] filePaths = filesToOpen.toArray(new String[filesToOpen.size()]);
			filesToOpen.clear();

			for (final String path : filePaths) {
				WorkspaceModelsManager.instance.openModelPassedAsArgument(path);
			}
		}
	}

	/**
	 * Creates the processor.
	 *
	 * @return the open document event processor
	 */
	public static OpenDocumentEventProcessor createProcessor() {
		final Display display = Display.getDefault();
		if (display == null) return null;
		return new OpenDocumentEventProcessor(display);
	}

	/**
	 * Instantiates a new gama workbench advisor.
	 */
	public GamaWorkbenchAdvisor() {
		super(createProcessor());
	}

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(final IWorkbenchWindowConfigurer configurer) {
		return new GamaWindowAdvisor(this, configurer);
	}

	@Override
	public void initialize(final IWorkbenchConfigurer configurer) {

		ResourcesPlugin.getPlugin().getStateLocation();
		try {
			super.initialize(configurer);

			final IDecoratorManager dm = configurer.getWorkbench().getDecoratorManager();
			dm.setEnabled("org.eclipse.pde.ui.binaryProjectDecorator", false);
			dm.setEnabled("org.eclipse.team.svn.ui.decorator.SVNLightweightDecorator", false);
			dm.setEnabled("msi.gama.application.decorator", true);
			dm.setEnabled("org.eclipse.ui.LinkedResourceDecorator", false);
			dm.setEnabled("org.eclipse.ui.VirtualResourceDecorator", false);
			dm.setEnabled("org.eclipse.xtext.builder.nature.overlay", false);
			if (Display.getCurrent() != null) {
				Display.getCurrent().getThread().setUncaughtExceptionHandler(GamaExecutorService.EXCEPTION_HANDLER);
			}
		} catch (final CoreException e) {}
		// dont show Help button in JFace dialogs
		TrayDialog.setDialogHelpAvailable(false);
		PluginActionBuilder.setAllowIdeLogging(false);
		ThemeHelper.install();
	}

	@Override
	public void postStartup() {
		super.postStartup();
		FileUtils.cleanCache();
		/// AD : was in Startup
		CleanupHelper.run();
		GamaKeyBindings.install();
		if (GAMA.getRegularGui() == null) { GAMA.setRegularGui(SwtGui.getInstance()); }
		if (GamaPreferences.Runtime.START_TESTS.getValue()) { TestsRunner.start(); }
		///
		final String[] args = Platform.getApplicationArgs();
		if (false) { DEBUG.LOG("Arguments received by GAMA : " + Arrays.toString(args)); }
		if (args.length > 0 && args[0].contains("launcher.defaultAction")
				&& !args[0].contains("--launcher.defaultAction"))
			return;
		if (args.length >= 1) {

			if (args[args.length - 1].endsWith(".gamr")) {
				for (final IEventLayerDelegate delegate : EventLayerStatement.delegates) {
					if (delegate.acceptSource(null, "launcher")) {
						delegate.createFrom(null, args[args.length - 1], null);
					}
				}
			} else {
				WorkspaceModelsManager.instance.openModelPassedAsArgument(args[args.length - 1]);
			}
		}
	}

	/**
	 * Check copy of built in models.
	 *
	 * @return true, if successful
	 */
	protected boolean checkCopyOfBuiltInModels() {

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProject[] projects = workspace.getRoot().getProjects();
		// If no projects are registered at all, we are facing a fresh new workspace
		if (projects.length == 0) return true;
		return false;

	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return IGui.PERSPECTIVE_MODELING_ID;
	}

	/**
	 * A workbench pre-shutdown method calls to prompt a confirmation of the shutdown and perform a saving of the
	 * workspace
	 */
	@Override
	public boolean preShutdown() {
		try {
			GAMA.closeAllExperiments(true, true);
			PerspectiveHelper.deleteCurrentSimulationPerspective();
			// So that they are not saved to the workbench.xmi file
			PerspectiveHelper.cleanPerspectives();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return super.preShutdown();

	}

	@Override
	public void postShutdown() {
		try {
			super.postShutdown();
		} catch (final Exception e) {
			// Remove the trace of exceptions
			// e.printStackTrace();
		}
	}

	@Override
	public void preStartup() {
		// Suspend background jobs while we startup
		Job.getJobManager().suspend();
		// super.preStartup();
		/* Linking the stock models with the workspace if they are not already */
		if (checkCopyOfBuiltInModels()) { WorkspaceModelsManager.linkSampleModelsToWorkspace(); }

	}

	/**
	 * Method getWorkbenchErrorHandler()
	 *
	 * @see org.eclipse.ui.internal.ide.application.IDEWorkbenchAdvisor#getWorkbenchErrorHandler()
	 */
	@Override
	public synchronized AbstractStatusHandler getWorkbenchErrorHandler() {
		return new AbstractStatusHandler() {

			@Override
			public void handle(final StatusAdapter statusAdapter, final int style) {
				final int severity = statusAdapter.getStatus().getSeverity();
				if (severity == IStatus.INFO || severity == IStatus.CANCEL) return;
				final Throwable e = statusAdapter.getStatus().getException();
				if (e instanceof OutOfMemoryError) {
					GamaExecutorService.EXCEPTION_HANDLER.uncaughtException(Thread.currentThread(), e);
				}
				final String message = statusAdapter.getStatus().getMessage();
				// Stupid Eclipse
				if (!message.contains("File toolbar contribution item") && !message.contains("Duplicate template id")) {
					DEBUG.OUT("GAMA caught a workbench message : " + message);
				}
				if (e != null) { DEBUG.OUT("GAMA caught an error in the main application loop: " + e.getMessage()); }
			}
		};
	}

	@Override
	public void eventLoopException(final Throwable t) {
		DEBUG.OUT("GAMA caught an error in the main application loop: " + t.getMessage());
	}

}
