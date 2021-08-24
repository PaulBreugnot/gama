/*******************************************************************************************************
 *
 * DXFExtrusion.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.helpers.Vector;
import gama.ext.libs.kabeja.math.MathUtils;


/**
 * This class implements the arbitrary axis algorithm to extract the
 * direction x,y,z of the plane defined by the extrusion.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFExtrusion {
    
    /** The Constant v. */
    private final static double v = 1.0 / 64.0;
    
    /** The n. */
    protected Vector n = new Vector(0.0, 0.0, 1.0);
    
    /** The x. */
    protected Vector x;
    
    /** The y. */
    protected Vector y;

    /**
     * Gets the x.
     *
     * @return the x value of the extrusion direction.
     */
    public double getX() {
        return n.getX();
    }

    /**
     * Set the x value of the extrusion direction.
     *
     * @param x the new x
     */
    public void setX(double x) {
        n.setX(x);
    }

    /**
     * Gets the y.
     *
     * @return the y value of the extrusion direction.
     */
    public double getY() {
        return n.getY();
    }

    /**
     * Set the x value of the extrusion direction.
     *
     * @param y the new y
     */
    public void setY(double y) {
        n.setY(y);
    }

    /**
     * Gets the z.
     *
     * @return the z value of the extrusion direction.
     */
    public double getZ() {
        return n.getZ();
    }

    /**
     * Set the x value of the extrusion direction.
     *
     * @param z the new z
     */
    public void setZ(double z) {
        n.setZ(z);
    }

    /**
     * Calculate and returns the x direction of the plane.
     *
     * @return the direction X
     */
    public Vector getDirectionX() {
        if ((Math.abs(n.getX()) < v) && (Math.abs(n.getY()) < v)) {
            return MathUtils.crossProduct(DXFConstants.DEFAULT_Y_AXIS_VECTOR, n);
        } else {
            return MathUtils.crossProduct(DXFConstants.DEFAULT_Z_AXIS_VECTOR, n);
        }
    }

    /**
     * Calculate the y direction of the plane.
     * @return the calculate y direction
     */
    public Vector getDirectionY() {
        return MathUtils.crossProduct(n, getDirectionX());
    }

    /**
     * Extrude point.
     *
     * @param basePoint the base point
     * @param elevation the elevation
     * @return the point
     */
    public Point extrudePoint(Point basePoint, double elevation) {
        return MathUtils.getPointOfStraightLine(basePoint, this.n, elevation);
    }

    /**
     * Return the normal direction of the plane.
     *
     * @return the normal
     */
    public Vector getNormal() {
        return n;
    }

    /**
     * Gets the direction Z.
     *
     * @return the direction Z
     * @see getNormal()
     */
    public Vector getDirectionZ() {
        return n;
    }
}
