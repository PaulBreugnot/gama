/*******************************************************************************************************
 *
 * GamaGraphConverter.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.converters;

import java.util.List;

import org.apache.commons.lang.ClassUtils;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import gama.core.dev.utils.DEBUG;
import gama.ext.serialize.gamaType.reduced.GamaGraphReducer;
import gama.util.graph.GamaGraph;
import gama.util.graph.IGraph;

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
