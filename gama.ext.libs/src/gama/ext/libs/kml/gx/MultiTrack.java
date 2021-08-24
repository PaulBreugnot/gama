/*******************************************************************************************************
 *
 * MultiTrack.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import gama.ext.libs.kml.AbstractObject;
import gama.ext.libs.kml.AltitudeMode;
import gama.ext.libs.kml.BooleanConverter;
import gama.ext.libs.kml.Geometry;
import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class MultiTrack.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiTrackType", propOrder = {
    "altitudeMode",
    "interpolate",
    "track"
})
@XmlRootElement(name = "MultiTrack", namespace = "http://www.google.com/kml/ext/2.2")
public class MultiTrack
    extends Geometry
    implements Cloneable
{

    /** The altitude mode. */
    @XmlElement(defaultValue = "clampToGround")
    protected AltitudeMode altitudeMode;
    
    /** The interpolate. */
    @XmlElement(defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanConverter.class)
    protected Boolean interpolate;
    
    /** The track. */
    @XmlElement(name = "Track")
    protected List<Track> track;

    /**
     * Instantiates a new multi track.
     */
    public MultiTrack() {
        super();
    }

    /**
     * Gets the altitude mode.
     *
     * @return     possible object is
     *     {@code <}{@link Object}{@code>}
     *     {@code <}{@link gama.ext.libs.kml.AltitudeMode}{@code>}
     *     {@code <}{@link msi.gama.ext.kml.gx.AltitudeMode}{@code>}
     */
    public AltitudeMode getAltitudeMode() {
        return altitudeMode;
    }

    /**
     * Sets the altitude mode.
     *
     * @param value     allowed object is
     *     {@code <}{@link Object}{@code>}
     *     {@code <}{@link gama.ext.libs.kml.AltitudeMode}{@code>}
     *     {@code <}{@link msi.gama.ext.kml.gx.AltitudeMode}{@code>}
     */
    public void setAltitudeMode(AltitudeMode value) {
        this.altitudeMode = value;
    }

    /**
     * Checks if is interpolate.
     *
     * @return     possible object is
     *     {@link Boolean}
     */
    public Boolean isInterpolate() {
        return interpolate;
    }

    /**
     * Sets the interpolate.
     *
     * @param value     allowed object is
     *     {@link Boolean}
     */
    public void setInterpolate(Boolean value) {
        this.interpolate = value;
    }

    /**
     * Gets the track.
     *
     * @return the track
     */
    public List<Track> getTrack() {
        if (track == null) {
            track = new ArrayList<Track>();
        }
        return this.track;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = ((prime*result)+((altitudeMode == null)? 0 :altitudeMode.hashCode()));
        result = ((prime*result)+((interpolate == null)? 0 :interpolate.hashCode()));
        result = ((prime*result)+((track == null)? 0 :track.hashCode()));
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
        if (super.equals(obj) == false) {
            return false;
        }
        if ((obj instanceof MultiTrack) == false) {
            return false;
        }
        MultiTrack other = ((MultiTrack) obj);
        if (altitudeMode == null) {
            if (other.altitudeMode!= null) {
                return false;
            }
        } else {
            if (altitudeMode.equals(other.altitudeMode) == false) {
                return false;
            }
        }
        if (interpolate == null) {
            if (other.interpolate!= null) {
                return false;
            }
        } else {
            if (interpolate.equals(other.interpolate) == false) {
                return false;
            }
        }
        if (track == null) {
            if (other.track!= null) {
                return false;
            }
        } else {
            if (track.equals(other.track) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link Track} and adds it to track.
     * This method is a short version for:
     * <code>
     * Track track = new Track();
     * this.getTrack().add(track); </code>
     *
     * @return the track
     */
    public Track createAndAddTrack() {
        Track newValue = new Track();
        this.getTrack().add(newValue);
        return newValue;
    }

    /**
     * Sets the value of the track property Objects of the following type(s) are allowed in the list List<Track>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withTrack} instead.
     *
     * @param track the new track
     */
    public void setTrack(final List<Track> track) {
        this.track = track;
    }

    /**
     * add a value to the track property collection.
     *
     * @param track     Objects of the following type are allowed in the list: {@link Track}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public MultiTrack addToTrack(final Track track) {
        this.getTrack().add(track);
        return this;
    }

    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public MultiTrack addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public void setGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
        super.setGeometrySimpleExtension(geometrySimpleExtension);
    }

    @Obvious
    @Override
    public MultiTrack addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
        super.getGeometrySimpleExtension().add(geometrySimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public void setGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
        super.setGeometryObjectExtension(geometryObjectExtension);
    }

    @Obvious
    @Override
    public MultiTrack addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
        super.getGeometryObjectExtension().add(geometryObjectExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param altitudeMode     required parameter
     * @return the multi track
     * @see #setAltitudeMode(Object)
     */
    public MultiTrack withAltitudeMode(final  AltitudeMode altitudeMode) {
        this.setAltitudeMode(altitudeMode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param interpolate     required parameter
     * @return the multi track
     * @see #setInterpolate(Boolean)
     */
    public MultiTrack withInterpolate(final Boolean interpolate) {
        this.setInterpolate(interpolate);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param track     required parameter
     * @return the multi track
     * @see #setTrack(List<Track>)
     */
    public MultiTrack withTrack(final List<Track> track) {
        this.setTrack(track);
        return this;
    }

    @Obvious
    @Override
    public MultiTrack withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public MultiTrack withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public MultiTrack withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Obvious
    @Override
    public MultiTrack withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
        super.withGeometrySimpleExtension(geometrySimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public MultiTrack withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
        super.withGeometryObjectExtension(geometryObjectExtension);
        return this;
    }

    @Override
    public MultiTrack clone() {
        MultiTrack copy;
        copy = ((MultiTrack) super.clone());
        copy.track = new ArrayList<Track>((getTrack().size()));
        for (Track iter: track) {
            copy.track.add(iter.clone());
        }
        return copy;
    }

}
