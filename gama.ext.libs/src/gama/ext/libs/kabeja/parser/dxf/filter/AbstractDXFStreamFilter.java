/*******************************************************************************************************
 *
 * AbstractDXFStreamFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.dxf.filter;

import java.util.Map;

import gama.ext.libs.kabeja.parser.dxf.DXFHandler;


/**
 * The Class AbstractDXFStreamFilter.
 */
public abstract class AbstractDXFStreamFilter implements DXFStreamFilter {
    
    /** The properties. */
    protected Map properties;
    
    /** The handler. */
    protected DXFHandler handler;

    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public void setDXFHandler(DXFHandler handler) {
        this.handler = handler;
    }
}
