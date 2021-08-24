/*******************************************************************************************************
 *
 * IExploration.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.*;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.ISymbol;
import gaml.expressions.IExpression;

/**
 * The class IExploration.
 *
 * @author drogoul
 * @since 26 d�c. 2011
 *
 */
public interface IExploration extends ISymbol {// , Runnable {

	/** The Constant C_MEAN. */
public final static short C_MAX = 0, C_MIN = 1, C_MEAN = 2;

	/**
	 * Initialize for.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public abstract void initializeFor(IScope scope, final BatchAgent agent) throws GamaRuntimeException;

	/**
	 * Gets the combination name.
	 *
	 * @return the combination name
	 */
	public abstract String getCombinationName();

	/**
	 * Adds the parameters to.
	 *
	 * @param exp the exp
	 * @param agent the agent
	 */
	public abstract void addParametersTo(final List<IParameter.Batch> exp, BatchAgent agent);

	/**
	 * Gets the best fitness.
	 *
	 * @return the best fitness
	 */
	public abstract Double getBestFitness();

	/**
	 * Gets the fitness expression.
	 *
	 * @return the fitness expression
	 */
	public abstract IExpression getFitnessExpression();

	/**
	 * Gets the best solution.
	 *
	 * @return the best solution
	 */
	public abstract ParametersSet getBestSolution();

	/**
	 * Gets the combination.
	 *
	 * @return the combination
	 */
	public abstract short getCombination();
	
	/**
	 * Update best fitness.
	 *
	 * @param solution the solution
	 * @param fitness the fitness
	 */
	public abstract void updateBestFitness(ParametersSet solution, Double fitness);
		

	/**
	 * Run.
	 *
	 * @param scope the scope
	 */
	public abstract void run(IScope scope);

}