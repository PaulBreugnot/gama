/*******************************************************************************************************
 *
 * msi.gama.kernel.batch.IExploration.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

	public final static short C_MAX = 0, C_MIN = 1, C_MEAN = 2;

	public abstract void initializeFor(IScope scope, final BatchAgent agent) throws GamaRuntimeException;

	public abstract String getCombinationName();

	public abstract void addParametersTo(final List<IParameter.Batch> exp, BatchAgent agent);

	public abstract Double getBestFitness();

	public abstract IExpression getFitnessExpression();

	public abstract ParametersSet getBestSolution();

	public abstract short getCombination();
	
	public abstract void updateBestFitness(ParametersSet solution, Double fitness);
		

	/**
	 * @param scope
	 */
	public abstract void run(IScope scope);

}