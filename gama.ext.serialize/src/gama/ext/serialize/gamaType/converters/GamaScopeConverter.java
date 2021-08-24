/*******************************************************************************************************
 *
 * GamaScopeConverter.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.dev.utils.DEBUG;
import gama.kernel.experiment.ExperimentAgent;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;

/**
 * The Class GamaScopeConverter.
 */
public class GamaScopeConverter implements Converter {

	@Override
	public boolean canConvert(final Class arg0) {
		if (ExperimentAgent.ExperimentAgentScope.class.equals(arg0)) { return true; }

		final Class<?>[] allInterface = arg0.getInterfaces();
		for (final Class<?> c : allInterface) {
			if (c.equals(IScope.class)) { return true; }
		}
		return false;
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		final IScope scope = (IScope) arg0;
		writer.startNode("IScope");
		writer.setValue(scope.getName().toString());
		writer.endNode();

		// The experiment ???

		writer.startNode("Simulations");
		final ExperimentAgent expAgt = (ExperimentAgent) scope.getExperiment();
		// The model / global
		// IModel model = expAgt.getModel();
		// Collection<IVariable> vars = model.getVars();

		// SimulationPopulation simPop = expAgt.getSimulationPopulation();

		for (final IAgent agt : expAgt.getSimulationPopulation()) {
			// Each simulation
			// SimulationAgent simAgt = (SimulationAgent) agt;
			// System.out.println("ConvertAnother : ScopeConverter " + agt.getClass());
			DEBUG.OUT("ConvertAnother : ScopeConverter " + agt.getClass());
			context.convertAnother(agt);
		}

		writer.endNode();
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		reader.moveDown();
		final String res = reader.getValue();
		reader.moveUp();

		return res;
	}

}
