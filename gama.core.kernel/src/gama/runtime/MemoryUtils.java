/*******************************************************************************************************
 *
 * MemoryUtils.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.runtime;

import gama.common.preferences.GamaPreferences;

/**
 * All-purpose static-method container class.
 *
 * @author Sebastiano Vigna
 * @since 0.1
 */

public final class MemoryUtils {
	
	/**
	 * Instantiates a new memory utils.
	 */
	private MemoryUtils() {}

	/** A static reference to {@link Runtime#getRuntime()}. */
	public final static Runtime RUNTIME = Runtime.getRuntime();

	/**
	 * Returns true if less then a percentage of the available memory is free.
	 *
	 * @return true, if successful
	 */
	public static boolean memoryIsLow() {
		return availableMemory() * 100 < RUNTIME.totalMemory()
				* GamaPreferences.Runtime.CORE_MEMORY_PERCENTAGE.getValue();
	}

	/**
	 * Returns the amount of available memory (free memory plus never allocated memory).
	 *
	 * @return the amount of available memory, in bytes.
	 */
	public static long availableMemory() {
		return RUNTIME.freeMemory() + RUNTIME.maxMemory() - RUNTIME.totalMemory();
	}

}
