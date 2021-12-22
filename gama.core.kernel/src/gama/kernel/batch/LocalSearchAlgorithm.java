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
import java.util.Map;

import gama.kernel.experiment.BatchAgent;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ParametersSet;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalSearchAlgorithm.
 */
public abstract class LocalSearchAlgorithm extends ParamSpaceExploAlgorithm {

	/** The Constant INIT_SOL. */
	protected static final String INIT_SOL = "init_solution";

	/** The neighborhood. */
	protected Neighborhood neighborhood;

	/** The solution init. */
	protected ParametersSet solutionInit;

	/** The init sol expression. */
	protected IExpression initSolExpression;

	/**
	 * Instantiates a new local search algorithm.
	 *
	 * @param species the species
	 */
	public LocalSearchAlgorithm(final IDescription species) {
		super(species);
	}

	/**
	 * Initialize for.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public void initializeFor(final IScope scope, final BatchAgent agent) throws GamaRuntimeException {
		super.initializeFor(scope, agent);
		final List<IParameter.Batch> v = agent.getParametersToExplore();
		neighborhood = new Neighborhood1Var(v);
		solutionInit = new ParametersSet(scope, v, true);
		initSolExpression = getFacet(INIT_SOL);
		if (initSolExpression != null) {
			Map<String,Object> vals = Cast.asMap(scope, initSolExpression.value(scope), false);
			if (vals != null) {
				initSolution(scope,vals);
			}
		}
	}

	/**
	 * Inits the solution.
	 *
	 * @param scope the scope
	 * @param initVals the init vals
	 */
	public void initSolution(final IScope scope, final Map<String, Object> initVals) {
		for (String name : initVals.keySet()) {
			if (solutionInit.containsKey(name)) {
				solutionInit.put(name, initVals.get(name));
			}
		}
	}



}
