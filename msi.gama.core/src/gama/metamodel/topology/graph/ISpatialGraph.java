/*******************************************************************************************************
 *
 * msi.gama.metamodel.topology.graph.ISpatialGraph.java, in plugin msi.gama.core, is part of the source code of the GAMA
 * modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

	ITopology getTopology(IScope scope);

	@Override
	IList<IShape> getVertices();

	@Override
	IList<IShape> getEdges();

}
