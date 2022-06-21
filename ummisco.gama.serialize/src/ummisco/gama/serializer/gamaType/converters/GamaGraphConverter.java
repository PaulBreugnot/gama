/*******************************************************************************************************
 *
 * GamaGraphConverter.java, in ummisco.gama.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package ummisco.gama.serializer.gamaType.converters;

import java.util.List;

import org.apache.commons.lang.ClassUtils;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import msi.gama.util.graph.GamaGraph;
import msi.gama.util.graph.IGraph;
import ummisco.gama.dev.utils.DEBUG;
import ummisco.gama.serializer.gamaType.reduced.GamaGraphReducer;

/**
 * The Class GamaGraphConverter.
 */
@SuppressWarnings({ "rawtypes" })
public class GamaGraphConverter implements Converter {

	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama graph converter.
	 *
	 * @param s the s
	 */
	public GamaGraphConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		final List allInterfaceApa = ClassUtils.getAllInterfaces(arg0);

		for (final Object i : allInterfaceApa) {
			if (i.equals(IGraph.class))
				return true;
		}
		return false;
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext arg2) {
		final GamaGraph graph = (GamaGraph) arg0;

	//	System.out.println("ConvertAnother : GamaList " + graph.getClass());
		DEBUG.OUT("ConvertAnother : GamaList " + graph.getClass());
		arg2.convertAnother(new GamaGraphReducer(convertScope.getScope(), graph));
	//	System.out.println("END --- ConvertAnother : GamaList ");
		DEBUG.OUT("END --- ConvertAnother : GamaList ");
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		final GamaGraphReducer rmt = (GamaGraphReducer) arg1.convertAnother(null, GamaGraphReducer.class);
		return rmt.constructObject(convertScope.getScope());
	}

}
