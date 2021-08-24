/*******************************************************************************************************
 *
 * DateFormatter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Outputs a date in a format suitable for an OSM XML file.
 *
 * @author Brett Henderson
 */
public class DateFormatter {

	/** The calendar. */
	private final GregorianCalendar calendar;

	/**
	 * Creates a new instance.
	 */
	public DateFormatter() {
		calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * Formats a date in XML format.
	 *
	 * @param date
	 *            The date to be formatted.
	 * @return The string representing the date.
	 */
	public String format(final Date date) {
		StringBuilder result;
		int year;
		int month;
		int day;
		int hour;
		int minute;
		int second;

		calendar.setTime(date);

		result = new StringBuilder(20);

		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DATE);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);

		result.append(year);
		result.append('-');
		if (month < 10) {
			result.append('0');
		}
		result.append(month);
		result.append('-');
		if (day < 10) {
			result.append('0');
		}
		result.append(day);
		result.append('T');
		if (hour < 10) {
			result.append('0');
		}
		result.append(hour);
		result.append(':');
		if (minute < 10) {
			result.append('0');
		}
		result.append(minute);
		result.append(':');
		if (second < 10) {
			result.append('0');
		}
		result.append(second);
		result.append('Z');

		return result.toString();
	}
}
