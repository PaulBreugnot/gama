/*******************************************************************************************************
 *
 * IExperimentController.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.experiment;

/**
 * Class IExperimentController.
 *
 * @author drogoul
 * @since 6 déc. 2015
 *
 */
public interface IExperimentController {

	/** The  open. */
	int _OPEN = 0;
	
	/** The  start. */
	int _START = 1;
	
	/** The  step. */
	int _STEP = 2;
	
	/** The  pause. */
	int _PAUSE = 3;
	
	/** The  reload. */
	int _RELOAD = 6;
	
	/** The  back. */
	int _BACK = 8;

	/**
	 * Gets the experiment.
	 *
	 * @return the experiment
	 */
	IExperimentPlan getExperiment();

	/**
	 * Gets the scheduler.
	 *
	 * @return the scheduler
	 */
	ExperimentScheduler getScheduler();

	/**
	 * User step.
	 */
	void userStep();

	/**
	 * Step back.
	 */
	void stepBack();

	/**
	 * Start pause.
	 */
	void startPause();

	/**
	 * Close.
	 */
	void close();

	/**
	 * User start.
	 */
	void userStart();

	/**
	 * Direct pause.
	 */
	void directPause();

	/**
	 * Dispose.
	 */
	void dispose();

	/**
	 * Direct open experiment.
	 */
	void directOpenExperiment();

	/**
	 * User reload.
	 */
	void userReload();

	/**
	 * User pause.
	 */
	void userPause();

	/**
	 * User open.
	 */
	void userOpen();

	/**
	 * Checks if is disposing.
	 *
	 * @return true, if is disposing
	 */
	boolean isDisposing();

}