/*******************************************************************************************************
 *
 * DependentLocality.java, in gama.ext.libs, is part of the source code of the
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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * The Class DependentLocality.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DependentLocalityType", propOrder = {
    "addressLine",
    "dependentLocalityName",
    "dependentLocalityNumber",
    "postBox",
    "largeMailUser",
    "postOffice",
    "postalRoute",
    "thoroughfare",
    "premise",
    "dependentLocality",
    "postalCode",
    "any"
})
@XmlRootElement(name = "DependentLocality", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class DependentLocality implements Cloneable
{

    /** The address line. */
    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    
    /** The dependent locality name. */
    @XmlElement(name = "DependentLocalityName")
    protected List<DependentLocality.DependentLocalityName> dependentLocalityName;
    
    /** The dependent locality number. */
    @XmlElement(name = "DependentLocalityNumber")
    protected DependentLocality.DependentLocalityNumber dependentLocalityNumber;
    
    /** The post box. */
    @XmlElement(name = "PostBox")
    protected PostBox postBox;
    
    /** The large mail user. */
    @XmlElement(name = "LargeMailUser")
    protected LargeMailUser largeMailUser;
    
    /** The post office. */
    @XmlElement(name = "PostOffice")
    protected PostOffice postOffice;
    
    /** The postal route. */
    @XmlElement(name = "PostalRoute")
    protected PostalRoute postalRoute;
    
    /** The thoroughfare. */
    @XmlElement(name = "Thoroughfare")
    protected Thoroughfare thoroughfare;
    
    /** The premise. */
    @XmlElement(name = "Premise")
    protected Premise premise;
    
    /** The dependent locality. */
    @XmlElement(name = "DependentLocality")
    protected DependentLocality dependentLocality;
    
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
    
    /** The usage. */
    @XmlAttribute(name = "UsageType")
    @XmlSchemaType(name = "anySimpleType")
    protected String usage;
    
    /** The connector. */
    @XmlAttribute(name = "Connector")
    @XmlSchemaType(name = "anySimpleType")
    protected String connector;
    
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
     * @param postBox     required parameter
     * @param largeMailUser     required parameter
     * @param postOffice     required parameter
     * @param postalRoute     required parameter
     */
    public DependentLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
        super();
        this.postBox = postBox;
        this.largeMailUser = largeMailUser;
        this.postOffice = postOffice;
        this.postalRoute = postalRoute;
    }

    /**
     * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
     * 
     */
    @Deprecated
    private DependentLocality() {
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
     * Gets the dependent locality name.
     *
     * @return the dependent locality name
     */
    public List<DependentLocality.DependentLocalityName> getDependentLocalityName() {
        if (dependentLocalityName == null) {
            dependentLocalityName = new ArrayList<DependentLocality.DependentLocalityName>();
        }
        return this.dependentLocalityName;
    }

    /**
     * Gets the dependent locality number.
     *
     * @return     possible object is
     *     {@link DependentLocality.DependentLocalityNumber}
     */
    public DependentLocality.DependentLocalityNumber getDependentLocalityNumber() {
        return dependentLocalityNumber;
    }

    /**
     * Sets the dependent locality number.
     *
     * @param value     allowed object is
     *     {@link DependentLocality.DependentLocalityNumber}
     */
    public void setDependentLocalityNumber(DependentLocality.DependentLocalityNumber value) {
        this.dependentLocalityNumber = value;
    }

    /**
     * Gets the post box.
     *
     * @return     possible object is
     *     {@link PostBox}
     */
    public PostBox getPostBox() {
        return postBox;
    }

    /**
     * Sets the post box.
     *
     * @param value     allowed object is
     *     {@link PostBox}
     */
    public void setPostBox(PostBox value) {
        this.postBox = value;
    }

    /**
     * Gets the large mail user.
     *
     * @return     possible object is
     *     {@link LargeMailUser}
     */
    public LargeMailUser getLargeMailUser() {
        return largeMailUser;
    }

    /**
     * Sets the large mail user.
     *
     * @param value     allowed object is
     *     {@link LargeMailUser}
     */
    public void setLargeMailUser(LargeMailUser value) {
        this.largeMailUser = value;
    }

    /**
     * Gets the post office.
     *
     * @return     possible object is
     *     {@link PostOffice}
     */
    public PostOffice getPostOffice() {
        return postOffice;
    }

    /**
     * Sets the post office.
     *
     * @param value     allowed object is
     *     {@link PostOffice}
     */
    public void setPostOffice(PostOffice value) {
        this.postOffice = value;
    }

    /**
     * Gets the postal route.
     *
     * @return     possible object is
     *     {@link PostalRoute}
     */
    public PostalRoute getPostalRoute() {
        return postalRoute;
    }

    /**
     * Sets the postal route.
     *
     * @param value     allowed object is
     *     {@link PostalRoute}
     */
    public void setPostalRoute(PostalRoute value) {
        this.postalRoute = value;
    }

    /**
     * Gets the thoroughfare.
     *
     * @return     possible object is
     *     {@link Thoroughfare}
     */
    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }

    /**
     * Sets the thoroughfare.
     *
     * @param value     allowed object is
     *     {@link Thoroughfare}
     */
    public void setThoroughfare(Thoroughfare value) {
        this.thoroughfare = value;
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
     * Gets the usage.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the usage.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setUsage(String value) {
        this.usage = value;
    }

    /**
     * Gets the connector.
     *
     * @return     possible object is
     *     {@link String}
     */
    public String getConnector() {
        return connector;
    }

    /**
     * Sets the connector.
     *
     * @param value     allowed object is
     *     {@link String}
     */
    public void setConnector(String value) {
        this.connector = value;
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
        result = ((prime*result)+((dependentLocalityName == null)? 0 :dependentLocalityName.hashCode()));
        result = ((prime*result)+((dependentLocalityNumber == null)? 0 :dependentLocalityNumber.hashCode()));
        result = ((prime*result)+((postBox == null)? 0 :postBox.hashCode()));
        result = ((prime*result)+((largeMailUser == null)? 0 :largeMailUser.hashCode()));
        result = ((prime*result)+((postOffice == null)? 0 :postOffice.hashCode()));
        result = ((prime*result)+((postalRoute == null)? 0 :postalRoute.hashCode()));
        result = ((prime*result)+((thoroughfare == null)? 0 :thoroughfare.hashCode()));
        result = ((prime*result)+((premise == null)? 0 :premise.hashCode()));
        result = ((prime*result)+((dependentLocality == null)? 0 :dependentLocality.hashCode()));
        result = ((prime*result)+((postalCode == null)? 0 :postalCode.hashCode()));
        result = ((prime*result)+((any == null)? 0 :any.hashCode()));
        result = ((prime*result)+((underscore == null)? 0 :underscore.hashCode()));
        result = ((prime*result)+((usage == null)? 0 :usage.hashCode()));
        result = ((prime*result)+((connector == null)? 0 :connector.hashCode()));
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
        if ((obj instanceof DependentLocality) == false) {
            return false;
        }
        DependentLocality other = ((DependentLocality) obj);
        if (addressLine == null) {
            if (other.addressLine!= null) {
                return false;
            }
        } else {
            if (addressLine.equals(other.addressLine) == false) {
                return false;
            }
        }
        if (dependentLocalityName == null) {
            if (other.dependentLocalityName!= null) {
                return false;
            }
        } else {
            if (dependentLocalityName.equals(other.dependentLocalityName) == false) {
                return false;
            }
        }
        if (dependentLocalityNumber == null) {
            if (other.dependentLocalityNumber!= null) {
                return false;
            }
        } else {
            if (dependentLocalityNumber.equals(other.dependentLocalityNumber) == false) {
                return false;
            }
        }
        if (postBox == null) {
            if (other.postBox!= null) {
                return false;
            }
        } else {
            if (postBox.equals(other.postBox) == false) {
                return false;
            }
        }
        if (largeMailUser == null) {
            if (other.largeMailUser!= null) {
                return false;
            }
        } else {
            if (largeMailUser.equals(other.largeMailUser) == false) {
                return false;
            }
        }
        if (postOffice == null) {
            if (other.postOffice!= null) {
                return false;
            }
        } else {
            if (postOffice.equals(other.postOffice) == false) {
                return false;
            }
        }
        if (postalRoute == null) {
            if (other.postalRoute!= null) {
                return false;
            }
        } else {
            if (postalRoute.equals(other.postalRoute) == false) {
                return false;
            }
        }
        if (thoroughfare == null) {
            if (other.thoroughfare!= null) {
                return false;
            }
        } else {
            if (thoroughfare.equals(other.thoroughfare) == false) {
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
        if (dependentLocality == null) {
            if (other.dependentLocality!= null) {
                return false;
            }
        } else {
            if (dependentLocality.equals(other.dependentLocality) == false) {
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
        if (usage == null) {
            if (other.usage!= null) {
                return false;
            }
        } else {
            if (usage.equals(other.usage) == false) {
                return false;
            }
        }
        if (connector == null) {
            if (other.connector!= null) {
                return false;
            }
        } else {
            if (connector.equals(other.connector) == false) {
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
     * Creates a new instance of {@link DependentLocality.DependentLocalityName} and adds it to dependentLocalityName.
     * This method is a short version for:
     * <code>
     * DependentLocalityName dependentLocalityName = new DependentLocalityName();
     * this.getDependentLocalityName().add(dependentLocalityName); </code>
     *
     * @return the dependent locality. dependent locality name
     */
    public DependentLocality.DependentLocalityName createAndAddDependentLocalityName() {
        DependentLocality.DependentLocalityName newValue = new DependentLocality.DependentLocalityName();
        this.getDependentLocalityName().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link DependentLocality.DependentLocalityNumber} and set it to dependentLocalityNumber.
     * 
     * This method is a short version for:
     * <code>
     * DependentLocalityNumber dependentLocalityNumber = new DependentLocalityNumber();
     * this.setDependentLocalityNumber(dependentLocalityNumber); </code>
     *
     * @return the dependent locality. dependent locality number
     */
    public DependentLocality.DependentLocalityNumber createAndSetDependentLocalityNumber() {
        DependentLocality.DependentLocalityNumber newValue = new DependentLocality.DependentLocalityNumber();
        this.setDependentLocalityNumber(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostBox} and set it to postBox.
     * 
     * This method is a short version for:
     * <code>
     * PostBox postBox = new PostBox();
     * this.setPostBox(postBox); </code>
     *
     * @param postBoxNumber     required parameter
     * @return the post box
     */
    public PostBox createAndSetPostBox(final PostBox.PostBoxNumber postBoxNumber) {
        PostBox newValue = new PostBox(postBoxNumber);
        this.setPostBox(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link LargeMailUser} and set it to largeMailUser.
     * 
     * This method is a short version for:
     * <code>
     * LargeMailUser largeMailUser = new LargeMailUser();
     * this.setLargeMailUser(largeMailUser); </code>
     *
     * @return the large mail user
     */
    public LargeMailUser createAndSetLargeMailUser() {
        LargeMailUser newValue = new LargeMailUser();
        this.setLargeMailUser(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostOffice} and set it to postOffice.
     * 
     * This method is a short version for:
     * <code>
     * PostOffice postOffice = new PostOffice();
     * this.setPostOffice(postOffice); </code>
     *
     * @return the post office
     */
    public PostOffice createAndSetPostOffice() {
        PostOffice newValue = new PostOffice();
        this.setPostOffice(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link PostalRoute} and set it to postalRoute.
     * 
     * This method is a short version for:
     * <code>
     * PostalRoute postalRoute = new PostalRoute();
     * this.setPostalRoute(postalRoute); </code>
     *
     * @param postalRouteName     required parameter
     * @param postalRouteNumber     required parameter
     * @return the postal route
     */
    public PostalRoute createAndSetPostalRoute(final List<PostalRoute.PostalRouteName> postalRouteName, final PostalRoute.PostalRouteNumber postalRouteNumber) {
        PostalRoute newValue = new PostalRoute(postalRouteName, postalRouteNumber);
        this.setPostalRoute(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link Thoroughfare} and set it to thoroughfare.
     * 
     * This method is a short version for:
     * <code>
     * Thoroughfare thoroughfare = new Thoroughfare();
     * this.setThoroughfare(thoroughfare); </code>
     *
     * @param dependentLocality     required parameter
     * @param premise     required parameter
     * @param firm     required parameter
     * @param postalCode     required parameter
     * @return the thoroughfare
     */
    public Thoroughfare createAndSetThoroughfare(final DependentLocality dependentLocality, final Premise premise, final Firm firm, final PostalCode postalCode) {
        Thoroughfare newValue = new Thoroughfare(dependentLocality, premise, firm, postalCode);
        this.setThoroughfare(newValue);
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
    public DependentLocality addToAddressLine(final AddressLine addressLine) {
        this.getAddressLine().add(addressLine);
        return this;
    }

    /**
     * Sets the value of the dependentLocalityName property Objects of the following type(s) are allowed in the list List<DependentLocalityName>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withDependentLocalityName} instead.
     *
     * @param dependentLocalityName the new dependent locality name
     */
    public void setDependentLocalityName(final List<DependentLocality.DependentLocalityName> dependentLocalityName) {
        this.dependentLocalityName = dependentLocalityName;
    }

    /**
     * add a value to the dependentLocalityName property collection.
     *
     * @param dependentLocalityName     Objects of the following type are allowed in the list: {@link DependentLocality.DependentLocalityName}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public DependentLocality addToDependentLocalityName(final DependentLocality.DependentLocalityName dependentLocalityName) {
        this.getDependentLocalityName().add(dependentLocalityName);
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
    public DependentLocality addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param addressLine     required parameter
     * @return the dependent locality
     * @see #setAddressLine(List<AddressLine>)
     */
    public DependentLocality withAddressLine(final List<AddressLine> addressLine) {
        this.setAddressLine(addressLine);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentLocalityName     required parameter
     * @return the dependent locality
     * @see #setDependentLocalityName(List<DependentLocalityName>)
     */
    public DependentLocality withDependentLocalityName(final List<DependentLocality.DependentLocalityName> dependentLocalityName) {
        this.setDependentLocalityName(dependentLocalityName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentLocalityNumber     required parameter
     * @return the dependent locality
     * @see #setDependentLocalityNumber(DependentLocalityNumber)
     */
    public DependentLocality withDependentLocalityNumber(final DependentLocality.DependentLocalityNumber dependentLocalityNumber) {
        this.setDependentLocalityNumber(dependentLocalityNumber);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfare     required parameter
     * @return the dependent locality
     * @see #setThoroughfare(Thoroughfare)
     */
    public DependentLocality withThoroughfare(final Thoroughfare thoroughfare) {
        this.setThoroughfare(thoroughfare);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param premise     required parameter
     * @return the dependent locality
     * @see #setPremise(Premise)
     */
    public DependentLocality withPremise(final Premise premise) {
        this.setPremise(premise);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param dependentLocality     required parameter
     * @return the dependent locality
     * @see #setDependentLocality(DependentLocality)
     */
    public DependentLocality withDependentLocality(final DependentLocality dependentLocality) {
        this.setDependentLocality(dependentLocality);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postalCode     required parameter
     * @return the dependent locality
     * @see #setPostalCode(PostalCode)
     */
    public DependentLocality withPostalCode(final PostalCode postalCode) {
        this.setPostalCode(postalCode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the dependent locality
     * @see #setAny(List<Object>)
     */
    public DependentLocality withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the dependent locality
     * @see #setUnderscore(String)
     */
    public DependentLocality withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param usage     required parameter
     * @return the dependent locality
     * @see #setUsage(String)
     */
    public DependentLocality withUsage(final String usage) {
        this.setUsage(usage);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param connector     required parameter
     * @return the dependent locality
     * @see #setConnector(String)
     */
    public DependentLocality withConnector(final String connector) {
        this.setConnector(connector);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param indicator     required parameter
     * @return the dependent locality
     * @see #setIndicator(String)
     */
    public DependentLocality withIndicator(final String indicator) {
        this.setIndicator(indicator);
        return this;
    }

    @Override
    public DependentLocality clone() {
        DependentLocality copy;
        try {
            copy = ((DependentLocality) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
        for (AddressLine iter: addressLine) {
            copy.addressLine.add(iter.clone());
        }
        copy.dependentLocalityName = new ArrayList<DependentLocality.DependentLocalityName>((getDependentLocalityName().size()));
        for (DependentLocality.DependentLocalityName iter: dependentLocalityName) {
            copy.dependentLocalityName.add(iter.clone());
        }
        copy.dependentLocalityNumber = ((dependentLocalityNumber == null)?null:((DependentLocality.DependentLocalityNumber) dependentLocalityNumber.clone()));
        copy.postBox = ((postBox == null)?null:((PostBox) postBox.clone()));
        copy.largeMailUser = ((largeMailUser == null)?null:((LargeMailUser) largeMailUser.clone()));
        copy.postOffice = ((postOffice == null)?null:((PostOffice) postOffice.clone()));
        copy.postalRoute = ((postalRoute == null)?null:((PostalRoute) postalRoute.clone()));
        copy.thoroughfare = ((thoroughfare == null)?null:((Thoroughfare) thoroughfare.clone()));
        copy.premise = ((premise == null)?null:((Premise) premise.clone()));
        copy.dependentLocality = ((dependentLocality == null)?null:((DependentLocality) dependentLocality.clone()));
        copy.postalCode = ((postalCode == null)?null:((PostalCode) postalCode.clone()));
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }


    /**
     * The Class DependentLocalityName.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "DependentLocalityName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class DependentLocalityName implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
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
         * Instantiates a new dependent locality name.
         */
        public DependentLocalityName() {
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
            if ((obj instanceof DependentLocality.DependentLocalityName) == false) {
                return false;
            }
            DependentLocality.DependentLocalityName other = ((DependentLocality.DependentLocalityName) obj);
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
         * @return the dependent locality. dependent locality name
         * @see #setContent(String)
         */
        public DependentLocality.DependentLocalityName withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the dependent locality. dependent locality name
         * @see #setUnderscore(String)
         */
        public DependentLocality.DependentLocalityName withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the dependent locality. dependent locality name
         * @see #setCode(String)
         */
        public DependentLocality.DependentLocalityName withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public DependentLocality.DependentLocalityName clone() {
            DependentLocality.DependentLocalityName copy;
            try {
                copy = ((DependentLocality.DependentLocalityName) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class DependentLocalityNumber.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "DependentLocalityNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class DependentLocalityNumber implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The name number occurrence. */
        @XmlAttribute(name = "NameNumberOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String nameNumberOccurrence;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new dependent locality number.
         */
        public DependentLocalityNumber() {
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
         * Gets the name number occurrence.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getNameNumberOccurrence() {
            return nameNumberOccurrence;
        }

        /**
         * Sets the name number occurrence.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setNameNumberOccurrence(String value) {
            this.nameNumberOccurrence = value;
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
            result = ((prime*result)+((nameNumberOccurrence == null)? 0 :nameNumberOccurrence.hashCode()));
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
            if ((obj instanceof DependentLocality.DependentLocalityNumber) == false) {
                return false;
            }
            DependentLocality.DependentLocalityNumber other = ((DependentLocality.DependentLocalityNumber) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
                    return false;
                }
            }
            if (nameNumberOccurrence == null) {
                if (other.nameNumberOccurrence!= null) {
                    return false;
                }
            } else {
                if (nameNumberOccurrence.equals(other.nameNumberOccurrence) == false) {
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
         * @return the dependent locality. dependent locality number
         * @see #setContent(String)
         */
        public DependentLocality.DependentLocalityNumber withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param nameNumberOccurrence     required parameter
         * @return the dependent locality. dependent locality number
         * @see #setNameNumberOccurrence(String)
         */
        public DependentLocality.DependentLocalityNumber withNameNumberOccurrence(final String nameNumberOccurrence) {
            this.setNameNumberOccurrence(nameNumberOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the dependent locality. dependent locality number
         * @see #setCode(String)
         */
        public DependentLocality.DependentLocalityNumber withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public DependentLocality.DependentLocalityNumber clone() {
            DependentLocality.DependentLocalityNumber copy;
            try {
                copy = ((DependentLocality.DependentLocalityNumber) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }

}
