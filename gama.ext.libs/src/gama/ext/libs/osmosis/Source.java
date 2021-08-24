/*******************************************************************************************************
 *
 * Source.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Defines the interface for tasks producing OSM data types.
 *
 * @author Brett Henderson
 */
public interface Source {

	/**
	 * Sets the osm sink to send data to.
	 *
	 * @param sink
	 *            The sink for receiving all produced data.
	 */
	void setSink(Sink sink);
}
