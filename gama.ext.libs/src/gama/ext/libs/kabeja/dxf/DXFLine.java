/*******************************************************************************************************
 *
 * DXFLine.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFLine.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFLine extends DXFEntity {
    
    /** The start. */
    private Point start;
    
    /** The end. */
    private Point end;

    /**
     * Instantiates a new DXF line.
     */
    public DXFLine() {
        start = new Point();
        end = new Point();
    }

    /**
     * Sets the property.
     *
     * @param groupcode the groupcode
     * @param value the value
     */
    public void setProperty(int groupcode, String value) {
    }

    /**
     * Sets the start point.
     *
     * @param start the new start point
     */
    public void setStartPoint(Point start) {
        this.start = start;
    }

    /**
     * Gets the end point.
     *
     * @return Returns the end.
     */
    public Point getEndPoint() {
        return end;
    }

    /**
     * Sets the end point.
     *
     * @param end            The end to set.
     */
    public void setEndPoint(Point end) {
        this.end = end;
    }

    /**
     * Gets the start point.
     *
     * @return Returns the start.
     */
    public Point getStartPoint() {
        return start;
    }

    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.addToBounds(this.end);
        bounds.addToBounds(this.start);

        return bounds;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_LINE;
    }

    public double getLength() {
        return MathUtils.distance(this.start, this.end);
    }
}
