/*******************************************************************************************************
 *
 * Thoroughfare.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * The Class Thoroughfare.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addressLine",
    "thoroughfareNumberOrThoroughfareNumberRange",
    "thoroughfareNumberPrefix",
    "thoroughfareNumberSuffix",
    "thoroughfarePreDirection",
    "thoroughfareLeading",
    "thoroughfareName",
    "thoroughfareTrailing",
    "thoroughfarePostDirection",
    "dependentThoroughfare",
    "dependentLocality",
    "premise",
    "firm",
    "postalCode",
    "any"
})
@XmlRootElement(name = "Thoroughfare")
public class Thoroughfare implements Cloneable
{

    /** The address line. */
    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    
    /** The thoroughfare number or thoroughfare number range. */
    @XmlElements({
        @XmlElement(name = "ThoroughfareNumberRange", type = Thoroughfare.ThoroughfareNumberRange.class),
        @XmlElement(name = "ThoroughfareNumber", type = ThoroughfareNumber.class)
    })
    protected List<Object> thoroughfareNumberOrThoroughfareNumberRange;
    
    /** The thoroughfare number prefix. */
    @XmlElement(name = "ThoroughfareNumberPrefix")
    protected List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix;
    
    /** The thoroughfare number suffix. */
    @XmlElement(name = "ThoroughfareNumberSuffix")
    protected List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix;
    
    /** The thoroughfare pre direction. */
    @XmlElement(name = "ThoroughfarePreDirection")
    protected ThoroughfarePreDirection thoroughfarePreDirection;
    
    /** The thoroughfare leading. */
    @XmlElement(name = "ThoroughfareLeadingType")
    protected ThoroughfareLeadingType thoroughfareLeading;
    
    /** The thoroughfare name. */
    @XmlElement(name = "ThoroughfareName")
    protected List<ThoroughfareName> thoroughfareName;
    
    /** The thoroughfare trailing. */
    @XmlElement(name = "ThoroughfareTrailingType")
    protected ThoroughfareTrailingType thoroughfareTrailing;
    
    /** The thoroughfare post direction. */
    @XmlElement(name = "ThoroughfarePostDirection")
    protected ThoroughfarePostDirection thoroughfarePostDirection;
    
    /** The dependent thoroughfare. */
    @XmlElement(name = "DependentThoroughfare")
    protected Thoroughfare.DependentThoroughfare dependentThoroughfare;
    
    /** The dependent locality. */
    @XmlElement(name = "DependentLocality")
    protected DependentLocality dependentLocality;
    
    /** The premise. */
    @XmlElement(name = "Premise")
    protected Premise premise;
    
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
    
    /** The xal dependent thoroughfares. */
    @XmlAttribute(name = "DependentThoroughfares")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xalDependentThoroughfares;
    
    /** The dependent thoroughfares indicator. */
    @XmlAttribute(name = "DependentThoroughfaresIndicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresIndicator;
    
    /** The dependent thoroughfares connector. */
    @XmlAttribute(name = "DependentThoroughfaresConnector")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresConnector;
    
    /** The dependent thoroughfares. */
    @XmlAttribute(name = "DependentThoroughfaresType")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfares;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Value constructor with only mandatory fields.
     *
     * @param dependentLocality     required parameter
     * @param premise     required parameter
     * @param firm     required parameter
     * @param postalCode     required parameter
     */
    public Thoroughfare(final DependentLocality dependentLocality, final Premise premise, final Firm firm, final PostalCode postalCode) {
        super();
        this.dependentLocality = dependentLocality;
        this.premise = premise;
        this.firm = firm;
        this.postalCode = postalCode;
    }

    /**
     * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
     * 
     */
    @Deprecated
    private Thoroughfare() {
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
     * Gets the thoroughfare number or thoroughfare number range.
     *
     * @return the thoroughfare number or thoroughfare number range
     */
    public List<Object> getThoroughfareNumberOrThoroughfareNumberRange() {
        if (thoroughfareNumberOrThoroughfareNumberRange == null) {
            thoroughfareNumberOrThoroughfareNumberRange = new ArrayList<Object>();
        }
        return this.thoroughfareNumberOrThoroughfareNumberRange;
    }

    /**
     * Gets the thoroughfare number prefix.
     *
     * @return the thoroughfare number prefix
     */
    public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
        if (thoroughfareNumberPrefix == null) {
            thoroughfareNumberPrefix = new ArrayList<ThoroughfareNumberPrefix>();
        }
        return this.thoroughfareNumberPrefix;
    }

    /**
     * Gets the thoroughfare number suffix.
     *
     * @return the thoroughfare number suffix
     */
    public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
        if (thoroughfareNumberSuffix == null) {
            thoroughfareNumberSuffix = new ArrayList<ThoroughfareNumberSuffix>();
        }
        return this.thoroughfareNumberSuffix;
    }

    /**
     * Gets the thoroughfare pre direction.
     *
     * @return     possible object is
     *     {@link ThoroughfarePreDirection}
     */
    public ThoroughfarePreDirection getThoroughfarePreDirection() {
        return thoroughfarePreDirection;
    }

    /**
     * Sets the thoroughfare pre direction.
     *
     * @param value     allowed object is
     *     {@link ThoroughfarePreDirection}
     */
    public void setThoroughfarePreDirection(ThoroughfarePreDirection value) {
        this.thoroughfarePreDirection = value;
    }

    /**
     * Gets the thoroughfare leading.
     *
     * @return     possible object is
     *     {@link ThoroughfareLeadingType}
     */
    public ThoroughfareLeadingType getThoroughfareLeading() {
        return thoroughfareLeading;
    }

    /**
     * Sets the thoroughfare leading.
     *
     * @param value     allowed object is
     *     {@link ThoroughfareLeadingType}
     */
    public void setThoroughfareLeading(ThoroughfareLeadingType value) {
        this.thoroughfareLeading = value;
    }

    /**
     * Gets the thoroughfare name.
     *
     * @return the thoroughfare name
     */
    public List<ThoroughfareName> getThoroughfareName() {
        if (thoroughfareName == null) {
            thoroughfareName = new ArrayList<ThoroughfareName>();
        }
        return this.thoroughfareName;
    }

    /**
     * Gets the thoroughfare trailing.
     *
     * @return     possible object is
     *     {@link ThoroughfareTrailingType}
     */
    public ThoroughfareTrailingType getThoroughfareTrailing() {
        return thoroughfareTrailing;
    }

    /**
     * Sets the thoroughfare trailing.
     *
     * @param value     allowed object is
     *     {@link ThoroughfareTrailingType}
     */
    public void setThoroughfareTrailing(ThoroughfareTrailingType value) {
        this.thoroughfareTrailing = value;
    }

    /**
     * Gets the thoroughfare post direction.
     *
     * @return     possible object is
     *     {@link ThoroughfarePostDirection}
     */
    public ThoroughfarePostDirection getThoroughfarePostDirection() {
        return thoroughfarePostDirection;
    }

    /**
     * Sets the thoroughfare post direction.
     *
     * @param value     allowed object is
     *     {@link ThoroughfarePostDirection}
     */
    public void setThoroughfarePostDirection(ThoroughfarePostDirection value) {
        this.thoroughfarePostDirection = value;
    }

    /**
     * Gets the dependent thoroughfare.
     *
     * @return     possible object is
     *     {@link Thoroughfare.DependentThoroughfare}
     */
    public Thoroughfare.DependentThoroughfare getDependentThoroughfare() {
        return dependentThoroughfare;
    }

    /**
     * Sets the dependent thoroughfare.
     *
     * @param value     allowed object is
     *     {@link Thoroughfare.DependentThoroughfare}
     */
    public void setDependentThoroughfare(Thoroughfare.DependentThoroughfare value) {
        this.dependentThoroughfare = value;
    }

    /**
     * Gets the dependent locality.
     *
     * @return     possible object is
     *     {@link DependentLocality}
     */
    public DependentLocality getDependentLocality() {
        return dependentLocality;
    }

    /**
     * Sets the dependent locality.
     *
     * @param value     allowed object is
     *     {@link DependentLocality}
     */
    public void setDependentLocality(DependentLocality value) {
        this.dependentLocality = value;
    }

    /**
     * Gets the premise.
     *
     * @return     possible object is
     *     {@link Premise}
     */
    public Premise getPremise() {
        return premise;
    }

    /**
     * Sets the premise.
     *
     * @param value     allowed object is
     *     {@link Premise}
     */
    public void setPremise(Premise value) {
        this.premise = value;
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
     * Gets the xal dependent thoroughfares.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getXalDependentThoroughfares() {
        return xalDependentThoroughfares;
    }

    /**
     * Sets the xal dependent thoroughfares.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setXalDependentThoroughfares(String value) {
        this.xalDependentThoroughfares = value;
    }

    /**
     * Gets the dependent thoroughfares indicator.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getDependentThoroughfaresIndicator() {
        return dependentThoroughfaresIndicator;
    }

    /**
     * Sets the dependent thoroughfares indicator.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setDependentThoroughfaresIndicator(String value) {
        this.dependentThoroughfaresIndicator = value;
    }

    /**
     * Gets the dependent thoroughfares connector.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getDependentThoroughfaresConnector() {
        return dependentThoroughfaresConnector;
    }

    /**
     * Sets the dependent thoroughfares connector.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setDependentThoroughfaresConnector(String value) {
        this.dependentThoroughfaresConnector = value;
    }

    /**
     * Gets the dependent thoroughfares.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getDependentThoroughfares() {
        return dependentThoroughfares;
    }

    /**
     * Sets the dependent thoroughfares.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setDependentThoroughfares(String value) {
        this.dependentThoroughfares = value;
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
        result = ((prime*result)+((thoroughfareNumberOrThoroughfareNumberRange == null)? 0 :thoroughfareNumberOrThoroughfareNumberRange.hashCode()));
        result = ((prime*result)+((thoroughfareNumberPrefix == null)? 0 :thoroughfareNumberPrefix.hashCode()));
        result = ((prime*result)+((thoroughfareNumberSuffix == null)? 0 :thoroughfareNumberSuffix.hashCode()));
        result = ((prime*result)+((thoroughfarePreDirection == null)? 0 :thoroughfarePreDirection.hashCode()));
        result = ((prime*result)+((thoroughfareLeading == null)? 0 :thoroughfareLeading.hashCode()));
        result = ((prime*result)+((thoroughfareName == null)? 0 :thoroughfareName.hashCode()));
        result = ((prime*result)+((thoroughfareTrailing == null)? 0 :thoroughfareTrailing.hashCode()));
        result = ((prime*result)+((thoroughfarePostDirection == null)? 0 :thoroughfarePostDirection.hashCode()));
        result = ((prime*result)+((dependentThoroughfare == null)? 0 :dependentThoroughfare.hashCode()));
        result = ((prime*result)+((dependentLocality == null)? 0 :dependentLocality.hashCode()));
        result = ((prime*result)+((premise == null)? 0 :premise.hashCode()));
        result = ((prime*result)+((firm == null)? 0 :firm.hashCode()));
        result = ((prime*result)+((postalCode == null)? 0 :postalCode.hashCode()));
        result = ((prime*result)+((any == null)? 0 :any.hashCode()));
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((xalDependentThoroughfares == null)? 0 :xalDependentThoroughfares.hashCode()));
        result = ((prime*result)+((dependentThoroughfaresIndicator == null)? 0 :dependentThoroughfaresIndicator.hashCode()));
        result = ((prime*result)+((dependentThoroughfaresConnector == null)? 0 :dependentThoroughfaresConnector.hashCode()));
        result = ((prime*result)+((dependentThoroughfares == null)? 0 :dependentThoroughfares.hashCode()));
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
        if ((obj instanceof Thoroughfare) == false) {
            return false;
        }
        Thoroughfare other = ((Thoroughfare) obj);
        if (addressLine == null) {
            if (other.addressLine!= null) {
                return false;
            }
        } else {
            if (addressLine.equals(other.addressLine) == false) {
                return false;
            }
        }
        if (thoroughfareNumberOrThoroughfareNumberRange == null) {
            if (other.thoroughfareNumberOrThoroughfareNumberRange!= null) {
                return false;
            }
        } else {
            if (thoroughfareNumberOrThoroughfareNumberRange.equals(other.thoroughfareNumberOrThoroughfareNumberRange) == false) {
                return false;
            }
        }
        if (thoroughfareNumberPrefix == null) {
            if (other.thoroughfareNumberPrefix!= null) {
                return false;
            }
        } else {
            if (thoroughfareNumberPrefix.equals(other.thoroughfareNumberPrefix) == false) {
                return false;
            }
        }
        if (thoroughfareNumberSuffix == null) {
            if (other.thoroughfareNumberSuffix!= null) {
                return false;
            }
        } else {
            if (thoroughfareNumberSuffix.equals(other.thoroughfareNumberSuffix) == false) {
                return false;
            }
        }
        if (thoroughfarePreDirection == null) {
            if (other.thoroughfarePreDirection!= null) {
                return false;
            }
        } else {
            if (thoroughfarePreDirection.equals(other.thoroughfarePreDirection) == false) {
                return false;
            }
        }
        if (thoroughfareLeading == null) {
            if (other.thoroughfareLeading!= null) {
                return false;
            }
        } else {
            if (thoroughfareLeading.equals(other.thoroughfareLeading) == false) {
                return false;
            }
        }
        if (thoroughfareName == null) {
            if (other.thoroughfareName!= null) {
                return false;
            }
        } else {
            if (thoroughfareName.equals(other.thoroughfareName) == false) {
                return false;
            }
        }
        if (thoroughfareTrailing == null) {
            if (other.thoroughfareTrailing!= null) {
                return false;
            }
        } else {
            if (thoroughfareTrailing.equals(other.thoroughfareTrailing) == false) {
                return false;
            }
        }
        if (thoroughfarePostDirection == null) {
            if (other.thoroughfarePostDirection!= null) {
                return false;
            }
        } else {
            if (thoroughfarePostDirection.equals(other.thoroughfarePostDirection) == false) {
                return false;
            }
        }
        if (dependentThoroughfare == null) {
            if (other.dependentThoroughfare!= null) {
                return false;
            }
        } else {
            if (dependentThoroughfare.equals(other.dependentThoroughfare) == false) {
                return false;
            }
        }
        if (dependentLocality == null) {
            if (other.dependentLocality!= null) {
                return false;
            }
        } else {
            if (dependentLocality.equals(other.dependentLocality) == false) {
                return false;
            }
        }
        if (premise == null) {
            if (other.premise!= null) {
                return false;
            }
        } else {
            if (premise.equals(other.premise) == false) {
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
        if (xalDependentThoroughfares == null) {
            if (other.xalDependentThoroughfares!= null) {
                return false;
            }
        } else {
            if (xalDependentThoroughfares.equals(other.xalDependentThoroughfares) == false) {
                return false;
            }
        }
        if (dependentThoroughfaresIndicator == null) {
            if (other.dependentThoroughfaresIndicator!= null) {
                return false;
            }
        } else {
            if (dependentThoroughfaresIndicator.equals(other.dependentThoroughfaresIndicator) == false) {
                return false;
            }
        }
        if (dependentThoroughfaresConnector == null) {
            if (other.dependentThoroughfaresConnector!= null) {
                return false;
            }
        } else {
            if (dependentThoroughfaresConnector.equals(other.dependentThoroughfaresConnector) == false) {
                return false;
            }
        }
        if (dependentThoroughfares == null) {
            if (other.dependentThoroughfares!= null) {
                return false;
            }
        } else {
            if (dependentThoroughfares.equals(other.dependentThoroughfares) == false) {
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
     * Creates a new instance of {@link ThoroughfareNumberPrefix} and adds it to thoroughfareNumberPrefix.
     * This method is a short version for:
     * <code>
     * ThoroughfareNumberPrefix thoroughfareNumberPrefix = new ThoroughfareNumberPrefix();
     * this.getThoroughfareNumberPrefix().add(thoroughfareNumberPrefix); </code>
     *
     * @return the thoroughfare number prefix
     */
    public ThoroughfareNumberPrefix createAndAddThoroughfareNumberPrefix() {
        ThoroughfareNumberPrefix newValue = new ThoroughfareNumberPrefix();
        this.getThoroughfareNumberPrefix().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfareNumberSuffix} and adds it to thoroughfareNumberSuffix.
     * This method is a short version for:
     * <code>
     * ThoroughfareNumberSuffix thoroughfareNumberSuffix = new ThoroughfareNumberSuffix();
     * this.getThoroughfareNumberSuffix().add(thoroughfareNumberSuffix); </code>
     *
     * @return the thoroughfare number suffix
     */
    public ThoroughfareNumberSuffix createAndAddThoroughfareNumberSuffix() {
        ThoroughfareNumberSuffix newValue = new ThoroughfareNumberSuffix();
        this.getThoroughfareNumberSuffix().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfarePreDirection} and set it to thoroughfarePreDirection.
     * 
     * This method is a short version for:
     * <code>
     * ThoroughfarePreDirection thoroughfarePreDirection = new ThoroughfarePreDirection();
     * this.setThoroughfarePreDirection(thoroughfarePreDirection); </code>
     *
     * @return the thoroughfare pre direction
     */
    public ThoroughfarePreDirection createAndSetThoroughfarePreDirection() {
        ThoroughfarePreDirection newValue = new ThoroughfarePreDirection();
        this.setThoroughfarePreDirection(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfareLeadingType} and set it to thoroughfareLeading.
     * 
     * This method is a short version for:
     * <code>
     * ThoroughfareLeadingType thoroughfareLeadingType = new ThoroughfareLeadingType();
     * this.setThoroughfareLeading(thoroughfareLeadingType); </code>
     *
     * @return the thoroughfare leading type
     */
    public ThoroughfareLeadingType createAndSetThoroughfareLeading() {
        ThoroughfareLeadingType newValue = new ThoroughfareLeadingType();
        this.setThoroughfareLeading(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfareName} and adds it to thoroughfareName.
     * This method is a short version for:
     * <code>
     * ThoroughfareName thoroughfareName = new ThoroughfareName();
     * this.getThoroughfareName().add(thoroughfareName); </code>
     *
     * @return the thoroughfare name
     */
    public ThoroughfareName createAndAddThoroughfareName() {
        ThoroughfareName newValue = new ThoroughfareName();
        this.getThoroughfareName().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfareTrailingType} and set it to thoroughfareTrailing.
     * 
     * This method is a short version for:
     * <code>
     * ThoroughfareTrailingType thoroughfareTrailingType = new ThoroughfareTrailingType();
     * this.setThoroughfareTrailing(thoroughfareTrailingType); </code>
     *
     * @return the thoroughfare trailing type
     */
    public ThoroughfareTrailingType createAndSetThoroughfareTrailing() {
        ThoroughfareTrailingType newValue = new ThoroughfareTrailingType();
        this.setThoroughfareTrailing(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link ThoroughfarePostDirection} and set it to thoroughfarePostDirection.
     * 
     * This method is a short version for:
     * <code>
     * ThoroughfarePostDirection thoroughfarePostDirection = new ThoroughfarePostDirection();
     * this.setThoroughfarePostDirection(thoroughfarePostDirection); </code>
     *
     * @return the thoroughfare post direction
     */
    public ThoroughfarePostDirection createAndSetThoroughfarePostDirection() {
        ThoroughfarePostDirection newValue = new ThoroughfarePostDirection();
        this.setThoroughfarePostDirection(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Thoroughfare.DependentThoroughfare} and set it to dependentThoroughfare.
     * 
     * This method is a short version for:
     * <code>
     * DependentThoroughfare dependentThoroughfare = new DependentThoroughfare();
     * this.setDependentThoroughfare(dependentThoroughfare); </code>
     *
     * @return the thoroughfare. dependent thoroughfare
     */
    public Thoroughfare.DependentThoroughfare createAndSetDependentThoroughfare() {
        Thoroughfare.DependentThoroughfare newValue = new Thoroughfare.DependentThoroughfare();
        this.setDependentThoroughfare(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link DependentLocality} and set it to dependentLocality.
     * 
     * This method is a short version for:
     * <code>
     * DependentLocality dependentLocality = new DependentLocality();
     * this.setDependentLocality(dependentLocality); </code>
     *
     * @param postBox     required parameter
     * @param largeMailUser     required parameter
     * @param postOffice     required parameter
     * @param postalRoute     required parameter
     * @return the dependent locality
     */
    public DependentLocality createAndSetDependentLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
        DependentLocality newValue = new DependentLocality(postBox, largeMailUser, postOffice, postalRoute);
        this.setDependentLocality(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Premise} and set it to premise.
     * 
     * This method is a short version for:
     * <code>
     * Premise premise = new Premise();
     * this.setPremise(premise); </code>
     *
     * @param premiseLocation     required parameter
     * @param premiseNumber     required parameter
     * @param premiseNumberRange     required parameter
     * @return the premise
     */
    public Premise createAndSetPremise(final Premise.PremiseLocation premiseLocation, final List<PremiseNumber> premiseNumber, final Premise.PremiseNumberRange premiseNumberRange) {
        Premise newValue = new Premise(premiseLocation, premiseNumber, premiseNumberRange);
        this.setPremise(newValue);
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
    public Thoroughfare addToAddressLine(final AddressLine addressLine) {
        this.getAddressLine().add(addressLine);
        return this;
    }

    /**
     * Sets the value of the thoroughfareNumberOrThoroughfareNumberRange property Objects of the following type(s) are allowed in the list List<Object>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withThoroughfareNumberOrThoroughfareNumberRange} instead.
     *
     * @param thoroughfareNumberOrThoroughfareNumberRange the new thoroughfare number or thoroughfare number range
     */
    public void setThoroughfareNumberOrThoroughfareNumberRange(final List<Object> thoroughfareNumberOrThoroughfareNumberRange) {
        this.thoroughfareNumberOrThoroughfareNumberRange = thoroughfareNumberOrThoroughfareNumberRange;
    }

    /**
     * add a value to the thoroughfareNumberOrThoroughfareNumberRange property collection.
     *
     * @param thoroughfareNumberOrThoroughfareNumberRange     Objects of the following type are allowed in the list: {@link Thoroughfare.ThoroughfareNumberRange}{@link ThoroughfareNumber}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Thoroughfare addToThoroughfareNumberOrThoroughfareNumberRange(final Object thoroughfareNumberOrThoroughfareNumberRange) {
        this.getThoroughfareNumberOrThoroughfareNumberRange().add(thoroughfareNumberOrThoroughfareNumberRange);
        return this;
    }

    /**
     * Sets the value of the thoroughfareNumberPrefix property Objects of the following type(s) are allowed in the list List<ThoroughfareNumberPrefix>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withThoroughfareNumberPrefix} instead.
     *
     * @param thoroughfareNumberPrefix the new thoroughfare number prefix
     */
    public void setThoroughfareNumberPrefix(final List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
        this.thoroughfareNumberPrefix = thoroughfareNumberPrefix;
    }

    /**
     * add a value to the thoroughfareNumberPrefix property collection.
     *
     * @param thoroughfareNumberPrefix     Objects of the following type are allowed in the list: {@link ThoroughfareNumberPrefix}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Thoroughfare addToThoroughfareNumberPrefix(final ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
        this.getThoroughfareNumberPrefix().add(thoroughfareNumberPrefix);
        return this;
    }

    /**
     * Sets the value of the thoroughfareNumberSuffix property Objects of the following type(s) are allowed in the list List<ThoroughfareNumberSuffix>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withThoroughfareNumberSuffix} instead.
     *
     * @param thoroughfareNumberSuffix the new thoroughfare number suffix
     */
    public void setThoroughfareNumberSuffix(final List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
        this.thoroughfareNumberSuffix = thoroughfareNumberSuffix;
    }

    /**
     * add a value to the thoroughfareNumberSuffix property collection.
     *
     * @param thoroughfareNumberSuffix     Objects of the following type are allowed in the list: {@link ThoroughfareNumberSuffix}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Thoroughfare addToThoroughfareNumberSuffix(final ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
        this.getThoroughfareNumberSuffix().add(thoroughfareNumberSuffix);
        return this;
    }

    /**
     * Sets the value of the thoroughfareName property Objects of the following type(s) are allowed in the list List<ThoroughfareName>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withThoroughfareName} instead.
     *
     * @param thoroughfareName the new thoroughfare name
     */
    public void setThoroughfareName(final List<ThoroughfareName> thoroughfareName) {
        this.thoroughfareName = thoroughfareName;
    }

    /**
     * add a value to the thoroughfareName property collection.
     *
     * @param thoroughfareName     Objects of the following type are allowed in the list: {@link ThoroughfareName}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Thoroughfare addToThoroughfareName(final ThoroughfareName thoroughfareName) {
        this.getThoroughfareName().add(thoroughfareName);
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
    public Thoroughfare addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param addressLine     required parameter
     * @return the thoroughfare
     * @see #setAddressLine(List<AddressLine>)
     */
    public Thoroughfare withAddressLine(final List<AddressLine> addressLine) {
        this.setAddressLine(addressLine);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareNumberOrThoroughfareNumberRange     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareNumberOrThoroughfareNumberRange(List<Object>)
     */
    public Thoroughfare withThoroughfareNumberOrThoroughfareNumberRange(final List<Object> thoroughfareNumberOrThoroughfareNumberRange) {
        this.setThoroughfareNumberOrThoroughfareNumberRange(thoroughfareNumberOrThoroughfareNumberRange);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareNumberPrefix     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix>)
     */
    public Thoroughfare withThoroughfareNumberPrefix(final List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
        this.setThoroughfareNumberPrefix(thoroughfareNumberPrefix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareNumberSuffix     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix>)
     */
    public Thoroughfare withThoroughfareNumberSuffix(final List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
        this.setThoroughfareNumberSuffix(thoroughfareNumberSuffix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfarePreDirection     required parameter
     * @return the thoroughfare
     * @see #setThoroughfarePreDirection(ThoroughfarePreDirection)
     */
    public Thoroughfare withThoroughfarePreDirection(final ThoroughfarePreDirection thoroughfarePreDirection) {
        this.setThoroughfarePreDirection(thoroughfarePreDirection);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareLeading     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareLeading(ThoroughfareLeadingType)
     */
    public Thoroughfare withThoroughfareLeading(final ThoroughfareLeadingType thoroughfareLeading) {
        this.setThoroughfareLeading(thoroughfareLeading);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareName     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareName(List<ThoroughfareName>)
     */
    public Thoroughfare withThoroughfareName(final List<ThoroughfareName> thoroughfareName) {
        this.setThoroughfareName(thoroughfareName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfareTrailing     required parameter
     * @return the thoroughfare
     * @see #setThoroughfareTrailing(ThoroughfareTrailingType)
     */
    public Thoroughfare withThoroughfareTrailing(final ThoroughfareTrailingType thoroughfareTrailing) {
        this.setThoroughfareTrailing(thoroughfareTrailing);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfarePostDirection     required parameter
     * @return the thoroughfare
     * @see #setThoroughfarePostDirection(ThoroughfarePostDirection)
     */
    public Thoroughfare withThoroughfarePostDirection(final ThoroughfarePostDirection thoroughfarePostDirection) {
        this.setThoroughfarePostDirection(thoroughfarePostDirection);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentThoroughfare     required parameter
     * @return the thoroughfare
     * @see #setDependentThoroughfare(DependentThoroughfare)
     */
    public Thoroughfare withDependentThoroughfare(final Thoroughfare.DependentThoroughfare dependentThoroughfare) {
        this.setDependentThoroughfare(dependentThoroughfare);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the thoroughfare
     * @see #setAny(List<Object>)
     */
    public Thoroughfare withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the thoroughfare
     * @see #setUnderscore(String)
     */
    public Thoroughfare withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param xalDependentThoroughfares     required parameter
     * @return the thoroughfare
     * @see #setXalDependentThoroughfares(String)
     */
    public Thoroughfare withXalDependentThoroughfares(final String xalDependentThoroughfares) {
        this.setXalDependentThoroughfares(xalDependentThoroughfares);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentThoroughfaresIndicator     required parameter
     * @return the thoroughfare
     * @see #setDependentThoroughfaresIndicator(String)
     */
    public Thoroughfare withDependentThoroughfaresIndicator(final String dependentThoroughfaresIndicator) {
        this.setDependentThoroughfaresIndicator(dependentThoroughfaresIndicator);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentThoroughfaresConnector     required parameter
     * @return the thoroughfare
     * @see #setDependentThoroughfaresConnector(String)
     */
    public Thoroughfare withDependentThoroughfaresConnector(final String dependentThoroughfaresConnector) {
        this.setDependentThoroughfaresConnector(dependentThoroughfaresConnector);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentThoroughfares     required parameter
     * @return the thoroughfare
     * @see #setDependentThoroughfares(String)
     */
    public Thoroughfare withDependentThoroughfares(final String dependentThoroughfares) {
        this.setDependentThoroughfares(dependentThoroughfares);
        return this;
    }

    @Override
    public Thoroughfare clone() {
        Thoroughfare copy;
        try {
            copy = ((Thoroughfare) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
        for (AddressLine iter: addressLine) {
            copy.addressLine.add(iter.clone());
        }
        copy.thoroughfareNumberOrThoroughfareNumberRange = new ArrayList<Object>((getThoroughfareNumberOrThoroughfareNumberRange().size()));
        for (Object iter: thoroughfareNumberOrThoroughfareNumberRange) {
            copy.thoroughfareNumberOrThoroughfareNumberRange.add(iter);
        }
        copy.thoroughfareNumberPrefix = new ArrayList<ThoroughfareNumberPrefix>((getThoroughfareNumberPrefix().size()));
        for (ThoroughfareNumberPrefix iter: thoroughfareNumberPrefix) {
            copy.thoroughfareNumberPrefix.add(iter.clone());
        }
        copy.thoroughfareNumberSuffix = new ArrayList<ThoroughfareNumberSuffix>((getThoroughfareNumberSuffix().size()));
        for (ThoroughfareNumberSuffix iter: thoroughfareNumberSuffix) {
            copy.thoroughfareNumberSuffix.add(iter.clone());
        }
        copy.thoroughfarePreDirection = ((thoroughfarePreDirection == null)?null:((ThoroughfarePreDirection) thoroughfarePreDirection.clone()));
        copy.thoroughfareLeading = ((thoroughfareLeading == null)?null:((ThoroughfareLeadingType) thoroughfareLeading.clone()));
        copy.thoroughfareName = new ArrayList<ThoroughfareName>((getThoroughfareName().size()));
        for (ThoroughfareName iter: thoroughfareName) {
            copy.thoroughfareName.add(iter.clone());
        }
        copy.thoroughfareTrailing = ((thoroughfareTrailing == null)?null:((ThoroughfareTrailingType) thoroughfareTrailing.clone()));
        copy.thoroughfarePostDirection = ((thoroughfarePostDirection == null)?null:((ThoroughfarePostDirection) thoroughfarePostDirection.clone()));
        copy.dependentThoroughfare = ((dependentThoroughfare == null)?null:((Thoroughfare.DependentThoroughfare) dependentThoroughfare.clone()));
        copy.dependentLocality = ((dependentLocality == null)?null:((DependentLocality) dependentLocality.clone()));
        copy.premise = ((premise == null)?null:((Premise) premise.clone()));
        copy.firm = ((firm == null)?null:((Firm) firm.clone()));
        copy.postalCode = ((postalCode == null)?null:((PostalCode) postalCode.clone()));
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }


    /**
     * The Class DependentThoroughfare.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressLine",
        "thoroughfarePreDirection",
        "thoroughfareLeading",
        "thoroughfareName",
        "thoroughfareTrailing",
        "thoroughfarePostDirection",
        "any"
    })
    @XmlRootElement(name = "DependentThoroughfare", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class DependentThoroughfare implements Cloneable
    {

        /** The address line. */
        @XmlElement(name = "AddressLine")
        protected List<AddressLine> addressLine;
        
        /** The thoroughfare pre direction. */
        @XmlElement(name = "ThoroughfarePreDirection")
        protected ThoroughfarePreDirection thoroughfarePreDirection;
        
        /** The thoroughfare leading. */
        @XmlElement(name = "ThoroughfareLeadingType")
        protected ThoroughfareLeadingType thoroughfareLeading;
        
        /** The thoroughfare name. */
        @XmlElement(name = "ThoroughfareName")
        protected List<ThoroughfareName> thoroughfareName;
        
        /** The thoroughfare trailing. */
        @XmlElement(name = "ThoroughfareTrailingType")
        protected ThoroughfareTrailingType thoroughfareTrailing;
        
        /** The thoroughfare post direction. */
        @XmlElement(name = "ThoroughfarePostDirection")
        protected ThoroughfarePostDirection thoroughfarePostDirection;
        
        /** The any. */
        @XmlAnyElement(lax = true)
        protected List<Object> any;
        
        /** The underscore. */
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String underscore;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new dependent thoroughfare.
         */
        public DependentThoroughfare() {
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
         * Gets the thoroughfare pre direction.
         *
         * @return     possible object is
         *     {@link ThoroughfarePreDirection}
         */
        public ThoroughfarePreDirection getThoroughfarePreDirection() {
            return thoroughfarePreDirection;
        }

        /**
         * Sets the thoroughfare pre direction.
         *
         * @param value     allowed object is
         *     {@link ThoroughfarePreDirection}
         */
        public void setThoroughfarePreDirection(ThoroughfarePreDirection value) {
            this.thoroughfarePreDirection = value;
        }

        /**
         * Gets the thoroughfare leading.
         *
         * @return     possible object is
         *     {@link ThoroughfareLeadingType}
         */
        public ThoroughfareLeadingType getThoroughfareLeading() {
            return thoroughfareLeading;
        }

        /**
         * Sets the thoroughfare leading.
         *
         * @param value     allowed object is
         *     {@link ThoroughfareLeadingType}
         */
        public void setThoroughfareLeading(ThoroughfareLeadingType value) {
            this.thoroughfareLeading = value;
        }

        /**
         * Gets the thoroughfare name.
         *
         * @return the thoroughfare name
         */
        public List<ThoroughfareName> getThoroughfareName() {
            if (thoroughfareName == null) {
                thoroughfareName = new ArrayList<ThoroughfareName>();
            }
            return this.thoroughfareName;
        }

        /**
         * Gets the thoroughfare trailing.
         *
         * @return     possible object is
         *     {@link ThoroughfareTrailingType}
         */
        public ThoroughfareTrailingType getThoroughfareTrailing() {
            return thoroughfareTrailing;
        }

        /**
         * Sets the thoroughfare trailing.
         *
         * @param value     allowed object is
         *     {@link ThoroughfareTrailingType}
         */
        public void setThoroughfareTrailing(ThoroughfareTrailingType value) {
            this.thoroughfareTrailing = value;
        }

        /**
         * Gets the thoroughfare post direction.
         *
         * @return     possible object is
         *     {@link ThoroughfarePostDirection}
         */
        public ThoroughfarePostDirection getThoroughfarePostDirection() {
            return thoroughfarePostDirection;
        }

        /**
         * Sets the thoroughfare post direction.
         *
         * @param value     allowed object is
         *     {@link ThoroughfarePostDirection}
         */
        public void setThoroughfarePostDirection(ThoroughfarePostDirection value) {
            this.thoroughfarePostDirection = value;
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
            result = ((prime*result)+((thoroughfarePreDirection == null)? 0 :thoroughfarePreDirection.hashCode()));
            result = ((prime*result)+((thoroughfareLeading == null)? 0 :thoroughfareLeading.hashCode()));
            result = ((prime*result)+((thoroughfareName == null)? 0 :thoroughfareName.hashCode()));
            result = ((prime*result)+((thoroughfareTrailing == null)? 0 :thoroughfareTrailing.hashCode()));
            result = ((prime*result)+((thoroughfarePostDirection == null)? 0 :thoroughfarePostDirection.hashCode()));
            result = ((prime*result)+((any == null)? 0 :any.hashCode()));
            result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
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
            if ((obj instanceof Thoroughfare.DependentThoroughfare) == false) {
                return false;
            }
            Thoroughfare.DependentThoroughfare other = ((Thoroughfare.DependentThoroughfare) obj);
            if (addressLine == null) {
                if (other.addressLine!= null) {
                    return false;
                }
            } else {
                if (addressLine.equals(other.addressLine) == false) {
                    return false;
                }
            }
            if (thoroughfarePreDirection == null) {
                if (other.thoroughfarePreDirection!= null) {
                    return false;
                }
            } else {
                if (thoroughfarePreDirection.equals(other.thoroughfarePreDirection) == false) {
                    return false;
                }
            }
            if (thoroughfareLeading == null) {
                if (other.thoroughfareLeading!= null) {
                    return false;
                }
            } else {
                if (thoroughfareLeading.equals(other.thoroughfareLeading) == false) {
                    return false;
                }
            }
            if (thoroughfareName == null) {
                if (other.thoroughfareName!= null) {
                    return false;
                }
            } else {
                if (thoroughfareName.equals(other.thoroughfareName) == false) {
                    return false;
                }
            }
            if (thoroughfareTrailing == null) {
                if (other.thoroughfareTrailing!= null) {
                    return false;
                }
            } else {
                if (thoroughfareTrailing.equals(other.thoroughfareTrailing) == false) {
                    return false;
                }
            }
            if (thoroughfarePostDirection == null) {
                if (other.thoroughfarePostDirection!= null) {
                    return false;
                }
            } else {
                if (thoroughfarePostDirection.equals(other.thoroughfarePostDirection) == false) {
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
         * Creates a new instance of {@link ThoroughfarePreDirection} and set it to thoroughfarePreDirection.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfarePreDirection thoroughfarePreDirection = new ThoroughfarePreDirection();
         * this.setThoroughfarePreDirection(thoroughfarePreDirection); </code>
         *
         * @return the thoroughfare pre direction
         */
        public ThoroughfarePreDirection createAndSetThoroughfarePreDirection() {
            ThoroughfarePreDirection newValue = new ThoroughfarePreDirection();
            this.setThoroughfarePreDirection(newValue);
            return newValue;
        }

        /**
         * Creates a new instance of {@link ThoroughfareLeadingType} and set it to thoroughfareLeading.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfareLeadingType thoroughfareLeadingType = new ThoroughfareLeadingType();
         * this.setThoroughfareLeading(thoroughfareLeadingType); </code>
         *
         * @return the thoroughfare leading type
         */
        public ThoroughfareLeadingType createAndSetThoroughfareLeading() {
            ThoroughfareLeadingType newValue = new ThoroughfareLeadingType();
            this.setThoroughfareLeading(newValue);
            return newValue;
        }

        /**
         * Creates a new instance of {@link ThoroughfareName} and adds it to thoroughfareName.
         * This method is a short version for:
         * <code>
         * ThoroughfareName thoroughfareName = new ThoroughfareName();
         * this.getThoroughfareName().add(thoroughfareName); </code>
         *
         * @return the thoroughfare name
         */
        public ThoroughfareName createAndAddThoroughfareName() {
            ThoroughfareName newValue = new ThoroughfareName();
            this.getThoroughfareName().add(newValue);
            return newValue;
        }

        /**
         * Creates a new instance of {@link ThoroughfareTrailingType} and set it to thoroughfareTrailing.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfareTrailingType thoroughfareTrailingType = new ThoroughfareTrailingType();
         * this.setThoroughfareTrailing(thoroughfareTrailingType); </code>
         *
         * @return the thoroughfare trailing type
         */
        public ThoroughfareTrailingType createAndSetThoroughfareTrailing() {
            ThoroughfareTrailingType newValue = new ThoroughfareTrailingType();
            this.setThoroughfareTrailing(newValue);
            return newValue;
        }

        /**
         * Creates a new instance of {@link ThoroughfarePostDirection} and set it to thoroughfarePostDirection.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfarePostDirection thoroughfarePostDirection = new ThoroughfarePostDirection();
         * this.setThoroughfarePostDirection(thoroughfarePostDirection); </code>
         *
         * @return the thoroughfare post direction
         */
        public ThoroughfarePostDirection createAndSetThoroughfarePostDirection() {
            ThoroughfarePostDirection newValue = new ThoroughfarePostDirection();
            this.setThoroughfarePostDirection(newValue);
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
        public Thoroughfare.DependentThoroughfare addToAddressLine(final AddressLine addressLine) {
            this.getAddressLine().add(addressLine);
            return this;
        }

        /**
         * Sets the value of the thoroughfareName property Objects of the following type(s) are allowed in the list List<ThoroughfareName>.
         * <p>Note:
         * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withThoroughfareName} instead.
         *
         * @param thoroughfareName the new thoroughfare name
         */
        public void setThoroughfareName(final List<ThoroughfareName> thoroughfareName) {
            this.thoroughfareName = thoroughfareName;
        }

        /**
         * add a value to the thoroughfareName property collection.
         *
         * @param thoroughfareName     Objects of the following type are allowed in the list: {@link ThoroughfareName}
         * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
         */
        public Thoroughfare.DependentThoroughfare addToThoroughfareName(final ThoroughfareName thoroughfareName) {
            this.getThoroughfareName().add(thoroughfareName);
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
        public Thoroughfare.DependentThoroughfare addToAny(final Object any) {
            this.getAny().add(any);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param addressLine     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setAddressLine(List<AddressLine>)
         */
        public Thoroughfare.DependentThoroughfare withAddressLine(final List<AddressLine> addressLine) {
            this.setAddressLine(addressLine);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param thoroughfarePreDirection     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setThoroughfarePreDirection(ThoroughfarePreDirection)
         */
        public Thoroughfare.DependentThoroughfare withThoroughfarePreDirection(final ThoroughfarePreDirection thoroughfarePreDirection) {
            this.setThoroughfarePreDirection(thoroughfarePreDirection);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param thoroughfareLeading     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setThoroughfareLeading(ThoroughfareLeadingType)
         */
        public Thoroughfare.DependentThoroughfare withThoroughfareLeading(final ThoroughfareLeadingType thoroughfareLeading) {
            this.setThoroughfareLeading(thoroughfareLeading);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param thoroughfareName     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setThoroughfareName(List<ThoroughfareName>)
         */
        public Thoroughfare.DependentThoroughfare withThoroughfareName(final List<ThoroughfareName> thoroughfareName) {
            this.setThoroughfareName(thoroughfareName);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param thoroughfareTrailing     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setThoroughfareTrailing(ThoroughfareTrailingType)
         */
        public Thoroughfare.DependentThoroughfare withThoroughfareTrailing(final ThoroughfareTrailingType thoroughfareTrailing) {
            this.setThoroughfareTrailing(thoroughfareTrailing);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param thoroughfarePostDirection     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setThoroughfarePostDirection(ThoroughfarePostDirection)
         */
        public Thoroughfare.DependentThoroughfare withThoroughfarePostDirection(final ThoroughfarePostDirection thoroughfarePostDirection) {
            this.setThoroughfarePostDirection(thoroughfarePostDirection);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param any     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setAny(List<Object>)
         */
        public Thoroughfare.DependentThoroughfare withAny(final List<Object> any) {
            this.setAny(any);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the thoroughfare. dependent thoroughfare
         * @see #setUnderscore(String)
         */
        public Thoroughfare.DependentThoroughfare withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        @Override
        public Thoroughfare.DependentThoroughfare clone() {
            Thoroughfare.DependentThoroughfare copy;
            try {
                copy = ((Thoroughfare.DependentThoroughfare) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
            for (AddressLine iter: addressLine) {
                copy.addressLine.add(iter.clone());
            }
            copy.thoroughfarePreDirection = ((thoroughfarePreDirection == null)?null:((ThoroughfarePreDirection) thoroughfarePreDirection.clone()));
            copy.thoroughfareLeading = ((thoroughfareLeading == null)?null:((ThoroughfareLeadingType) thoroughfareLeading.clone()));
            copy.thoroughfareName = new ArrayList<ThoroughfareName>((getThoroughfareName().size()));
            for (ThoroughfareName iter: thoroughfareName) {
                copy.thoroughfareName.add(iter.clone());
            }
            copy.thoroughfareTrailing = ((thoroughfareTrailing == null)?null:((ThoroughfareTrailingType) thoroughfareTrailing.clone()));
            copy.thoroughfarePostDirection = ((thoroughfarePostDirection == null)?null:((ThoroughfarePostDirection) thoroughfarePostDirection.clone()));
            copy.any = new ArrayList<Object>((getAny().size()));
            for (Object iter: any) {
                copy.any.add(iter);
            }
            return copy;
        }

    }


    /**
     * The Class ThoroughfareNumberRange.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressLine",
        "thoroughfareNumberFrom",
        "thoroughfareNumberTo"
    })
    @XmlRootElement(name = "ThoroughfareNumberRange", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class ThoroughfareNumberRange implements Cloneable
    {

        /** The address line. */
        @XmlElement(name = "AddressLine")
        protected List<AddressLine> addressLine;
        
        /** The thoroughfare number from. */
        @XmlElement(name = "ThoroughfareNumberFrom", required = true)
        protected Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom;
        
        /** The thoroughfare number to. */
        @XmlElement(name = "ThoroughfareNumberTo", required = true)
        protected Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo;
        
        /** The range. */
        @XmlAttribute(name = "RangeType")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String range;
        
        /** The indicator. */
        @XmlAttribute(name = "Indicator")
        @XmlSchemaType(name = "anySimpleType")
        protected String indicator;
        
        /** The separator. */
        @XmlAttribute(name = "Separator")
        @XmlSchemaType(name = "anySimpleType")
        protected String separator;
        
        /** The indicator occurrence. */
        @XmlAttribute(name = "IndicatorOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String indicatorOccurrence;
        
        /** The number range occurrence. */
        @XmlAttribute(name = "NumberRangeOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String numberRangeOccurrence;
        
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
         * Value constructor with only mandatory fields.
         *
         * @param thoroughfareNumberFrom     required parameter
         * @param thoroughfareNumberTo     required parameter
         */
        public ThoroughfareNumberRange(final Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom, final Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo) {
            super();
            this.thoroughfareNumberFrom = thoroughfareNumberFrom;
            this.thoroughfareNumberTo = thoroughfareNumberTo;
        }

        /**
         * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
         * 
         */
        @Deprecated
        private ThoroughfareNumberRange() {
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
         * Gets the thoroughfare number from.
         *
         * @return     possible object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom}
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom getThoroughfareNumberFrom() {
            return thoroughfareNumberFrom;
        }

        /**
         * Sets the thoroughfare number from.
         *
         * @param value     allowed object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom}
         */
        public void setThoroughfareNumberFrom(Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom value) {
            this.thoroughfareNumberFrom = value;
        }

        /**
         * Gets the thoroughfare number to.
         *
         * @return     possible object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo}
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo getThoroughfareNumberTo() {
            return thoroughfareNumberTo;
        }

        /**
         * Sets the thoroughfare number to.
         *
         * @param value     allowed object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo}
         */
        public void setThoroughfareNumberTo(Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo value) {
            this.thoroughfareNumberTo = value;
        }

        /**
         * Gets the range.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getRange() {
            return range;
        }

        /**
         * Sets the range.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setRange(String value) {
            this.range = value;
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
         * Gets the separator.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getSeparator() {
            return separator;
        }

        /**
         * Sets the separator.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setSeparator(String value) {
            this.separator = value;
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
         * Gets the number range occurrence.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getNumberRangeOccurrence() {
            return numberRangeOccurrence;
        }

        /**
         * Sets the number range occurrence.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setNumberRangeOccurrence(String value) {
            this.numberRangeOccurrence = value;
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
            result = ((prime*result)+((addressLine == null)? 0 :addressLine.hashCode()));
            result = ((prime*result)+((thoroughfareNumberFrom == null)? 0 :thoroughfareNumberFrom.hashCode()));
            result = ((prime*result)+((thoroughfareNumberTo == null)? 0 :thoroughfareNumberTo.hashCode()));
            result = ((prime*result)+((range == null)? 0 :range.hashCode()));
            result = ((prime*result)+((indicator == null)? 0 :indicator.hashCode()));
            result = ((prime*result)+((separator == null)? 0 :separator.hashCode()));
            result = ((prime*result)+((indicatorOccurrence == null)? 0 :indicatorOccurrence.hashCode()));
            result = ((prime*result)+((numberRangeOccurrence == null)? 0 :numberRangeOccurrence.hashCode()));
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
            if ((obj instanceof Thoroughfare.ThoroughfareNumberRange) == false) {
                return false;
            }
            Thoroughfare.ThoroughfareNumberRange other = ((Thoroughfare.ThoroughfareNumberRange) obj);
            if (addressLine == null) {
                if (other.addressLine!= null) {
                    return false;
                }
            } else {
                if (addressLine.equals(other.addressLine) == false) {
                    return false;
                }
            }
            if (thoroughfareNumberFrom == null) {
                if (other.thoroughfareNumberFrom!= null) {
                    return false;
                }
            } else {
                if (thoroughfareNumberFrom.equals(other.thoroughfareNumberFrom) == false) {
                    return false;
                }
            }
            if (thoroughfareNumberTo == null) {
                if (other.thoroughfareNumberTo!= null) {
                    return false;
                }
            } else {
                if (thoroughfareNumberTo.equals(other.thoroughfareNumberTo) == false) {
                    return false;
                }
            }
            if (range == null) {
                if (other.range!= null) {
                    return false;
                }
            } else {
                if (range.equals(other.range) == false) {
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
            if (separator == null) {
                if (other.separator!= null) {
                    return false;
                }
            } else {
                if (separator.equals(other.separator) == false) {
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
            if (numberRangeOccurrence == null) {
                if (other.numberRangeOccurrence!= null) {
                    return false;
                }
            } else {
                if (numberRangeOccurrence.equals(other.numberRangeOccurrence) == false) {
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
         * Creates a new instance of {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom} and set it to thoroughfareNumberFrom.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfareNumberFrom thoroughfareNumberFrom = new ThoroughfareNumberFrom();
         * this.setThoroughfareNumberFrom(thoroughfareNumberFrom); </code>
         *
         * @return the thoroughfare. thoroughfare number range. thoroughfare number from
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom createAndSetThoroughfareNumberFrom() {
            Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom newValue = new Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom();
            this.setThoroughfareNumberFrom(newValue);
            return newValue;
        }

        /**
         * Creates a new instance of {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo} and set it to thoroughfareNumberTo.
         * 
         * This method is a short version for:
         * <code>
         * ThoroughfareNumberTo thoroughfareNumberTo = new ThoroughfareNumberTo();
         * this.setThoroughfareNumberTo(thoroughfareNumberTo); </code>
         *
         * @return the thoroughfare. thoroughfare number range. thoroughfare number to
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo createAndSetThoroughfareNumberTo() {
            Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo newValue = new Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo();
            this.setThoroughfareNumberTo(newValue);
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
        public Thoroughfare.ThoroughfareNumberRange addToAddressLine(final AddressLine addressLine) {
            this.getAddressLine().add(addressLine);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param addressLine     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setAddressLine(List<AddressLine>)
         */
        public Thoroughfare.ThoroughfareNumberRange withAddressLine(final List<AddressLine> addressLine) {
            this.setAddressLine(addressLine);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param range     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setRange(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withRange(final String range) {
            this.setRange(range);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param indicator     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setIndicator(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withIndicator(final String indicator) {
            this.setIndicator(indicator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param separator     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setSeparator(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withSeparator(final String separator) {
            this.setSeparator(separator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param indicatorOccurrence     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setIndicatorOccurrence(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withIndicatorOccurrence(final String indicatorOccurrence) {
            this.setIndicatorOccurrence(indicatorOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberRangeOccurrence     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setNumberRangeOccurrence(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withNumberRangeOccurrence(final String numberRangeOccurrence) {
            this.setNumberRangeOccurrence(numberRangeOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setUnderscore(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the thoroughfare. thoroughfare number range
         * @see #setCode(String)
         */
        public Thoroughfare.ThoroughfareNumberRange withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public Thoroughfare.ThoroughfareNumberRange clone() {
            Thoroughfare.ThoroughfareNumberRange copy;
            try {
                copy = ((Thoroughfare.ThoroughfareNumberRange) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
            for (AddressLine iter: addressLine) {
                copy.addressLine.add(iter.clone());
            }
            copy.thoroughfareNumberFrom = ((thoroughfareNumberFrom == null)?null:((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom) thoroughfareNumberFrom.clone()));
            copy.thoroughfareNumberTo = ((thoroughfareNumberTo == null)?null:((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo) thoroughfareNumberTo.clone()));
            return copy;
        }


        /**
         * The Class ThoroughfareNumberFrom.
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        @XmlRootElement(name = "ThoroughfareNumberFrom", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
        public static class ThoroughfareNumberFrom implements Cloneable
        {

            /** The content. */
            @XmlElementRefs({
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefix.class),
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLine.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffix.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumber.class)
            })
            @XmlMixed
            protected List<Object> content;
            
            /** The code. */
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            
            /** The other attributes. */
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Instantiates a new thoroughfare number from.
             */
            public ThoroughfareNumberFrom() {
                super();
            }

            /**
             * Gets the content.
             *
             * @return the content
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
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
                if ((obj instanceof Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom) == false) {
                    return false;
                }
                Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom other = ((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom) obj);
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
             * Sets the value of the content property Objects of the following type(s) are allowed in the list List<Object>.
             * <p>Note:
             * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withContent} instead.
             *
             * @param content the new content
             */
            public void setContent(final List<Object> content) {
                this.content = content;
            }

            /**
             * add a value to the content property collection.
             *
             * @param content     Objects of the following type are allowed in the list: {@link String}{@link ThoroughfareNumberPrefix}{@link AddressLine}{@link ThoroughfareNumber}{@link ThoroughfareNumberSuffix}
             * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom addToContent(final Object content) {
                this.getContent().add(content);
                return this;
            }

            /**
             * fluent setter.
             *
             * @param content     required parameter
             * @return the thoroughfare. thoroughfare number range. thoroughfare number from
             * @see #setContent(List<Object>)
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom withContent(final List<Object> content) {
                this.setContent(content);
                return this;
            }

            /**
             * fluent setter.
             *
             * @param code     required parameter
             * @return the thoroughfare. thoroughfare number range. thoroughfare number from
             * @see #setCode(String)
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom withCode(final String code) {
                this.setCode(code);
                return this;
            }

            @Override
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom clone() {
                Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom copy;
                try {
                    copy = ((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom) super.clone());
                } catch (CloneNotSupportedException _x) {
                    throw new InternalError((_x.toString()));
                }
                copy.content = new ArrayList<Object>((getContent().size()));
                for (Object iter: content) {
                    copy.content.add(iter);
                }
                return copy;
            }

        }


        /**
         * The Class ThoroughfareNumberTo.
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        @XmlRootElement(name = "ThoroughfareNumberTo", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
        public static class ThoroughfareNumberTo implements Cloneable
        {

            /** The content. */
            @XmlElementRefs({
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefix.class),
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLine.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffix.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumber.class)
            })
            @XmlMixed
            protected List<Object> content;
            
            /** The code. */
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            
            /** The other attributes. */
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Instantiates a new thoroughfare number to.
             */
            public ThoroughfareNumberTo() {
                super();
            }

            /**
             * Gets the content.
             *
             * @return the content
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
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
                if ((obj instanceof Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo) == false) {
                    return false;
                }
                Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo other = ((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo) obj);
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
             * Sets the value of the content property Objects of the following type(s) are allowed in the list List<Object>.
             * <p>Note:
             * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withContent} instead.
             *
             * @param content the new content
             */
            public void setContent(final List<Object> content) {
                this.content = content;
            }

            /**
             * add a value to the content property collection.
             *
             * @param content     Objects of the following type are allowed in the list: {@link String}{@link ThoroughfareNumberPrefix}{@link AddressLine}{@link ThoroughfareNumber}{@link ThoroughfareNumberSuffix}
             * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo addToContent(final Object content) {
                this.getContent().add(content);
                return this;
            }

            /**
             * fluent setter.
             *
             * @param content     required parameter
             * @return the thoroughfare. thoroughfare number range. thoroughfare number to
             * @see #setContent(List<Object>)
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo withContent(final List<Object> content) {
                this.setContent(content);
                return this;
            }

            /**
             * fluent setter.
             *
             * @param code     required parameter
             * @return the thoroughfare. thoroughfare number range. thoroughfare number to
             * @see #setCode(String)
             */
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo withCode(final String code) {
                this.setCode(code);
                return this;
            }

            @Override
            public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo clone() {
                Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo copy;
                try {
                    copy = ((Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo) super.clone());
                } catch (CloneNotSupportedException _x) {
                    throw new InternalError((_x.toString()));
                }
                copy.content = new ArrayList<Object>((getContent().size()));
                for (Object iter: content) {
                    copy.content.add(iter);
                }
                return copy;
            }

        }

    }

}
