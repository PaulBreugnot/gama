/*********************************************************************************************
 *
 *
 * 'MoleExperiment.java', in plugin 'msi.gama.headless', is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.core.headless.core;

import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.ParametersSet;
import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gaml.compilation.GAML;
import gaml.expressions.IExpression;

public class Experiment implements IExperiment {

	public static final double DEFAULT_SEED_VALUE = 0;

	protected IExperimentPlan currentExperiment;
	protected ParametersSet params;
	protected IModel model;
	protected String experimentName;
	protected double seed;
	protected long currentStep;

	protected Experiment() {
		currentExperiment = null;
		params = new ParametersSet();
		model = null;
		experimentName = null;
		seed = DEFAULT_SEED_VALUE;
	}

	public Experiment(final IModel mdl) {
		this();
		this.model = mdl;
	}

	@Override
	public SimulationAgent getSimulation() {
		return currentExperiment.getCurrentSimulation();
	}

	protected IScope getScope() {
		return getSimulation().getScope();
	}

	@Override
	public void setup(final String expName) {
		this.seed = 0;
		this.loadCurrentExperiment(expName);
	}

	@Override
	public void setup(final String expName, final double sd) {
		this.seed = sd;
		this.loadCurrentExperiment(expName);
	}

	private synchronized void loadCurrentExperiment(final String expName) {
		this.experimentName = expName;
		this.currentStep = 0;
		this.currentExperiment = GAMA.addHeadlessExperiment(model, experimentName, this.params, seed);
		// this.currentSimulation = this.currentExperiment.getAgent().getSimulation();
		this.currentExperiment.setHeadless(true);
	}

	@Override
	public long step() {
		currentExperiment.getController().getScheduler().paused = false;
		currentExperiment.getAgent().step(currentExperiment.getAgent().getScope());

		// if (currentExperiment.isBatch()) {
		// // Currently, the batch have the own way to control their
		// // simulations so we call the experiment to do step instead of
		// // demand simulation
		// // MUST BE RE-ORGANIZE [ THE MULTI-SIMULATION + HEADLESS SIMULATION
		// // + BATCH SIMULATION ]
		// // AD commented this
		// // currentExperiment.getAgent().getSimulation().removeAgent();
		// currentExperiment.getController().getScheduler().paused = false;
		// currentExperiment.getAgent().step(currentExperiment.getAgent().getScope());
		// } else {
		// currentExperiment.getAgent().step(this.getScope());
		// // currentExperiment.getAgent().getSimulation().step(this.getScope());
		// }
		return currentStep++;

	}

	@Override
	public void setParameter(final String parameterName, final Object value) {
		if (this.params.containsKey(parameterName)) { this.params.remove(parameterName); }
		this.params.put(parameterName, value);
	}

	@Override
	public void dispose() {
		GAMA.closeExperiment(currentExperiment);
	}

	@Override
	public boolean isInterrupted() {
		final SimulationAgent sim = currentExperiment.getCurrentSimulation();
		if (currentExperiment.isBatch() && sim == null) return false;
		return sim == null || sim.dead() || sim.getScope().interrupted();
	}

	@Override
	public IModel getModel() {
		return this.model;
	}

	@Override
	public IExpression compileExpression(final String expression) {
		return GAML.compileExpression(expression, this.getSimulation(), false);
	}

	@Override
	public Object evaluateExpression(final IExpression exp) {
		return exp.value(this.getSimulation().getScope());
	}

	@Override
	public Object evaluateExpression(final String exp) {
		final IExpression localExpression = compileExpression(exp);
		return evaluateExpression(localExpression);
	}

}
