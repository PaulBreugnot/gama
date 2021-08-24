/*******************************************************************************************************
 *
 * AbstractDXFObjectHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class AbstractDXFObjectHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public abstract class AbstractDXFObjectHandler implements DXFObjectHandler {
    
    /** The Constant GROUPCODE_SOFTPOINTER_ID. */
    public final static int GROUPCODE_SOFTPOINTER_ID = 330;
    
    /** The Constant GROUPCODE_HARDOWNER_ID. */
    public final static int GROUPCODE_HARDOWNER_ID = 360;
    
    /** The Constant GROUPCODE_HANDLE_ID. */
    public final static int GROUPCODE_HANDLE_ID = 5;
    
    /** The doc. */
    protected DXFDocument doc;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        doc = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.Handler#setDXFDocument(de.miethxml.kabeja.dxf.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /**
     * Parses the common group code.
     *
     * @param groupCode the group code
     * @param value the value
     * @param obj the obj
     */
    protected void parseCommonGroupCode(int groupCode, DXFValue value,
        DXFObject obj) {
        switch (groupCode) {
        case GROUPCODE_HANDLE_ID:
            obj.setID(value.getValue());

            break;

        case GROUPCODE_HARDOWNER_ID:
            obj.setHardOwnerID(value.getValue());

            break;

        case GROUPCODE_SOFTPOINTER_ID:
            obj.setSoftPointerID(value.getValue());

            break;
        }
    }
}
