/*******************************************************************************************************
 *
 * SwtGui.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.shared;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.services.ISourceProviderService;

import gama.common.interfaces.IKeyword;
import gama.common.preferences.GamaPreferences;
import gama.common.ui.IConsoleDisplayer;
import gama.common.ui.IDisplayCreator.DisplayDescription;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGamaView;
import gama.common.ui.IGamaView.Error;
import gama.common.ui.IGamaView.Parameters;
import gama.common.ui.IGamaView.Test;
import gama.common.ui.IGamaView.User;
import gama.common.ui.IGamlLabelProvider;
import gama.common.ui.IGui;
import gama.common.ui.IRuntimeExceptionHandler;
import gama.common.ui.IStatusDisplayer;
import gama.core.dev.utils.DEBUG;
import gama.kernel.experiment.ExperimentAgent;
import gama.kernel.experiment.IExperimentController;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ITopLevelAgent;
import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.ExperimentOutputManager;
import gama.outputs.IDisplayOutput;
import gama.outputs.InspectDisplayOutput;
import gama.outputs.LayeredDisplayOutput;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.ISimulationStateProvider;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.dialogs.Dialogs;
import gama.ui.base.dialogs.PickWorkspaceDialog;
import gama.ui.base.interfaces.IDisplayLayoutManager;
import gama.ui.base.interfaces.IModelRunner;
import gama.ui.base.interfaces.IOpenGLInitializer;
import gama.ui.base.interfaces.IRefreshHandler;
import gama.ui.base.interfaces.ISpeedDisplayer;
import gama.ui.base.interfaces.IUserDialogFactory;
import gama.ui.base.parameters.EditorsDialog;
import gama.ui.base.parameters.GamaWizard;
import gama.ui.base.parameters.GamaWizardDialog;
import gama.ui.base.parameters.GamaWizardPage;
import gama.ui.base.utils.PerspectiveHelper;
import gama.ui.base.utils.PerspectiveHelper.SimulationPerspectiveDescriptor;
import gama.ui.base.utils.ViewsHelper;
import gama.ui.base.utils.WebHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;
import gama.util.GamaFont;
import gama.util.GamaListFactory;
import gama.util.GamaMapFactory;
import gama.util.IList;
import gama.util.IMap;
import gama.util.file.IFileMetaDataProvider;
import gaml.architecture.user.UserPanelStatement;
import gaml.compilation.Symbol;
import gaml.descriptions.ActionDescription;
import gaml.statements.test.CompoundSummary;
import gaml.statements.test.TestExperimentSummary;

// TODO: Auto-generated Javadoc
/**
 * Written by drogoul Modified on 6 mai 2011.
 *
 * @todo Description
 */
public class SwtGui implements IGui {

	static {
		DEBUG.ON();
	}

	/** The instance. */
	private static SwtGui INSTANCE = new SwtGui();

	/**
	 * Gets the single instance of SwtGui.
	 *
	 * @return single instance of SwtGui
	 */
	public static IGui getInstance() { return INSTANCE; }

	/**
	 * Instantiates a new swt gui.
	 */
	private SwtGui() {}

	/** The all tests running. */
	public volatile static boolean ALL_TESTS_RUNNING;

	/** The highlighted agent. */
	private IAgent highlightedAgent;

	/** The mouse location in model. */
	private GamaPoint mouseLocationInModel;

	static {
		// GamaFonts.setLabelFont(PreferencesHelper.BASE_BUTTON_FONT.getValue());
		// PreferencesHelper.initialize();
	}

	/**
	 * Confirm close.
	 *
	 * @param exp
	 *            the exp
	 * @return true, if successful
	 */
	@Override
	public boolean confirmClose(final IExperimentPlan exp) {
		if (exp == null || !GamaPreferences.Runtime.CORE_ASK_CLOSING.getValue()) return true;
		PerspectiveHelper.switchToSimulationPerspective();
		return question("Close simulation confirmation", "Do you want to close experiment '" + exp.getName()
				+ "' of model '" + exp.getModel().getName() + "' ?");
	}

