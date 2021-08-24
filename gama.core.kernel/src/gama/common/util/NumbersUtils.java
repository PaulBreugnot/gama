/*******************************************************************************************************
 *
 * NumbersUtils.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.util;

/**
 * Class containing various basic utility methods to deal with numbers. This class is meant to be light (no big look-up
 * tables or such).
 *
 * Check methods return boolean if success, for it allows to use them in assertions.
 *
 * toString methods use capital letters, unlike JDK's toStrings, for it is more readable (especially, "l" and "1" can
 * easily be confused with one another).
 *
 * Some methods have an int version additionally to the long version, even though long version could be used instead,
 * for performance reasons, either for the methods themselves (if they do computations with ints instead of longs), or
 * to be used in an int use case (like methods checking whether or not a signed int can fit in such number of bits).
 */
public final class NumbersUtils {

	// --------------------------------------------------------------------------
	// MEMBERS
	// --------------------------------------------------------------------------

	/**
	 * Double.MIN_NORMAL since Java 6.
	 */
	public static final double DOUBLE_MIN_NORMAL = Double.longBitsToDouble(0x0010000000000000L); // 2.2250738585072014E-308

	/**
	 * Float.MIN_NORMAL since Java 6.
	 */
	public static final float FLOAT_MIN_NORMAL = Float.intBitsToFloat(0x00800000); // 1.17549435E-38f

	/** The Constant MIN_DOUBLE_EXPONENT. */
	private static final int MIN_DOUBLE_EXPONENT = -1074;
	
	/** The Constant MAX_DOUBLE_EXPONENT. */
	private static final int MAX_DOUBLE_EXPONENT = 1023;

	/**
	 * All possible upper case chars for representing a number as a String.
	 */
	private final static char[] CHAR_BY_DIGIT;
	static {
		final char minDecimal = '0';
		final char maxDecimal = '9';
		final int n1 = maxDecimal - minDecimal + 1;
		final char minLetter = 'A';
		final char maxLetter = 'Z';
		final int n2 = maxLetter - minLetter + 1;
		CHAR_BY_DIGIT = new char[n1 + n2];
		int i = 0;
		for (char c = minDecimal; c <= maxDecimal; c++) {
			CHAR_BY_DIGIT[i++] = c;
		}
		for (char c = minLetter; c <= maxLetter; c++) {
			CHAR_BY_DIGIT[i++] = c;
		}
	}

	/**
	 * For power-of-two radixes only.
	 */
	private static final int[] DIV_SHIFT_BY_RADIX;
	static {
		DIV_SHIFT_BY_RADIX = new int[32 + 1];
		int shift = 1;
		for (int radix = 2; radix <= 32; radix *= 2) {
			DIV_SHIFT_BY_RADIX[radix] = shift++;
		}
	}

	/** The Constant MAX_NBR_OF_NEG_INT_DIGITS_BY_RADIX. */
	private final static int[] MAX_NBR_OF_NEG_INT_DIGITS_BY_RADIX = new int[Character.MAX_RADIX + 1];
	
	/** The Constant MAX_NBR_OF_NEG_LONG_DIGITS_BY_RADIX. */
	private final static int[] MAX_NBR_OF_NEG_LONG_DIGITS_BY_RADIX = new int[Character.MAX_RADIX + 1];
	static {
		for (int radix = Character.MIN_RADIX; radix <= Character.MAX_RADIX; radix++) {
			/*
			 * Brutal but works. -1 for the sign.
			 */
			MAX_NBR_OF_NEG_INT_DIGITS_BY_RADIX[radix] = Integer.toString(Integer.MIN_VALUE, radix).length() - 1;
			MAX_NBR_OF_NEG_LONG_DIGITS_BY_RADIX[radix] = Long.toString(Long.MIN_VALUE, radix).length() - 1;
		}
	}

	/** The Constant NO_CSN_MIN_BOUND_INCL. */
	static final double NO_CSN_MIN_BOUND_INCL = 1e-3;
	
	/** The Constant NO_CSN_MAX_BOUND_EXCL. */
	static final double NO_CSN_MAX_BOUND_EXCL = 1e7;

	/** The Constant PIO2_HI. */
	private static final double PIO2_HI = Double.longBitsToDouble(0x3FF921FB54400000L); // 1.57079632673412561417e+00
																						
																						/** The Constant PIO2_LO. */
																						// first 33 bits of pi/2
	private static final double PIO2_LO = Double.longBitsToDouble(0x3DD0B4611A626331L); // 6.07710050650619224932e-11
																						
																						/** The Constant PI_HI. */
																						// pi/2 - PIO2_HI
	private static final double PI_HI = 2 * PIO2_HI;
	
	/** The Constant PI_LO. */
	private static final double PI_LO = 2 * PIO2_LO;
	
	/** The Constant TWOPI_HI. */
	private static final double TWOPI_HI = 4 * PIO2_HI;
	
	/** The Constant TWOPI_LO. */
	private static final double TWOPI_LO = 4 * PIO2_LO;

	// --------------------------------------------------------------------------
	// PUBLIC METHODS
	// --------------------------------------------------------------------------

	/**
	 * Equal.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are equal or both NaN, false otherwise.
	 */
	public static boolean equal(final float a, final float b) {
		// Only does one test if a == b.
		return a == b ? true : a != a && b != b;
	}

	/**
	 * Equal.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are equal or both NaN, false otherwise.
	 */
	public static boolean equal(final double a, final double b) {
		// Only does one test if a == b.
		return a == b ? true : a != a && b != b;
	}

	/**
	 * Checks if is mathematical integer.
	 *
	 * @param val the val
	 * @return True if the specified value is a mathematical integer, false otherwise (which includes NaN and
	 *         +-Infinity).
	 */
	public static boolean isMathematicalInteger(final float val) {
		float value = val;
		// Doing magnitude test first, for cast
		// might be very slow for huge values.
		// It also helps be faster for huge values,
		// for which the test with cast always fail.
		value = Math.abs(value);
		return value >= 1 << 23 && value != Float.POSITIVE_INFINITY || value == (int) value;
	}

	/**
	 * Checks if is mathematical integer.
	 *
	 * @param val the val
	 * @return True if the specified value is a mathematical integer, false otherwise (which includes NaN and
	 *         +-Infinity).
	 */
	public static boolean isMathematicalInteger(final double val) {
		double value = val;
		// Doing magnitude test first, for cast
		// might be very slow for huge values.
		// It also helps be faster for huge values,
		// for which the test with cast always fail.
		value = Math.abs(value);
		return value >= 1L << 52 && value != Double.POSITIVE_INFINITY || value == (long) value;
	}

	/**
	 * Checks if is equidistant.
	 *
	 * @param value            A float value.
	 * @return True if the specified value is equidistant from two adjacent mathematical integers, false otherwise
	 *         (which includes NaN and +-Infinity).
	 */
	public static boolean isEquidistant(final float value) {
		final float valueAbs = Math.abs(value);
		if (!(valueAbs < 1 << 23)) {
			// NaN or too large to have a chance
			return false;
		}
		final float twice = valueAbs + valueAbs;
		// Test on twice first, for it's the most likely to fail.
		return twice == (int) twice && value != (int) value;
	}

	/**
	 * Checks if is equidistant.
	 *
	 * @param value            A double value.
	 * @return True if the specified value is equidistant from two adjacent mathematical integers, false otherwise
	 *         (which includes NaN and +-Infinity).
	 */
	public static boolean isEquidistant(final double value) {
		final double valueAbs = Math.abs(value);
		if (!(valueAbs < 1L << 52)) { return false; }
		final double twice = valueAbs + valueAbs;
		// Test on twice first, for it's the most likely to fail.
		return twice == (long) twice && value != (long) value;
	}

	/**
	 * Checks if is na N or infinite.
	 *
	 * @param a the a
	 * @return True if the specified value is NaN or +-Infinity, false otherwise.
	 */
	public static boolean isNaNOrInfinite(final float a) {
		// a-a is not equal to 0.0f (and is NaN) <-> a is NaN or +-Infinity
		return !(a - a == 0.0f);
	}

	/**
	 * Checks if is na N or infinite.
	 *
	 * @param a the a
	 * @return True if the specified value is NaN or +-Infinity, false otherwise.
	 */
	public static boolean isNaNOrInfinite(final double a) {
		// a-a is not equal to 0.0 (and is NaN) <-> a is NaN or +-Infinity
		return !(a - a == 0.0);
	}

	/**
	 * Sign from bit.
	 *
	 * @param value            A float value.
	 * @return -1 if sign bit is 1, 1 if sign bit is 0.
	 */
	public static int signFromBit(final float value) {
		return Float.floatToRawIntBits(value) >> 30 | 1;
	}

