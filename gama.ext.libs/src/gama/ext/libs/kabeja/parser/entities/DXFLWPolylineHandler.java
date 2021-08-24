/*******************************************************************************************************
 *
 * DXFLWPolylineHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFLWPolyline;
import gama.ext.libs.kabeja.dxf.DXFVertex;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFLWPolylineHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFLWPolylineHandler extends AbstractEntityHandler {
    
    /** The Constant ENTITY_NAME. */
    public static final String ENTITY_NAME = "LWPOLYLINE";
    
    /** The Constant VERTEX_BULGE. */
    public static final int VERTEX_BULGE = 42;
    
    /** The Constant START_WIDTH. */
    public static final int START_WIDTH = 40;
    
    /** The Constant END_WIDTH. */
    public static final int END_WIDTH = 41;
    
    /** The Constant CONSTANT_WIDTH. */
    public static final int CONSTANT_WIDTH = 43;
    
    /** The Constant ELEVATION. */
    public static final int ELEVATION = 38;
    
    /** The Constant THICKNESS. */
    public static final int THICKNESS = 39;
    
    /** The vertex. */
    private DXFVertex vertex;
    
    /** The lwpolyline. */
    private DXFLWPolyline lwpolyline;

    /**
     * Instantiates a new DXFLW polyline handler.
     */
    public DXFLWPolylineHandler() {
        super();
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
        return lwpolyline;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        // the different between polyline and lwpolyline is,
        // that the vertices comes not as sequence here.
        switch (groupCode) {
        case GROUPCODE_START_X:
            // every new vertex starts with 10
            createVertex();
            vertex.setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            vertex.setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            vertex.setZ(value.getDoubleValue());

            break;

        case VERTEX_BULGE:
            vertex.setBulge(value.getDoubleValue());

            break;

        case START_WIDTH:
            vertex.setStartWidth(value.getDoubleValue());

            break;

        case END_WIDTH:
            vertex.setEndWidth(value.getDoubleValue());

            break;

        case CONSTANT_WIDTH:
            lwpolyline.setConstantWidth(value.getDoubleValue());

            break;

        case ELEVATION:
            lwpolyline.setElevation(value.getDoubleValue());

            break;

        case THICKNESS:
            lwpolyline.setThickness(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, lwpolyline);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        lwpolyline = new DXFLWPolyline();
    }

    /**
     * Creates the vertex.
     */
    private void createVertex() {
        vertex = new DXFVertex();
        vertex.setDXFDocument(doc);
        lwpolyline.addVertex(vertex);
    }
}
