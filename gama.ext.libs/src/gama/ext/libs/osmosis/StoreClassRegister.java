/*******************************************************************************************************
 *
 * StoreClassRegister.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Writes class identifiers to a store allowing the class to be identified when the store data is being read back again.
 * This provides the basis for multiple classes to be written to a single store location.
 */
public interface StoreClassRegister {

	/**
	 * Stores the unique identifier for the specified class to the store.
	 *
	 * @param storeWriter
	 *            The store to write class identification data to.
	 * @param clazz
	 *            The class for which an identifier is required.
	 */
	void storeIdentifierForClass(StoreWriter storeWriter, Class<?> clazz);

	/**
	 * Returns the class associated with the unique identifier in the store. An exception will be thrown if the
	 * identifier is not recognised.
	 *
	 * @param storeReader
	 *            The store to read class identification information from.
	 * @return The class associated with the identifier.
	 */
	Class<?> getClassFromIdentifier(StoreReader storeReader);
}
