/*******************************************************************************************************
 *
 * LargeMailUser.java, in gama.ext.libs, is part of the source code of the
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
 * The Class LargeMailUser.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LargeMailUserType", propOrder = {
    "addressLine",
    "largeMailUserName",
    "largeMailUserIdentifier",
    "buildingName",
    "department",
    "postBox",
    "thoroughfare",
    "postalCode",
    "any"
})
@XmlRootElement(name = "LargeMailUser", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class LargeMailUser implements Cloneable
{

    /** The address line. */
    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    
    /** The large mail user name. */
    @XmlElement(name = "LargeMailUserName")
    protected List<LargeMailUser.LargeMailUserName> largeMailUserName;
    
    /** The large mail user identifier. */
    @XmlElement(name = "LargeMailUserIdentifier")
    protected LargeMailUser.LargeMailUserIdentifier largeMailUserIdentifier;
    
    /** The building name. */
    @XmlElement(name = "BuildingName")
    protected List<BuildingName> buildingName;
    
    /** The department. */
    @XmlElement(name = "Department")
    protected Department department;
    
    /** The post box. */
    @XmlElement(name = "PostBox")
    protected PostBox postBox;
    
    /** The thoroughfare. */
    @XmlElement(name = "Thoroughfare")
    protected Thoroughfare thoroughfare;
    
    /** The postal code. */
    @XmlElement(name = "PostalCode")
    protected PostalCode postalCode;
    
    /** The any. */
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    
    /** The underscore. */
    @XmlAttribute(name = "Type")
    protected String underscore;
    
    /** The other attributes. */
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Instantiates a new large mail user.
     */
    public LargeMailUser() {
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
     * Gets the large mail user name.
     *
     * @return the large mail user name
     */
    public List<LargeMailUser.LargeMailUserName> getLargeMailUserName() {
        if (largeMailUserName == null) {
            largeMailUserName = new ArrayList<LargeMailUser.LargeMailUserName>();
        }
        return this.largeMailUserName;
    }

    /**
     * Gets the large mail user identifier.
     *
     * @return     possible object is
     *     {@link LargeMailUser.LargeMailUserIdentifier}
     */
    public LargeMailUser.LargeMailUserIdentifier getLargeMailUserIdentifier() {
        return largeMailUserIdentifier;
    }

    /**
     * Sets the large mail user identifier.
     *
     * @param value     allowed object is
     *     {@link LargeMailUser.LargeMailUserIdentifier}
     */
    public void setLargeMailUserIdentifier(LargeMailUser.LargeMailUserIdentifier value) {
        this.largeMailUserIdentifier = value;
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
     * Gets the department.
     *
     * @return     possible object is
     *     {@link Department}
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param value     allowed object is
     *     {@link Department}
     */
    public void setDepartment(Department value) {
        this.department = value;
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
        result = ((prime*result)+((largeMailUserName == null)? 0 :largeMailUserName.hashCode()));
        result = ((prime*result)+((largeMailUserIdentifier == null)? 0 :largeMailUserIdentifier.hashCode()));
        result = ((prime*result)+((buildingName == null)? 0 :buildingName.hashCode()));
        result = ((prime*result)+((department == null)? 0 :department.hashCode()));
        result = ((prime*result)+((postBox == null)? 0 :postBox.hashCode()));
        result = ((prime*result)+((thoroughfare == null)? 0 :thoroughfare.hashCode()));
        result = ((prime*result)+((postalCode == null)? 0 :postalCode.hashCode()));
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
        if ((obj instanceof LargeMailUser) == false) {
            return false;
        }
        LargeMailUser other = ((LargeMailUser) obj);
        if (addressLine == null) {
            if (other.addressLine!= null) {
                return false;
            }
        } else {
            if (addressLine.equals(other.addressLine) == false) {
                return false;
            }
        }
        if (largeMailUserName == null) {
            if (other.largeMailUserName!= null) {
                return false;
            }
        } else {
            if (largeMailUserName.equals(other.largeMailUserName) == false) {
                return false;
            }
        }
        if (largeMailUserIdentifier == null) {
            if (other.largeMailUserIdentifier!= null) {
                return false;
            }
        } else {
            if (largeMailUserIdentifier.equals(other.largeMailUserIdentifier) == false) {
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
        if (department == null) {
            if (other.department!= null) {
                return false;
            }
        } else {
            if (department.equals(other.department) == false) {
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
        if (thoroughfare == null) {
            if (other.thoroughfare!= null) {
                return false;
            }
        } else {
            if (thoroughfare.equals(other.thoroughfare) == false) {
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
     * Creates a new instance of {@link LargeMailUser.LargeMailUserName} and adds it to largeMailUserName.
     * This method is a short version for:
     * <code>
     * LargeMailUserName largeMailUserName = new LargeMailUserName();
     * this.getLargeMailUserName().add(largeMailUserName); </code>
     *
     * @return the large mail user. large mail user name
     */
    public LargeMailUser.LargeMailUserName createAndAddLargeMailUserName() {
        LargeMailUser.LargeMailUserName newValue = new LargeMailUser.LargeMailUserName();
        this.getLargeMailUserName().add(newValue);
        return newValue;
    }

    /**
     * Creates a new instance of {@link LargeMailUser.LargeMailUserIdentifier} and set it to largeMailUserIdentifier.
     * 
     * This method is a short version for:
     * <code>
     * LargeMailUserIdentifier largeMailUserIdentifier = new LargeMailUserIdentifier();
     * this.setLargeMailUserIdentifier(largeMailUserIdentifier); </code>
     *
     * @return the large mail user. large mail user identifier
     */
    public LargeMailUser.LargeMailUserIdentifier createAndSetLargeMailUserIdentifier() {
        LargeMailUser.LargeMailUserIdentifier newValue = new LargeMailUser.LargeMailUserIdentifier();
        this.setLargeMailUserIdentifier(newValue);
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
     * Creates a new instance of {@link Department} and set it to department.
     * 
     * This method is a short version for:
     * <code>
     * Department department = new Department();
     * this.setDepartment(department); </code>
     *
     * @return the department
     */
    public Department createAndSetDepartment() {
        Department newValue = new Department();
        this.setDepartment(newValue);
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
    public LargeMailUser addToAddressLine(final AddressLine addressLine) {
        this.getAddressLine().add(addressLine);
        return this;
    }

    /**
     * Sets the value of the largeMailUserName property Objects of the following type(s) are allowed in the list List<LargeMailUserName>.
     * <p>Note:
     * <p>This method does not make use of the fluent pattern.If you would like to make it fluent, use {@link #withLargeMailUserName} instead.
     *
     * @param largeMailUserName the new large mail user name
     */
    public void setLargeMailUserName(final List<LargeMailUser.LargeMailUserName> largeMailUserName) {
        this.largeMailUserName = largeMailUserName;
    }

    /**
     * add a value to the largeMailUserName property collection.
     *
     * @param largeMailUserName     Objects of the following type are allowed in the list: {@link LargeMailUser.LargeMailUserName}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public LargeMailUser addToLargeMailUserName(final LargeMailUser.LargeMailUserName largeMailUserName) {
        this.getLargeMailUserName().add(largeMailUserName);
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
    public LargeMailUser addToBuildingName(final BuildingName buildingName) {
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
    public LargeMailUser addToAny(final Object any) {
        this.getAny().add(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param addressLine     required parameter
     * @return the large mail user
     * @see #setAddressLine(List<AddressLine>)
     */
    public LargeMailUser withAddressLine(final List<AddressLine> addressLine) {
        this.setAddressLine(addressLine);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param largeMailUserName     required parameter
     * @return the large mail user
     * @see #setLargeMailUserName(List<LargeMailUserName>)
     */
    public LargeMailUser withLargeMailUserName(final List<LargeMailUser.LargeMailUserName> largeMailUserName) {
        this.setLargeMailUserName(largeMailUserName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param largeMailUserIdentifier     required parameter
     * @return the large mail user
     * @see #setLargeMailUserIdentifier(LargeMailUserIdentifier)
     */
    public LargeMailUser withLargeMailUserIdentifier(final LargeMailUser.LargeMailUserIdentifier largeMailUserIdentifier) {
        this.setLargeMailUserIdentifier(largeMailUserIdentifier);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param buildingName     required parameter
     * @return the large mail user
     * @see #setBuildingName(List<BuildingName>)
     */
    public LargeMailUser withBuildingName(final List<BuildingName> buildingName) {
        this.setBuildingName(buildingName);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param department     required parameter
     * @return the large mail user
     * @see #setDepartment(Department)
     */
    public LargeMailUser withDepartment(final Department department) {
        this.setDepartment(department);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postBox     required parameter
     * @return the large mail user
     * @see #setPostBox(PostBox)
     */
    public LargeMailUser withPostBox(final PostBox postBox) {
        this.setPostBox(postBox);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param thoroughfare     required parameter
     * @return the large mail user
     * @see #setThoroughfare(Thoroughfare)
     */
    public LargeMailUser withThoroughfare(final Thoroughfare thoroughfare) {
        this.setThoroughfare(thoroughfare);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param postalCode     required parameter
     * @return the large mail user
     * @see #setPostalCode(PostalCode)
     */
    public LargeMailUser withPostalCode(final PostalCode postalCode) {
        this.setPostalCode(postalCode);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param any     required parameter
     * @return the large mail user
     * @see #setAny(List<Object>)
     */
    public LargeMailUser withAny(final List<Object> any) {
        this.setAny(any);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param underscore     required parameter
     * @return the large mail user
     * @see #setUnderscore(String)
     */
    public LargeMailUser withUnderscore(final String underscore) {
        this.setUnderscore(underscore);
        return this;
    }

    @Override
    public LargeMailUser clone() {
        LargeMailUser copy;
        try {
            copy = ((LargeMailUser) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.addressLine = new ArrayList<AddressLine>((getAddressLine().size()));
        for (AddressLine iter: addressLine) {
            copy.addressLine.add(iter.clone());
        }
        copy.largeMailUserName = new ArrayList<LargeMailUser.LargeMailUserName>((getLargeMailUserName().size()));
        for (LargeMailUser.LargeMailUserName iter: largeMailUserName) {
            copy.largeMailUserName.add(iter.clone());
        }
        copy.largeMailUserIdentifier = ((largeMailUserIdentifier == null)?null:((LargeMailUser.LargeMailUserIdentifier) largeMailUserIdentifier.clone()));
        copy.buildingName = new ArrayList<BuildingName>((getBuildingName().size()));
        for (BuildingName iter: buildingName) {
            copy.buildingName.add(iter.clone());
        }
        copy.department = ((department == null)?null:((Department) department.clone()));
        copy.postBox = ((postBox == null)?null:((PostBox) postBox.clone()));
        copy.thoroughfare = ((thoroughfare == null)?null:((Thoroughfare) thoroughfare.clone()));
        copy.postalCode = ((postalCode == null)?null:((PostalCode) postalCode.clone()));
        copy.any = new ArrayList<Object>((getAny().size()));
        for (Object iter: any) {
            copy.any.add(iter);
        }
        return copy;
    }


    /**
     * The Class LargeMailUserIdentifier.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "LargeMailUserIdentifier", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class LargeMailUserIdentifier implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The underscore. */
        @XmlAttribute(name = "Type")
        protected String underscore;
        
        /** The indicator. */
        @XmlAttribute(name = "Indicator")
        @XmlSchemaType(name = "anySimpleType")
        protected String indicator;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new large mail user identifier.
         */
        public LargeMailUserIdentifier() {
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
            result = ((prime*result)+((indicator == null)? 0 :indicator.hashCode()));
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
            if ((obj instanceof LargeMailUser.LargeMailUserIdentifier) == false) {
                return false;
            }
            LargeMailUser.LargeMailUserIdentifier other = ((LargeMailUser.LargeMailUserIdentifier) obj);
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
            if (indicator == null) {
                if (other.indicator!= null) {
                    return false;
                }
            } else {
                if (indicator.equals(other.indicator) == false) {
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
         * @return the large mail user. large mail user identifier
         * @see #setContent(String)
         */
        public LargeMailUser.LargeMailUserIdentifier withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the large mail user. large mail user identifier
         * @see #setUnderscore(String)
         */
        public LargeMailUser.LargeMailUserIdentifier withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param indicator     required parameter
         * @return the large mail user. large mail user identifier
         * @see #setIndicator(String)
         */
        public LargeMailUser.LargeMailUserIdentifier withIndicator(final String indicator) {
            this.setIndicator(indicator);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the large mail user. large mail user identifier
         * @see #setCode(String)
         */
        public LargeMailUser.LargeMailUserIdentifier withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public LargeMailUser.LargeMailUserIdentifier clone() {
            LargeMailUser.LargeMailUserIdentifier copy;
            try {
                copy = ((LargeMailUser.LargeMailUserIdentifier) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }


    /**
     * The Class LargeMailUserName.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    @XmlRootElement(name = "LargeMailUserName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    public static class LargeMailUserName implements Cloneable
    {

        /** The content. */
        @XmlValue
        protected String content;
        
        /** The underscore. */
        @XmlAttribute(name = "Type")
        protected String underscore;
        
        /** The code. */
        @XmlAttribute(name = "Code")
        protected String code;
        
        /** The other attributes. */
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Instantiates a new large mail user name.
         */
        public LargeMailUserName() {
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
            if ((obj instanceof LargeMailUser.LargeMailUserName) == false) {
                return false;
            }
            LargeMailUser.LargeMailUserName other = ((LargeMailUser.LargeMailUserName) obj);
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
         * @return the large mail user. large mail user name
         * @see #setContent(String)
         */
        public LargeMailUser.LargeMailUserName withContent(final String content) {
            this.setContent(content);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param underscore     required parameter
         * @return the large mail user. large mail user name
         * @see #setUnderscore(String)
         */
        public LargeMailUser.LargeMailUserName withUnderscore(final String underscore) {
            this.setUnderscore(underscore);
            return this;
        }

        /**
         * fluent setter.
         *
         * @param code     required parameter
         * @return the large mail user. large mail user name
         * @see #setCode(String)
         */
        public LargeMailUser.LargeMailUserName withCode(final String code) {
            this.setCode(code);
            return this;
        }

        @Override
        public LargeMailUser.LargeMailUserName clone() {
            LargeMailUser.LargeMailUserName copy;
            try {
                copy = ((LargeMailUser.LargeMailUserName) super.clone());
            } catch (CloneNotSupportedException _x) {
                throw new InternalError((_x.toString()));
            }
            return copy;
        }

    }

}
