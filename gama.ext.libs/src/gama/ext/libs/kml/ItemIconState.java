/*******************************************************************************************************
 *
 * ItemIconState.java, in gama.ext.libs, is part of the source code of the
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
 * <itemicon>
 * <p>
 * <state> Specifies the current state of the NetworkLink or Folder. Possible values 
 * are open, closed, error, fetching0, fetching1, and fetching2. These values can be 
 * combined by inserting a space between two values (no comma). <href> Specifies the 
 * URI of the image used in the List View for the Feature. 
 * </p>
 * <p>
 * Icon used in the List view that reflects the state of a Folder or Link fetch. Icons 
 * associated with the open and closed modes are used for Folders and Network Links. 
 * Icons associated with the error and fetching0, fetching1, and fetching2 modes are 
 * used for Network Links. The following screen capture illustrates the Google Earth 
 * icons for these states: 
 * </p>
 * 
 * 
 * 
 */
@XmlType(name = "itemIconStateEnumType")
@XmlEnum
public enum ItemIconState {

    /** The open. */
    @XmlEnumValue("open")
    OPEN("open"),
    
    /** The closed. */
    @XmlEnumValue("closed")
    CLOSED("closed"),
    
    /** The error. */
    @XmlEnumValue("error")
    ERROR("error"),
    
    /** The fetching 0. */
    @XmlEnumValue("fetching0")
    FETCHING_0("fetching0"),
    
    /** The fetching 1. */
    @XmlEnumValue("fetching1")
    FETCHING_1("fetching1"),
    
    /** The fetching 2. */
    @XmlEnumValue("fetching2")
    FETCHING_2("fetching2");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new item icon state.
     *
     * @param v the v
     */
    ItemIconState(String v) {
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
     * @return the item icon state
     */
    public static ItemIconState fromValue(String v) {
        for (ItemIconState c: ItemIconState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
