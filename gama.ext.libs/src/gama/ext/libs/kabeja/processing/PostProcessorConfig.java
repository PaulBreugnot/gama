/*******************************************************************************************************
 *
 * PostProcessorConfig.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class PostProcessorConfig.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class PostProcessorConfig {
    
    /** The properties. */
    private Map properties = new HashMap();
    
    /** The post processor name. */
    private String postProcessorName;

    /**
     * Instantiates a new post processor config.
     *
     * @param properties the properties
     */
    public PostProcessorConfig(Map properties) {
        this.properties = properties;
    }

    /**
     * Instantiates a new post processor config.
     */
    public PostProcessorConfig() {
        this(new HashMap());
    }

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
     * Gets the post processor name.
     *
     * @return Returns the filterName.
     */
    public String getPostProcessorName() {
        return postProcessorName;
    }

    /**
     * Sets the post processor name.
     *
     * @param filterName The filterName to set.
     */
    public void setPostProcessorName(String filterName) {
        this.postProcessorName = filterName;
    }
}
