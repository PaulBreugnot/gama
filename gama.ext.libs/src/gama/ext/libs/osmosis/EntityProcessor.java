/*******************************************************************************************************
 *
 * EntityProcessor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * EntityContainer implementations call implementations of this class to perform entity type specific processing.
 *
 * @author Brett Henderson
 */
public interface EntityProcessor {

	/**
	 * Process the bound.
	 *
	 * @param bound
	 *            The bound to be processed.
	 */
	void process(BoundContainer bound);

	/**
	 * Process the node.
	 *
	 * @param node
	 *            The node to be processed.
	 */
	void process(NodeContainer node);

	/**
	 * Process the way.
	 *
	 * @param way
	 *            The way to be processed.
	 */
	void process(WayContainer way);

	/**
	 * Process the relation.
	 *
	 * @param relation
	 *            The relation to be processed.
	 */
	void process(RelationContainer relation);
}
