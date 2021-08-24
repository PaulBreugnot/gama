/*******************************************************************************************************
 *
 * ISpatialGraph.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.graph;

import gama.metamodel.shape.IShape;
import gama.metamodel.topology.ITopology;
import gama.metamodel.topology.filter.IAgentFilter;
import gama.runtime.IScope;
import gama.util.IList;
import gama.util.graph.IGraph;

/**
 * The class ISpatialGraph.
 *
 * @author drogoul
 * @since 3 f�vr. 2012
 *
 */
public interface ISpatialGraph extends IGraph<IShape, IShape>, IAgentFilter {

	/**
	 * Gets the topology.
	 *
	 * @param scope the scope
	 * @return the topology
	 */
	ITopology getTopology(IScope scope);

	/**
	 * Gets the vertices.
	 *
	 * @return the vertices
	 */
	@Override
	IList<IShape> getVertices();

	/**
	 * Gets the edges.
	 *
	 * @return the edges
	 */
	@Override
	IList<IShape> getEdges();

}
