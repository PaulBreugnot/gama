/*******************************************************************************************************
 *
 * Boundary.java, in gama.ext.libs, is part of the source code of the
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


/**
 * The Class Boundary.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoundaryType", propOrder = {
    "linearRing",
    "boundarySimpleExtension",
    "boundaryObjectExtension"
})
@XmlRootElement(name = "Boundary", namespace = "http://www.opengis.net/kml/2.2")
public class Boundary implements Cloneable
{

    /** The linear ring. */
    @XmlElement(name = "LinearRing")
    protected LinearRing linearRing;
    
    /** The boundary simple extension. */
    @XmlElement(name = "BoundarySimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> boundarySimpleExtension;
    
    /** The boundary object extension. */
    @XmlElement(name = "BoundaryObjectExtensionGroup")
    protected List<AbstractObject> boundaryObjectExtension;

    /**
     * Instantiates a new boundary.
     */
    public Boundary() {
        super();
    }

    /**
     * Gets the linear ring.
     *
     * @return     possible object is
     *     {@link LinearRing}
     */
    public LinearRing getLinearRing() {
        return linearRing;
    }

    /**
     * Sets the linear ring.
     *
     * @param value     allowed object is
     *     {@link LinearRing}
     */
    public void setLinearRing(LinearRing value) {
        this.linearRing = value;
    }

    /**
     * Gets the boundary simple extension.
     *
     * @return the boundary simple extension
     */
    public List<Object> getBoundarySimpleExtension() {
        if (boundarySimpleExtension == null) {
            boundarySimpleExtension = new ArrayList<Object>();
        }
        return this.boundarySimpleExtension;
    }

    /**
     * Gets the boundary object extension.
     *
     * @return the boundary object extension
     */
    public List<AbstractObject> getBoundaryObjectExtension() {
        if (boundaryObjectExtension == null) {
            boundaryObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.boundaryObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((linearRing == null)? 0 :linearRing.hashCode()));
        result = ((prime*result)+((boundarySimpleExtension == null)? 0 :boundarySimpleExtension.hashCode()));
        result = ((prime*result)+((boundaryObjectExtension == null)? 0 :boundaryObjectExtension.hashCode()));
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
        if ((obj instanceof Boundary) == false) {
            return false;
        }
        Boundary other = ((Boundary) obj);
        if (linearRing == null) {
            if (other.linearRing!= null) {
                return false;
            }
        } else {
            if (linearRing.equals(other.linearRing) == false) {
                return false;
            }
        }
        if (boundarySimpleExtension == null) {
            if (other.boundarySimpleExtension!= null) {
                return false;
            }
        } else {
            if (boundarySimpleExtension.equals(other.boundarySimpleExtension) == false) {
                return false;
            }
        }
        if (boundaryObjectExtension == null) {
            if (other.boundaryObjectExtension!= null) {
                return false;
            }
        } else {
            if (boundaryObjectExtension.equals(other.boundaryObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link LinearRing} and set it to linearRing.
     * 
     * This method is a short version for:
     * <code>
     * LinearRing linearRing = new LinearRing();
     * this.setLinearRing(linearRing); </code>
     *
     * @return the linear ring
     */
    public LinearRing createAndSetLinearRing() {
        LinearRing newValue = new LinearRing();
        this.setLinearRing(newValue);
        return newValue;
    }

    /**
     * Sets the value of the boundarySimpleExtension property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withBoundarySimpleExtension} instead.
     *
     * @param boundarySimpleExtension the new boundary simple extension
     */
    public void setBoundarySimpleExtension(final List<Object> boundarySimpleExtension) {
        this.boundarySimpleExtension = boundarySimpleExtension;
    }

    /**
     * add a value to the boundarySimpleExtension property collection.
     *
     * @param boundarySimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Boundary addToBoundarySimpleExtension(final Object boundarySimpleExtension) {
        this.getBoundarySimpleExtension().add(boundarySimpleExtension);
        return this;
    }

    /**
     * Sets the value of the boundaryObjectExtension property Objects of the following type(s) are allowed in the list List<AbstractObject>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withBoundaryObjectExtension} instead.
     *
     * @param boundaryObjectExtension the new boundary object extension
     */
    public void setBoundaryObjectExtension(final List<AbstractObject> boundaryObjectExtension) {
        this.boundaryObjectExtension = boundaryObjectExtension;
    }

    /**
     * add a value to the boundaryObjectExtension property collection.
     *
     * @param boundaryObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Boundary addToBoundaryObjectExtension(final AbstractObject boundaryObjectExtension) {
        this.getBoundaryObjectExtension().add(boundaryObjectExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param linearRing     required parameter
     * @return the boundary
     * @see #setLinearRing(LinearRing)
     */
    public Boundary withLinearRing(final LinearRing linearRing) {
        this.setLinearRing(linearRing);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param boundarySimpleExtension     required parameter
     * @return the boundary
     * @see #setBoundarySimpleExtension(List<Object>)
     */
    public Boundary withBoundarySimpleExtension(final List<Object> boundarySimpleExtension) {
        this.setBoundarySimpleExtension(boundarySimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param boundaryObjectExtension     required parameter
     * @return the boundary
     * @see #setBoundaryObjectExtension(List<AbstractObject>)
     */
    public Boundary withBoundaryObjectExtension(final List<AbstractObject> boundaryObjectExtension) {
        this.setBoundaryObjectExtension(boundaryObjectExtension);
        return this;
    }

    @Override
    public Boundary clone() {
        Boundary copy;
        try {
            copy = ((Boundary) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.linearRing = ((linearRing == null)?null:((LinearRing) linearRing.clone()));
        copy.boundarySimpleExtension = new ArrayList<Object>((getBoundarySimpleExtension().size()));
        for (Object iter: boundarySimpleExtension) {
            copy.boundarySimpleExtension.add(iter);
        }
        copy.boundaryObjectExtension = new ArrayList<AbstractObject>((getBoundaryObjectExtension().size()));
        for (AbstractObject iter: boundaryObjectExtension) {
            copy.boundaryObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
