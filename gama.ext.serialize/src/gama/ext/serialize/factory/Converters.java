/*******************************************************************************************************
 *
 * Converters.java, in gama.ext.serialize, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ext.serialize.factory;

import com.thoughtworks.xstream.converters.Converter;

import gama.ext.serialize.gamaType.converters.ConverterScope;
import gama.ext.serialize.gamaType.converters.GamaAgentConverter;
import gama.ext.serialize.gamaType.converters.GamaAgentConverterNetwork;
import gama.ext.serialize.gamaType.converters.GamaBDIPlanConverter;
import gama.ext.serialize.gamaType.converters.GamaBasicTypeConverter;
import gama.ext.serialize.gamaType.converters.GamaFileConverter;
import gama.ext.serialize.gamaType.converters.GamaGraphConverter;
import gama.ext.serialize.gamaType.converters.GamaListConverter;
import gama.ext.serialize.gamaType.converters.GamaListConverterNetwork;
import gama.ext.serialize.gamaType.converters.GamaMapConverter;
import gama.ext.serialize.gamaType.converters.GamaMatrixConverter;
import gama.ext.serialize.gamaType.converters.GamaPairConverter;
import gama.ext.serialize.gamaType.converters.GamaPathConverter;
import gama.ext.serialize.gamaType.converters.GamaPopulationConverter;
import gama.ext.serialize.gamaType.converters.GamaSpeciesConverter;
import gama.ext.serialize.gamaType.converters.LogConverter;
import gama.ext.serialize.gamaType.converters.ReferenceAgentConverter;
import gama.ext.serialize.gamaType.converters.SavedAgentConverter;
import one.util.streamex.StreamEx;

/**
 * The Class Converters.
 */
public abstract class Converters {

	/**
	 * Load converter.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	private static Converter[] loadConverter(final ConverterScope cs) {
		return StreamEx.of(new GamaBasicTypeConverter(cs), new GamaAgentConverter(cs), new GamaListConverter(cs),
				new GamaMapConverter(cs), new GamaPairConverter(), new GamaMatrixConverter(cs),
				new GamaGraphConverter(cs), new GamaFileConverter(cs), new LogConverter(),
				new GamaPopulationConverter(cs), new GamaSpeciesConverter(cs), new ReferenceAgentConverter(cs),
				new GamaPathConverter(cs), new GamaBDIPlanConverter(cs)).toArray(Converter.class);

	}

	/**
	 * Converter factory.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	public static Converter[] converterFactory(final ConverterScope cs) {
		return loadConverter(cs);
	}

	/**
	 * Load converter network.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	// TODO Remove when possible
	private static Converter[] loadConverterNetwork(final ConverterScope cs) {
		Converter[] converters = new Converter[12];
		converters[0] = new GamaBasicTypeConverter(cs);
		converters[1] = new GamaAgentConverterNetwork(cs);
		converters[2] = new GamaListConverterNetwork(cs);
		converters[3] = new GamaMapConverter(cs);
		converters[4] = new GamaPairConverter();
		converters[5] = new GamaMatrixConverter(cs);
		converters[6] = new GamaGraphConverter(cs);
		converters[7] = new GamaFileConverter(cs);

		converters[8] = new LogConverter();
		converters[9] = new SavedAgentConverter(cs);

		converters[10] = new GamaPopulationConverter(cs);
		converters[11] = new GamaSpeciesConverter(cs);
		// converters[12]= new ComplexMessageConverter(cs);

		return converters;
	}

	/**
	 * Converter network factory.
	 *
	 * @param cs
	 *            the cs
	 * @return the converter[]
	 */
	public static Converter[] converterNetworkFactory(final ConverterScope cs) {
		return loadConverterNetwork(cs);
	}

	// END TODO
}