	/**
	 * Sign from bit.
	 *
	 * @param value            A double value.
	 * @return -1 if sign bit is 1, 1 if sign bit is 0.
	 */
	public static long signFromBit(final double value) {
		// Returning a long, to avoid useless cast into int.
		return Double.doubleToRawLongBits(value) >> 62 | 1;
	}

	/*
	 * min/max ranges
	 */

	/**
	 * Checks if is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if the specified value is in the specified range (inclusive), false otherwise.
	 */
	public static boolean isInRange(final int min, final int max, final int a) {
		return min <= a && a <= max;
	}

	/**
	 * Checks if is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if the specified value is in the specified range (inclusive), false otherwise.
	 */
	public static boolean isInRange(final long min, final long max, final long a) {
		return min <= a && a <= max;
	}

	/**
	 * Returns false if any value is NaN.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if the specified value is in the specified range (inclusive), false otherwise.
	 */
	public static boolean isInRange(final float min, final float max, final float a) {
		return min <= a && a <= max;
	}

	/**
	 * Returns false if any value is NaN.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if the specified value is in the specified range (inclusive), false otherwise.
	 */
	public static boolean isInRange(final double min, final double max, final double a) {
		return min <= a && a <= max;
	}

	/*
	 *
	 */

	/**
	 * Check is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value is not in the specified range (inclusive).
	 */
	public static boolean checkIsInRange(final int min, final int max, final int a) {
		if (!isInRange(min, max, a)) { throw new IllegalArgumentException(a + " not in [" + min + "," + max + "]"); }
		return true;
	}

	/**
	 * Check is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value is not in the specified range (inclusive).
	 */
	public static boolean checkIsInRange(final long min, final long max, final long a) {
		if (!isInRange(min, max, a)) { throw new IllegalArgumentException(a + " not in [" + min + "," + max + "]"); }
		return true;
	}

	/**
	 * Check is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value is not in the specified range (inclusive) or any parameter is NaN.
	 */
	public static boolean checkIsInRange(final float min, final float max, final float a) {
		if (!isInRange(min, max, a)) { throw new IllegalArgumentException(a + " not in [" + min + "," + max + "]"); }
		return true;
	}

	/**
	 * Check is in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @param a the a
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value is not in the specified range (inclusive) or any parameter is NaN.
	 */
	public static boolean checkIsInRange(final double min, final double max, final double a) {
		if (!isInRange(min, max, a)) { throw new IllegalArgumentException(a + " not in [" + min + "," + max + "]"); }
		return true;
	}

	/*
	 *
	 */

	/**
	 * To range.
	 *
	 * @param min            A value.
	 * @param max            A value.
	 * @param a            A value.
	 * @return min if a <= min, else max if a >= max, else a.
	 */
	public static int toRange(final int min, final int max, final int a) {
		if (a <= min) {
			return min;
		} else if (a >= max) {
			return max;
		} else {
			return a;
		}
	}

	/**
	 * To range.
	 *
	 * @param min            A value.
	 * @param max            A value.
	 * @param a            A value.
	 * @return min if a <= min, else max if a >= max, else a.
	 */
	public static long toRange(final long min, final long max, final long a) {
		if (a <= min) {
			return min;
		} else if (a >= max) {
			return max;
		} else {
			return a;
		}
	}

	/**
	 * To range.
	 *
	 * @param min            A value.
	 * @param max            A value.
	 * @param a            A value.
	 * @return min if a <= min, else max if a >= max, else a.
	 */
	public static float toRange(final float min, final float max, final float a) {
		if (a <= min) {
			return min;
		} else if (a >= max) {
			return max;
		} else {
			return a;
		}
	}

	/**
	 * To range.
	 *
	 * @param min            A value.
	 * @param max            A value.
	 * @param a            A value.
	 * @return min if a <= min, else max if a >= max, else a.
	 */
	public static double toRange(final double min, final double max, final double a) {
		if (a <= min) {
			return min;
		} else if (a >= max) {
			return max;
		} else {
			return a;
		}
	}

	/*
	 * bitwise ranges
	 */

	/**
	 * Checks if is in range signed.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,32].
	 * @return True if the specified value fits as a signed integer over the specified number of bits, false otherwise.
	 * @throws IllegalArgumentException             if the specified number of bits is not in [1,32].
	 */
	public static boolean isInRangeSigned(final int a, final int bitSize) {
		checkBitSizeForSignedInt(bitSize);
		return minSignedIntForBitSize_noCheck(bitSize) <= a && a <= maxSignedIntForBitSize_noCheck(bitSize);
	}

	/**
	 * Checks if is in range signed.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,64].
	 * @return True if the specified value fits as a signed integer over the specified number of bits, false otherwise.
	 * @throws IllegalArgumentException             if the specified number of bits is not in [1,64].
	 */
	public static boolean isInRangeSigned(final long a, final int bitSize) {
		checkBitSizeForSignedLong(bitSize);
		return minSignedLongForBitSize_noCheck(bitSize) <= a && a <= maxSignedLongForBitSize_noCheck(bitSize);
	}

	/**
	 * Checks if is in range unsigned.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,31].
	 * @return True if the specified value fits as an unsigned integer over the specified number of bits, false
	 *         otherwise.
	 * @throws IllegalArgumentException             if the specified number of bits is not in [1,31].
	 */
	public static boolean isInRangeUnsigned(final int a, final int bitSize) {
		return isInRange(0, maxUnsignedIntForBitSize(bitSize), a);
	}

	/**
	 * Checks if is in range unsigned.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,63].
	 * @return True if the specified value fits as an unsigned integer over the specified number of bits, false
	 *         otherwise.
	 * @throws IllegalArgumentException             if the specified number of bits is not in [1,63].
	 */
	public static boolean isInRangeUnsigned(final long a, final int bitSize) {
		return isInRange(0, maxUnsignedLongForBitSize(bitSize), a);
	}

	/*
	 *
	 */

	/**
	 * Check is in range signed.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,32].
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value does not fit as a signed integer over the specified number of bits.
	 */
	public static boolean checkIsInRangeSigned(final int a, final int bitSize) {
		if (!isInRangeSigned(a, bitSize)) {
			throw new IllegalArgumentException(a + " does not fit as a signed value over " + bitSize + " bits");
		}
		return true;
	}

	/**
	 * Check is in range signed.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,64].
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value does not fit as a signed integer over the specified number of bits.
	 */
	public static boolean checkIsInRangeSigned(final long a, final int bitSize) {
		if (!isInRangeSigned(a, bitSize)) {
			throw new IllegalArgumentException(a + " does not fit as a signed value over " + bitSize + " bits");
		}
		return true;
	}

	/**
	 * Check is in range unsigned.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,31].
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value does not fit as an unsigned integer over the specified number of bits.
	 */
	public static boolean checkIsInRangeUnsigned(final int a, final int bitSize) {
		if (!isInRangeUnsigned(a, bitSize)) {
			throw new IllegalArgumentException(a + " does not fit as an unsigned value over " + bitSize + " bits");
		}
		return true;
	}

	/**
	 * Check is in range unsigned.
	 *
	 * @param a the a
	 * @param bitSize            A number of bits, in [1,63].
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified value does not fit as an unsigned integer over the specified number of bits.
	 */
	public static boolean checkIsInRangeUnsigned(final long a, final int bitSize) {
		if (!isInRangeUnsigned(a, bitSize)) {
			throw new IllegalArgumentException(a + " does not fit as an unsigned value over " + bitSize + " bits");
		}
		return true;
	}

	/*
	 * masks (int)
	 */

	/**
	 * Int mask MS bits 0.
	 *
	 * @param bitSize            A number of bits, in [0,32].
	 * @return Mask with the specified number of left bits set with 0, and other bits set with 1.
	 */
	public static int intMaskMSBits0(final int bitSize) {
		checkIsInRange(0, 32, bitSize);
		// Shifting in two times, for >>> doesn't work for full bit size (<< as well).
		final int halfish = bitSize >> 1;
		return -1 >>> halfish >>> bitSize - halfish;
	}

	/**
	 * Int mask MS bits 1.
	 *
	 * @param bitSize            A number of bits, in [0,32].
	 * @return Mask with the specified number of left bits set with 1, and other bits set with 0.
	 */
	public static int intMaskMSBits1(final int bitSize) {
		return ~intMaskMSBits0(bitSize);
	}

	/**
	 * Int mask LS bits 0.
	 *
	 * @param bitSize            A number of bits, in [0,32].
	 * @return Mask with the specified number of right bits set with 0, and other bits set with 1.
	 */
	public static int intMaskLSBits0(final int bitSize) {
		return ~intMaskMSBits0(32 - bitSize);
	}

	/**
	 * Int mask LS bits 1.
	 *
	 * @param bitSize            A number of bits, in [0,32].
	 * @return Mask with the specified number of right bits set with 1, and other bits set with 0.
	 */
	public static int intMaskLSBits1(final int bitSize) {
		return intMaskMSBits0(32 - bitSize);
	}

