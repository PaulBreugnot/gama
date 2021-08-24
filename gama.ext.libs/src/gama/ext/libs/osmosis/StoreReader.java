/*******************************************************************************************************
 *
 * StoreReader.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Implementations of this interface are used by Storeable classes to load their state.
 *
 * @author Brett Henderson
 */
public interface StoreReader {

	/**
	 * Reads a boolean from storage.
	 *
	 * @return The loaded value.
	 */
	boolean readBoolean();

	/**
	 * Reads a byte from storage.
	 *
	 * @return The loaded value.
	 */
	byte readByte();

	/**
	 * Reads a character from storage.
	 *
	 * @return The loaded value.
	 */
	char readCharacter();

	/**
	 * Reads an integer from storage.
	 *
	 * @return The loaded value.
	 */
	int readInteger();

	/**
	 * Reads a long from storage.
	 *
	 * @return The loaded value.
	 */
	long readLong();

	/**
	 * Reads a double from storage.
	 *
	 * @return The loaded value.
	 */
	double readDouble();

	/**
	 * Reads a String from storage.
	 *
	 * @return The loaded value.
	 */
	String readString();
}
