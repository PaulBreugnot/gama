/*******************************************************************************************************
 *
 * RelationMemberListener.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Provides the definition of a class receiving relation members.
 *
 * @author Brett Henderson
 */
public interface RelationMemberListener {
	/**
	 * Processes the relation member.
	 *
	 * @param relationMember
	 *            The relation member.
	 */
	void processRelationMember(RelationMember relationMember);
}
