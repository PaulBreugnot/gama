/*******************************************************************************************************
 *
 * GAMA.java, in msi.gama.core, is part of the source code of the GAMA modeling and simulation platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package msi.gama.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import msi.gama.common.interfaces.IBenchmarkable;
import msi.gama.common.interfaces.IGui;
import msi.gama.common.preferences.GamaPreferences;
import msi.gama.common.util.PoolUtils;
import msi.gama.common.util.RandomUtils;
import msi.gama.kernel.experiment.ExperimentAgent;
import msi.gama.kernel.experiment.ExperimentPlan;
import msi.gama.kernel.experiment.IExperimentController;
import msi.gama.kernel.experiment.IExperimentPlan;
import msi.gama.kernel.experiment.IParameter;
import msi.gama.kernel.experiment.ParametersSet;
import msi.gama.kernel.model.IModel;
import msi.gama.kernel.root.PlatformAgent;
import msi.gama.kernel.simulation.SimulationAgent;
import msi.gama.runtime.benchmark.Benchmark;
import msi.gama.runtime.benchmark.StopWatch;
import msi.gama.runtime.exceptions.GamaRuntimeException;
import msi.gama.runtime.exceptions.GamaRuntimeException.GamaRuntimeFileException;
import msi.gaml.compilation.ISymbol;
import msi.gaml.compilation.kernel.GamaBundleLoader;
import msi.gaml.compilation.kernel.GamaMetaModel;
import ummisco.gama.dev.utils.DEBUG;

/**
 * Written by drogoul Modified on 23 nov. 2009
 *
 * In GUI Mode, for the moment, only one controller allowed at a time (controllers[0])
 *
 * @todo Description
 */
public class GAMA {

	static {
		DEBUG.OFF();
	}

	/** The Constant VERSION_NUMBER. */
	public final static String VERSION_NUMBER = "1.8.2";

	/** The Constant VERSION. */
	public final static String VERSION = "GAMA " + VERSION_NUMBER;

	/** The Constant _WARNINGS. */
	public static final String _WARNINGS = "warnings";

	/** The agent. */
	private static volatile PlatformAgent agent;

	/** The benchmark agent. */
	private static Benchmark benchmarkAgent;

	/** The is in headless mode. */
	private static boolean isInHeadlessMode;

	/** The regular gui. */
	private static IGui regularGui;

	/** The headless gui. */
	private static IGui headlessGui = new HeadlessListener();

	/** The Constant controllers. */
	// hqnghi: add several controllers to have multi-thread experiments
	private final static List<IExperimentController> controllers = new CopyOnWriteArrayList<>();

	/**
	 * Gets the controllers.
	 *
	 * @return the controllers
	 */
	public static List<IExperimentController> getControllers() { return controllers; }

	/**
	 * Gets the frontmost controller.
	 *
	 * @return the frontmost controller
	 */
	public static IExperimentController getFrontmostController() {
		return controllers.isEmpty() ? null : controllers.get(0);
	}

	/**
	 * New control architecture
	 */

	/**
	 * Create a GUI experiment that replaces the current one (if any)
	 *
	 * @param id
	 * @param model
	 */
	public static void runGuiExperiment(final String id, final IModel model) {
		// DEBUG.OUT("Launching experiment " + id + " of model " + model.getFilePath());
		final IExperimentPlan newExperiment = model.getExperiment(id);
		if (newExperiment == null) // DEBUG.OUT("No experiment " + id + " in model " + model.getFilePath());
			return;
		IExperimentController controller = getFrontmostController();
		if (controller != null) {
			final IExperimentPlan existingExperiment = controller.getExperiment();
			if (existingExperiment != null) {
				controller.directPause();
				if (!getGui().confirmClose(existingExperiment)) return;
			}
		}
		controller = newExperiment.getController();
		if (controllers.size() > 0) { closeAllExperiments(false, false); }

		if (getGui().openSimulationPerspective(model, id)) {
			controllers.add(controller);
			startBenchmark(newExperiment);
			controller.userOpen();
		} else {
			// we are unable to launch the perspective.
			DEBUG.ERR("Unable to launch simulation perspective for experiment " + id + " of model "
					+ model.getFilePath());
		}
	}

	// /**
	// * Add a sub-experiment to the current GUI experiment
	// *
	// * @param id
	// * @param model
	// */
	// public static void addGuiExperiment(final IExperimentPlan experiment) {
	//
	// }

