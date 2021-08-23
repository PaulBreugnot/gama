package gama.ext.serialize.gamaType.reduced;

import gama.ext.serialize.gamaType.reference.ReferencePath;
import gama.kernel.simulation.SimulationAgent;
import gama.runtime.IScope;
import gama.util.IList;
import gama.util.IReference;
import gama.util.graph.IGraph;
import gama.util.path.GamaPath;
import gama.util.path.PathFactory;

public class GamaPathReducer {

	IGraph<Object, Object> g;
	Object start;
	Object target;
	IList<Object> edges;

	public GamaPathReducer(final GamaPath p) {
		g = p.getGraph();
		start = p.getStartVertex();
		target = p.getEndVertex();
		edges = p.getEdgeList();
	}

	@SuppressWarnings ("unchecked")
	public void unreferenceReducer(final SimulationAgent sim) {
		g = (IGraph) IReference.getObjectWithoutReference(g, sim);
		start = IReference.getObjectWithoutReference(start, sim);
		target = IReference.getObjectWithoutReference(target, sim);
		edges = (IList) IReference.getObjectWithoutReference(edges, sim);
	}

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
