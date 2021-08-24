/*******************************************************************************************************
 *
 * Display2D.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.common;

import java.io.Serializable;

/**
 * The Class Display2D.
 */
public class Display2D implements Serializable {

	/** The path. */
	private String path;

	// private String key;

	/**
	 * Value of.
	 *
	 * @param path the path
	 * @return the display 2 D
	 */
	public static Display2D valueOf(final String path) {
		return new Display2D(path);
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(final String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return path;
	}

	/**
	 * Instantiates a new display 2 D.
	 *
	 * @param path the path
	 */
	public Display2D(final String path) {
		this.path = path;
	}

}
