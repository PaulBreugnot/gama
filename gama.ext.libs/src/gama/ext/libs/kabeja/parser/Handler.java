/*******************************************************************************************************
 *
 * Handler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 * This is a simple marker-interface. Every parser part must implement this
 * interface.
 *
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 *
 *
 */
public interface Handler {
    
    /**
     * Sets the DXF document.
     *
     * @param doc the new DXF document
     */
    public void setDXFDocument(DXFDocument doc);

    /**
     * Release DXF document.
     */
    public void releaseDXFDocument();
}
