/*******************************************************************************************************
 *
 * LongAsInt.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Contains utility methods supporting storage of longs as integers. This is only useful while OSM ids remain below
 * Integer.MAX_VALUE.
 *
 * @author Brett Henderson
 */
public final class LongAsInt {

	/**
	 * This class cannot be constructed.
	 */
	private LongAsInt() {
		// Do nothing.
	}

	/**
	 * Converts the specified long to an int and verifies that it is legal.
	 *
	 * @param value
	 *            The identifier to be converted.
	 * @return The integer representation of the id.
	 */
	public static int longToInt(final long value) {
		// Verify that the value can be safely cast to an integer.
		if (value > Integer.MAX_VALUE) {
			throw new OsmosisRuntimeException("Cannot represent " + value + " as an integer.");
		}
		if (value < Integer.MIN_VALUE) {
			throw new OsmosisRuntimeException("Cannot represent " + value + " as an integer.");
		}

		return (int) value;
	}
}
