/*******************************************************************************************************
 *
 * GraphAlgorithmsHandmade.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.graph;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IList;

/**
 * Contains various handmade algorithms. Algorithms mainly based on external
 * dependances should take place elsewhere for shake of lisibility.
 * 
 * @author Samuel Thiriot
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class GraphAlgorithmsHandmade {

	/**
	 * Picks up a random node in the graph and returns it.
	 *
	 * @param scope the scope
	 * @param graph the graph
	 * @return the one random node
	 */
	public static Object getOneRandomNode(final IScope scope, final IGraph graph) {
		return graph.getVertices().get(scope.getRandom().between(0, graph.getVertices().size() - 1));
	}

	/**
	 * Picks up a random node that is not the one passed in parameter.
	 *
	 * @param scope the scope
	 * @param graph the graph
	 * @param excludedNode the excluded node
	 * @return the another random node
	 */
	public static Object getAnotherRandomNode(final IScope scope, final IGraph graph, final Object excludedNode) {

		if (graph.getVertices().size() < 2) {
			throw GamaRuntimeException.error("unable to find another node in this very small network", scope);
		}

		Object proposedNode = null;
		do {
			proposedNode = getOneRandomNode(scope, graph);
		} while (proposedNode == excludedNode);

		return proposedNode;
	}

	/**
	 * TODO does not works now Rewires a graph (in the Watts-Strogatz meaning).
	 *
	 * @param scope the scope
	 * @param graph the graph
	 * @param probability the probability
	 * @return the i graph
	 */
	public static IGraph rewireGraphProbability(final IScope scope, final IGraph graph, final Double probability) {

		final IList edges = graph.getEdges();
		for (int i = 0; i < edges.size(); i++) {

			final Object currentEdge = edges.get(i);
			if (scope.getRandom().between(0, 1.0) <= probability) {

				// rewire this edge
				final Object from = graph.getEdgeSource(currentEdge);

				//System.err.println("removing " + from);

				final Object toNode = getAnotherRandomNode(scope, graph, from);
				//System.err.println("rewiring " + graph.getEdgeTarget(currentEdge) + " to " + toNode);

				graph.removeEdge(currentEdge);

				graph.addEdge(from, toNode, currentEdge);

			}

		}

		return graph;

	}

	/**
	 * Rewires the given count of edges. If there are too many edges, all the
	 * edges will be rewired.
	 *
	 * @param scope the scope
	 * @param graph the graph
	 * @param count the count
	 * @return the i graph
	 */
	public static IGraph rewireGraphCount(final IScope scope, final IGraph graph, final Integer count) {

		final IList edges = graph.getEdges();
		for (int i = 0; i < count; i++) {

			final Object currentEdge = edges.get(scope.getRandom().between(0, graph.getEdges().length(null) - 1 // VERIFY
			// NULL
			// SCOPE
			));

			// rewire this edge
			final Object from = graph.getEdgeSource(currentEdge);

			//System.err.println("removing " + from);

			final Object toNode = getAnotherRandomNode(scope, graph, from);
			//System.err.println("rewiring " + graph.getEdgeTarget(currentEdge) + " to " + toNode);

			graph.removeEdge(currentEdge);

			graph.addEdge(from, toNode, currentEdge);

		}

		return graph;

	}

}
