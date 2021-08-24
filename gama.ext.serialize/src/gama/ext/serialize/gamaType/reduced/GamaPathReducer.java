/*******************************************************************************************************
 *
 * GamaPathReducer.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.ext.serialize.gamaType.reference.ReferencePath;
import gama.kernel.simulation.SimulationAgent;
import gama.runtime.IScope;
import gama.util.IList;
import gama.util.IReference;
import gama.util.graph.IGraph;
import gama.util.path.GamaPath;
import gama.util.path.PathFactory;

/**
 * The Class GamaPathReducer.
 */
public class GamaPathReducer {

	/** The g. */
	IGraph<Object, Object> g;
	
	/** The start. */
	Object start;
	
	/** The target. */
	Object target;
	
	/** The edges. */
	IList<Object> edges;

	/**
	 * Instantiates a new gama path reducer.
	 *
	 * @param p the p
	 */
	public GamaPathReducer(final GamaPath p) {
		g = p.getGraph();
		start = p.getStartVertex();
		target = p.getEndVertex();
		edges = p.getEdgeList();
	}

	/**
	 * Unreference reducer.
	 *
	 * @param sim the sim
	 */
	@SuppressWarnings ("unchecked")
	public void unreferenceReducer(final SimulationAgent sim) {
		g = (IGraph) IReference.getObjectWithoutReference(g, sim);
		start = IReference.getObjectWithoutReference(start, sim);
		target = IReference.getObjectWithoutReference(target, sim);
		edges = (IList) IReference.getObjectWithoutReference(edges, sim);
	}

	/**
	 * Construct object.
	 *
	 * @param scope the scope
	 * @return the gama path
	 */
	public GamaPath constructObject(final IScope scope) {

		GamaPath path = null;
		if (IReference.isReference(g) || IReference.isReference(start) || IReference.isReference(target)
				|| IReference.isReference(edges)) {
			path = new ReferencePath(this);
		} else {
			path = PathFactory.newInstance(g, start, target, edges);
		}
		return path;
	}
}
