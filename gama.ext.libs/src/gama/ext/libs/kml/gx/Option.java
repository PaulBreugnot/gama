/*******************************************************************************************************
 *
 * Option.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.gx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The Class Option.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "optionType")
@XmlRootElement(name = "Option", namespace = "http://www.google.com/kml/ext/2.2")
public class Option implements Cloneable
{

    /** The name. */
    @XmlAttribute(name = "name")
    protected String name;
    
    /** The enabled. */
    @XmlAttribute(name = "enabled")
    protected boolean enabled;

    /**
     * Instantiates a new option.
     */
    public Option() {
        super();
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

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     *
     * @param value the new enabled
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((name == null)? 0 :name.hashCode()));
        result = ((prime*result)+(new Boolean(enabled).hashCode()));
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
        if ((obj instanceof Option) == false) {
            return false;
        }
        Option other = ((Option) obj);
        if (name == null) {
            if (other.name!= null) {
                return false;
            }
        } else {
            if (name.equals(other.name) == false) {
                return false;
            }
        }
        if (enabled!= other.enabled) {
            return false;
        }
        return true;
    }

    /**
     * fluent setter.
     *
     * @param name     required parameter
     * @return the option
     * @see #setName(String)
     */
    public Option withName(final String name) {
        this.setName(name);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param enabled     required parameter
     * @return the option
     * @see #setEnabled(boolean)
     */
    public Option withEnabled(final boolean enabled) {
        this.setEnabled(enabled);
        return this;
    }

    @Override
    public Option clone() {
        Option copy;
        try {
            copy = ((Option) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        return copy;
    }

}
