/*******************************************************************************************************
 *
 * OsmosisRuntimeException.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * The root of the unchecked exception hierarchy for the application. All typed runtime exceptions subclass this
 * exception.
 *
 * @author Brett Henderson
 */
public class OsmosisRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception.
	 */
	public OsmosisRuntimeException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 *
	 * @param message
	 *            the detail message.
	 */
	public OsmosisRuntimeException(final String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause.
	 * 
	 * @param cause
	 *            the cause.
	 */
	public OsmosisRuntimeException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause.
	 */
	public OsmosisRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
