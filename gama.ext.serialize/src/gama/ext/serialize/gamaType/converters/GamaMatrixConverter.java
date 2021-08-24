/*******************************************************************************************************
 *
 * GamaMatrixConverter.java, in gama.ext.serialize, is part of the source code of the
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
import gama.ext.serialize.gamaType.reduced.GamaMatrixReducer;
import gama.util.matrix.GamaMatrix;
import gama.util.matrix.IMatrix;

/**
 * The Class GamaMatrixConverter.
 */
@SuppressWarnings({ "rawtypes" })
public class GamaMatrixConverter implements Converter {

	/** The convert scope. */
	ConverterScope convertScope;

	/**
	 * Instantiates a new gama matrix converter.
	 *
	 * @param s the s
	 */
	public GamaMatrixConverter(final ConverterScope s) {
		convertScope = s;
	}

	@Override
	public boolean canConvert(final Class arg0) {
		final List allInterfaceApa = ClassUtils.getAllInterfaces(arg0);

		for (final Object i : allInterfaceApa) {
			if (i.equals(IMatrix.class))
				return true;
		}
		return false;
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		final GamaMatrix mat = (GamaMatrix) arg0;

	//	System.out.println("ConvertAnother : GamaMatrix " + mat.getClass());
		DEBUG.OUT("ConvertAnother : GamaMatrix " + mat.getClass());
		context.convertAnother(new GamaMatrixReducer(convertScope.getScope(), mat));
	//	System.out.println("END --- ConvertAnother : GamaMatrix ");
		DEBUG.OUT("END --- ConvertAnother : GamaMatrix ");

	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		final GamaMatrixReducer rmt = (GamaMatrixReducer) arg1.convertAnother(null, GamaMatrixReducer.class);
		return rmt.constructObject(convertScope.getScope());
	}

}