	/**
	 * Question.
	 *
	 * @param title
	 *            the title
	 * @param msg
	 *            the msg
	 * @return true, if successful
	 */
	@Override
	public boolean question(final String title, final String msg) {
		return Dialogs.question(title, msg);
	}

	/**
	 * Tell.
	 *
	 * @param title
	 *            the title
	 * @param msg
	 *            the msg
	 */
	@Override
	public void inform(final String title, final String msg) {
		Dialogs.inform(title, msg);
	}

	/**
	 * Error.
	 *
	 * @param title
	 *            the title
	 * @param err
	 *            the err
	 */
	@Override
	public void error(final String title, final String err) {
		Dialogs.error(title, err);
	}

	/**
	 * Runtime error.
	 *
	 * @param scope
	 *            the scope
	 * @param g
	 *            the g
	 */
	@Override
	public void runtimeError(final IScope scope, final GamaRuntimeException g) {
		if (g.isReported() || GAMA.getFrontmostController() != null && GAMA.getFrontmostController().isDisposing())
			return;
		final IRuntimeExceptionHandler handler = getRuntimeExceptionHandler();
		if (!handler.isRunning()) { handler.start(); }
		handler.offer(g);
		g.setReported();
	}

	/**
	 * Display errors.
	 *
	 * @param scope
	 *            the scope
	 * @param exceptions
	 *            the exceptions
	 */
	@Override
	public void displayErrors(final IScope scope, final List<GamaRuntimeException> exceptions) {
		if (exceptions == null) {
			ViewsHelper.hideView(ERROR_VIEW_ID);
		} else {
			final IGamaView.Error v = (Error) showView(scope, ERROR_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);
			if (v != null) { v.displayErrors(); }
		}
	}

	/**
	 * Open test view.
	 *
	 * @param scope
	 *            the scope
	 * @param allTests
	 *            the all tests
	 * @return the i gama view. test
	 */
	@Override
	public IGamaView.Test openTestView(final IScope scope, final boolean allTests) {
		ALL_TESTS_RUNNING = allTests;
		final IGamaView.Test v = (Test) showView(scope, TEST_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);
		if (v != null) { v.startNewTestSequence(allTests); }
		return v;
	}

	/**
	 * Display tests results.
	 *
	 * @param scope
	 *            the scope
	 * @param summary
	 *            the summary
	 */
	@Override
	public void displayTestsResults(final IScope scope, final CompoundSummary<?, ?> summary) {
		final IGamaView.Test v = (Test) WorkbenchHelper.getPage().findView(TEST_VIEW_ID);
		if (v != null) { v.addTestResult(summary); }
	}

	/**
	 * End test display.
	 */
	@Override
	public void endTestDisplay() {
		final IGamaView.Test v = (Test) WorkbenchHelper.getPage().findView(TEST_VIEW_ID);
		if (v != null) { v.finishTestSequence(); }
		WorkbenchHelper.getService(IRefreshHandler.class).refreshNavigator();
	}

	/**
	 * Clear errors.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void clearErrors(final IScope scope) {
		final IRuntimeExceptionHandler handler = getRuntimeExceptionHandler();
		handler.clearErrors();
	}

	/**
	 * Internal show view.
	 *
	 * @param viewId
	 *            the view id
	 * @param secondaryId
	 *            the secondary id
	 * @param code
	 *            the code
	 * @return the object
	 */
	private Object internalShowView(final String viewId, final String secondaryId, final int code) {
		if (GAMA.getFrontmostController() != null && GAMA.getFrontmostController().isDisposing()) return null;
		final Object[] result = new Object[1];
		WorkbenchHelper.run(() -> {
			try {
				final IWorkbenchPage page = WorkbenchHelper.getPage();
				if (page != null) {
					page.zoomOut();
					final String second = secondaryId == null ? null
							: secondaryId + "@@@" + String.valueOf(System.currentTimeMillis());
					// The goal here is to address #2441 by randomizing the ids of views.
					// DEBUG.LOG("Opening view " + viewId + " " + second);
					result[0] = page.showView(viewId, second, code);
				}
			} catch (final Exception e) {
				result[0] = e;
			}
		});
		return result[0];
	}

