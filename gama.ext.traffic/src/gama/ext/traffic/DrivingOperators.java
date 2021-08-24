/*******************************************************************************************************
 *
 * DrivingOperators.java, in gama.ext.traffic, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.traffic;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.OrderedBidiMap;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ITypeProvider;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.no_test;
import gama.core.dev.annotations.GamlAnnotations.operator;
import gama.ext.traffic.carfollowing.CustomDualTreeBidiMap;
import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.graph.GamaSpatialGraph;
import gama.runtime.IScope;
import gama.util.IContainer;
import gama.util.graph.IGraph;

/**
 * The Class DrivingOperators.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DrivingOperators {

	/**
	 * Spatial driving from edges.
	 *
	 * @param scope the scope
	 * @param edges the edges
	 * @param nodes the nodes
	 * @return the i graph
	 */
	@operator(value = "as_driving_graph", content_type = ITypeProvider.CONTENT_TYPE_AT_INDEX + 2, index_type = ITypeProvider.CONTENT_TYPE_AT_INDEX + 1, concept = {
			IConcept.GRAPH, IConcept.TRANSPORT })
	@doc(value = "creates a graph from the list/map of edges given as operand and connect the node to the edge", examples = {
			@example(value = "as_driving_graph(road,node)  --:  build a graph while using the road agents as edges and the node agents as nodes", isExecutable = false) }, see = {
					"as_intersection_graph", "as_distance_graph", "as_edge_graph" })
	@no_test
	public static IGraph spatialDrivingFromEdges(final IScope scope, final IContainer edges, final IContainer nodes) {
		return new GamaSpatialGraph(edges, nodes, scope);
	}
}
