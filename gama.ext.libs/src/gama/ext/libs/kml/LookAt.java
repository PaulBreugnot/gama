/*******************************************************************************************************
 *
 * LookAt.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.annotations.Obvious;


/**
 * <LookAt>
 * <p>
 * Defines a virtual camera that is associated with any element derived from Feature. 
 * The LookAt element positions the "camera" in relation to the object that is being 
 * viewed. In Google Earth, the view "flies to" this LookAt viewpoint when the user 
 * double-clicks an item in the Places panel or double-clicks an icon in the 3D viewer. 
 * </p>
 * 
 * Syntax: 
 * <pre><strong>&lt;LookAt id="ID"&gt;</strong>
 *   &lt;!-- inherited from AbstractView element --&gt;
 *   <em>&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt;</em>  &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
 *    
 *   &lt;!-- specific to LookAt --&gt;
 *   &lt;longitude&gt;0&lt;/longitude&gt;            &lt;!-- kml:angle180 --&gt;
 *   &lt;latitude&gt;0&lt;/latitude&gt;              &lt;!-- kml:angle90 --&gt;
 *   &lt;altitude&gt;0&lt;/altitude&gt;              &lt;!-- double --&gt; 
 *   &lt;heading&gt;0&lt;/heading&gt;                &lt;!-- kml:angle360 --&gt;
 *   &lt;tilt&gt;0&lt;/tilt&gt;                      &lt;!-- kml:anglepos90 --&gt;
 *   &lt;range&gt;&lt;/range&gt;                     &lt;!-- double --&gt;
 *   &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; 
 *           &lt;!--kml:altitudeModeEnum:clampToGround, relativeToGround, absolute --&gt;
 *           &lt;!-- or, gx:altitudeMode can be substituted: clampToSeaFloor, relativeToSeaFloor --&gt;
 * 
 * <strong>&lt;/LookAt&gt;</strong></pre>
 * 
 * Extends: 
 * @see: <AbstractView>
 * 
 * Contained By: 
 * @see: <Feature>
 * @see: <NetworkLinkControl>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookAtType", propOrder = {
    "longitude",
    "latitude",
    "altitude",
    "heading",
    "tilt",
    "range",
    "altitudeMode",
    "lookAtSimpleExtension",
    "lookAtObjectExtension"
})
@XmlRootElement(name = "LookAt", namespace = "http://www.opengis.net/kml/2.2")
public class LookAt
    extends AbstractView
    implements Cloneable
{

    /**
     * <longitude>
     * <p>
     * Longitude of the point the camera is looking at. Angular distance in degrees, relative 
     * to the Prime Meridian. Values west of the Meridian range from −180 to 0 degrees. 
     * Values east of the Meridian range from 0 to 180 degrees. 
     * </p>
     * <p>
     * Longitude of the virtual camera (eye point). Angular distance in degrees, relative 
     * to the Prime Meridian. Values west of the Meridian range from −180 to 0 degrees. 
     * Values east of the Meridian range from 0 to 180 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double longitude;
    /**
     * <latitude>
     * <p>
     * Latitude of the point the camera is looking at. Degrees north or south of the Equator 
     * (0 degrees). Values range from −90 degrees to 90 degrees. 
     * </p>
     * <p>
     * Latitude of the virtual camera. Degrees north or south of the Equator (0 degrees). 
     * Values range from −90 degrees to 90 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double latitude;
    /**
     * <altitude>
     * <p>
     * Distance from the earth's surface, in meters. Interpreted according to the LookAt's 
     * altitude mode. 
     * </p>
     * <p>
     * Distance of the camera from the earth's surface, in meters. Interpreted according 
     * to the Camera's <altitudeMode> or <gx:altitudeMode>. 
     * </p>
     * <p>
     * Specifies the distance above the earth's surface, in meters, and is interpreted 
     * according to the altitude mode. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double altitude;
    /**
     * <heading>
     * <p>
     * Direction (azimuth) of the camera, in degrees. Default=0 (true North). (See diagram.) 
     * Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Direction (that is, North, South, East, West), in degrees. Default=0 (North). (See 
     * diagram below.) Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Direction (that is, North, South, East, West), in degrees. Default=0 (North). (See 
     * diagram.) Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Rotation about the z axis (normal to the Earth's surface). A value of 0 (the default) 
     * equals North. A positive rotation is clockwise around the z axis and specified in 
     * degrees from 0 to 360. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double heading;
    /**
     * <tilt>
     * <p>
     * Angle between the direction of the LookAt position and the normal to the surface 
     * of the earth. (See diagram below.) Values range from 0 to 90 degrees. Values for 
     * <tilt> cannot be negative. A <tilt> value of 0 degrees indicates viewing from directly 
     * above. A <tilt> value of 90 degrees indicates viewing along the horizon. 
     * </p>
     * <p>
     * Rotation about the x axis. A positive rotation is clockwise around the x axis and 
     * specified in degrees from 0 to 360. 
     * </p>
     * <p>
     * Rotation, in degrees, of the camera around the X axis. A value of 0 indicates that 
     * the view is aimed straight down toward the earth (the most common case). A value 
     * for 90 for <tilt> indicates that the view is aimed toward the horizon. Values greater 
     * than 90 indicate that the view is pointed up into the sky. Values for <tilt> are 
     * clamped at +180 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double tilt;
    /**
     * <range> (required)
     * <p>
     * Distance in meters from the point specified by <longitude>, <latitude>, and <altitude> 
     * to the LookAt position. (See diagram below.) 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double range;
    
    /** AltitudeMode <p> clampToGround, relativeToGround, absolute  </p>  See Also:  See <LookAt> and <Region>. */
    @XmlElement(defaultValue = "clampToGround")
    protected AltitudeMode altitudeMode;
    
    /** The look at simple extension. */
    @XmlElement(name = "LookAtSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> lookAtSimpleExtension;
    /**
     * <Object>
     * <p>
     * This is an abstract base class and cannot be used directly in a KML file. It provides 
     * the id attribute, which allows unique identification of a KML element, and the targetId 
     * attribute, which is used to reference objects that have already been loaded into 
     * Google Earth. The id attribute must be assigned if the <Update> mechanism is to 
     * be used. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
     * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
     * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
     * 
     * 
     * 
     */
    @XmlElement(name = "LookAtObjectExtensionGroup")
    protected List<AbstractObject> lookAtObjectExtension;

    /**
     * Instantiates a new look at.
     */
    public LookAt() {
        super();
    }

    /**
     * Gets the longitude.
     *
     * @return     possible object is
     *     {@link Double}
     * @see longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see longitude
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * Gets the latitude.
     *
     * @return     possible object is
     *     {@link Double}
     * @see latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see latitude
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the altitude.
     *
     * @return     possible object is
     *     {@link Double}
     * @see altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Sets the altitude.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see altitude
     */
    public void setAltitude(double value) {
        this.altitude = value;
    }

    /**
     * Gets the heading.
     *
     * @return     possible object is
     *     {@link Double}
     * @see heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * Sets the heading.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see heading
     */
    public void setHeading(double value) {
        this.heading = value;
    }

    /**
     * Gets the tilt.
     *
     * @return     possible object is
     *     {@link Double}
     * @see tilt
     */
    public double getTilt() {
        return tilt;
    }

    /**
     * Sets the tilt.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see tilt
     */
    public void setTilt(double value) {
        this.tilt = value;
    }

    /**
     * Gets the range.
     *
     * @return     possible object is
     *     {@link Double}
     * @see range
     */
    public double getRange() {
        return range;
    }

    /**
     * Sets the range.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see range
     */
    public void setRange(double value) {
        this.range = value;
    }

    /**
     * Gets the altitude mode.
     *
     * @return     possible object is
     *     {@code <}{@link Object}{@code>}
     *     {@code <}{@link gama.ext.libs.kml.AltitudeMode}{@code>}
     *     {@code <}{@link msi.gama.ext.kml.gx.AltitudeMode}{@code>}
     * @see altitudeMode
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
     * @see altitudeMode
     */
    public void setAltitudeMode(AltitudeMode value) {
        this.altitudeMode = value;
    }

    /**
     * Gets the look at simple extension.
     *
     * @return the look at simple extension
     * @see lookAtSimpleExtension
     */
    public List<Object> getLookAtSimpleExtension() {
        if (lookAtSimpleExtension == null) {
            lookAtSimpleExtension = new ArrayList<Object>();
        }
        return this.lookAtSimpleExtension;
    }

    /**
     * Gets the look at object extension.
     *
     * @return the look at object extension
     * @see lookAtObjectExtension
     */
    public List<AbstractObject> getLookAtObjectExtension() {
        if (lookAtObjectExtension == null) {
            lookAtObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.lookAtObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(longitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(latitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(altitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(heading);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(tilt);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(range);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((altitudeMode == null)? 0 :altitudeMode.hashCode()));
        result = ((prime*result)+((lookAtSimpleExtension == null)? 0 :lookAtSimpleExtension.hashCode()));
        result = ((prime*result)+((lookAtObjectExtension == null)? 0 :lookAtObjectExtension.hashCode()));
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
        if ((obj instanceof LookAt) == false) {
            return false;
        }
        LookAt other = ((LookAt) obj);
        if (longitude!= other.longitude) {
            return false;
        }
        if (latitude!= other.latitude) {
            return false;
        }
        if (altitude!= other.altitude) {
            return false;
        }
        if (heading!= other.heading) {
            return false;
        }
        if (tilt!= other.tilt) {
            return false;
        }
        if (range!= other.range) {
            return false;
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
        if (lookAtSimpleExtension == null) {
            if (other.lookAtSimpleExtension!= null) {
                return false;
            }
        } else {
            if (lookAtSimpleExtension.equals(other.lookAtSimpleExtension) == false) {
                return false;
            }
        }
        if (lookAtObjectExtension == null) {
            if (other.lookAtObjectExtension!= null) {
                return false;
            }
        } else {
            if (lookAtObjectExtension.equals(other.lookAtObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the look at simple extension.
     *
     * @param lookAtSimpleExtension the new look at simple extension
     * @see lookAtSimpleExtension
     */
    public void setLookAtSimpleExtension(final List<Object> lookAtSimpleExtension) {
        this.lookAtSimpleExtension = lookAtSimpleExtension;
    }

    /**
     * add a value to the lookAtSimpleExtension property collection.
     *
     * @param lookAtSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public LookAt addToLookAtSimpleExtension(final Object lookAtSimpleExtension) {
        this.getLookAtSimpleExtension().add(lookAtSimpleExtension);
        return this;
    }

    /**
     * Sets the look at object extension.
     *
     * @param lookAtObjectExtension the new look at object extension
     * @see lookAtObjectExtension
     */
    public void setLookAtObjectExtension(final List<AbstractObject> lookAtObjectExtension) {
        this.lookAtObjectExtension = lookAtObjectExtension;
    }

    /**
     * add a value to the lookAtObjectExtension property collection.
     *
     * @param lookAtObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public LookAt addToLookAtObjectExtension(final AbstractObject lookAtObjectExtension) {
        this.getLookAtObjectExtension().add(lookAtObjectExtension);
        return this;
    }

    /**
     * @see objectSimpleExtension
     * 
     */
    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public LookAt addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * @see abstractViewSimpleExtension
     * 
     */
    @Obvious
    @Override
    public void setAbstractViewSimpleExtension(final List<Object> abstractViewSimpleExtension) {
        super.setAbstractViewSimpleExtension(abstractViewSimpleExtension);
    }

    @Obvious
    @Override
    public LookAt addToAbstractViewSimpleExtension(final Object abstractViewSimpleExtension) {
        super.getAbstractViewSimpleExtension().add(abstractViewSimpleExtension);
        return this;
    }

    /**
     * @see abstractViewObjectExtension
     * 
     */
    @Obvious
    @Override
    public void setAbstractViewObjectExtension(final List<AbstractObject> abstractViewObjectExtension) {
        super.setAbstractViewObjectExtension(abstractViewObjectExtension);
    }

    @Obvious
    @Override
    public LookAt addToAbstractViewObjectExtension(final AbstractObject abstractViewObjectExtension) {
        super.getAbstractViewObjectExtension().add(abstractViewObjectExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param longitude     required parameter
     * @return the look at
     * @see #setLongitude(double)
     */
    public LookAt withLongitude(final double longitude) {
        this.setLongitude(longitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param latitude     required parameter
     * @return the look at
     * @see #setLatitude(double)
     */
    public LookAt withLatitude(final double latitude) {
        this.setLatitude(latitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param altitude     required parameter
     * @return the look at
     * @see #setAltitude(double)
     */
    public LookAt withAltitude(final double altitude) {
        this.setAltitude(altitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param heading     required parameter
     * @return the look at
     * @see #setHeading(double)
     */
    public LookAt withHeading(final double heading) {
        this.setHeading(heading);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param tilt     required parameter
     * @return the look at
     * @see #setTilt(double)
     */
    public LookAt withTilt(final double tilt) {
        this.setTilt(tilt);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param range     required parameter
     * @return the look at
     * @see #setRange(double)
     */
    public LookAt withRange(final double range) {
        this.setRange(range);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param altitudeMode     required parameter
     * @return the look at
     * @see #setAltitudeMode(Object)
     */
    public LookAt withAltitudeMode(final  AltitudeMode altitudeMode) {
        this.setAltitudeMode(altitudeMode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param lookAtSimpleExtension     required parameter
     * @return the look at
     * @see #setLookAtSimpleExtension(List<Object>)
     */
    public LookAt withLookAtSimpleExtension(final List<Object> lookAtSimpleExtension) {
        this.setLookAtSimpleExtension(lookAtSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param lookAtObjectExtension     required parameter
     * @return the look at
     * @see #setLookAtObjectExtension(List<AbstractObject>)
     */
    public LookAt withLookAtObjectExtension(final List<AbstractObject> lookAtObjectExtension) {
        this.setLookAtObjectExtension(lookAtObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public LookAt withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Obvious
    @Override
    public LookAt withAbstractViewSimpleExtension(final List<Object> abstractViewSimpleExtension) {
        super.withAbstractViewSimpleExtension(abstractViewSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withAbstractViewObjectExtension(final List<AbstractObject> abstractViewObjectExtension) {
        super.withAbstractViewObjectExtension(abstractViewObjectExtension);
        return this;
    }

    @Override
    public LookAt clone() {
        LookAt copy;
        copy = ((LookAt) super.clone());
        copy.lookAtSimpleExtension = new ArrayList<Object>((getLookAtSimpleExtension().size()));
        for (Object iter: lookAtSimpleExtension) {
            copy.lookAtSimpleExtension.add(iter);
        }
        copy.lookAtObjectExtension = new ArrayList<AbstractObject>((getLookAtObjectExtension().size()));
        for (AbstractObject iter: lookAtObjectExtension) {
            copy.lookAtObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
