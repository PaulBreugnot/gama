/*******************************************************************************************************
 *
 * ListItemType.java, in gama.ext.libs, is part of the source code of the
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
 * <listitemtype>
 * <p>
 * Specifies how a Feature is displayed in the list view. Possible values are: check 
 * (default) - The Feature's visibility is tied to its item's checkbox. radioFolder 
 * - When specified for a Container, only one of the Container's items is visible at 
 * a time checkOffOnly - When specified for a Container or Network Link, prevents all 
 * items from being made visible at once—that is, the user can turn everything in the 
 * Container or Network Link off but cannot turn everything on at the same time. This 
 * setting is useful for Containers or Network Links containing large amounts of data. 
 * checkHideChildren - Use a normal checkbox for visibility but do not display the 
 * Container or Network Link's children in the list view. A checkbox allows the user 
 * to toggle visibility of the child objects in the viewer. 
 * </p>
 * 
 * 
 * 
 */
@XmlType(name = "listItemTypeEnumType")
@XmlEnum
public enum ListItemType {

    /** The radio folder. */
    @XmlEnumValue("radioFolder")
    RADIO_FOLDER("radioFolder"),
    
    /** The check. */
    @XmlEnumValue("check")
    CHECK("check"),
    
    /** The check hide children. */
    @XmlEnumValue("checkHideChildren")
    CHECK_HIDE_CHILDREN("checkHideChildren"),
    
    /** The check off only. */
    @XmlEnumValue("checkOffOnly")
    CHECK_OFF_ONLY("checkOffOnly");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new list item type.
     *
     * @param v the v
     */
    ListItemType(String v) {
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
     * @return the list item type
     */
    public static ListItemType fromValue(String v) {
        for (ListItemType c: ListItemType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