	/**
	 * Copy to clipboard.
	 *
	 * @param text
	 *            the text
	 * @return true, if successful
	 */
	@Override
	public boolean copyToClipboard(final String text) {
		WorkbenchHelper.asyncRun(() -> {
			final Clipboard clipboard = new Clipboard(WorkbenchHelper.getDisplay());
			final TextTransfer textTransfer = TextTransfer.getInstance();
			final Transfer[] transfers = { textTransfer };
			final Object[] data = { text };
			clipboard.setContents(data, transfers);
			clipboard.dispose();
		});
		return true;
	}

	/**
	 * Open welcome page.
	 *
	 * @param ifEmpty
	 *            the if empty
	 */
	@Override
	public void openWelcomePage(final boolean ifEmpty) {
		WebHelper.openWelcomePage(ifEmpty);
	}

	/**
	 * Show view.
	 *
	 * @param scope
	 *            the scope
	 * @param viewId
	 *            the view id
	 * @param secondaryId
	 *            the secondary id
	 * @param code
	 *            the code
	 * @return the i gama view
	 */
	@Override
	public IGamaView showView(final IScope scope, final String viewId, final String secondaryId, final int code) {

		Object o = internalShowView(viewId, secondaryId, code);
		if (o instanceof IWorkbenchPart) {
			if (o instanceof IGamaView) return (IGamaView) o;
			o = GamaRuntimeException.error("Impossible to open view " + viewId, GAMA.getRuntimeScope());
		}
		if (o instanceof Throwable) {
			GAMA.reportError(GAMA.getRuntimeScope(), GamaRuntimeException.create((Exception) o, GAMA.getRuntimeScope()),
					false);
		}
		return null;
	}

	/**
	 * Open simulation perspective.
	 *
	 * @param model
	 *            the model
	 * @param experimentName
	 *            the experiment name
	 * @return true, if successful
	 */
	@Override
	public final boolean openSimulationPerspective(final IModel model, final String experimentName) {
		return PerspectiveHelper.openSimulationPerspective(model, experimentName);
	}

	/**
	 * Gets the display description for.
	 *
	 * @param name
	 *            the name
	 * @return the display description for
	 */
	@Override
	public DisplayDescription getDisplayDescriptionFor(final String name) {
		return DISPLAYS.get(name);
	}

	/**
	 * Creates the display surface for.
	 *
	 * @param output
	 *            the output
	 * @param args
	 *            the args
	 * @return the i display surface
	 */
	@Override
	public IDisplaySurface createDisplaySurfaceFor(final LayeredDisplayOutput output, final Object... args) {
		IDisplaySurface surface;
		final String keyword = output.getData().getDisplayType();
		final DisplayDescription creator = DISPLAYS.get(keyword);
		if (creator == null)
			throw GamaRuntimeException.error("Display " + keyword + " is not defined anywhere.", output.getScope());
		surface = creator.create(output, args);
		surface.outputReloaded();
		return surface;
	}

	/**
	 * Gets the all display surfaces.
	 *
	 * @return the all display surfaces
	 */
	@Override
	public Iterable<IDisplaySurface> getAllDisplaySurfaces() { return ViewsHelper.allDisplaySurfaces(); }

