/*******************************************************************************************************
 *
 * EntityType.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * An enum representing the different data types in the OSM data model.
 *
 * @author Brett Henderson
 */
public enum EntityType {
	/**
	 * Representation of the latitude/longitude bounding box of the entity stream.
	 */
	Bound,

	/**
	 * Represents a geographical point.
	 */
	Node,

	/**
	 * Represents a set of segments forming a path.
	 */
	Way,

	/**
	 * Represents a relationship between multiple entities.
	 */
	Relation
}
