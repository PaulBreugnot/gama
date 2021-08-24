/*******************************************************************************************************
 *
 * XmlConstants.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Defines some common constants shared between various xml processing classes.
 *
 * @author Brett Henderson
 */
public final class XmlConstants {

	/**
	 * The origin attribute.
	 */
	public static final String ATTRIBUTE_NAME_ORIGIN = "origin";

	/**
	 * The minlat attribute.
	 */
	public static final String ATTRIBUTE_NAME_MINLAT = "minlat";

	/**
	 * The maxlat attribute.
	 */
	public static final String ATTRIBUTE_NAME_MAXLAT = "maxlat";

	/**
	 * The minlon attribute.
	 */
	public static final String ATTRIBUTE_NAME_MINLON = "minlon";

	/**
	 * The maxlon attribute.
	 */
	public static final String ATTRIBUTE_NAME_MAXLON = "maxlon";

	/**
	 * This class cannot be instantiated.
	 */
	private XmlConstants() {}

	/**
	 * Defines the version number to be stored in osm xml files. This number will also be applied to osmChange files.
	 */
	public static final String OSM_VERSION = "0.6";

	/**
	 * The default URL for the production API.
	 */
	public static final String DEFAULT_URL = "http://www.openstreetmap.org/api/0.6";
}
