/*******************************************************************************************************
 *
 * DXFPoint.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class DXFPoint.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFPoint extends DXFEntity {
    
    /** The p. */
    protected Point p = new Point();

    /**
     * Instantiates a new DXF point.
     */
    public DXFPoint() {
    }

    /**
     * Instantiates a new DXF point.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public DXFPoint(double x, double y, double z) {
        this.p.setX(x);
        this.p.setY(y);
        this.p.setZ(z);
    }

    /**
     * Instantiates a new DXF point.
     *
     * @param p the p
     */
    public DXFPoint(Point p) {
        this.p = p;
    }

    /**
     * Gets the x.
     *
     * @return Returns the x.
     */
    public double getX() {
        return this.p.getX();
    }

    /**
     * Sets the x.
     *
     * @param x            The x to set.
     */
    public void setX(double x) {
        this.p.setX(x);
    }

    /**
     * Gets the y.
     *
     * @return Returns the y.
     */
    public double getY() {
        return this.p.getY();
    }

    /**
     * Sets the y.
     *
     * @param y            The y to set.
     */
    public void setY(double y) {
        this.p.setY(y);
    }

    /**
     * Gets the z.
     *
     * @return Returns the z.
     */
    public double getZ() {
        return this.p.getZ();
    }

    /**
     * Sets the z.
     *
     * @param z            The z to set.
     */
    public void setZ(double z) {
        this.p.setZ(z);
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.addToBounds(p);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_POINT;
    }

    /**
     * Gets the point.
     *
     * @return the point
     */
    public Point getPoint() {
        return this.p;
    }

    /**
     * Sets the point.
     *
     * @param p the new point
     */
    public void setPoint(Point p) {
        this.p = p;
    }

    public double getLength() {
        // a point has no length
        return 0;
    }
}
