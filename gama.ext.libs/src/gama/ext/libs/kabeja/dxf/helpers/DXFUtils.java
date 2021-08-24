/*******************************************************************************************************
 *
 * DXFUtils.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import java.util.ArrayList;

import gama.ext.libs.kabeja.dxf.DXFLine;
import gama.ext.libs.kabeja.dxf.DXFPolyline;
import gama.ext.libs.kabeja.dxf.DXFVertex;
import gama.ext.libs.kabeja.math.MathUtils;


/**
 * The Class DXFUtils.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFUtils {
    
    /**
     * Instantiates a new DXF utils.
     */
    public DXFUtils() {
        super();
    }

    /**
     * Distance.
     *
     * @param start the start
     * @param end the end
     * @return the double
     */
    public static double distance(Point start, Point end) {
        double length;
        length = Math.sqrt(Math.pow((end.getX() - start.getX()), 2) +
                Math.pow((end.getY() - start.getY()), 2));

        return length;
    }

    /**
     * Rotate angle X.
     *
     * @param start the start
     * @param end the end
     * @return the double
     */
    public static double rotateAngleX(Point start, Point end) {
        if (end.getY() == start.getY()) {
            return 0.0;
        }

        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();

        return Math.toDegrees(Math.atan(1 / (dy / dx)));
    }

    /**
     * Vector value.
     *
     * @param x the x
     * @return the double
     */
    public static double vectorValue(double[] x) {
        double v = 0.0;

        for (int i = 0; i < x.length; i++) {
            v += (x[i] * x[i]);
        }

        return Math.sqrt(v);
    }

    /**
     * Scale point.
     *
     * @param p the p
     * @param scale the scale
     * @return the point
     */
    public static Point scalePoint(Point p, double scale) {
        Point r = new Point();
        r.setX(p.getX() * scale);
        r.setY(p.getY() * scale);
        r.setZ(p.getZ() * scale);

        return r;
    }

    /**
     * Gets the point from parameterized line.
     *
     * @param basePoint the base point
     * @param direction the direction
     * @param parameter the parameter
     * @return the point from parameterized line
     */
    public static Point getPointFromParameterizedLine(Point basePoint,
        Vector direction, double parameter) {
        Point r = scalePoint(direction, parameter);

        r.setX(r.getX() + basePoint.getX());
        r.setY(r.getY() + basePoint.getY());
        r.setZ(r.getZ() + basePoint.getZ());

        return r;
    }

    /**
     * Reverse DXF line.
     *
     * @param line the line
     */
    public static void reverseDXFLine(DXFLine line) {
        Point start = line.getStartPoint();
        line.setStartPoint(line.getEndPoint());
        line.setEndPoint(start);
    }

    /**
     * Reverse DXF polyline.
     *
     * @param pline the pline
     */
    public static void reverseDXFPolyline(DXFPolyline pline) {
        ArrayList list = new ArrayList();
        double bulge = 0;
        int size = pline.getVertexCount();

        for (int i = 0; i < size; i++) {
            DXFVertex v = pline.getVertex(0);
            double b = v.getBulge();

            if (b != 0) {
                v.setBulge(0);
            }

            //the predecessor becomes the reversed bulge
            if (bulge != 0.0) {
                v.setBulge(bulge * (-1.0));
            }

            bulge = b;

            list.add(v);
            pline.removeVertex(0);
        }

        // reverse now
        for (int i = 1; i <= size; i++) {
            pline.addVertex((DXFVertex) list.get(size - i));
        }
    }

    /**
     * Gets the arc radius.
     *
     * @param start the start
     * @param end the end
     * @return the arc radius
     */
    public static double getArcRadius(DXFVertex start, DXFVertex end) {
        double alpha = 4 * Math.atan(Math.abs(start.getBulge()));
        double l = MathUtils.distance(start.getPoint(), end.getPoint());
        double r = l / (2 * Math.sin(alpha / 2));

        return r;
    }

    /**
     * Tests if the two points are the same for a given radius. In other words
     * the distance between the two points is lower then the radius.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @param radius the radius
     * @return true, if successful
     */
    public static boolean equals(Point p1, Point p2, double radius) {
        return distance(p1, p2) < radius;

        // if (Math.abs(p1.getX() - p2.getX()) <= radius
        // && Math.abs(p1.getY() - p2.getY()) <= radius)
        // return Math.abs(p1.getZ() - p2.getZ()) <= radius;

        // return false;
    }
}