	/*
	 * masks (long)
	 */

	/**
	 * Long mask MS bits 0.
	 *
	 * @param bitSize            A number of bits, in [0,64].
	 * @return Mask with the specified number of left bits set with 0, and other bits set with 1.
	 */
	public static long longMaskMSBits0(final int bitSize) {
		checkIsInRange(0, 64, bitSize);
		// Shifting in two times, for >>> doesn't work for full bit size (<< as well).
		final int halfish = bitSize >> 1;
		return -1L >>> halfish >>> bitSize - halfish;
	}

	/**
	 * Long mask MS bits 1.
	 *
	 * @param bitSize            A number of bits, in [0,64].
	 * @return Mask with the specified number of left bits set with 1, and other bits set with 0.
	 */
	public static long longMaskMSBits1(final int bitSize) {
		return ~longMaskMSBits0(bitSize);
	}

	/**
	 * Long mask LS bits 0.
	 *
	 * @param bitSize            A number of bits, in [0,64].
	 * @return Mask with the specified number of right bits set with 0, and other bits set with 1.
	 */
	public static long longMaskLSBits0(final int bitSize) {
		return ~longMaskMSBits0(64 - bitSize);
	}

	/**
	 * Long mask LS bits 1.
	 *
	 * @param bitSize            A number of bits, in [0,64].
	 * @return Mask with the specified number of right bits set with 1, and other bits set with 0.
	 */
	public static long longMaskLSBits1(final int bitSize) {
		return longMaskMSBits0(64 - bitSize);
	}

	/*
	 * signed/unsigned
	 */

	/**
	 * Byte as unsigned.
	 *
	 * @param value the value
	 * @return Unsigned value corresponding to bits of the specified byte.
	 */
	public static short byteAsUnsigned(final byte value) {
		return (short) (value & 0xFF);
	}

	/**
	 * Short as unsigned.
	 *
	 * @param value the value
	 * @return Unsigned value corresponding to bits of the specified short.
	 */
	public static int shortAsUnsigned(final short value) {
		return value & 0xFFFF;
	}

	/**
	 * Int as unsigned.
	 *
	 * @param value the value
	 * @return Unsigned value corresponding to bits of the specified int.
	 */
	public static long intAsUnsigned(final int value) {
		return (long) value & 0xFFFFFFFF;
	}

	/*
	 * bitwise ranges
	 */

	/**
	 * Checks if is valid bit size for signed int.
	 *
	 * @param bitSize the bit size
	 * @return True if a signed int value can be read over the specified number of bits, i.e. if it is in [1,32], false
	 *         otherwise.
	 */
	public static boolean isValidBitSizeForSignedInt(final int bitSize) {
		return bitSize > 0 && bitSize <= 32;
	}

	/**
	 * Checks if is valid bit size for signed long.
	 *
	 * @param bitSize the bit size
	 * @return True if a signed long value can be read over the specified number of bits, i.e. if it is in [1,64], false
	 *         otherwise.
	 */
	public static boolean isValidBitSizeForSignedLong(final int bitSize) {
		return bitSize > 0 && bitSize <= 64;
	}

	/**
	 * Checks if is valid bit size for unsigned int.
	 *
	 * @param bitSize the bit size
	 * @return True if an unsigned int value can be read over the specified number of bits, i.e. if it is in [1,31],
	 *         false otherwise.
	 */
	public static boolean isValidBitSizeForUnsignedInt(final int bitSize) {
		return bitSize > 0 && bitSize < 32;
	}

	/**
	 * Checks if is valid bit size for unsigned long.
	 *
	 * @param bitSize the bit size
	 * @return True if an unsigned long value can be read over the specified number of bits, i.e. if it is in [1,63],
	 *         false otherwise.
	 */
	public static boolean isValidBitSizeForUnsignedLong(final int bitSize) {
		return bitSize > 0 && bitSize < 64;
	}

	/*
	 *
	 */

	/**
	 * Check bit size for signed int.
	 *
	 * @param bitSize the bit size
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if a signed int value can't be read over the specified number of bits, i.e. if it is not in [1,32].
	 */
	public static boolean checkBitSizeForSignedInt(final int bitSize) {
		if (!isValidBitSizeForSignedInt(bitSize)) {
			throw new IllegalArgumentException("bit size [" + bitSize + "] must be in [1,32] for signed int values");
		}
		return true;
	}

	/**
	 * Check bit size for signed long.
	 *
	 * @param bitSize the bit size
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if a signed long value can't be read over the specified number of bits, i.e. if it is not in [1,64].
	 */
	public static boolean checkBitSizeForSignedLong(final int bitSize) {
		if (!isValidBitSizeForSignedLong(bitSize)) {
			throw new IllegalArgumentException("bit size [" + bitSize + "] must be in [1,64] for signed long values");
		}
		return true;
	}

	/**
	 * Check bit size for unsigned int.
	 *
	 * @param bitSize the bit size
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if an unsigned int value can't be read over the specified number of bits, i.e. if it is not in
	 *             [1,31].
	 */
	public static boolean checkBitSizeForUnsignedInt(final int bitSize) {
		if (!isValidBitSizeForUnsignedInt(bitSize)) {
			throw new IllegalArgumentException("bit size [" + bitSize + "] must be in [1,31] for unsigned int values");
		}
		return true;
	}

	/**
	 * Check bit size for unsigned long.
	 *
	 * @param bitSize the bit size
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if an unsigned long value can't be read over the specified number of bits, i.e. if it is not in
	 *             [1,63].
	 */
	public static boolean checkBitSizeForUnsignedLong(final int bitSize) {
		if (!isValidBitSizeForUnsignedLong(bitSize)) {
			throw new IllegalArgumentException("bit size [" + bitSize + "] must be in [1,63] for unsigned long values");
		}
		return true;
	}

	/*
	 *
	 */

	/**
	 * Min signed int for bit size.
	 *
	 * @param bitSize            A number of bits in [1,32].
	 * @return The min signed int value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static int minSignedIntForBitSize(final int bitSize) {
		checkBitSizeForSignedInt(bitSize);
		return minSignedIntForBitSize_noCheck(bitSize);
	}

	/**
	 * Min signed long for bit size.
	 *
	 * @param bitSize            A number of bits in [1,64].
	 * @return The min signed long value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static long minSignedLongForBitSize(final int bitSize) {
		checkBitSizeForSignedLong(bitSize);
		return minSignedLongForBitSize_noCheck(bitSize);
	}

	/**
	 * Max signed int for bit size.
	 *
	 * @param bitSize            A number of bits in [1,32].
	 * @return The max signed int value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static int maxSignedIntForBitSize(final int bitSize) {
		checkBitSizeForSignedInt(bitSize);
		return maxSignedIntForBitSize_noCheck(bitSize);
	}

	/**
	 * Max signed long for bit size.
	 *
	 * @param bitSize            A number of bits in [1,64].
	 * @return The max signed long value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static long maxSignedLongForBitSize(final int bitSize) {
		checkBitSizeForSignedLong(bitSize);
		return maxSignedLongForBitSize_noCheck(bitSize);
	}

	/**
	 * Max unsigned int for bit size.
	 *
	 * @param bitSize            A number of bits in [1,31].
	 * @return The max unsigned int value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static int maxUnsignedIntForBitSize(final int bitSize) {
		checkBitSizeForUnsignedInt(bitSize);
		// i.e. (1<<bitSize)-1
		return Integer.MAX_VALUE >> 31 - bitSize;
	}

	/**
	 * Max unsigned long for bit size.
	 *
	 * @param bitSize            A number of bits in [1,63].
	 * @return The max unsigned long value that can be stored over the specified number of bits.
	 * @throws IllegalArgumentException             if the specified number of bits is out of range.
	 */
	public static long maxUnsignedLongForBitSize(final int bitSize) {
		checkBitSizeForUnsignedLong(bitSize);
		// i.e. (1L<<bitSize)-1
		return Long.MAX_VALUE >> 63 - bitSize;
	}

	/*
	 *
	 */

	/**
	 * Bit size for signed value.
	 *
	 * @param value the value
	 * @return The number of bits required to store the specified value as a signed integer, i.e. a result in [1,32].
	 */
	public static int bitSizeForSignedValue(final int value) {
		if (value > 0) {
			return 33 - Integer.numberOfLeadingZeros(value);
		} else if (value == 0) {
			return 1;
		} else {
			// Works for Integer.MIN_VALUE as well.
			return 33 - Integer.numberOfLeadingZeros(-value - 1);
		}
	}

	/**
	 * Bit size for signed value.
	 *
	 * @param value the value
	 * @return The number of bits required to store the specified value as a signed integer, i.e. a result in [1,64].
	 */
	public static int bitSizeForSignedValue(final long value) {
		if (value > 0) {
			return 65 - Long.numberOfLeadingZeros(value);
		} else if (value == 0) {
			return 1;
		} else {
			// Works for Long.MIN_VALUE as well.
			return 65 - Long.numberOfLeadingZeros(-value - 1);
		}
	}

