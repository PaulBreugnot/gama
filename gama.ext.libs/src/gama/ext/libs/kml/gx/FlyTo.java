/*******************************************************************************************************
 *
 * FlyTo.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.AbstractView;
import gama.ext.libs.kml.Camera;
import gama.ext.libs.kml.LookAt;
import gama.ext.libs.kml.annotations.Obvious;


/**
 * <gx:FlyTo>
 * <p>
 * <gx:FlyTo> specifies a point in space to which the browser will fly during a tour. 
 * It must contain one AbstractView, and should contain <gx:duration> and <gx:flyToMode> 
 * elements, which specify the time it takes to fly to the defined point from the current 
 * point, and the method of flight, respectively. 
 * </p>
 * 
 * Syntax: 
 * <pre>&lt;gx:FlyTo&gt;
 *   &lt;gx:duration&gt;0.0&lt;/gx:duration&gt;         &lt;!-- double --&gt;
 *   &lt;gx:flyToMode&gt;bounce&lt;/gx:duration&gt;      &lt;!-- <em>smooth</em> or <em>bounce</em> --&gt;
 *   &lt;!-- AbstractView --&gt;                   &lt;!-- <em>Camera</em> or <em>LookAt</em> --&gt; 
 *     ...
 *   &lt;!-- /AbstractView --&gt;
 * &lt;/gx:FlyTo&gt;</pre>
 * 
 * Extends: 
 * @see: <gx:TourPrimitive>
 * 
 * Contains: 
 * @see: <AbstractView>
 * @see: <gx:duration>
 * @see: <gx:flyToMode>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlyToType", propOrder = {
    "duration",
    "flyToMode",
    "abstractView"
})
@XmlRootElement(name = "FlyTo", namespace = "http://www.google.com/kml/ext/2.2")
public class FlyTo
    extends TourPrimitive
    implements Cloneable
{

    /**
     * <gx:duration>
     * <p>
     * <gx:AnimatedUpdate> <gx:duration>5.0</gx:duration> <Update> .... </Update> </gx:AnimatedUpdate> 
     * </p>
     * <p>
     * <gx:FlyTo> <gx:flyToMode>bounce</gx:flyToMode> <gx:duration>10.2</gx:duration> <!-- 
     * AbstractView --> ... <!-- /AbstractView --> </gx:FlyTo> 
     * </p>
     * <p>
     * <gx:duration> extends gx:TourPrimitive by specifying a time-span for events. The 
     * time is written as seconds using XML's double datatype. 
     * </p>
     * <p>
     * Duration and <gx:AnimatedUpdate> 
     * </p>
     * <p>
     * Duration and <gx:FlyTo> 
     * </p>
     * <p>
     * Specifies the length of time over which the update takes place. Integer, float, 
     * and color fields are smoothly animated from original to new value across the duration; 
     * boolean, string, and other values that don't lend to interpolation are updated at 
     * the end of the duration. 
     * </p>
     * <p>
     * When a duration is included within a <gx:FlyTo> element, it specifies the length 
     * of time that the browser takes to fly from the previous point to the specified point. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;gx:duration&gt;0.0&lt;/gx:duration&gt;            &lt;!-- double --&gt;
     * </pre>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double duration;
    
    /** The fly to mode. */
    @XmlElement(defaultValue = "bounce")
    protected FlyToMode flyToMode;
    /**
     * <abstractview>
     * <p>
     * Defines a viewpoint associated with any element derived from Feature. See <Camera> 
     * and <LookAt>. 
     * </p>
     * <p>
     * This is an abstract element and cannot be used directly in a KML file. This element 
     * is extended by the <Camera> and <LookAt> elements. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;
     * <strong>&lt;!--<em> AbstractView</em> --&gt;</strong>                   &lt;!-- Camera, LookAt --&gt;                
     *   &lt;!-- extends <span class="style1">Object</span> --&gt;
     *   <em>&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt;</em>                        &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
     * <strong>&lt;-- /<em>AbstractView</em> --&gt;</strong></pre>
     * 
     * Extends: 
     * @see: <Object>
     * 
     * Extended By: 
     * @see: <Camera>
     * @see: <LookAt>
     * 
     * 
     * 
     */
    @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
    protected AbstractView abstractView;

    /**
     * Instantiates a new fly to.
     */
    public FlyTo() {
        super();
    }

    /**
     * Gets the duration.
     *
     * @return     possible object is
     *     {@link Double}
     * @see duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param value     allowed object is
     *     {@link Double}
     * @see duration
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    /**
     * Gets the fly to mode.
     *
     * @return     possible object is
     *     {@link FlyToMode}
     * @see flyToMode
     */
    public FlyToMode getFlyToMode() {
        return flyToMode;
    }

    /**
     * Sets the fly to mode.
     *
     * @param value     allowed object is
     *     {@link FlyToMode}
     * @see flyToMode
     */
    public void setFlyToMode(FlyToMode value) {
        this.flyToMode = value;
    }

    /**
     * Gets the abstract view.
     *
     * @return     possible object is
     *     {@code <}{@link AbstractView}{@code>}
     *     {@code <}{@link LookAt}{@code>}
     *     {@code <}{@link Camera}{@code>}
     * @see abstractView
     */
    public AbstractView getAbstractView() {
        return abstractView;
    }

    /**
     * Sets the abstract view.
     *
     * @param value     allowed object is
     *     {@code <}{@link AbstractView}{@code>}
     *     {@code <}{@link LookAt}{@code>}
     *     {@code <}{@link Camera}{@code>}
     * @see abstractView
     */
    public void setAbstractView(AbstractView value) {
        this.abstractView = (value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(duration);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((flyToMode == null)? 0 :flyToMode.hashCode()));
        result = ((prime*result)+((abstractView == null)? 0 :abstractView.hashCode()));
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
        if ((obj instanceof FlyTo) == false) {
            return false;
        }
        FlyTo other = ((FlyTo) obj);
        if (duration!= other.duration) {
            return false;
        }
        if (flyToMode == null) {
            if (other.flyToMode!= null) {
                return false;
            }
        } else {
            if (flyToMode.equals(other.flyToMode) == false) {
                return false;
            }
        }
        if (abstractView == null) {
            if (other.abstractView!= null) {
                return false;
            }
        } else {
            if (abstractView.equals(other.abstractView) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link LookAt} and set it to abstractView.
     * 
     * This method is a short version for:
     * <code>
     * LookAt lookAt = new LookAt();
     * this.setAbstractView(lookAt); </code>
     *
     * @return the look at
     */
    public LookAt createAndSetLookAt() {
        LookAt newValue = new LookAt();
        this.setAbstractView(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Camera} and set it to abstractView.
     * 
     * This method is a short version for:
     * <code>
     * Camera camera = new Camera();
     * this.setAbstractView(camera); </code>
     *
     * @return the camera
     */
    public Camera createAndSetCamera() {
        Camera newValue = new Camera();
        this.setAbstractView(newValue);
        return newValue;
    }

    /**
     * fluent setter.
     *
     * @param duration     required parameter
     * @return the fly to
     * @see #setDuration(double)
     */
    public FlyTo withDuration(final double duration) {
        this.setDuration(duration);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param flyToMode     required parameter
     * @return the fly to
     * @see #setFlyToMode(FlyToMode)
     */
    public FlyTo withFlyToMode(final FlyToMode flyToMode) {
        this.setFlyToMode(flyToMode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param abstractView     required parameter
     * @return the fly to
     * @see #setAbstractView(AbstractView)
     */
    public FlyTo withAbstractView(final AbstractView abstractView) {
        this.setAbstractView(abstractView);
        return this;
    }

    @Obvious
    @Override
    public FlyTo withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public FlyTo withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public FlyTo withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public FlyTo clone() {
        FlyTo copy;
        copy = ((FlyTo) super.clone());
        copy.abstractView = ((abstractView == null)?null:((AbstractView ) abstractView.clone()));
        return copy;
    }

}
