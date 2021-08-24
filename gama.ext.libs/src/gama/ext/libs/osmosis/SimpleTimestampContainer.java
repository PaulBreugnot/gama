/*******************************************************************************************************
 *
 * SimpleTimestampContainer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Date;

/**
 * A timestamp container implementation that holds a standard date object.
 *
 * @author Brett Henderson
 */
public class SimpleTimestampContainer implements TimestampContainer {

	/** The timestamp. */
	private final Date timestamp;

	/**
	 * Creates a new instance.
	 *
	 * @param timestamp
	 *            The timestamp to be managed.
	 */
	public SimpleTimestampContainer(final Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFormattedTimestamp(final TimestampFormat timestampFormat) {
		return timestampFormat.formatTimestamp(timestamp);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date getTimestamp() {
		return timestamp;
	}
}