	/**
	 * Bit size for unsigned value.
	 *
	 * @param value            An integer value in [0,Integer.MAX_VALUE].
	 * @return The number of bits required to store the specified value as an unsigned integer, i.e. a result in [1,31].
	 * @throws IllegalArgumentException             if the specified value is < 0.
	 */
	public static int bitSizeForUnsignedValue(final int value) {
		if (value > 0) {
			return 32 - Integer.numberOfLeadingZeros(value);
		} else {
			if (value == 0) {
				return 1;
			} else {
				throw new IllegalArgumentException("unsigned value [" + value + "] must be >= 0");
			}
		}
	}

	/**
	 * Bit size for unsigned value.
	 *
	 * @param value            An integer value in [0,Long.MAX_VALUE].
	 * @return The number of bits required to store the specified value as an unsigned integer, i.e. a result in [1,63].
	 * @throws IllegalArgumentException             if the specified value is < 0.
	 */
	public static int bitSizeForUnsignedValue(final long value) {
		if (value > 0) {
			return 64 - Long.numberOfLeadingZeros(value);
		} else {
			if (value == 0) {
				return 1;
			} else {
				throw new IllegalArgumentException("unsigned value [" + value + "] must be >= 0");
			}
		}
	}

	/*
	 * integer functions
	 */

	/**
	 * Signum.
	 *
	 * @param a the a
	 * @return 1 if the specified value is > 0, 0 if it is 0, -1 otherwise.
	 */
	public static int signum(final int a) {
		return a < 0 ? -1 : a == 0 ? 0 : 1;
	}

	/**
	 * Signum.
	 *
	 * @param a the a
	 * @return 1 if the specified value is > 0, 0 if it is 0, -1 otherwise.
	 */
	public static int signum(final long a) {
		return a < 0 ? -1 : a == 0 ? 0 : 1;
	}

	/**
	 * Checks if is even.
	 *
	 * @param a the a
	 * @return True if the specified value is even, false otherwise.
	 */
	public static boolean isEven(final int a) {
		return (a & 1) == 0;
	}

	/**
	 * Checks if is even.
	 *
	 * @param a the a
	 * @return True if the specified value is even, false otherwise.
	 */
	public static boolean isEven(final long a) {
		// faster to work on ints
		return isEven((int) a);
	}

	/**
	 * Checks if is odd.
	 *
	 * @param a the a
	 * @return True if the specified value is odd, false otherwise.
	 */
	public static boolean isOdd(final int a) {
		return (a & 1) != 0;
	}

	/**
	 * Checks if is odd.
	 *
	 * @param a the a
	 * @return True if the specified value is odd, false otherwise.
	 */
	public static boolean isOdd(final long a) {
		// faster to work on ints
		return isOdd((int) a);
	}

	/**
	 * Have same evenness.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are both even or both odd, false otherwise.
	 */
	public static boolean haveSameEvenness(final int a, final int b) {
		return ((a ^ b) & 1) == 0;
	}

	/**
	 * Have same evenness.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are both even or both odd, false otherwise.
	 */
	public static boolean haveSameEvenness(final long a, final long b) {
		// faster to work on ints
		return haveSameEvenness((int) a, (int) b);
	}

	/**
	 * Have same sign.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are both >= 0 or both < 0, false otherwise.
	 */
	public static boolean haveSameSign(final int a, final int b) {
		return (a ^ b) >= 0;
	}

	/**
	 * Have same sign.
	 *
	 * @param a the a
	 * @param b the b
	 * @return True if the specified values are both >= 0 or both < 0, false otherwise.
	 */
	public static boolean haveSameSign(final long a, final long b) {
		return (a ^ b) >= 0;
	}

	/**
	 * Checks if is power of two.
	 *
	 * @param a the a
	 * @return True if the specified value is a power of two, i.e. a value of the form 2^k, with k >= 0.
	 */
	public static boolean isPowerOfTwo(final int a) {
		if (a <= 0) { return false; }
		return (a & a - 1) == 0;
	}

	/**
	 * Checks if is power of two.
	 *
	 * @param a the a
	 * @return True if the specified value is a power of two, i.e. a value of the form 2^k, with k >= 0.
	 */
	public static boolean isPowerOfTwo(final long a) {
		if (a <= 0) { return false; }
		return (a & a - 1) == 0;
	}

	/**
	 * Checks if is signed power of two.
	 *
	 * @param a the a
	 * @return True if the specified value is a signed power of two, i.e. a value of the form +-2^k, with k >= 0.
	 */
	public static boolean isSignedPowerOfTwo(final int a) {
		if (a > 0) {
			return (a & a - 1) == 0;
		} else {
			if (a == -a) {
				// a is 0 or Integer.MIN_VALUE
				return a != 0;
			}
			return (-a & -a - 1) == 0;
		}
	}

	/**
	 * Checks if is signed power of two.
	 *
	 * @param a the a
	 * @return True if the specified value is a signed power of two, i.e. a value of the form +-2^k, with k >= 0.
	 */
	public static boolean isSignedPowerOfTwo(final long a) {
		if (a > 0) {
			return (a & a - 1) == 0;
		} else {
			if (a == -a) {
				// a is 0 or Long.MIN_VALUE
				return a != 0;
			}
			return (-a & -a - 1) == 0;
		}
	}

	/**
	 * Floor power of two.
	 *
	 * @param a            A value in [1,Integer.MAX_VALUE].
	 * @return The highest power of two <= a.
	 */
	public static int floorPowerOfTwo(final int a) {
		if (a <= 0) { throw new IllegalArgumentException("a [" + a + "] must be > 0"); }
		return Integer.highestOneBit(a);
	}

	/**
	 * Floor power of two.
	 *
	 * @param a            A value in [1,Long.MAX_VALUE].
	 * @return The highest power of two <= a.
	 */
	public static long floorPowerOfTwo(final long a) {
		if (a <= 0) { throw new IllegalArgumentException("a [" + a + "] must be > 0"); }
		// Faster than copying int method
		// (less computations on long).
		return 1L << 63 - Long.numberOfLeadingZeros(a);
	}

	/**
	 * Ceiling power of two.
	 *
	 * @param a            A value in [0,2^30].
	 * @return The lowest power of two >= a.
	 */
	public static int ceilingPowerOfTwo(final int a) {
		checkIsInRange(0, 1 << 30, a);
		return a >= 2 ? Integer.highestOneBit(a - 1 << 1) : 1;
	}

	/**
	 * Ceiling power of two.
	 *
	 * @param a            A value in [0,2^62].
	 * @return The lowest power of two >= a.
	 */
	public static long ceilingPowerOfTwo(final long a) {
		checkIsInRange(0L, 1L << 62, a);
		// Faster than copying int method
		// (less computations on long).
		return 1L << 64 - Long.numberOfLeadingZeros(a - 1);
	}

	/**
	 * Mean low.
	 *
	 * @param a the a
	 * @param b the b
	 * @return Mean without overflow, rounded to the lowest value (i.e. mathematical floor((a+b)/2), using floating
	 *         point division).
	 */
	public static int meanLow(final int a, final int b) {
		return (a & b) + ((a ^ b) >> 1);
	}

	/**
	 * Mean low.
	 *
	 * @param a the a
	 * @param b the b
	 * @return Mean without overflow, rounded to the lowest value (i.e. mathematical floor((a+b)/2), using floating
	 *         point division).
	 */
	public static long meanLow(final long a, final long b) {
		return (a & b) + ((a ^ b) >> 1);
	}

	/**
	 * Mean sml.
	 *
	 * @param a the a
	 * @param b the b
	 * @return Mean without overflow, rounded to the value of smallest magnitude (i.e. mathematical (a+b)/2, using
	 *         integer division).
	 */
	public static int meanSml(final int a, final int b) {
		int result = meanLow(a, b);
		if (!haveSameEvenness(a, b)) {
			// inexact
			if ((a & b) < 0 || (a | b) < 0 && a + b < 0) {
				// both < 0, or only one is < 0 and it has the largest magnitude
				result++;
			}
		}
		return result;
	}

	/**
	 * Mean sml.
	 *
	 * @param a the a
	 * @param b the b
	 * @return Mean without overflow, rounded to the value of smallest magnitude (i.e. mathematical (a+b)/2, using
	 *         integer division).
	 */
	public static long meanSml(final long a, final long b) {
		long result = meanLow(a, b);
		if (!haveSameEvenness(a, b)) {
			// inexact
			if ((a & b) < 0 || (a | b) < 0 && a + b < 0) {
				// both < 0, or only one is < 0 and it has the largest magnitude
				result++;
			}
		}
		return result;
	}

