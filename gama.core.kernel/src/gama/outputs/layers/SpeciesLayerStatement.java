/*******************************************************************************************************
 *
 * SpeciesLayerStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs.layers;

import java.util.ArrayList;
import java.util.List;

import gama.common.interfaces.IGamlIssue;
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
import gama.outputs.LayeredDisplayOutput;
import gama.outputs.layers.SpeciesLayerStatement.SpeciesLayerSerializer;
import gama.outputs.layers.SpeciesLayerStatement.SpeciesLayerValidator;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.ISymbol;
import gaml.compilation.annotations.serializer;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.StatementDescription;
import gaml.descriptions.SymbolDescription;
import gaml.descriptions.SymbolSerializer;
import gaml.factories.DescriptionFactory;
import gaml.operators.Cast;
import gaml.species.ISpecies;
import gaml.statements.AspectStatement;
import gaml.statements.IExecutable;
import gaml.statements.IStatement;
import gaml.types.IType;

// TODO: Auto-generated Javadoc
/**
 * Written by drogoul Modified on 9 nov. 2009
 *
 * @todo Description
 *
 */
@symbol (
		name = IKeyword.POPULATION,
		kind = ISymbolKind.LAYER,
		with_sequence = true,
		remote_context = true,
		concept = { IConcept.DISPLAY, IConcept.SPECIES })
@inside (
		symbols = { IKeyword.DISPLAY, IKeyword.POPULATION })
