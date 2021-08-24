/*******************************************************************************************************
 *
 * GamaPairConverter.java, in gama.ext.serialize, is part of the source code of the
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
import gama.ext.serialize.gamaType.reduced.GamaPairReducer;
import gama.util.GamaPair;

/**
 * The Class GamaPairConverter.
 */
@SuppressWarnings({ "rawtypes" })
public class GamaPairConverter implements Converter {

	@Override
	public boolean canConvert(final Class arg0) {
		if (GamaPair.class.equals(arg0)) {
			return true;
		}

		final Class<?>[] allInterface = arg0.getInterfaces();
		for (final Class<?> c : allInterface) {
			if (c.equals(GamaPair.class))
				return true;
		}
		return false;
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter arg1, final MarshallingContext arg2) {
		final GamaPair mp = (GamaPair) arg0;
	//	System.out.println("ConvertAnother : GamaPair " + mp.getClass());
		DEBUG.OUT("ConvertAnother : GamaPair " + mp.getClass());
		arg2.convertAnother(new GamaPairReducer(mp));
	//	System.out.println("END -- ConvertAnother : GamaPair " + mp.getClass());
		DEBUG.OUT("END -- ConvertAnother : GamaPair " + mp.getClass());
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		// reader.moveDown();
		final GamaPairReducer rmt = (GamaPairReducer) arg1.convertAnother(null, GamaPairReducer.class);
		// reader.moveUp();
		return rmt.constructObject();
	}

}