	/**
	 * Open user input dialog.
	 *
	 * @param scope
	 *            the scope
	 * @param title
	 *            the title
	 * @param parameters
	 *            the parameters
	 * @param font
	 *            the font
	 * @param color
	 *            the color
	 * @return the map
	 */
	@Override
	public Map<String, Object> openUserInputDialog(final IScope scope, final String title,
			final List<IParameter> parameters, final GamaFont font, final GamaColor color) {
		final IMap<String, Object> result = GamaMapFactory.createUnordered();
		for (final IParameter p : parameters) {
			result.put(p.getName(), p.getInitialValue(scope));
		}
		WorkbenchHelper.run(() -> {
			final EditorsDialog dialog = new EditorsDialog(scope, null, parameters, title, font, color);
			if (dialog.open() == Window.OK) { result.putAll(dialog.getValues()); }
		});
		return result;
	}

	/**
	 * Open wizard.
	 *
	 * @param scope
	 *            the scope
	 * @param title
	 *            the title
	 * @param finish
	 *            the finish
	 * @param pages
	 *            the pages
	 * @return the i map
	 */
	@Override
	public IMap<String, IMap<String, Object>> openWizard(final IScope scope, final String title,
			final ActionDescription finish, final IList<IMap<String, Object>> pages) {
		final IMap<String, IMap<String, Object>> result = GamaMapFactory.create();
		final IList<GamaWizardPage> wizardPages = GamaListFactory.create();
		for (IMap<String, Object> l : pages) {
			GamaFont f = (GamaFont) l.get(IKeyword.FONT);
			String t = (String) l.get(IKeyword.TITLE);
			String d = (String) l.get(IKeyword.DESCRIPTION);
			List<IParameter> ps = (List<IParameter>) l.get(IKeyword.PARAMETERS);

			wizardPages.add(new GamaWizardPage(scope, ps, t, d, f));

		}

		WorkbenchHelper.run(() -> {
			final GamaWizard wizard = new GamaWizard(title, finish, wizardPages);
			GamaWizardDialog wizardDialog = new GamaWizardDialog(WorkbenchHelper.getShell(), wizard);
			if (wizardDialog.open() == Window.OK) { result.putAll(wizardDialog.getValues()); }
		});
		return result;
	}

	/*
	 * @Override public Map<String, Object> openWizard(final IScope scope, final String title, final List<IParameter>
	 * parameters, final GamaFont font) { final IMap<String, Object> result = GamaMapFactory.createUnordered(); for
	 * (final IParameter p : parameters) { result.put(p.getName(), p.getInitialValue(scope)); } WorkbenchHelper.run(()
	 * -> { final EditorsDialog dialog = new EditorsDialog(scope, WorkbenchHelper.getShell(), parameters, title, font);
	 * if (dialog.open() == Window.OK) { result.putAll(dialog.getValues()); } }); return result; }
	 */

	/**
	 * Open user input dialog confirm.
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @return the boolean
	 */
	@Override
	public boolean confirm(final String title, final String message) {
		final List<Boolean> result = new ArrayList<>();
		WorkbenchHelper.run(() -> {
			result.add(Dialogs.confirm(title, message));
		});
		return result.isEmpty() ? false : result.get(0);
	}

	/**
	 * Open user control panel.
	 *
	 * @param scope
	 *            the scope
	 * @param panel
	 *            the panel
	 */
	@Override
	public void openUserControlPanel(final IScope scope, final UserPanelStatement panel) {
		WorkbenchHelper.run(() -> {
			IGamaView.User part;
			part = (User) showView(scope, USER_CONTROL_VIEW_ID, null, IWorkbenchPage.VIEW_CREATE);
			if (part != null) { part.initFor(scope, panel); }
			scope.setOnUserHold(true);
			try {
				WorkbenchHelper.getPage().showView(USER_CONTROL_VIEW_ID);
			} catch (final PartInitException e) {
				e.printStackTrace();
			}
		});

	}

