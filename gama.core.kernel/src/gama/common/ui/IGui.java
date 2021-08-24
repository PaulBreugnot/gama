/*******************************************************************************************************
 *
 * msi.gama.common.interfaces.IGui.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

	int ERROR = 0;
	int WAIT = 1;
	int INFORM = 2;
	int NEUTRAL = 3;
	int USER = 4;

	Map<String, DisplayDescription> DISPLAYS = GamaMapFactory.createUnordered();
	String MONITOR_VIEW_ID = "gama.view.MonitorView";
	String INTERACTIVE_CONSOLE_VIEW_ID = "gama.view.InteractiveConsoleView";
	String AGENT_VIEW_ID = "gama.view.AgentInspectView";
	String TABLE_VIEW_ID = "gama.view.TableAgentInspectView";
	String LAYER_VIEW_ID = "gama.view.LayeredDisplayView";
	String GL_LAYER_VIEW_ID = "gama.view.OpenGLDisplayView";
	String GL_LAYER_VIEW_ID2 = "gama.view.OpenGLDisplayView2";
	String GL_LAYER_VIEW_ID3 = "gama.view.WebDisplayView";

	String ERROR_VIEW_ID = "gama.view.ErrorView";
	String TEST_VIEW_ID = "gama.view.TestView";
	String PARAMETER_VIEW_ID = "gama.view.ParameterView";

	String NAVIGATOR_VIEW_ID = "gama.view.GamaNavigator";
	String NAVIGATOR_LIGHTWEIGHT_DECORATOR_ID = "msi.gama.application.decorator";
	String CONSOLE_VIEW_ID = "gama.view.ConsoleView";
	String USER_CONTROL_VIEW_ID = "gama.view.userControlView";

	String PERSPECTIVE_MODELING_ID = "gama.perspective.modeling";

	IStatusDisplayer getStatus(IScope scope);

	IConsoleDisplayer getConsole();

	IGamaView showView(IScope scope, String viewId, String name, int code);

	void showParameterView(IScope scope, IExperimentPlan exp);

	void clearErrors(IScope scope);

	void runtimeError(final IScope scope, GamaRuntimeException g);

	boolean confirmClose(IExperimentPlan experiment);

	boolean copyToClipboard(String text);

	boolean openSimulationPerspective(IModel model, String experimentId);

	Iterable<IDisplaySurface> getAllDisplaySurfaces();

	IDisplaySurface createDisplaySurfaceFor(final LayeredDisplayOutput output, final Object... args);

	Map<String, Object> openUserInputDialog(IScope scope, String title, List<IParameter> parameters, GamaFont font);

	IMap<String, IMap<String, Object>> openWizard(IScope scope, String title, ActionDescription finish,
			IList<IMap<String, Object>> pages);

	void openUserControlPanel(IScope scope, UserPanelStatement panel);

	void closeDialogs(IScope scope);

	IAgent getHighlightedAgent();

	void setHighlightedAgent(IAgent a);

	void setSelectedAgent(IAgent a);

	void updateParameterView(IScope scope, IExperimentPlan exp);

	void prepareForExperiment(IScope scope, IExperimentPlan exp);

	void cleanAfterExperiment();

	void editModel(IScope scope, Object eObject);

	void runModel(final Object object, final String exp);

	void updateSpeedDisplay(IScope scope, Double d, boolean notify);

	IFileMetaDataProvider getMetaDataProvider();

	void closeSimulationViews(IScope scope, boolean andOpenModelingPerspective, boolean immediately);

	DisplayDescription getDisplayDescriptionFor(final String name);

	String getExperimentState(String uid);

	void updateExperimentState(IScope scope, String state);

	void updateExperimentState(IScope scope);

	void updateViewTitle(IDisplayOutput output, SimulationAgent agent);

	void openWelcomePage(boolean b);

	void updateDecorator(String string);

	void run(String taskName, Runnable opener, boolean asynchronous);

	void setFocusOn(IShape o);

	void applyLayout(IScope scope, Object layout);

	void displayErrors(IScope scope, List<GamaRuntimeException> newExceptions);

	GamaPoint getMouseLocationInModel();

	void setMouseLocationInModel(GamaPoint modelCoordinates);

	IGamlLabelProvider getGamlLabelProvider();

	void exit();

	void openInteractiveConsole(IScope scope);

	// Tests

	IGamaView.Test openTestView(IScope scope, boolean remainOpen);

	void displayTestsResults(IScope scope, CompoundSummary<?, ?> summary);

	void endTestDisplay();

	List<TestExperimentSummary> runHeadlessTests(final Object model);

	/**
	 * Tries to put the frontmost display in full screen mode or in normal view mode if it is already in full screen
	 *
	 * @return true if the toggle has succeeded
	 */
	boolean toggleFullScreenMode();

	void refreshNavigator();

	boolean isInDisplayThread();

	/**
	 * Opens/displays/writes an error message. No need to call it from a specific thread
	 *
	 * @param title
	 * @param message
	 */
	void error(final String title, final String message);

	default void error(final String message) {
		error("Error", message);
	}

	/**
	 * Opens/displays/writes an information message. No need to call it from a specific thread
	 *
	 * @param title
	 * @param message
	 */
	void inform(final String title, final String message);

	default void inform(final String message) {
		inform("Information", message);
	}

	/**
	 * Opens/displays/writes a question and awaits for the answer (yes or no, true or false). No need to call it from a
	 * specific thread
	 *
	 * @param title
	 * @param message
	 */
	boolean question(final String title, final String message);

	/**
	 * Asks the user to confirm a message (true if confirmed, false otherwise). No need to call it from a specific
	 * thread
	 *
	 * @param title
	 * @param message
	 * @return
	 */
	boolean confirm(final String title, final String message);

	/**
	 * Opens the dialog allowing to choose a workspace. Returns 1 (Window.CANCEL) if the user has canceled the
	 * operation. All other values are ignored
	 *
	 * @return
	 */
	int chooseWorkspace();

}
