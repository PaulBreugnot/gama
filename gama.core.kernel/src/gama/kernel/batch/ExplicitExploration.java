/*
 *
 */
package gama.kernel.batch;

import java.util.ArrayList;
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
 * The Class ExplicitExploration.
 */
// TODO: Auto-generated Javadoc

/**
 * The Class ExplicitExploration.
 */
// TODO: Auto-generated Javadoc

/**
 * The Class ExplicitExploration.
 */
@symbol (
		name = IKeyword.EXPLICIT,
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
						name = ExplicitExploration.PARAMETER_SET,
						type = IType.LIST,
						of = IType.MAP,
						optional = false,
						doc = @doc ("the list of parameter sets to explore; a parameter set is defined by a map: key: name of the variable, value: expression for the value of the variable")),
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
		value = "This algorithm run simulations with the given parameter sets",
		usages = { @usage (
				value = "As other batch methods, the basic syntax of the `explicit` statement uses `method explicit` instead of the expected `explicit name: id` : ",
				examples = { @example (
						value = "method explicit [facet: value];",
						isExecutable = false) }),
				@usage (
						value = "For example: ",
						examples = { @example (
								value = "method explicit parameter_sets:[[\"a\"::0.5, \"b\"::10],[\"a\"::0.1, \"b\"::100]]; ",
								isExecutable = false) }) })
public class ExplicitExploration extends ParamSpaceExploAlgorithm {

	/** The Constant PARAMETER_SET. */
	protected static final String PARAMETER_SET = "parameter_sets";

	/** The parameter sets. */
	protected List<Map<String, Object>> parameterSets;

	/**
	 * Instantiates a new explicit exploration.
	 *
	 * @param desc
	 *            the desc
	 */
	public ExplicitExploration(final IDescription desc) {
		super(desc);

	}

	/**
	 * Find best solution.
	 *
	 * @param scope
	 *            the scope
	 * @return the parameters set
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public ParametersSet findBestSolution(final IScope scope) throws GamaRuntimeException {
		IExpression psexp = getFacet(PARAMETER_SET);
		parameterSets = Cast.asList(scope, psexp.value(scope));
		setBestFitness(null);
		List<ParametersSet> solutions = new ArrayList<>();
		for (Map<String, Object> parameterSet : parameterSets) {
			ParametersSet p = new ParametersSet();
			for (String v : parameterSet.keySet()) {
				Object val = parameterSet.get(v);
				p.put(v, val instanceof IExpression ? ((IExpression) val).value(scope) : val);
			}
			solutions.add(p);
		}
		if (GamaExecutorService.CONCURRENCY_SIMULATIONS_ALL.getValue()) {
			solutions.removeIf(a -> testedSolutions.containsKey(a));
			Map<ParametersSet, Double> res = currentExperiment.launchSimulationsWithSolution(solutions);
			for (ParametersSet sol : res.keySet()) {
				updateBestFitness(sol, res.get(sol));
			}
		} else {
			for (ParametersSet sol : solutions) {
				if (!testedSolutions.containsKey(sol)) {
					double fitness = currentExperiment.launchSimulationsWithSolution(sol);
					updateBestFitness(sol, fitness);
				}
			}
		}
		return getBestSolution();
	}

}