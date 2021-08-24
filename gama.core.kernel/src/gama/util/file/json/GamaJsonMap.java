/*******************************************************************************************************
 *
 * GamaJsonMap.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file.json;

import java.util.Iterator;
import java.util.Map;

import gama.util.GamaMap;
import gaml.types.Types;

/**
 * GamaJsonMap is a GAMA compatible implementation of a json object.
 *
 * @author A. Drogoul, adapted from json-simple library
 */
@SuppressWarnings ("unchecked")
public class GamaJsonMap extends GamaMap<String, Object> implements Jsonable {

	/**
	 * Instantiates a new gama json map.
	 */
	public GamaJsonMap() {
		super(0, Types.STRING, Types.NO_TYPE);
	}

	@Override
	public String toJson() {
		final StringBuilder writable = new StringBuilder();
		boolean isFirstEntry = true;
		final Iterator<Map.Entry<String, Object>> entries = this.entrySet().iterator();
		writable.append('{');
		while (entries.hasNext()) {
			if (isFirstEntry) {
				isFirstEntry = false;
			} else {
				writable.append(',');
			}
			final Map.Entry<String, Object> entry = entries.next();
			writable.append(Jsoner.serialize(entry.getKey())).append(':').append(Jsoner.serialize(entry.getValue()));
		}
		writable.append('}');
		return writable.toString();
	}
}
