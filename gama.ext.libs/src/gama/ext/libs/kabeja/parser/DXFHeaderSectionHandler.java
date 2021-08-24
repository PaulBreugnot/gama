/*******************************************************************************************************
 *
 * DXFHeaderSectionHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFHeader;
import gama.ext.libs.kabeja.dxf.DXFVariable;


/**
 * The Class DXFHeaderSectionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFHeaderSectionHandler implements DXFSectionHandler {
    
    /** The Constant VARIABLE_CODE. */
    public final static int VARIABLE_CODE = 9;
    
    /** The section key. */
    private final String sectionKey = "HEADER";
    
    /** The doc. */
    private DXFDocument doc;
    
    /** The variable. */
    private DXFVariable variable = null;
    
    /** The mode. */
    private String mode;

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#getSectionKey()
     */
    public String getSectionKey() {
        return sectionKey;
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#setDXFDocument(org.dxf2svg.xml.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#parseGroup(int, java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        if (groupCode == VARIABLE_CODE) {
            variable = new DXFVariable(value.getValue());
            doc.getDXFHeader().setVariable(variable);
        } else {
            //handle the current mode
            parse(groupCode, value);
        }
    }

    /**
     * Parses the.
     *
     * @param code the code
     * @param value the value
     */
    private void parse(int code, DXFValue value) {
        variable.setValue("" + code, value.getValue());
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#endParsing()
     */
    public void endSection() {
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.SectionHandler#startParsing()
     */
    public void startSection() {
        doc.setDXFHeader(new DXFHeader());
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        this.doc = null;
    }
}
