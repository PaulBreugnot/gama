/*******************************************************************************************************
 *
 * DXFAttribHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFAttrib;
import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFAttribHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFAttribHandler extends DXFTextHandler {
    
    /** The Constant ATTRIB_VERTICAL_ALIGN. */
    public static final int ATTRIB_VERTICAL_ALIGN = 74;
    
    /** The Constant ATTRIB_TEXT_LENGTH. */
    public static final int ATTRIB_TEXT_LENGTH = 73;

    /**
     * Instantiates a new DXF attrib handler.
     */
    public DXFAttribHandler() {
        super();
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int, de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case ATTRIB_TEXT_LENGTH:

            //ignore not used by
            break;

        case ATTRIB_VERTICAL_ALIGN:
            text.setValign(value.getIntegerValue());

            break;

        default:
            super.parseGroup(groupCode, value);
        }
    }

    public void startDXFEntity() {
        text = new DXFAttrib();
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_ATTRIB;
    }
}
