/*******************************************************************************************************
 *
 * TourPrimitive.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.AbstractObject;


/**
 * <gx:TourPrimitive>
 * <p>
 * Elements extended from gx:TourPrimitive provide instructions to KML browsers during 
 * tours, including points to fly to and the duration of those flights, pauses, updates 
 * to KML features, and sound files to play. 
 * </p>
 * <p>
 * These elements must be contained within a <gx:Playlist> element, which in turn is 
 * contained with a <gx:Tour> element. 
 * </p>
 * <p>
 * This is an abstract element and cannot be used directly in a KML file. This element 
 * is extended by the <gx:FlyTo>, <gx:AnimatedUpdate>, <gx:TourControl>, <gx:Wait>, 
 * and <gx:SoundCue> elements. 
 * </p>
 * 
 * Syntax: 
 * <pre>&lt;gx:Tour&gt;
 *   &lt;gx:Playlist&gt;
 * 
 *     &lt;!-- abstract element; do not create --&gt;
 *     <strong>&lt;!-- gx:TourPrimitive --&gt;</strong>    &lt;!-- gx:AnimatedUpdate, gx:FlyTo, gx:TourControl, gx:SoundCue, gx:Wait --&gt;
 *         &lt;!-- extends <strong>Object</strong> --&gt;
 *     <strong>&lt;!-- /gx:TourPrimitive --&gt;</strong>
 * 
 *   &lt;/gx:Playlist&gt;
 * &lt;/gx:Tour&gt;
 * </pre>
 * 
 * Extends: 
 * @see: <Object>
 * 
 * Extended By: 
 * @see: <gx:AnimatedUpdate>
 * @see: <gx:FlyTo>
 * @see: <gx:SoundCue>
 * @see: <gx:TourControl>
 * @see: <gx:Wait>
 * 
 * Contained By: 
 * @see: <gx:Playlist>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTourPrimitiveType")
@XmlSeeAlso({
    Wait.class,
    AnimatedUpdate.class,
    TourControl.class,
    FlyTo.class,
    SoundCue.class
})
public abstract class TourPrimitive
    extends AbstractObject
    implements Cloneable
{


    /**
     * Instantiates a new tour primitive.
     */
    public TourPrimitive() {
        super();
    }

    @Override
    public TourPrimitive clone() {
        TourPrimitive copy;
        copy = ((TourPrimitive) super.clone());
        return copy;
    }

}
