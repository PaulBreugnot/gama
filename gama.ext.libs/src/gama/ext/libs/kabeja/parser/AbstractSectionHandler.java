/*******************************************************************************************************
 *
 * AbstractSectionHandler.java, in gama.ext.libs, is part of the source code of the
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
 * The Class AbstractSectionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public abstract class AbstractSectionHandler implements DXFSectionHandler {
    
    /** The doc. */
    protected DXFDocument doc;

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#setDXFDocument(org.dxf2svg.xml.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }
}
