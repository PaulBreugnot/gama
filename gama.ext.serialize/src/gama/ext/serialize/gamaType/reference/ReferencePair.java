/*******************************************************************************************************
 *
 * ReferencePair.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reference;

import java.util.ArrayList;

import gama.ext.serialize.gamaType.reduced.GamaPairReducer;
import gama.kernel.simulation.SimulationAgent;
import gama.util.GamaPair;
import gama.util.IReference;
import gaml.types.Types;

/**
 * The Class ReferencePair.
 */
public class ReferencePair extends GamaPair<Object, Object> implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;

	/** The pair reducer. */
	GamaPairReducer pairReducer;

	/**
	 * Instantiates a new reference pair.
	 *
	 * @param p the p
	 */
	public ReferencePair(final GamaPairReducer p) {
		super(null, null, Types.NO_TYPE, Types.NO_TYPE);
		agtAttr = new ArrayList<>();
		pairReducer = p;
	}

	/**
	 * Gets the pair reducer.
	 *
	 * @return the pair reducer
	 */
	public GamaPairReducer getPairReducer() {
		return pairReducer;
	}

	@Override
	public Object constructReferencedObject(final SimulationAgent sim) {
		pairReducer.unreferenceReducer(sim);
		return pairReducer.constructObject();
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
