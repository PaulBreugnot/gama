/*******************************************************************************************************
 *
 * StyleState.java, in gama.ext.libs, is part of the source code of the
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
 * <Style>
 * <p>
 * A Style defines an addressable style group that can be referenced by StyleMaps and 
 * Features. Styles affect how Geometry is presented in the 3D viewer and how Features 
 * appear in the Places panel of the List view. Shared styles are collected in a <Document> 
 * and must have an id defined for them so that they can be referenced by the individual 
 * Features that use them. 
 * </p>
 * <p>
 * A Style defines an addressable style group that can be referenced by StyleMaps and 
 * Features. Styles affect how Geometry is presented in the 3D viewer and how Features 
 * appear in the Places panel of the List view. Shared styles are collected in a <Document> 
 * and must have an id defined for them so that they can be referenced by the individual 
 * Features that use them. 
 * </p>
 * <p>
 * Use an id to refer to the style from a <styleUrl>. 
 * </p>
 * 
 * Syntax: 
 * <pre><strong>&lt;Style id="ID"&gt;
 * </strong>&lt;!-- extends StyleSelector --&gt;
 * 
 * &lt;!-- specific to Style --&gt;
 *   &lt;IconStyle&gt;...&lt;/IconStyle&gt;
 *   &lt;LabelStyle&gt;...&lt;/LabelStyle&gt;
 *   &lt;LineStyle&gt;...&lt;/LineStyle&gt;
 *   &lt;PolyStyle&gt;...&lt;/PolyStyle&gt;
 *   &lt;BalloonStyle&gt;...&lt;/BalloonStyle&gt;
 *   &lt;ListStyle&gt;<strong>...</strong>&lt;/ListStyle&gt;<strong>
 * &lt;/Style&gt;</strong></pre>
 * 
 * Extends: 
 * @see: <StyleSelector>
 * 
 * Contained By: 
 * @see: <Feature>
 * 
 * 
 * 
 */
@XmlType(name = "styleStateEnumType")
@XmlEnum
public enum StyleState {

    /** The normal. */
    @XmlEnumValue("normal")
    NORMAL("normal"),
    
    /** The highlight. */
    @XmlEnumValue("highlight")
    HIGHLIGHT("highlight");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new style state.
     *
     * @param v the v
     */
    StyleState(String v) {
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
     * @return the style state
     */
    public static StyleState fromValue(String v) {
        for (StyleState c: StyleState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
