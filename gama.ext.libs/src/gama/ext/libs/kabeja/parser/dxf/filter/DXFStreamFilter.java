/*******************************************************************************************************
 *
 * DXFStreamFilter.java, in gama.ext.libs, is part of the source code of the
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
 * The Interface DXFStreamFilter.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public interface DXFStreamFilter extends DXFHandler {
    
    /**
     * The next DXFHandler in the chain.
     *
     * @param handler the new DXF handler
     */
    public void setDXFHandler(DXFHandler handler);

    /**
     * Setup properties for the DXFStreamFilter. Will called before the parsing
     * starts.
     *
     * @param properties the new properties
     */
    public void setProperties(Map properties);
}
