/*******************************************************************************************************
 *
 * DXFPolylineHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFPolyline;
import gama.ext.libs.kabeja.dxf.DXFVertex;
import gama.ext.libs.kabeja.parser.DXFEntitiesSectionHandler;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFPolylineHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth </a>
 */
public class DXFPolylineHandler extends AbstractEntityHandler {
    
    /** The Constant ENTITY_NAME. */
    public static final String ENTITY_NAME = "POLYLINE";
    
    /** The Constant ENTITY_VERTEX. */
    public static final String ENTITY_VERTEX = "VERTEX";
    
    /** The Constant END_SEQUENCE. */
    public static final String END_SEQUENCE = "SEQEND";
    
    /** The Constant END_SEQUENCE_CODE. */
    public static final int END_SEQUENCE_CODE = -2;
    
    /** The Constant VERTEX_BULGE. */
    public static final int VERTEX_BULGE = 42;
    
    /** The Constant START_WIDTH. */
    public static final int START_WIDTH = 40;
    
    /** The Constant END_WIDTH. */
    public static final int END_WIDTH = 41;
    
    /** The Constant THICKNESS. */
    public static final int THICKNESS = 39;
    
    /** The Constant SURFACE_TYPE. */
    public static final int SURFACE_TYPE = 75;
    
    /** The Constant SUREFACE_DENSITY_ROW_COUNT. */
    public static final int SUREFACE_DENSITY_ROW_COUNT = 73;
    
    /** The Constant SUREFACE_DENSITY_COLUMN_COUNT. */
    public static final int SUREFACE_DENSITY_COLUMN_COUNT = 74;
    
    /** The Constant ROW_COUNT. */
    public static final int ROW_COUNT = 71;
    
    /** The Constant COLUMN_COUNT. */
    public static final int COLUMN_COUNT = 72;
    
    /** The follow. */
    private boolean follow = true;
    
    /** The parse vertex. */
    private boolean parse_vertex = false;
    
    /** The vertex. */
    private DXFVertex vertex;
    
    /** The polyline. */
    private DXFPolyline polyline;

    /**
     * Instantiates a new DXF polyline handler.
     */
    public DXFPolylineHandler() {
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
        return polyline;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_POLYLINE;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return follow;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        if ((groupCode == END_SEQUENCE_CODE) ||
                END_SEQUENCE.equals(value.getValue())) {
            polyline.addVertex(vertex);
            follow = false;

            return;
        }

        switch (groupCode) {
        case DXFEntitiesSectionHandler.ENTITY_START:

            if (ENTITY_VERTEX.equals(value.getValue())) {
                // store the old before
                if (parse_vertex) {
                    polyline.addVertex(vertex);
                } else {
                    parse_vertex = true;
                }

                vertex = new DXFVertex();
                vertex.setDXFDocument(doc);
            }

            break;

        case GROUPCODE_START_X:

            if (parse_vertex) {
                vertex.setX(value.getDoubleValue());
            }

            break;

        case GROUPCODE_START_Y:

            if (parse_vertex) {
                vertex.setY(value.getDoubleValue());
            }

            break;

        case GROUPCODE_START_Z:

            if (parse_vertex) {
                vertex.setZ(value.getDoubleValue());
            }

            break;

        case VERTEX_BULGE:

            if (parse_vertex) {
                vertex.setBulge(value.getDoubleValue());
            }

            break;

        case START_WIDTH:

            if (parse_vertex) {
                vertex.setStartWidth(value.getDoubleValue());
            } else {
                polyline.setStartWidth(value.getDoubleValue());
            }

            break;

        case END_WIDTH:

            if (parse_vertex) {
                vertex.setEndWidth(value.getDoubleValue());
            } else {
                polyline.setEndWidth(value.getDoubleValue());
            }

            break;

        case THICKNESS:
            polyline.setThickness(value.getDoubleValue());

            break;

        case SURFACE_TYPE:
            polyline.setSurefaceType(value.getIntegerValue());

            break;

        case ROW_COUNT:

            if (parse_vertex) {
                vertex.setPolyFaceMeshVertex0(value.getIntegerValue());
            } else {
                polyline.setRows(value.getIntegerValue());
            }

            break;

        case COLUMN_COUNT:

            if (parse_vertex) {
                vertex.setPolyFaceMeshVertex1(value.getIntegerValue());
            } else {
                polyline.setColumns(value.getIntegerValue());
            }

            break;

        case SUREFACE_DENSITY_ROW_COUNT:

            if (parse_vertex) {
                vertex.setPolyFaceMeshVertex2(value.getIntegerValue());
            } else {
                polyline.setSurefaceDensityRows(value.getIntegerValue());
            }

            break;

        case SUREFACE_DENSITY_COLUMN_COUNT:

            if (parse_vertex) {
                vertex.setPolyFaceMeshVertex3(value.getIntegerValue());
            } else {
                polyline.setSurefaceDensityColumns(value.getIntegerValue());
            }

            break;

        default:

            if (parse_vertex) {
                super.parseCommonProperty(groupCode, value, vertex);
            } else {
                super.parseCommonProperty(groupCode, value, polyline);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        follow = true;
        parse_vertex = false;
        polyline = new DXFPolyline();
    }
}
