/*******************************************************************************************************
 *
 * DXFDimensionHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFDimension;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFDimensionHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFDimensionHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_REFERENCE_POINT_X. */
    protected final static int GROUPCODE_REFERENCE_POINT_X = 10;
    
    /** The Constant GROUPCODE_REFERENCE_POINT_Y. */
    protected final static int GROUPCODE_REFERENCE_POINT_Y = 20;
    
    /** The Constant GROUPCODE_REFERENCE_POINT_Z. */
    protected final static int GROUPCODE_REFERENCE_POINT_Z = 30;
    
    /** The Constant GROUPCODE_TEXT_POINT_X. */
    protected final static int GROUPCODE_TEXT_POINT_X = 11;
    
    /** The Constant GROUPCODE_TEXT_POINT_Y. */
    protected final static int GROUPCODE_TEXT_POINT_Y = 21;
    
    /** The Constant GROUPCODE_TEXT_POINT_Z. */
    protected final static int GROUPCODE_TEXT_POINT_Z = 31;
    
    /** The Constant GROUPCODE_INSERT_POINT_X. */
    protected final static int GROUPCODE_INSERT_POINT_X = 12;
    
    /** The Constant GROUPCODE_INSERT_POINT_Y. */
    protected final static int GROUPCODE_INSERT_POINT_Y = 22;
    
    /** The Constant GROUPCODE_INSERT_POINT_Z. */
    protected final static int GROUPCODE_INSERT_POINT_Z = 32;
    
    /** The Constant GROUPCODE_REFERENCE_POINT3_X. */
    protected final static int GROUPCODE_REFERENCE_POINT3_X = 13;
    
    /** The Constant GROUPCODE_REFERENCE_POINT3_Y. */
    protected final static int GROUPCODE_REFERENCE_POINT3_Y = 23;
    
    /** The Constant GROUPCODE_REFERENCE_POINT3_Z. */
    protected final static int GROUPCODE_REFERENCE_POINT3_Z = 33;
    
    /** The Constant GROUPCODE_REFERENCE_POINT4_X. */
    protected final static int GROUPCODE_REFERENCE_POINT4_X = 14;
    
    /** The Constant GROUPCODE_REFERENCE_POINT4_Y. */
    protected final static int GROUPCODE_REFERENCE_POINT4_Y = 24;
    
    /** The Constant GROUPCODE_REFERENCE_POINT4_Z. */
    protected final static int GROUPCODE_REFERENCE_POINT4_Z = 34;
    
    /** The Constant GROUPCODE_REFERENCE_POINT5_X. */
    protected final static int GROUPCODE_REFERENCE_POINT5_X = 15;
    
    /** The Constant GROUPCODE_REFERENCE_POINT5_Y. */
    protected final static int GROUPCODE_REFERENCE_POINT5_Y = 25;
    
    /** The Constant GROUPCODE_REFERENCE_POINT5_Z. */
    protected final static int GROUPCODE_REFERENCE_POINT5_Z = 35;
    
    /** The Constant GROUPCODE_REFERENCE_POINT6_X. */
    protected final static int GROUPCODE_REFERENCE_POINT6_X = 16;
    
    /** The Constant GROUPCODE_REFERENCE_POINT6_Y. */
    protected final static int GROUPCODE_REFERENCE_POINT6_Y = 26;
    
    /** The Constant GROUPCODE_REFERENCE_POINT6_Z. */
    protected final static int GROUPCODE_REFERENCE_POINT6_Z = 36;
    
    /** The Constant GROUPCODE_DIMENSION_STYLE. */
    protected final static int GROUPCODE_DIMENSION_STYLE = 3;
    
    /** The Constant GROUPCODE_DIMENSION_BLOCK. */
    protected final static int GROUPCODE_DIMENSION_BLOCK = 2;
    
    /** The Constant GROUPCODE_DIMENSION_AREA. */
    protected final static int GROUPCODE_DIMENSION_AREA = 67;
    
    /** The Constant GROUPCODE_DIMENSION_TEXT. */
    protected final static int GROUPCODE_DIMENSION_TEXT = 1;
    
    /** The Constant GROUPCODE_LEADINGLINE_LENGTH. */
    protected final static int GROUPCODE_LEADINGLINE_LENGTH = 40;
    
    /** The Constant GROUPCODE_DIMENSION_ROTATE. */
    protected final static int GROUPCODE_DIMENSION_ROTATE = 50;
    
    /** The Constant GROUPCODE_HORIZONTAL_ALIGNMENT. */
    protected final static int GROUPCODE_HORIZONTAL_ALIGNMENT = 51;
    
    /** The Constant GROUPCODE_INCLINATION_HELPLINE. */
    protected final static int GROUPCODE_INCLINATION_HELPLINE = 52;
    
    /** The Constant GROUPCODE_TEXT_ROTATION. */
    protected final static int GROUPCODE_TEXT_ROTATION = 53;
    
    /** The Constant GROUPCODE_DIMENSION_TYPE. */
    protected final static int GROUPCODE_DIMENSION_TYPE = 70;
    
    /** The entity name. */
    protected String ENTITY_NAME = "DIMENSION";
    
    /** The dimension. */
    protected DXFDimension dimension;

    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return dimension;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        // TODO Auto-generated method stub
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_TEXT_POINT_X:
            dimension.getTextPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_POINT_Y:
            dimension.getTextPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_POINT_Z:
            dimension.getTextPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_INSERT_POINT_X:
            dimension.getInsertPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_INSERT_POINT_Y:
            dimension.getInsertPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_INSERT_POINT_Z:
            dimension.getInsertPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT_X:
            dimension.getReferencePoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT_Y:
            dimension.getReferencePoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT_Z:
            dimension.getReferencePoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT3_X:
            dimension.getReferencePoint3().setX(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT3_Y:
            dimension.getReferencePoint3().setY(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT3_Z:
            dimension.getReferencePoint3().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT4_X:
            dimension.getReferencePoint4().setX(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT4_Y:
            dimension.getReferencePoint4().setY(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT4_Z:
            dimension.getReferencePoint4().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT5_X:
            dimension.getReferencePoint5().setX(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT5_Y:
            dimension.getReferencePoint5().setY(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT5_Z:
            dimension.getReferencePoint5().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT6_X:
            dimension.getReferencePoint6().setX(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT6_Y:
            dimension.getReferencePoint6().setY(value.getDoubleValue());

            break;

        case GROUPCODE_REFERENCE_POINT6_Z:
            dimension.getReferencePoint6().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_DIMENSION_BLOCK:
            dimension.setDimensionBlock(value.getValue());

            break;

        case GROUPCODE_DIMENSION_STYLE:
            dimension.setDimensionStyleID(value.getValue());

            break;

        case GROUPCODE_DIMENSION_TYPE:
            dimension.setDimensionType(value.getIntegerValue());

            break;

        case GROUPCODE_DIMENSION_TEXT:
            dimension.setDimensionText(value.getValue());

            break;

        case GROUPCODE_HORIZONTAL_ALIGNMENT:
            dimension.setHorizontalAlign(value.getDoubleValue());

            break;

        case GROUPCODE_INCLINATION_HELPLINE:
            dimension.setInclinationHelpLine(value.getDoubleValue());

            break;

        case GROUPCODE_LEADINGLINE_LENGTH:
            dimension.setLeadingLineLength(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_ROTATION:
            dimension.setTextRotation(value.getDoubleValue());

            break;

        case GROUPCODE_DIMENSION_ROTATE:
            dimension.setDimensionRotation(value.getDoubleValue());

            break;

        case GROUPCODE_DIMENSION_AREA:
            dimension.setDimensionArea(value.getIntegerValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, dimension);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        dimension = new DXFDimension();
    }
}
