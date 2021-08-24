/*******************************************************************************************************
 *
 * ViewVolume.java, in gama.ext.libs, is part of the source code of the
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
 * <viewvolume>
 * <p>
 * Defines how much of the current scene is visible. Specifying the field of view is 
 * analogous to specifying the lens opening in a physical camera. A small field of 
 * view, like a telephoto lens, focuses on a small part of the scene. A large field 
 * of view, like a wide-angle lens, focuses on a large part of the scene. 
 * </p>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewVolumeType", propOrder = {
    "leftFov",
    "rightFov",
    "bottomFov",
    "topFov",
    "near",
    "viewVolumeSimpleExtension",
    "viewVolumeObjectExtension"
})
@XmlRootElement(name = "ViewVolume", namespace = "http://www.opengis.net/kml/2.2")
public class ViewVolume
    extends AbstractObject
    implements Cloneable
{

    /**
     * <leftfov>
     * <p>
     * Angle, in degrees, between the camera's viewing direction and the left side of the 
     * view volume. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double leftFov;
    /**
     * <rightfov>
     * <p>
     * Angle, in degrees, between the camera's viewing direction and the right side of 
     * the view volume. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double rightFov;
    /**
     * <bottomfov>
     * <p>
     * Angle, in degrees, between the camera's viewing direction and the bottom side of 
     * the view volume. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double bottomFov;
    /**
     * <topfov>
     * <p>
     * Angle, in degrees, between the camera's viewing direction and the top side of the 
     * view volume. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double topFov;
    /**
     * <near>
     * <p>
     * <leftFov> Angle, in degrees, between the camera's viewing direction and the left 
     * side of the view volume. <rightFov> Angle, in degrees, between the camera's viewing 
     * direction and the right side of the view volume. <bottomFov> Angle, in degrees, 
     * between the camera's viewing direction and the bottom side of the view volume. <topFov> 
     * Angle, in degrees, between the camera's viewing direction and the top side of the 
     * view volume. <near> Measurement in meters along the viewing direction from the camera 
     * viewpoint to the PhotoOverlay shape. 
     * </p>
     * <p>
     * Measurement in meters along the viewing direction from the camera viewpoint to the 
     * PhotoOverlay shape. 
     * </p>
     * <p>
     * The field of view for a PhotoOverlay is defined by four planes, each of which is 
     * specified by an angle relative to the view vector. These four planes define the 
     * top, bottom, left, and right sides of the field of view, which has the shape of 
     * a truncated pyramid, as shown here: 
     * </p>
     * <p>
     * The following diagrams show the four field-of-view angles within this pyramid: 
     * </p>
     * <p>
     * The following diagrams show the four field-of-view angles within this pyramid: 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double near;
    
    /** The view volume simple extension. */
    @XmlElement(name = "ViewVolumeSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> viewVolumeSimpleExtension;
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
    @XmlElement(name = "ViewVolumeObjectExtensionGroup")
    protected List<AbstractObject> viewVolumeObjectExtension;

    /**
     * Instantiates a new view volume.
     */
    public ViewVolume() {
        super();
    }

    /**
     * Gets the left fov.
     *
     * @return     possible object is
     *     {@link Double}
     * @see leftFov
     */
    public double getLeftFov() {
        return leftFov;
    }

    /**
     * Sets the left fov.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see leftFov
     */
    public void setLeftFov(double value) {
        this.leftFov = value;
    }

    /**
     * Gets the right fov.
     *
     * @return     possible object is
     *     {@link Double}
     * @see rightFov
     */
    public double getRightFov() {
        return rightFov;
    }

    /**
     * Sets the right fov.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see rightFov
     */
    public void setRightFov(double value) {
        this.rightFov = value;
    }

    /**
     * Gets the bottom fov.
     *
     * @return     possible object is
     *     {@link Double}
     * @see bottomFov
     */
    public double getBottomFov() {
        return bottomFov;
    }

    /**
     * Sets the bottom fov.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see bottomFov
     */
    public void setBottomFov(double value) {
        this.bottomFov = value;
    }

    /**
     * Gets the top fov.
     *
     * @return     possible object is
     *     {@link Double}
     * @see topFov
     */
    public double getTopFov() {
        return topFov;
    }

    /**
     * Sets the top fov.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see topFov
     */
    public void setTopFov(double value) {
        this.topFov = value;
    }

    /**
     * Gets the near.
     *
     * @return     possible object is
     *     {@link Double}
     * @see near
     */
    public double getNear() {
        return near;
    }

    /**
     * Sets the near.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see near
     */
    public void setNear(double value) {
        this.near = value;
    }

    /**
     * Gets the view volume simple extension.
     *
     * @return the view volume simple extension
     * @see viewVolumeSimpleExtension
     */
    public List<Object> getViewVolumeSimpleExtension() {
        if (viewVolumeSimpleExtension == null) {
            viewVolumeSimpleExtension = new ArrayList<Object>();
        }
        return this.viewVolumeSimpleExtension;
    }

    /**
     * Gets the view volume object extension.
     *
     * @return the view volume object extension
     * @see viewVolumeObjectExtension
     */
    public List<AbstractObject> getViewVolumeObjectExtension() {
        if (viewVolumeObjectExtension == null) {
            viewVolumeObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.viewVolumeObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(leftFov);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(rightFov);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(bottomFov);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(topFov);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(near);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((viewVolumeSimpleExtension == null)? 0 :viewVolumeSimpleExtension.hashCode()));
        result = ((prime*result)+((viewVolumeObjectExtension == null)? 0 :viewVolumeObjectExtension.hashCode()));
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
        if ((obj instanceof ViewVolume) == false) {
            return false;
        }
        ViewVolume other = ((ViewVolume) obj);
        if (leftFov!= other.leftFov) {
            return false;
        }
        if (rightFov!= other.rightFov) {
            return false;
        }
        if (bottomFov!= other.bottomFov) {
            return false;
        }
        if (topFov!= other.topFov) {
            return false;
        }
        if (near!= other.near) {
            return false;
        }
        if (viewVolumeSimpleExtension == null) {
            if (other.viewVolumeSimpleExtension!= null) {
                return false;
            }
        } else {
            if (viewVolumeSimpleExtension.equals(other.viewVolumeSimpleExtension) == false) {
                return false;
            }
        }
        if (viewVolumeObjectExtension == null) {
            if (other.viewVolumeObjectExtension!= null) {
                return false;
            }
        } else {
            if (viewVolumeObjectExtension.equals(other.viewVolumeObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the view volume simple extension.
     *
     * @param viewVolumeSimpleExtension the new view volume simple extension
     * @see viewVolumeSimpleExtension
     */
    public void setViewVolumeSimpleExtension(final List<Object> viewVolumeSimpleExtension) {
        this.viewVolumeSimpleExtension = viewVolumeSimpleExtension;
    }

    /**
     * add a value to the viewVolumeSimpleExtension property collection.
     *
     * @param viewVolumeSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public ViewVolume addToViewVolumeSimpleExtension(final Object viewVolumeSimpleExtension) {
        this.getViewVolumeSimpleExtension().add(viewVolumeSimpleExtension);
        return this;
    }

    /**
     * Sets the view volume object extension.
     *
     * @param viewVolumeObjectExtension the new view volume object extension
     * @see viewVolumeObjectExtension
     */
    public void setViewVolumeObjectExtension(final List<AbstractObject> viewVolumeObjectExtension) {
        this.viewVolumeObjectExtension = viewVolumeObjectExtension;
    }

    /**
     * add a value to the viewVolumeObjectExtension property collection.
     *
     * @param viewVolumeObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public ViewVolume addToViewVolumeObjectExtension(final AbstractObject viewVolumeObjectExtension) {
        this.getViewVolumeObjectExtension().add(viewVolumeObjectExtension);
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
    public ViewVolume addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param leftFov     required parameter
     * @return the view volume
     * @see #setLeftFov(double)
     */
    public ViewVolume withLeftFov(final double leftFov) {
        this.setLeftFov(leftFov);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param rightFov     required parameter
     * @return the view volume
     * @see #setRightFov(double)
     */
    public ViewVolume withRightFov(final double rightFov) {
        this.setRightFov(rightFov);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param bottomFov     required parameter
     * @return the view volume
     * @see #setBottomFov(double)
     */
    public ViewVolume withBottomFov(final double bottomFov) {
        this.setBottomFov(bottomFov);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param topFov     required parameter
     * @return the view volume
     * @see #setTopFov(double)
     */
    public ViewVolume withTopFov(final double topFov) {
        this.setTopFov(topFov);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param near     required parameter
     * @return the view volume
     * @see #setNear(double)
     */
    public ViewVolume withNear(final double near) {
        this.setNear(near);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param viewVolumeSimpleExtension     required parameter
     * @return the view volume
     * @see #setViewVolumeSimpleExtension(List<Object>)
     */
    public ViewVolume withViewVolumeSimpleExtension(final List<Object> viewVolumeSimpleExtension) {
        this.setViewVolumeSimpleExtension(viewVolumeSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param viewVolumeObjectExtension     required parameter
     * @return the view volume
     * @see #setViewVolumeObjectExtension(List<AbstractObject>)
     */
    public ViewVolume withViewVolumeObjectExtension(final List<AbstractObject> viewVolumeObjectExtension) {
        this.setViewVolumeObjectExtension(viewVolumeObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public ViewVolume withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public ViewVolume withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public ViewVolume withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public ViewVolume clone() {
        ViewVolume copy;
        copy = ((ViewVolume) super.clone());
        copy.viewVolumeSimpleExtension = new ArrayList<Object>((getViewVolumeSimpleExtension().size()));
        for (Object iter: viewVolumeSimpleExtension) {
            copy.viewVolumeSimpleExtension.add(iter);
        }
        copy.viewVolumeObjectExtension = new ArrayList<AbstractObject>((getViewVolumeObjectExtension().size()));
        for (AbstractObject iter: viewVolumeObjectExtension) {
            copy.viewVolumeObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
