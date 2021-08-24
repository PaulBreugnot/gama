/*******************************************************************************************************
 *
 * GraphObject.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.graph;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;

/**
 * Class GraphObject.
 *
 * @author drogoul
 * @param <T> the generic type
 * @param <V> the value type
 * @param <E> the element type
 * @since 12 janv. 2014
 */
public abstract class GraphObject<T extends IGraph<V, E>, V, E> {

	/** The graph. */
	protected final T graph;
	
	/** The weight. */
	protected double weight = DefaultDirectedWeightedGraph.DEFAULT_EDGE_WEIGHT;

	/**
	 * Instantiates a new graph object.
	 *
	 * @param g the g
	 * @param w the w
	 */
	GraphObject(final T g, final double w) {
		graph = g;
		weight = w;
	}

	/**
	 * Sets the weight.
	 *
	 * @param w the new weight
	 */
	public void setWeight(final double w) {
		weight = w;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public abstract double getWeight();

	/**
	 * Checks if is node.
	 *
	 * @return true, if is node
	 */
	public boolean isNode() {
		return false;
	}

	/**
	 * Checks if is edge.
	 *
	 * @return true, if is edge
	 */
	public boolean isEdge() {
		return false;
	}
}
