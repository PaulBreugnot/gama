/*******************************************************************************************************
 *
 * Point.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class Point.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class Point {
    
    /** The x. */
    protected double x = 0.0;
    
    /** The y. */
    protected double y = 0.0;
    
    /** The z. */
    protected double z = 0.0;

    /**
     * Instantiates a new point.
     */
    public Point() {
    }

    /**
     * Instantiates a new point.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the x.
     *
     * @return Returns the x.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x.
     *
     * @param x            The x to set.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y.
     *
     * @return Returns the y.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y.
     *
     * @param y            The y to set.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the z.
     *
     * @return Returns the z.
     */
    public double getZ() {
        return z;
    }

    /**
     * Sets the z.
     *
     * @param z            The z to set.
     */
    public void setZ(double z) {
        this.z = z;
    }

    public String toString() {
        return super.toString() + "[" + this.x + "," + this.y + "," + this.z +
        "]";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point) obj;
            double d = DXFConstants.POINT_CONNECTION_RADIUS;

            if ((Math.abs(x - p.getX()) <= d) && (Math.abs(y - p.getY()) <= d)) {
                return Math.abs(z - p.getZ()) <= d;
            }
        }

        return false;
    }
}
