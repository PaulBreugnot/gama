/*******************************************************************************************************
 *
 * MemberTypeParser.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses the xml representation of a relation member type into an entity type object.
 *
 * @author Brett Henderson
 */
public class MemberTypeParser {

	/** The Constant MEMBER_TYPE_MAP. */
	private static final Map<String, EntityType> MEMBER_TYPE_MAP = new HashMap<>();

	static {
		MEMBER_TYPE_MAP.put("node", EntityType.Node);
		MEMBER_TYPE_MAP.put("way", EntityType.Way);
		MEMBER_TYPE_MAP.put("relation", EntityType.Relation);
	}

	/**
	 * Parses the database representation of a relation member type into an entity type object.
	 *
	 * @param memberType
	 *            The database value of member type.
	 * @return A strongly typed entity type.
	 */
	public EntityType parse(final String memberType) {
		if (MEMBER_TYPE_MAP.containsKey(memberType)) {
			return MEMBER_TYPE_MAP.get(memberType);
		} else {
			throw new OsmosisRuntimeException("The member type " + memberType + " is not recognised.");
		}
	}
}
