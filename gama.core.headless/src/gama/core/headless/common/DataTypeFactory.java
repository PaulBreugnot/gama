/*******************************************************************************************************
 *
 * DataTypeFactory.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.common;

/**
 * A factory for creating DataType objects.
 */
public final class DataTypeFactory {

	/**
	 * Gets the object meta data.
	 *
	 * @param val the val
	 * @return the object meta data
	 */
	public static DataType getObjectMetaData(final Object val) {
		DataType type;
		if (val instanceof Integer || val instanceof Long) {
			type = DataType.INT;
		} else if (val instanceof Float || val instanceof Double) {
			type = DataType.FLOAT;
		} else if (val instanceof Boolean) {
			type = DataType.BOOLEAN;
		} else if (val instanceof String) {
			type = DataType.STRING;
		} else {
			type = DataType.UNDEFINED;
		}
		return type;
	}

	/**
	 * Gets the object from text.
	 *
	 * @param val the val
	 * @param t the t
	 * @return the object from text
	 */
	public static Object getObjectFromText(final String val, final DataType t) {
		if (t.equals(DataType.INT)) return Integer.valueOf(val);
		if (t.equals(DataType.BOOLEAN)) return Boolean.valueOf(val);
		// See #3006
		if (t.equals(DataType.FLOAT)) return Double.valueOf(val);
		if (t.equals(DataType.STRING)) return val;
		return val;
	}

}
