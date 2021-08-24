/*******************************************************************************************************
 *
 * SubPremise.java, in gama.ext.libs, is part of the source code of the
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
 * The Class SubPremise.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubPremiseType", propOrder = {
    "addressLine",
    "subPremiseName",
    "subPremiseLocation",
    "subPremiseNumber",
    "subPremiseNumberPrefix",
    "subPremiseNumberSuffix",
    "buildingName",
    "firm",
    "mailStop",
    "postalCode",
    "subPremise",
    "any"
})
@XmlRootElement(name = "SubPremise", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class SubPremise implements Cloneable
{

    /** The address line. */
    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    
    /** The sub premise name. */
    @XmlElement(name = "SubPremiseName")
    protected List<SubPremise.SubPremiseName> subPremiseName;
    
    /** The sub premise location. */
    @XmlElement(name = "SubPremiseLocation")
    protected SubPremise.SubPremiseLocation subPremiseLocation;
    
    /** The sub premise number. */
    @XmlElement(name = "SubPremiseNumber")
    protected List<SubPremise.SubPremiseNumber> subPremiseNumber;
    
    /** The sub premise number prefix. */
    @XmlElement(name = "SubPremiseNumberPrefix")
    protected List<SubPremise.SubPremiseNumberPrefix> subPremiseNumberPrefix;
    
    /** The sub premise number suffix. */
    @XmlElement(name = "SubPremiseNumberSuffix")
    protected List<SubPremise.SubPremiseNumberSuffix> subPremiseNumberSuffix;
    
    /** The building name. */
    @XmlElement(name = "BuildingName")
    protected List<BuildingName> buildingName;
    
    /** The firm. */
    @XmlElement(name = "Firm")
    protected Firm firm;
    
    /** The mail stop. */
    @XmlElement(name = "MailStop")
    protected MailStop mailStop;
    
    /** The postal code. */
    @XmlElement(name = "PostalCode")
    protected PostalCode postalCode;
    
    /** The sub premise. */
    @XmlElement(name = "SubPremise")
    protected SubPremise subPremise;
    
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
     * Value constructor with only mandatory fields.
     *
     * @param subPremiseLocation     required parameter
     */
    public SubPremise(final SubPremise.SubPremiseLocation subPremiseLocation) {
        super();
        this.subPremiseLocation = subPremiseLocation;
    }

    /**
     * Default no-arg constructor is private. Use overloaded constructor instead! (Temporary solution, till a better and more suitable ObjectFactory is created.) 
     * 
     */
    @Deprecated
    private SubPremise() {
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
     * Gets the sub premise name.
     *
     * @return the sub premise name
     */
    public List<SubPremise.SubPremiseName> getSubPremiseName() {
        if (subPremiseName == null) {
            subPremiseName = new ArrayList<SubPremise.SubPremiseName>();
        }
        return this.subPremiseName;
    }

    /**
     * Gets the sub premise location.
     *
     * @return     possible object is
     *     {@link SubPremise.SubPremiseLocation}
     */
    public SubPremise.SubPremiseLocation getSubPremiseLocation() {
        return subPremiseLocation;
    }

    /**
     * Sets the sub premise location.
     *
     * @param value     allowed object is
     *     {@link SubPremise.SubPremiseLocation}
     */
    public void setSubPremiseLocation(SubPremise.SubPremiseLocation value) {
        this.subPremiseLocation = value;
    }

    /**
     * Gets the sub premise number.
     *
     * @return the sub premise number
     */
    public List<SubPremise.SubPremiseNumber> getSubPremiseNumber() {
        if (subPremiseNumber == null) {
            subPremiseNumber = new ArrayList<SubPremise.SubPremiseNumber>();
        }
        return this.subPremiseNumber;
    }

    /**
     * Gets the sub premise number prefix.
     *
     * @return the sub premise number prefix
     */
    public List<SubPremise.SubPremiseNumberPrefix> getSubPremiseNumberPrefix() {
        if (subPremiseNumberPrefix == null) {
            subPremiseNumberPrefix = new ArrayList<SubPremise.SubPremiseNumberPrefix>();
        }
        return this.subPremiseNumberPrefix;
    }

    /**
     * Gets the sub premise number suffix.
     *
     * @return the sub premise number suffix
     */
    public List<SubPremise.SubPremiseNumberSuffix> getSubPremiseNumberSuffix() {
        if (subPremiseNumberSuffix == null) {
            subPremiseNumberSuffix = new ArrayList<SubPremise.SubPremiseNumberSuffix>();
        }
        return this.subPremiseNumberSuffix;
    }

    /**
     * Gets the building name.
     *
     * @return the building name
     */
    public List<BuildingName> getBuildingName() {
        if (buildingName == null) {
            buildingName = new ArrayList<BuildingName>();
        }
        return this.buildingName;
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
     * Gets the mail stop.
     *
     * @return     possible object is
     *     {@link MailStop}
     */
    public MailStop getMailStop() {
        return mailStop;
    }

    /**
     * Sets the mail stop.
     *
     * @param value     allowed object is
     *     {@link MailStop}
     */
    public void setMailStop(MailStop value) {
        this.mailStop = value;
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
     * Gets the sub premise.
     *
     * @return     possible object is
     *     {@link SubPremise}
     */
    public SubPremise getSubPremise() {
        return subPremise;
    }

    /**
     * Sets the sub premise.
     *
     * @param value     allowed object is
     *     {@link SubPremise}
     */
    public void setSubPremise(SubPremise value) {
        this.subPremise = value;
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
        result = ((prime*result)+((subPremiseName == null)? 0 :subPremiseName.hashCode()));
        result = ((prime*result)+((subPremiseLocation == null)? 0 :subPremiseLocation.hashCode()));
        result = ((prime*result)+((subPremiseNumber == null)? 0 :subPremiseNumber.hashCode()));
        result = ((prime*result)+((subPremiseNumberPrefix == null)? 0 :subPremiseNumberPrefix.hashCode()));
        result = ((prime*result)+((subPremiseNumberSuffix == null)? 0 :subPremiseNumberSuffix.hashCode()));
        result = ((prime*result)+((buildingName == null)? 0 :buildingName.hashCode()));
        result = ((prime*result)+((firm == null)? 0 :firm.hashCode()));
        result = ((prime*result)+((mailStop == null)? 0 :mailStop.hashCode()));
        result = ((prime*result)+((postalCode == null)? 0 :postalCode.hashCode()));
        result = ((prime*result)+((subPremise == null)? 0 :subPremise.hashCode()));
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
        if ((obj instanceof SubPremise) == false) {
            return false;
        }
        SubPremise other = ((SubPremise) obj);
        if (addressLine == null) {
            if (other.addressLine!= null) {
                return false;
            }
        } else {
            if (addressLine.equals(other.addressLine) == false) {
                return false;
            }
        }
        if (subPremiseName == null) {
            if (other.subPremiseName!= null) {
                return false;
            }
        } else {
            if (subPremiseName.equals(other.subPremiseName) == false) {
                return false;
            }
        }
        if (subPremiseLocation == null) {
            if (other.subPremiseLocation!= null) {
                return false;
            }
        } else {
            if (subPremiseLocation.equals(other.subPremiseLocation) == false) {
                return false;
            }
        }
        if (subPremiseNumber == null) {
            if (other.subPremiseNumber!= null) {
                return false;
            }
        } else {
            if (subPremiseNumber.equals(other.subPremiseNumber) == false) {
                return false;
            }
        }
        if (subPremiseNumberPrefix == null) {
            if (other.subPremiseNumberPrefix!= null) {
                return false;
            }
        } else {
            if (subPremiseNumberPrefix.equals(other.subPremiseNumberPrefix) == false) {
                return false;
            }
        }
        if (subPremiseNumberSuffix == null) {
            if (other.subPremiseNumberSuffix!= null) {
                return false;
            }
        } else {
            if (subPremiseNumberSuffix.equals(other.subPremiseNumberSuffix) == false) {
                return false;
            }
        }
        if (buildingName == null) {
            if (other.buildingName!= null) {
                return false;
            }
        } else {
            if (buildingName.equals(other.buildingName) == false) {
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
        if (mailStop == null) {
            if (other.mailStop!= null) {
                return false;
            }
        } else {
            if (mailStop.equals(other.mailStop) == false) {
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
        if (subPremise == null) {
            if (other.subPremise!= null) {
                return false;
            }
        } else {
            if (subPremise.equals(other.subPremise) == false) {
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
     * Creates a new instance of {@link SubPremise.SubPremiseName} and adds it to subPremiseName.
     * This method is a short version for:
     * <code>
     * SubPremiseName subPremiseName = new SubPremiseName();
     * this.getSubPremiseName().add(subPremiseName); </code>
     *
     * @return the sub premise. sub premise name
     */
    public SubPremise.SubPremiseName createAndAddSubPremiseName() {
        SubPremise.SubPremiseName newValue = new SubPremise.SubPremiseName();
        this.getSubPremiseName().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link SubPremise.SubPremiseLocation} and set it to subPremiseLocation.
     * 
     * This method is a short version for:
     * <code>
     * SubPremiseLocation subPremiseLocation = new SubPremiseLocation();
     * this.setSubPremiseLocation(subPremiseLocation); </code>
     *
     * @return the sub premise. sub premise location
     */
    public SubPremise.SubPremiseLocation createAndSetSubPremiseLocation() {
        SubPremise.SubPremiseLocation newValue = new SubPremise.SubPremiseLocation();
        this.setSubPremiseLocation(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link SubPremise.SubPremiseNumber} and adds it to subPremiseNumber.
     * This method is a short version for:
     * <code>
     * SubPremiseNumber subPremiseNumber = new SubPremiseNumber();
     * this.getSubPremiseNumber().add(subPremiseNumber); </code>
     *
     * @return the sub premise. sub premise number
     */
    public SubPremise.SubPremiseNumber createAndAddSubPremiseNumber() {
        SubPremise.SubPremiseNumber newValue = new SubPremise.SubPremiseNumber();
        this.getSubPremiseNumber().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link SubPremise.SubPremiseNumberPrefix} and adds it to subPremiseNumberPrefix.
     * This method is a short version for:
     * <code>
     * SubPremiseNumberPrefix subPremiseNumberPrefix = new SubPremiseNumberPrefix();
     * this.getSubPremiseNumberPrefix().add(subPremiseNumberPrefix); </code>
     *
     * @return the sub premise. sub premise number prefix
     */
    public SubPremise.SubPremiseNumberPrefix createAndAddSubPremiseNumberPrefix() {
        SubPremise.SubPremiseNumberPrefix newValue = new SubPremise.SubPremiseNumberPrefix();
        this.getSubPremiseNumberPrefix().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link SubPremise.SubPremiseNumberSuffix} and adds it to subPremiseNumberSuffix.
     * This method is a short version for:
     * <code>
     * SubPremiseNumberSuffix subPremiseNumberSuffix = new SubPremiseNumberSuffix();
     * this.getSubPremiseNumberSuffix().add(subPremiseNumberSuffix); </code>
     *
     * @return the sub premise. sub premise number suffix
     */
    public SubPremise.SubPremiseNumberSuffix createAndAddSubPremiseNumberSuffix() {
        SubPremise.SubPremiseNumberSuffix newValue = new SubPremise.SubPremiseNumberSuffix();
        this.getSubPremiseNumberSuffix().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link BuildingName} and adds it to buildingName.
     * This method is a short version for:
     * <code>
     * BuildingName buildingName = new BuildingName();
     * this.getBuildingName().add(buildingName); </code>
     *
     * @return the building name
     */
    public BuildingName createAndAddBuildingName() {
        BuildingName newValue = new BuildingName();
        this.getBuildingName().add(newValue);
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
     * Creates a new instance of {@link MailStop} and set it to mailStop.
     * 
     * This method is a short version for:
     * <code>
     * MailStop mailStop = new MailStop();
     * this.setMailStop(mailStop); </code>
     *
     * @return the mail stop
     */
    public MailStop createAndSetMailStop() {
        MailStop newValue = new MailStop();
        this.setMailStop(newValue);
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
     * Creates a new instance of {@link SubPremise} and set it to subPremise.
     * 
     * This method is a short version for:
     * <code>
     * SubPremise subPremise = new SubPremise();
     * this.setSubPremise(subPremise); </code>
     *
     * @param subPremiseLocation     required parameter
     * @return the sub premise
     */
    public SubPremise createAndSetSubPremise(final SubPremise.SubPremiseLocation subPremiseLocation) {
        SubPremise newValue = new SubPremise(subPremiseLocation);
        this.setSubPremise(newValue);
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
    public SubPremise addToAddressLine(final AddressLine addressLine) {
        this.getAddressLine().add(addressLine);
        return this;
    }

    /**
     * Sets the value of the subPremiseName property Objects of the following type(s) are allowed in the list List<SubPremiseName>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubPremiseName} instead.
     *
     * @param subPremiseName the new sub premise name
     */
    public void setSubPremiseName(final List<SubPremise.SubPremiseName> subPremiseName) {
        this.subPremiseName = subPremiseName;
    }

    /**
     * add a value to the subPremiseName property collection.
     *
     * @param subPremiseName     Objects of the following type are allowed in the list: {@link SubPremise.SubPremiseName}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubPremise addToSubPremiseName(final SubPremise.SubPremiseName subPremiseName) {
        this.getSubPremiseName().add(subPremiseName);
        return this;
    }

    /**
     * Sets the value of the subPremiseNumber property Objects of the following type(s) are allowed in the list List<SubPremiseNumber>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubPremiseNumber} instead.
     *
     * @param subPremiseNumber the new sub premise number
     */
    public void setSubPremiseNumber(final List<SubPremise.SubPremiseNumber> subPremiseNumber) {
        this.subPremiseNumber = subPremiseNumber;
    }

    /**
     * add a value to the subPremiseNumber property collection.
     *
     * @param subPremiseNumber     Objects of the following type are allowed in the list: {@link SubPremise.SubPremiseNumber}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubPremise addToSubPremiseNumber(final SubPremise.SubPremiseNumber subPremiseNumber) {
        this.getSubPremiseNumber().add(subPremiseNumber);
        return this;
    }

    /**
     * Sets the value of the subPremiseNumberPrefix property Objects of the following type(s) are allowed in the list List<SubPremiseNumberPrefix>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubPremiseNumberPrefix} instead.
     *
     * @param subPremiseNumberPrefix the new sub premise number prefix
     */
    public void setSubPremiseNumberPrefix(final List<SubPremise.SubPremiseNumberPrefix> subPremiseNumberPrefix) {
        this.subPremiseNumberPrefix = subPremiseNumberPrefix;
    }

    /**
     * add a value to the subPremiseNumberPrefix property collection.
     *
     * @param subPremiseNumberPrefix     Objects of the following type are allowed in the list: {@link SubPremise.SubPremiseNumberPrefix}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubPremise addToSubPremiseNumberPrefix(final SubPremise.SubPremiseNumberPrefix subPremiseNumberPrefix) {
        this.getSubPremiseNumberPrefix().add(subPremiseNumberPrefix);
        return this;
    }

    /**
     * Sets the value of the subPremiseNumberSuffix property Objects of the following type(s) are allowed in the list List<SubPremiseNumberSuffix>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withSubPremiseNumberSuffix} instead.
     *
     * @param subPremiseNumberSuffix the new sub premise number suffix
     */
    public void setSubPremiseNumberSuffix(final List<SubPremise.SubPremiseNumberSuffix> subPremiseNumberSuffix) {
        this.subPremiseNumberSuffix = subPremiseNumberSuffix;
    }

    /**
     * add a value to the subPremiseNumberSuffix property collection.
     *
     * @param subPremiseNumberSuffix     Objects of the following type are allowed in the list: {@link SubPremise.SubPremiseNumberSuffix}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubPremise addToSubPremiseNumberSuffix(final SubPremise.SubPremiseNumberSuffix subPremiseNumberSuffix) {
        this.getSubPremiseNumberSuffix().add(subPremiseNumberSuffix);
        return this;
    }

    /**
     * Sets the value of the buildingName property Objects of the following type(s) are allowed in the list List<BuildingName>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withBuildingName} instead.
     *
     * @param buildingName the new building name
     */
    public void setBuildingName(final List<BuildingName> buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * add a value to the buildingName property collection.
     *
     * @param buildingName     Objects of the following type are allowed in the list: {@link BuildingName}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public SubPremise addToBuildingName(final BuildingName buildingName) {
        this.getBuildingName().add(buildingName);
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
    public SubPremise addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param addressLine     required parameter
     * @return the sub premise
     * @see #setAddressLine(List<AddressLine>)
     */
    public SubPremise withAddressLine(final List<AddressLine> addressLine) {
        this.setAddressLine(addressLine);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subPremiseName     required parameter
     * @return the sub premise
     * @see #setSubPremiseName(List<SubPremiseName>)
     */
    public SubPremise withSubPremiseName(final List<SubPremise.SubPremiseName> subPremiseName) {
        this.setSubPremiseName(subPremiseName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subPremiseNumber     required parameter
     * @return the sub premise
     * @see #setSubPremiseNumber(List<SubPremiseNumber>)
     */
    public SubPremise withSubPremiseNumber(final List<SubPremise.SubPremiseNumber> subPremiseNumber) {
        this.setSubPremiseNumber(subPremiseNumber);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subPremiseNumberPrefix     required parameter
     * @return the sub premise
     * @see #setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix>)
     */
    public SubPremise withSubPremiseNumberPrefix(final List<SubPremise.SubPremiseNumberPrefix> subPremiseNumberPrefix) {
        this.setSubPremiseNumberPrefix(subPremiseNumberPrefix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subPremiseNumberSuffix     required parameter
     * @return the sub premise
     * @see #setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix>)
     */
    public SubPremise withSubPremiseNumberSuffix(final List<SubPremise.SubPremiseNumberSuffix> subPremiseNumberSuffix) {
        this.setSubPremiseNumberSuffix(subPremiseNumberSuffix);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param buildingName     required parameter
     * @return the sub premise
     * @see #setBuildingName(List<BuildingName>)
     */
    public SubPremise withBuildingName(final List<BuildingName> buildingName) {
        this.setBuildingName(buildingName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param firm     required parameter
     * @return the sub premise
     * @see #setFirm(Firm)
     */
    public SubPremise withFirm(final Firm firm) {
        this.setFirm(firm);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param mailStop     required parameter
     * @return the sub premise
     * @see #setMailStop(MailStop)
     */
    public SubPremise withMailStop(final MailStop mailStop) {
        this.setMailStop(mailStop);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postalCode     required parameter
     * @return the sub premise
     * @see #setPostalCode(PostalCode)
     */
    public SubPremise withPostalCode(final PostalCode postalCode) {
        this.setPostalCode(postalCode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param subPremise     required parameter
     * @return the sub premise
     * @see #setSubPremise(SubPremise)
     */
    public SubPremise withSubPremise(final SubPremise subPremise) {
        this.setSubPremise(subPremise);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the sub premise
     * @see #setAny(List<Object>)
     */
    public SubPremise withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the sub premise
     * @see #setUnderscore(String)
     */
    public SubPremise withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    @Override
    public SubPremise clone() {
        SubPremise copy;
        try {
            copy = ((SubPremise) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
        for (AddressLine iter: addressLine) {
            copy.addressLine.add(iter.clone());
        }
        copy.subPremiseName = new ArrayList<SubPremise.SubPremiseName>((getSubPremiseName().size()));
        for (SubPremise.SubPremiseName iter: subPremiseName) {
            copy.subPremiseName.add(iter.clone());
        }
        copy.subPremiseLocation = ((subPremiseLocation == null)?null:((SubPremise.SubPremiseLocation) subPremiseLocation.clone()));
        copy.subPremiseNumber = new ArrayList<SubPremise.SubPremiseNumber>((getSubPremiseNumber().size()));
        for (SubPremise.SubPremiseNumber iter: subPremiseNumber) {
            copy.subPremiseNumber.add(iter.clone());
        }
        copy.subPremiseNumberPrefix = new ArrayList<SubPremise.SubPremiseNumberPrefix>((getSubPremiseNumberPrefix().size()));
        for (SubPremise.SubPremiseNumberPrefix iter: subPremiseNumberPrefix) {
            copy.subPremiseNumberPrefix.add(iter.clone());
        }
        copy.subPremiseNumberSuffix = new ArrayList<SubPremise.SubPremiseNumberSuffix>((getSubPremiseNumberSuffix().size()));
        for (SubPremise.SubPremiseNumberSuffix iter: subPremiseNumberSuffix) {
            copy.subPremiseNumberSuffix.add(iter.clone());
        }
        copy.buildingName = new ArrayList<BuildingName>((getBuildingName().size()));
        for (BuildingName iter: buildingName) {
            copy.buildingName.add(iter.clone());
        }
        copy.firm = ((firm == null)?null:((Firm) firm.clone()));
        copy.mailStop = ((mailStop == null)?null:((MailStop) mailStop.clone()));
        copy.postalCode = ((postalCode == null)?null:((PostalCode) postalCode.clone()));
        copy.subPremise = ((subPremise == null)?null:((SubPremise) subPremise.clone()));
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }


    /**
     * The Class SubPremiseLocation.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "SubPremiseLocation", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class SubPremiseLocation implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;

        /**
         * Instantiates a new sub premise location.
         */
        public SubPremiseLocation() {
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
            if ((obj instanceof SubPremise.SubPremiseLocation) == false) {
                return false;
            }
            SubPremise.SubPremiseLocation other = ((SubPremise.SubPremiseLocation) obj);
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
         * @return the sub premise. sub premise location
         * @see #setContent(String)
         */
        public SubPremise.SubPremiseLocation withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the sub premise. sub premise location
         * @see #setCode(String)
         */
        public SubPremise.SubPremiseLocation withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public SubPremise.SubPremiseLocation clone() {
            SubPremise.SubPremiseLocation copy;
            try {
                copy = ((SubPremise.SubPremiseLocation) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class SubPremiseName.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "SubPremiseName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class SubPremiseName implements Cloneable
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
         * Instantiates a new sub premise name.
         */
        public SubPremiseName() {
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
            if ((obj instanceof SubPremise.SubPremiseName) == false) {
                return false;
            }
            SubPremise.SubPremiseName other = ((SubPremise.SubPremiseName) obj);
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
         * @return the sub premise. sub premise name
         * @see #setContent(String)
         */
        public SubPremise.SubPremiseName withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the sub premise. sub premise name
         * @see #setUnderscore(String)
         */
        public SubPremise.SubPremiseName withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param typeOccurrence     required parameter
         * @return the sub premise. sub premise name
         * @see #setTypeOccurrence(String)
         */
        public SubPremise.SubPremiseName withTypeOccurrence(final String typeOccurrence) {
            this.setTypeOccurrence(typeOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the sub premise. sub premise name
         * @see #setCode(String)
         */
        public SubPremise.SubPremiseName withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public SubPremise.SubPremiseName clone() {
            SubPremise.SubPremiseName copy;
            try {
                copy = ((SubPremise.SubPremiseName) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class SubPremiseNumber.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "SubPremiseNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class SubPremiseNumber implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
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
        
        /** The premise number separator. */
        @XmlAttribute(name = "PremiseNumberSeparator")
        @XmlSchemaType(name = "anySimpleType")
        protected String premiseNumberSeparator;
        
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
         * Instantiates a new sub premise number.
         */
        public SubPremiseNumber() {
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
         * Gets the premise number separator.
         *
         * @return     possible object is
         *     {@link String}
         */
        public String getPremiseNumberSeparator() {
            return premiseNumberSeparator;
        }

        /**
         * Sets the premise number separator.
         *
         * @param value     allowed object is
         *     {@link String}
         */
        public void setPremiseNumberSeparator(String value) {
            this.premiseNumberSeparator = value;
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
            result = ((prime*result)+((indicator == null)? 0 :indicator.hashCode()));
            result = ((prime*result)+((indicatorOccurrence == null)? 0 :indicatorOccurrence.hashCode()));
            result = ((prime*result)+((numberTypeOccurrence == null)? 0 :numberTypeOccurrence.hashCode()));
            result = ((prime*result)+((premiseNumberSeparator == null)? 0 :premiseNumberSeparator.hashCode()));
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
            if ((obj instanceof SubPremise.SubPremiseNumber) == false) {
                return false;
            }
            SubPremise.SubPremiseNumber other = ((SubPremise.SubPremiseNumber) obj);
            if (content == null) {
                if (other.content!= null) {
                    return false;
                }
            } else {
                if (content.equals(other.content) == false) {
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
            if (premiseNumberSeparator == null) {
                if (other.premiseNumberSeparator!= null) {
                    return false;
                }
            } else {
                if (premiseNumberSeparator.equals(other.premiseNumberSeparator) == false) {
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
         * @return the sub premise. sub premise number
         * @see #setContent(String)
         */
        public SubPremise.SubPremiseNumber withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param indicator     required parameter
         * @return the sub premise. sub premise number
         * @see #setIndicator(String)
         */
        public SubPremise.SubPremiseNumber withIndicator(final String indicator) {
            this.setIndicator(indicator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param indicatorOccurrence     required parameter
         * @return the sub premise. sub premise number
         * @see #setIndicatorOccurrence(String)
         */
        public SubPremise.SubPremiseNumber withIndicatorOccurrence(final String indicatorOccurrence) {
            this.setIndicatorOccurrence(indicatorOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberTypeOccurrence     required parameter
         * @return the sub premise. sub premise number
         * @see #setNumberTypeOccurrence(String)
         */
        public SubPremise.SubPremiseNumber withNumberTypeOccurrence(final String numberTypeOccurrence) {
            this.setNumberTypeOccurrence(numberTypeOccurrence);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param premiseNumberSeparator     required parameter
         * @return the sub premise. sub premise number
         * @see #setPremiseNumberSeparator(String)
         */
        public SubPremise.SubPremiseNumber withPremiseNumberSeparator(final String premiseNumberSeparator) {
            this.setPremiseNumberSeparator(premiseNumberSeparator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the sub premise. sub premise number
         * @see #setUnderscore(String)
         */
        public SubPremise.SubPremiseNumber withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the sub premise. sub premise number
         * @see #setCode(String)
         */
        public SubPremise.SubPremiseNumber withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public SubPremise.SubPremiseNumber clone() {
            SubPremise.SubPremiseNumber copy;
            try {
                copy = ((SubPremise.SubPremiseNumber) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class SubPremiseNumberPrefix.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "SubPremiseNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class SubPremiseNumberPrefix implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
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
         * Instantiates a new sub premise number prefix.
         */
        public SubPremiseNumberPrefix() {
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
            if ((obj instanceof SubPremise.SubPremiseNumberPrefix) == false) {
                return false;
            }
            SubPremise.SubPremiseNumberPrefix other = ((SubPremise.SubPremiseNumberPrefix) obj);
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
         * @return the sub premise. sub premise number prefix
         * @see #setContent(String)
         */
        public SubPremise.SubPremiseNumberPrefix withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberPrefixSeparator     required parameter
         * @return the sub premise. sub premise number prefix
         * @see #setNumberPrefixSeparator(String)
         */
        public SubPremise.SubPremiseNumberPrefix withNumberPrefixSeparator(final String numberPrefixSeparator) {
            this.setNumberPrefixSeparator(numberPrefixSeparator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the sub premise. sub premise number prefix
         * @see #setUnderscore(String)
         */
        public SubPremise.SubPremiseNumberPrefix withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the sub premise. sub premise number prefix
         * @see #setCode(String)
         */
        public SubPremise.SubPremiseNumberPrefix withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public SubPremise.SubPremiseNumberPrefix clone() {
            SubPremise.SubPremiseNumberPrefix copy;
            try {
                copy = ((SubPremise.SubPremiseNumberPrefix) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class SubPremiseNumberSuffix.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "SubPremiseNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class SubPremiseNumberSuffix implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The number suffix separator. */
        @XmlAttribute(name = "NumberSuffixSeparator")
        @XmlSchemaType(name = "anySimpleType")
        protected String numberSuffixSeparator;
        
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
         * Instantiates a new sub premise number suffix.
         */
        public SubPremiseNumberSuffix() {
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
            result = ((prime*result)+((numberSuffixSeparator == null)? 0 :numberSuffixSeparator.hashCode()));
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
            if ((obj instanceof SubPremise.SubPremiseNumberSuffix) == false) {
                return false;
            }
            SubPremise.SubPremiseNumberSuffix other = ((SubPremise.SubPremiseNumberSuffix) obj);
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
         * @return the sub premise. sub premise number suffix
         * @see #setContent(String)
         */
        public SubPremise.SubPremiseNumberSuffix withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param numberSuffixSeparator     required parameter
         * @return the sub premise. sub premise number suffix
         * @see #setNumberSuffixSeparator(String)
         */
        public SubPremise.SubPremiseNumberSuffix withNumberSuffixSeparator(final String numberSuffixSeparator) {
            this.setNumberSuffixSeparator(numberSuffixSeparator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the sub premise. sub premise number suffix
         * @see #setUnderscore(String)
         */
        public SubPremise.SubPremiseNumberSuffix withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the sub premise. sub premise number suffix
         * @see #setCode(String)
         */
        public SubPremise.SubPremiseNumberSuffix withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public SubPremise.SubPremiseNumberSuffix clone() {
            SubPremise.SubPremiseNumberSuffix copy;
            try {
                copy = ((SubPremise.SubPremiseNumberSuffix) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }

}
