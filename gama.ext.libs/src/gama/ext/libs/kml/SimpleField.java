/*******************************************************************************************************
 *
 * SimpleField.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class SimpleField.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleFieldType", propOrder = {
    "displayName",
    "simpleFieldExtension"
})
@XmlRootElement(name = "SimpleField", namespace = "http://www.opengis.net/kml/2.2")
public class SimpleField implements Cloneable
{

    /** The display name. */
    protected String displayName;
    
    /** The simple field extension. */
    @XmlElement(name = "SimpleFieldExtension")
    protected List<Object> simpleFieldExtension;
    
    /** The type. */
    @XmlAttribute(name = "type")
    protected String type;
    
    /** The name. */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Instantiates a new simple field.
     */
    public SimpleField() {
        super();
    }

    /**
     * Gets the display name.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Gets the simple field extension.
     *
     * @return the simple field extension
     */
    public List<Object> getSimpleFieldExtension() {
        if (simpleFieldExtension == null) {
            simpleFieldExtension = new ArrayList<Object>();
        }
        return this.simpleFieldExtension;
    }

    /**
     * Gets the type.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the name.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((displayName == null)? 0 :displayName.hashCode()));
        result = ((prime*result)+((simpleFieldExtension == null)? 0 :simpleFieldExtension.hashCode()));
        result = ((prime*result)+((type == null)? 0 :type.hashCode()));
        result = ((prime*result)+((name == null)? 0 :name.hashCode()));
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
        if ((obj instanceof SimpleField) == false) {
            return false;
        }
        SimpleField other = ((SimpleField) obj);
        if (displayName == null) {
            if (other.displayName!= null) {
                return false;
            }
        } else {
            if (displayName.equals(other.displayName) == false) {
                return false;
            }
        }
        if (simpleFieldExtension == null) {
            if (other.simpleFieldExtension!= null) {
                return false;
            }
        } else {
            if (simpleFieldExtension.equals(other.simpleFieldExtension) == false) {
                return false;
            }
        }
        if (type == null) {
            if (other.type!= null) {
                return false;
            }
        } else {
            if (type.equals(other.type) == false) {
                return false;
            }
        }
        if (name == null) {
            if (other.name!= null) {
                return false;
            }
        } else {
            if (name.equals(other.name) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the value of the simpleFieldExtension property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSimpleFieldExtension} instead.
     *
     * @param simpleFieldExtension the new simple field extension
     */
    public void setSimpleFieldExtension(final List<Object> simpleFieldExtension) {
        this.simpleFieldExtension = simpleFieldExtension;
    }

    /**
     * add a value to the simpleFieldExtension property collection.
     *
     * @param simpleFieldExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SimpleField addToSimpleFieldExtension(final Object simpleFieldExtension) {
        this.getSimpleFieldExtension().add(simpleFieldExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param displayName     required parameter
     * @return the simple field
     * @see #setDisplayName(String)
     */
    public SimpleField withDisplayName(final String displayName) {
        this.setDisplayName(displayName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param simpleFieldExtension     required parameter
     * @return the simple field
     * @see #setSimpleFieldExtension(List<Object>)
     */
    public SimpleField withSimpleFieldExtension(final List<Object> simpleFieldExtension) {
        this.setSimpleFieldExtension(simpleFieldExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param type     required parameter
     * @return the simple field
     * @see #setType(String)
     */
    public SimpleField withType(final String type) {
        this.setType(type);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param name     required parameter
     * @return the simple field
     * @see #setName(String)
     */
    public SimpleField withName(final String name) {
        this.setName(name);
        return this;
    }

    @Override
    public SimpleField clone() {
        SimpleField copy;
        try {
            copy = ((SimpleField) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.simpleFieldExtension = new ArrayList<Object>((getSimpleFieldExtension().size()));
        for (Object iter: simpleFieldExtension) {
            copy.simpleFieldExtension.add(iter);
        }
        return copy;
    }

}
