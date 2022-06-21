/*******************************************************************************************************
 *
 * GamaPathConverter.java, in ummisco.gama.serialize, is part of the source code of the
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

import msi.gama.util.path.GamaPath;
import ummisco.gama.dev.utils.DEBUG;
import ummisco.gama.serializer.gamaType.reduced.GamaPathReducer;

/**
 * The Class GamaPathConverter.
 */
@SuppressWarnings({ "rawtypes" , "unchecked" })
public class GamaPathConverter implements Converter {
	
	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama path converter.
	 *
	 * @param s the s
	 */
	public GamaPathConverter(final ConverterScope s) {
		convertScope = s;
	}
	
	@Override
	public boolean canConvert(final Class arg0) {
		if (GamaPath.class.equals(arg0)) {
			return true;
		}
		
		final List<Class<?>> allClassesApa = ClassUtils.getAllSuperclasses(arg0);
		for (final Object c : allClassesApa) {
			if (c.equals(GamaPath.class))
				return true;
		}
		
		return false;
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		final GamaPath path = (GamaPath) source;
	//	System.out.println("ConvertAnother : GamaPath " + path.getClass());
		DEBUG.OUT("ConvertAnother : GamaPath " + path.getClass());
		context.convertAnother(new GamaPathReducer(path));
	//	System.out.println("END -- ConvertAnother : GamaPath " + path.getClass());		
		DEBUG.OUT("END -- ConvertAnother : GamaPath " + path.getClass());		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		// reader.moveDown();
		final GamaPathReducer rmt = (GamaPathReducer) context.convertAnother(null, GamaPathReducer.class);
		// reader.moveUp();
		return rmt.constructObject(convertScope.getScope());
	}

}
