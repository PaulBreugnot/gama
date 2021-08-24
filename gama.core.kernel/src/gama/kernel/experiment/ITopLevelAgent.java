/*******************************************************************************************************
 *
 * ITopLevelAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.experiment;

import gama.common.interfaces.IScopedStepable;
import gama.common.util.RandomUtils;
import gama.kernel.simulation.SimulationAgent;
import gama.kernel.simulation.SimulationClock;
import gama.metamodel.agent.IMacroAgent;
import gama.outputs.IOutputManager;
import gama.util.GamaColor;
import gaml.statements.IExecutable;

/**
 * Class ITopLevelAgent Addition (Aug 2021): explicit inheritance of IScopedStepable.
 *
 * @author drogoul
 * @since 27 janv. 2016
 */
public interface ITopLevelAgent extends IMacroAgent, IScopedStepable {

	/**
	 * Gets the clock.
	 *
	 * @return the clock
	 */
	SimulationClock getClock();

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	GamaColor getColor();

	/**
	 * Gets the random generator.
	 *
	 * @return the random generator
	 */
	RandomUtils getRandomGenerator();

	/**
	 * Gets the output manager.
	 *
	 * @return the output manager
	 */
	IOutputManager getOutputManager();

	/**
	 * Post end action.
	 *
	 * @param executable the executable
	 */
	void postEndAction(IExecutable executable);

	/**
	 * Post dispose action.
	 *
	 * @param executable the executable
	 */
	void postDisposeAction(IExecutable executable);

	/**
	 * Post one shot action.
	 *
	 * @param executable the executable
	 */
	void postOneShotAction(IExecutable executable);

	/**
	 * Execute action.
	 *
	 * @param executable the executable
	 */
	void executeAction(IExecutable executable);

	/**
	 * Checks if is on user hold.
	 *
	 * @return true, if is on user hold
	 */
	boolean isOnUserHold();

	/**
	 * Sets the on user hold.
	 *
	 * @param state the new on user hold
	 */
	void setOnUserHold(boolean state);

	/**
	 * Gets the simulation.
	 *
	 * @return the simulation
	 */
	SimulationAgent getSimulation();

	/**
	 * Gets the experiment.
	 *
	 * @return the experiment
	 */
	IExperimentAgent getExperiment();

}
