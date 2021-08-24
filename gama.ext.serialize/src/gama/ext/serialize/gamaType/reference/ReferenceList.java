/*******************************************************************************************************
 *
 * ReferenceList.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reference;

import java.util.ArrayList;

import gama.ext.serialize.gamaType.reduced.GamaListReducer;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.util.GamaList;
import gama.util.IReference;

/**
 * The Class ReferenceList.
 */
public class ReferenceList extends GamaList implements IReference {

	/** The agt attr. */
	ArrayList<AgentAttribute> agtAttr;
	
	/** The list reducer. */
	GamaListReducer listReducer;
	
	/**
	 * Instantiates a new reference list.
	 *
	 * @param l the l
	 */
	public ReferenceList(GamaListReducer l) {
		super(l.getValuesListReducer().size(), l.getContentTypeListReducer());
		agtAttr = new ArrayList<AgentAttribute>();		
		listReducer = l;
	}

	public Object constructReferencedObject(SimulationAgent sim) {

		listReducer.unreferenceReducer(sim);
		return listReducer.constructObject(sim.getScope());	
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
