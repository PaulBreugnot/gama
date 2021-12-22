/*******************************************************************************************************
 *
 * ParamSpaceExploAlgorithm.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.batch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.ISymbolKind;
import gama.kernel.experiment.BatchAgent;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.ParameterAdapter;
import gama.kernel.experiment.ParametersSet;
import gama.runtime.GAMA;
import gama.runtime.GAMA.InScope;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.AbstractGamlAdditions;
import gaml.compilation.ISymbol;
import gaml.compilation.Symbol;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.types.IType;

// TODO: Auto-generated Javadoc
/**
 * The Class ParamSpaceExploAlgorithm.
 */
@inside (
		kinds = { ISymbolKind.EXPERIMENT })
public abstract class ParamSpaceExploAlgorithm extends Symbol implements IExploration {

	/** The Constant COMBINATIONS. */
	public final static String[] COMBINATIONS = { "maximum", "minimum", "average" };

	/** The Constant CLASSES. */
	@SuppressWarnings ("rawtypes") public static final Class[] CLASSES =
		{ GeneticAlgorithm.class, SimulatedAnnealing.class, HillClimbing.class, TabuSearch.class,
				TabuSearchReactive.class, ExhaustiveSearch.class, Swarm.class, ExplicitExploration.class};

	static {
		AbstractGamlAdditions._constants(COMBINATIONS);
	}

	/** The tested solutions. */
	// private ContinuousUniformGenerator randUniform;
	protected HashMap<ParametersSet, Double> testedSolutions;

	/** The fitness expression. */
	protected IExpression fitnessExpression;

	/** The is maximize. */
	protected boolean isMaximize;

	/** The current experiment. */
	protected BatchAgent currentExperiment;

	/** The best solution. */
	// protected IScope scope;
	protected ParametersSet bestSolution = null;

	/** The best fitness. */
	protected Double bestFitness = null;

	/** The combination. */
	protected short combination;

	/**
	 * Find best solution.
	 *
	 * @param scope the scope
	 * @return the parameters set
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	protected abstract ParametersSet findBestSolution(IScope scope) throws GamaRuntimeException;

	/**
	 * Initialize for.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public void initializeFor(final IScope scope, final BatchAgent agent) throws GamaRuntimeException {
		currentExperiment = agent;
		// this.scope = scope;
	}

	// protected ContinuousUniformGenerator getRandUniform() {
	// if ( randUniform == null ) {
	// randUniform = scope.getRandom().createUniform(0., 1.);
	// }
	// return randUniform;
	// }

	/**
	 * Initialize tested solutions.
	 */
	protected void initializeTestedSolutions() {
		testedSolutions = new HashMap<>();
	}

	/**
	 * Inits the params.
	 */
	protected void initParams() {
		GAMA.run(new InScope.Void() {

			@Override
			public void process(final IScope scope) {
				initParams(scope);
			}
		});
	}

	/**
	 * Inits the params.
	 *
	 * @param scope the scope
	 */
	protected void initParams(final IScope scope) {}

	/**
	 * Instantiates a new param space explo algorithm.
	 *
	 * @param desc the desc
	 */
	public ParamSpaceExploAlgorithm(final IDescription desc) {
		super(desc);
		initializeTestedSolutions();
		fitnessExpression = getFacet(IKeyword.MAXIMIZE, IKeyword.MINIMIZE);
		isMaximize = hasFacet(IKeyword.MAXIMIZE);
		final String ag = getLiteral(IKeyword.AGGREGATION);
		combination = IKeyword.MAX.equals(ag) ? C_MAX : IKeyword.MIN.equals(ag) ? C_MIN : C_MEAN;
		bestFitness = isMaximize ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
	}

	/**
	 * Gets the combination name.
	 *
	 * @return the combination name
	 */
	@Override
	public String getCombinationName() {
		return COMBINATIONS[combination];
	}

	/**
	 * Run.
	 *
	 * @param scope the scope
	 */
	@Override
	public void run(final IScope scope) {
		try {
			findBestSolution(scope);
		} catch (final GamaRuntimeException e) {
			GAMA.reportError(scope, e, false);
		}
	}

	// @Override
	// public void start() {
	// new Thread(this, getName() + " thread").start();
	// }

	/**
	 * Sets the children.
	 *
	 * @param commands the new children
	 */
	@Override
	public void setChildren(final Iterable<? extends ISymbol> commands) {}

	/**
	 * Checks if is maximize.
	 *
	 * @return true, if is maximize
	 */
	public boolean isMaximize() {
		return isMaximize;
	}

	/**
	 * Adds the parameters to.
	 *
	 * @param params the params
	 * @param agent the agent
	 */
	@Override
	public void addParametersTo(final List<IParameter.Batch> params, final BatchAgent agent) {
		params.add(new ParameterAdapter("Exploration method", IExperimentPlan.BATCH_CATEGORY_NAME, IType.STRING) {

			@Override
			public Object value() {
				@SuppressWarnings ("rawtypes") final List<Class> classes = Arrays.asList(CLASSES);
				final String methodName = IKeyword.METHODS[classes.indexOf(ParamSpaceExploAlgorithm.this.getClass())];
				final String fit = fitnessExpression == null ? "" : "fitness = "
						+ (isMaximize ? " maximize " : " minimize ") + fitnessExpression.serialize(false);
				final String sim = fitnessExpression == null ? ""
						: (combination == C_MAX ? " max " : combination == C_MIN ? " min " : " average ") + "of "
						+ agent.getSeeds().length + " simulations";
				return "Method " + methodName + " | " + fit + " | " + "compute the" + sim + " for each solution";
			}

		});
	}


	/**
	 * Gets the best fitness.
	 *
	 * @return the best fitness
	 */
	@Override
	public Double getBestFitness() {
		return bestFitness;
	}

	/**
	 * Gets the fitness expression.
	 *
	 * @return the fitness expression
	 */
	@Override
	public IExpression getFitnessExpression() {
		return fitnessExpression;
	}

	/**
	 * Gets the best solution.
	 *
	 * @return the best solution
	 */
	@Override
	public ParametersSet getBestSolution() {
		return bestSolution;
	}

	/**
	 * Gets the combination.
	 *
	 * @return the combination
	 */
	@Override
	public short getCombination() {
		return combination;
	}

	/**
	 * Sets the best solution.
	 *
	 * @param bestSolution the new best solution
	 */
	protected void setBestSolution(final ParametersSet bestSolution) {
		// scope.getGui().debug("ParamSpaceExploAlgorithm.setBestSolution : " +
		// bestSolution);
		this.bestSolution = new ParametersSet(bestSolution);
	}

	/**
	 * Sets the best fitness.
	 *
	 * @param bestFitness the new best fitness
	 */
	protected void setBestFitness(final Double bestFitness) {
		// scope.getGui().debug("ParamSpaceExploAlgorithm.setBestFitness : " +
		// bestFitness);
		this.bestFitness = bestFitness;
	}

	/**
	 * Update best fitness.
	 *
	 * @param solution the solution
	 * @param fitness the fitness
	 */
	@Override
	public void updateBestFitness(final ParametersSet solution, final Double fitness) {
		if (fitness == null)
			return;
		Double best = getBestFitness();

		if (bestSolution == null || (isMaximize() ? fitness > best : fitness < best)) {
			setBestFitness(fitness);
			setBestSolution(solution);
		}
	}
}
