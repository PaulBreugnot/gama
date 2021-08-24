/*******************************************************************************************************
 *
 * IntAsChar.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Contains utility methods supporting storage of ints as chars.
 *
 * @author Brett Henderson
 */
public final class IntAsChar {

	/**
	 * This class cannot be constructed.
	 */
	private IntAsChar() {
		// Do nothing.
	}

	/**
	 * Converts the specified int to an char and verifies that it is legal.
	 *
	 * @param value
	 *            The identifier to be converted.
	 * @return The integer representation of the id.
	 */
	public static char intToChar(final int value) {
		// Verify that the bit can be safely cast to an integer.
		if (value > Character.MAX_VALUE) {
			throw new OsmosisRuntimeException("Cannot represent " + value + " as a char.");
		}
		if (value < Character.MIN_VALUE) {
			throw new OsmosisRuntimeException("Cannot represent " + value + " as a char.");
		}

		return (char) value;
	}
}
