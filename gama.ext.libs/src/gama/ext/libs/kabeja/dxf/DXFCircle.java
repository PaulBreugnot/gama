/*******************************************************************************************************
 *
 * DXFCircle.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.math.ParametricPlane;


/**
 * The Class DXFCircle.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFCircle extends DXFEntity {
    
    /** The center. */
    private Point center;
    
    /** The radius. */
    private double radius;

    /**
     * Instantiates a new DXF circle.
     */
    public DXFCircle() {
    }

    /**
     * Gets the radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius.
     *
     * @param radius            The radius to set.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Sets the center point.
     *
     * @param p the new center point
     */
    public void setCenterPoint(Point p) {
        this.center = p;
    }

    /**
     * Gets the center point.
     *
     * @return the center point
     */
    public Point getCenterPoint() {
        return center;
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        ParametricPlane plane = new ParametricPlane(this.getExtrusion());
        Point p = plane.getPoint(this.center.getX(), this.center.getY());
        bounds.setMaximumX(p.getX() + radius);
        bounds.setMinimumX(p.getX() - radius);
        bounds.setMaximumY(p.getY() + radius);
        bounds.setMinimumY(p.getY() - radius);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_CIRCLE;
    }

    public double getLength() {
        return 2 * Math.PI * this.radius;
    }

    /**
     * Gets the point at.
     *
     * @param angle the angle
     * @return the point at
     */
    public Point getPointAt(double angle) {
        // the local part
        double x = this.radius * Math.cos(Math.toRadians(angle));
        double y = radius * Math.sin(Math.toRadians(angle));

        // the wcs part
        ParametricPlane plane = new ParametricPlane(this.getExtrusion());
        Point p = plane.getPoint(x + this.center.getX(), y +
                this.center.getY());

        return p;
    }
}
