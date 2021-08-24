/*******************************************************************************************************
 *
 * GenerateStatement.java, in gama.ext.genstar, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.genstar.statement;

import static gama.common.interfaces.IKeyword.FROM;
import static gama.common.interfaces.IKeyword.GENERATE;
import static gama.common.interfaces.IKeyword.NUMBER;
import static gama.common.interfaces.IKeyword.RETURNS;
import static gama.common.interfaces.IKeyword.SPECIES;
import static gama.core.dev.annotations.ISymbolKind.SEQUENCE_STATEMENT;
import static gama.runtime.exceptions.GamaRuntimeException.error;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.IOperatorCategory;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.ext.genstar.generator.IGenstarGenerator;
import gama.ext.genstar.statement.GenerateStatement.GenerateValidator;
import gama.ext.genstar.utils.GenStarConstant;
import gama.ext.genstar.utils.GenStarGamaUtils;
import gama.kernel.experiment.ExperimentAgent;
import gama.kernel.simulation.SimulationPopulation;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaListFactory;
import gama.util.IList;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.ISymbol;
import gaml.compilation.annotations.validator;
import gaml.descriptions.ExperimentDescription;
import gaml.descriptions.IDescription;
import gaml.descriptions.ModelDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.StatementDescription;
import gaml.expressions.IExpression;
import gaml.expressions.types.SpeciesConstantExpression;
import gaml.operators.Cast;
import gaml.species.ISpecies;
import gaml.statements.AbstractStatementSequence;
import gaml.statements.Arguments;
import gaml.statements.Facets;
import gaml.statements.IStatement;
import gaml.statements.RemoteSequence;
import gaml.statements.Facets.Facet;
import gaml.types.IType;
import gaml.types.Types;
import one.util.streamex.StreamEx;

/**
 * The Class GenerateStatement.
 */
@symbol (
		name = GENERATE,
		kind = SEQUENCE_STATEMENT,
		with_sequence = true,
		with_args = true,
		category = { IOperatorCategory.GENSTAR },
		concept = { IConcept.SPECIES },
		remote_context = true)
@inside (
		kinds = { ISymbolKind.BEHAVIOR, SEQUENCE_STATEMENT })
@facets (
		value = { 
				@facet (
						name = SPECIES,
						type = { IType.SPECIES, IType.AGENT },
						optional = true,
						doc = @doc ("The species of the agents to be created.")
						),
				@facet (
						name = FROM,
						type = IType.NONE,
						optional = false,
						doc = @doc ("To specify the input data used to inform the generation process. Various data input can be used: <\b> "
								+ "<ul>"
								+ "  <li>list of csv_file: can be aggregated or micro data</li>\n"
								+ "  <li>matrix: describe the joint distribution of two attributes</li>\n"
								+ "  <li>bayesian network: describe a conditional distribution of three or more attributes</li>"
								+ "</ul>")
						),
				@facet (
						/*
						 * TODO :  make those attributes like in csv map 
						 * to directly recognize species' attributes rather than use string
						 * with potential mispells
						 */
						name = GenStarConstant.GSATTRIBUTES,
						type = { IType.MAP },
						optional = false,
						doc = @doc ("To specify the explicit link between agent attributes and file based attributes")
						),
				@facet (
						name = NUMBER,
						type = IType.INT,
						optional = true,
						doc = @doc ("To specify the number of created agents interpreted as an int value. "
								+ "If facet is ommited or value is 0 or less, generator will treat data used in the 'from' facet as contingencies "
								+ "(i.e. a count of entities) and infer a number to generate (if distribution is used, then only one entity will be created")
						),
				@facet (
						name = GenStarConstant.GSGENERATOR,
						type = { IType.STRING },
						optional = true,
						doc = @doc ("To specify the type of generator you want to use: as of now there is only DS (or DirectSampling) available")
						)
				},
		omissible = SPECIES
		) 

@doc (
		value = "Allows to create a synthetic population of agent from a set of given rules",
		usages = { 
				@usage (
						value = "The synthax to create a minimal synthetic population from aggregated file is:",
						examples = { 
						@example (
								value = "synthesis my_species from: [source_file]; "
										+ "attributes: [age::[\"below 18\",\"19 to 45\",\"more than 46\"]",
								isExecutable = false),
						
						@example (
								value = "synthesis my_species from: my_matrix "
										+ "number: 5 returns: list5Agents;",
								isTestOnly = false)
						}) 
				}
		)