	/**
	 * Useful because a positive int value could not represent half the width of full int range width, which is
	 * mathematically Integer.MAX_VALUE+1.
	 *
	 * @param min the min
	 * @param max the max
	 * @return Minus half the range width (inclusive, and rounded to the value of smaller magnitude) between the
	 *         specified bounds.
	 * @throws IllegalArgumentException             if min > max.
	 */
	public static int negHalfWidth(final int min, final int max) {
		if (min > max) { throw new IllegalArgumentException("min [" + min + "] must be <= max [" + max + "]"); }
		final int mean = meanLow(min, max);
		return min - mean - ((min ^ max) & 1);
	}

	/**
	 * Useful because a positive long value could not represent half the width of full long range width, which is
	 * mathematically Long.MAX_VALUE+1.
	 *
	 * @param min the min
	 * @param max the max
	 * @return Minus half the range width (inclusive, and rounded to the value of smaller magnitude) between the
	 *         specified bounds.
	 * @throws IllegalArgumentException             if min > max.
	 */
	public static long negHalfWidth(final long min, final long max) {
		if (min > max) { throw new IllegalArgumentException("min [" + min + "] must be <= max [" + max + "]"); }
		final long mean = meanLow(min, max);
		return min - mean - ((min ^ max) & 1);
	}

	/**
	 * This treatment being designed for optimization, the fact that spot is a signed power of two is not checked.
	 *
	 * @param value
	 *            A value.
	 * @param spot
	 *            A signed power of two (i.e. a value of the form +-2^k, k >= 0).
	 * @return value % spot, i.e. a value in ]-|spot|,|spot|[.
	 */
	public static int moduloSignedPowerOfTwo(final int value, final int spot) {
		if (spot == Integer.MIN_VALUE) {
			return value != Integer.MIN_VALUE ? value : 0;
		} else {
			final int s = value >> 31;
			return ((value + s ^ s) & abs(spot) - 1) + s ^ s;
		}
	}

	/**
	 * This treatment being designed for optimization, the fact that spot is a signed power of two is not checked.
	 *
	 * @param value
	 *            A value.
	 * @param spot
	 *            A signed power of two (i.e. a value of the form +-2^k, k >= 0).
	 * @return value % spot, i.e. a value in ]-|spot|,|spot|[.
	 */
	public static long moduloSignedPowerOfTwo(final long value, final long spot) {
		if (spot == Long.MIN_VALUE) {
			return value != Long.MIN_VALUE ? value : 0;
		} else {
			final long s = value >> 63;
			return ((value + s ^ s) & abs(spot) - 1) + s ^ s;
		}
	}

	/**
	 * Log 2.
	 *
	 * @param value            An integer value > 0.
	 * @return The integer part of the logarithm, in base 2, of the specified value, i.e. a result in [0,30]
	 * @throws IllegalArgumentException             if the specified value is <= 0.
	 */
	public static int log2(final int value) {
		if (value <= 0) { throw new IllegalArgumentException("value [" + value + "] must be > 0"); }
		return 31 - Integer.numberOfLeadingZeros(value);
	}

	/**
	 * Log 2.
	 *
	 * @param value            An integer value > 0.
	 * @return The integer part of the logarithm, in base 2, of the specified value, i.e. a result in [0,62]
	 * @throws IllegalArgumentException             if the specified value is <= 0.
	 */
	public static int log2(final long value) {
		if (value <= 0) { throw new IllegalArgumentException("value [" + value + "] must be > 0"); }
		return 63 - Long.numberOfLeadingZeros(value);
	}

	/**
	 * Possibly faster than java.lang.Math.abs(int).
	 *
	 * @param a the a
	 * @return The absolute value, except if value is Integer.MIN_VALUE, for which it returns Integer.MIN_VALUE.
	 */
	public static int abs(final int a) {
		return (a ^ a >> 31) - (a >> 31);
	}

	/**
	 * Possibly faster than java.lang.Math.abs(long).
	 *
	 * @param a the a
	 * @return The absolute value, except if value is Long.MIN_VALUE, for which it returns Long.MIN_VALUE.
	 */
	public static long abs(final long a) {
		return (a ^ a >> 63) - (a >> 63);
	}

	/**
	 * Abs neg.
	 *
	 * @param a the a
	 * @return The negative of the absolute value (always exact).
	 */
	public static int absNeg(final int a) {
		return (a >> 31) - (a ^ a >> 31);
	}

	/**
	 * Abs neg.
	 *
	 * @param a the a
	 * @return The negative of the absolute value (always exact).
	 */
	public static long absNeg(final long a) {
		return (a >> 63) - (a ^ a >> 63);
	}

	/**
	 * If the specified value is in int range, the returned value is identical.
	 *
	 * @param a the a
	 * @return An int hash of the specified value.
	 */
	public static int intHash(final long a) {
		int hash = (int) (a >> 32) + (int) a;
		if (a < 0) {
			hash++;
		}
		return hash;
	}

	/**
	 * Not defining an asByte(long) method, since asByte((int)aLong) works.
	 *
	 * @param a
	 *            An int value.
	 * @return The specified value as byte.
	 * @throws ArithmeticException
	 *             if the specified value is not in [Byte.MIN_VALUE,Byte.MAX_VALUE] range.
	 */
	public static byte asByte(final int a) {
		if (a != (byte) a) { throw new ArithmeticException("overflow: " + a); }
		return (byte) a;
	}

	/**
	 * As int.
	 *
	 * @param a            A long value.
	 * @return The specified value as int.
	 * @throws ArithmeticException             if the specified value is not in [Integer.MIN_VALUE,Integer.MAX_VALUE] range.
	 */
	public static int asInt(final long a) {
		if (a != (int) a) { throw new ArithmeticException("overflow: " + a); }
		return (int) a;
	}

	/**
	 * To int.
	 *
	 * @param a            A long value.
	 * @return The closest int value in [Integer.MIN_VALUE,Integer.MAX_VALUE] range.
	 */
	public static int toInt(final long a) {
		if (a != (int) a) { return a < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE; }
		return (int) a;
	}

	/**
	 * Plus exact.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The mathematical result of a+b.
	 * @throws ArithmeticException             if the mathematical result of a+b is not in [Integer.MIN_VALUE,Integer.MAX_VALUE] range.
	 */
	public static int plusExact(final int a, final int b) {
		final int sum = a + b;
		// HD 2-12 Overflow iff both arguments
		// have the opposite sign of the result.
		if (((a ^ sum) & (b ^ sum)) < 0) { throw new ArithmeticException("overflow: " + a + "+" + b); }
		return sum;
	}

	/**
	 * Plus exact.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The mathematical result of a+b.
	 * @throws ArithmeticException             if the mathematical result of a+b is not in [Long.MIN_VALUE,Long.MAX_VALUE] range.
	 */
	public static long plusExact(final long a, final long b) {
		final long sum = a + b;
		// HD 2-12 Overflow iff both arguments
		// have the opposite sign of the result.
		if (((a ^ sum) & (b ^ sum)) < 0) { throw new ArithmeticException("overflow: " + a + "+" + b); }
		return sum;
	}

	/**
	 * Plus bounded.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The int value of [Integer.MIN_VALUE,Integer.MAX_VALUE] range which is the closest to mathematical result
	 *         of a+b.
	 */
	public static int plusBounded(final int a, final int b) {
		return toInt((long) a + (long) b);
	}

	/**
	 * Plus bounded.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The long value of [Long.MIN_VALUE,Long.MAX_VALUE] range which is the closest to mathematical result of
	 *         a+b.
	 */
	public static long plusBounded(final long a, final long b) {
		final long sum = a + b;
		if (((a ^ sum) & (b ^ sum)) < 0) { return sum >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE; }
		return sum;
	}

	/**
	 * Minus exact.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The mathematical result of a-b.
	 * @throws ArithmeticException             if the mathematical result of a-b is not in [Integer.MIN_VALUE,Integer.MAX_VALUE] range.
	 */
	public static int minusExact(final int a, final int b) {
		final int diff = a - b;
		// HD 2-12 Overflow iff the arguments have different signs and
		// the sign of the result is different than the sign of "a".
		if (((a ^ b) & (a ^ diff)) < 0) { throw new ArithmeticException("integer overflow"); }
		return diff;
	}

	/**
	 * Minus exact.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The mathematical result of a-b.
	 * @throws ArithmeticException             if the mathematical result of a-b is not in [Long.MIN_VALUE,Long.MAX_VALUE] range.
	 */
	public static long minusExact(final long a, final long b) {
		final long diff = a - b;
		// HD 2-12 Overflow iff the arguments have different signs and
		// the sign of the result is different than the sign of "a".
		if (((a ^ b) & (a ^ diff)) < 0) { throw new ArithmeticException("integer overflow"); }
		return diff;
	}

