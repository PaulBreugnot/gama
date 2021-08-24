/*******************************************************************************************************
 *
 * Edge.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;


/**
 * The Class Edge.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class Edge {
    
    /** The start point. */
    protected Point startPoint = new Point();
    
    /** The end point. */
    protected Point endPoint = new Point();

    /**
     * Gets the end point.
     *
     * @return Returns the endPoint.
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * Sets the end point.
     *
     * @param endPoint The endPoint to set.
     */
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Gets the start point.
     *
     * @return Returns the startPoint.
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     * Sets the start point.
     *
     * @param startPoint The startPoint to set.
     */
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Gets the intersection point.
     *
     * @param e the e
     * @return the intersection point
     */
    public Point getIntersectionPoint(Edge e) {
        return null;
    }
}
