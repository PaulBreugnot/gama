/*******************************************************************************************************
 *
 * GamaSpatialGraph.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.metamodel.topology.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.locationtech.jts.geom.Coordinate;

import gama.common.util.StringUtils;
import gama.core.dev.utils.DEBUG;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.metamodel.shape.GamaPoint;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.ITopology;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaListFactory;
import gama.util.GamaMapFactory;
import gama.util.IContainer;
import gama.util.IList;
import gama.util.IMap;
import gama.util.graph.GamaGraph;
import gama.util.graph.GraphEvent;
import gama.util.graph.GraphEvent.GraphEventType;
import gama.util.graph._Edge;
import gama.util.path.GamaSpatialPath;
import gama.util.path.PathFactory;
import gaml.species.ISpecies;
import gaml.types.GamaGeometryType;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class GamaSpatialGraph.
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaSpatialGraph extends GamaGraph<IShape, IShape> implements ISpatialGraph, IPopulation.Listener {

	/** The topology. */
	/*
	 * Own topology of the graph. Lazily instantiated, and invalidated at each modification of the graph.
	 */
	private ITopology topology;

	/** The tolerance. */
	private double tolerance = 0;

	/** The vertices built. */
	private final Map<Integer, IShape> verticesBuilt; // only used for
														// optimization
														// purpose of
														// spatial graph

	// building.

	/**
	 * Determines the relationship among two polygons.
	 *
	 * @param <T>
	 *            the generic type
	 */
	public interface VertexRelationship<T> {

		/**
		 * Related.
		 *
		 * @param scope
		 *            TODO Determines if two vertex geometries are to be treated as related in any way.
		 * @param p1
		 *            a geometrical object
		 * @param p2
		 *            another geometrical object
		 * @return true, if successful
		 */
		boolean related(IScope scope, T p1, T p2);

		/**
		 * Equivalent.
		 *
		 * @param scope
		 *            the scope
		 * @param p1
		 *            the p 1
		 * @param p2
		 *            the p 2
		 * @return true, if successful
		 */
		boolean equivalent(IScope scope, T p1, T p2);

		// Double distance(T p1, T p2);

	}

	/**
	 * Instantiates a new gama spatial graph.
	 *
	 * @param edgesOrVertices
	 *            the edges or vertices
	 * @param byEdge
	 *            the by edge
	 * @param directed
	 *            the directed
	 * @param rel
	 *            the rel
	 * @param edgesSpecies
	 *            the edges species
	 * @param scope
	 *            the scope
	 * @param nodeType
	 *            the node type
	 * @param edgeType
	 *            the edge type
	 */
	public GamaSpatialGraph(final IContainer edgesOrVertices, final boolean byEdge, final boolean directed,
			final VertexRelationship rel, final ISpecies edgesSpecies, final IScope scope, final IType nodeType,
			final IType edgeType) {
		this(scope, nodeType, edgeType);
		init(scope, edgesOrVertices, byEdge, directed, rel, edgesSpecies);
	}

	/**
	 * Instantiates a new gama spatial graph.
	 *
	 * @param edgesOrVertices
	 *            the edges or vertices
	 * @param byEdge
	 *            the by edge
	 * @param directed
	 *            the directed
	 * @param rel
	 *            the rel
	 * @param edgesSpecies
	 *            the edges species
	 * @param scope
	 *            the scope
	 * @param nodeType
	 *            the node type
	 * @param edgeType
	 *            the edge type
	 * @param tolerance
	 *            the tolerance
	 */
	public GamaSpatialGraph(final IContainer edgesOrVertices, final boolean byEdge, final boolean directed,
			final VertexRelationship rel, final ISpecies edgesSpecies, final IScope scope, final IType nodeType,
			final IType edgeType, final Double tolerance) {
		this(scope, nodeType, edgeType);
		this.tolerance = tolerance;
		init(scope, edgesOrVertices, byEdge, directed, rel, edgesSpecies, tolerance);
	}

	/**
	 * Instantiates a new gama spatial graph.
	 *
	 * @param edges
	 *            the edges
	 * @param vertices
	 *            the vertices
	 * @param scope
	 *            the scope
	 */
	public GamaSpatialGraph(final IContainer edges, final IContainer vertices, final IScope scope) {
		this(scope, vertices.getGamlType().getContentType(), edges.getGamlType().getContentType());
		init(scope, edges, vertices);
	}

	/**
	 * Instantiates a new gama spatial graph.
	 *
	 * @param scope
	 *            the scope
	 * @param nodeType
	 *            the node type
	 * @param edgeType
	 *            the edge type
	 */
	public GamaSpatialGraph(final IScope scope, final IType nodeType, final IType edgeType) {
		super(scope, nodeType, edgeType);
		verticesBuilt = new HashMap();
	}

	@Override
	public GamaSpatialGraph copy(final IScope scope) {
		final GamaSpatialGraph g = new GamaSpatialGraph(GamaListFactory.EMPTY_LIST, true, directed, vertexRelation,
				edgeSpecies, scope, type.getKeyType(), type.getContentType());

		Graphs.addAllVertices(g, this.getVertices());
		Graphs.addAllEdges(g, this, this.edgeSet());
		return g;
	}

	@Override
	protected GamaSpatialPath pathFromEdges(final IScope scope, final IShape source, final IShape target,
			final IList<IShape> edges) {
		return PathFactory.newInstance(scope, getTopology(scope), source, target, edges);
		// return new GamaPath(getTopology(), (IShape) source, (IShape) target,
		// edges);
	}

	@Override
	protected void buildByVertices(final IScope scope, final IContainer<?, IShape> list) {
		Iterable<? extends IShape> shapes = list.iterable(scope);
		for (final IShape p : shapes) {
			super.addVertex(p);
		}
		for (final IShape o1 : shapes) { // Try to create automatic edges
			if (o1.getAgent() != null) { o1.getAgent().setAttribute("attached_graph", this); }
			for (final IShape o2 : shapes) { // See issue #2945 -- do not add an edge if it already exists
				// Reverted for the moment
				if (vertexRelation.related(scope, o1, o2) /* && !containsEdge(o1, o2) */) { addEdge(o1, o2); }
			}
		}
	}

	@Override
	public _SpatialEdge getEdge(final Object e) {
		return (_SpatialEdge) edgeMap.get(e);
	}

	@Override
	public _SpatialVertex getVertex(final Object v) {
		return (_SpatialVertex) vertexMap.get(v);
	}

	@Override
	protected _SpatialEdge newEdge(final Object e, final Object v1, final Object v2) throws GamaRuntimeException {
		return new _SpatialEdge(this, e, v1, v2);
	}

	@Override
	protected _SpatialVertex newVertex(final Object v) throws GamaRuntimeException {
		return new _SpatialVertex(this, v);
	}

	@Override
	public boolean addVertex(final IShape v) {
		final boolean added = super.addVertex(v);
		if (added && vertexRelation != null) {
			for (final IShape o : vertexSet()) {
				if (!vertexRelation.equivalent(graphScope, v, o) && vertexRelation.related(graphScope, v, o)) {
					addEdge(v, o);
				}
			}
		}
		return added;
	}

	@Override
	public ITopology getTopology(final IScope scope) {
		if (topology == null) { setTopology(new GraphTopology(scope, this)); }
		return topology;
	}

	/**
	 * Sets the topology.
	 *
	 * @param topology
	 *            the new topology
	 */
	protected void setTopology(final ITopology topology) { this.topology = topology; }

	/**
	 * Refresh edges.
	 */
	private void refreshEdges() {
		final Set<? extends IShape> vSet = vertexSet();
		DEBUG.OUT("Refreshing Edges " + edgeSpecies);
		boolean related, already;
		for (final IShape s1 : vSet) {
			for (final IShape s2 : vSet) {
				if (graphScope.interrupted()) return;
				if (vertexRelation.equivalent(graphScope, s1, s2)) { continue; }
				already = this.containsEdge(s1, s2);
				related = vertexRelation.related(graphScope, s1, s2);
				if (related && !already) {
					addEdge(s1, s2);
				} else if (already && !related) {
					removeEdge(s1, s2);

				}
			}
		}
	}

	@Override
	protected Object generateEdgeObject(final Object v1, final Object v2) {
		if (v1 instanceof IShape && v2 instanceof IShape)
			return GamaGeometryType.buildLink(graphScope, (IShape) v1, (IShape) v2);
		return super.generateEdgeObject(v1, v2);
	}

	@Override
	public void notifyAgentRemoved(final IScope scope, final IPopulation pop, final IAgent agent) {
		this.removeVertex(agent);
	}

	@Override
	public void notifyAgentAdded(final IScope scope, final IPopulation pop, final IAgent agent) {
		this.addVertex(agent);
	}

	@Override
	public void notifyAgentsAdded(final IScope scope, final IPopulation pop, final Collection agents) {
		for (final Object o : agents) {
			addVertex((IAgent) o);
		}
	}

	@Override
	public void notifyAgentsRemoved(final IScope scope, final IPopulation pop, final Collection agents) {
		for (final Object o : agents) {
			removeVertex(o);
		}
	}

	@Override
	public void notifyPopulationCleared(final IScope scope, final IPopulation pop) {
		removeAllVertices(vertexSet());
	}

	/**
	 * Post refresh management action.
	 *
	 * @param scope
	 *            the scope
	 */
	public void postRefreshManagementAction(final IScope scope) {
		scope.getSimulation().postEndAction(scope1 -> {
			GamaSpatialGraph.this.refreshEdges();
			return null;
		});
	}

	@Override
	public Set<IShape> vertexSet() {
		return vertexMap.keySet();
	}

	/**
	 * Adds the built vertex.
	 *
	 * @param vertex
	 *            the vertex
	 */
	public void addBuiltVertex(final IShape vertex) {
		verticesBuilt.put(vertex.getLocation().hashCode(), vertex);
	}

	/**
	 * Gets the built vertex.
	 *
	 * @param vertex
	 *            the vertex
	 * @return the built vertex
	 */
	public IShape getBuiltVertex(final Coordinate vertex) {
		if (tolerance == 0) return verticesBuilt.get(vertex.hashCode());
		final IShape sh = verticesBuilt.get(vertex.hashCode());
		if (sh != null) return sh;
		for (final Object v : verticesBuilt.values()) {
			if (vertex.distance3D(((IShape) v).getLocation()) <= tolerance) return (IShape) v;
		}
		return null;
	}

	/**
	 * Builds the by edge with node.
	 *
	 * @param scope
	 *            the scope
	 * @param edges
	 *            the edges
	 * @param vertices
	 *            the vertices
	 */
	protected void buildByEdgeWithNode(final IScope scope, final IContainer edges, final IContainer vertices) {

		/*
		 * Do we want to have intersections that are not connected to any road ? At least put this in the next loop to
		 * avoid duplicates
		 *
		 * for (final Object ag : vertices.iterable(scope)) { super.addVertex(ag); }
		 */

		final IMap<GamaPoint, IShape> nodes = GamaMapFactory.create(Types.POINT, getGamlType().getKeyType());
		for (final Object ag : vertices.iterable(scope)) {
			super.addVertex(ag);
			nodes.put(((IShape) ag).getLocation(), (IShape) ag);
		}
		for (final Object p : edges.iterable(scope)) {
			final boolean addEdge = addEdgeWithNodes(scope, (IShape) p, nodes);
			if (!addEdge) { continue; }
			getEdge(p).setWeight(((IShape) p).getPerimeter());
		}
	}

	/**
	 * Adds the edge with nodes.
	 *
	 * @param scope
	 *            the scope
	 * @param e
	 *            the e
	 * @param nodes
	 *            the nodes
	 * @return true, if successful
	 */
	public boolean addEdgeWithNodes(final IScope scope, final IShape e, final IMap<GamaPoint, IShape> nodes) {
		if (containsEdge(e)) return false;
		final Coordinate[] coord = e.getInnerGeometry().getCoordinates();
		final IShape ptS = new GamaPoint(coord[0]);
		final IShape ptT = new GamaPoint(coord[coord.length - 1]);
		final IShape v1 = nodes.get(ptS);
		if (v1 == null) return false;
		final IShape v2 = nodes.get(ptT);
		if (v2 == null) return false;

		addVertex(v1);
		addVertex(v2);
		_Edge<IShape, IShape> edge;
		try {
			edge = newEdge(e, v1, v2);
		} catch (final GamaRuntimeException e1) {
			e1.addContext("Impossible to create edge from " + StringUtils.toGaml(e, false) + " in graph " + this);
			throw e1;
		}
		// if ( edge == null ) { return false; }
		edgeMap.put(e, edge);
		dispatchEvent(scope, new GraphEvent(scope, this, this, e, null, GraphEventType.EDGE_ADDED));
		return true;
	}

	/**
	 * Inits the.
	 *
	 * @param scope
	 *            the scope
	 * @param edges
	 *            the edges
	 * @param vertices
	 *            the vertices
	 */
	protected void init(final IScope scope, final IContainer edges, final IContainer vertices) {
		this.directed = true;
		edgeBased = true;
		vertexRelation = null;
		edgeSpecies = null;
		agentEdge = true;
		buildByEdgeWithNode(scope, edges, vertices);
		version = 1;
	}

	/**
	 * Method getSpecies(): returns the species of the edges if any.
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#getSpecies()
	 */
	@Override
	public ISpecies getSpecies() { return getEdgeSpecies(); }

	@Override
	public IPopulation<? extends IAgent> getPopulation(final IScope scope) {
		return getScope().getSimulation().getPopulationFor(getSpecies());
		// return null;// See if we can identify the populations of edges / vertices
	}

	/**
	 * Method getAgents()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#getAgents()
	 */
	@Override
	public IContainer<?, ? extends IAgent> getAgents(final IScope scope) {
		return getEdges();
	}

	@Override
	public boolean hasAgentList() {
		return true;
	}

	/**
	 * Method accept()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#accept(gama.runtime.IScope, gama.metamodel.shape.IShape,
	 *      gama.metamodel.shape.IShape)
	 */
	@Override
	public boolean accept(final IScope scope, final IShape source, final IShape a) {
		return a.getGeometry() != source.getGeometry() && containsEdge(a);
	}

	/**
	 * Method filter()
	 *
	 * @see gama.metamodel.topology.filter.IAgentFilter#filter(gama.runtime.IScope, gama.metamodel.shape.IShape,
	 *      java.util.Collection)
	 */
	@Override
	public void filter(final IScope scope, final IShape source, final Collection<? extends IShape> results) {
		results.removeIf(each -> !edgeMap.containsKey(each));
	}

	/**
	 * Gets the tolerance.
	 *
	 * @return the tolerance
	 */
	public double getTolerance() { return tolerance; }

	/**
	 * Sets the tolerance.
	 *
	 * @param tolerance
	 *            the new tolerance
	 */
	public void setTolerance(final double tolerance) { this.tolerance = tolerance; }

}
