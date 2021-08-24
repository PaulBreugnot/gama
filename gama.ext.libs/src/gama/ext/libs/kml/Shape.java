/*******************************************************************************************************
 *
 * Shape.java, in gama.ext.libs, is part of the source code of the
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
 * Shape
 * <p>
 * rectangle, cylinder, sphere 
 * </p>
 * 
 * See Also: 
 * See <PhotoOverlay>.
 */
@XmlType(name = "shapeEnumType")
@XmlEnum
public enum Shape {

    /** The rectangle. */
    @XmlEnumValue("rectangle")
    RECTANGLE("rectangle"),
    
    /** The cylinder. */
    @XmlEnumValue("cylinder")
    CYLINDER("cylinder"),
    
    /** The sphere. */
    @XmlEnumValue("sphere")
    SPHERE("sphere");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new shape.
     *
     * @param v the v
     */
    Shape(String v) {
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
     * @return the shape
     */
    public static Shape fromValue(String v) {
        for (Shape c: Shape.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
