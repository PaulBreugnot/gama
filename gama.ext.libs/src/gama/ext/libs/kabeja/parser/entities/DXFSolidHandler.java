/*******************************************************************************************************
 *
 * DXFSolidHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFSolid;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFSolidHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFSolidHandler extends AbstractEntityHandler {
    
    /** The Constant POINT2_X. */
    public final static int POINT2_X = 11;
    
    /** The Constant POINT2_Y. */
    public final static int POINT2_Y = 21;
    
    /** The Constant POINT2_Z. */
    public final static int POINT2_Z = 31;
    
    /** The Constant POINT3_X. */
    public final static int POINT3_X = 12;
    
    /** The Constant POINT3_Y. */
    public final static int POINT3_Y = 22;
    
    /** The Constant POINT3_Z. */
    public final static int POINT3_Z = 32;
    
    /** The Constant POINT4_X. */
    public final static int POINT4_X = 13;
    
    /** The Constant POINT4_Y. */
    public final static int POINT4_Y = 23;
    
    /** The Constant POINT4_Z. */
    public final static int POINT4_Z = 33;
    
    /** The entity name. */
    protected String ENTITY_NAME = "SOLID";
    
    /** The solid. */
    protected DXFSolid solid;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return solid;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
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
        //point 1
        case GROUPCODE_START_X:
            solid.getPoint1().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            solid.getPoint1().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            solid.getPoint1().setZ(value.getDoubleValue());

            break;

        //point 2
        case POINT2_X:
            solid.getPoint2().setX(value.getDoubleValue());

            break;

        case POINT2_Y:
            solid.getPoint2().setY(value.getDoubleValue());

            break;

        case POINT2_Z:
            solid.getPoint2().setZ(value.getDoubleValue());

            break;

        //point 3
        case POINT3_X:
            solid.getPoint3().setX(value.getDoubleValue());

            break;

        case POINT3_Y:
            solid.getPoint3().setY(value.getDoubleValue());

            break;

        case POINT3_Z:
            solid.getPoint3().setZ(value.getDoubleValue());

            break;

        //point 4
        case POINT4_X:
            solid.getPoint4().setX(value.getDoubleValue());

            break;

        case POINT4_Y:
            solid.getPoint4().setY(value.getDoubleValue());

            break;

        case POINT4_Z:
            solid.getPoint4().setZ(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, solid);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        solid = new DXFSolid();
    }
}
