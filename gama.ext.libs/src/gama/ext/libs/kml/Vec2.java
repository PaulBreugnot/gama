/*******************************************************************************************************
 *
 * Vec2.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Vec2
 * <p>
 * x=double xunits=kml:unitsEnum y=double yunits=kml:unitsEnum 
 * </p>
 * 
 * See Also: 
 * See <hotSpot> in <IconStyle>, <ScreenOverlay>.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vec2Type")
@XmlRootElement(name = "Vec2", namespace = "http://www.opengis.net/kml/2.2")
public class Vec2 implements Cloneable
{

    /**
     * <x>, <y>, <w>, <h>
     * <p>
     * Use of these elements within <Icon> has been deprecated. 
     * </p>
     * 
     * 
     * 
     */
    @XmlAttribute(name = "x")
    protected double x;
    
    /** The y. */
    @XmlAttribute(name = "y")
    protected double y;
    
    /** Units <p> fraction, pixels, insetPixels  </p>  See Also:  See <hotSpot> in <IconStyle>, <ScreenOverlay>. */
    @XmlAttribute(name = "xunits")
    protected Units xunits;
    
    /** Units <p> fraction, pixels, insetPixels  </p>  See Also:  See <hotSpot> in <IconStyle>, <ScreenOverlay>. */
    @XmlAttribute(name = "yunits")
    protected Units yunits;

    /**
     * Instantiates a new vec 2.
     */
    public Vec2() {
        super();
    }

    /**
     * Gets the x.
     *
     * @return the x
     * @see x
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x.
     *
     * @param value the new x
     * @see x
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * Gets the y.
     *
     * @return the y
     * @see y
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y.
     *
     * @param value the new y
     * @see y
     */
    public void setY(double value) {
        this.y = value;
    }

    /**
     * Gets the xunits.
     *
     * @return     possible object is
     *     {@link Units}
     * @see xunits
     */
    public Units getXunits() {
        if (xunits == null) {
            return Units.FRACTION;
        } else {
            return xunits;
        }
    }

    /**
     * Sets the xunits.
     *
     * @param value     allowed object is
     *     {@link Units}
     * @see xunits
     */
    public void setXunits(Units value) {
        this.xunits = value;
    }

    /**
     * Gets the yunits.
     *
     * @return     possible object is
     *     {@link Units}
     * @see yunits
     */
    public Units getYunits() {
        if (yunits == null) {
            return Units.FRACTION;
        } else {
            return yunits;
        }
    }

    /**
     * Sets the yunits.
     *
     * @param value     allowed object is
     *     {@link Units}
     * @see yunits
     */
    public void setYunits(Units value) {
        this.yunits = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(y);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((xunits == null)? 0 :xunits.hashCode()));
        result = ((prime*result)+((yunits == null)? 0 :yunits.hashCode()));
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
        if ((obj instanceof Vec2) == false) {
            return false;
        }
        Vec2 other = ((Vec2) obj);
        if (x!= other.x) {
            return false;
        }
        if (y!= other.y) {
            return false;
        }
        if (xunits == null) {
            if (other.xunits!= null) {
                return false;
            }
        } else {
            if (xunits.equals(other.xunits) == false) {
                return false;
            }
        }
        if (yunits == null) {
            if (other.yunits!= null) {
                return false;
            }
        } else {
            if (yunits.equals(other.yunits) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * fluent setter.
     *
     * @param x     required parameter
     * @return the vec 2
     * @see #setX(double)
     */
    public Vec2 withX(final double x) {
        this.setX(x);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param y     required parameter
     * @return the vec 2
     * @see #setY(double)
     */
    public Vec2 withY(final double y) {
        this.setY(y);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param xunits     required parameter
     * @return the vec 2
     * @see #setXunits(Units)
     */
    public Vec2 withXunits(final Units xunits) {
        this.setXunits(xunits);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param yunits     required parameter
     * @return the vec 2
     * @see #setYunits(Units)
     */
    public Vec2 withYunits(final Units yunits) {
        this.setYunits(yunits);
        return this;
    }

    @Override
    public Vec2 clone() {
        Vec2 copy;
        try {
            copy = ((Vec2) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        return copy;
    }

}
