/*******************************************************************************************************
 *
 * SoundCue.java, in gama.ext.libs, is part of the source code of the
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
 * The Class SoundCue.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoundCueType", propOrder = {
    "href",
    "delayedStart"
})
@XmlRootElement(name = "SoundCue", namespace = "http://www.google.com/kml/ext/2.2")
public class SoundCue
    extends TourPrimitive
    implements Cloneable
{

    /** The href. */
    @XmlElement(namespace = "http://www.opengis.net/kml/2.2")
    protected String href;
    
    /** The delayed start. */
    @XmlElement(defaultValue = "0.0")
    protected double delayedStart;

    /**
     * Instantiates a new sound cue.
     */
    public SoundCue() {
        super();
    }

    /**
     * Gets the href.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the href.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the delayed start.
     *
     * @return     possible object is
     *     {@link Double}
     */
    public double getDelayedStart() {
        return delayedStart;
    }

    /**
     * Sets the delayed start.
     *
     * @param value     allowed object is
     *     {@link Double}
     */
    public void setDelayedStart(double value) {
        this.delayedStart = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        result = ((prime*result)+((href == null)? 0 :href.hashCode()));
        temp = Double.doubleToLongBits(delayedStart);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
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
        if ((obj instanceof SoundCue) == false) {
            return false;
        }
        SoundCue other = ((SoundCue) obj);
        if (href == null) {
            if (other.href!= null) {
                return false;
            }
        } else {
            if (href.equals(other.href) == false) {
                return false;
            }
        }
        if (delayedStart!= other.delayedStart) {
            return false;
        }
        return true;
    }

    /**
     * fluent setter.
     *
     * @param href     required parameter
     * @return the sound cue
     * @see #setHref(String)
     */
    public SoundCue withHref(final String href) {
        this.setHref(href);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param delayedStart     required parameter
     * @return the sound cue
     * @see #setDelayedStart(double)
     */
    public SoundCue withDelayedStart(final double delayedStart) {
        this.setDelayedStart(delayedStart);
        return this;
    }

    @Obvious
    @Override
    public SoundCue withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public SoundCue withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public SoundCue withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public SoundCue clone() {
        SoundCue copy;
        copy = ((SoundCue) super.clone());
        return copy;
    }

}
