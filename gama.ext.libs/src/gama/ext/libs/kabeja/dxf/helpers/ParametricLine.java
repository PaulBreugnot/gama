/*******************************************************************************************************
 *
 * ParametricLine.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import gama.ext.libs.kabeja.math.MathUtils;


/**
 * The Class ParametricLine.
 */
public class ParametricLine {
    
    /** The start point. */
    protected Point startPoint;
    
    /** The direction. */
    protected Vector direction;

    /**
     * Instantiates a new parametric line.
     *
     * @param startPoint the start point
     * @param direction the direction
     */
    public ParametricLine(Point startPoint, Vector direction) {
        this.startPoint = startPoint;
        this.direction = direction;
    }

    /**
     * Instantiates a new parametric line.
     *
     * @param start the start
     * @param end the end
     */
    public ParametricLine(Point start, Point end) {
        this.startPoint = start;
        this.direction = MathUtils.getVector(start, end);
    }

    /**
     * Instantiates a new parametric line.
     */
    public ParametricLine() {
        this(new Point(), new Point());
    }

    /**
     * Gets the intersection parameter.
     *
     * @param line the line
     * @return the intersection parameter
     */
    public double getIntersectionParameter(ParametricLine line) {
        Vector n = MathUtils.crossProduct(this.direction,
                line.getDirectionVector());

        if (MathUtils.absoluteValue(n) == 0.0) {
            //System.out.println("parallel");
            return Double.POSITIVE_INFINITY;
        }

        Vector m = MathUtils.crossProduct(MathUtils.getVector(this.startPoint,
                    line.getStartPoint()), line.getDirectionVector());
        double s = 0;

        if (n.getX() != 0.0) {
            s = m.getX() / n.getX();
        } else if (n.getY() != 0.0) {
            s = m.getY() / n.getY();
        } else if (n.getZ() != 0.0) {
            s = m.getZ() / n.getZ();
        }

        return s;
    }

    /**
     * Gets the start point.
     *
     * @return the start point
     */
    public Point getStartPoint() {
        return this.startPoint;
    }

    /**
     * Sets the start point.
     *
     * @param start the new start point
     */
    public void setStartPoint(Point start) {
        this.startPoint = start;
    }

    /**
     * Gets the direction vector.
     *
     * @return the direction vector
     */
    public Vector getDirectionVector() {
        return this.direction;
    }

    /**
     * Sets the direction vector.
     *
     * @param v the new direction vector
     */
    public void setDirectionVector(Vector v) {
        this.direction = v;
    }

    /**
     * Gets the point at.
     *
     * @param para the para
     * @return the point at
     */
    public Point getPointAt(double para) {
        return MathUtils.getPointOfStraightLine(this.startPoint,
            this.direction, para);
    }

    /**
     * Gets the parameter.
     *
     * @param p the p
     * @return the parameter
     */
    public double getParameter(Point p) {
        double t = 0;

        if (this.direction.getX() != 0) {
            t = (p.getX() - this.startPoint.getX()) / this.direction.getX();
        } else if (this.direction.getY() != 0.0) {
            t = (p.getY() - this.startPoint.getY()) / this.direction.getY();
        } else if (this.direction.getZ() != 0.0) {
            t = (p.getZ() - this.startPoint.getZ()) / this.direction.getZ();
        }

        return t;
    }
}
