/*******************************************************************************************************
 *
 * GamaPopulationConverter.java, in ummisco.gama.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package ummisco.gama.serializer.gamaType.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import msi.gama.metamodel.agent.IAgent;
import msi.gama.metamodel.population.GamaPopulation;
import msi.gama.util.IList;
import ummisco.gama.dev.utils.DEBUG;

/**
 * The Class GamaPopulationConverter.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class GamaPopulationConverter implements Converter {

	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama population converter.
	 *
	 * @param s the s
	 */
	public GamaPopulationConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		// TODO management of other GamaPopulation (grid)

		// final Class sc = arg0.getSuperclass();
		// final Class<?>[] allInterface = arg0.getInterfaces();
		// for (final Class<?> c : allInterface) {
		// final Class scs = c.getSuperclass();
		// }

		// if(GamlAgent.class.equals(arg0) || MinimalAgent.class.equals(arg0) ||
		// GamlAgent.class.equals(arg0.getSuperclass())){
		// return true;
		// }
		//
		// Class<?>[] allInterface=arg0.getInterfaces();
		// for( Class<?> c:allInterface)
		// {
		// if(c.equals(GamlAgent.class))
		// return true;
		// }

		return arg0.equals(GamaPopulation.class);
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		System.out.println("ConvertAnother : GamaPopulationConverter " + arg0.getClass());
		final GamaPopulation pop = (GamaPopulation) arg0;

		writer.startNode("agentSetFromPopulation");
		context.convertAnother(pop.getAgents(convertScope.getScope()));
		writer.endNode();

		// System.out.println("===========END ConvertAnother : GamaSavedAgentConverter");
		DEBUG.OUT("===========END ConvertAnother : GamaSavedAgentConverter");
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {

		reader.moveDown();
		final IList<IAgent> listAgetFromPopulation = (IList<IAgent>) context.convertAnother(null, IList.class);
		reader.moveUp();

		return listAgetFromPopulation;
	}

}
