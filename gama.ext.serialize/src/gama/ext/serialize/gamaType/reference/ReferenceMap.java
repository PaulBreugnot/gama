/*******************************************************************************************************
 *
 * ReferenceMap.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reference;

import java.util.ArrayList;

import gama.ext.serialize.gamaType.reduced.GamaMapReducer;
import gama.kernel.simulation.SimulationAgent;
import gama.util.GamaMap;
import gama.util.IReference;

/**
 * The Class ReferenceMap.
 */
public class ReferenceMap extends GamaMap implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The map reducer. */
	GamaMapReducer mapReducer;

	/**
	 * Instantiates a new reference map.
	 *
	 * @param m the m
	 */
	public ReferenceMap(final GamaMapReducer m) {
		super(m.getValues().size(), m.getKeysType(), m.getDataType());
		agtAttr = new ArrayList<>();
		mapReducer = m;
	}

	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {
		mapReducer.unreferenceReducer(sim);
		return mapReducer.constructObject(sim.getScope());
	}

	@Override
	public ArrayList<AgentAttribute> getAgentAttributes() {
		return agtAttr;
	}

	@Override
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else {
			return false;
		}
	}
}
