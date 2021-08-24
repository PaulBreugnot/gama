/*******************************************************************************************************
 *
 * SAXSerializerConfig.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.tools;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class SAXSerializerConfig.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class SAXSerializerConfig {
    
    /** The properties. */
    private Map properties = new HashMap();
    
    /** The sax serializer name. */
    private String saxSerializerName;

    /**
     * Gets the properties.
     *
     * @return the properties
     */
    public Map getProperties() {
        return this.properties;
    }

    /**
     * Adds the property.
     *
     * @param name the name
     * @param value the value
     */
    public void addProperty(String name, String value) {
        this.properties.put(name, value);
    }

    /**
     * Gets the SAX serializer name.
     *
     * @return Returns the filterName.
     */
    public String getSAXSerializerName() {
        return saxSerializerName;
    }

    /**
     * Sets the SAX serializer name.
     *
     * @param filterName The filterName to set.
     */
    public void setSAXSerializerName(String filterName) {
        this.saxSerializerName = filterName;
    }
}
