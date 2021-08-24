/*******************************************************************************************************
 *
 * DXFShapeHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFShape;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFShapeHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFShapeHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_NAME. */
    public final static int GROUPCODE_NAME = 2;
    
    /** The Constant GROUPCODE_SIZE. */
    public final static int GROUPCODE_SIZE = 40;
    
    /** The Constant GROUPCODE_SCALE_X. */
    public final static int GROUPCODE_SCALE_X = 41;
    
    /** The Constant GROUPCODE_OBLIQUE_ANGLE. */
    public final static int GROUPCODE_OBLIQUE_ANGLE = 51;
    
    /** The shape. */
    protected DXFShape shape;

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_SHAPE;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return shape;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            shape.getInsertPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            shape.getInsertPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            shape.getInsertPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_OBLIQUE_ANGLE:
            shape.setObliqueAngle(value.getDoubleValue());

            break;

        case GROUPCODE_ROTATION_ANGLE:
            shape.setRotation(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            shape.setName(value.getValue());

            break;

        case GROUPCODE_SIZE:
            shape.setHeight(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, shape);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        shape = new DXFShape();
    }
}
