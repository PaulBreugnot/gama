/*******************************************************************************************************
 *
 * GamaListConverter.java, in gama.ext.serialize, is part of the source code of the
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
import gama.ext.serialize.gamaType.reduced.GamaListReducer;
import gama.util.IList;

/**
 * The Class GamaListConverter.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaListConverter implements Converter {

	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama list converter.
	 *
	 * @param s the s
	 */
	public GamaListConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		return IList.class.isAssignableFrom(arg0); // ??
		// if (GamaList.class.equals(arg0)) {
		// return true;
		// }
		//
		// final Class<?>[] allInterface = arg0.getInterfaces();
		// for (final Class<?> c : allInterface) {
		// if (c.equals(GamaList.class))
		// return true;
		// }
		// return false;
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext arg2) {
		final IList list = (IList) arg0;

		// System.out.println("ConvertAnother : GamaList " + list.getClass()+ " "+list.getGamlType().getContentType());
		DEBUG.OUT("ConvertAnother : IList " + list.getClass() + " " + list.getGamlType().getContentType());
		arg2.convertAnother(new GamaListReducer(list));
		// System.out.println("END --- ConvertAnother : GamaList ");
		DEBUG.OUT("END --- ConvertAnother : GamaList ");

	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		// reader.moveDown();
		final GamaListReducer rmt = (GamaListReducer) arg1.convertAnother(null, GamaListReducer.class);
		// reader.moveUp();
		return rmt.constructObject(convertScope.getScope());
	}

}
