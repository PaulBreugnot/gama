/*******************************************************************************************************
 *
 * GamaSpeciesConverter.java, in ummisco.gama.serialize, is part of the source code of the
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
import msi.gaml.species.AbstractSpecies;
import msi.gaml.species.GamlSpecies;
import ummisco.gama.dev.utils.DEBUG;

/**
 * The Class GamaSpeciesConverter.
 */
@SuppressWarnings ({ "unchecked" })
public class GamaSpeciesConverter implements Converter {
	
	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama species converter.
	 *
	 * @param s the s
	 */
	public GamaSpeciesConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		return GamlSpecies.class.equals(arg0) || AbstractSpecies.class.equals(arg0.getSuperclass());
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		// System.out.println("ConvertAnother : ConvertGamaSpecies " + arg0.getClass());
		DEBUG.OUT("ConvertAnother : ConvertGamaSpecies " + arg0.getClass());
		final AbstractSpecies spec = (AbstractSpecies) arg0;
		final GamaPopulation<? extends IAgent> pop =
				(GamaPopulation<? extends IAgent>) spec.getPopulation(convertScope.getScope());

		writer.startNode("agentSetFromPopulation");
		context.convertAnother(pop.getAgents(convertScope.getScope()));
		writer.endNode();

		// System.out.println("===========END ConvertAnother : ConvertGamaSpecies");
		DEBUG.OUT("===========END ConvertAnother : ConvertGamaSpecies");
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext context) {

		reader.moveDown();
		final IList<IAgent> listAgetFromPopulation = (IList<IAgent>) context.convertAnother(null, IList.class);
		reader.moveUp();

		return listAgetFromPopulation;
	}

}