	/**
	 * Minus bounded.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The int value of [Integer.MIN_VALUE,Integer.MAX_VALUE] range which is the closest to mathematical result
	 *         of a-b.
	 */
	public static int minusBounded(final int a, final int b) {
		return toInt((long) a - (long) b);
	}

	/**
	 * Minus bounded.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The long value of [Long.MIN_VALUE,Long.MAX_VALUE] range which is the closest to mathematical result of
	 *         a-b.
	 */
	public static long minusBounded(final long a, final long b) {
		final long diff = a - b;
		if (((a ^ b) & (a ^ diff)) < 0) { return diff >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE; }
		return diff;
	}

	/**
	 * Times exact.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The mathematical result of a*b.
	 * @throws ArithmeticException             if the mathematical result of a*b is not in [Integer.MIN_VALUE,Integer.MAX_VALUE] range.
	 */
	public static int timesExact(final int a, final int b) {
		final long prod = a * (long) b;
		if (prod != (int) prod) { throw new ArithmeticException("overflow: " + a + "*" + b); }
		return (int) prod;
	}

	/**
	 * Times exact.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The mathematical result of a*b.
	 * @throws ArithmeticException             if the mathematical result of a*b is not in [Long.MIN_VALUE,Long.MAX_VALUE] range.
	 */
	public static long timesExact(final long a, final long b) {
		final long prod = a * b;
		final long absA = abs(a);
		final long absB = abs(b);
		if ((absA | absB) >>> 31 != 0) {
			// Some bits greater than 2^31 that might cause overflow
			// Check the result using the divide operator
			// and check for the special case of Long.MIN_VALUE * -1
			if (b != 0 && prod / b != a || a == Long.MIN_VALUE && b == -1) {
				throw new ArithmeticException("overflow: " + a + "*" + b);
			}
		}
		return prod;
	}

	/**
	 * Times bounded.
	 *
	 * @param a            An int value.
	 * @param b            An int value.
	 * @return The int value of [Integer.MIN_VALUE,Integer.MAX_VALUE] range which is the closest to mathematical result
	 *         of a*b.
	 */
	public static int timesBounded(final int a, final int b) {
		return (int) (a * (double) b);
	}

	/**
	 * Times bounded.
	 *
	 * @param a            A long value.
	 * @param b            A long value.
	 * @return The long value of [Long.MIN_VALUE,Long.MAX_VALUE] range which is the closest to mathematical result of
	 *         a*b.
	 */
	public static long timesBounded(final long a, final long b) {
		final long prod = a * b;
		final long absA = abs(a);
		final long absB = abs(b);
		if ((absA | absB) >>> 31 != 0) {
			// Some bits greater than 2^31 that might cause overflow
			// Check the result using the divide operator
			// and check for the special case of Long.MIN_VALUE * -1
			if (b != 0 && prod / b != a || a == Long.MIN_VALUE && b == -1) {
				return (a ^ b) >= 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
			}
		}
		return prod;
	}

	/*
	 * powers
	 */

	/**
	 * Returns the exact result, provided it's in double range, i.e. if power is in [-1074,1023].
	 *
	 * @param power
	 *            An int power.
	 * @return 2^power as a double, or +-Infinity in case of overflow.
	 */
	public static double twoPow(final int power) {
		if (power <= -MAX_DOUBLE_EXPONENT) { // Not normal.
			if (power >= MIN_DOUBLE_EXPONENT) { // Subnormal.
				return Double.longBitsToDouble(0x0008000000000000L >> -(power + MAX_DOUBLE_EXPONENT));
			} else { // Underflow.
				return 0.0;
			}
		} else if (power > MAX_DOUBLE_EXPONENT) { // Overflow.
			return Double.POSITIVE_INFINITY;
		} else { // Normal.
			return Double.longBitsToDouble((long) (power + MAX_DOUBLE_EXPONENT) << 52);
		}
	}

	/**
	 * Two pow as int exact.
	 *
	 * @param power            An int power.
	 * @return 2^power as an int.
	 * @throws ArithmeticException             if the mathematical result is not in int range, i.e. if power is not in [0,30].
	 */
	public static int twoPowAsIntExact(final int power) {
		if (power < 0 || power > 30) { throw new ArithmeticException("integer overflow"); }
		return 1 << power;
	}

	/**
	 * Two pow as int bounded.
	 *
	 * @param p the p
	 * @return 2^power as an int, or the closest power of two in int range in case of overflow, i.e. if power is not in
	 *         [0,30].
	 */
	public static int twoPowAsIntBounded(final int p) {
		final int power = toRange(0, 30, p);
		return 1 << power;
	}

	/**
	 * Two pow as long exact.
	 *
	 * @param power            An int power.
	 * @return 2^power as a long.
	 * @throws ArithmeticException             if the mathematical result is not in long range, i.e. if power is not in [0,62].
	 */
	public static long twoPowAsLongExact(final int power) {
		if (power < 0 || power > 62) { throw new ArithmeticException("long overflow"); }
		return 1L << power;
	}

	/**
	 * Two pow as long bounded.
	 *
	 * @param p the p
	 * @return 2^power as a long, or the closest power of two in long range in case of overflow, i.e. if power is not in
	 *         [0,62].
	 */
	public static long twoPowAsLongBounded(final int p) {
		final int power = toRange(0, 62, p);
		return 1L << power;
	}

	/**
	 * Pow 2.
	 *
	 * @param a            A value.
	 * @return a*a.
	 */
	public static int pow2(final int a) {
		return a * a;
	}

	/**
	 * Pow 2.
	 *
	 * @param a            A value.
	 * @return a*a.
	 */
	public static long pow2(final long a) {
		return a * a;
	}

	/**
	 * Pow 2.
	 *
	 * @param a            A value.
	 * @return a*a.
	 */
	public static float pow2(final float a) {
		return a * a;
	}

	/**
	 * Strict version.
	 *
	 * @param a
	 *            A value.
	 * @return a*a.
	 */
	public static strictfp float pow2_strict(final float a) {
		return a * a;
	}

	/**
	 * Pow 2.
	 *
	 * @param a            A value.
	 * @return a*a.
	 */
	public static double pow2(final double a) {
		return a * a;
	}

	/**
	 * Strict version.
	 *
	 * @param a
	 *            A value.
	 * @return a*a.
	 */
	public static strictfp double pow2_strict(final double a) {
		return a * a;
	}

	/**
	 * Pow 3.
	 *
	 * @param a            A value.
	 * @return a*a*a.
	 */
	public static int pow3(final int a) {
		return a * a * a;
	}

	/**
	 * Pow 3.
	 *
	 * @param a            A value.
	 * @return a*a*a.
	 */
	public static long pow3(final long a) {
		return a * a * a;
	}

	/**
	 * Pow 3.
	 *
	 * @param a            A value.
	 * @return a*a*a.
	 */
	public static float pow3(final float a) {
		return a * a * a;
	}

	/**
	 * Strict version.
	 *
	 * @param a
	 *            A value.
	 * @return a*a*a.
	 */
	public static strictfp float pow3_strict(final float a) {
		return a * a * a;
	}

	/**
	 * Pow 3.
	 *
	 * @param a            A value.
	 * @return a*a*a.
	 */
	public static double pow3(final double a) {
		return a * a * a;
	}

	/**
	 * Strict version.
	 *
	 * @param a
	 *            A value.
	 * @return a*a*a.
	 */
	public static strictfp double pow3_strict(final double a) {
		return a * a * a;
	}

	/*
	 * Accurate +-m*PI/n.
	 */

	/**
	 * Plus 2 PI.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad + 2*PI, accurately computed.
	 */
	public static double plus2PI(final double angRad) {
		if (angRad > -Math.PI) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + TWOPI_LO + TWOPI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + TWOPI_HI + TWOPI_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad + 2*PI, accurately computed.
	 */
	public static strictfp double plus2PI_strict(final double angRad) {
		if (angRad > -Math.PI) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + TWOPI_LO + TWOPI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + TWOPI_HI + TWOPI_LO;
		}
	}

	/**
	 * Minus 2 PI.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad - 2*PI, accurately computed.
	 */
	public static double minus2PI(final double angRad) {
		if (angRad < Math.PI) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - TWOPI_LO - TWOPI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - TWOPI_HI - TWOPI_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad - 2*PI, accurately computed.
	 */
	public static strictfp double minus2PI_strict(final double angRad) {
		if (angRad < Math.PI) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - TWOPI_LO - TWOPI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - TWOPI_HI - TWOPI_LO;
		}
	}

	/**
	 * Plus PI.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad + PI, accurately computed.
	 */
	public static double plusPI(final double angRad) {
		if (angRad > -Math.PI / 2) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + PI_LO + PI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + PI_HI + PI_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad + PI, accurately computed.
	 */
	public static strictfp double plusPI_strict(final double angRad) {
		if (angRad > -Math.PI / 2) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + PI_LO + PI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + PI_HI + PI_LO;
		}
	}

