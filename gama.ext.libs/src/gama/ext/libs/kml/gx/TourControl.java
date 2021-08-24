/*******************************************************************************************************
 *
 * TourControl.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class TourControl.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TourControlType", propOrder = {
    "playMode"
})
@XmlRootElement(name = "TourControl", namespace = "http://www.google.com/kml/ext/2.2")
public class TourControl
    extends TourPrimitive
    implements Cloneable
{

    /** The play mode. */
    @XmlElement(defaultValue = "pause")
    protected PlayMode playMode;

    /**
     * Instantiates a new tour control.
     */
    public TourControl() {
        super();
    }

    /**
     * Gets the play mode.
     *
     * @return     possible object is
     *     {@link PlayMode}
     */
    public PlayMode getPlayMode() {
        return playMode;
    }

    /**
     * Sets the play mode.
     *
     * @param value     allowed object is
     *     {@link PlayMode}
     */
    public void setPlayMode(PlayMode value) {
        this.playMode = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((playMode == null)? 0 :playMode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if ((obj instanceof TourControl) == false) {
            return false;
        }
        TourControl other = ((TourControl) obj);
        if (playMode == null) {
            if (other.playMode!= null) {
                return false;
            }
        } else {
            if (playMode.equals(other.playMode) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * fluent setter.
     *
     * @param playMode     required parameter
     * @return the tour control
     * @see #setPlayMode(PlayMode)
     */
    public TourControl withPlayMode(final PlayMode playMode) {
        this.setPlayMode(playMode);
        return this;
    }

    @Obvious
    @Override
    public TourControl withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public TourControl withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public TourControl withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public TourControl clone() {
        TourControl copy;
        copy = ((TourControl) super.clone());
        return copy;
    }

}
