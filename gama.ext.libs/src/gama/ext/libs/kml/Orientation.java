/*******************************************************************************************************
 *
 * Orientation.java, in gama.ext.libs, is part of the source code of the
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
 * <orientation>
 * <p>
 * Describes rotation of a 3D model's coordinate system to position the object in Google 
 * Earth. See diagram below. <Orientation> <heading>45.0</heading> <tilt>10.0</tilt> 
 * <roll>0.0</roll> </Orientation> 
 * </p>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrientationType", propOrder = {
    "heading",
    "tilt",
    "roll",
    "orientationSimpleExtension",
    "orientationObjectExtension"
})
@XmlRootElement(name = "Orientation", namespace = "http://www.opengis.net/kml/2.2")
public class Orientation
    extends AbstractObject
    implements Cloneable
{

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
     * <roll>
     * <p>
     * <heading> Rotation about the z axis (normal to the Earth's surface). A value of 
     *  0 (the default) equals North. A positive rotation is clockwise around the z axis 
     * and specified in degrees from 0 to 360. <tilt> Rotation about the x axis. A positive 
     * rotation is clockwise around the x axis and specified in degrees from 0 to 360. 
     * <roll> Rotation about the y axis. A positive rotation is clockwise around the y 
     * axis and specified in degrees from 0 to 360. This diagram illustrates the typical 
     * orientation of a model's axes: 
     * </p>
     * <p>
     * Rotation about the y axis. A positive rotation is clockwise around the y axis and 
     * specified in degrees from 0 to 360. 
     * </p>
     * <p>
     * Rotation, in degrees, of the camera around the Z axis. Values range from −180 to 
     * +180 degrees. 
     * </p>
     * <p>
     * This diagram illustrates the typical orientation of a model's axes: 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double roll;
    
    /** The orientation simple extension. */
    @XmlElement(name = "OrientationSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> orientationSimpleExtension;
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
    @XmlElement(name = "OrientationObjectExtensionGroup")
    protected List<AbstractObject> orientationObjectExtension;

    /**
     * Instantiates a new orientation.
     */
    public Orientation() {
        super();
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
     * Gets the roll.
     *
     * @return     possible object is
     *     {@link Double}
     * @see roll
     */
    public double getRoll() {
        return roll;
    }

    /**
     * Sets the roll.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see roll
     */
    public void setRoll(double value) {
        this.roll = value;
    }

    /**
     * Gets the orientation simple extension.
     *
     * @return the orientation simple extension
     * @see orientationSimpleExtension
     */
    public List<Object> getOrientationSimpleExtension() {
        if (orientationSimpleExtension == null) {
            orientationSimpleExtension = new ArrayList<Object>();
        }
        return this.orientationSimpleExtension;
    }

    /**
     * Gets the orientation object extension.
     *
     * @return the orientation object extension
     * @see orientationObjectExtension
     */
    public List<AbstractObject> getOrientationObjectExtension() {
        if (orientationObjectExtension == null) {
            orientationObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.orientationObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(heading);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(tilt);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(roll);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((orientationSimpleExtension == null)? 0 :orientationSimpleExtension.hashCode()));
        result = ((prime*result)+((orientationObjectExtension == null)? 0 :orientationObjectExtension.hashCode()));
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
        if ((obj instanceof Orientation) == false) {
            return false;
        }
        Orientation other = ((Orientation) obj);
        if (heading!= other.heading) {
            return false;
        }
        if (tilt!= other.tilt) {
            return false;
        }
        if (roll!= other.roll) {
            return false;
        }
        if (orientationSimpleExtension == null) {
            if (other.orientationSimpleExtension!= null) {
                return false;
            }
        } else {
            if (orientationSimpleExtension.equals(other.orientationSimpleExtension) == false) {
                return false;
            }
        }
        if (orientationObjectExtension == null) {
            if (other.orientationObjectExtension!= null) {
                return false;
            }
        } else {
            if (orientationObjectExtension.equals(other.orientationObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the orientation simple extension.
     *
     * @param orientationSimpleExtension the new orientation simple extension
     * @see orientationSimpleExtension
     */
    public void setOrientationSimpleExtension(final List<Object> orientationSimpleExtension) {
        this.orientationSimpleExtension = orientationSimpleExtension;
    }

    /**
     * add a value to the orientationSimpleExtension property collection.
     *
     * @param orientationSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Orientation addToOrientationSimpleExtension(final Object orientationSimpleExtension) {
        this.getOrientationSimpleExtension().add(orientationSimpleExtension);
        return this;
    }

    /**
     * Sets the orientation object extension.
     *
     * @param orientationObjectExtension the new orientation object extension
     * @see orientationObjectExtension
     */
    public void setOrientationObjectExtension(final List<AbstractObject> orientationObjectExtension) {
        this.orientationObjectExtension = orientationObjectExtension;
    }

    /**
     * add a value to the orientationObjectExtension property collection.
     *
     * @param orientationObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Orientation addToOrientationObjectExtension(final AbstractObject orientationObjectExtension) {
        this.getOrientationObjectExtension().add(orientationObjectExtension);
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
    public Orientation addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param heading     required parameter
     * @return the orientation
     * @see #setHeading(double)
     */
    public Orientation withHeading(final double heading) {
        this.setHeading(heading);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param tilt     required parameter
     * @return the orientation
     * @see #setTilt(double)
     */
    public Orientation withTilt(final double tilt) {
        this.setTilt(tilt);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param roll     required parameter
     * @return the orientation
     * @see #setRoll(double)
     */
    public Orientation withRoll(final double roll) {
        this.setRoll(roll);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param orientationSimpleExtension     required parameter
     * @return the orientation
     * @see #setOrientationSimpleExtension(List<Object>)
     */
    public Orientation withOrientationSimpleExtension(final List<Object> orientationSimpleExtension) {
        this.setOrientationSimpleExtension(orientationSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param orientationObjectExtension     required parameter
     * @return the orientation
     * @see #setOrientationObjectExtension(List<AbstractObject>)
     */
    public Orientation withOrientationObjectExtension(final List<AbstractObject> orientationObjectExtension) {
        this.setOrientationObjectExtension(orientationObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public Orientation withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public Orientation withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public Orientation withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public Orientation clone() {
        Orientation copy;
        copy = ((Orientation) super.clone());
        copy.orientationSimpleExtension = new ArrayList<Object>((getOrientationSimpleExtension().size()));
        for (Object iter: orientationSimpleExtension) {
            copy.orientationSimpleExtension.add(iter);
        }
        copy.orientationObjectExtension = new ArrayList<AbstractObject>((getOrientationObjectExtension().size()));
        for (AbstractObject iter: orientationObjectExtension) {
            copy.orientationObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
