/*******************************************************************************************************
 *
 * GamlIdiomsProvider.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gaml.compilation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import gama.common.interfaces.IGamlDescription;
import gama.common.interfaces.IKeyword;
import gaml.compilation.kernel.GamaSkillRegistry;
import gaml.descriptions.ActionDescription;
import gaml.descriptions.FacetProto;
import gaml.descriptions.OperatorProto;
import gaml.descriptions.SkillDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.SymbolProto;
import gaml.descriptions.VariableDescription;
import gaml.expressions.IExpressionCompiler;
import gaml.expressions.units.UnitConstantExpression;
import gaml.factories.DescriptionFactory;
import gaml.operators.IUnits;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class GamlIdiomsProvider.
 *
 * @param <T> the generic type
 */
public class GamlIdiomsProvider<T extends IGamlDescription> {

	/** The Constant SPECIES. */
	public final static GamlIdiomsProvider<SpeciesDescription> SPECIES =
			new GamlIdiomsProvider<SpeciesDescription>("species", IKeyword.SPECIES, "Built-in species",
					Types.getBuiltInSpecies()).with((each) -> each.getDocumentationWithoutMeta());
	
	/** The Constant SPECIES_ATTRIBUTES. */
	public final static GamlIdiomsProvider<VariableDescription> SPECIES_ATTRIBUTES = new GamlIdiomsProvider<>(
			"variables", "species_attribute", "Built-in species attribute",
			Iterables.concat(Iterables.transform(Types.getBuiltInSpecies(), (each) -> each.getOwnAttributes())));
	
	/** The Constant SPECIES_ACTIONS. */
	public final static GamlIdiomsProvider<ActionDescription> SPECIES_ACTIONS =
			new GamlIdiomsProvider<>("actions", "species_action", "Built-in species action",
					Iterables.concat(Iterables.transform(Types.getBuiltInSpecies(), (each) -> each.getOwnActions())));
	
	/** The Constant SKILLS. */
	public final static GamlIdiomsProvider<SkillDescription> SKILLS = new GamlIdiomsProvider<>("skills", IKeyword.SKILL,
			"Skill", GamaSkillRegistry.INSTANCE.getRegisteredSkills());
	
	/** The Constant SKILLS_ATTRIBUTES. */
	public final static GamlIdiomsProvider<VariableDescription> SKILLS_ATTRIBUTES =
			new GamlIdiomsProvider<>("variables", "skill_attribute", "Skill Attribute",
					GamaSkillRegistry.INSTANCE.getRegisteredSkillsAttributes());
	
	/** The Constant SKILLS_ACTIONS. */
	public final static GamlIdiomsProvider<ActionDescription> SKILLS_ACTIONS = new GamlIdiomsProvider<>("actions",
			"skill_action", "Skill Action", GamaSkillRegistry.INSTANCE.getRegisteredSkillsActions());
	
	/** The Constant STATEMENTS. */
	public final static GamlIdiomsProvider<SymbolProto> STATEMENTS =
			new GamlIdiomsProvider<>("statements", "statement", "Statements", DescriptionFactory.getStatementProtos());
	
	/** The Constant CONSTANTS. */
	public final static GamlIdiomsProvider<UnitConstantExpression> CONSTANTS =
			new GamlIdiomsProvider<>("constant", IKeyword.CONST, "Constant & Units", IUnits.UNITS_EXPR.values());
	
	/** The Constant OPERATORS. */
	public final static GamlIdiomsProvider<OperatorProto> OPERATORS = new GamlIdiomsProvider<>("operators", "operator",
			"Operators",
			Iterables.concat(Iterables.transform(IExpressionCompiler.OPERATORS.values(), (each) -> each.values())));
	
	/** The Constant TYPES. */
	public final static GamlIdiomsProvider<IType<?>> TYPES =
			new GamlIdiomsProvider<>("types", "type", "Types", Types.builtInTypes.getAllTypes());
	
