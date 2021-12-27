/*******************************************************************************************************
 *
 * InspectDisplayOutput.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.outputs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGui;
import gama.common.util.StringUtils;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.kernel.experiment.IExperimentAgent;
import gama.kernel.simulation.SimulationPopulation;
import gama.metamodel.agent.IAgent;
import gama.metamodel.agent.IMacroAgent;
import gama.metamodel.population.IPopulation;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IContainer;
import gaml.compilation.GAML;
import gaml.compilation.SymbolTracer;
import gaml.descriptions.IDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.expressions.IExpression;
import gaml.factories.DescriptionFactory;
import gaml.operators.Cast;
import gaml.species.ISpecies;
import gaml.statements.IStatement;
import gaml.types.IType;
import gaml.types.Types;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractInspectOutput.
 *
 * @author drogoul
 */
@symbol (
		name = { IKeyword.INSPECT, IKeyword.BROWSE },
		kind = ISymbolKind.OUTPUT,
		with_sequence = false,
		concept = { IConcept.INSPECTOR })
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT },
		symbols = { IKeyword.OUTPUT, IKeyword.PERMANENT })
@facets (
		value = { @facet (
				name = IKeyword.NAME,
				type = IType.NONE,
				optional = false,
				doc = @doc ("the identifier of the inspector")),
				@facet (
						name = IKeyword.REFRESH_EVERY,
						type = IType.INT,
						optional = true,
						doc = @doc (
								value = "Allows to refresh the inspector every n time steps (default is 1)",
								deprecated = "Use refresh: every(n) instead")),
				@facet (
						name = IKeyword.REFRESH,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Indicates the condition under which this output should be refreshed (default is true)")),
				@facet (
						name = IKeyword.VALUE,
						type = IType.NONE,
						optional = true,
						doc = @doc ("the set of agents to inspect, could be a species, a list of agents or an agent")),
				@facet (
						name = IKeyword.ATTRIBUTES,
						type = { IType.LIST },
						optional = true,
						doc = @doc ("the list of attributes to inspect. A list that can contain strings or pair<string,type>, or a mix of them. These can be variables of the species, but also attributes present in the attributes table of the agent. The type is necessary in that case")),
				@facet (
						name = IKeyword.TYPE,
						type = IType.ID,
						values = { IKeyword.AGENT, IKeyword.TABLE },
						optional = true,
						doc = @doc ("the way to inspect agents: in a table, or a set of inspectors")) },
		omissible = IKeyword.NAME)
@doc (
		value = "`" + IKeyword.INSPECT + "` (and `" + IKeyword.BROWSE
				+ "`) statements allows modeler to inspect a set of agents, in a table with agents and all their attributes or an agent inspector per agent, depending on the type: chosen. Modeler can choose which attributes to display. When `"
				+ IKeyword.BROWSE + "` is used, type: default value is table, whereas when`" + IKeyword.INSPECT
				+ "` is used, type: default value is agent.",
		usages = { @usage (
				value = "An example of syntax is:",
				examples = { @example (
						value = "inspect \"my_inspector\" value: ant attributes: [\"name\", \"location\"];",
						isExecutable = false) }) })
@SuppressWarnings ({ "rawtypes" })
public class InspectDisplayOutput extends AbstractValuedDisplayOutput implements IStatement {

	/** The Constant INSPECT_AGENT. */
	public static final short INSPECT_AGENT = 0;

	/** The Constant INSPECT_TABLE. */
	public static final short INSPECT_TABLE = 3;

	/** The count. */
	static int count = 0;

	/** The Constant types. */
	static final List<String> types = Arrays.asList(IKeyword.AGENT, IKeyword.DYNAMIC, IKeyword.SPECIES, IKeyword.TABLE);

	/** The type. */
	String type;

	/** The attributes. */
	IExpression attributes;

	/** The list of attributes. */
	private Map<String, String> listOfAttributes;

	/** The root agent. */
	IMacroAgent rootAgent;

	/**
	 * Instantiates a new inspect display output.
	 *
	 * @param desc
	 *            the desc
	 */
	public InspectDisplayOutput(final IDescription desc) {
		super(desc);
		if (getValue() == null) {
			value = getFacet(IKeyword.NAME);
			expressionText = getValue() == null ? "" : getValue().serialize(false);
		}
		type = getLiteral(IKeyword.TYPE);
		if (type == null) {
			if (IKeyword.BROWSE.equals(getKeyword())) {
				type = IKeyword.TABLE;
			} else {
				type = IKeyword.AGENT;
			}
		}
		attributes = getFacet(IKeyword.ATTRIBUTES);
	}

	/**
	 * Inits the.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 */
	@Override
	public boolean init(final IScope scope) {
		super.init(scope);
		if (IKeyword.AGENT.equals(type) && getValue() != null) { lastValue = getValue().value(getScope()); }
		if (attributes != null) {
			listOfAttributes = (Map<String, String>) Types.MAP.of(Types.STRING, Types.STRING).cast(getScope(),
					attributes.value(getScope()), null, true);
		}
		if (rootAgent == null || rootAgent.dead()) { rootAgent = getScope().getRoot(); }
		return true;
	}

	/**
	 * Inspect.
	 *
	 * @param a
	 *            the a
	 * @param attributes
	 *            the attributes
	 * @return the inspect display output
	 */
	public static InspectDisplayOutput inspect(final IAgent a, final IExpression attributes) {
		IDescription desc = DescriptionFactory.create(IKeyword.INSPECT, IKeyword.NAME,
				StringUtils.toGamlString("Inspect: "), IKeyword.TYPE, types.get(INSPECT_AGENT)).validate();
		desc.setFacet(IKeyword.VALUE, GAML.getExpressionFactory().createConst(a, a.getGamlType()));
		desc.validate();
		if (attributes != null) { desc.setFacet(IKeyword.ATTRIBUTES, attributes); }
		// Opens directly an inspector
		InspectDisplayOutput result = new InspectDisplayOutput(desc);
		// result.setValue(GAML.getExpressionFactory().createConst(a, a.getGamlType()));
		result.lastValue = a;
		return result;
	}

	/**
	 * Instantiates a new inspect display output.
	 *
	 * @param a
	 *            the a
	 * @param attributes
	 *            the attributes
	 * @return the inspect display output
	 */
	public static InspectDisplayOutput inspect(final IExperimentAgent a, final IExpression attributes) {
		// Opens directly an inspector
		IDescription desc = DescriptionFactory.create(IKeyword.INSPECT, IKeyword.NAME,
				StringUtils.toGamlString("Inspect: "), IKeyword.TYPE, types.get(INSPECT_TABLE)).validate();
		final SimulationPopulation sp = a.getSimulationPopulation();
		desc.setFacet(IKeyword.VALUE, GAML.getExpressionFactory().createConst(sp, sp.getGamlType()));
		if (attributes != null) { desc.setFacet(IKeyword.ATTRIBUTES, attributes); }
		InspectDisplayOutput result = new InspectDisplayOutput(desc);
		result.lastValue = sp;
		result.rootAgent = a;
		return result;
	}

	/**
	 * Instantiates a new inspect display output.
	 *
	 * @param rootAgent
	 *            the root agent
	 * @param species
	 *            the species
	 * @param attributes
	 *            the attributes
	 * @return the inspect display output
	 */
	static public InspectDisplayOutput browse(final IMacroAgent rootAgent, final ISpecies species,
			final IExpression attributes) {
		// Opens a table inspector on the agents of this species
		IDescription desc = DescriptionFactory
				.create(IKeyword.INSPECT, GAML.getExperimentContext(rootAgent), IKeyword.NAME,
						StringUtils.toGamlString("Browse(" + count++ + ")"), IKeyword.VALUE,
						species == null ? "nil" : species.getName(), IKeyword.TYPE, types.get(INSPECT_TABLE))
				.validate();
		if (attributes != null) { desc.setFacet(IKeyword.ATTRIBUTES, attributes); }
		InspectDisplayOutput result = new InspectDisplayOutput(desc);
		result.rootAgent = rootAgent;
		return result;
	}

	/**
	 * Instantiates a new inspect display output.
	 *
	 * @param agent
	 *            the agent
	 * @param agents
	 *            the agents
	 * @param attributes
	 *            the attributes
	 * @return the inspect display output
	 */
	static public InspectDisplayOutput browse(final IMacroAgent agent, final Collection<? extends IAgent> agents,
			final IExpression attributes) {
		// Opens a table inspector on the agents of this container
		IDescription desc = DescriptionFactory.create(IKeyword.INSPECT, GAML.getExperimentContext(agent), IKeyword.NAME,
				StringUtils.toGamlString("Browse(" + count++ + ")"), IKeyword.VALUE, Cast.toGaml(agents), IKeyword.TYPE,
				types.get(INSPECT_TABLE)).validate();
		if (attributes != null) { desc.setFacet(IKeyword.ATTRIBUTES, attributes); }
		InspectDisplayOutput result = new InspectDisplayOutput(desc);
		result.lastValue = agents;
		result.rootAgent = agent;
		return result;
	}

	/**
	 * Browse.
	 *
	 * @param agent
	 *            the agent
	 * @param agents
	 *            the agents
	 * @param attributes
	 *            the attributes
	 * @return the inspect display output
	 */
	static public InspectDisplayOutput browse(final IMacroAgent agent, final IExpression agents,
			final IExpression attributes) { // Opens a table inspector on the agents of this container
		IDescription desc = DescriptionFactory
				.create(IKeyword.INSPECT, GAML.getExperimentContext(agent), IKeyword.NAME,
						StringUtils.toGamlString("Browse(" + count++ + ")"), IKeyword.TYPE, types.get(INSPECT_TABLE))
				.validate();
		desc.setFacet(IKeyword.VALUE, agents);
		if (attributes != null) { desc.setFacet(IKeyword.ATTRIBUTES, attributes); }
		InspectDisplayOutput result = new InspectDisplayOutput(desc);
		result.rootAgent = agent;
		return result;
	}

	/**
	 * Launch.
	 *
	 * @param scope
	 *            the scope
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	public void launch(final IScope scope) throws GamaRuntimeException {
		if (!scope.init(InspectDisplayOutput.this).passed()) return;
		// TODO What to do in case of multi-simulations ???
		if (scope.getSimulation() != null) {
			scope.getSimulation().addOutput(InspectDisplayOutput.this);
		} else if (scope.getExperiment() != null) {
			scope.getExperiment().getSpecies().getExperimentOutputs().add(InspectDisplayOutput.this);
		}
		setPaused(false);
		open();
		step(scope);
		update();
	}

	/**
	 * Step.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 */
	@Override
	public boolean step(final IScope scope) {
		// ((AbstractScope) getScope()).traceAgents = true;
		if (IKeyword.TABLE.equals(type)) {
			if (rootAgent == null || rootAgent.dead()) return false;
			if (getValue() == null) return true;
			if (getScope().interrupted()) return false;
			getScope().setCurrentSymbol(this);
			lastValue = getScope().evaluate(getValue(), rootAgent).getValue();
		}
		return true;
	}

	/**
	 * Checks if is unique.
	 *
	 * @return true, if is unique
	 */
	@Override
	public boolean isUnique() { return !IKeyword.TABLE.equals(type); }

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public String getId() { return isUnique() ? getViewId() : getViewId() + getName(); }

	/**
	 * Gets the view id.
	 *
	 * @return the view id
	 */
	@Override
	public String getViewId() {
		if (IKeyword.TABLE.equals(type)) return IGui.TABLE_VIEW_ID;
		return IGui.AGENT_VIEW_ID;

	}

	/** The Constant EMPTY. */
	final static IAgent[] EMPTY = {};

	/**
	 * Gets the last value.
	 *
	 * @return the last value
	 */
	@Override
	public IAgent[] getLastValue() {
		if (IKeyword.TABLE.equals(type) && (rootAgent == null || rootAgent.dead())) return EMPTY;
		// DEBUG.LOG("Last value :" + lastValue);
		if (lastValue instanceof IAgent) return new IAgent[] { (IAgent) lastValue };
		if (lastValue instanceof ISpecies && rootAgent != null) {
			final IPopulation pop = rootAgent.getMicroPopulation((ISpecies) lastValue);
			return pop.toArray();
		}
		if (lastValue instanceof IContainer)
			return ((IContainer<?, ?>) lastValue).listValue(getScope(), Types.NO_TYPE, false).toArray(new IAgent[0]);
		return EMPTY;
	}

	/**
	 * Gets the species.
	 *
	 * @return the species
	 */
	public ISpecies getSpecies() {
		final IExpression valueExpr = getValue();
		if (valueExpr == null) return null;
		final IType theType = valueExpr.getGamlType().getContentType();
		if (theType == Types.get(IKeyword.MODEL)) return getScope().getModel().getSpecies();
		final SpeciesDescription sd = theType.getSpecies();
		if (sd == null) return getScope().getModel().getSpecies(IKeyword.AGENT);
		if (sd.equals(getScope().getModel().getDescription())) return getScope().getModel().getSpecies();
		String speciesName = sd.getName();
		if (speciesName == null) { speciesName = IKeyword.AGENT; }
		return rootAgent.getSpecies().getMicroSpecies(speciesName);
	}

	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() { return listOfAttributes; }

	/**
	 * Gets the root agent.
	 *
	 * @return the root agent
	 */
	public IMacroAgent getRootAgent() { return rootAgent; }

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		super.dispose();
		rootAgent = null;
		attributes = null;
	}

	/**
	 * Execute on.
	 *
	 * @param scope
	 *            the scope
	 * @return the object
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	public Object executeOn(final IScope scope) throws GamaRuntimeException {
		final IType theType = value.getGamlType();
		if (theType.isAgentType()) {
			GAMA.getGui().setSelectedAgent((IAgent) value.value(scope));
		} else if (theType.isContainer()) { ValuedDisplayOutputFactory.browse(scope.getRoot(), value, attributes); }
		return value.value(scope);
	}

	/**
	 * Gets the trace.
	 *
	 * @param scope
	 *            the scope
	 * @return the trace
	 */
	@Override
	public String getTrace(final IScope scope) {
		return new SymbolTracer().trace(scope, this);
	}

}
