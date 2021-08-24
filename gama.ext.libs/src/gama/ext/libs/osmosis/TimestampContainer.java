/*******************************************************************************************************
 *
 * TimestampContainer.java, in gama.ext.libs, is part of the source code of the
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
 * Defines the interface for a class holding timestamps in one or both of parsed and unparsed forms. This allows a date
 * to remain in text form throughout a pipeline if both ends utilise the date in the same format.
 *
 * @author Brett Henderson
 */
public interface TimestampContainer {

	/**
	 * Gets the timestamp.
	 *
	 * @return The timestamp.
	 */
	Date getTimestamp();

	/**
	 * Gets the timestamp in a string format.
	 *
	 * @param timestampFormat
	 *            The formatter to use for formatting the timestamp into a string.
	 * @return The timestamp string.
	 */
	String getFormattedTimestamp(TimestampFormat timestampFormat);
}
