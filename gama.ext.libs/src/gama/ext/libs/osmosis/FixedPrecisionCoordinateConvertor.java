/*******************************************************************************************************
 *
 * FixedPrecisionCoordinateConvertor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Converts a double coordinate value into an equivalent integer with fixed precision.
 *
 * @author Brett Henderson
 */
public final class FixedPrecisionCoordinateConvertor {
	
	/** The Constant PRECISION. */
	private static final int PRECISION = 7;
	
	/** The Constant MULTIPLICATION_FACTOR. */
	private static final int MULTIPLICATION_FACTOR = calculateMultiplicationFactor();

	/**
	 * This class cannot be instantiated.
	 */
	private FixedPrecisionCoordinateConvertor() {
		// Do nothing.
	}

	/**
	 * Generates the multiplication factor that the double coordinate must be multiplied by to turn it into a fixed
	 * precision integer.
	 *
	 * @return The double to fixed multiplication factor.
	 */
	private static int calculateMultiplicationFactor() {
		int result;

		result = 1;

		for (int i = 0; i < PRECISION; i++) {
			result *= 10;
		}

		return result;
	}

	/**
	 * Converts the requested coordinate from double to fixed precision.
	 *
	 * @param coordinate
	 *            The double coordinate value.
	 * @return The fixed coordinate value.
	 */
	public static int convertToFixed(final double coordinate) {
		int result;

		result = (int) Math.round(coordinate * MULTIPLICATION_FACTOR);

		return result;
	}

	/**
	 * Converts the requested coordinate from fixed to double precision.
	 *
	 * @param coordinate
	 *            The fixed coordinate value.
	 * @return The double coordinate value.
	 */
	public static double convertToDouble(final int coordinate) {
		double result;

		result = (double) coordinate / MULTIPLICATION_FACTOR;

		return result;
	}
}
