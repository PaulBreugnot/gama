/*******************************************************************************************************
 *
 * HillClimbing.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.kernel.experiment.BatchAgent;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ParameterAdapter;
import gama.kernel.experiment.ParametersSet;
import gama.runtime.IScope;
import gama.runtime.concurrent.GamaExecutorService;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IType;

// TODO: Auto-generated Javadoc
/**
 * The Class HillClimbing.
 */
@symbol (
		name = IKeyword.HILL_CLIMBING,
		kind = ISymbolKind.BATCH_METHOD,
		with_sequence = false,
		concept = { IConcept.BATCH, IConcept.ALGORITHM })
@inside (
		kinds = { ISymbolKind.EXPERIMENT })
@facets (
		value = { @facet (
				name = IKeyword.NAME,
				type = IType.ID,
				optional = false,
				internal = true,
				doc = @doc ("The name of the method. For internal use only")),
				@facet (
						name = HillClimbing.ITER_MAX,
						type = IType.INT,
						optional = true,
						doc = @doc ("number of iterations")),
				@facet (
						name = HillClimbing.INIT_SOL,
						type = IType.MAP,
						optional = true,
						doc = @doc ("init solution: key: name of the variable, value: value of the variable")),
				@facet (
						name = IKeyword.MAXIMIZE,
						type = IType.FLOAT,
						optional = true,
						doc = @doc ("the value the algorithm tries to maximize")),
				@facet (
						name = IKeyword.MINIMIZE,
						type = IType.FLOAT,
						optional = true,
						doc = @doc ("the value the algorithm tries to minimize")),
				@facet (
						name = IKeyword.AGGREGATION,
						type = IType.LABEL,
						optional = true,
						values = { IKeyword.MIN, IKeyword.MAX },
						doc = @doc ("the agregation method")) },
		omissible = IKeyword.NAME)
@doc (
		value = "This algorithm is an implementation of the Hill Climbing algorithm. See the wikipedia article and [batch161 the batch dedicated page].",
		usages = { @usage (
				value = "As other batch methods, the basic syntax of the `hill_climbing` statement uses `method hill_climbing` instead of the expected `hill_climbing name: id` : ",
				examples = { @example (
						value = "method hill_climbing [facet: value];",
						isExecutable = false) }),
				@usage (
						value = "For example: ",
						examples = { @example (
								value = "method hill_climbing iter_max: 50 maximize : food_gathered; ",
								isExecutable = false) }) })
public class HillClimbing extends LocalSearchAlgorithm {

	/** The Constant ITER_MAX. */
	protected static final String ITER_MAX = "iter_max";

	/** The stopping criterion. */
	StoppingCriterion stoppingCriterion = null;

	/** The max it. */
	int maxIt;

	/**
	 * Instantiates a new hill climbing.
	 *
	 * @param species the species
	 */
	public HillClimbing(final IDescription species) {
		super(species);
		initParams();
	}

	/**
	 * Keep sol.
	 *
	 * @param neighborSol the neighbor sol
	 * @param neighborFitness the neighbor fitness
	 * @return true, if successful
	 */
	public boolean keepSol(final ParametersSet neighborSol, final Double neighborFitness ) {
		if (isMaximize() && neighborFitness.doubleValue() > getBestFitness()
				|| !isMaximize() && neighborFitness.doubleValue() < getBestFitness()) {
			setBestFitness(neighborFitness);
			return true;
		}
		return false;
	}

	/**
	 * Find best solution.
	 *
	 * @param scope the scope
	 * @return the parameters set
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public ParametersSet findBestSolution(final IScope scope) throws GamaRuntimeException {
		setBestSolution(this.solutionInit);
		double currentFitness = currentExperiment.launchSimulationsWithSolution(getBestSolution());
		initializeTestedSolutions();
		testedSolutions.put(getBestSolution(), currentFitness);
		int nbIt = 0;

		final Map<String, Object> endingCritParams = new Hashtable<>();
		endingCritParams.put("Iteration", Integer.valueOf(nbIt));
		while (stoppingCriterion == null || !stoppingCriterion.stopSearchProcess(endingCritParams)) {
			final List<ParametersSet> neighbors = neighborhood.neighbor(scope, getBestSolution());
			if (neighbors.isEmpty()) {
				break;
			}
			setBestFitness(currentFitness);
			ParametersSet bestNeighbor = null;


			if (GamaExecutorService.CONCURRENCY_SIMULATIONS_ALL.getValue() && ! currentExperiment.getParametersToExplore().isEmpty()) {
				Map<ParametersSet,Double> result = testSolutions(neighbors);
				for (ParametersSet p : result.keySet()) {
					if (keepSol(p, result.get(p))) {
						bestNeighbor = p;
					}
				}
			} else {
				for (final ParametersSet neighborSol : neighbors) {
					if (neighborSol == null) {
						continue;
					}
					Double neighborFitness = testedSolutions.get(neighborSol);
					if (neighborFitness == null) {
						neighborFitness = currentExperiment.launchSimulationsWithSolution(neighborSol);
					}
					testedSolutions.put(neighborSol, neighborFitness);

					if (keepSol(neighborSol, neighborFitness)) {
						bestNeighbor = neighborSol;
					}

				}
			}


			if (bestNeighbor == null) {
				break;
			}
			setBestSolution(bestNeighbor);
			currentFitness = getBestFitness();
			nbIt++;
			endingCritParams.put("Iteration", Integer.valueOf(nbIt));
		}
		// DEBUG.LOG("Best solution : " + currentSol + " fitness : "
		// + currentFitness);
		return getBestSolution();
	}
	//
	// @Override
	// public void initializeFor(final IScope scope, final BatchAgent agent) throws GamaRuntimeException {
	// super.initializeFor(scope, agent);
	// }

	/**
	 * Inits the params.
	 *
	 * @param scope the scope
	 */
	@Override
	protected void initParams(final IScope scope) {
		final IExpression maxItExp = getFacet(ITER_MAX);
		if (maxItExp != null) {
			maxIt = Cast.asInt(scope, maxItExp.value(scope));
			stoppingCriterion = new StoppingCriterionMaxIt(maxIt);
		}
	}

	/**
	 * Adds the parameters to.
	 *
	 * @param params the params
	 * @param agent the agent
	 */
	@Override
	public void addParametersTo(final List<IParameter.Batch> params, final BatchAgent agent) {
		super.addParametersTo(params, agent);
		params.add(
				new ParameterAdapter("Maximum number of iterations", IExperimentPlan.BATCH_CATEGORY_NAME, IType.INT) {

					@Override
					public Object value() {
						return maxIt;
					}

				});
	}

}
