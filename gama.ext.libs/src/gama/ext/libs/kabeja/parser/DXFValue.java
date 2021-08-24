/*******************************************************************************************************
 *
 * DXFValue.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;


/**
 * This is a helper class, which convert to different output formats.
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 *
 */
public final class DXFValue {
    
    /** The value. */
    private String value;
    
    /** The integer value. */
    private int integerValue = Integer.MAX_VALUE;

    /**
     * Instantiates a new DXF value.
     */
    public DXFValue() {
        super();
    }

    /**
     * Instantiates a new DXF value.
     *
     * @param value the value
     */
    public DXFValue(String value) {
        setValue(value);
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value The value to set.
     */
    private void setValue(String value) {
        this.value = value.trim();
    }

    /**
     * Gets the double value.
     *
     * @return the double value
     */
    public double getDoubleValue() {
        return Double.parseDouble(value);
    }

    /**
     * Gets the integer value.
     *
     * @return the integer value
     */
    public int getIntegerValue() {
        return Integer.parseInt(value);
    }

    /**
     * Convert the DXF value to boolean
     * 0 -> false
     * 1 -> true.
     *
     * @return the boolean value
     */
    public boolean getBooleanValue() {
        //0 -> true
        //else -> false
        return (getIntegerValue() == 0) ? true : false;
    }

    public String toString() {
        return value;
    }

    /**
     * Checks if is bit set.
     *
     * @param pos the pos
     * @return true, if is bit set
     */
    public boolean isBitSet(int pos) {
        if (this.integerValue == Integer.MAX_VALUE) {
            this.integerValue = getIntegerValue();
        }

        return (this.integerValue & pos) == pos;
    }
}
