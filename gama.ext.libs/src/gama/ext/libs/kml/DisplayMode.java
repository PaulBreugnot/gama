/*******************************************************************************************************
 *
 * DisplayMode.java, in gama.ext.libs, is part of the source code of the
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
 * DisplayMode
 * <p>
 * default, hide 
 * </p>
 * 
 * See Also: 
 * See <BalloonStyle>.
 */
@XmlType(name = "displayModeEnumType")
@XmlEnum
public enum DisplayMode {

    /** The default. */
    @XmlEnumValue("default")
    DEFAULT("default"),
    
    /** The hide. */
    @XmlEnumValue("hide")
    HIDE("hide");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new display mode.
     *
     * @param v the v
     */
    DisplayMode(String v) {
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
     * @return the display mode
     */
    public static DisplayMode fromValue(String v) {
        for (DisplayMode c: DisplayMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
