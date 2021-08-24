/*******************************************************************************************************
 *
 * DXFLeaderHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFLeader;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFLeaderHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFLeaderHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_ARROW_HEAD_FLAG. */
    public static final int GROUPCODE_ARROW_HEAD_FLAG = 71;
    
    /** The Constant GROUPCODE_LEADER_PATH_TYPE. */
    public static final int GROUPCODE_LEADER_PATH_TYPE = 72;
    
    /** The Constant GROUPCODE_LEADER_CREATION_FLAG. */
    public static final int GROUPCODE_LEADER_CREATION_FLAG = 73;
    
    /** The Constant GROUPCODE_HOOKLINE_DIRECTION_FLAG. */
    public static final int GROUPCODE_HOOKLINE_DIRECTION_FLAG = 74;
    
    /** The Constant GROUPCODE_HOOKLINE_FLAG. */
    public static final int GROUPCODE_HOOKLINE_FLAG = 75;
    
    /** The Constant GROUPCODE_TEXT_HEIGHT. */
    public static final int GROUPCODE_TEXT_HEIGHT = 40;
    
    /** The Constant GROUPCODE_TEXT_WIDTH. */
    public static final int GROUPCODE_TEXT_WIDTH = 41;
    
    /** The Constant GROUPCODE_COLOR_LEADER. */
    public static final int GROUPCODE_COLOR_LEADER = 77;
    
    /** The Constant GROUPCODE_TEXT_ENTITY_REFERENCE. */
    public static final int GROUPCODE_TEXT_ENTITY_REFERENCE = 340;
    
    /** The Constant GROUPCODE_HORIZONTAL_DIRECTION_X. */
    public static final int GROUPCODE_HORIZONTAL_DIRECTION_X = 211;
    
    /** The Constant GROUPCODE_HORIZONTAL_DIRECTION_Y. */
    public static final int GROUPCODE_HORIZONTAL_DIRECTION_Y = 221;
    
    /** The Constant GROUPCODE_HORIZONTAL_DIRECTION_Z. */
    public static final int GROUPCODE_HORIZONTAL_DIRECTION_Z = 231;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_X. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_X = 212;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Y. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Y = 222;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Z. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Z = 232;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_X. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_X = 213;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Y. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Y = 223;
    
    /** The Constant GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Z. */
    public static final int GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Z = 233;
    
    /** The leader. */
    protected DXFLeader leader;
    
    /** The vertex. */
    protected Point vertex;

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.AbstractEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_LEADER;
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        leader = new DXFLeader();
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.DXFEntityHandler#parseGroup(int, org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            vertex = new Point();
            leader.addCoordinate(vertex);
            vertex.setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            vertex.setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            vertex.setZ(value.getDoubleValue());

            break;

        case GROUPCODE_STYLENAME:
            leader.setStyleNameID(value.getValue());

            break;

        case GROUPCODE_ARROW_HEAD_FLAG:
            leader.setArrowEnabled(value.getBooleanValue());

            break;

        case GROUPCODE_LEADER_PATH_TYPE:
            leader.setPathType(value.getIntegerValue());

            break;

        case GROUPCODE_LEADER_CREATION_FLAG:
            leader.setCreationType(value.getIntegerValue());

            break;

        case GROUPCODE_HOOKLINE_DIRECTION_FLAG:
            leader.setHooklineDirecton(value.getIntegerValue());

            break;

        case GROUPCODE_HOOKLINE_FLAG:
            leader.setHookline(value.getBooleanValue());

            break;

        case GROUPCODE_TEXT_HEIGHT:
            leader.setTextHeight(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_WIDTH:
            leader.setTextWidth(value.getDoubleValue());

            break;

        case GROUPCODE_HORIZONTAL_DIRECTION_X:
            leader.getHorizontalDirection().setX(value.getDoubleValue());

            break;

        case GROUPCODE_HORIZONTAL_DIRECTION_Y:
            leader.getHorizontalDirection().setY(value.getDoubleValue());

            break;

        case GROUPCODE_HORIZONTAL_DIRECTION_Z:
            leader.getHorizontalDirection().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_X:
            leader.getLastOffsetInsertion().setX(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Y:
            leader.getLastOffsetInsertion().setY(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_INSERTPOINT_Z:
            leader.getLastOffsetInsertion().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_X:
            leader.getLastOffsetText().setX(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Y:
            leader.getLastOffsetText().setY(value.getDoubleValue());

            break;

        case GROUPCODE_OFFSET_LAST_VERTEX_PLACEMENT_POINT_Z:
            leader.getLastOffsetText().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_ENTITY_REFERENCE:
            leader.setTextID(value.getValue());

            break;

        case GROUPCODE_COLOR_LEADER:
            leader.setColor(value.getIntegerValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, leader);
        }
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return leader;
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /* (non-Javadoc)
     * @see org.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }
}