@facets (
		value = { @facet (
				name = IKeyword.POSITION,
				type = IType.POINT,
				optional = true,
				doc = @doc ("position of the upper-left corner of the layer. Note that if coordinates are in [0,1[, the position is relative to the size of the environment (e.g. {0.5,0.5} refers to the middle of the display) whereas it is absolute when coordinates are greater than 1 for x and y. The z-ordinate can only be defined between 0 and 1. The position can only be a 3D point {0.5, 0.5, 0.5}, the last coordinate specifying the elevation of the layer.")),
				@facet (
						name = IKeyword.SELECTABLE,
						type = { IType.BOOL },
						optional = true,
						doc = @doc ("Indicates whether the agents present on this layer are selectable by the user. Default is true")),
				@facet (
						name = IKeyword.SIZE,
						type = IType.POINT,
						optional = true,
						doc = @doc ("extent of the layer in the screen from its position. Coordinates in [0,1[ are treated as percentages of the total surface, while coordinates > 1 are treated as absolute sizes in model units (i.e. considering the model occupies the entire view). Like in 'position', an elevation can be provided with the z coordinate, allowing to scale the layer in the 3 directions ")),
				@facet (
						name = IKeyword.TRANSPARENCY,
						type = IType.FLOAT,
						optional = true,
						doc = @doc ("the transparency level of the layer (between 0 -- opaque -- and 1 -- fully transparent)")),
				@facet (
						name = IKeyword.VISIBLE,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Defines whether this layer is visible or not")),
				@facet (
						name = IKeyword.TRACE,
						type = { IType.BOOL, IType.INT },
						optional = true,
						doc = @doc ("Allows to aggregate the visualization of agents at each timestep on the display. Default is false. If set to an int value, only the last n-th steps will be visualized. If set to true, no limit of timesteps is applied. ")),
				@facet (
						name = IKeyword.FADING,
						type = { IType.BOOL },
						optional = true,
						doc = @doc ("Used in conjunction with 'trace:', allows to apply a fading effect to the previous traces. Default is false")),
				@facet (
						name = IKeyword.SPECIES,
						type = IType.SPECIES,
						optional = false,
						doc = @doc ("the species to be displayed")),
				@facet (
						name = IKeyword.ASPECT,
						type = IType.ID,
						optional = true,
						doc = @doc ("the name of the aspect that should be used to display the species")),
				@facet (
						name = IKeyword.REFRESH,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("(openGL only) specify whether the display of the species is refreshed. (true by default, usefull in case of agents that do not move)")) },
		omissible = IKeyword.SPECIES)
@doc (
		value = "The `" + IKeyword.POPULATION
		+ "` statement is used using the `species keyword`. It allows modeler to display all the agent of a given species in the current display. In particular, modeler can choose the aspect used to display them.",
		usages = { @usage (
				value = "The general syntax is:",
				examples = { @example (
						value = "display my_display {",
						isExecutable = false),
						@example (
								value = "   species species_name [additional options];",
								isExecutable = false),
						@example (
								value = "}",
								isExecutable = false) }),
				@usage (
						value = "Species can be superposed on the same plan (be careful with the order, the last one will be above all the others):",
						examples = { @example (
								value = "display my_display {",
								isExecutable = false),
								@example (
										value = "   species agent1 aspect: base;",
										isExecutable = false),
								@example (
										value = "   species agent2 aspect: base;",
										isExecutable = false),
								@example (
										value = "   species agent3 aspect: base;",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false) }),
				@usage (
						value = "Each species layer can be placed at a different z value using the opengl display. position:{0,0,0} means the layer will be placed on the ground and position:{0,0,1} means it will be placed at an height equal to the maximum size of the environment.",
						examples = { @example (
								value = "display my_display type: opengl{",
								isExecutable = false),
								@example (
										value = "   species agent1 aspect: base ;",
										isExecutable = false),
								@example (
										value = "   species agent2 aspect: base position:{0,0,0.5};",
										isExecutable = false),
								@example (
										value = "   species agent3 aspect: base position:{0,0,1};",
										isExecutable = false),
								@example (
										value = "}",
										isExecutable = false) }) },
		see = { IKeyword.DISPLAY, IKeyword.AGENTS, IKeyword.CHART, IKeyword.EVENT, "graphics", IKeyword.GRID_POPULATION,
				IKeyword.IMAGE, IKeyword.OVERLAY })
@serializer (SpeciesLayerSerializer.class)
@validator (SpeciesLayerValidator.class)
public class SpeciesLayerStatement extends AgentLayerStatement {

	/**
	 * The Class SpeciesLayerSerializer.
	 */
	public static class SpeciesLayerSerializer extends SymbolSerializer<StatementDescription> {

		/**
		 * Serialize keyword.
		 *
		 * @param desc the desc
		 * @param sb the sb
		 * @param includingBuiltIn the including built in
		 */
		@Override
		protected void serializeKeyword(final SymbolDescription desc, final StringBuilder sb,
				final boolean includingBuiltIn) {
			sb.append("species ");
		}

	}

	/**
	 * The Class SpeciesLayerValidator.
	 */
	public static class SpeciesLayerValidator implements IDescriptionValidator<StatementDescription> {

		/**
		 * Validate.
		 *
		 * @param description the description
		 */
		@Override
		public void validate(final StatementDescription description) {
			// IExpressionDescription ed = description.getFacet(SPECIES);
			SpeciesDescription target;
			target = description.getGamlType().getDenotedSpecies();
			if (target == null) // Already caught by the type checking
				return;
			final IExpressionDescription ed = description.getFacet(ASPECT);
			if (ed != null) {
				final String a = description.getLitteral(ASPECT);
				if (target.getAspect(a) != null) {
					ed.compileAsLabel();
				} else {
					description.error(a + " is not the name of an aspect of " + target.getName(), IGamlIssue.GENERAL,
							ed.getTarget());
				}

			}
		}

	}

	/** The aspect. */
	private IExecutable aspect;

	/** The host species. */
	protected ISpecies hostSpecies;

	/** The species. */
	protected ISpecies species;

	/** The micro species layers. */
	protected List<SpeciesLayerStatement> microSpeciesLayers;

	/**
	 * Instantiates a new species layer statement.
	 *
	 * @param desc the desc
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public SpeciesLayerStatement(final IDescription desc) throws GamaRuntimeException {
		super(desc);
		setName(getFacet(IKeyword.SPECIES).literalValue());
	}

	/**
	 * Inits the.
	 *
	 * @param scope the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public boolean _init(final IScope scope) throws GamaRuntimeException {
		// top level species layer is a direct micro-species of "world_species"
		// for sure
		if (hostSpecies == null && scope.getSimulation() != null) {
			hostSpecies = scope.getSimulation().getSpecies();
		}
		species = Cast.asSpecies(scope, getFacet(IKeyword.SPECIES).value(scope));
		if (species == null && hostSpecies != null) {
			species = hostSpecies.getMicroSpecies(getName());
		}
		if (species == null) throw GamaRuntimeException.error("not a suitable species to display: " + getName(), scope);
		if (super._init(scope) && (microSpeciesLayers != null)) {
			for (final SpeciesLayerStatement microLayer : microSpeciesLayers) {
				microLayer.hostSpecies = species;
				if (!scope.init(microLayer).passed()) return false;
			}
		}
		return true;
	}

	/**
	 * Step.
	 *
	 * @param scope the scope
	 * @return true, if successful
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public boolean _step(final IScope scope) throws GamaRuntimeException {
		return true;
	}

	/**
	 * Gets the type.
	 *
	 * @param output the output
	 * @return the type
	 */
	@Override
	public LayerType getType(final LayeredDisplayOutput output) {
		return LayerType.SPECIES;
	}

	/**
	 * Gets the aspects.
	 *
	 * @return the aspects
	 */
	public List<String> getAspects() {
		return species.getAspectNames();
	}

	/**
	 * Sets the aspect.
	 *
	 * @param currentAspect the new aspect
	 */
	@Override
	public void setAspect(final String currentAspect) {
		super.setAspect(currentAspect);
		aspect = species.getAspect(constantAspectName);
	}

	/**
	 * Compute aspect name.
	 *
	 * @param sim the sim
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public void computeAspectName(final IScope sim) throws GamaRuntimeException {
		if (aspect != null) return;
		super.computeAspectName(sim);
		aspect = species.getAspect(constantAspectName);
	}

	/**
	 * Gets the aspect.
	 *
	 * @return the aspect
	 */
	@Override
	public IExecutable getAspect() {
		return aspect;
	}

	/**
	 * Gets the species.
	 *
	 * @return the species
	 */
	public ISpecies getSpecies() {
		return species;
	}

	/**
	 * Sets the children.
	 *
	 * @param commands the new children
	 */
	@Override
	public void setChildren(final Iterable<? extends ISymbol> commands) {
		final List<IStatement> aspectStatements = new ArrayList<>();

		for (final ISymbol c : commands) {
			if (c instanceof SpeciesLayerStatement) {
				if (microSpeciesLayers == null) {
					microSpeciesLayers = new ArrayList<>();
				}
				microSpeciesLayers.add((SpeciesLayerStatement) c);
			} else {
				aspectStatements.add((IStatement) c);
			}
		}
		if (!aspectStatements.isEmpty()) {
			constantAspectName = "inline";
			final IDescription d =
					DescriptionFactory.create(IKeyword.ASPECT, getDescription(), IKeyword.NAME, "inline");
			aspect = new AspectStatement(d);
			((AspectStatement) aspect).setChildren(aspectStatements);
		}
	}

	/**
	 * Returns a list of micro-species layers declared as sub-layers.
	 *
	 * @return the micro species layers
	 */
	public List<SpeciesLayerStatement> getMicroSpeciesLayers() {
		return microSpeciesLayers;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SpeciesDisplayLayer species: " + getName();
	}
}
