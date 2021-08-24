/*******************************************************************************************************
 *
 * DXFRegionHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFRegion;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFRegionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFRegionHandler extends AbstractEntityHandler {
    
    /** The Constant DATA. */
    protected static final int DATA = 1;
    
    /** The Constant APPEND_DATA. */
    protected static final int APPEND_DATA = 3;
    
    /** The region. */
    protected DXFRegion region;
    
    /** The data. */
    protected StringBuffer data = new StringBuffer();

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.AbstractEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        // TODO Auto-generated method stub
        return DXFConstants.ENTITY_TYPE_REGION;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        region = new DXFRegion();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case DATA:
            //first cleanup
            checkBuffer();
            data.append(value.getValue());

            break;

        case APPEND_DATA:
            data.append(value.getValue());

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return region;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
        checkBuffer();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /**
     * Decode DATA.
     *
     * @param s the s
     * @return the string
     */
    protected String decodeDATA(String s) {
        char[] c = s.toCharArray();
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < c.length; i++) {
            if (Character.isWhitespace(c[i])) {
                buf.append(' ');
            } else {
                int code = Math.abs((c[i]) - 159);
                buf.append((char) code);
            }
        }

        return buf.toString();
    }

    /**
     * Check buffer.
     */
    protected void checkBuffer() {
        if (data.length() > 0) {
            region.appendACISDATA(decodeDATA(data.toString()));
            data.delete(0, data.length());
        }
    }
}
