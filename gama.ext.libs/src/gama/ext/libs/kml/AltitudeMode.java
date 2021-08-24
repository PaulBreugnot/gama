/*******************************************************************************************************
 *
 * AltitudeMode.java, in gama.ext.libs, is part of the source code of the
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
 * AltitudeMode
 * <p>
 * clampToGround, relativeToGround, absolute 
 * </p>
 * 
 * See Also: 
 * See <LookAt> and <Region>.
 */
@XmlType(name = "altitudeModeEnumType")
@XmlEnum
public enum AltitudeMode {

    /** The clamp to ground. */
    @XmlEnumValue("clampToGround")
    CLAMP_TO_GROUND("clampToGround"),
    
    /** The relative to ground. */
    @XmlEnumValue("relativeToGround")
    RELATIVE_TO_GROUND("relativeToGround"),
    
    /** The absolute. */
    @XmlEnumValue("absolute")
    ABSOLUTE("absolute"),
    
    /** The clamp to sea floor. */
    @XmlEnumValue("clampToSeaFloor")
    CLAMP_TO_SEA_FLOOR("clampToSeaFloor"),
    
    /** The relative to sea floor. */
    @XmlEnumValue("relativeToSeaFloor")
    RELATIVE_TO_SEA_FLOOR("relativeToSeaFloor");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new altitude mode.
     *
     * @param v the v
     */
    AltitudeMode(String v) {
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
     * @return the altitude mode
     */
    public static AltitudeMode fromValue(String v) {
        for (AltitudeMode c: AltitudeMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