	/**
	 * Open experiment from gaml file.
	 *
	 * @param experiment
	 *            the experiment
	 */
	public static void openExperimentFromGamlFile(final IExperimentPlan experiment) {
		experiment.getController().directOpenExperiment();
	}

	/**
	 * Add an experiment
	 *
	 * @param id
	 * @param model
	 */
	public static synchronized IExperimentPlan addHeadlessExperiment(final IModel model, final String expName,
			final ParametersSet params, final Double seed) {

		final ExperimentPlan currentExperiment = (ExperimentPlan) model.getExperiment(expName);

		if (currentExperiment == null) throw GamaRuntimeException
				.error("Experiment " + expName + " does not exist. Please check its name.", getRuntimeScope());
		currentExperiment.setHeadless(true);
		for (final Map.Entry<String, Object> entry : params.entrySet()) {

			final IParameter.Batch v = currentExperiment.getParameterByTitle(entry.getKey());
			if (v != null) {
				currentExperiment.setParameterValueByTitle(currentExperiment.getExperimentScope(), entry.getKey(),
						entry.getValue());
			} else {
				currentExperiment.setParameterValue(currentExperiment.getExperimentScope(), entry.getKey(),
						entry.getValue());
			}

		}
		currentExperiment.open(seed);
		controllers.add(currentExperiment.getController());
		return currentExperiment;

	}

	// public static void closeFrontmostExperiment() {
	// final IExperimentController controller = getFrontmostController();
	// if (controller == null || controller.getExperiment() == null) { return; }
	// controller.close();
	// controllers.remove(controller);
	// }

	/**
	 * Close experiment.
	 *
	 * @param experiment
	 *            the experiment
	 */
	public static void closeExperiment(final IExperimentPlan experiment) {
		if (experiment == null) return;
		closeController(experiment.getController());
	}

	/**
	 * Close all experiments.
	 *
	 * @param andOpenModelingPerspective
	 *            the and open modeling perspective
	 * @param immediately
	 *            the immediately
	 */
	public static void closeAllExperiments(final boolean andOpenModelingPerspective, final boolean immediately) {
		for (final IExperimentController controller : new ArrayList<>(controllers)) { closeController(controller); }
		getGui().closeSimulationViews(null, andOpenModelingPerspective, immediately);
		PoolUtils.WriteStats();

	}

	/**
	 * Close controller.
	 *
	 * @param controller
	 *            the controller
	 */
	private static void closeController(final IExperimentController controller) {
		if (controller == null) return;
		stopBenchmark(controller.getExperiment());
		controller.close();
		controllers.remove(controller);
	}

	/**
	 *
	 * Access to experiments and their components
	 *
	 */

	public static SimulationAgent getSimulation() {
		final IExperimentController controller = getFrontmostController();
		if (controller == null || controller.getExperiment() == null) return null;
		return controller.getExperiment().getCurrentSimulation();
	}

