/*******************************************************************************************************
 *
 * RefreshMode.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * RefreshMode
 * <p>
 * onChange, onInterval, onExpire 
 * </p>
 * 
 * See Also: 
 * See <Link>.
 */
@XmlType(name = "refreshModeEnumType")
@XmlEnum
public enum RefreshMode {

    /** The on change. */
    @XmlEnumValue("onChange")
    ON_CHANGE("onChange"),
    
    /** The on interval. */
    @XmlEnumValue("onInterval")
    ON_INTERVAL("onInterval"),
    
    /** The on expire. */
    @XmlEnumValue("onExpire")
    ON_EXPIRE("onExpire");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new refresh mode.
     *
     * @param v the v
     */
    RefreshMode(String v) {
        value = v;
    }

    /**
     * Value.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value.
     *
     * @param v the v
     * @return the refresh mode
     */
    public static RefreshMode fromValue(String v) {
        for (RefreshMode c: RefreshMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
