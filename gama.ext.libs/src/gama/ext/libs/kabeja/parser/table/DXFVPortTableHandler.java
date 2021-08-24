/*******************************************************************************************************
 *
 * DXFVPortTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFViewport;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFVPortTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFVPortTableHandler extends AbstractTableHandler {
    
    /** The Constant GROUPCODE_VPORT_NAME. */
    public final static int GROUPCODE_VPORT_NAME = 2;
    
    /** The Constant GROUPCODE_VPORT_LOWER_LEFT_X. */
    public final static int GROUPCODE_VPORT_LOWER_LEFT_X = 10;
    
    /** The Constant GROUPCODE_VPORT_LOWER_LEFT_Y. */
    public final static int GROUPCODE_VPORT_LOWER_LEFT_Y = 20;
    
    /** The Constant GROUPCODE_VPORT_UPPER_RIGHT_X. */
    public final static int GROUPCODE_VPORT_UPPER_RIGHT_X = 11;
    
    /** The Constant GROUPCODE_VPORT_UPPER_RIGHT_Y. */
    public final static int GROUPCODE_VPORT_UPPER_RIGHT_Y = 21;
    
    /** The Constant GROUPCODE_VPORT_CENTER_POINT_X. */
    public final static int GROUPCODE_VPORT_CENTER_POINT_X = 12;
    
    /** The Constant GROUPCODE_VPORT_CENTER_POINT_Y. */
    public final static int GROUPCODE_VPORT_CENTER_POINT_Y = 22;
    
    /** The Constant GROUPCODE_VPORT_SNAP_BASE_POINT_X. */
    public final static int GROUPCODE_VPORT_SNAP_BASE_POINT_X = 13;
    
    /** The Constant GROUPCODE_VPORT_SNAP_BASE_POINT_Y. */
    public final static int GROUPCODE_VPORT_SNAP_BASE_POINT_Y = 23;
    
    /** The Constant GROUPCODE_HEIGHT. */
    public final static int GROUPCODE_HEIGHT = 40;
    
    /** The Constant GROUPCODE_ASPECT_RATIO. */
    public final static int GROUPCODE_ASPECT_RATIO = 41;
    
    /** The viewport. */
    private DXFViewport viewport;

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFViewport(viewport);
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return DXFConstants.TABLE_KEY_VPORT;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int, de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_VPORT_NAME:
            viewport.setViewportID(value.getValue());

            if ("*active".equals(value.getValue().toLowerCase())) {
                viewport.setActive(true);
            }

            break;

        case GROUPCODE_VPORT_CENTER_POINT_X:
            viewport.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_CENTER_POINT_Y:
            viewport.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_LOWER_LEFT_X:
            viewport.getLowerLeftCorner().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VPORT_LOWER_LEFT_Y:
            viewport.getLowerLeftCorner().setY(value.getDoubleValue());

            break;

        case GROUPCODE_HEIGHT:
            viewport.setHeight(value.getDoubleValue());

            break;

        case GROUPCODE_ASPECT_RATIO:
            viewport.setAspectRatio(value.getDoubleValue());

            break;
        }
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        viewport = new DXFViewport();
    }
}
