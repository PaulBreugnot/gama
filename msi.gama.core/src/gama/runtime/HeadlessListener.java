/*******************************************************************************************************
 *
 * msi.gama.runtime.HeadlessListener.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.runtime;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IConsoleDisplayer;
import gama.common.ui.IDisplayCreator;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGamaView;
import gama.common.ui.IGamlLabelProvider;
import gama.common.ui.IGui;
import gama.common.ui.IStatusDisplayer;
import gama.common.ui.IDisplayCreator.DisplayDescription;
import gama.core.dev.utils.DEBUG;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ITopLevelAgent;
import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.IDisplayOutput;
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.display.NullDisplaySurface;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaColor;
import gama.util.GamaFont;
import gama.util.GamaMapFactory;
import gama.util.IList;
import gama.util.IMap;
import gama.util.file.IFileMetaDataProvider;
import gama.util.file.IGamaFileMetaData;
import gaml.architecture.user.UserPanelStatement;
import gaml.compilation.ast.ISyntacticElement;
import gaml.descriptions.ActionDescription;
import gaml.statements.test.CompoundSummary;
import gaml.statements.test.TestExperimentSummary;

public class HeadlessListener implements IGui {

	// See #2996: simplification of the logging done in this class
	// static Logger LOGGER = LogManager.getLogManager().getLogger("");
	// static Level LEVEL = Level.ALL;
	// final ThreadLocal<BufferedWriter> outputWriter = new ThreadLocal<>();

	static {
		// See #2996: simplification of the logging done in this class
		// if (GAMA.isInHeadLessMode()) {

		//
		// for (final Handler h : LOGGER.getHandlers()) {
		// h.setLevel(Level.ALL);
		// }
		// LOGGER.setLevel(Level.ALL);
		// }
		GAMA.setHeadlessGui(new HeadlessListener());
	}

	private static void log(final String s) {
		DEBUG.LOG(s);
	}

	@Override
	public Map<String, Object> openUserInputDialog(final IScope scope, final String title,
			final List<IParameter> parameters, final GamaFont font) {
		final Map<String, Object> initialValues = GamaMapFactory.create();
		parameters.forEach(p -> {
			initialValues.put(p.getName(), p.getInitialValue(scope));
		});
		return initialValues;
	}

	@Override
	public IMap<String, IMap<String, Object>> openWizard(final IScope scope, final String title,
			final ActionDescription finish, final IList<IMap<String, Object>> pages) {
		final IMap<String, IMap<String, Object>> initialValues = GamaMapFactory.create();
		for (IMap l : pages) {
			final IMap<String, Object> initialValuesPage = GamaMapFactory.create();
			String t = (String) l.get(IKeyword.TITLE);

			initialValues.put(t, initialValuesPage);
			IList<IParameter> ps = (IList<IParameter>) l.get(IKeyword.PARAMETERS);
			if (ps != null) {
				ps.forEach(p -> {
					initialValuesPage.put(p.getName(), p.getInitialValue(scope));
				});
			}

		}

		return initialValues;
	}

	@Override
	public boolean copyToClipboard(final String text) {
		return false;
	}

	@Override
	public void openUserControlPanel(final IScope scope, final UserPanelStatement panel) {}

	@Override
	public void closeDialogs(final IScope scope) {}

	@Override
	public IAgent getHighlightedAgent() {
		return null;
	}

	@Override
	public void setHighlightedAgent(final IAgent a) {}

	@Override
	public IGamaView showView(final IScope scope, final String viewId, final String name, final int code) {
		return null;
	}

	@Override
	public void showParameterView(final IScope scope, final IExperimentPlan exp) {}

	@Override
	public void runtimeError(final IScope scope, final GamaRuntimeException g) {
		error("Runtime error: ", g.getMessage());
	}

	@Override
	public boolean confirmClose(final IExperimentPlan experiment) {
		return true;
	}

	@Override
	public void prepareForExperiment(final IScope scope, final IExperimentPlan exp) {}

	@Override
	public boolean openSimulationPerspective(final IModel model, final String id) {
		return true;
	}

	// @SuppressWarnings ("rawtypes") static Map<String, Class> displayClasses = null;

	@Override
	public IDisplaySurface createDisplaySurfaceFor(final LayeredDisplayOutput output, final Object... objects) {

		IDisplaySurface surface = null;
		final IDisplayCreator creator = DISPLAYS.get("image");
		if (creator == null) return new NullDisplaySurface();
		surface = creator.create(output);
		surface.outputReloaded();
		return surface;
	}

	@Override
	public void editModel(final IScope scope, final Object eObject) {}

	@Override
	public void updateParameterView(final IScope scope, final IExperimentPlan exp) {}

	@Override
	public void setSelectedAgent(final IAgent a) {}

	@Override
	public void cleanAfterExperiment() {
		// DEBUG.LOG("[Headless] Clean after experiment.");
		// try {
		// outputWriter.get().flush();
		// outputWriter.get().close();
		// } catch (final IOException e) {
		// e.printStackTrace();
		// }

	}

	@Override
	public void runModel(final Object object, final String exp) {}

	/**
	 * Method updateSpeedDisplay()
	 *
	 * @see gama.common.ui.IGui#updateSpeedDisplay(java.lang.Double)
	 */
	@Override
	public void updateSpeedDisplay(final IScope scope, final Double d, final boolean notify) {}

	/**
	 * Method getMetaDataProvider()
	 *
	 * @see gama.common.ui.IGui#getMetaDataProvider()
	 */
	@Override
	public IFileMetaDataProvider getMetaDataProvider() {
		return new IFileMetaDataProvider() {

			@Override
			public void storeMetaData(final IResource file, final IGamaFileMetaData data, final boolean immediately) {}

			@Override
			public IGamaFileMetaData getMetaData(final Object element, final boolean includeOutdated,
					final boolean immediately) {
				return new IGamaFileMetaData() {

					@Override
					public boolean hasFailed() {
						return false;
					}

					@Override
					public String toPropertyString() {
						return "";
					}

					@Override
					public void setModificationStamp(final long modificationStamp) {}

					@Override
					public Object getThumbnail() {
						return "";
					}

					@Override
					public String getSuffix() {
						return "";
					}

					@Override
					public void appendSuffix(final StringBuilder sb) {}

					@Override
					public long getModificationStamp() {
						return 0;
					}

					@Override
					public String getDocumentation() {
						return "";
					}
				};
			}

		};
	}

	/**
	 * Method closeSimulationViews()
	 *
	 * @see gama.common.ui.IGui#closeSimulationViews(boolean)
	 */
	@Override
	public void closeSimulationViews(final IScope scope, final boolean andOpenModelingPerspective,
			final boolean immediately) {}

	/**
	 * Method getDisplayDescriptionFor()
	 *
	 * @see gama.common.ui.IGui#getDisplayDescriptionFor(java.lang.String)
	 */
	@Override
	public DisplayDescription getDisplayDescriptionFor(final String name) {
		return new DisplayDescription(null, "display", "msi.gama.core");
	}

	/**
	 * Method getFrontmostSimulationState()
	 *
	 * @see gama.common.ui.IGui#getExperimentState()
	 */
	@Override
	public String getExperimentState(final String uid) {
		return RUNNING; // ???
	}

	/**
	 * Method updateSimulationState()
	 *
	 * @see gama.common.ui.IGui#updateExperimentState(java.lang.String)
	 */
	@Override
	public void updateExperimentState(final IScope scope, final String state) {}

	/**
	 * Method updateSimulationState()
	 *
	 * @see gama.common.ui.IGui#updateExperimentState()
	 */
	@Override
	public void updateExperimentState(final IScope scope) {}

	@Override
	public void updateViewTitle(final IDisplayOutput output, final SimulationAgent agent) {}

	@Override
	public void openWelcomePage(final boolean b) {}

	@Override
	public void updateDecorator(final String string) {}

	IStatusDisplayer status = new IStatusDisplayer() {

		@Override
		public void resumeStatus() {}

		@Override
		public void waitStatus(final String string) {}

		@Override
		public void informStatus(final String string) {}

		@Override
		public void errorStatus(final String message) {}

		@Override
		public void setSubStatusCompletion(final double status) {}

		@Override
		public void setStatus(final String msg, final GamaColor color) {}

		@Override
		public void informStatus(final String message, final String icon) {}

		@Override
		public void setStatus(final String msg, final String icon) {}

		@Override
		public void beginSubStatus(final String name) {}

		@Override
		public void endSubStatus(final String name) {}

		@Override
		public void neutralStatus(final String string) {}

	};

	IConsoleDisplayer console = new IConsoleDisplayer() {

		@Override
		public void debugConsole(final int cycle, final String s, final ITopLevelAgent root, final GamaColor color) {
			informConsole(s, root);
		}

		@Override
		public void debugConsole(final int cycle, final String s, final ITopLevelAgent root) {
			informConsole(s, root);
		}

		@Override
		public void informConsole(final String s, final ITopLevelAgent root, final GamaColor color) {
			informConsole(s, root);
		}

		@Override
		public void informConsole(final String s, final ITopLevelAgent root) {
			DEBUG.ON();
			DEBUG.LOG(s);
			// if (outputWriter.get() != null) {
			// try {
			// outputWriter.get().write(s + Strings.LN);
			// // outputWriter.get().flush();
			// } catch (final IOException e) {
			// e.printStackTrace();
			// }
			// }
		}

		@Override
		public void showConsoleView(final ITopLevelAgent agent) {}

		@Override
		public void eraseConsole(final boolean setToNull) {}

	};

	@Override
	public IStatusDisplayer getStatus(final IScope scope) {
		return status;
	}

	@Override
	public IConsoleDisplayer getConsole() {
		return console;
	}

	@Override
	public void clearErrors(final IScope scope) {}

	@Override
	public void run(final String taskName, final Runnable opener, final boolean asynchronous) {
		if (opener != null) {
			if (asynchronous) {
				new Thread(opener).start();
			} else {
				opener.run();
			}
		}
	}

	@Override
	public void setFocusOn(final IShape o) {}

	@Override
	public void applyLayout(final IScope scope, final Object layout) {}

	@Override
	public void displayErrors(final IScope scope, final List<GamaRuntimeException> list) {}

	@Override
	public GamaPoint getMouseLocationInModel() {
		return new GamaPoint(0, 0);
	}

	@Override
	public void setMouseLocationInModel(final GamaPoint modelCoordinates) {}

	@Override
	public IGamlLabelProvider getGamlLabelProvider() {
		return new IGamlLabelProvider() {

			@Override
			public String getText(final ISyntacticElement element) {
				return "";
			}

			@Override
			public Object getImage(final ISyntacticElement element) {
				return null;
			}
		};
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void openInteractiveConsole(final IScope scope) {}

	@Override
	public IGamaView.Test openTestView(final IScope scope, final boolean remainOpen) {
		// final String pathToFile = scope.getModel().getFilePath().replace(scope.getModel().getWorkingPath(), "");
		// log("----------------------------------------------------------------");
		// log(" Running tests declared in " + pathToFile);
		// log("----------------------------------------------------------------");
		return null;
	}

	@Override
	public void displayTestsResults(final IScope scope, final CompoundSummary<?, ?> summary) {
		log(summary.toString());
	}

	@Override
	public List<TestExperimentSummary> runHeadlessTests(final Object model) {
		return null;
	}

	@Override
	public void endTestDisplay() {}

	@Override
	public boolean toggleFullScreenMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refreshNavigator() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInDisplayThread() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<IDisplaySurface> getAllDisplaySurfaces() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public void error(final String title, final String message) {
		log(title + ": " + message);
	}

	@Override
	public void inform(final String title, final String message) {
		log(title + ": " + message);
	}

	@Override
	public boolean question(final String title, final String message) {
		log("Question: " + message);
		return false;
	}

	@Override
	public boolean confirm(final String title, final String message) {
		log("Confirm: " + message);
		return false;
	}

	@Override
	public int chooseWorkspace() {
		return 0;
	}

}
