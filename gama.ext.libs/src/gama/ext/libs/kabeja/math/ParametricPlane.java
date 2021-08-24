/*******************************************************************************************************
 *
 * ParametricPlane.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.math;

import gama.ext.libs.kabeja.dxf.DXFExtrusion;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.helpers.Vector;


/**
 * The Class ParametricPlane.
 */
public class ParametricPlane {
    
    /** The base. */
    protected Point base;
    
    /** The direction X. */
    protected Vector directionX;
    
    /** The direction Y. */
    protected Vector directionY;
    
    /** The normal. */
    protected Vector normal;

    /**
     * Instantiates a new parametric plane.
     *
     * @param basePoint            The base point of this plane
     * @param directionX            the x direction of this plane
     * @param directionY            the y direction of this plane
     * @param normal            the normal direction of this plane
     */
    public ParametricPlane(Point basePoint, Vector directionX,
        Vector directionY, Vector normal) {
        this.base = basePoint;
        this.directionX = directionX;
        this.directionY = directionY;
        this.normal = normal;
    }

    /**
     * Instantiates a new parametric plane.
     *
     * @param basePoint            The base point of this plane
     * @param directionX            the x direction of this plane
     * @param directionY            the y direction of this plane
     */
    public ParametricPlane(Point basePoint, Vector directionX, Vector directionY) {
        this(basePoint, directionX, directionY,
            MathUtils.normalize(MathUtils.crossProduct(directionX, directionY)));
    }

    /**
     * Generates a plane with the base point and uses the vector from base point
     * to b as x direction. The y direction is generated with the cross product
     * of the normal with the x direction.
     *
     * @param basePoint the base point
     * @param b the b
     * @param normal the normal
     */
    public ParametricPlane(Point basePoint, Point b, Vector normal) {
        this(basePoint, MathUtils.normalize(MathUtils.getVector(basePoint, b)),
            MathUtils.normalize(MathUtils.crossProduct(normal,
                    MathUtils.normalize(MathUtils.getVector(basePoint, b)))),
            normal);
    }

    /**
     * Instantiates a new parametric plane.
     *
     * @param basePoint the base point
     * @param b the b
     * @param c the c
     */
    public ParametricPlane(Point basePoint, Point b, Point c) {
        this(basePoint, MathUtils.normalize(MathUtils.getVector(basePoint, b)),
            MathUtils.normalize(MathUtils.getVector(basePoint, c)));
    }

    /**
     * Instantiates a new parametric plane.
     *
     * @param e the e
     */
    public ParametricPlane(DXFExtrusion e) {
        this(new Point(0.0, 0.0, 0.0), e.getDirectionX(), e.getDirectionY(),
            e.getNormal());
    }

    /**
     * Calculate the point in world coordinates for the given parameters.
     *
     * @param x the x
     * @param y the y
     * @return the point
     */
    public Point getPoint(double x, double y) {
        Point p = new Point();
        p.setX(this.base.getX() + (this.directionX.getX() * x) +
            (this.directionY.getX() * y));
        p.setY(this.base.getY() + (this.directionX.getY() * x) +
            (this.directionY.getY() * y));
        p.setZ(this.base.getZ() + (this.directionX.getZ() * x) +
            (this.directionY.getZ() * y));

        return p;
    }

    /**
     * Gets the point.
     *
     * @param point the point
     * @return the point
     */
    public Point getPoint(Point point) {
        return getPoint(point.getX(), point.getY());
    }

    /**
     * Calculates the plane parameters of the given point relative to the base
     * point of the plane.
     *
     * @param p the p
     * @return double[]{parameter x direction, parameter y direction}
     */
    public double[] getParameter(Point p) {
        double u = 0.0;
        double v = (this.directionX.getY() * this.directionY.getX()) -
            (this.directionX.getX() * this.directionY.getY());

        if (v != 0.0) {
            v = ((p.getY() * this.directionY.getX()) -
                (this.base.getY() * this.directionY.getX()) -
                (this.directionY.getY() * p.getX()) +
                (this.base.getX() * this.directionY.getY())) / v;
        }

        if (this.directionY.getX() != 0.0) {
            u = (p.getX() - this.base.getX() - (this.directionX.getX() * v)) / this.directionY.getX();
        } else if (this.directionY.getY() != 0.0) {
            u = (p.getY() - this.base.getY() - (this.directionX.getY() * v)) / this.directionY.getY();
        } else if (this.directionY.getY() != 0.0) {
            u = (p.getZ() - this.base.getZ() - (this.directionX.getZ() * v)) / this.directionY.getZ();
        }

        return new double[] { v, u };
    }

    /**
     * Determines if the given point lies on the plane.
     *
     * @param p
     *            the point to determine
     * @return true if the point lies on the plane, otherwise false.
     */
    public boolean isOnPlane(Point p) {
        double[] para = this.getParameter(p);
        double v = this.base.getZ() + (this.directionX.getZ() * para[0]) +
            (this.directionY.getZ() * para[1]);

        if (!(Math.abs((p.getZ() - v)) < MathUtils.DISTANCE_DELTA)) {
            return false;
        }

        v = this.base.getY() + (this.directionX.getY() * para[0]) +
            (this.directionY.getY() * para[1]);

        if (!(Math.abs((p.getY() - v)) < MathUtils.DISTANCE_DELTA)) {
            return false;
        }

        v = this.base.getX() + (this.directionX.getX() * para[0]) +
            (this.directionY.getX() * para[1]);

        if (!(Math.abs((p.getX() - v)) < MathUtils.DISTANCE_DELTA)) {
            return false;
        }

        return true;
    }

    /**
     * Gets the base point.
     *
     * @return the base point
     */
    public Point getBasePoint() {
        return base;
    }

    /**
     * Sets the base point.
     *
     * @param base the new base point
     */
    public void setBasePoint(Point base) {
        this.base = base;
    }

    /**
     * Gets the direction X.
     *
     * @return the direction X
     */
    public Vector getDirectionX() {
        return directionX;
    }

    /**
     * Sets the direction X.
     *
     * @param directionX the new direction X
     */
    public void setDirectionX(Vector directionX) {
        this.directionX = directionX;
        this.normal = MathUtils.crossProduct(this.directionX, this.directionY);
        this.normal.normalize();
    }

    /**
     * Gets the direction Y.
     *
     * @return the direction Y
     */
    public Vector getDirectionY() {
        return directionY;
    }

    /**
     * Sets the direction Y.
     *
     * @param directionY the new direction Y
     */
    public void setDirectionY(Vector directionY) {
        this.directionY = directionY;
        this.normal = MathUtils.crossProduct(this.directionX, this.directionY);
        this.normal.normalize();
    }

    /**
     * Gets the normal.
     *
     * @return the normal
     */
    public Vector getNormal() {
        return normal;
    }
}
