/*******************************************************************************************************
 *
 * PremiseNumberPrefix.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.xal;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;


/**
 * The Class PremiseNumberPrefix.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "PremiseNumberPrefix")
public class PremiseNumberPrefix implements Cloneable
{

    /** The value. */
    @XmlValue
    protected String value;
    
    /** The number prefix separator. */
    @XmlAttribute(name = "NumberPrefixSeparator")
    @XmlSchemaType(name = "anySimpleType")
    protected String numberPrefixSeparator;
    
    /** The underscore. */
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String underscore;
    
    /** The code. */
    @XmlAttribute(name = "Code")
    @XmlSchemaType(name = "anySimpleType")
    protected String code;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Instantiates a new premise number prefix.
     */
    public PremiseNumberPrefix() {
        super();
    }

    /**
     * Gets the value.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the number prefix separator.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getNumberPrefixSeparator() {
        return numberPrefixSeparator;
    }

    /**
     * Sets the number prefix separator.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setNumberPrefixSeparator(String value) {
        this.numberPrefixSeparator = value;
    }

    /**
     * Gets the underscore.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getUnderscore() {
        return underscore;
    }

    /**
     * Sets the underscore.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setUnderscore(String value) {
        this.underscore = value;
    }

    /**
     * Gets the code.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the other attributes.
     *
     * @return     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((value == null)? 0 :value.hashCode()));
        result = ((prime*result)+((numberPrefixSeparator == null)? 0 :numberPrefixSeparator.hashCode()));
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((code == null)? 0 :code.hashCode()));
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
        if ((obj instanceof PremiseNumberPrefix) == false) {
            return false;
        }
        PremiseNumberPrefix other = ((PremiseNumberPrefix) obj);
        if (value == null) {
            if (other.value!= null) {
                return false;
            }
        } else {
            if (value.equals(other.value) == false) {
                return false;
            }
        }
        if (numberPrefixSeparator == null) {
            if (other.numberPrefixSeparator!= null) {
                return false;
            }
        } else {
            if (numberPrefixSeparator.equals(other.numberPrefixSeparator) == false) {
                return false;
            }
        }
        if (underscore == null) {
            if (other.underscore!= null) {
                return false;
            }
        } else {
            if (underscore.equals(other.underscore) == false) {
                return false;
            }
        }
        if (code == null) {
            if (other.code!= null) {
                return false;
            }
        } else {
            if (code.equals(other.code) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * fluent setter.
     *
     * @param value     required parameter
     * @return the premise number prefix
     * @see #setValue(String)
     */
    public PremiseNumberPrefix withValue(final String value) {
        this.setValue(value);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param numberPrefixSeparator     required parameter
     * @return the premise number prefix
     * @see #setNumberPrefixSeparator(String)
     */
    public PremiseNumberPrefix withNumberPrefixSeparator(final String numberPrefixSeparator) {
        this.setNumberPrefixSeparator(numberPrefixSeparator);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the premise number prefix
     * @see #setUnderscore(String)
     */
    public PremiseNumberPrefix withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param code     required parameter
     * @return the premise number prefix
     * @see #setCode(String)
     */
    public PremiseNumberPrefix withCode(final String code) {
        this.setCode(code);
        return this;
    }

    @Override
    public PremiseNumberPrefix clone() {
        PremiseNumberPrefix copy;
        try {
            copy = ((PremiseNumberPrefix) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        return copy;
    }

}