	/**
	 * Minus PI.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad - PI, accurately computed.
	 */
	public static double minusPI(final double angRad) {
		if (angRad < Math.PI / 2) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - PI_LO - PI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - PI_HI - PI_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad - PI, accurately computed.
	 */
	public static strictfp double minusPI_strict(final double angRad) {
		if (angRad < Math.PI / 2) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - PI_LO - PI_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - PI_HI - PI_LO;
		}
	}

	/**
	 * Plus PIO 2.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad + PI/2, accurately computed.
	 */
	public static double plusPIO2(final double angRad) {
		if (angRad > -Math.PI / 4) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + PIO2_LO + PIO2_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + PIO2_HI + PIO2_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad + PI/2, accurately computed.
	 */
	public static strictfp double plusPIO2_strict(final double angRad) {
		if (angRad > -Math.PI / 4) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad + PIO2_LO + PIO2_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad + PIO2_HI + PIO2_LO;
		}
	}

	/**
	 * Minus PIO 2.
	 *
	 * @param angRad            An angle, in radians.
	 * @return angRad - PI/2, accurately computed.
	 */
	public static double minusPIO2(final double angRad) {
		if (angRad < Math.PI / 4) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - PIO2_LO - PIO2_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - PIO2_HI - PIO2_LO;
		}
	}

	/**
	 * Strict version.
	 *
	 * @param angRad
	 *            An angle, in radians.
	 * @return angRad - PI/2, accurately computed.
	 */
	public static strictfp double minusPIO2_strict(final double angRad) {
		if (angRad < Math.PI / 4) {
			// LO then HI, for better accuracy (if starting near 0).
			return angRad - PIO2_LO - PIO2_HI;
		} else {
			// HI then LO, for better accuracy (if ending near 0).
			return angRad - PIO2_HI - PIO2_LO;
		}
	}

	/*
	 * toString (radix)
	 */

	/**
	 * Check radix.
	 *
	 * @param radix            Radix to be checked.
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified radix is not in [2,36].
	 */
	public static boolean checkRadix(final int radix) {
		if (!isInRange(Character.MIN_RADIX, Character.MAX_RADIX, radix)) {
			throw new IllegalArgumentException(
					"radix [" + radix + "] must be in [" + Character.MIN_RADIX + "," + Character.MAX_RADIX + "]");
		}
		return true;
	}

	/**
	 * Compute nbr of chars.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return Number of characters (minus sign included) to represent the specified value in the specified radix.
	 */
	public static int computeNbrOfChars(final int value, final int radix) {
		if (value < 0) {
			// 1 for sign
			return 1 + computeNbrOfDigits_negValue(value, radix);
		} else {
			return computeNbrOfDigits_negValue(-value, radix);
		}
	}

	/**
	 * Compute nbr of chars.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return Number of characters (minus sign included) to represent the specified value in the specified radix.
	 */
	public static int computeNbrOfChars(final long value, final int radix) {
		if (value < 0) {
			// 1 for sign
			return 1 + computeNbrOfDigits_negValue(value, radix);
		} else {
			return computeNbrOfDigits_negValue(-value, radix);
		}
	}

	/**
	 * Compute nbr of chars.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return Number of characters (minus sign included) to represent the specified value in the specified radix.
	 */
	public static int computeNbrOfChars(final int value, final int radix, final int paddingUpTo) {
		if (value < 0) {
			// 1 for sign
			return 1 + Math.max(paddingUpTo, computeNbrOfDigits_negValue(value, radix));
		} else {
			return Math.max(paddingUpTo, computeNbrOfDigits_negValue(-value, radix));
		}
	}

	/**
	 * Compute nbr of chars.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return Number of characters (minus sign included) to represent the specified value in the specified radix.
	 */
	public static int computeNbrOfChars(final long value, final int radix, final int paddingUpTo) {
		if (value < 0) {
			// 1 for sign
			return 1 + Math.max(paddingUpTo, computeNbrOfDigits_negValue(value, radix));
		} else {
			return Math.max(paddingUpTo, computeNbrOfDigits_negValue(-value, radix));
		}
	}

	/**
	 * Compute nbr of digits.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return Number of digits of the specified value in the specified radix.
	 */
	public static int computeNbrOfDigits(final int value, final int radix) {
		return computeNbrOfDigits_negValue(-abs(value), radix);
	}

	/**
	 * Compute nbr of digits.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return Number of digits of the specified value in the specified radix.
	 */
	public static int computeNbrOfDigits(final long value, final int radix) {
		return computeNbrOfDigits_negValue(-abs(value), radix);
	}

	/**
	 * Compute nbr of digits.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return Number of digits of the specified value in the specified radix, including the specified padding.
	 */
	public static int computeNbrOfDigits(final int value, final int radix, final int paddingUpTo) {
		return Math.max(paddingUpTo, computeNbrOfDigits(value, radix));
	}

	/**
	 * Compute nbr of digits.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return Number of digits of the specified value in the specified radix, including the specified padding.
	 */
	public static int computeNbrOfDigits(final long value, final int radix, final int paddingUpTo) {
		return Math.max(paddingUpTo, computeNbrOfDigits(value, radix));
	}

	/**
	 * This method just delegates to Integer.toString(int), but is defined here to complete the API.
	 *
	 * @param value the value
	 * @return String representation of the specified value in base 10.
	 */
	public static String toString(final int value) {
		return Integer.toString(value);
	}

	/**
	 * This method just delegates to Long.toString(long), but is defined here to complete the API.
	 *
	 * @param value the value
	 * @return String representation of the specified value in base 10.
	 */
	public static String toString(final long value) {
		return Long.toString(value);
	}

	/**
	 * To string.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return String representation of the specified value in the specified radix.
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	public static String toString(final int value, final int radix) {
		return toString(value, radix, 0);
	}

	/**
	 * To string.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @return String representation of the specified value in the specified radix.
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	public static String toString(final long value, final int radix) {
		return toString(value, radix, 0);
	}

	/**
	 * To string.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return String representation of the specified value in the specified radix.
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	public static String toString(final int value, final int radix, final int paddingUpTo) {
		// Only one test if radix+paddingUpTo != 10.
		if (radix + paddingUpTo == 10 && paddingUpTo == 0) {
			// Using JDK's optimized algorithm.
			return Integer.toString(value);
		}

		int negValue;
		final int signSize;
		final boolean negative = value < 0;
		if (negative) {
			negValue = value;
			signSize = 1;
		} else {
			negValue = -value;
			signSize = 0;
		}
		// Faster if we just use max possible number of characters (33),
		// but we prefer to take care of garbage's memory footprint.
		// Checks radix.
		final int nbrOfChars = signSize + Math.max(paddingUpTo, computeNbrOfDigits_negValue(negValue, radix));

		final char[] chars = new char[nbrOfChars];

		int charPos = nbrOfChars;

		final boolean radixIsPowerOfTwo = (radix & radix - 1) == 0;
		// Not allowing Integer.MIN_VALUE so it can be negated.
		if (radixIsPowerOfTwo && negValue != Integer.MIN_VALUE) {
			final int mask = radix - 1;
			final int divShift = DIV_SHIFT_BY_RADIX[radix];
			while (negValue <= -radix) {
				chars[--charPos] = CHAR_BY_DIGIT[-negValue & mask];
				negValue = -(-negValue >> divShift);
			}
		} else {
			while (negValue <= -radix) {
				chars[--charPos] = CHAR_BY_DIGIT[-(negValue % radix)];
				negValue /= radix;
			}
		}
		chars[--charPos] = CHAR_BY_DIGIT[-negValue];

		while (charPos > signSize) {
			chars[--charPos] = '0';
		}

		if (negative) {
			chars[0] = '-';
		}

		return new String(chars);
	}

	/**
	 * To string.
	 *
	 * @param value the value
	 * @param radix            A radix in [2,36].
	 * @param paddingUpTo            Number of digits (sign excluded) up to which left-padding with zeros is done.
	 * @return String representation of the specified value in the specified radix.
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	public static String toString(final long value, final int radix, final int paddingUpTo) {
		// Only one test if radix+paddingUpTo != 10.
		if (radix + paddingUpTo == 10 && paddingUpTo == 0) {
			// Using JDK's optimized algorithm.
			return Long.toString(value);
		}

		long negValue;
		final int signSize;
		final boolean negative = value < 0;
		if (negative) {
			negValue = value;
			signSize = 1;
		} else {
			negValue = -value;
			signSize = 0;
		}
		// Checks radix.
		final int nbrOfChars = signSize + Math.max(paddingUpTo, computeNbrOfDigits_negValue(negValue, radix));

		final char[] chars = new char[nbrOfChars];

		int charPos = nbrOfChars;

		final boolean radixIsPowerOfTwo = (radix & radix - 1) == 0;
		// Not allowing Long.MIN_VALUE so it can be negated.
		if (radixIsPowerOfTwo && negValue != Long.MIN_VALUE) {
			final int mask = radix - 1;
			final int divShift = DIV_SHIFT_BY_RADIX[radix];
			while (negValue <= -radix) {
				chars[--charPos] = CHAR_BY_DIGIT[(int) (-negValue & mask)];
				negValue = -(-negValue >> divShift);
			}
		} else {
			while (negValue <= -radix) {
				chars[--charPos] = CHAR_BY_DIGIT[(int) -(negValue % radix)];
				negValue /= radix;
			}
		}
		chars[--charPos] = CHAR_BY_DIGIT[(int) -negValue];

		while (charPos > signSize) {
			chars[--charPos] = '0';
		}

		if (negative) {
			chars[0] = '-';
		}

		return new String(chars);
	}

	/*
	 * toString (bits)
	 */

	/**
	 * Check bit positions byte.
	 *
	 * @param firstBitPos            First bit position (inclusive).
	 * @param lastBitPosExcl            Last bit position (exclusive).
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified bit range does not fit in a byte.
	 */
	public static boolean checkBitPositionsByte(final int firstBitPos, final int lastBitPosExcl) {
		return checkBitPositions(firstBitPos, lastBitPosExcl, 8);
	}

	/**
	 * Check bit positions short.
	 *
	 * @param firstBitPos            First bit position (inclusive).
	 * @param lastBitPosExcl            Last bit position (exclusive).
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified bit range does not fit in a short.
	 */
	public static boolean checkBitPositionsShort(final int firstBitPos, final int lastBitPosExcl) {
		return checkBitPositions(firstBitPos, lastBitPosExcl, 16);
	}

	/**
	 * Check bit positions int.
	 *
	 * @param firstBitPos            First bit position (inclusive).
	 * @param lastBitPosExcl            Last bit position (exclusive).
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified bit range does not fit in an int.
	 */
	public static boolean checkBitPositionsInt(final int firstBitPos, final int lastBitPosExcl) {
		return checkBitPositions(firstBitPos, lastBitPosExcl, 32);
	}

	/**
	 * Check bit positions long.
	 *
	 * @param firstBitPos            First bit position (inclusive).
	 * @param lastBitPosExcl            Last bit position (exclusive).
	 * @return True if does not throw.
	 * @throws IllegalArgumentException             if the specified bit range does not fit in a long.
	 */
	public static boolean checkBitPositionsLong(final int firstBitPos, final int lastBitPosExcl) {
		return checkBitPositions(firstBitPos, lastBitPosExcl, 64);
	}

	/**
	 * Instantiates a new numbers utils.
	 */
	private NumbersUtils() {}

	/**
	 * Min signed int for bit size no check.
	 *
	 * @param bitSize the bit size
	 * @return the int
	 */
	private static int minSignedIntForBitSize_noCheck(final int bitSize) {
		// i.e. (-1<<(bitSize-1))
		return Integer.MIN_VALUE >> 32 - bitSize;
	}

	/**
	 * Min signed long for bit size no check.
	 *
	 * @param bitSize the bit size
	 * @return the long
	 */
	private static long minSignedLongForBitSize_noCheck(final int bitSize) {
		// i.e. (-1L<<(bitSize-1))
		return Long.MIN_VALUE >> 64 - bitSize;
	}

	/**
	 * Max signed int for bit size no check.
	 *
	 * @param bitSize the bit size
	 * @return the int
	 */
	private static int maxSignedIntForBitSize_noCheck(final int bitSize) {
		// i.e. (1<<(bitSize-1))-1
		return Integer.MAX_VALUE >> 32 - bitSize;
	}

	/**
	 * Max signed long for bit size no check.
	 *
	 * @param bitSize the bit size
	 * @return the long
	 */
	private static long maxSignedLongForBitSize_noCheck(final int bitSize) {
		// i.e. (1L<<(bitSize-1))-1
		return Long.MAX_VALUE >> 64 - bitSize;
	}

	/*
	 *
	 */

	/**
	 * Compute nbr of digits neg value.
	 *
	 * @param negValue the neg value
	 * @param radix the radix
	 * @return the int
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	private static int computeNbrOfDigits_negValue(final int negValue, final int radix) {
		checkRadix(radix);
		final int maxNbrOfDigits = MAX_NBR_OF_NEG_INT_DIGITS_BY_RADIX[radix];
		int p = radix;
		for (int i = 1; i < maxNbrOfDigits; i++) {
			if (negValue > -p) { return i; }
			p *= radix;
		}
		return maxNbrOfDigits;
	}

	/**
	 * Compute nbr of digits neg value.
	 *
	 * @param negValue the neg value
	 * @param radix the radix
	 * @return the int
	 * @throws IllegalArgumentException             if the specified radix is out of range.
	 */
	private static int computeNbrOfDigits_negValue(final long negValue, final int radix) {
		checkRadix(radix);
		final int maxNbrOfDigits = MAX_NBR_OF_NEG_LONG_DIGITS_BY_RADIX[radix];
		long p = radix;
		for (int i = 1; i < maxNbrOfDigits; i++) {
			if (negValue > -p) { return i; }
			p *= radix;
		}
		return maxNbrOfDigits;
	}

	/*
	 *
	 */

	/**
	 * Check bit positions.
	 *
	 * @param firstBitPos the first bit pos
	 * @param lastBitPosExcl the last bit pos excl
	 * @param bitSize the bit size
	 * @return true, if successful
	 */
	private static boolean checkBitPositions(final int firstBitPos, final int lastBitPosExcl, final int bitSize) {
		if (firstBitPos < 0 || firstBitPos > lastBitPosExcl || lastBitPosExcl > bitSize) {
			throw new IllegalArgumentException("bit positions (first=" + firstBitPos + ",lastExcl=" + lastBitPosExcl
					+ ") must verify 0 <= first <= lastExcl <= " + bitSize);
		}
		return true;
	}

	/**
	 * Common method for byte, short and int. Could be a bit faster to have specific methods for byte and short, but not
	 * much, and that would also make more messy (byte-)code.
	 *
	 * @param bitSize            Must be in [0,32].
	 * @param bits the bits
	 * @param firstBitPos the first bit pos
	 * @param lastBitPosExcl the last bit pos excl
	 * @param bigEndian the big endian
	 * @param padding the padding
	 * @return the string
	 */
	private static String toStringBits_0_32_bitPosAlreadyChecked(final int bitSize, final int bits,
			final int firstBitPos, final int lastBitPosExcl, final boolean bigEndian, final boolean padding) {
		final int bitSizeM1 = bitSize - 1;
		final int lastBitPos = lastBitPosExcl - 1;
		if (padding) {
			final int nbrOfChars = bitSize;
			final char[] chars = new char[nbrOfChars];
			int bitIndex = bitSizeM1;
			if (bigEndian) {
				final int firstBitIndex = bitSizeM1 - lastBitPos;
				final int lastBitIndex = bitSizeM1 - firstBitPos;
				while (bitIndex > lastBitIndex) {
					chars[bitSizeM1 - bitIndex] = '_';
					--bitIndex;
				}
				while (bitIndex >= firstBitIndex) {
					chars[bitSizeM1 - bitIndex] = (char) ('0' + (bits >> bitIndex & 1));
					--bitIndex;
				}
				while (bitIndex >= 0) {
					chars[bitSizeM1 - bitIndex] = '_';
					--bitIndex;
				}
			} else {
				while (bitIndex > lastBitPos) {
					chars[bitIndex] = '_';
					--bitIndex;
				}
				while (bitIndex >= firstBitPos) {
					chars[bitIndex] = (char) ('0' + (bits >> bitIndex & 1));
					--bitIndex;
				}
				while (bitIndex >= 0) {
					chars[bitIndex] = '_';
					--bitIndex;
				}
			}
			return new String(chars);
		} else {
			final int nbrOfChars = lastBitPosExcl - firstBitPos;
			final char[] chars = new char[nbrOfChars];
			if (bigEndian) {
				final int firstBitIndex = bitSizeM1 - lastBitPos;
				final int lastBitIndex = bitSizeM1 - firstBitPos;
				int bitIndex = lastBitIndex;
				while (bitIndex >= firstBitIndex) {
					chars[lastBitIndex - bitIndex] = (char) ('0' + (bits >> bitIndex & 1));
					--bitIndex;
				}
			} else {
				int bitIndex = lastBitPos;
				while (bitIndex >= firstBitPos) {
					chars[bitIndex - firstBitPos] = (char) ('0' + (bits >> bitIndex & 1));
					--bitIndex;
				}
			}
			return new String(chars);
		}
	}
}
