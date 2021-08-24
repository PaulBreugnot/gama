/*******************************************************************************************************
 *
 * DXFSolid.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.math.MathUtils;


/**
 * The Class DXFSolid.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFSolid extends DXFEntity {
    
    /** The point 1. */
    protected Point point1 = new Point();
    
    /** The point 2. */
    protected Point point2 = new Point();
    
    /** The point 3. */
    protected Point point3 = new Point();
    
    /** The point 4. */
    protected Point point4 = new Point();

    /**
     * Instantiates a new DXF solid.
     */
    public DXFSolid() {
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();

        bounds.addToBounds(point1);
        bounds.addToBounds(point2);
        bounds.addToBounds(point3);
        bounds.addToBounds(point4);

        return bounds;
    }

    /**
     * Gets the point 1.
     *
     * @return Returns the point1.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Sets the point 1.
     *
     * @param point1            The point1 to set.
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    /**
     * Gets the point 2.
     *
     * @return Returns the point2.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Sets the point 2.
     *
     * @param point2            The point2 to set.
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    /**
     * Gets the point 3.
     *
     * @return Returns the point3.
     */
    public Point getPoint3() {
        return point3;
    }

    /**
     * Sets the point 3.
     *
     * @param point3            The point3 to set.
     */
    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    /**
     * Gets the point 4.
     *
     * @return Returns the point4.
     */
    public Point getPoint4() {
        return point4;
    }

    /**
     * Sets the point 4.
     *
     * @param point4            The point4 to set.
     */
    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_SOLID;
    }

    public double getLength() {
        double length = 0.0;
        length += MathUtils.distance(this.point1, this.point2);
        length += MathUtils.distance(this.point2, this.point4);
        length += MathUtils.distance(this.point4, this.point3);
        length += MathUtils.distance(this.point3, this.point1);

        return length;
    }
}
