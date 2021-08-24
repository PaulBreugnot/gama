/*******************************************************************************************************
 *
 * Storeable.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * This interface defines the methods supporting custom serialisation. This custom serialisation provides performance
 * improvements over default java serialisation at the expense of having to be supported explicitly by classes.
 *
 * @author Brett Henderson
 */
public interface Storeable {
	/**
	 * Stores all state to the specified store writer.
	 *
	 * @param writer
	 *            The writer that persists data to an underlying store.
	 * @param storeClassRegister
	 *            Maintains the mapping between classes and their identifiers within the store.
	 */
	void store(StoreWriter writer, StoreClassRegister storeClassRegister);
}