	/**
	 * Gets the experiment.
	 *
	 * @return the experiment
	 */
	public static IExperimentPlan getExperiment() {
		final IExperimentController controller = getFrontmostController();
		if (controller == null) return null;
		return controller.getExperiment();
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public static IModel getModel() {
		final IExperimentController controller = getFrontmostController();
		if (controller == null || controller.getExperiment() == null)
			return GamaMetaModel.INSTANCE.getAbstractModelSpecies();
		return controller.getExperiment().getModel();
	}

	/**
	 *
	 * Exception and life-cycle related utilities
	 *
	 */

	public static boolean reportError(final IScope scope, final GamaRuntimeException g,
			final boolean shouldStopSimulation) {
		final IExperimentController controller = getFrontmostController();
		if (controller == null || controller.getExperiment() == null || controller.isDisposing()
				|| controller.getExperiment().getAgent() == null)
			return false;
		DEBUG.LOG("report error : " + g.getMessage());
		// Returns whether or not to continue
		if (!(g instanceof GamaRuntimeFileException) && scope != null && !scope.reportErrors()) {
			// AD: we still throw exceptions related to files (Issue #1281)
			g.printStackTrace();
			return true;
		}
		if (scope != null && scope.getGui() != null) { scope.getGui().runtimeError(scope, g); }
		g.setReported();

		final boolean isError = !g.isWarning() || controller.getExperiment().getAgent().getWarningsAsErrors();
		final boolean shouldStop =
				isError && shouldStopSimulation && GamaPreferences.Runtime.CORE_REVEAL_AND_STOP.getValue();
		return !shouldStop;
	}

	/**
	 * Report and throw if needed.
	 *
	 * @param scope
	 *            the scope
	 * @param g
	 *            the g
	 * @param shouldStopSimulation
	 *            the should stop simulation
	 */
	public static void reportAndThrowIfNeeded(final IScope scope, final GamaRuntimeException g,
			final boolean shouldStopSimulation) {

		if (getExperiment() == null && !(g instanceof GamaRuntimeFileException) && scope != null
				&& !scope.reportErrors()) {
			// AD: we still throw exceptions related to files (Issue #1281)
			g.printStackTrace();
			return;
		}

		DEBUG.LOG("reportAndThrowIfNeeded : " + g.getMessage());
		if (scope != null && scope.getAgent() != null) {
			final String name = scope.getAgent().getName();
			if (!g.getAgentsNames().contains(name)) { g.addAgent(name); }
		}
		if (scope != null) { scope.setCurrentError(g); }
		final boolean isInTryMode = scope != null && scope.isInTryMode();
		if (isInTryMode) throw g;
		final boolean shouldStop = !reportError(scope, g, shouldStopSimulation);
		if (shouldStop) {
			if (isInHeadLessMode()) throw g;
			pauseFrontmostExperiment();
			throw g;
		}
	}

	/**
	 * Start pause frontmost experiment.
	 */
	public static void startPauseFrontmostExperiment() {
		for (final IExperimentController controller : controllers) { controller.startPause(); }
	}

	/**
	 * Step frontmost experiment.
	 */
	public static void stepFrontmostExperiment() {
		for (final IExperimentController controller : controllers) { controller.userStep(); }
	}

	/**
	 * Step back frontmost experiment.
	 */
	public static void stepBackFrontmostExperiment() {
		for (final IExperimentController controller : controllers) { controller.userStepBack(); }
	}

	/**
	 * Pause frontmost experiment.
	 */
	public static void pauseFrontmostExperiment() {
		for (final IExperimentController controller : controllers) {
			// Dont block display threads (see #
			if (getGui().isInDisplayThread()) {
				controller.userPause();
			} else {
				controller.directPause();
			}
		}
	}

	/**
	 * Resume frontmost experiment.
	 */
	public static void resumeFrontmostExperiment() {
		for (final IExperimentController controller : controllers) { controller.userStart(); }
	}

	/**
	 * Reload frontmost experiment.
	 */
	public static void reloadFrontmostExperiment() {
		final IExperimentController controller = getFrontmostController();
		if (controller != null) { controller.userReload(); }
	}

	/**
	 * Start frontmost experiment.
	 */
	public static void startFrontmostExperiment() {
		final IExperimentController controller = getFrontmostController();
		if (controller != null) { controller.userStart(); }
	}

	/**
	 * Checks if is paused.
	 *
	 * @return true, if is paused
	 */
	public static boolean isPaused() {
		final IExperimentController controller = getFrontmostController();
		if (controller == null || controller.getExperiment() == null) return true;
		return controller.isPaused();

	}

	/**
	 *
	 * Scoping utilities
	 *
	 */

	public static void releaseScope(final IScope scope) {
		if (scope != null) { scope.clear(); }
	}

	/**
	 * Copy runtime scope.
	 *
	 * @param additionalName
	 *            the additional name
	 * @return the i scope
	 */
	private static IScope copyRuntimeScope(final String additionalName) {
		final IScope scope = getRuntimeScope();
		if (scope != null) return scope.copy(additionalName);
		return null;
	}

	/**
	 * Gets the runtime scope.
	 *
	 * @return the runtime scope
	 */
	public static IScope getRuntimeScope() {
		// If GAMA has not yet been loaded, we return null
		if (!GamaBundleLoader.LOADED) return null;
		final IExperimentController controller = getFrontmostController();
		if (controller == null || controller.getExperiment() == null) return getPlatformAgent().getScope();
		final ExperimentAgent a = controller.getExperiment().getAgent();
		if (a == null || a.dead()) return controller.getExperiment().getExperimentScope();
		final SimulationAgent s = a.getSimulation();
		if (s == null || s.dead()) return a.getScope();
		return s.getScope();
	}

	/**
	 * Gets the current random.
	 *
	 * @return the current random
	 */
	public static RandomUtils getCurrentRandom() {
		final IScope scope = getRuntimeScope();
		if (scope == null) return new RandomUtils();
		return scope.getRandom();
	}

	/**
	 * The Interface InScope.
	 *
	 * @param <T>
	 *            the generic type
	 */
	public interface InScope<T> {

		/**
		 * The Class Void.
		 */
		public abstract static class Void implements InScope<Object> {

			@Override
			public Object run(final IScope scope) {
				process(scope);
				return null;
			}

			/**
			 * Process.
			 *
			 * @param scope
			 *            the scope
			 */
			public abstract void process(IScope scope);
		}

		/**
		 * Run.
		 *
		 * @param scope
		 *            the scope
		 * @return the t
		 */
		T run(IScope scope);
	}

	/**
	 * Run.
	 *
	 * @param <T>
	 *            the generic type
	 * @param r
	 *            the r
	 * @return the t
	 */
	public static <T> T run(final InScope<T> r) {
		try (IScope scope = copyRuntimeScope(" in temporary scope block")) {
			return r.run(scope);
		}
	}

	/**
	 * Allows to update all outputs after running an experiment
	 *
	 * @param r
	 */
	public static final void runAndUpdateAll(final Runnable r) {
		r.run();
		// SimulationAgent sim = getSimulation();
		// if(sim.isPaused(sim.getScope()))
		getExperiment().refreshAllOutputs();
	}

	/**
	 * Gets the gui.
	 *
	 * @return the gui
	 */
	public static IGui getGui() {
		// either a headless listener or a fully configured gui
		if (isInHeadlessMode || regularGui == null) return headlessGui;
		return regularGui;
	}

	/**
	 * Gets the headless gui.
	 *
	 * @return the headless gui
	 */
	public static IGui getHeadlessGui() { return headlessGui; }

	/**
	 * Gets the regular gui.
	 *
	 * @return the regular gui
	 */
	public static IGui getRegularGui() { return regularGui; }

	/**
	 * @param IGui
	 *            gui
	 */
	public static void setHeadlessGui(final IGui g) { headlessGui = g; }

	/**
	 * Sets the regular gui.
	 *
	 * @param g
	 *            the new regular gui
	 */
	public static void setRegularGui(final IGui g) { regularGui = g; }

	/**
	 * @return
	 */
	public static boolean isInHeadLessMode() { return isInHeadlessMode; }

	/**
	 *
	 */
	public static IGui setHeadLessMode() {
		isInHeadlessMode = true;
		final IGui gui = new HeadlessListener();
		setHeadlessGui(gui);
		return gui;
	}

	/**
	 * Relaunch frontmost experiment.
	 */
	public static void relaunchFrontmostExperiment() {
		// Needs to be done: recompile the model and runs the previous
		// experiment if any

	}

	/**
	 * Access to the one and only 'gama' agent
	 *
	 * @return the platform agent, or creates it if it doesn't exist
	 */
	public static PlatformAgent getPlatformAgent() {
		if (agent == null) { agent = new PlatformAgent(); }
		return agent;
	}

	/**
	 *
	 * Benchmarking utilities
	 *
	 */
	public static StopWatch benchmark(final IScope scope, final Object symbol) {
		if (benchmarkAgent == null || symbol == null || scope == null) return StopWatch.NULL;
		if (symbol instanceof IBenchmarkable) return benchmarkAgent.record(scope, (IBenchmarkable) symbol);
		if (symbol instanceof ISymbol) return benchmarkAgent.record(scope, ((ISymbol) symbol).getDescription());
		return StopWatch.NULL;
	}

	/**
	 * Start benchmark.
	 *
	 * @param experiment
	 *            the experiment
	 */
	public static void startBenchmark(final IExperimentPlan experiment) {
		if (experiment.shouldBeBenchmarked()) { benchmarkAgent = new Benchmark(experiment); }
	}

	/**
	 * Stop benchmark.
	 *
	 * @param experiment
	 *            the experiment
	 */
	public static void stopBenchmark(final IExperimentPlan experiment) {
		if (benchmarkAgent != null) { benchmarkAgent.saveAndDispose(experiment); }
		benchmarkAgent = null;
	}

}
