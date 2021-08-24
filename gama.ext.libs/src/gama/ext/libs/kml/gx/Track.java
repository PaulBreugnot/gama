/*******************************************************************************************************
 *
 * Track.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import gama.ext.libs.kml.AbstractObject;
import gama.ext.libs.kml.AltitudeMode;
import gama.ext.libs.kml.BooleanConverter;
import gama.ext.libs.kml.ExtendedData;
import gama.ext.libs.kml.Geometry;
import gama.ext.libs.kml.Model;
import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class Track.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackType", propOrder = {
    "extrude",
    "tessellate",
    "altitudeMode",
    "when",
    "coord",
    "angles",
    "model",
    "extendedData",
    "trackSimpleExtension"
})
@XmlRootElement(name = "Track", namespace = "http://www.google.com/kml/ext/2.2")
public class Track
    extends Geometry
    implements Cloneable
{

    /** The extrude. */
    @XmlElement(namespace = "http://www.opengis.net/kml/2.2", defaultValue = "0")
    @XmlJavaTypeAdapter(BooleanConverter.class)
    protected Boolean extrude;
    
    /** The tessellate. */
    @XmlElement(namespace = "http://www.opengis.net/kml/2.2", defaultValue = "0")
    @XmlJavaTypeAdapter(BooleanConverter.class)
    protected Boolean tessellate;
    
    /** The altitude mode. */
    @XmlElement(defaultValue = "clampToGround")
    protected AltitudeMode altitudeMode;
    
    /** The when. */
    @XmlElement(namespace = "http://www.opengis.net/kml/2.2")
    protected List<String> when;
    
    /** The coord. */
    protected List<String> coord;
    
    /** The angles. */
    protected List<String> angles;
    
    /** The model. */
    @XmlElement(name = "Model", namespace = "http://www.opengis.net/kml/2.2")
    protected Model model;
    
    /** The extended data. */
    @XmlElement(name = "ExtendedData", namespace = "http://www.opengis.net/kml/2.2")
    protected ExtendedData extendedData;
    
    /** The track simple extension. */
    @XmlElement(name = "AbstractTrackSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> trackSimpleExtension;

    /**
     * Instantiates a new track.
     */
    public Track() {
        super();
    }

    /**
     * Checks if is extrude.
     *
     * @return     possible object is
     *     {@link Boolean}
     */
    public Boolean isExtrude() {
        return extrude;
    }

    /**
     * Sets the extrude.
     *
     * @param value     allowed object is
     *     {@link Boolean}
     */
    public void setExtrude(Boolean value) {
        this.extrude = value;
    }

    /**
     * Checks if is tessellate.
     *
     * @return     possible object is
     *     {@link Boolean}
     */
    public Boolean isTessellate() {
        return tessellate;
    }

    /**
     * Sets the tessellate.
     *
     * @param value     allowed object is
     *     {@link Boolean}
     */
    public void setTessellate(Boolean value) {
        this.tessellate = value;
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
     * Gets the when.
     *
     * @return the when
     */
    public List<String> getWhen() {
        if (when == null) {
            when = new ArrayList<String>();
        }
        return this.when;
    }

    /**
     * Gets the coord.
     *
     * @return the coord
     */
    public List<String> getCoord() {
        if (coord == null) {
            coord = new ArrayList<String>();
        }
        return this.coord;
    }

    /**
     * Gets the angles.
     *
     * @return the angles
     */
    public List<String> getAngles() {
        if (angles == null) {
            angles = new ArrayList<String>();
        }
        return this.angles;
    }

    /**
     * Gets the model.
     *
     * @return     possible object is
     *     {@link Model}
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value     allowed object is
     *     {@link Model}
     */
    public void setModel(Model value) {
        this.model = value;
    }

    /**
     * Gets the extended data.
     *
     * @return     possible object is
     *     {@link ExtendedData}
     */
    public ExtendedData getExtendedData() {
        return extendedData;
    }

    /**
     * Sets the extended data.
     *
     * @param value     allowed object is
     *     {@link ExtendedData}
     */
    public void setExtendedData(ExtendedData value) {
        this.extendedData = value;
    }

    /**
     * Gets the track simple extension.
     *
     * @return the track simple extension
     */
    public List<Object> getTrackSimpleExtension() {
        if (trackSimpleExtension == null) {
            trackSimpleExtension = new ArrayList<Object>();
        }
        return this.trackSimpleExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = ((prime*result)+((extrude == null)? 0 :extrude.hashCode()));
        result = ((prime*result)+((tessellate == null)? 0 :tessellate.hashCode()));
        result = ((prime*result)+((altitudeMode == null)? 0 :altitudeMode.hashCode()));
        result = ((prime*result)+((when == null)? 0 :when.hashCode()));
        result = ((prime*result)+((coord == null)? 0 :coord.hashCode()));
        result = ((prime*result)+((angles == null)? 0 :angles.hashCode()));
        result = ((prime*result)+((model == null)? 0 :model.hashCode()));
        result = ((prime*result)+((extendedData == null)? 0 :extendedData.hashCode()));
        result = ((prime*result)+((trackSimpleExtension == null)? 0 :trackSimpleExtension.hashCode()));
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
        if ((obj instanceof Track) == false) {
            return false;
        }
        Track other = ((Track) obj);
        if (extrude == null) {
            if (other.extrude!= null) {
                return false;
            }
        } else {
            if (extrude.equals(other.extrude) == false) {
                return false;
            }
        }
        if (tessellate == null) {
            if (other.tessellate!= null) {
                return false;
            }
        } else {
            if (tessellate.equals(other.tessellate) == false) {
                return false;
            }
        }
        if (altitudeMode == null) {
            if (other.altitudeMode!= null) {
                return false;
            }
        } else {
            if (altitudeMode.equals(other.altitudeMode) == false) {
                return false;
            }
        }
        if (when == null) {
            if (other.when!= null) {
                return false;
            }
        } else {
            if (when.equals(other.when) == false) {
                return false;
            }
        }
        if (coord == null) {
            if (other.coord!= null) {
                return false;
            }
        } else {
            if (coord.equals(other.coord) == false) {
                return false;
            }
        }
        if (angles == null) {
            if (other.angles!= null) {
                return false;
            }
        } else {
            if (angles.equals(other.angles) == false) {
                return false;
            }
        }
        if (model == null) {
            if (other.model!= null) {
                return false;
            }
        } else {
            if (model.equals(other.model) == false) {
                return false;
            }
        }
        if (extendedData == null) {
            if (other.extendedData!= null) {
                return false;
            }
        } else {
            if (extendedData.equals(other.extendedData) == false) {
                return false;
            }
        }
        if (trackSimpleExtension == null) {
            if (other.trackSimpleExtension!= null) {
                return false;
            }
        } else {
            if (trackSimpleExtension.equals(other.trackSimpleExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link Model} and set it to model.
     * 
     * This method is a short version for:
     * <code>
     * Model model = new Model();
     * this.setModel(model); </code>
     *
     * @return the model
     */
    public Model createAndSetModel() {
        Model newValue = new Model();
        this.setModel(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ExtendedData} and set it to extendedData.
     * 
     * This method is a short version for:
     * <code>
     * ExtendedData extendedData = new ExtendedData();
     * this.setExtendedData(extendedData); </code>
     *
     * @return the extended data
     */
    public ExtendedData createAndSetExtendedData() {
        ExtendedData newValue = new ExtendedData();
        this.setExtendedData(newValue);
        return newValue;
    }

    /**
     * Sets the value of the when property Objects of the following type(s) are allowed in the list List<String>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withWhen} instead.
     *
     * @param when the new when
     */
    public void setWhen(final List<String> when) {
        this.when = when;
    }

    /**
     * add a value to the when property collection.
     *
     * @param when     Objects of the following type are allowed in the list: {@link String}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Track addToWhen(final String when) {
        this.getWhen().add(when);
        return this;
    }

    /**
     * Sets the value of the coord property Objects of the following type(s) are allowed in the list List<String>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withCoord} instead.
     *
     * @param coord the new coord
     */
    public void setCoord(final List<String> coord) {
        this.coord = coord;
    }

    /**
     * add a value to the coord property collection.
     *
     * @param coord     Objects of the following type are allowed in the list: {@link String}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Track addToCoord(final String coord) {
        this.getCoord().add(coord);
        return this;
    }

    /**
     * Sets the value of the angles property Objects of the following type(s) are allowed in the list List<String>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withAngles} instead.
     *
     * @param angles the new angles
     */
    public void setAngles(final List<String> angles) {
        this.angles = angles;
    }

    /**
     * add a value to the angles property collection.
     *
     * @param angles     Objects of the following type are allowed in the list: {@link String}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Track addToAngles(final String angles) {
        this.getAngles().add(angles);
        return this;
    }

    /**
     * Sets the value of the trackSimpleExtension property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withTrackSimpleExtension} instead.
     *
     * @param trackSimpleExtension the new track simple extension
     */
    public void setTrackSimpleExtension(final List<Object> trackSimpleExtension) {
        this.trackSimpleExtension = trackSimpleExtension;
    }

    /**
     * add a value to the trackSimpleExtension property collection.
     *
     * @param trackSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Track addToTrackSimpleExtension(final Object trackSimpleExtension) {
        this.getTrackSimpleExtension().add(trackSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public Track addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
    public Track addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
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
    public Track addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
        super.getGeometryObjectExtension().add(geometryObjectExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param extrude     required parameter
     * @return the track
     * @see #setExtrude(Boolean)
     */
    public Track withExtrude(final Boolean extrude) {
        this.setExtrude(extrude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param tessellate     required parameter
     * @return the track
     * @see #setTessellate(Boolean)
     */
    public Track withTessellate(final Boolean tessellate) {
        this.setTessellate(tessellate);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param altitudeMode     required parameter
     * @return the track
     * @see #setAltitudeMode(Object)
     */
    public Track withAltitudeMode(final  AltitudeMode altitudeMode) {
        this.setAltitudeMode(altitudeMode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param when     required parameter
     * @return the track
     * @see #setWhen(List<String>)
     */
    public Track withWhen(final List<String> when) {
        this.setWhen(when);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param coord     required parameter
     * @return the track
     * @see #setCoord(List<String>)
     */
    public Track withCoord(final List<String> coord) {
        this.setCoord(coord);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param angles     required parameter
     * @return the track
     * @see #setAngles(List<String>)
     */
    public Track withAngles(final List<String> angles) {
        this.setAngles(angles);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param model     required parameter
     * @return the track
     * @see #setModel(Model)
     */
    public Track withModel(final Model model) {
        this.setModel(model);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param extendedData     required parameter
     * @return the track
     * @see #setExtendedData(ExtendedData)
     */
    public Track withExtendedData(final ExtendedData extendedData) {
        this.setExtendedData(extendedData);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param trackSimpleExtension     required parameter
     * @return the track
     * @see #setTrackSimpleExtension(List<Object>)
     */
    public Track withTrackSimpleExtension(final List<Object> trackSimpleExtension) {
        this.setTrackSimpleExtension(trackSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public Track withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public Track withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public Track withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Obvious
    @Override
    public Track withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
        super.withGeometrySimpleExtension(geometrySimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public Track withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
        super.withGeometryObjectExtension(geometryObjectExtension);
        return this;
    }

    @Override
    public Track clone() {
        Track copy;
        copy = ((Track) super.clone());
        copy.when = new ArrayList<String>((getWhen().size()));
        for (String iter: when) {
            copy.when.add(iter);
        }
        copy.coord = new ArrayList<String>((getCoord().size()));
        for (String iter: coord) {
            copy.coord.add(iter);
        }
        copy.angles = new ArrayList<String>((getAngles().size()));
        for (String iter: angles) {
            copy.angles.add(iter);
        }
        copy.model = ((model == null)?null:((Model) model.clone()));
        copy.extendedData = ((extendedData == null)?null:((ExtendedData) extendedData.clone()));
        copy.trackSimpleExtension = new ArrayList<Object>((getTrackSimpleExtension().size()));
        for (Object iter: trackSimpleExtension) {
            copy.trackSimpleExtension.add(iter);
        }
        return copy;
    }

}