	/**
	 * Close dialogs.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void closeDialogs(final IScope scope) {

		WorkbenchHelper.run(() -> {
			final IUserDialogFactory userDialogFactory = WorkbenchHelper.getService(IUserDialogFactory.class);
			if (userDialogFactory != null) { userDialogFactory.closeUserDialog(); }
			ViewsHelper.hideView(USER_CONTROL_VIEW_ID);

		});

	}

	/**
	 * Gets the highlighted agent.
	 *
	 * @return the highlighted agent
	 */
	@Override
	public IAgent getHighlightedAgent() { return highlightedAgent; }

	/**
	 * Sets the highlighted agent.
	 *
	 * @param a
	 *            the new highlighted agent
	 */
	@Override
	public void setHighlightedAgent(final IAgent a) { highlightedAgent = a; }

	/**
	 * Gets the model runner.
	 *
	 * @return the model runner
	 */
	private IModelRunner getModelRunner() { return WorkbenchHelper.getService(IModelRunner.class); }

	/**
	 * Edits the model.
	 *
	 * @param scope
	 *            the scope
	 * @param eObject
	 *            the e object
	 */
	@Override
	public void editModel(final IScope scope, final Object eObject) {
		final IModelRunner modelRunner = getModelRunner();
		if (modelRunner == null) return;
		modelRunner.editModel(eObject);
	}

	/**
	 * Run headless tests.
	 *
	 * @param model
	 *            the model
	 * @return the list
	 */
	@Override
	public List<TestExperimentSummary> runHeadlessTests(final Object model) {
		final IModelRunner modelRunner = getModelRunner();
		if (modelRunner == null) return null;
		return modelRunner.runHeadlessTests(model);
	}

	/**
	 * Update parameter view.
	 *
	 * @param scope
	 *            the scope
	 * @param exp
	 *            the exp
	 */
	@Override
	public void updateParameterView(final IScope scope, final IExperimentPlan exp) {

		WorkbenchHelper.run(() -> {
			if (!exp.hasParametersOrUserCommands()) return;
			final IGamaView.Parameters view =
					(Parameters) showView(scope, PARAMETER_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);
			view.addItem(exp);
			view.updateItemValues();

		});
	}

	/**
	 * Show parameter view.
	 *
	 * @param scope
	 *            the scope
	 * @param exp
	 *            the exp
	 */
	@Override
	public void showParameterView(final IScope scope, final IExperimentPlan exp) {

		WorkbenchHelper.run(() -> {
			if (!exp.hasParametersOrUserCommands()) return;
			final IGamaView.Parameters view =
					(Parameters) showView(scope, PARAMETER_VIEW_ID, null, IWorkbenchPage.VIEW_VISIBLE);
			if (view != null) { view.addItem(exp); }
		});
	}

	/**
	 * Method setSelectedAgent().
	 *
	 * @param a
	 *            the new selected agent
	 * @see msi.gama.common.interfaces.IGui#setSelectedAgent(msi.gama.metamodel.agent.IAgent)
	 */
	@Override
	public void setSelectedAgent(final IAgent a) {
		WorkbenchHelper.asyncRun(() -> {
			if (WorkbenchHelper.getPage() == null || a == null) return;
			try {
				final InspectDisplayOutput output = InspectDisplayOutput.inspect(a, null);
				output.launch(a.getScope());
			} catch (final GamaRuntimeException g) {
				g.addContext("In opening the agent inspector");
				GAMA.reportError(GAMA.getRuntimeScope(), g, false);
			}
			final IViewReference r = WorkbenchHelper.getPage().findViewReference(IGui.AGENT_VIEW_ID, "");
			if (r != null) { WorkbenchHelper.getPage().bringToTop(r.getPart(true)); }
		});
	}

