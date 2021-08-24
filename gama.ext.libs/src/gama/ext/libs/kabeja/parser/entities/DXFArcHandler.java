/*******************************************************************************************************
 *
 * DXFArcHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFArc;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFArcHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFArcHandler extends AbstractEntityHandler {
    
    /** The Constant ENTITY_NAME. */
    public static final String ENTITY_NAME = "ARC";
    
    /** The Constant RADIUS. */
    public static final int RADIUS = 40;
    
    /** The Constant START_ANGLE. */
    public static final int START_ANGLE = 50;
    
    /** The Constant END_ANGLE. */
    public static final int END_ANGLE = 51;
    
    /** The Constant COUNTERCLOCKWISE. */
    public static final int COUNTERCLOCKWISE = 73;
    
    /** The arc. */
    private DXFArc arc;

    /**
     * Instantiates a new DXF arc handler.
     */
    public DXFArcHandler() {
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
        return arc;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
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
            arc.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            arc.getCenterPoint().setY(value.getDoubleValue());

            break;

        case RADIUS:
            arc.setRadius(value.getDoubleValue());

            break;

        case START_ANGLE:
            arc.setStartAngle(value.getDoubleValue());

            break;

        case END_ANGLE:
            arc.setEndAngle(value.getDoubleValue());

            break;

        case COUNTERCLOCKWISE:
            arc.setCounterClockwise(value.getBooleanValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, arc);

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        arc = new DXFArc();
    }
}
