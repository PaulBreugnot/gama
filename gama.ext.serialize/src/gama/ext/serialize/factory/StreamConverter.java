/*******************************************************************************************************
 *
 * StreamConverter.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.factory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import gama.core.application.bundles.GamaClassLoader;
import gama.ext.serialize.gamaType.converters.ConverterScope;
import gama.runtime.IScope;

/**
 * The Class StreamConverter.
 */
public abstract class StreamConverter {

	/**
	 * Register converter.
	 *
	 * @param dataStreamer the data streamer
	 * @param c the c
	 */
	public static void registerConverter(final XStream dataStreamer, final Converter c) {
		dataStreamer.registerConverter(c);
	}

	/**
	 * Load and build.
	 *
	 * @param cs the cs
	 * @return the x stream
	 */
	public static XStream loadAndBuild(final ConverterScope cs) {
		final XStream dataStreamer = new XStream(new DomDriver());
		dataStreamer.setClassLoader(GamaClassLoader.getInstance());

		final Converter[] cnv = Converters.converterFactory(cs);
		for (final Converter c : cnv) {
			StreamConverter.registerConverter(dataStreamer, c);
		}
		// dataStreamer.setMode(XStream.ID_REFERENCES);
		return dataStreamer;
	}

	/**
	 * Convert object to stream.
	 *
	 * @param scope the scope
	 * @param o the o
	 * @return the string
	 */
	public static synchronized String convertObjectToStream(final IScope scope, final Object o) {
		return loadAndBuild(new ConverterScope(scope)).toXML(o);
	}

	/**
	 * Convert object to stream.
	 *
	 * @param scope the scope
	 * @param o the o
	 * @return the string
	 */
	public static synchronized String convertObjectToStream(final ConverterScope scope, final Object o) {
		return loadAndBuild(scope).toXML(o);
	}

	/**
	 * Convert stream to object.
	 *
	 * @param scope the scope
	 * @param data the data
	 * @return the object
	 */
	public static Object convertStreamToObject(final IScope scope, final String data) {
		return loadAndBuild(new ConverterScope(scope)).fromXML(data);
	}

	/**
	 * Convert stream to object.
	 *
	 * @param scope the scope
	 * @param data the data
	 * @return the object
	 */
	public static Object convertStreamToObject(final ConverterScope scope, final String data) {
		return loadAndBuild(scope).fromXML(data);
	}

	/**
	 * Load and build network.
	 *
	 * @param cs the cs
	 * @return the x stream
	 */
	// TODO To remove when possible
	public static XStream loadAndBuildNetwork(final ConverterScope cs) {
		final XStream dataStreamer = new XStream(new DomDriver());
		dataStreamer.setClassLoader(GamaClassLoader.getInstance());

		final Converter[] cnv = Converters.converterNetworkFactory(cs);
		for (final Converter c : cnv) {
			StreamConverter.registerConverter(dataStreamer, c);
		}
		return dataStreamer;
	}

	/**
	 * Convert network object to stream.
	 *
	 * @param scope the scope
	 * @param o the o
	 * @return the string
	 */
	public static synchronized String convertNetworkObjectToStream(final ConverterScope scope, final Object o) {
		return loadAndBuildNetwork(scope).toXML(o);
	}

	/**
	 * Convert network object to stream.
	 *
	 * @param scope the scope
	 * @param o the o
	 * @return the string
	 */
	public static synchronized String convertNetworkObjectToStream(final IScope scope, final Object o) {
		return loadAndBuildNetwork(new ConverterScope(scope)).toXML(o);
	}

	/**
	 * Convert network stream to object.
	 *
	 * @param scope the scope
	 * @param data the data
	 * @return the object
	 */
	public static Object convertNetworkStreamToObject(final ConverterScope scope, final String data) {
		return loadAndBuildNetwork(scope).fromXML(data);
	}

	/**
	 * Convert network stream to object.
	 *
	 * @param scope the scope
	 * @param data the data
	 * @return the object
	 */
	public static Object convertNetworkStreamToObject(final IScope scope, final String data) {
		return loadAndBuildNetwork(new ConverterScope(scope)).fromXML(data);
	}

	// END TODO
}
