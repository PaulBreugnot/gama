/*******************************************************************************************************
 *
 * DXFInsertHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFInsert;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFInsertHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFInsertHandler extends AbstractEntityHandler {
    
    /** The Constant SCALE_X. */
    public static final int SCALE_X = 41;
    
    /** The Constant SCALE_Y. */
    public static final int SCALE_Y = 42;
    
    /** The Constant SCALE_Z. */
    public static final int SCALE_Z = 43;
    
    /** The Constant ROTATE. */
    public static final int ROTATE = 50;
    
    /** The Constant COLUMN_COUNT. */
    public static final int COLUMN_COUNT = 70;
    
    /** The Constant ROW_COUNT. */
    public static final int ROW_COUNT = 71;
    
    /** The Constant COLUMN_SPACING. */
    public static final int COLUMN_SPACING = 44;
    
    /** The Constant ROW_SPACING. */
    public static final int ROW_SPACING = 45;
    
    /** The Constant BLOCK_NAME. */
    public static final int BLOCK_NAME = 2;
    
    /** The insert. */
    private DXFInsert insert;

    /**
     * Instantiates a new DXF insert handler.
     */
    public DXFInsertHandler() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return insert;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_INSERT;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            insert.getPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            insert.getPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            insert.getPoint().setZ(value.getDoubleValue());

            break;

        case SCALE_X:
            insert.setScaleX(value.getDoubleValue());

            break;

        case SCALE_Y:
            insert.setScaleY(value.getDoubleValue());

            break;

        case SCALE_Z:
            insert.setScaleZ(value.getDoubleValue());

            break;

        case ROTATE:
            insert.setRotate(value.getDoubleValue());

            break;

        case COLUMN_COUNT:
            insert.setColumns(value.getIntegerValue());

            break;

        case ROW_COUNT:
            insert.setRows(value.getIntegerValue());

            break;

        case COLUMN_SPACING:
            insert.setColumnSpacing(value.getDoubleValue());

            break;

        case ROW_SPACING:
            insert.setRowSpacing(value.getDoubleValue());

            break;

        case BLOCK_NAME:
            insert.setBlockID(value.getValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, insert);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        insert = new DXFInsert();
    }
}
