/*******************************************************************************************************
 *
 * IExperiment.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.core;

import gama.kernel.model.IModel;
import gama.kernel.simulation.SimulationAgent;
import gaml.expressions.IExpression;

/**
 * The Interface IExperiment.
 */
public interface IExperiment {
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	IModel getModel();

	/**
	 * Gets the simulation.
	 *
	 * @return the simulation
	 */
	SimulationAgent getSimulation();

	/**
	 * Sets the up.
	 *
	 * @param experimentName the new up
	 */
	void setup(final String experimentName);

	/**
	 * Setup.
	 *
	 * @param experimentName the experiment name
	 * @param seed the seed
	 */
	void setup(final String experimentName, final double seed);

	/**
	 * Step.
	 *
	 * @return the long
	 */
	long step();

	/**
	 * Checks if is interrupted.
	 *
	 * @return true, if is interrupted
	 */
	boolean isInterrupted();

	/**
	 * Sets the parameter.
	 *
	 * @param parameterName the parameter name
	 * @param value the value
	 */
	void setParameter(final String parameterName, final Object value);

	/**
	 * Compile expression.
	 *
	 * @param expression the expression
	 * @return the i expression
	 */
	IExpression compileExpression(final String expression);

	/**
	 * Evaluate expression.
	 *
	 * @param exp the exp
	 * @return the object
	 */
	Object evaluateExpression(IExpression exp);

	/**
	 * Evaluate expression.
	 *
	 * @param exp the exp
	 * @return the object
	 */
	Object evaluateExpression(String exp);

	/**
	 * Dispose.
	 */
	void dispose();

}
