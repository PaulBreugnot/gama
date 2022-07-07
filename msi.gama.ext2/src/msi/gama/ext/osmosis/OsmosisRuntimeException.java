// This software is released into the Public Domain. See copying.txt for details.
package msi.gama.ext.osmosis;

/**
 * The root of the unchecked exception hierarchy for the application. All typed runtime exceptions subclass this
 * exception.
 *
 * @author Brett Henderson
 */
public class OsmosisRuntimeException extends RuntimeException {

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
