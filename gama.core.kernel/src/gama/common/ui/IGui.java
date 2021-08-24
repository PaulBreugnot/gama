/*******************************************************************************************************
 *
 * IGui.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

import java.util.List;
import java.util.Map;

import gama.common.ui.IDisplayCreator.DisplayDescription;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.IParameter;
import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.outputs.IDisplayOutput;
import gama.outputs.LayeredDisplayOutput;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaFont;
import gama.util.GamaMapFactory;
import gama.util.IList;
import gama.util.IMap;
import gama.util.file.IFileMetaDataProvider;
import gaml.architecture.user.UserPanelStatement;
import gaml.descriptions.ActionDescription;
import gaml.statements.test.CompoundSummary;
import gaml.statements.test.TestExperimentSummary;

/**
 * The interface IGui. Represents objects that act on behalf of a concrete GUI implementation (RCP, Headless, etc.)
 *
 * @author drogoul
 * @since 18 dec. 2011
 *
 */
public interface IGui {

	/** The error. */
	int ERROR = 0;
	
	/** The wait. */
	int WAIT = 1;
	
	/** The inform. */
	int INFORM = 2;
	
	/** The neutral. */
	int NEUTRAL = 3;
	
	/** The user. */
	int USER = 4;

	/** The displays. */
	Map<String, DisplayDescription> DISPLAYS = GamaMapFactory.createUnordered();
	
	/** The monitor view id. */
	String MONITOR_VIEW_ID = "gama.view.MonitorView";
	
	/** The interactive console view id. */
	String INTERACTIVE_CONSOLE_VIEW_ID = "gama.view.InteractiveConsoleView";
	
	/** The agent view id. */
	String AGENT_VIEW_ID = "gama.view.AgentInspectView";
	
	/** The table view id. */
	String TABLE_VIEW_ID = "gama.view.TableAgentInspectView";
	
	/** The layer view id. */
	String LAYER_VIEW_ID = "gama.view.LayeredDisplayView";
	
	/** The gl layer view id. */
	String GL_LAYER_VIEW_ID = "gama.view.OpenGLDisplayView";
	
	/** The gl layer view id2. */
	String GL_LAYER_VIEW_ID2 = "gama.view.OpenGLDisplayView2";
	
	/** The gl layer view id3. */
	String GL_LAYER_VIEW_ID3 = "gama.view.WebDisplayView";
	
	/** The error view id. */
	String ERROR_VIEW_ID = "gama.view.ErrorView";
	
	/** The test view id. */
	String TEST_VIEW_ID = "gama.view.TestView";
	
	/** The parameter view id. */
	String PARAMETER_VIEW_ID = "gama.view.ParameterView";
	
	/** The navigator view id. */
	String NAVIGATOR_VIEW_ID = "gama.view.GamaNavigator";
	
	/** The console view id. */
	String CONSOLE_VIEW_ID = "gama.view.ConsoleView";
	
	/** The user control view id. */
	String USER_CONTROL_VIEW_ID = "gama.view.UserControlView";
	
	/** The syntax errors view id. */
	String SYNTAX_ERRORS_VIEW_ID = "gama.view.SyntaxErrorsView";

	/** The perspective modeling id. */
	String PERSPECTIVE_MODELING_ID = "gama.perspective.modeling";
	
	/** The navigator lightweight decorator id. */
	String NAVIGATOR_LIGHTWEIGHT_DECORATOR_ID = "msi.gama.application.decorator";

	/**
	 * Gets the status.
	 *
	 * @param scope the scope
	 * @return the status
	 */
	IStatusDisplayer getStatus(IScope scope);

	/**
	 * Gets the console.
	 *
	 * @return the console
	 */
	IConsoleDisplayer getConsole();

	/**
	 * Show view.
	 *
	 * @param scope the scope
	 * @param viewId the view id
	 * @param name the name
	 * @param code the code
	 * @return the i gama view
	 */
	IGamaView showView(IScope scope, String viewId, String name, int code);

	/**
	 * Show parameter view.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	void showParameterView(IScope scope, IExperimentPlan exp);

	/**
	 * Clear errors.
	 *
	 * @param scope the scope
	 */
	void clearErrors(IScope scope);

	/**
	 * Runtime error.
	 *
	 * @param scope the scope
	 * @param g the g
	 */
	void runtimeError(final IScope scope, GamaRuntimeException g);