	/** The Constant FACETS. */
	public final static GamlIdiomsProvider<FacetProto> FACETS =
			new GamlIdiomsProvider<>("facets", "facet", "Facets", DescriptionFactory.getFacetsProtos());
	
	/** The Constant FIELDS. */
	public final static GamlIdiomsProvider<OperatorProto> FIELDS =
			new GamlIdiomsProvider<>("attributes", "field", "Fields", Types.getAllFields());

	/** The Constant PROVIDERS. */
	public final static List<GamlIdiomsProvider<?>> PROVIDERS =
			Arrays.asList(SPECIES, SPECIES_ATTRIBUTES, SPECIES_ACTIONS, SKILLS, SKILLS_ATTRIBUTES, SKILLS_ACTIONS,
					STATEMENTS, CONSTANTS, OPERATORS, TYPES, FACETS, FIELDS);

	/** The search. */
	public final String id, name, search;
	
	/** The elements. */
	public final Iterable<? extends T> elements;
	
	/** The titles. */
	public final Map<T, String> titles;
	
	/** The sorted elements. */
	public IGamlDescription[] sortedElements;
	
	/** The by name. */
	public Multimap<String, ? extends T> byName;
	
	/** The documenter. */
	// default
	public Function<T, String> documenter = (each) -> each.getDocumentation();

	/**
	 * Instantiates a new gaml idioms provider.
	 *
	 * @param search the search
	 * @param id the id
	 * @param name the name
	 * @param elmts the elmts
	 */
	public GamlIdiomsProvider(final String search, final String id, final String name,
			final Iterable<? extends T> elmts) {
		this(search, id, name, elmts, null);
	}

	/**
	 * Instantiates a new gaml idioms provider.
	 *
	 * @param search the search
	 * @param id the id
	 * @param name the name
	 * @param elmts the elmts
	 * @param titles the titles
	 */
	public GamlIdiomsProvider(final String search, final String id, final String name,
			final Iterable<? extends T> elmts, final Map<T, String> titles) {
		this.search = search;
		this.id = id;
		this.name = name;
		this.elements = elmts;
		this.titles = titles;
	}

	/**
	 * Document.
	 *
	 * @param element the element
	 * @return the string
	 */
	@SuppressWarnings ("unchecked")
	public String document(final IGamlDescription element) {
		return documenter.apply((T) element);
	}

	/**
	 * With.
	 *
	 * @param doc the doc
	 * @return the gaml idioms provider
	 */
	public GamlIdiomsProvider<T> with(final Function<T, String> doc) {
		documenter = doc;
		return this;
	}

	/**
	 * Gets the search category.
	 *
	 * @return the search category
	 */
	public String getSearchCategory() {
		return search;
	}

	/**
	 * Gets the.
	 *
	 * @param name the name
	 * @return the collection<? extends t>
	 */
	public Collection<? extends T> get(final String name) {
		if (byName == null) {
			init();
		}
		return byName.get(name);
	}

	/**
	 * Gets the sorted elements.
	 *
	 * @return the sorted elements
	 */
	public IGamlDescription[] getSortedElements() {
		if (sortedElements == null) {
			init();
		}
		return sortedElements;
	}

	/**
	 * Inits the.
	 */
	private void init() {

		sortedElements = Iterables.toArray(elements, IGamlDescription.class);
		if (titles == null) {
			Arrays.sort(sortedElements, (e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
		} else {
			Arrays.sort(sortedElements, (e1, e2) -> titles.get(e1).compareTo(titles.get(e2)));
		}
		byName = Multimaps.index(elements, (each) -> each.getName());

	}

	/**
	 * For name.
	 *
	 * @param name the name
	 * @return the multimap
	 */
	public static Multimap<GamlIdiomsProvider<?>, IGamlDescription> forName(final String name) {
		final Multimap<GamlIdiomsProvider<?>, IGamlDescription> result = ArrayListMultimap.create();
		for (final GamlIdiomsProvider<?> p : PROVIDERS) {
			result.replaceValues(p, p.get(name));
		}
		return result;
	}

}
