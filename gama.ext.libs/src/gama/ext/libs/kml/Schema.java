/*******************************************************************************************************
 *
 * Schema.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import gama.ext.libs.kml.gx.SimpleArrayField;


/**
 * <Schema>
 * <p>
 * Specifies a custom KML schema that is used to add custom data to KML Features. The 
 * "id" attribute is required and must be unique within the KML file. <Schema> is always 
 * a child of <Document>. 
 * </p>
 * 
 * Syntax: 
 * <pre>&lt;Schema name="string" id="ID"&gt;
 *   &lt;SimpleField type="string" name="string"&gt;
 *     &lt;displayName&gt;...&lt;/displayName&gt;            &lt;!-- string --&gt;
 *   &lt;/SimpleField&gt;
 * &lt;/Schema&gt;</pre>
 * 
 * Extends: 
 * @see: This is a root element.
 * 
 * Contained By: 
 * @see: <Document>
 * 
 * See Also: 
 * <SchemaData>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaType", propOrder = {
    "simpleField",
    "schemaExtension"
})
@XmlRootElement(name = "Schema", namespace = "http://www.opengis.net/kml/2.2")
public class Schema implements Cloneable
{

    /** The simple field. */
    @XmlElement(name = "SimpleField")
    protected List<SimpleField> simpleField;
    /**
     * <Object>
     * <p>
     * This is an abstract base class and cannot be used directly in a KML file. It provides 
     * the id attribute, which allows unique identification of a KML element, and the targetId 
     * attribute, which is used to reference objects that have already been loaded into 
     * Google Earth. The id attribute must be assigned if the <Update> mechanism is to 
     * be used. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
     * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
     * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
     * 
     * 
     * 
     */
    @XmlElement(name = "SchemaExtension")
    protected List<Object> schemaExtension;
    /**
     * <name>
     * <p>
     * User-defined text displayed in the 3D viewer as the label for the object (for example, 
     * for a Placemark, Folder, or NetworkLink). 
     * </p>
     * 
     * 
     * 
     */
    @XmlAttribute(name = "name")
    protected String name;
    
    /** The id. */
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Instantiates a new schema.
     */
    public Schema() {
        super();
    }

    /**
     * Gets the simple field.
     *
     * @return the simple field
     * @see simpleField
     */
    public List<SimpleField> getSimpleField() {
        if (simpleField == null) {
            simpleField = new ArrayList<SimpleField>();
        }
        return this.simpleField;
    }

    /**
     * Gets the schema extension.
     *
     * @return the schema extension
     * @see schemaExtension
     */
    public List<Object> getSchemaExtension() {
        if (schemaExtension == null) {
            schemaExtension = new ArrayList<Object>();
        }
        return this.schemaExtension;
    }

    /**
     * Gets the name.
     *
     * @return     possible object is
     *     {@link String}
     * @see name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see name
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the id.
     *
     * @return     possible object is
     *     {@link String}
     * @see id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value     allowed object is
     *     {@link String}
     * @see id
     */
    public void setId(String value) {
        this.id = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ((prime*result)+((simpleField == null)? 0 :simpleField.hashCode()));
        result = ((prime*result)+((schemaExtension == null)? 0 :schemaExtension.hashCode()));
        result = ((prime*result)+((name == null)? 0 :name.hashCode()));
        result = ((prime*result)+((id == null)? 0 :id.hashCode()));
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
        if ((obj instanceof Schema) == false) {
            return false;
        }
        Schema other = ((Schema) obj);
        if (simpleField == null) {
            if (other.simpleField!= null) {
                return false;
            }
        } else {
            if (simpleField.equals(other.simpleField) == false) {
                return false;
            }
        }
        if (schemaExtension == null) {
            if (other.schemaExtension!= null) {
                return false;
            }
        } else {
            if (schemaExtension.equals(other.schemaExtension) == false) {
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
        if (id == null) {
            if (other.id!= null) {
                return false;
            }
        } else {
            if (id.equals(other.id) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new instance of {@link SimpleField} and adds it to simpleField.
     * This method is a short version for:
     * <code>
     * SimpleField simpleField = new SimpleField();
     * this.getSimpleField().add(simpleField); </code>
     *
     * @return the simple field
     */
    public SimpleField createAndAddSimpleField() {
        SimpleField newValue = new SimpleField();
        this.getSimpleField().add(newValue);
        return newValue;
    }

    /**
     * Sets the simple field.
     *
     * @param simpleField the new simple field
     * @see simpleField
     */
    public void setSimpleField(final List<SimpleField> simpleField) {
        this.simpleField = simpleField;
    }

    /**
     * add a value to the simpleField property collection.
     *
     * @param simpleField     Objects of the following type are allowed in the list: {@link SimpleField}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Schema addToSimpleField(final SimpleField simpleField) {
        this.getSimpleField().add(simpleField);
        return this;
    }

    /**
     * Sets the schema extension.
     *
     * @param schemaExtension the new schema extension
     * @see schemaExtension
     */
    public void setSchemaExtension(final List<Object> schemaExtension) {
        this.schemaExtension = schemaExtension;
    }

    /**
     * add a value to the schemaExtension property collection.
     *
     * @param schemaExtension     Objects of the following type are allowed in the list: {@code <}{@link SimpleArrayField}{@code>}{@link JAXBElement}{@code <}{@link Object}{@code>}
     * @return     <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
     */
    public Schema addToSchemaExtension(final Object schemaExtension) {
        this.getSchemaExtension().add(schemaExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param simpleField     required parameter
     * @return the schema
     * @see #setSimpleField(List<SimpleField>)
     */
    public Schema withSimpleField(final List<SimpleField> simpleField) {
        this.setSimpleField(simpleField);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param schemaExtension     required parameter
     * @return the schema
     * @see #setSchemaExtension(List<Object>)
     */
    public Schema withSchemaExtension(final List<Object> schemaExtension) {
        this.setSchemaExtension(schemaExtension);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param name     required parameter
     * @return the schema
     * @see #setName(String)
     */
    public Schema withName(final String name) {
        this.setName(name);
        return this;
    }

    /**
     * fluent setter.
     *
     * @param id     required parameter
     * @return the schema
     * @see #setId(String)
     */
    public Schema withId(final String id) {
        this.setId(id);
        return this;
    }

    @Override
    public Schema clone() {
        Schema copy;
        try {
            copy = ((Schema) super.clone());
        } catch (CloneNotSupportedException _x) {
            throw new InternalError((_x.toString()));
        }
        copy.simpleField = new ArrayList<SimpleField>((getSimpleField().size()));
        for (SimpleField iter: simpleField) {
            copy.simpleField.add(iter.clone());
        }
        copy.schemaExtension = new ArrayList<Object>((getSchemaExtension().size()));
        for (Object iter: schemaExtension) {
            copy.schemaExtension.add(iter);
        }
        return copy;
    }

}
