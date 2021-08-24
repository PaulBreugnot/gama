/*******************************************************************************************************
 *
 * AbstractGraphNodeAgent.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.graph;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.action;
import gama.core.dev.annotations.GamlAnnotations.arg;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.species;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.core.dev.utils.DEBUG;
import gama.metamodel.agent.GamlAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.topology.graph.GamaSpatialGraph.VertexRelationship;
import gama.runtime.ExecutionResult;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.ConstantExpressionDescription;
import gaml.operators.Cast;
import gaml.statements.Arguments;
import gaml.statements.IStatement;
import gaml.types.IType;

/**
 * The Class AbstractGraphNodeAgent.
 */
// FIXME: Add all the necessary variables (degree, neighbors, edges)
@species (
		name = "graph_node",
		concept = { IConcept.GRAPH, IConcept.NODE },
		doc = @doc ("A base species to use as a parent for species representing agents that are nodes of a graph"))
@vars ({ @variable (
		name = IKeyword.MYGRAPH,
		type = IType.GRAPH,
		doc = @doc ("A reference to the graph containing the agent")) })
@doc ("A base species to use as a parent for species representing agents that are nodes of a graph")
public class AbstractGraphNodeAgent extends GamlAgent {

	/** The Constant args. */
	final static Arguments args = new Arguments();

	/**
	 * The Class NodeRelation.
	 */
	public static class NodeRelation implements VertexRelationship<AbstractGraphNodeAgent> {

		/** The action. */
		IStatement.WithArgs action;

		@Override
		public boolean related(final IScope scope, final AbstractGraphNodeAgent p1, final AbstractGraphNodeAgent p2) {
			args.put("other", ConstantExpressionDescription.create(p2));
			final ExecutionResult result = scope.execute(getAction(p1), p1, args);
			return Cast.asBool(scope, result.getValue());
		}

		@Override
		public boolean equivalent(final IScope scope, final AbstractGraphNodeAgent p1,
				final AbstractGraphNodeAgent p2) {
			return p1 == p2;
		}

		/**
		 * Gets the action.
		 *
		 * @param a1 the a 1
		 * @return the action
		 */
		IStatement.WithArgs getAction(final AbstractGraphNodeAgent a1) {
			if (action == null) {
				action = a1.getAction();
			}
			return action;
		}

	}

	/**
	 * Instantiates a new abstract graph node agent.
	 *
	 * @param s the s
	 * @param index the index
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public AbstractGraphNodeAgent(final IPopulation<? extends IAgent> s, final int index) throws GamaRuntimeException {
		super(s, index);
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	IStatement.WithArgs getAction() {
		return getSpecies().getAction("related_to");
	}

	/**
	 * Related to.
	 *
	 * @param scope the scope
	 * @return the boolean
	 */
	@action (
			doc = @doc ("This operator should never be called"),
			name = "related_to",
			virtual = true,
			args = { @arg (
					doc = @doc ("The other agent"),
					name = "other",
					optional = false,
					type = IType.AGENT) })
	public Boolean relatedTo(final IScope scope) {
		DEBUG.LOG("Should never be called !");
		return false;
	}

	/**
	 * Gets the graph.
	 *
	 * @return the graph
	 */
	@SuppressWarnings ("rawtypes")
	@getter (IKeyword.MYGRAPH)
	public GamaGraph getGraph() {
		return (GamaGraph) getTopology().getPlaces();
	}
}
