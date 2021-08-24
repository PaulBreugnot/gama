/*******************************************************************************************************
 *
 * GridOrigin.java, in gama.ext.libs, is part of the source code of the
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
 * GridOrigin
 * <p>
 * lowerLeft, upperLeft 
 * </p>
 * 
 * See Also: 
 * See <PhotoOverlay>.
 */
@XmlType(name = "gridOriginEnumType")
@XmlEnum
public enum GridOrigin {

    /** The lower left. */
    @XmlEnumValue("lowerLeft")
    LOWER_LEFT("lowerLeft"),
    
    /** The upper left. */
    @XmlEnumValue("upperLeft")
    UPPER_LEFT("upperLeft");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new grid origin.
     *
     * @param v the v
     */
    GridOrigin(String v) {
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
     * @return the grid origin
     */
    public static GridOrigin fromValue(String v) {
        for (GridOrigin c: GridOrigin.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
