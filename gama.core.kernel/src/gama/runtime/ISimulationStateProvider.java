/*******************************************************************************************************
 *
 * ISimulationStateProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
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
	
	/** The simulation running state. */
	String SIMULATION_RUNNING_STATE = "gama.ui.experiment.SimulationRunningState";
	
	/** The simulation type. */
	String SIMULATION_TYPE = "gama.ui.experiment.SimulationType";
	
	/** The simulation stepback. */
	String SIMULATION_STEPBACK = "gama.ui.experiment.SimulationStepBack";

	/** The paused. */
	String PAUSED = "STOPPED";
	
	/** The finished. */
	String FINISHED = "FINISHED";
	
	/** The running. */
	String RUNNING = "RUNNING";
	
	/** The notready. */
	String NOTREADY = "NOTREADY";
	
	/** The memorize. */
	String MEMORIZE = "MEMORIZE";
	
	/** The regular. */
	String REGULAR = "REGULAR";
	
	/** The none. */
	String NONE = "NONE";
	
	/** The batch. */
	String BATCH = "BATCH";
	
	/** The can step back. */
	String CAN_STEP_BACK = "CAN_STEP_BACK";
	
	/** The cannot step back. */
	String CANNOT_STEP_BACK = "CANNOT_STEP_BACK";

	/**
	 * Change the UI state based on the state of the simulation (none, stopped, running or notready).
	 *
	 * @param state the state
	 */
	void updateStateTo(final String state);

}