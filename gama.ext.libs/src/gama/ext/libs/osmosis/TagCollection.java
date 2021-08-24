/*******************************************************************************************************
 *
 * TagCollection.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Collection;
import java.util.Map;

/**
 * An extension to basic Collection behaviour adding convenience methods for working with tags.
 *
 * @author Brett Henderson
 */
public interface TagCollection extends Collection<Tag>, Storeable {
	/**
	 * Creates a map representation of the tags.
	 *
	 * @return The tags represented as a map.
	 */
	Map<String, String> buildMap();

	/**
	 * To read only.
	 *
	 * @return the tag collection
	 */
	TagCollection toReadOnly();
}