	/**
	 * Confirm close.
	 *
	 * @param experiment the experiment
	 * @return true, if successful
	 */
	boolean confirmClose(IExperimentPlan experiment);

	/**
	 * Copy to clipboard.
	 *
	 * @param text the text
	 * @return true, if successful
	 */
	boolean copyToClipboard(String text);

	/**
	 * Open simulation perspective.
	 *
	 * @param model the model
	 * @param experimentId the experiment id
	 * @return true, if successful
	 */
	boolean openSimulationPerspective(IModel model, String experimentId);

	/**
	 * Gets the all display surfaces.
	 *
	 * @return the all display surfaces
	 */
	Iterable<IDisplaySurface> getAllDisplaySurfaces();

	/**
	 * Creates the display surface for.
	 *
	 * @param output the output
	 * @param args the args
	 * @return the i display surface
	 */
	IDisplaySurface createDisplaySurfaceFor(final LayeredDisplayOutput output, final Object... args);

	/**
	 * Open user input dialog.
	 *
	 * @param scope the scope
	 * @param title the title
	 * @param parameters the parameters
	 * @param font the font
	 * @return the map
	 */
	Map<String, Object> openUserInputDialog(IScope scope, String title, List<IParameter> parameters, GamaFont font);

	/**
	 * Open wizard.
	 *
	 * @param scope the scope
	 * @param title the title
	 * @param finish the finish
	 * @param pages the pages
	 * @return the i map
	 */
	IMap<String, IMap<String, Object>> openWizard(IScope scope, String title, ActionDescription finish,
			IList<IMap<String, Object>> pages);

	/**
	 * Open user control panel.
	 *
	 * @param scope the scope
	 * @param panel the panel
	 */
	void openUserControlPanel(IScope scope, UserPanelStatement panel);

	/**
	 * Close dialogs.
	 *
	 * @param scope the scope
	 */
	void closeDialogs(IScope scope);

	/**
	 * Gets the highlighted agent.
	 *
	 * @return the highlighted agent
	 */
	IAgent getHighlightedAgent();

	/**
	 * Sets the highlighted agent.
	 *
	 * @param a the new highlighted agent
	 */
	void setHighlightedAgent(IAgent a);

	/**
	 * Sets the selected agent.
	 *
	 * @param a the new selected agent
	 */
	void setSelectedAgent(IAgent a);

	/**
	 * Update parameter view.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	void updateParameterView(IScope scope, IExperimentPlan exp);

	/**
	 * Prepare for experiment.
	 *
	 * @param scope the scope
	 * @param exp the exp
	 */
	void prepareForExperiment(IScope scope, IExperimentPlan exp);

	/**
	 * Clean after experiment.
	 */
	void cleanAfterExperiment();

	/**
	 * Edits the model.
	 *
	 * @param scope the scope
	 * @param eObject the e object
	 */
	void editModel(IScope scope, Object eObject);

	/**
	 * Run model.
	 *
	 * @param object the object
	 * @param exp the exp
	 */
	void runModel(final Object object, final String exp);

	/**
	 * Update speed display.
	 *
	 * @param scope the scope
	 * @param d the d
	 * @param notify the notify
	 */
	void updateSpeedDisplay(IScope scope, Double d, boolean notify);

	/**
	 * Gets the meta data provider.
	 *
	 * @return the meta data provider
	 */
	IFileMetaDataProvider getMetaDataProvider();

	/**
	 * Close simulation views.
	 *
	 * @param scope the scope
	 * @param andOpenModelingPerspective the and open modeling perspective
	 * @param immediately the immediately
	 */
	void closeSimulationViews(IScope scope, boolean andOpenModelingPerspective, boolean immediately);

	/**
	 * Gets the display description for.
	 *
	 * @param name the name
	 * @return the display description for
	 */
	DisplayDescription getDisplayDescriptionFor(final String name);

	/**
	 * Gets the experiment state.
	 *
	 * @param uid the uid
	 * @return the experiment state
	 */
	String getExperimentState(String uid);

	/**
	 * Update experiment state.
	 *
	 * @param scope the scope
	 * @param state the state
	 */
	void updateExperimentState(IScope scope, String state);

