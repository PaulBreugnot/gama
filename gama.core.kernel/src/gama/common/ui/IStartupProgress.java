/*******************************************************************************************************
 *
 * IStartupProgress.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.common.ui;

import gama.runtime.GAMA;

/**
 * The Interface IStartupProgress.
 */
public interface IStartupProgress extends AutoCloseable {

	/**
	 * The Class Null.
	 */
	class Null implements IStartupProgress {

		@Override
		public void add(final String task) {}

	}

	/** The default msg. */
	String DEFAULT_MSG = "Loading GAMA...";

	/**
	 * Adds a string to display.
	 *
	 * @param task
	 *            the task
	 */
	void add(String task);

	/**
	 * Close the startup progress monitor. Default is to remove it from GAMA
	 */
	@Override
	default void close() {
		GAMA.setStartupProgressListener(null);
	}

}
