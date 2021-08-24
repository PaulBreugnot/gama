/*******************************************************************************************************
 *
 * Metadata.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <metadata> (deprecated in kml 2.2; use <extendeddata> instead)
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataType", propOrder = {
    "any"
})
@Deprecated
@XmlRootElement(name = "Metadata", namespace = "http://www.opengis.net/kml/2.2")
public class Metadata implements Cloneable
{

    /** The any. */
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Instantiates a new metadata.
     */
    public Metadata() {
        super();
    }

    /**
     * Gets the any.
     *
     * @return the any
     * @see any
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((any == null)? 0 :any.hashCode()));
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
        if ((obj instanceof Metadata) == false) {
            return false;
        }
        Metadata other = ((Metadata) obj);
        if (any == null) {
            if (other.any!= null) {
                return false;
            }
        } else {
            if (any.equals(other.any) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the any.
     *
     * @param any the new any
     * @see any
     */
    public void setAny(final List<Object> any) {
        this.any = any;
    }

    /**
     * add a value to the any property collection.
     *
     * @param any     Objects of the following type are allowed in the list: {@link Object}{@link Element}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Metadata addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the metadata
     * @see #setAny(List<Object>)
     */
    public Metadata withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    @Override
    public Metadata clone() {
        Metadata copy;
        try {
            copy = ((Metadata) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }

}
