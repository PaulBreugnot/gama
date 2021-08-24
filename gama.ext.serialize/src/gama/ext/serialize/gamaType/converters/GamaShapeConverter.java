/*******************************************************************************************************
 *
 * GamaShapeConverter.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.converters;

import com.thoughtworks.xstream.converters.*;
import com.thoughtworks.xstream.io.*;

import gama.core.dev.utils.DEBUG;
import gama.metamodel.shape.GamaShape;

/**
 * The Class GamaShapeConverter.
 */
public class GamaShapeConverter implements Converter {

	@Override
	public boolean canConvert(final Class arg0) {
		return (arg0.equals(GamaShape.class));
	}

	@Override
	public void marshal(final Object arg0, final HierarchicalStreamWriter writer, final MarshallingContext context) {
		GamaShape agt = (GamaShape) arg0;		
	//	System.out.println("ConvertAnother : AgentConverter " + agt.getClass());		
		DEBUG.OUT("ConvertAnother : AgentConverter " + agt.getClass());		
	// 	context.convertAnother(agt);
	//	System.out.println("===========END ConvertAnother : GamaShape");		
		DEBUG.OUT("===========END ConvertAnother : GamaShape");		
	}

	@Override
	public Object unmarshal(final HierarchicalStreamReader reader, final UnmarshallingContext arg1) {
		GamaShape rmt = (GamaShape) arg1.convertAnother(null, GamaShape.class);
		return rmt; // ragt;
	}

}
