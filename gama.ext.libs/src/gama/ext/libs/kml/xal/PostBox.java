/*******************************************************************************************************
 *
 * PostBox.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml.xal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;


/**
 * The Class PostBox.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addressLine",
    "postBoxNumber",
    "postBoxNumberPrefix",
    "postBoxNumberSuffix",
    "postBoxNumberExtension",
    "firm",
    "postalCode",
    "any"
})
@XmlRootElement(name = "PostBox")
public class PostBox implements Cloneable
{

    /** The address line. */
    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    
    /** The post box number. */
    @XmlElement(name = "PostBoxNumber", required = true)
    protected PostBox.PostBoxNumber postBoxNumber;
    
    /** The post box number prefix. */
    @XmlElement(name = "PostBoxNumberPrefix")
    protected PostBox.PostBoxNumberPrefix postBoxNumberPrefix;
    
    /** The post box number suffix. */
    @XmlElement(name = "PostBoxNumberSuffix")
    protected PostBox.PostBoxNumberSuffix postBoxNumberSuffix;
    
    /** The post box number extension. */
    @XmlElement(name = "PostBoxNumberExtension")
    protected PostBox.PostBoxNumberExtension postBoxNumberExtension;
    
    /** The firm. */
    @XmlElement(name = "Firm")
    protected Firm firm;
    
    /** The postal code. */
    @XmlElement(name = "PostalCode")
    protected PostalCode postalCode;
    
    /** The any. */
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    
    /** The underscore. */
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String underscore;
    
    /** The indicator. */
    @XmlAttribute(name = "Indicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String indicator;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Value constructor with only mandatory fields.
     *
     * @param postBoxNumber     required parameter
     */
    public PostBox(final PostBox.PostBoxNumber postBoxNumber) {
        super();
        this.postBoxNumber = postBoxNumber;
    }

    /**
     * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
     * 
     */
    @Deprecated
    private PostBox() {
        super();
    }

    /**
     * Gets the address line.
     *
     * @return the address line
     */
    public List<AddressLine> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<AddressLine>();
        }
        return this.addressLine;
    }

    /**
     * Gets the post box number.
     *
     * @return     possible object is
     *     {@link PostBox.PostBoxNumber}
     */
    public PostBox.PostBoxNumber getPostBoxNumber() {
        return postBoxNumber;
    }

    /**
     * Sets the post box number.
     *
     * @param value     allowed object is
     *     {@link PostBox.PostBoxNumber}
     */
    public void setPostBoxNumber(PostBox.PostBoxNumber value) {
        this.postBoxNumber = value;
    }

    /**
     * Gets the post box number prefix.
     *
     * @return     possible object is
     *     {@link PostBox.PostBoxNumberPrefix}
     */
    public PostBox.PostBoxNumberPrefix getPostBoxNumberPrefix() {
        return postBoxNumberPrefix;
    }

    /**
     * Sets the post box number prefix.
     *
     * @param value     allowed object is
     *     {@link PostBox.PostBoxNumberPrefix}
     */
    public void setPostBoxNumberPrefix(PostBox.PostBoxNumberPrefix value) {
        this.postBoxNumberPrefix = value;
    }

    /**
     * Gets the post box number suffix.
     *
     * @return     possible object is
     *     {@link PostBox.PostBoxNumberSuffix}
     */
    public PostBox.PostBoxNumberSuffix getPostBoxNumberSuffix() {
        return postBoxNumberSuffix;
    }

    /**
     * Sets the post box number suffix.
     *
     * @param value     allowed object is
     *     {@link PostBox.PostBoxNumberSuffix}
     */
    public void setPostBoxNumberSuffix(PostBox.PostBoxNumberSuffix value) {
        this.postBoxNumberSuffix = value;
    }

    /**
     * Gets the post box number extension.
     *
     * @return     possible object is
     *     {@link PostBox.PostBoxNumberExtension}
     */
    public PostBox.PostBoxNumberExtension getPostBoxNumberExtension() {
        return postBoxNumberExtension;
    }

    /**
     * Sets the post box number extension.
     *
     * @param value     allowed object is
     *     {@link PostBox.PostBoxNumberExtension}
     */
    public void setPostBoxNumberExtension(PostBox.PostBoxNumberExtension value) {
        this.postBoxNumberExtension = value;
    }

    /**
     * Gets the firm.
     *
     * @return     possible object is
     *     {@link Firm}
     */
    public Firm getFirm() {
        return firm;
    }

    /**
     * Sets the firm.
     *
     * @param value     allowed object is
     *     {@link Firm}
     */
    public void setFirm(Firm value) {
        this.firm = value;
    }

    /**
     * Gets the postal code.
     *
     * @return     possible object is
     *     {@link PostalCode}
     */
    public PostalCode getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param value     allowed object is
     *     {@link PostalCode}
     */
    public void setPostalCode(PostalCode value) {
        this.postalCode = value;
    }

    /**
     * Gets the any.
     *
     * @return the any
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
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
        result = ((prime*result)+((addressLine == null)? 0 :addressLine.hashCode()));
        result = ((prime*result)+((postBoxNumber == null)? 0 :postBoxNumber.hashCode()));
        result = ((prime*result)+((postBoxNumberPrefix == null)? 0 :postBoxNumberPrefix.hashCode()));
        result = ((prime*result)+((postBoxNumberSuffix == null)? 0 :postBoxNumberSuffix.hashCode()));
        result = ((prime*result)+((postBoxNumberExtension == null)? 0 :postBoxNumberExtension.hashCode()));
        result = ((prime*result)+((firm == null)? 0 :firm.hashCode()));
        result = ((prime*result)+((postalCode == null)? 0 :postalCode.hashCode()));
        result = ((prime*result)+((any == null)? 0 :any.hashCode()));
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((indicator == null)? 0 :indicator.hashCode()));
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
        if ((obj instanceof PostBox) == false) {
            return false;
        }
        PostBox other = ((PostBox) obj);
        if (addressLine == null) {
            if (other.addressLine!= null) {
                return false;
            }
        } else {
            if (addressLine.equals(other.addressLine) == false) {
                return false;
            }
        }
        if (postBoxNumber == null) {
            if (other.postBoxNumber!= null) {
                return false;
            }
        } else {
            if (postBoxNumber.equals(other.postBoxNumber) == false) {
                return false;
            }
        }
        if (postBoxNumberPrefix == null) {
            if (other.postBoxNumberPrefix!= null) {
                return false;
            }
        } else {
            if (postBoxNumberPrefix.equals(other.postBoxNumberPrefix) == false) {
                return false;
            }
        }
        if (postBoxNumberSuffix == null) {
            if (other.postBoxNumberSuffix!= null) {
                return false;
            }
        } else {
            if (postBoxNumberSuffix.equals(other.postBoxNumberSuffix) == false) {
                return false;
            }
        }
        if (postBoxNumberExtension == null) {
            if (other.postBoxNumberExtension!= null) {
                return false;
            }
        } else {
            if (postBoxNumberExtension.equals(other.postBoxNumberExtension) == false) {
                return false;
            }
        }
        if (firm == null) {
            if (other.firm!= null) {
                return false;
            }
        } else {
            if (firm.equals(other.firm) == false) {
                return false;
            }
        }
        if (postalCode == null) {
            if (other.postalCode!= null) {
                return false;
            }
        } else {
            if (postalCode.equals(other.postalCode) == false) {
                return false;
            }
        }
        if (any == null) {
            if (other.any!= null) {
                return false;
            }
        } else {
            if (any.equals(other.any) == false) {
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
        return true;
    }

    /**
     * Creates a new instance of {@link AddressLine} and adds it to addressLine.
     * This method is a short version for:
     * <code>
     * AddressLine addressLine = new AddressLine();
     * this.getAddressLine().add(addressLine); </code>
     *
     * @return the address line
     */
    public AddressLine createAndAddAddressLine() {
        AddressLine newValue = new AddressLine();
        this.getAddressLine().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostBox.PostBoxNumber} and set it to postBoxNumber.
     * 
     * This method is a short version for:
     * <code>
     * PostBoxNumber postBoxNumber = new PostBoxNumber();
     * this.setPostBoxNumber(postBoxNumber); </code>
     *
     * @return the post box. post box number
     */
    public PostBox.PostBoxNumber createAndSetPostBoxNumber() {
        PostBox.PostBoxNumber newValue = new PostBox.PostBoxNumber();
        this.setPostBoxNumber(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostBox.PostBoxNumberPrefix} and set it to postBoxNumberPrefix.
     * 
     * This method is a short version for:
     * <code>
     * PostBoxNumberPrefix postBoxNumberPrefix = new PostBoxNumberPrefix();
     * this.setPostBoxNumberPrefix(postBoxNumberPrefix); </code>
     *
     * @return the post box. post box number prefix
     */
    public PostBox.PostBoxNumberPrefix createAndSetPostBoxNumberPrefix() {
        PostBox.PostBoxNumberPrefix newValue = new PostBox.PostBoxNumberPrefix();
        this.setPostBoxNumberPrefix(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostBox.PostBoxNumberSuffix} and set it to postBoxNumberSuffix.
     * 
     * This method is a short version for:
     * <code>
     * PostBoxNumberSuffix postBoxNumberSuffix = new PostBoxNumberSuffix();
     * this.setPostBoxNumberSuffix(postBoxNumberSuffix); </code>
     *
     * @return the post box. post box number suffix
     */
    public PostBox.PostBoxNumberSuffix createAndSetPostBoxNumberSuffix() {
        PostBox.PostBoxNumberSuffix newValue = new PostBox.PostBoxNumberSuffix();
        this.setPostBoxNumberSuffix(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostBox.PostBoxNumberExtension} and set it to postBoxNumberExtension.
     * 
     * This method is a short version for:
     * <code>
     * PostBoxNumberExtension postBoxNumberExtension = new PostBoxNumberExtension();
     * this.setPostBoxNumberExtension(postBoxNumberExtension); </code>
     *
     * @return the post box. post box number extension
     */
    public PostBox.PostBoxNumberExtension createAndSetPostBoxNumberExtension() {
        PostBox.PostBoxNumberExtension newValue = new PostBox.PostBoxNumberExtension();
        this.setPostBoxNumberExtension(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Firm} and set it to firm.
     * 
     * This method is a short version for:
     * <code>
     * Firm firm = new Firm();
     * this.setFirm(firm); </code>
     *
     * @return the firm
     */
    public Firm createAndSetFirm() {
        Firm newValue = new Firm();
        this.setFirm(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostalCode} and set it to postalCode.
     * 
     * This method is a short version for:
     * <code>
     * PostalCode postalCode = new PostalCode();
     * this.setPostalCode(postalCode); </code>
     *
     * @return the postal code
     */
    public PostalCode createAndSetPostalCode() {
        PostalCode newValue = new PostalCode();
        this.setPostalCode(newValue);
        return newValue;
    }

    /**
     * Sets the value of the addressLine property Objects of the following type(s) are allowed in the list List<AddressLine>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withAddressLine} instead.
     *
     * @param addressLine the new address line
     */
    public void setAddressLine(final List<AddressLine> addressLine) {
        this.addressLine = addressLine;
    }

    /**
     * add a value to the addressLine property collection.
     *
     * @param addressLine     Objects of the following type are allowed in the list: {@link AddressLine}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public PostBox addToAddressLine(final AddressLine addressLine) {
        this.getAddressLine().add(addressLine);
        return this;
    }

    /**
     * Sets the value of the any property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withAny} instead.
     *
     * @param any the new any
     */
    public void setAny(final List<Object> any) {
        this.any = any;
    }

    /**
     * add a value to the any property collection.
     *
     * @param any     Objects of the following type are allowed in the list: {@link Object}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public PostBox addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param addressLine     required parameter
     * @return the post box
     * @see #setAddressLine(List<AddressLine>)
     */
    public PostBox withAddressLine(final List<AddressLine> addressLine) {
        this.setAddressLine(addressLine);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postBoxNumberPrefix     required parameter
     * @return the post box
     * @see #setPostBoxNumberPrefix(PostBoxNumberPrefix)
     */
    public PostBox withPostBoxNumberPrefix(final PostBox.PostBoxNumberPrefix postBoxNumberPrefix) {
        this.setPostBoxNumberPrefix(postBoxNumberPrefix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postBoxNumberSuffix     required parameter
     * @return the post box
     * @see #setPostBoxNumberSuffix(PostBoxNumberSuffix)
     */
    public PostBox withPostBoxNumberSuffix(final PostBox.PostBoxNumberSuffix postBoxNumberSuffix) {
        this.setPostBoxNumberSuffix(postBoxNumberSuffix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postBoxNumberExtension     required parameter
     * @return the post box
     * @see #setPostBoxNumberExtension(PostBoxNumberExtension)
     */
    public PostBox withPostBoxNumberExtension(final PostBox.PostBoxNumberExtension postBoxNumberExtension) {
        this.setPostBoxNumberExtension(postBoxNumberExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param firm     required parameter
     * @return the post box
     * @see #setFirm(Firm)
     */
    public PostBox withFirm(final Firm firm) {
        this.setFirm(firm);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postalCode     required parameter
     * @return the post box
     * @see #setPostalCode(PostalCode)
     */
    public PostBox withPostalCode(final PostalCode postalCode) {
        this.setPostalCode(postalCode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the post box
     * @see #setAny(List<Object>)
     */
    public PostBox withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the post box
     * @see #setUnderscore(String)
     */
    public PostBox withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param indicator     required parameter
     * @return the post box
     * @see #setIndicator(String)
     */
    public PostBox withIndicator(final String indicator) {
        this.setIndicator(indicator);
        return this;
    }

    @Override
    public PostBox clone() {
        PostBox copy;
        try {
            copy = ((PostBox) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
        for (AddressLine iter: addressLine) {
            copy.addressLine.add(iter.clone());
        }
        copy.postBoxNumber = ((postBoxNumber == null)?null:((PostBox.PostBoxNumber) postBoxNumber.clone()));
        copy.postBoxNumberPrefix = ((postBoxNumberPrefix == null)?null:((PostBox.PostBoxNumberPrefix) postBoxNumberPrefix.clone()));
        copy.postBoxNumberSuffix = ((postBoxNumberSuffix == null)?null:((PostBox.PostBoxNumberSuffix) postBoxNumberSuffix.clone()));
        copy.postBoxNumberExtension = ((postBoxNumberExtension == null)?null:((PostBox.PostBoxNumberExtension) postBoxNumberExtension.clone()));
        copy.firm = ((firm == null)?null:((Firm) firm.clone()));
        copy.postalCode = ((postalCode == null)?null:((PostalCode) postalCode.clone()));
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }


    /**
     * The Class PostBoxNumber.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "PostBoxNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class PostBoxNumber implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new post box number.
         */
        public PostBoxNumber() {
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
            if ((obj instanceof PostBox.PostBoxNumber) == false) {
                return false;
            }
            PostBox.PostBoxNumber other = ((PostBox.PostBoxNumber) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
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
         * @return the post box. post box number
         * @see #setContent(String)
         */
        public PostBox.PostBoxNumber withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the post box. post box number
         * @see #setCode(String)
         */
        public PostBox.PostBoxNumber withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public PostBox.PostBoxNumber clone() {
            PostBox.PostBoxNumber copy;
            try {
                copy = ((PostBox.PostBoxNumber) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class PostBoxNumberExtension.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "PostBoxNumberExtension", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class PostBoxNumberExtension implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The number extension separator. */
        @XmlAttribute(name = "NumberExtensionSeparator")
        @XmlSchemaType(name = "anySimpleType")
        protected String numberExtensionSeparator;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new post box number extension.
         */
        public PostBoxNumberExtension() {
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
         * Gets the number extension separator.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getNumberExtensionSeparator() {
            return numberExtensionSeparator;
        }

        /**
         * Sets the number extension separator.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setNumberExtensionSeparator(String value) {
            this.numberExtensionSeparator = value;
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
            result = ((prime*result)+((numberExtensionSeparator == null)? 0 :numberExtensionSeparator.hashCode()));
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
            if ((obj instanceof PostBox.PostBoxNumberExtension) == false) {
                return false;
            }
            PostBox.PostBoxNumberExtension other = ((PostBox.PostBoxNumberExtension) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
                    return false;
                }
            }
            if (numberExtensionSeparator == null) {
                if (other.numberExtensionSeparator!= null) {
                    return false;
                }
            } else {
                if (numberExtensionSeparator.equals(other.numberExtensionSeparator) == false) {
                    return false;
                }
            }
            return true;
        }

        /**
         * fluent setter.
         *
         * @param content     required parameter
         * @return the post box. post box number extension
         * @see #setContent(String)
         */
        public PostBox.PostBoxNumberExtension withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberExtensionSeparator     required parameter
         * @return the post box. post box number extension
         * @see #setNumberExtensionSeparator(String)
         */
        public PostBox.PostBoxNumberExtension withNumberExtensionSeparator(final String numberExtensionSeparator) {
            this.setNumberExtensionSeparator(numberExtensionSeparator);
            return this;
        }

        @Override
        public PostBox.PostBoxNumberExtension clone() {
            PostBox.PostBoxNumberExtension copy;
            try {
                copy = ((PostBox.PostBoxNumberExtension) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class PostBoxNumberPrefix.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "PostBoxNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class PostBoxNumberPrefix implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The number prefix separator. */
        @XmlAttribute(name = "NumberPrefixSeparator")
        @XmlSchemaType(name = "anySimpleType")
        protected String numberPrefixSeparator;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new post box number prefix.
         */
        public PostBoxNumberPrefix() {
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
            result = ((prime*result)+((numberPrefixSeparator == null)? 0 :numberPrefixSeparator.hashCode()));
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
            if ((obj instanceof PostBox.PostBoxNumberPrefix) == false) {
                return false;
            }
            PostBox.PostBoxNumberPrefix other = ((PostBox.PostBoxNumberPrefix) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
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
         * @return the post box. post box number prefix
         * @see #setContent(String)
         */
        public PostBox.PostBoxNumberPrefix withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberPrefixSeparator     required parameter
         * @return the post box. post box number prefix
         * @see #setNumberPrefixSeparator(String)
         */
        public PostBox.PostBoxNumberPrefix withNumberPrefixSeparator(final String numberPrefixSeparator) {
            this.setNumberPrefixSeparator(numberPrefixSeparator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the post box. post box number prefix
         * @see #setCode(String)
         */
        public PostBox.PostBoxNumberPrefix withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public PostBox.PostBoxNumberPrefix clone() {
            PostBox.PostBoxNumberPrefix copy;
            try {
                copy = ((PostBox.PostBoxNumberPrefix) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class PostBoxNumberSuffix.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "PostBoxNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class PostBoxNumberSuffix implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The number suffix separator. */
        @XmlAttribute(name = "NumberSuffixSeparator")
        @XmlSchemaType(name = "anySimpleType")
        protected String numberSuffixSeparator;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new post box number suffix.
         */
        public PostBoxNumberSuffix() {
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
         * Gets the number suffix separator.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getNumberSuffixSeparator() {
            return numberSuffixSeparator;
        }

        /**
         * Sets the number suffix separator.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setNumberSuffixSeparator(String value) {
            this.numberSuffixSeparator = value;
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
            result = ((prime*result)+((numberSuffixSeparator == null)? 0 :numberSuffixSeparator.hashCode()));
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
            if ((obj instanceof PostBox.PostBoxNumberSuffix) == false) {
                return false;
            }
            PostBox.PostBoxNumberSuffix other = ((PostBox.PostBoxNumberSuffix) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
                    return false;
                }
            }
            if (numberSuffixSeparator == null) {
                if (other.numberSuffixSeparator!= null) {
                    return false;
                }
            } else {
                if (numberSuffixSeparator.equals(other.numberSuffixSeparator) == false) {
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
         * @return the post box. post box number suffix
         * @see #setContent(String)
         */
        public PostBox.PostBoxNumberSuffix withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberSuffixSeparator     required parameter
         * @return the post box. post box number suffix
         * @see #setNumberSuffixSeparator(String)
         */
        public PostBox.PostBoxNumberSuffix withNumberSuffixSeparator(final String numberSuffixSeparator) {
            this.setNumberSuffixSeparator(numberSuffixSeparator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the post box. post box number suffix
         * @see #setCode(String)
         */
        public PostBox.PostBoxNumberSuffix withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public PostBox.PostBoxNumberSuffix clone() {
            PostBox.PostBoxNumberSuffix copy;
            try {
                copy = ((PostBox.PostBoxNumberSuffix) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }

}
