/*******************************************************************************************************
 *
 * HeadlessListener.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
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
import gama.common.ui.IDisplayCreator.DisplayDescription;
import gama.common.ui.IDisplaySurface;
import gama.common.ui.IGamaView;
import gama.common.ui.IGamlLabelProvider;
import gama.common.ui.IGui;
import gama.common.ui.IStatusDisplayer;
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

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving headless events. The class that is interested in processing a headless event
 * implements this interface, and the object created with that class is registered with a component using the
 * component's <code>addHeadlessListener<code> method. When the headless event occurs, that object's appropriate method
 * is invoked.
 *
 * @see HeadlessEvent
 */
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

	/**
	 * Log.
	 *
	 * @param s
	 *            the s
	 */
	private static void log(final String s) {
		DEBUG.LOG(s);
	}

	/**
	 * Open user input dialog.
	 *
	 * @param scope the scope
	 * @param title the title
	 * @param parameters the parameters
	 * @param font the font
	 * @param color the color
	 * @return the map
	 */
	@Override
	public Map<String, Object> openUserInputDialog(final IScope scope, final String title,
			final List<IParameter> parameters, final GamaFont font, final GamaColor color) {
		final Map<String, Object> initialValues = GamaMapFactory.create();
		parameters.forEach(p -> {
			initialValues.put(p.getName(), p.getInitialValue(scope));
		});
		return initialValues;
	}

	/**
	 * Open wizard.
	 *
	 * @param scope the scope
	 * @param title the title
	 * @param finish the finish
	 * @param pages the pages
	 * @return the i map
	 */
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

	/**
	 * Copy to clipboard.
	 *
	 * @param text the text
	 * @return true, if successful
	 */
	@Override
	public boolean copyToClipboard(final String text) {
		return false;
	}

	/**
	 * Open user control panel.
	 *
	 * @param scope the scope
	 * @param panel the panel
	 */
	@Override
	public void openUserControlPanel(final IScope scope, final UserPanelStatement panel) {}

	/**
	 * Close dialogs.
	 *
	 * @param scope the scope
	 */
	@Override
	public void closeDialogs(final IScope scope) {}

	/**
	 * Gets the highlighted agent.
	 *
	 * @return the highlighted agent
	 */
	@Override
	public IAgent getHighlightedAgent() { return null; }

	/**
	 * Sets the highlighted agent.
	 *
	 * @param a the new highlighted agent
	 */
	@Override
	public void setHighlightedAgent(final IAgent a) {}

	/**
	 * Show view.
	 *
	 * @param scope the scope
	 * @param viewId the view id
	 * @param name the name
	 * @param code the code
	 * @return the i gama view
	 */
	@Override
	public IGamaView showView(final IScope scope, final String viewId, final String name, final int code) {
		return null;
	}

	/**
	 * Show parameter view.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	@Override
	public void showParameterView(final IScope scope, final IExperimentPlan exp) {}

	/**
	 * Runtime error.
	 *
	 * @param scope the scope
	 * @param g the g
	 */
	@Override
	public void runtimeError(final IScope scope, final GamaRuntimeException g) {
		error("Runtime error: ", g.getMessage());
	}

	/**
	 * Confirm close.
	 *
	 * @param experiment the experiment
	 * @return true, if successful
	 */
	@Override
	public boolean confirmClose(final IExperimentPlan experiment) {
		return true;
	}

	/**
	 * Prepare for experiment.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	@Override
	public void prepareForExperiment(final IScope scope, final IExperimentPlan exp) {}

	/**
	 * Open simulation perspective.
	 *
	 * @param model the model
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	public boolean openSimulationPerspective(final IModel model, final String id) {
		return true;
	}

	// @SuppressWarnings ("rawtypes") static Map<String, Class> displayClasses = null;

	/**
	 * Creates the display surface for.
	 *
	 * @param output the output
	 * @param objects the objects
	 * @return the i display surface
	 */
	@Override
	public IDisplaySurface createDisplaySurfaceFor(final LayeredDisplayOutput output, final Object... objects) {

		IDisplaySurface surface;
		final IDisplayCreator creator = DISPLAYS.get("image");
		if (creator == null) return new NullDisplaySurface();
		surface = creator.create(output);
		surface.outputReloaded();
		return surface;
	}

	/**
	 * Edits the model.
	 *
	 * @param scope the scope
	 * @param eObject the e object
	 */
	@Override
	public void editModel(final IScope scope, final Object eObject) {}

	/**
	 * Update parameter view.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	@Override
	public void updateParameterView(final IScope scope, final IExperimentPlan exp) {}

	/**
	 * Sets the selected agent.
	 *
	 * @param a the new selected agent
	 */
	@Override
	public void setSelectedAgent(final IAgent a) {}

	/**
	 * Clean after experiment.
	 */
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

	/**
	 * Run model.
	 *
	 * @param object the object
	 * @param exp the exp
	 */
	@Override
	public void runModel(final Object object, final String exp) {}

	/**
	 * Method updateSpeedDisplay().
	 *
	 * @param scope the scope
	 * @param d the d
	 * @param notify the notify
	 * @see gama.common.ui.IGui#updateSpeedDisplay(java.lang.Double)
	 */
	@Override
	public void updateSpeedDisplay(final IScope scope, final Double d, final boolean notify) {}

	/**
	 * Method getMetaDataProvider().
	 *
	 * @return the meta data provider
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
					public Object getThumbnail() { return ""; }

					@Override
					public String getSuffix() { return ""; }

					@Override
					public void appendSuffix(final StringBuilder sb) {}

					@Override
					public long getModificationStamp() { return 0; }

					@Override
					public String getDocumentation() { return ""; }
				};
			}

		};
	}

	/**
	 * Method closeSimulationViews().
	 *
	 * @param scope the scope
	 * @param andOpenModelingPerspective the and open modeling perspective
	 * @param immediately the immediately
	 * @see gama.common.ui.IGui#closeSimulationViews(boolean)
	 */
	@Override
	public void closeSimulationViews(final IScope scope, final boolean andOpenModelingPerspective,
			final boolean immediately) {}

	/**
	 * Method getDisplayDescriptionFor().
	 *
	 * @param name the name
	 * @return the display description for
	 * @see gama.common.ui.IGui#getDisplayDescriptionFor(java.lang.String)
	 */
	@Override
	public DisplayDescription getDisplayDescriptionFor(final String name) {
		return new DisplayDescription(null, "display", "gama.core.kernel");
	}

	/**
	 * Method getFrontmostSimulationState().
	 *
	 * @param uid the uid
	 * @return the experiment state
	 * @see gama.common.ui.IGui#getExperimentState()
	 */
	@Override
	public String getExperimentState(final String uid) {
		return ISimulationStateProvider.RUNNING; // ???
	}

	/**
	 * Method updateSimulationState().
	 *
	 * @param scope the scope
	 * @param state the state
	 * @see gama.common.ui.IGui#updateExperimentState(java.lang.String)
	 */
	@Override
	public void updateExperimentState(final IScope scope, final String state) {}

	/**
	 * Method updateSimulationState().
	 *
	 * @param scope the scope
	 * @see gama.common.ui.IGui#updateExperimentState()
	 */
	@Override
	public void updateExperimentState(final IScope scope) {}

	/**
	 * Update view title.
	 *
	 * @param output the output
	 * @param agent the agent
	 */
	@Override
	public void updateViewTitle(final IDisplayOutput output, final SimulationAgent agent) {}

	/**
	 * Open welcome page.
	 *
	 * @param b the b
	 */
	@Override
	public void openWelcomePage(final boolean b) {}

	/**
	 * Update decorator.
	 *
	 * @param string the string
	 */
	@Override
	public void updateDecorator(final String string) {}

	/** The status. */
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

	/** The console. */
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

	/**
	 * Gets the status.
	 *
	 * @param scope the scope
	 * @return the status
	 */
	@Override
	public IStatusDisplayer getStatus(final IScope scope) {
		return status;
	}

	/**
	 * Gets the console.
	 *
	 * @return the console
	 */
	@Override
	public IConsoleDisplayer getConsole() { return console; }

	/**
	 * Clear errors.
	 *
	 * @param scope the scope
	 */
	@Override
	public void clearErrors(final IScope scope) {}

	/**
	 * Run.
	 *
	 * @param taskName the task name
	 * @param opener the opener
	 * @param asynchronous the asynchronous
	 */
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

	/**
	 * Sets the focus on.
	 *
	 * @param o the new focus on
	 */
	@Override
	public void setFocusOn(final IShape o) {}

	/**
	 * Apply layout.
	 *
	 * @param scope the scope
	 * @param layout the layout
	 */
	@Override
	public void applyLayout(final IScope scope, final Object layout) {}

	/**
	 * Display errors.
	 *
	 * @param scope the scope
	 * @param list the list
	 */
	@Override
	public void displayErrors(final IScope scope, final List<GamaRuntimeException> list) {}

	/**
	 * Gets the mouse location in model.
	 *
	 * @return the mouse location in model
	 */
	@Override
	public GamaPoint getMouseLocationInModel() { return new GamaPoint(0, 0); }

	/**
	 * Sets the mouse location in model.
	 *
	 * @param modelCoordinates the new mouse location in model
	 */
	@Override
	public void setMouseLocationInModel(final GamaPoint modelCoordinates) {}

	/**
	 * Gets the gaml label provider.
	 *
	 * @return the gaml label provider
	 */
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

	/**
	 * Exit.
	 */
	@Override
	public void exit() {
		System.exit(0);
	}

	/**
	 * Open interactive console.
	 *
	 * @param scope the scope
	 */
	@Override
	public void openInteractiveConsole(final IScope scope) {}

	/**
	 * Open test view.
	 *
	 * @param scope the scope
	 * @param remainOpen the remain open
	 * @return the i gama view. test
	 */
	@Override
	public IGamaView.Test openTestView(final IScope scope, final boolean remainOpen) {
		// final String pathToFile = scope.getModel().getFilePath().replace(scope.getModel().getWorkingPath(), "");
		// log("----------------------------------------------------------------");
		// log(" Running tests declared in " + pathToFile);
		// log("----------------------------------------------------------------");
		return null;
	}

	/**
	 * Display tests results.
	 *
	 * @param scope the scope
	 * @param summary the summary
	 */
	@Override
	public void displayTestsResults(final IScope scope, final CompoundSummary<?, ?> summary) {
		log(summary.toString());
	}

	/**
	 * Run headless tests.
	 *
	 * @param model the model
	 * @return the list
	 */
	@Override
	public List<TestExperimentSummary> runHeadlessTests(final Object model) {
		return null;
	}

	/**
	 * End test display.
	 */
	@Override
	public void endTestDisplay() {}

	/**
	 * Toggle full screen mode.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean toggleFullScreenMode() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Refresh navigator.
	 */
	@Override
	public void refreshNavigator() {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if is in display thread.
	 *
	 * @return true, if is in display thread
	 */
	@Override
	public boolean isInDisplayThread() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Gets the all display surfaces.
	 *
	 * @return the all display surfaces
	 */
	@Override
	public Iterable<IDisplaySurface> getAllDisplaySurfaces() { return Collections.EMPTY_LIST; }

	/**
	 * Error.
	 *
	 * @param title the title
	 * @param message the message
	 */
	@Override
	public void error(final String title, final String message) {
		log(title + ": " + message);
	}

	/**
	 * Inform.
	 *
	 * @param title the title
	 * @param message the message
	 */
	@Override
	public void inform(final String title, final String message) {
		log(title + ": " + message);
	}

	/**
	 * Question.
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
	@Override
	public boolean question(final String title, final String message) {
		log("Question: " + message);
		return false;
	}

	/**
	 * Confirm.
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
	@Override
	public boolean confirm(final String title, final String message) {
		log("Confirm: " + message);
		return false;
	}

	/**
	 * Choose workspace.
	 *
	 * @return the int
	 */
	@Override
	public int chooseWorkspace() {
		return 0;
	}

}
