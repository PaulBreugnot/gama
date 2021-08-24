/*******************************************************************************************************
 *
 * BuildingName.java, in gama.ext.libs, is part of the source code of the
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
 * The Class BuildingName.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingNameType", propOrder = {
    "content"
})
@XmlRootElement(name = "BuildingName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class BuildingName implements Cloneable
{

    /** The content. */
    @XmlValue
    protected String content;
    
    /** The underscore. */
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String underscore;
    
    /** The type occurrence. */
    @XmlAttribute(name = "TypeOccurrence")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String typeOccurrence;
    
    /** The code. */
    @XmlAttribute(name = "Code")
    @XmlSchemaType(name = "anySimpleType")
    protected String code;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Instantiates a new building name.
     */
    public BuildingName() {
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
     * Gets the type occurrence.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getTypeOccurrence() {
        return typeOccurrence;
    }

    /**
     * Sets the type occurrence.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setTypeOccurrence(String value) {
        this.typeOccurrence = value;
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
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((typeOccurrence == null)? 0 :typeOccurrence.hashCode()));
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
        if ((obj instanceof BuildingName) == false) {
            return false;
        }
        BuildingName other = ((BuildingName) obj);
        if (content == null) {
            if (other.content!= null) {
                return false;
            }
        } else {
            if (content.equals(other.content) == false) {
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
        if (typeOccurrence == null) {
            if (other.typeOccurrence!= null) {
                return false;
            }
        } else {
            if (typeOccurrence.equals(other.typeOccurrence) == false) {
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
     * @return the building name
     * @see #setContent(String)
     */
    public BuildingName withContent(final String content) {
        this.setContent(content);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the building name
     * @see #setUnderscore(String)
     */
    public BuildingName withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param typeOccurrence     required parameter
     * @return the building name
     * @see #setTypeOccurrence(String)
     */
    public BuildingName withTypeOccurrence(final String typeOccurrence) {
        this.setTypeOccurrence(typeOccurrence);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param code     required parameter
     * @return the building name
     * @see #setCode(String)
     */
    public BuildingName withCode(final String code) {
        this.setCode(code);
        return this;
    }

    @Override
    public BuildingName clone() {
        BuildingName copy;
        try {
            copy = ((BuildingName) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        return copy;
    }

}
