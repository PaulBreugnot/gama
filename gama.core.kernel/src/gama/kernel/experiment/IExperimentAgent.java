/*******************************************************************************************************
 *
 * IExperimentAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.experiment;

import java.util.List;

import gama.kernel.simulation.SimulationAgent;
import gama.kernel.simulation.SimulationPopulation;

/**
 * The Interface IExperimentAgent.
 */
public interface IExperimentAgent extends ITopLevelAgent {

	@Override
	public abstract IExperimentPlan getSpecies();

	/**
	 * Gets the working path.
	 *
	 * @return the working path
	 */
	public String getWorkingPath();

	/**
	 * Gets the working paths.
	 *
	 * @return the working paths
	 */
	public List<String> getWorkingPaths();

	/**
	 * Gets the warnings as errors.
	 *
	 * @return the warnings as errors
	 */
	public abstract Boolean getWarningsAsErrors();

	/**
	 * Gets the minimum duration.
	 *
	 * @return the minimum duration
	 */
	public abstract Double getMinimumDuration();

	/**
	 * Sets the minimum duration.
	 *
	 * @param d the new minimum duration
	 */
	public abstract void setMinimumDuration(Double d);

	/**
	 * Close simulations.
	 */
	void closeSimulations();

	/**
	 * Close simulation.
	 *
	 * @param simulationAgent the simulation agent
	 */
	public abstract void closeSimulation(SimulationAgent simulationAgent);

	/**
	 * Gets the simulation population.
	 *
	 * @return the simulation population
	 */
	public abstract SimulationPopulation getSimulationPopulation();

	/**
	 * Checks if is memorize.
	 *
	 * @return true, if is memorize
	 */
	public boolean isMemorize();

	/**
	 * Can step back.
	 *
	 * @return true, if successful
	 */
	public boolean canStepBack();

	/**
	 * Inform status.
	 */
	public abstract void informStatus();

	/**
	 * Checks if is headless.
	 *
	 * @return true, if is headless
	 */
	public abstract boolean isHeadless();

}
