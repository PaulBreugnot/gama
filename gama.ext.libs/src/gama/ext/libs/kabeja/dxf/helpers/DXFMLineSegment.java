/*******************************************************************************************************
 *
 * DXFMLineSegment.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class DXFMLineSegment.
 */
public class DXFMLineSegment {
    
    /** The start point. */
    protected Point startPoint = new Point();
    
    /** The direction. */
    protected Vector direction = new Vector();
    
    /** The miter direction. */
    protected Vector miterDirection = new Vector();
    
    /** The elements. */
    protected List elements = new ArrayList();

    /**
     * Gets the start point.
     *
     * @return the start point
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     * Sets the start point.
     *
     * @param startPoint the new start point
     */
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Gets the direction.
     *
     * @return the direction
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Sets the direction.
     *
     * @param direction the new direction
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    /**
     * Gets the miter direction.
     *
     * @return the miter direction
     */
    public Vector getMiterDirection() {
        return miterDirection;
    }

    /**
     * Sets the miter direction.
     *
     * @param miterDirection the new miter direction
     */
    public void setMiterDirection(Vector miterDirection) {
        this.miterDirection = miterDirection;
    }

    /**
     * Adds the DXFM line segment element.
     *
     * @param el the el
     */
    public void addDXFMLineSegmentElement(DXFMLineSegmentElement el) {
        this.elements.add(el);
    }

    /**
     * Gets the DXFM line segment element count.
     *
     * @return the DXFM line segment element count
     */
    public int getDXFMLineSegmentElementCount() {
        return this.elements.size();
    }

    /**
     * Gets the DXFM line segment element.
     *
     * @param index the index
     * @return the DXFM line segment element
     */
    public DXFMLineSegmentElement getDXFMLineSegmentElement(int index) {
        return (DXFMLineSegmentElement) this.elements.get(index);
    }
}
