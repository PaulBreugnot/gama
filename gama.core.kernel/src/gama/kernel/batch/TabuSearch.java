/*******************************************************************************************************
 *
 * TabuSearch.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.ArrayList;
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
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.types.IType;

// TODO: Auto-generated Javadoc
/**
 * The Class TabuSearch.
 */
@symbol (
		name = IKeyword.TABU,
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
						name = TabuSearch.ITER_MAX,
						type = IType.INT,
						optional = true,
						doc = @doc ("number of iterations")),
				@facet (
						name = HillClimbing.INIT_SOL,
						type = IType.MAP,
						optional = true,
						doc = @doc ("init solution: key: name of the variable, value: value of the variable")),
				@facet (
						name = TabuSearch.LIST_SIZE,
						type = IType.INT,
						optional = true,
						doc = @doc ("size of the tabu list")),
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
		value = "This algorithm is an implementation of the Tabu Search algorithm. See the wikipedia article and [batch161 the batch dedicated page].",
		usages = { @usage (
				value = "As other batch methods, the basic syntax of the tabu statement uses `method tabu` instead of the expected `tabu name: id` : ",
				examples = { @example (
						value = "method tabu [facet: value];",
						isExecutable = false) }),
				@usage (
						value = "For example: ",
						examples = { @example (
								value = "method tabu iter_max: 50 tabu_list_size: 5 maximize: food_gathered;",
								isExecutable = false) }) })
public class TabuSearch extends LocalSearchAlgorithm {

	/** The Constant ITER_MAX. */
	protected static final String ITER_MAX = "iter_max";

	/** The Constant LIST_SIZE. */
	protected static final String LIST_SIZE = "tabu_list_size";

	/** The tabu list size. */
	int tabuListSize = 5;

	/** The stopping criterion. */
	StoppingCriterion stoppingCriterion = new StoppingCriterionMaxIt(50);

	/**
	 * Instantiates a new tabu search.
	 *
	 * @param species the species
	 */
	public TabuSearch(final IDescription species) {
		super(species);
		initParams();

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
		initializeTestedSolutions();
		final List<ParametersSet> tabuList = new ArrayList<>();
		ParametersSet bestSolutionAlgo = this.solutionInit;
		tabuList.add(bestSolutionAlgo);
		final double currentFitness = currentExperiment.launchSimulationsWithSolution(bestSolutionAlgo);
		testedSolutions.put(bestSolutionAlgo, currentFitness);
		setBestSolution(new ParametersSet(bestSolutionAlgo));
		setBestFitness(currentFitness);

		int nbIt = 0;
		double bestFitnessAlgo = currentFitness;
		final Map<String, Object> endingCritParams = new Hashtable<>();
		endingCritParams.put("Iteration", Integer.valueOf(nbIt));
		while (!stoppingCriterion.stopSearchProcess(endingCritParams)) {
			// scope.getGui().debug("TabuSearch.findBestSolution while stoppingCriterion " + endingCritParams);
			final List<ParametersSet> neighbors = neighborhood.neighbor(scope, bestSolutionAlgo);
			neighbors.removeAll(tabuList);
			if (neighbors.isEmpty()) {
				if (tabuList.isEmpty()) {
					break;
				}
				neighbors.add(tabuList.get(scope.getRandom().between(0, tabuList.size() - 1)));
			}
			if (isMaximize()) {
				bestFitnessAlgo = -Double.MAX_VALUE;
			} else {
				bestFitnessAlgo = Double.MAX_VALUE;
			}
			ParametersSet bestNeighbor = null;

			for (final ParametersSet neighborSol : neighbors) {
				// scope.getGui().debug("TabuSearch.findBestSolution for parametersSet " + neighborSol);
				if (neighborSol == null) {
					continue;
				}
				Double neighborFitness = testedSolutions.get(neighborSol);
				if ((neighborFitness != null) && (neighborFitness != Double.MAX_VALUE)) {
					continue;
				}
				neighborFitness = currentExperiment.launchSimulationsWithSolution(neighborSol);
				nbIt++;
				testedSolutions.put(neighborSol, neighborFitness);

				// scope.getGui().debug("TabuSearch.findBestSolution neighborFitness = " + neighborFitness +
				// " bestFitnessAlgo = " + bestFitnessAlgo + " bestFitness = " + getBestFitness() +
				// " current fitness = " + currentFitness);
				final boolean neighFitnessGreaterThanBest = neighborFitness > bestFitnessAlgo;
				if (isMaximize() && neighFitnessGreaterThanBest || !isMaximize() && !neighFitnessGreaterThanBest) {
					bestNeighbor = neighborSol;
					bestFitnessAlgo = neighborFitness;
				}

				if (nbIt > iterMax) {
					break;
				}
			}
			if (bestNeighbor == null) {
				break;
			}
			bestSolutionAlgo = bestNeighbor;
			tabuList.add(bestSolutionAlgo);
			if (tabuList.size() > tabuListSize) {
				tabuList.remove(0);
			}
			// currentFitness = bestFitnessAlgo;
			endingCritParams.put("Iteration", Integer.valueOf(nbIt));
		}
		// DEBUG.LOG("Best solution : " + currentSol + " fitness : "
		// + currentFitness);

		return getBestSolution();
	}

	/** The iter max. */
	int iterMax = 50;
	//
	// @Override
	// public void initializeFor(final IScope scope, final BatchAgent agent) throws GamaRuntimeException {
	// super.initializeFor(scope, agent);
	//
	// }

	/**
	 * Inits the params.
	 *
	 * @param scope the scope
	 */
	@Override
	public void initParams(final IScope scope) {
		final IExpression maxIt = getFacet(ITER_MAX);
		if (maxIt != null) {
			iterMax = Cast.asInt(scope, maxIt.value(scope));
			stoppingCriterion = new StoppingCriterionMaxIt(iterMax);
		}
		final IExpression listsize = getFacet(LIST_SIZE);
		if (listsize != null) {
			tabuListSize = Cast.asInt(scope, listsize.value(scope));
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
		params.add(new ParameterAdapter("Tabu list size", IExperimentPlan.BATCH_CATEGORY_NAME, IType.INT) {

			@Override
			public Object value() {
				return tabuListSize;
			}

		});
		params.add(
				new ParameterAdapter("Maximum number of iterations", IExperimentPlan.BATCH_CATEGORY_NAME, IType.FLOAT) {

					@Override
					public Object value() {
						return iterMax;
					}

				});
	}

}
