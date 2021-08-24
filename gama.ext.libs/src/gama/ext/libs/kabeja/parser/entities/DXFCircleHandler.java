/*******************************************************************************************************
 *
 * DXFCircleHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFCircle;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFCircleHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFCircleHandler extends AbstractEntityHandler {
    
    /** The Constant ENTITY_NAME. */
    public final static String ENTITY_NAME = "CIRCLE";
    
    /** The Constant RADIUS. */
    public final static int RADIUS = 40;
    
    /** The circle. */
    private DXFCircle circle;

    /**
     * Instantiates a new DXF circle handler.
     */
    public DXFCircleHandler() {
        super();

        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#endParsing()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntity()
     */
    public DXFEntity getDXFEntity() {
        return circle;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        // TODO Auto-generated method stub
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            circle.getCenterPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            circle.getCenterPoint().setY(value.getDoubleValue());

            break;

        case RADIUS:
            circle.setRadius(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, circle);

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        circle = new DXFCircle();
        circle.setCenterPoint(new Point());
        circle.setDXFDocument(doc);
    }

    /* (non-Javadoc)
     * @see org.dxf2svg.parser.entities.EntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }
}