	/**
	 * Update experiment state.
	 *
	 * @param scope the scope
	 */
	void updateExperimentState(IScope scope);

	/**
	 * Update view title.
	 *
	 * @param output the output
	 * @param agent the agent
	 */
	void updateViewTitle(IDisplayOutput output, SimulationAgent agent);

	/**
	 * Open welcome page.
	 *
	 * @param b the b
	 */
	void openWelcomePage(boolean b);

	/**
	 * Update decorator.
	 *
	 * @param string the string
	 */
	void updateDecorator(String string);

	/**
	 * Run.
	 *
	 * @param taskName the task name
	 * @param opener the opener
	 * @param asynchronous the asynchronous
	 */
	void run(String taskName, Runnable opener, boolean asynchronous);

	/**
	 * Sets the focus on.
	 *
	 * @param o the new focus on
	 */
	void setFocusOn(IShape o);

	/**
	 * Apply layout.
	 *
	 * @param scope the scope
	 * @param layout the layout
	 */
	void applyLayout(IScope scope, Object layout);

	/**
	 * Display errors.
	 *
	 * @param scope the scope
	 * @param newExceptions the new exceptions
	 */
	void displayErrors(IScope scope, List<GamaRuntimeException> newExceptions);

	/**
	 * Gets the mouse location in model.
	 *
	 * @return the mouse location in model
	 */
	GamaPoint getMouseLocationInModel();

	/**
	 * Sets the mouse location in model.
	 *
	 * @param modelCoordinates the new mouse location in model
	 */
	void setMouseLocationInModel(GamaPoint modelCoordinates);

	/**
	 * Gets the gaml label provider.
	 *
	 * @return the gaml label provider
	 */
	IGamlLabelProvider getGamlLabelProvider();

	/**
	 * Exit.
	 */
	void exit();

	/**
	 * Open interactive console.
	 *
	 * @param scope the scope
	 */
	void openInteractiveConsole(IScope scope);

	// Tests

	/**
	 * Open test view.
	 *
	 * @param scope the scope
	 * @param remainOpen the remain open
	 * @return the i gama view. test
	 */
	IGamaView.Test openTestView(IScope scope, boolean remainOpen);

	/**
	 * Display tests results.
	 *
	 * @param scope the scope
	 * @param summary the summary
	 */
	void displayTestsResults(IScope scope, CompoundSummary<?, ?> summary);

	/**
	 * End test display.
	 */
	void endTestDisplay();

	/**
	 * Run headless tests.
	 *
	 * @param model the model
	 * @return the list
	 */
	List<TestExperimentSummary> runHeadlessTests(final Object model);

	/**
	 * Tries to put the frontmost display in full screen mode or in normal view mode if it is already in full screen.
	 *
	 * @return true if the toggle has succeeded
	 */
	boolean toggleFullScreenMode();

	/**
	 * Refresh navigator.
	 */
	void refreshNavigator();

	/**
	 * Checks if is in display thread.
	 *
	 * @return true, if is in display thread
	 */
	boolean isInDisplayThread();

	/**
	 * Opens/displays/writes an error message. No need to call it from a specific thread
	 *
	 * @param title the title
	 * @param message the message
	 */
	void error(final String title, final String message);

	/**
	 * Error.
	 *
	 * @param message the message
	 */
	default void error(final String message) {
		error("Error", message);
	}

	/**
	 * Opens/displays/writes an information message. No need to call it from a specific thread
	 *
	 * @param title the title
	 * @param message the message
	 */
	void inform(final String title, final String message);

	/**
	 * Inform.
	 *
	 * @param message the message
	 */
	default void inform(final String message) {
		inform("Information", message);
	}

	/**
	 * Opens/displays/writes a question and awaits for the answer (yes or no, true or false). No need to call it from a
	 * specific thread
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
	boolean question(final String title, final String message);

	/**
	 * Asks the user to confirm a message (true if confirmed, false otherwise). No need to call it from a specific
	 * thread
	 *
	 * @param title the title
	 * @param message the message
	 * @return true, if successful
	 */
	boolean confirm(final String title, final String message);

	/**
	 * Opens the dialog allowing to choose a workspace. Returns 1 (Window.CANCEL) if the user has canceled the
	 * operation. All other values are ignored
	 *
	 * @return the int
	 */
	int chooseWorkspace();

}
