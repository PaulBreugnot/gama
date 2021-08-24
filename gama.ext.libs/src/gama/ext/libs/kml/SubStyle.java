/*******************************************************************************************************
 *
 * SubStyle.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class SubStyle.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSubStyleType", propOrder = {
    "subStyleSimpleExtension",
    "subStyleObjectExtension"
})
@XmlSeeAlso({
    BalloonStyle.class,
    ListStyle.class,
    ColorStyle.class
})
public abstract class SubStyle
    extends AbstractObject
    implements Cloneable
{

    /** The sub style simple extension. */
    @XmlElement(name = "AbstractSubStyleSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> subStyleSimpleExtension;
    
    /** The sub style object extension. */
    @XmlElement(name = "AbstractSubStyleObjectExtensionGroup")
    protected List<AbstractObject> subStyleObjectExtension;

    /**
     * Instantiates a new sub style.
     */
    public SubStyle() {
        super();
    }

    /**
     * Gets the sub style simple extension.
     *
     * @return the sub style simple extension
     */
    public List<Object> getSubStyleSimpleExtension() {
        if (subStyleSimpleExtension == null) {
            subStyleSimpleExtension = new ArrayList<Object>();
        }
        return this.subStyleSimpleExtension;
    }

    /**
     * Gets the sub style object extension.
     *
     * @return the sub style object extension
     */
    public List<AbstractObject> getSubStyleObjectExtension() {
        if (subStyleObjectExtension == null) {
            subStyleObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.subStyleObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = ((prime*result)+((subStyleSimpleExtension == null)? 0 :subStyleSimpleExtension.hashCode()));
        result = ((prime*result)+((subStyleObjectExtension == null)? 0 :subStyleObjectExtension.hashCode()));
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
        if ((obj instanceof SubStyle) == false) {
            return false;
        }
        SubStyle other = ((SubStyle) obj);
        if (subStyleSimpleExtension == null) {
            if (other.subStyleSimpleExtension!= null) {
                return false;
            }
        } else {
            if (subStyleSimpleExtension.equals(other.subStyleSimpleExtension) == false) {
                return false;
            }
        }
        if (subStyleObjectExtension == null) {
            if (other.subStyleObjectExtension!= null) {
                return false;
            }
        } else {
            if (subStyleObjectExtension.equals(other.subStyleObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the value of the subStyleSimpleExtension property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubStyleSimpleExtension} instead.
     *
     * @param subStyleSimpleExtension the new sub style simple extension
     */
    public void setSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
        this.subStyleSimpleExtension = subStyleSimpleExtension;
    }

    /**
     * add a value to the subStyleSimpleExtension property collection.
     *
     * @param subStyleSimpleExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
        this.getSubStyleSimpleExtension().add(subStyleSimpleExtension);
        return this;
    }

    /**
     * Sets the value of the subStyleObjectExtension property Objects of the following type(s) are allowed in the list List<AbstractObject>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubStyleObjectExtension} instead.
     *
     * @param subStyleObjectExtension the new sub style object extension
     */
    public void setSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
        this.subStyleObjectExtension = subStyleObjectExtension;
    }

    /**
     * add a value to the subStyleObjectExtension property collection.
     *
     * @param subStyleObjectExtension     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
        this.getSubStyleObjectExtension().add(subStyleObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public SubStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subStyleSimpleExtension     required parameter
     * @return the sub style
     * @see #setSubStyleSimpleExtension(List<Object>)
     */
    public SubStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
        this.setSubStyleSimpleExtension(subStyleSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subStyleObjectExtension     required parameter
     * @return the sub style
     * @see #setSubStyleObjectExtension(List<AbstractObject>)
     */
    public SubStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
        this.setSubStyleObjectExtension(subStyleObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public SubStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public SubStyle withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public SubStyle withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public SubStyle clone() {
        SubStyle copy;
        copy = ((SubStyle) super.clone());
        copy.subStyleSimpleExtension = new ArrayList<Object>((getSubStyleSimpleExtension().size()));
        for (Object iter: subStyleSimpleExtension) {
            copy.subStyleSimpleExtension.add(iter);
        }
        copy.subStyleObjectExtension = new ArrayList<AbstractObject>((getSubStyleObjectExtension().size()));
        for (AbstractObject iter: subStyleObjectExtension) {
            copy.subStyleObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
