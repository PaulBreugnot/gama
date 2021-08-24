/*******************************************************************************************************
 *
 * DXFSplineHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFSpline;
import gama.ext.libs.kabeja.dxf.helpers.SplinePoint;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFSplineHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFSplineHandler extends AbstractEntityHandler {
    
    /** The Constant CONTROL_POINT_X. */
    public static final int CONTROL_POINT_X = 10;
    
    /** The Constant CONTROL_POINT_Y. */
    public static final int CONTROL_POINT_Y = 20;
    
    /** The Constant CONTROL_POINT_Z. */
    public static final int CONTROL_POINT_Z = 30;
    
    /** The Constant FIT_POINT_X. */
    public static final int FIT_POINT_X = 11;
    
    /** The Constant FIT_POINT_Y. */
    public static final int FIT_POINT_Y = 21;
    
    /** The Constant FIT_POINT_Z. */
    public static final int FIT_POINT_Z = 31;
    
    /** The Constant START_TANGENT_X. */
    public static final int START_TANGENT_X = 12;
    
    /** The Constant START_TANGENT_Y. */
    public static final int START_TANGENT_Y = 22;
    
    /** The Constant START_TANGENT_Z. */
    public static final int START_TANGENT_Z = 32;
    
    /** The Constant END_TANGENT_X. */
    public static final int END_TANGENT_X = 13;
    
    /** The Constant END_TANGENT_Y. */
    public static final int END_TANGENT_Y = 23;
    
    /** The Constant END_TANGENT_Z. */
    public static final int END_TANGENT_Z = 33;
    
    /** The Constant FIT_TOLERANCE. */
    public static final int FIT_TOLERANCE = 44;
    
    /** The Constant KNOTS. */
    public static final int KNOTS = 40;
    
    /** The Constant WEIGHTS. */
    public static final int WEIGHTS = 41;
    
    /** The Constant CONTROLPOINT_TOLERANCE. */
    public static final int CONTROLPOINT_TOLERANCE = 42;
    
    /** The Constant KNOT_TOLERANCE. */
    public static final int KNOT_TOLERANCE = 43;
    
    /** The Constant NUMBER_OF_FIT_POINTS. */
    public static final int NUMBER_OF_FIT_POINTS = 74;
    
    /** The Constant NUMBER_OF_CONTROL_POINTS. */
    public static final int NUMBER_OF_CONTROL_POINTS = 73;
    
    /** The Constant NUMBER_OF_CONTROL_POINTS2. */
    public static final int NUMBER_OF_CONTROL_POINTS2 = 96;
    
    /** The Constant NUMBER_OF_NODES. */
    public static final int NUMBER_OF_NODES = 72;
    
    /** The Constant NUMBER_OF_NODES2. */
    public static final int NUMBER_OF_NODES2 = 95;
    
    /** The Constant DEGREE. */
    public static final int DEGREE = 71;
    
    /** The spline. */
    private DXFSpline spline;
    
    /** The point. */
    private SplinePoint point;
    
    /** The knots. */
    private double[] knots;
    
    /** The weights. */
    private double[] weights;
    
    /** The knots count. */
    private int knotsCount;
    
    /** The control point count. */
    private int controlPointCount;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_SPLINE;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
        spline.setKnots(knots);
        spline.setWeights(weights);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return spline;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
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
        case DEGREE:
            spline.setDegree(value.getIntegerValue());

            break;

        case NUMBER_OF_CONTROL_POINTS:
            weights = new double[value.getIntegerValue()];
            controlPointCount = 0;
            spline.setControlPointSize(value.getIntegerValue());

            break;

        case NUMBER_OF_FIT_POINTS:
            spline.setFitPointSize(value.getIntegerValue());

            break;

        case NUMBER_OF_NODES:
            knots = new double[value.getIntegerValue()];
            knotsCount = 0;
            spline.setNodePointsSize(value.getIntegerValue());

            break;

        case NUMBER_OF_NODES2:
            knots = new double[value.getIntegerValue()];
            knotsCount = 0;
            spline.setNodePointsSize(value.getIntegerValue());

            break;

        case FIT_TOLERANCE:
            spline.setFitTolerance(value.getDoubleValue());

            break;

        case KNOTS:
            knots[knotsCount] = value.getDoubleValue();
            knotsCount++;

            break;

        case KNOT_TOLERANCE:
            spline.setKnotsTolerance(value.getDoubleValue());

            break;

        case WEIGHTS:
            weights[controlPointCount] = value.getDoubleValue();
            controlPointCount++;

            break;

        case CONTROLPOINT_TOLERANCE:
            spline.setControlPointTolerance(value.getDoubleValue());

            break;

        case FIT_POINT_X:
            point = new SplinePoint();
            point.setType(SplinePoint.TYPE_FITPOINT);
            point.setX(value.getDoubleValue());
            spline.addSplinePoint(point);

            break;

        case FIT_POINT_Y:
            point.setY(value.getDoubleValue());

            break;

        case FIT_POINT_Z:
            point.setZ(value.getDoubleValue());

            break;

        case CONTROL_POINT_X:
            point = new SplinePoint();
            point.setType(SplinePoint.TYPE_CONTROLPOINT);
            point.setX(value.getDoubleValue());
            spline.addSplinePoint(point);

            break;

        case CONTROL_POINT_Y:
            point.setY(value.getDoubleValue());

            break;

        case CONTROL_POINT_Z:
            point.setZ(value.getDoubleValue());

            break;

        case START_TANGENT_X:
            point = new SplinePoint();
            point.setType(SplinePoint.TYPE_STARTTANGENT);
            point.setX(value.getDoubleValue());
            spline.addSplinePoint(point);

            break;

        case START_TANGENT_Y:
            point.setY(value.getDoubleValue());

            break;

        case START_TANGENT_Z:
            point.setZ(value.getDoubleValue());

            break;

        case END_TANGENT_X:
            point = new SplinePoint();
            point.setType(SplinePoint.TYPE_ENDTANGENT);
            point.setX(value.getDoubleValue());
            spline.addSplinePoint(point);

            break;

        case END_TANGENT_Y:
            point.setY(value.getDoubleValue());

            break;

        case END_TANGENT_Z:
            point.setZ(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, spline);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        spline = new DXFSpline();
    }
}
