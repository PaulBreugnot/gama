package gama.ext.serialize.gamaType.reference;

import java.util.ArrayList;

import gama.ext.serialize.gamaType.reduced.GamaListReducer;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.util.GamaList;
import gama.util.IReference;

public class ReferenceList extends GamaList implements IReference {

	ArrayList<AgentAttribute> agtAttr;
	
	GamaListReducer listReducer;
	
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
