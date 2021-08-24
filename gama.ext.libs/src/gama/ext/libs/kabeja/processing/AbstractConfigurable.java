/*******************************************************************************************************
 *
 * AbstractConfigurable.java, in gama.ext.libs, is part of the source code of the
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
 * The Class AbstractConfigurable.
 */
public abstract class AbstractConfigurable implements Configurable {
    
    /** The properties. */
    protected Map properties = new HashMap();

    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public Map getProperties() {
        return this.properties;
    }
}
