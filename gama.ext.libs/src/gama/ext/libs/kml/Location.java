/*******************************************************************************************************
 *
 * Location.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.annotations.Obvious;


/**
 * <location>
 * <p>
 * Specifies the exact coordinates of the Model's origin in latitude, longitude, and 
 * altitude. Latitude and longitude measurements are standard lat-lon projection with 
 * WGS84 datum. Altitude is distance above the earth's surface, in meters, and is interpreted 
 * according to <altitudeMode> or <gx:altitudeMode>. <Location> <longitude>39.55375305703105</longitude> 
 * <latitude>-118.9813220168456</latitude> <altitude>1223</altitude> </Location> 
 * </p>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType", propOrder = {
    "longitude",
    "latitude",
    "altitude",
    "locationSimpleExtension",
    "locationObjectExtension"
})
@XmlRootElement(name = "Location", namespace = "http://www.opengis.net/kml/2.2")
public class Location
    extends AbstractObject
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
    
    /** The location simple extension. */
    @XmlElement(name = "LocationSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> locationSimpleExtension;
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
    @XmlElement(name = "LocationObjectExtensionGroup")
    protected List<AbstractObject> locationObjectExtension;

    /**
     * Instantiates a new location.
     */
    public Location() {
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
     * Gets the location simple extension.
     *
     * @return the location simple extension
     * @see locationSimpleExtension
     */
    public List<Object> getLocationSimpleExtension() {
        if (locationSimpleExtension == null) {
            locationSimpleExtension = new ArrayList<Object>();
        }
        return this.locationSimpleExtension;
    }

    /**
     * Gets the location object extension.
     *
     * @return the location object extension
     * @see locationObjectExtension
     */
    public List<AbstractObject> getLocationObjectExtension() {
        if (locationObjectExtension == null) {
            locationObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.locationObjectExtension;
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
        result = ((prime*result)+((locationSimpleExtension == null)? 0 :locationSimpleExtension.hashCode()));
        result = ((prime*result)+((locationObjectExtension == null)? 0 :locationObjectExtension.hashCode()));
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
        if ((obj instanceof Location) == false) {
            return false;
        }
        Location other = ((Location) obj);
        if (longitude!= other.longitude) {
            return false;
        }
        if (latitude!= other.latitude) {
            return false;
        }
        if (altitude!= other.altitude) {
            return false;
        }
        if (locationSimpleExtension == null) {
            if (other.locationSimpleExtension!= null) {
                return false;
            }
        } else {
            if (locationSimpleExtension.equals(other.locationSimpleExtension) == false) {
                return false;
            }
        }
        if (locationObjectExtension == null) {
            if (other.locationObjectExtension!= null) {
                return false;
            }
        } else {
            if (locationObjectExtension.equals(other.locationObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the location simple extension.
     *
     * @param locationSimpleExtension the new location simple extension
     * @see locationSimpleExtension
     */
    public void setLocationSimpleExtension(final List<Object> locationSimpleExtension) {
        this.locationSimpleExtension = locationSimpleExtension;
    }

    /**
     * add a value to the locationSimpleExtension property collection.
     *
     * @param locationSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Location addToLocationSimpleExtension(final Object locationSimpleExtension) {
        this.getLocationSimpleExtension().add(locationSimpleExtension);
        return this;
    }

    /**
     * Sets the location object extension.
     *
     * @param locationObjectExtension the new location object extension
     * @see locationObjectExtension
     */
    public void setLocationObjectExtension(final List<AbstractObject> locationObjectExtension) {
        this.locationObjectExtension = locationObjectExtension;
    }

    /**
     * add a value to the locationObjectExtension property collection.
     *
     * @param locationObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Location addToLocationObjectExtension(final AbstractObject locationObjectExtension) {
        this.getLocationObjectExtension().add(locationObjectExtension);
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
    public Location addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param longitude     required parameter
     * @return the location
     * @see #setLongitude(double)
     */
    public Location withLongitude(final double longitude) {
        this.setLongitude(longitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param latitude     required parameter
     * @return the location
     * @see #setLatitude(double)
     */
    public Location withLatitude(final double latitude) {
        this.setLatitude(latitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param altitude     required parameter
     * @return the location
     * @see #setAltitude(double)
     */
    public Location withAltitude(final double altitude) {
        this.setAltitude(altitude);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param locationSimpleExtension     required parameter
     * @return the location
     * @see #setLocationSimpleExtension(List<Object>)
     */
    public Location withLocationSimpleExtension(final List<Object> locationSimpleExtension) {
        this.setLocationSimpleExtension(locationSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param locationObjectExtension     required parameter
     * @return the location
     * @see #setLocationObjectExtension(List<AbstractObject>)
     */
    public Location withLocationObjectExtension(final List<AbstractObject> locationObjectExtension) {
        this.setLocationObjectExtension(locationObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public Location withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public Location withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public Location withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public Location clone() {
        Location copy;
        copy = ((Location) super.clone());
        copy.locationSimpleExtension = new ArrayList<Object>((getLocationSimpleExtension().size()));
        for (Object iter: locationSimpleExtension) {
            copy.locationSimpleExtension.add(iter);
        }
        copy.locationObjectExtension = new ArrayList<AbstractObject>((getLocationObjectExtension().size()));
        for (AbstractObject iter: locationObjectExtension) {
            copy.locationObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
