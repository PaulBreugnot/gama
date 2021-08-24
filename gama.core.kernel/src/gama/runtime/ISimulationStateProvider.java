/*******************************************************************************************************
 *
 * msi.gama.runtime.ISimulationStateProvider.java, in plugin msi.gama.core, is part of the source code of the GAMA
 * modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.runtime;

/**
 * The class ISimulationStateProvider.
 *
 * @author drogoul
 * @since 14 d�c. 2011
 *
 */
public interface ISimulationStateProvider {
	String SIMULATION_RUNNING_STATE = "gama.ui.experiment.SimulationRunningState";
	String SIMULATION_TYPE = "gama.ui.experiment.SimulationType";
	String SIMULATION_STEPBACK = "gama.ui.experiment.SimulationStepBack";

	String PAUSED = "STOPPED";
	String FINISHED = "FINISHED";
	String RUNNING = "RUNNING";
	String NOTREADY = "NOTREADY";
	String MEMORIZE = "MEMORIZE";
	String REGULAR = "REGULAR";
	String NONE = "NONE";
	String BATCH = "BATCH";
	String CAN_STEP_BACK = "CAN_STEP_BACK";
	String CANNOT_STEP_BACK = "CANNOT_STEP_BACK";

	/**
	 * Change the UI state based on the state of the simulation (none, stopped, running or notready)
	 */
	void updateStateTo(final String state);

}