/*******************************************************************************************************
 *
 * ReferencePath.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reference;

import java.util.ArrayList;

import gama.ext.serialize.gamaType.reduced.GamaPathReducer;
import gama.kernel.simulation.SimulationAgent;
import gama.util.IReference;
import gama.util.path.GamaPath;

/**
 * The Class ReferencePath.
 */
public class ReferencePath extends GamaPath implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;
	
	/** The path reducer. */
	GamaPathReducer pathReducer;

	/**
	 * Instantiates a new reference path.
	 *
	 * @param p the p
	 */
	public ReferencePath(GamaPathReducer p) {
		super();
		agtAttr = new ArrayList<AgentAttribute>();		
		pathReducer = p;
	}	

	@Override
	public Object constructReferencedObject(SimulationAgent sim) {
		pathReducer.unreferenceReducer(sim);
		return pathReducer.constructObject(sim.getScope());
	}	
	
	@Override
	public ArrayList<AgentAttribute> getAgentAttributes() {
		return agtAttr;
	}	

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else
        	return false;
    }
}
