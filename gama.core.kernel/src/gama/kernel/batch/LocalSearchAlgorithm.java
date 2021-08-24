/*******************************************************************************************************
 *
 * LocalSearchAlgorithm.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.List;

import gama.kernel.experiment.BatchAgent;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ParametersSet;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;

/**
 * The Class LocalSearchAlgorithm.
 */
public abstract class LocalSearchAlgorithm extends ParamSpaceExploAlgorithm {

	/** The neighborhood. */
	protected Neighborhood neighborhood;
	
	/** The solution init. */
	protected ParametersSet solutionInit;

	/**
	 * Instantiates a new local search algorithm.
	 *
	 * @param species the species
	 */
	public LocalSearchAlgorithm(final IDescription species) {
		super(species);
	}

	@Override
	public void initializeFor(final IScope scope, final BatchAgent agent) throws GamaRuntimeException {
		super.initializeFor(scope, agent);
		final List<IParameter.Batch> v = agent.getParametersToExplore();
		neighborhood = new Neighborhood1Var(v);
		solutionInit = new ParametersSet(scope, v, true);
	}

}