	/**
	 * Prepare for experiment.
	 *
	 * @param scope
	 *            the scope
	 * @param exp
	 *            the exp
	 */
	@Override
	public void prepareForExperiment(final IScope scope, final IExperimentPlan exp) {
		if (exp.isGui()) {
			// hideScreen();
			final IOpenGLInitializer initializer = WorkbenchHelper.getService(IOpenGLInitializer.class);
			if (initializer != null && !initializer.isDone()) { initializer.run(); }
			WorkbenchHelper.setWorkbenchWindowTitle(exp.getName() + " - " + exp.getModel().getFilePath());
			final ExperimentAgent agent = exp.getAgent();
			final ExperimentOutputManager manager = (ExperimentOutputManager) agent.getOutputManager();
			Symbol layout = manager.getLayout();
			if (layout == null) { layout = manager; }
			final Boolean keepTabs = layout.getFacetValue(scope, "tabs", true);
			final Boolean keepToolbars = layout.getFacetValue(scope, "toolbars", null);
			final Boolean showParameters = layout.getFacetValue(scope, "parameters", null);
			final Boolean showConsoles = layout.getFacetValue(scope, "consoles", null);
			final Boolean showNavigator = layout.getFacetValue(scope, "navigator", null);
			final Boolean showControls = layout.getFacetValue(scope, "controls", null);
			final Boolean keepTray = layout.getFacetValue(scope, "tray", null);
			boolean showEditors;
			if (layout.hasFacet("editors")) {
				showEditors = layout.getFacetValue(scope, "editors", false);
			} else {
				showEditors = !GamaPreferences.Modeling.EDITOR_PERSPECTIVE_HIDE.getValue();
			}
			WorkbenchHelper.runInUI("Arranging views", 0, m -> {
				WorkbenchHelper.getPage().setEditorAreaVisible(showEditors);
				if (showConsoles != null && !showConsoles) {
					ViewsHelper.hideView(IGui.CONSOLE_VIEW_ID);
					ViewsHelper.hideView(IGui.INTERACTIVE_CONSOLE_VIEW_ID);
				} else {
					getConsole().showConsoleView(exp.getAgent());
				}
				if (showParameters != null && !showParameters) {
					ViewsHelper.hideView(IGui.PARAMETER_VIEW_ID);
				} else {
					updateParameterView(scope, exp);
				}
				if (showNavigator != null && !showNavigator) { ViewsHelper.hideView(IGui.NAVIGATOR_VIEW_ID); }
				if (showControls != null) { WorkbenchHelper.getWindow().setCoolBarVisible(showControls); }
				if (keepTray != null) { PerspectiveHelper.showBottomTray(WorkbenchHelper.getWindow(), keepTray); }

				final SimulationPerspectiveDescriptor sd = PerspectiveHelper.getActiveSimulationPerspective();
				if (sd != null) {
					sd.keepTabs(keepTabs);
					sd.keepToolbars(keepToolbars);
					sd.keepControls(showControls);
					sd.keepTray(keepTray);
				}
			});

		}

	}

	/**
	 * Method cleanAfterExperiment().
	 *
	 * @see msi.gama.common.interfaces.IGui#cleanAfterExperiment(msi.gama.kernel.experiment.IExperimentPlan)
	 */
	@Override
	public void cleanAfterExperiment() {
		ViewsHelper.hideView(PARAMETER_VIEW_ID);
		final IGamaView m = (IGamaView) ViewsHelper.findView(MONITOR_VIEW_ID, null, false);
		if (m != null) {
			m.reset();
			ViewsHelper.hideView(MONITOR_VIEW_ID);
		}
		getConsole().eraseConsole(true);
		final IGamaView icv = (IGamaView) ViewsHelper.findView(INTERACTIVE_CONSOLE_VIEW_ID, null, false);
		if (icv != null) { icv.reset(); }
		final IRuntimeExceptionHandler handler = getRuntimeExceptionHandler();
		handler.stop();
	}

	/**
	 * Gets the runtime exception handler.
	 *
	 * @return the runtime exception handler
	 */
	private IRuntimeExceptionHandler getRuntimeExceptionHandler() {
		return WorkbenchHelper.getService(IRuntimeExceptionHandler.class);
	}