@validator (GenerateValidator.class)
public class GenerateStatement extends AbstractStatementSequence implements IStatement.WithArgs {
	
	/** The init. */
	private Arguments init;
	
	/** The algorithm. */
	private final IExpression from, number, species, attributes, algorithm;
	
	/** The returns. */
	private final String returns;
	
	/** The sequence. */
	private final RemoteSequence sequence;
	
	/**
	 * Instantiates a new generate statement.
	 *
	 * @param desc the desc
	 */
	public GenerateStatement(IDescription desc) { 
		super(desc);
		returns = getLiteral(RETURNS);
		from = getFacet(FROM);
		number = getFacet(NUMBER);
		species = getFacet(SPECIES);
		
		attributes = getFacet(GenStarConstant.GSATTRIBUTES);
		algorithm = getFacet(GenStarConstant.GSGENERATOR);
		
		sequence = new RemoteSequence(description);
		sequence.setName("commands of generate ");
		setName(GENERATE);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public IList<? extends IAgent> privateExecuteIn(final IScope scope) throws GamaRuntimeException {

		// First, we compute the number of agents to create
		final Integer max = number == null ? null : Cast.asInt(scope, number.value(scope));
		if (from == null && max != null && max <= 0) return GamaListFactory.EMPTY_LIST;

		// Next, we compute the species to instantiate
		final IPopulation pop = findPopulation(scope);
		// A check is made in order to address issues #2621 and #2611
		if (pop == null || pop.getSpecies() == null)
			throw GamaRuntimeException.error("Impossible to determine the species of the agents to generate", scope);
		checkPopulationValidity(pop, scope);

		// We grab whatever initial data are input
		final List<Map<String, Object>> inits = GamaListFactory.create(Types.MAP, max == null ? 10 : max);
		final Object source = from.value(scope);
		
		// Only one generator according to data input type (type of the source Object)
		StreamEx.of(GenStarGamaUtils.getGamaGenerator())
				.findFirst(g ->  g.sourceMatch(scope, source))
				.orElseThrow(IllegalArgumentException::new)
				.generate(scope,inits,max,source,
						attributes.value(scope),
						algorithm==null?null:algorithm.value(scope),
						init,this);
		
		// and we create and return the agent(s)
		final IList<? extends IAgent> agents = pop.createAgents(scope, inits.size(), inits, false, false, sequence);
		if (returns != null) { scope.setVarValue(returns, agents); }
		return agents;
	}
	
	/**
	 * TODO Description PLZZZZZ
	 * TODO Call it before calling the ICreateDelegate createFrom method !.
	 *
	 * @param scope the scope
	 * @param values the values
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void fillWithUserInit(final IScope scope, final Map values) {
		if (init == null) return;
		scope.pushReadAttributes(values);
		try {
			init.forEachFacet((k, v) -> {
				values.put(k, v.getExpression().value(scope));
				return true;
			});
		} finally {
			scope.popReadAttributes();
		}
	}
	
	// ------------------------------------------------------------------------------------------------ //
	// ------------------------------------------------------------------------------------------------ //
	//																									//
	// 					Copy pasted from the CreateStatement way to init agents							//
	//																									//
	// ------------------------------------------------------------------------------------------------ //
	// ------------------------------------------------------------------------------------------------ //
	
	/**
	 * Find population.
	 *
	 * @param scope the scope
	 * @return the i population
	 */
	@SuppressWarnings("rawtypes")
	private IPopulation findPopulation(final IScope scope) {
		final IAgent executor = scope.getAgent();
		if (species == null) return executor.getPopulationFor(description.getSpeciesContext().getName());
		ISpecies s = Cast.asSpecies(scope, species.value(scope));
		if (s == null) {// A last attempt in order to fix #2466
			final String potentialSpeciesName = species.getDenotedType().getSpeciesName();
			if (potentialSpeciesName != null) { s = scope.getModel().getSpecies(potentialSpeciesName); }
		}
		if (s == null) throw GamaRuntimeException.error(
				"No population of " + species.serialize(false) + " is accessible in the context of " + executor + ".",
				scope);
		return executor.getPopulationFor(s);
	}
	
	/**
	 * A check made in order to address issues #2621 and #2611.
	 *
	 * @param pop the pop
	 * @param scope the scope
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@SuppressWarnings("rawtypes")
	private void checkPopulationValidity(final IPopulation pop, final IScope scope) throws GamaRuntimeException {
		if (pop instanceof SimulationPopulation && !(scope.getAgent() instanceof ExperimentAgent))
			throw error("Simulations can only be created within experiments", scope);
		final SpeciesDescription sd = pop.getSpecies().getDescription();
		final String error = sd.isAbstract() ? "abstract"
				: sd.isMirror() ? "a mirror" : sd.isBuiltIn() ? "built-in" : sd.isGrid() ? "a grid" : null;
		if (error != null) throw error(sd.getName() + "is " + error + " and cannot be instantiated.", scope);
	}
	
	/**
	 * TODO : make the validator coherent with 'must contains' facets .
	 *
	 * @author kevinchapuis
	 */
	public static class GenerateValidator implements IDescriptionValidator<StatementDescription> {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public void validate(StatementDescription description) {
			final IExpression species = description.getFacetExpr(SPECIES);
			// If the species cannot be determined, issue an error and leave validation
			if (species == null) {
				description.error("The species is not found", UNKNOWN_SPECIES, SPECIES);
				return;
			}

			final SpeciesDescription sd = species.getGamlType().getDenotedSpecies();
			if (sd == null) {
				System.out.println(species.getGamlType()+" "+species.getName());
				description.error("The species to instantiate cannot be determined", UNKNOWN_SPECIES, SPECIES, species.getName());
				return;
			}

			if (species instanceof SpeciesConstantExpression) {
				final boolean abs = sd.isAbstract();
				final boolean mir = sd.isMirror();
				final boolean gri = sd.isGrid();
				final boolean bui = sd.isBuiltIn();
				if (abs || mir || gri || bui) {
					final String p = abs ? "abstract" : mir ? "a mirror" : gri ? "a grid" : bui ? "built-in" : "";
					description.error(sd.getName() + " is " + p + " and cannot be instantiated", WRONG_TYPE, SPECIES);
					return;
				}
			} else {
				if (!(sd instanceof ModelDescription)) {
					description.info("The actual species will be determined at runtime. This can lead to errors if it cannot be instantiated",
							WRONG_TYPE, SPECIES);
				}
			}

			if (sd instanceof ModelDescription && !(description.getSpeciesContext() instanceof ExperimentDescription)) {
				description.error("Simulations can only be created within experiments", WRONG_CONTEXT, SPECIES);
				return;
			}

			final SpeciesDescription callerSpecies = description.getSpeciesContext();
			final SpeciesDescription macro = sd.getMacroSpecies();
			if (macro == null) {
				description.error("The macro-species of " + species + " cannot be determined");
				return;
				// hqnghi special case : create instances of model from
				// model
			} else if (macro instanceof ModelDescription && callerSpecies instanceof ModelDescription) {

				// end-hqnghi
			} else if (callerSpecies != macro && !callerSpecies.hasMacroSpecies(macro)
					&& !callerSpecies.hasParent(macro)) {
				description.error("No instance of " + macro.getName() + " available for creating instances of " + sd.getName());
				return;
			}
			

			final IExpression exp = description.getFacetExpr(FROM);
			if (exp != null) {
				final IType type = exp.getGamlType();
				boolean found = false;
				List<IType> types = StreamEx.of(GenStarGamaUtils.getGamaGenerator())
						.map(IGenstarGenerator::sourceType).collect(Collectors.toList());
				for (final IType genType : types) {
					found = genType.isAssignableFrom(type);
					if (found) { break; }
				}
				if (type==Types.MATRIX) {
					// TODO verify that x,y matrix match possible attributes values
				}
				if (!found) {
					description.warning("Facet 'from' expects an expression with one of the following types: " + types,
							WRONG_TYPE, FROM);
				}
			}
			
			final Facets facets = description.getPassedArgs();
			for (final Facet att : facets.getFacets()) {
				if (!sd.isExperiment() && !sd.hasAttribute(att.key)) {
					description.error("Attribute " + att + " is not defined in species " + species.getName(), UNKNOWN_VAR);
					return;
				}
			}

		}
		
	}

	@Override
	public void setFormalArgs(Arguments args) { init = args; }

	@Override
	public void setRuntimeArgs(IScope scope, Arguments args) {}
	

	@Override
	public void setChildren(final Iterable<? extends ISymbol> com) { sequence.setChildren(com); }

	@Override
	public void enterScope(final IScope scope) {
		if (returns != null) { scope.addVarWithValue(returns, null); }
		super.enterScope(scope);
	}

}
