/*******************************************************************************************************
 *
 * StoreWriter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Implementations of this interface are used by Storeable classes to persist their state.
 *
 * @author Brett Henderson
 */
public interface StoreWriter {
	/**
	 * Writes a boolean to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeBoolean(boolean value);

	/**
	 * Writes a byte to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeByte(byte value);

	/**
	 * Writes a character to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeCharacter(char value);

	/**
	 * Writes an integer to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeInteger(int value);

	/**
	 * Writes a long to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeLong(long value);

	/**
	 * Writes a double to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeDouble(double value);

	/**
	 * Writes a String to storage.
	 *
	 * @param value
	 *            The value to be written.
	 */
	void writeString(String value);
}