	/**
	 * Run model.
	 *
	 * @param object
	 *            the object
	 * @param exp
	 *            the exp
	 */
	@Override
	public void runModel(final Object object, final String exp) {
		final IModelRunner modelRunner = getModelRunner();
		if (modelRunner == null) return;
		modelRunner.runModel(object, exp);
	}

	/**
	 * Method updateSpeedDisplay().
	 *
	 * @param scope
	 *            the scope
	 * @param d
	 *            the d
	 * @param notify
	 *            the notify
	 * @see msi.gama.common.interfaces.IGui#updateSpeedDisplay(java.lang.Double)
	 */
	@Override
	public void updateSpeedDisplay(final IScope scope, final Double d, final boolean notify) {
		final ISpeedDisplayer speedStatus = WorkbenchHelper.getService(ISpeedDisplayer.class);
		if (speedStatus != null) {
			WorkbenchHelper.asyncRun(() -> speedStatus.setInit(d, notify));

		}
	}

	/**
	 * Method getMetaDataProvider().
	 *
	 * @return the meta data provider
	 * @see msi.gama.common.interfaces.IGui#getMetaDataProvider()
	 */
	@Override
	public IFileMetaDataProvider getMetaDataProvider() {
		return WorkbenchHelper.getService(IFileMetaDataProvider.class);
	}

	/**
	 * Gets the gaml label provider.
	 *
	 * @return the gaml label provider
	 */
	@Override
	public IGamlLabelProvider getGamlLabelProvider() { return WorkbenchHelper.getService(IGamlLabelProvider.class); }

	/**
	 * Close simulation views.
	 *
	 * @param scope
	 *            the scope
	 * @param openModelingPerspective
	 *            the open modeling perspective
	 * @param immediately
	 *            the immediately
	 */
	@Override
	public void closeSimulationViews(final IScope scope, final boolean openModelingPerspective,
			final boolean immediately) {
		WorkbenchHelper.run(() -> {
			final IWorkbenchPage page = WorkbenchHelper.getPage();
			final IViewReference[] views = page.getViewReferences();

			for (final IViewReference view : views) {
				final IViewPart part = view.getView(false);
				if (part instanceof IGamaView) { ((IGamaView) part).close(scope); }
			}
			if (openModelingPerspective) {
				DEBUG.OUT("Deleting simulation perspective and opening immediately the modeling perspective = "
						+ immediately);
				PerspectiveHelper.deleteCurrentSimulationPerspective();
				PerspectiveHelper.openModelingPerspective(immediately, false);
			}

			getStatus(scope).neutralStatus("No simulation running");
		});

	}

	/**
	 * Gets the experiment state.
	 *
	 * @param uid
	 *            the uid
	 * @return the experiment state
	 */
	@Override
	public String getExperimentState(final String uid) {
		final IExperimentController controller = GAMA.getFrontmostController();
		if (controller == null) return ISimulationStateProvider.NONE;
		if (controller.getScheduler().paused) return ISimulationStateProvider.PAUSED;
		return ISimulationStateProvider.RUNNING;
	}

	/**
	 * Update experiment state.
	 *
	 * @param scope
	 *            the scope
	 * @param forcedState
	 *            the forced state
	 */
	@Override
	public void updateExperimentState(final IScope scope, final String forcedState) {
		DEBUG.OUT("STATE: " + forcedState);
		final ISourceProviderService service = WorkbenchHelper.getService(ISourceProviderService.class);
		final ISimulationStateProvider stateProvider =
				(ISimulationStateProvider) service.getSourceProvider(ISimulationStateProvider.SIMULATION_RUNNING_STATE);
		if (stateProvider != null) { WorkbenchHelper.run(() -> stateProvider.updateStateTo(forcedState)); }
	}

