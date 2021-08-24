/*******************************************************************************************************
 *
 * DXFViewportHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFViewport;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFViewportHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFViewportHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_CENTER_X. */
    public static final int GROUPCODE_CENTER_X = 10;
    
    /** The Constant GROUPCODE_CENTER_Y. */
    public static final int GROUPCODE_CENTER_Y = 20;
    
    /** The Constant GROUPCODE_CENTER_Z. */
    public static final int GROUPCODE_CENTER_Z = 30;
    
    /** The Constant GROUPCODE_HEIGHT. */
    public static final int GROUPCODE_HEIGHT = 41;
    
    /** The Constant GROUPCODE_WIDTH. */
    public static final int GROUPCODE_WIDTH = 40;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_X. */
    public static final int GROUPCODE_VIEW_DIRECTION_X = 16;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_Y. */
    public static final int GROUPCODE_VIEW_DIRECTION_Y = 26;
    
    /** The Constant GROUPCODE_VIEW_DIRECTION_Z. */
    public static final int GROUPCODE_VIEW_DIRECTION_Z = 36;
    
    /** The Constant GROUPCODE_VIEW_CENTER_X. */
    public static final int GROUPCODE_VIEW_CENTER_X = 12;
    
    /** The Constant GROUPCODE_VIEW_CENTER_Y. */
    public static final int GROUPCODE_VIEW_CENTER_Y = 22;
    
    /** The Constant GROUPCODE_VIEW_CENTER_Z. */
    public static final int GROUPCODE_VIEW_CENTER_Z = 32;
    
    /** The Constant GROUPCODE_VIEW_TARGET_X. */
    public static final int GROUPCODE_VIEW_TARGET_X = 17;
    
    /** The Constant GROUPCODE_VIEW_TARGET_Y. */
    public static final int GROUPCODE_VIEW_TARGET_Y = 27;
    
    /** The Constant GROUPCODE_VIEW_TARGET_Z. */
    public static final int GROUPCODE_VIEW_TARGET_Z = 37;
    
    /** The Constant GROUPCODE_SNAP_BASE_POINT_X. */
    public static final int GROUPCODE_SNAP_BASE_POINT_X = 13;
    
    /** The Constant GROUPCODE_SNAP_BASE_POINT_Y. */
    public static final int GROUPCODE_SNAP_BASE_POINT_Y = 23;
    
    /** The Constant GROUPCODE_SNAP_SPACING_X. */
    public static final int GROUPCODE_SNAP_SPACING_X = 14;
    
    /** The Constant GROUPCODE_SNAP_SPACING_Y. */
    public static final int GROUPCODE_SNAP_SPACING_Y = 24;
    
    /** The Constant GROUPCODE_GRID_SPACING_X. */
    public static final int GROUPCODE_GRID_SPACING_X = 15;
    
    /** The Constant GROUPCODE_GRID_SPACING_Y. */
    public static final int GROUPCODE_GRID_SPACING_Y = 25;
    
    /** The Constant GROUPCODE_LENS_LENGTH. */
    public static final int GROUPCODE_LENS_LENGTH = 42;
    
    /** The Constant GROUPCODE_FRONT_CLIPPING. */
    public static final int GROUPCODE_FRONT_CLIPPING = 43;
    
    /** The Constant GROUPCODE_BACK_CLIPPING. */
    public static final int GROUPCODE_BACK_CLIPPING = 44;
    
    /** The Constant GROUPCODE_VIEW_HEIGHT. */
    public static final int GROUPCODE_VIEW_HEIGHT = 45;
    
    /** The Constant GROUPCODE_SNAP_ANGLE. */
    public static final int GROUPCODE_SNAP_ANGLE = 50;
    
    /** The Constant GROUPCODE_TWIST_ANGLE. */
    public static final int GROUPCODE_TWIST_ANGLE = 51;
    
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
    
    /** The Constant GROUPCODE_CIRCLE_ZOOM_PERCENT. */
    public static final int GROUPCODE_CIRCLE_ZOOM_PERCENT = 72;
    
    /** The Constant GROUPCODE_VIEWPORT_ID. */
    public static final int GROUPCODE_VIEWPORT_ID = 69;
    
    /** The Constant GROUPCODE_VIEWPORT_STATUS. */
    public static final int GROUPCODE_VIEWPORT_STATUS = 68;
    
    /** The Constant GROUPCODE_PLOTSTYLE_NAME. */
    public static final int GROUPCODE_PLOTSTYLE_NAME = 1;
    
    /** The Constant GROUPCODE_FROZEN_LAYER. */
    public static final int GROUPCODE_FROZEN_LAYER = 341;
    
    /** The Constant GROUPCODE_FROZEN_LAYER_XDATA. */
    public static final int GROUPCODE_FROZEN_LAYER_XDATA = 1003;
    
    /** The x data convert. */
    private int[] xDataConvert = new int[] {
            1000, 1002, 1070, 17, 27, 37, 16, 26, 36, 51, 45, 12, 22, 42, 43, 44,
            90, 72, 90, 90, 90, 90, 90, 90, 50, 13, 23, 14, 24, 15, 25, 90, 1002
        };
    
    /** The viewport. */
    private DXFViewport viewport;
    
    /** The convert XDATA. */
    private boolean convertXDATA = false;
    
    /** The pos. */
    private int pos = 0;

    public void parseGroup(int groupCode, DXFValue value) {
        //check for XDATA
        if (convertXDATA && (pos < xDataConvert.length)) {
            groupCode = xDataConvert[pos];
            pos++;
        } else if ((groupCode == 1001) && value.getValue().equals("ACAD")) {
            convertXDATA = true;
            pos = 0;
        } else {
            convertXDATA = false;
        }

        switch (groupCode) {
        case GROUPCODE_CENTER_X:
            viewport.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Y:
            viewport.getCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_CENTER_Z:
            viewport.getCenterPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_CENTER_X:
            viewport.getViewCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_CENTER_Y:
            viewport.getViewCenterPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_CENTER_Z:
            viewport.getViewCenterPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_DIRECTION_X:
            viewport.getViewDirectionVector().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_DIRECTION_Y:
            viewport.getViewDirectionVector().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_DIRECTION_Z:
            viewport.getViewDirectionVector().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_TARGET_X:
            viewport.getViewTargetPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_TARGET_Y:
            viewport.getViewTargetPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VIEW_TARGET_Z:
            viewport.getViewTargetPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_SNAP_BASE_POINT_X:
            viewport.getSnapBasePoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_SNAP_BASE_POINT_Y:
            viewport.getSnapBasePoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_SNAP_SPACING_X:
            viewport.getSnapSpacingPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_SNAP_SPACING_Y:
            viewport.getSnapSpacingPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_GRID_SPACING_X:
            viewport.getGridSpacingPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_GRID_SPACING_Y:
            viewport.getGridSpacingPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VIEWPORT_ID:
            viewport.setViewportID(value.getValue());

            break;

        case GROUPCODE_WIDTH:
            viewport.setWidth(value.getDoubleValue());

            break;

        case GROUPCODE_HEIGHT:
            viewport.setHeight(value.getDoubleValue());

            break;

        case GROUPCODE_FRONT_CLIPPING:
            viewport.setFrontClippingPlane(value.getDoubleValue());

            break;

        case GROUPCODE_BACK_CLIPPING:
            viewport.setBackClippingPlane(value.getDoubleValue());

            break;

        case GROUPCODE_LENS_LENGTH:
            viewport.setLensLength(value.getDoubleValue());

            break;

        case GROUPCODE_RENDER_MODE:
            viewport.setRenderMode(value.getIntegerValue());

            break;

        case GROUPCODE_TWIST_ANGLE:
            viewport.setTwistAngle(value.getDoubleValue());

            break;

        case GROUPCODE_SNAP_ANGLE:
            viewport.setSnapAngle(value.getDoubleValue());

            break;

        case GROUPCODE_CIRCLE_ZOOM_PERCENT:
            viewport.setCircleZoom(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ELEVATION:
            viewport.setUcsElevation(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_X:
            viewport.getUcsOrigin().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Y:
            viewport.getUcsOrigin().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_ORIGIN_Z:
            viewport.getUcsOrigin().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_X:
            viewport.getUcsXAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Y:
            viewport.getUcsXAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_X_AXIS_Z:
            viewport.getUcsXAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_X:
            viewport.getUcsYAxis().setX(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Y:
            viewport.getUcsYAxis().setY(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_Y_AXIS_Z:
            viewport.getUcsYAxis().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_UCS_TYPE:
            viewport.setUcsType(value.getIntegerValue());

            break;

        case GROUPCODE_VIEW_HEIGHT:
            viewport.setViewHeight(value.getDoubleValue());

            break;

        case GROUPCODE_VIEWPORT_STATUS:
            viewport.setViewportStatus(value.getIntegerValue());

            break;

        case GROUPCODE_PLOTSTYLE_NAME:
            viewport.setPlotStyleName(value.getValue());

            break;

        case GROUPCODE_FROZEN_LAYER:
            viewport.addFrozenLayer(value.getValue());

            break;

        case GROUPCODE_FROZEN_LAYER_XDATA:
            viewport.addFrozenLayer(value.getValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, viewport);

            break;
        }
    }

    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_VIEWPORT;
    }

    public void endDXFEntity() {
        // nothing to do
    }

    public DXFEntity getDXFEntity() {
        return this.viewport;
    }

    public boolean isFollowSequence() {
        return false;
    }

    public void startDXFEntity() {
        this.viewport = new DXFViewport();
        this.viewport.setModelSpace(false);
    }
}
