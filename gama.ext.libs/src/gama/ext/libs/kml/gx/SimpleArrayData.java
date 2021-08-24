/*******************************************************************************************************
 *
 * SimpleArrayData.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import gama.ext.libs.kml.AbstractObject;
import gama.ext.libs.kml.annotations.Obvious;


/**
 * The Class SimpleArrayData.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleArrayDataType", propOrder = {
    "value",
    "simpleArrayDataExtension"
})
@XmlRootElement(name = "SimpleArrayData", namespace = "http://www.google.com/kml/ext/2.2")
public class SimpleArrayData
    extends AbstractObject
    implements Cloneable
{

    /** The value. */
    protected List<String> value;
    
    /** The simple array data extension. */
    @XmlElement(name = "SimpleArrayDataExtension")
    protected List<Object> simpleArrayDataExtension;
    
    /** The name. */
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Instantiates a new simple array data.
     */
    public SimpleArrayData() {
        super();
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public List<String> getValue() {
        if (value == null) {
            value = new ArrayList<String>();
        }
        return this.value;
    }

    /**
     * Gets the simple array data extension.
     *
     * @return the simple array data extension
     */
    public List<Object> getSimpleArrayDataExtension() {
        if (simpleArrayDataExtension == null) {
            simpleArrayDataExtension = new ArrayList<Object>();
        }
        return this.simpleArrayDataExtension;
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
        int result = super.hashCode();
        result = ((prime*result)+((value == null)? 0 :value.hashCode()));
        result = ((prime*result)+((simpleArrayDataExtension == null)? 0 :simpleArrayDataExtension.hashCode()));
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
        if (super.equals(obj) == false) {
            return false;
        }
        if ((obj instanceof SimpleArrayData) == false) {
            return false;
        }
        SimpleArrayData other = ((SimpleArrayData) obj);
        if (value == null) {
            if (other.value!= null) {
                return false;
            }
        } else {
            if (value.equals(other.value) == false) {
                return false;
            }
        }
        if (simpleArrayDataExtension == null) {
            if (other.simpleArrayDataExtension!= null) {
                return false;
            }
        } else {
            if (simpleArrayDataExtension.equals(other.simpleArrayDataExtension) == false) {
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
     * Sets the value of the value property Objects of the following type(s) are allowed in the list List<String>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withValue} instead.
     *
     * @param value the new value
     */
    public void setValue(final List<String> value) {
        this.value = value;
    }

    /**
     * add a value to the value property collection.
     *
     * @param value     Objects of the following type are allowed in the list: {@link String}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SimpleArrayData addToValue(final String value) {
        this.getValue().add(value);
        return this;
    }

    /**
     * Sets the value of the simpleArrayDataExtension property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSimpleArrayDataExtension} instead.
     *
     * @param simpleArrayDataExtension the new simple array data extension
     */
    public void setSimpleArrayDataExtension(final List<Object> simpleArrayDataExtension) {
        this.simpleArrayDataExtension = simpleArrayDataExtension;
    }

    /**
     * add a value to the simpleArrayDataExtension property collection.
     *
     * @param simpleArrayDataExtension     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SimpleArrayData addToSimpleArrayDataExtension(final Object simpleArrayDataExtension) {
        this.getSimpleArrayDataExtension().add(simpleArrayDataExtension);
        return this;
    }

    @Obvious
    @Override
    public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.setObjectSimpleExtension(objectSimpleExtension);
    }

    @Obvious
    @Override
    public SimpleArrayData addToObjectSimpleExtension(final Object objectSimpleExtension) {
        super.getObjectSimpleExtension().add(objectSimpleExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param value     required parameter
     * @return the simple array data
     * @see #setValue(List<String>)
     */
    public SimpleArrayData withValue(final List<String> value) {
        this.setValue(value);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param simpleArrayDataExtension     required parameter
     * @return the simple array data
     * @see #setSimpleArrayDataExtension(List<Object>)
     */
    public SimpleArrayData withSimpleArrayDataExtension(final List<Object> simpleArrayDataExtension) {
        this.setSimpleArrayDataExtension(simpleArrayDataExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param name     required parameter
     * @return the simple array data
     * @see #setName(String)
     */
    public SimpleArrayData withName(final String name) {
        this.setName(name);
        return this;
    }

    @Obvious
    @Override
    public SimpleArrayData withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public SimpleArrayData withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public SimpleArrayData withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Override
    public SimpleArrayData clone() {
        SimpleArrayData copy;
        copy = ((SimpleArrayData) super.clone());
        copy.value = new ArrayList<String>((getValue().size()));
        for (String iter: value) {
            copy.value.add(iter);
        }
        copy.simpleArrayDataExtension = new ArrayList<Object>((getSimpleArrayDataExtension().size()));
        for (Object iter: simpleArrayDataExtension) {
            copy.simpleArrayDataExtension.add(iter);
        }
        return copy;
    }

}