	/**
	 * Update experiment state.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void updateExperimentState(final IScope scope) {
		updateExperimentState(scope, getExperimentState(""));
	}

	/**
	 * Update view title.
	 *
	 * @param out
	 *            the out
	 * @param agent
	 *            the agent
	 */
	@Override
	public void updateViewTitle(final IDisplayOutput out, final SimulationAgent agent) {
		WorkbenchHelper.run(() -> {
			final IViewPart part = ViewsHelper.findView(out.getViewId(), out.isUnique() ? null : out.getName(), true);
			if (part instanceof IGamaView) { ((IGamaView) part).changePartNameWithSimulation(agent); }
		});

	}

	/**
	 * Update decorator.
	 *
	 * @param id
	 *            the id
	 */
	@Override
	public void updateDecorator(final String id) {
		WorkbenchHelper.asyncRun(() -> WorkbenchHelper.getWorkbench().getDecoratorManager().update(id));

	}

	/**
	 * Gets the status.
	 *
	 * @param scope
	 *            the scope
	 * @return the status
	 */
	@Override
	public IStatusDisplayer getStatus(final IScope scope) {
		return WorkbenchHelper.getService(IStatusDisplayer.class);
	}

	/**
	 * Gets the console.
	 *
	 * @return the console
	 */
	@Override
	public IConsoleDisplayer getConsole() { return WorkbenchHelper.getService(IConsoleDisplayer.class); }

	/**
	 * Run.
	 *
	 * @param taskName
	 *            the task name
	 * @param r
	 *            the r
	 * @param asynchronous
	 *            the asynchronous
	 */
	@Override
	public void run(final String taskName, final Runnable r, final boolean asynchronous) {

		if (asynchronous) {
			WorkbenchHelper.runInUI(taskName, 0, m -> r.run());
		} else {
			WorkbenchHelper.run(r);
		}
	}

	/**
	 * Sets the focus on.
	 *
	 * @param shape
	 *            the new focus on
	 */
	@Override
	public void setFocusOn(final IShape shape) {
		if (shape == null) return;
		for (final IDisplaySurface surface : ViewsHelper.allDisplaySurfaces()) {
			if (shape instanceof ITopLevelAgent) {
				surface.zoomFit();
			} else {
				surface.focusOn(shape);
			}
		}
		GAMA.getExperiment().refreshAllOutputs();
	}

	/**
	 * Apply layout.
	 *
	 * @param scope
	 *            the scope
	 * @param layout
	 *            the layout
	 */
	@Override
	public void applyLayout(final IScope scope, final Object layout) {
		final IDisplayLayoutManager manager = WorkbenchHelper.getService(IDisplayLayoutManager.class);
		if (manager != null) { manager.applyLayout(layout); }
	}

	/**
	 * Gets the mouse location in model.
	 *
	 * @return the mouse location in model
	 */
	@Override
	public GamaPoint getMouseLocationInModel() { return mouseLocationInModel; }

	/**
	 * Sets the mouse location in model.
	 *
	 * @param location
	 *            the new mouse location in model
	 */
	@Override
	public void setMouseLocationInModel(final GamaPoint location) { mouseLocationInModel = location; }

	/**
	 * Exit.
	 */
	@Override
	public void exit() {
		WorkbenchHelper.close();
	}

	/**
	 * Refresh navigator.
	 */
	@Override
	public void refreshNavigator() {
		final IRefreshHandler refresh = WorkbenchHelper.getService(IRefreshHandler.class);
		if (refresh != null) { refresh.completeRefresh(null); }

	}

	/**
	 * Checks if is in display thread.
	 *
	 * @return true, if is in display thread
	 */
	@Override
	public boolean isInDisplayThread() { return EventQueue.isDispatchThread() || Display.getCurrent() != null; }

	/**
	 * Choose workspace.
	 *
	 * @return the int
	 */
	@Override
	public int chooseWorkspace() {
		int[] result = { 0 };
		WorkbenchHelper.run(() -> {
			try {
				result[0] = new PickWorkspaceDialog().open();
			} catch (Exception e) {}
		});
		return result[0];
	}
}
