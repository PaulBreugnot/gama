/*******************************************************************************************************
 *
 * FileFormatException.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.osmosis;

import java.io.IOException;

/**
 * The Class FileFormatException.
 */
public class FileFormatException extends IOException {

	/**
	 * Instantiates a new file format exception.
	 *
	 * @param string the string
	 */
	public FileFormatException(final String string) {
		super(string);
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8128010128748910923L;

}
