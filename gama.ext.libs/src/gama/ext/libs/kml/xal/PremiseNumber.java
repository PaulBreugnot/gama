/*******************************************************************************************************
 *
 * PremiseNumber.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * The Class PremiseNumber.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "PremiseNumber")
public class PremiseNumber implements Cloneable
{

    /** The content. */
    @XmlValue
    protected String content;
    
    /** The number. */
    @XmlAttribute(name = "NumberType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String number;
    
    /** The underscore. */
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String underscore;
    
    /** The indicator. */
    @XmlAttribute(name = "Indicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String indicator;
    
    /** The indicator occurrence. */
    @XmlAttribute(name = "IndicatorOccurrence")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String indicatorOccurrence;
    
    /** The number type occurrence. */
    @XmlAttribute(name = "NumberTypeOccurrence")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String numberTypeOccurrence;
    
    /** The code. */
    @XmlAttribute(name = "Code")
    @XmlSchemaType(name = "anySimpleType")
    protected String code;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Instantiates a new premise number.
     */
    public PremiseNumber() {
        super();
    }

    /**
     * Gets the content.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the number.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setNumber(String value) {
        this.number = value;
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
     * Gets the indicator.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * Sets the indicator.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setIndicator(String value) {
        this.indicator = value;
    }

    /**
     * Gets the indicator occurrence.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getIndicatorOccurrence() {
        return indicatorOccurrence;
    }

    /**
     * Sets the indicator occurrence.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setIndicatorOccurrence(String value) {
        this.indicatorOccurrence = value;
    }

    /**
     * Gets the number type occurrence.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getNumberTypeOccurrence() {
        return numberTypeOccurrence;
    }

    /**
     * Sets the number type occurrence.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setNumberTypeOccurrence(String value) {
        this.numberTypeOccurrence = value;
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
        result = ((prime*result)+((content == null)? 0 :content.hashCode()));
        result = ((prime*result)+((number == null)? 0 :number.hashCode()));
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((indicator == null)? 0 :indicator.hashCode()));
        result = ((prime*result)+((indicatorOccurrence == null)? 0 :indicatorOccurrence.hashCode()));
        result = ((prime*result)+((numberTypeOccurrence == null)? 0 :numberTypeOccurrence.hashCode()));
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
        if ((obj instanceof PremiseNumber) == false) {
            return false;
        }
        PremiseNumber other = ((PremiseNumber) obj);
        if (content == null) {
            if (other.content!= null) {
                return false;
            }
        } else {
            if (content.equals(other.content) == false) {
                return false;
            }
        }
        if (number == null) {
            if (other.number!= null) {
                return false;
            }
        } else {
            if (number.equals(other.number) == false) {
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
        if (indicator == null) {
            if (other.indicator!= null) {
                return false;
            }
        } else {
            if (indicator.equals(other.indicator) == false) {
                return false;
            }
        }
        if (indicatorOccurrence == null) {
            if (other.indicatorOccurrence!= null) {
                return false;
            }
        } else {
            if (indicatorOccurrence.equals(other.indicatorOccurrence) == false) {
                return false;
            }
        }
        if (numberTypeOccurrence == null) {
            if (other.numberTypeOccurrence!= null) {
                return false;
            }
        } else {
            if (numberTypeOccurrence.equals(other.numberTypeOccurrence) == false) {
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
     * @param content     required parameter
     * @return the premise number
     * @see #setContent(String)
     */
    public PremiseNumber withContent(final String content) {
        this.setContent(content);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param number     required parameter
     * @return the premise number
     * @see #setNumber(String)
     */
    public PremiseNumber withNumber(final String number) {
        this.setNumber(number);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the premise number
     * @see #setUnderscore(String)
     */
    public PremiseNumber withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param indicator     required parameter
     * @return the premise number
     * @see #setIndicator(String)
     */
    public PremiseNumber withIndicator(final String indicator) {
        this.setIndicator(indicator);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param indicatorOccurrence     required parameter
     * @return the premise number
     * @see #setIndicatorOccurrence(String)
     */
    public PremiseNumber withIndicatorOccurrence(final String indicatorOccurrence) {
        this.setIndicatorOccurrence(indicatorOccurrence);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param numberTypeOccurrence     required parameter
     * @return the premise number
     * @see #setNumberTypeOccurrence(String)
     */
    public PremiseNumber withNumberTypeOccurrence(final String numberTypeOccurrence) {
        this.setNumberTypeOccurrence(numberTypeOccurrence);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param code     required parameter
     * @return the premise number
     * @see #setCode(String)
     */
    public PremiseNumber withCode(final String code) {
        this.setCode(code);
        return this;
    }

    @Override
    public PremiseNumber clone() {
        PremiseNumber copy;
        try {
            copy = ((PremiseNumber) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        return copy;
    }

}
