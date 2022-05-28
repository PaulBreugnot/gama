/*******************************************************************************************************
 *
 * GamaAgentConverter.java, in ummisco.gama.serialize, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package ummisco.gama.serializer.gamaType.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import msi.gama.metamodel.agent.IAgent;
import msi.gama.runtime.IScope;
import ummisco.gama.dev.utils.DEBUG;
import ummisco.gama.serializer.gamaType.reference.ReferenceAgent;

/**
 * The Class GamaAgentConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaAgentConverter extends AbstractGamaConverter<IAgent, IAgent> {

	/**
	 * Instantiates a new gama agent converter.
	 *
	 * @param target
	 *            the target
	 */
	public GamaAgentConverter(final Class<IAgent> target) {
		super(target);
	}

	@Override
	public boolean canConvert(final Class clazz) {
		if (ReferenceAgent.class.equals(clazz)) return false;
		return super.canConvert(clazz);
	}

	@Override
	public void write(IScope scope, final IAgent agt, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		writer.startNode("agentReference");
		DEBUG.OUT("ConvertAnother : AgentConverter " + agt.getClass());
		final ReferenceAgent refAft = new ReferenceAgent(null, null, agt);
		context.convertAnother(refAft);
		DEBUG.OUT("===========END ConvertAnother : GamaAgent");
		writer.endNode();
	}

	@Override
	public IAgent read(IScope scope, final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		// TODO manage MinimalAgent and MinimalGridAgent
		reader.moveDown();
		final ReferenceAgent agt = (ReferenceAgent) arg1.convertAnother(null, ReferenceAgent.class);
		reader.moveUp();
		return agt;
	}

}
