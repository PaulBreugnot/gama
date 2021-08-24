/*******************************************************************************************************
 *
 * DXFViewTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFView;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFViewTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFViewTableHandler extends AbstractTableHandler {
    
    /** The Constant GROUPCODE_NAME. */
    public static final int GROUPCODE_NAME = 2;
    
    /** The Constant GROUPCODE_CENTER_X. */
    public static final int GROUPCODE_CENTER_X = 10;
    
    /** The Constant GROUPCODE_CENTER_Y. */
    public static final int GROUPCODE_CENTER_Y = 20;
    
    /** The Constant GROUPCODE_CENTER_Z. */
    public static final int GROUPCODE_CENTER_Z = 30;
    
    /** The Constant GROUPCODE_HEIGHT. */
    public static final int GROUPCODE_HEIGHT = 40;
    
    /** The Constant GROUPCODE_WIDTH. */
    public static final int GROUPCODE_WIDTH = 41;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_X. */
    public static final int GROUPCODE_VIEW_DIRECTION_X = 11;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_Y. */
    public static final int GROUPCODE_VIEW_DIRECTION_Y = 21;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_Z. */
    public static final int GROUPCODE_VIEW_DIRECTION_Z = 31;
    
    /** The Constant GROUPCODE_VIEW_TARGET_X. */
    public static final int GROUPCODE_VIEW_TARGET_X = 12;
    
    /** The Constant GROUPCODE_VIEW_TARGET_Y. */
    public static final int GROUPCODE_VIEW_TARGET_Y = 22;
    
    /** The Constant GROUPCODE_VIEW_TARGET_Z. */
    public static final int GROUPCODE_VIEW_TARGET_Z = 32;
    
    /** The Constant GROUPCODE_LENS_LENGTH. */
    public static final int GROUPCODE_LENS_LENGTH = 42;
    
    /** The Constant GROUPCODE_FRONT_CLIPPING. */
    public static final int GROUPCODE_FRONT_CLIPPING = 43;
    
    /** The Constant GROUPCODE_BACK_CLIPPING. */
    public static final int GROUPCODE_BACK_CLIPPING = 44;
    
    /** The Constant GROUPCODE_TWIST_ANGLE. */
    public static final int GROUPCODE_TWIST_ANGLE = 50;
    
    /** The Constant GROUPCODE_RENDER_MODE. */
    public static final int GROUPCODE_RENDER_MODE = 281;
    
    /** The Constant GROUPCODE_UCS_ORIGIN_X. */
    public static final int GROUPCODE_UCS_ORIGIN_X = 110;
    
    /** The Constant GROUPCODE_UCS_ORIGIN_Y. */
    public static final int GROUPCODE_UCS_ORIGIN_Y = 120;
    
    /** The Constant GROUPCODE_UCS_ORIGIN_Z. */
    public static final int GROUPCODE_UCS_ORIGIN_Z = 130;
    
    /** The Constant GROUPCODE_UCS_X_AXIS_X. */
    public static final int GROUPCODE_UCS_X_AXIS_X = 111;
    
    /** The Constant GROUPCODE_UCS_X_AXIS_Y. */
    public static final int GROUPCODE_UCS_X_AXIS_Y = 121;
    
    /** The Constant GROUPCODE_UCS_X_AXIS_Z. */
    public static final int GROUPCODE_UCS_X_AXIS_Z = 131;
    
    /** The Constant GROUPCODE_UCS_Y_AXIS_X. */
    public static final int GROUPCODE_UCS_Y_AXIS_X = 112;
    
    /** The Constant GROUPCODE_UCS_Y_AXIS_Y. */
    public static final int GROUPCODE_UCS_Y_AXIS_Y = 122;
    
    /** The Constant GROUPCODE_UCS_Y_AXIS_Z. */
    public static final int GROUPCODE_UCS_Y_AXIS_Z = 132;
    
    /** The Constant GROUPCODE_UCS_TYPE. */
    public static final int GROUPCODE_UCS_TYPE = 79;
    
    /** The Constant GROUPCODE_UCS_ELEVATION. */
    public static final int GROUPCODE_UCS_ELEVATION = 146;
    
    /** The Constant GROUPCODE_USE_UCS. */
    public static final int GROUPCODE_USE_UCS = 72;
    
    /** The view. */
    private DXFView view;

    public void endParsing() {
        this.doc.addDXFView(view);
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return DXFConstants.TABLE_KEY_VIEW;
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#parseGroup(int, org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_CENTER_X:
            view.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Y:
            view.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Z:
            view.getCenterPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            view.setName(value.getValue());

            break;

        case GROUPCODE_WIDTH:
            view.setWidth(value.getDoubleValue());

            break;

        case GROUPCODE_HEIGHT:
            view.setHeight(value.getDoubleValue());

            break;

        case GROUPCODE_FRONT_CLIPPING:
            view.setFrontClipping(value.getDoubleValue());

            break;

        case GROUPCODE_BACK_CLIPPING:
            view.setBackClipping(value.getDoubleValue());

            break;

        case GROUPCODE_LENS_LENGTH:
            view.setLensLength(value.getDoubleValue());

            break;

        case GROUPCODE_RENDER_MODE:
            view.setRenderMode(value.getIntegerValue());

            break;

        case GROUPCODE_TWIST_ANGLE:
            view.setTwistAngle(value.getDoubleValue());

            break;

        case GROUPCODE_USE_UCS:
            view.setUseUCS(value.getBooleanValue());

            break;

        case GROUPCODE_UCS_ELEVATION:
            view.setUcsElevation(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_X:
            view.getUcsOrigin().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Y:
            view.getUcsOrigin().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Z:
            view.getUcsOrigin().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_X:
            view.getUcsXAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Y:
            view.getUcsXAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Z:
            view.getUcsXAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_X:
            view.getUcsYAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Y:
            view.getUcsYAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Z:
            view.getUcsYAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_TYPE:
            view.setUcsType(value.getIntegerValue());

            break;
        }
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        view = new DXFView();
    }
}
