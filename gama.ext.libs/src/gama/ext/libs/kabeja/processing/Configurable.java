/*******************************************************************************************************
 *
 * Configurable.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.Map;


/**
 * The Interface Configurable.
 */
public interface Configurable {
    
    /**
     * Set configuration properties of the component.
     *
     * @param properties the new properties
     */
    public void setProperties(Map properties);

    /**
     * Get the configuration Properties of the component.
     *
     * @return the properties
     */
    public Map getProperties();
}
