/*******************************************************************************************************
 *
 * DXFRay.java, in gama.ext.libs, is part of the source code of the
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


/**
 * The Class DXFRay.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFRay extends DXFEntity {
    
    /** The base point. */
    protected Point basePoint = new Point();
    
    /** The direction. */
    protected Vector direction = new Vector();

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        // we will only add the base point
        //the end is infinite
        Bounds bounds = new Bounds();
        bounds.addToBounds(basePoint);

        return bounds;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_RAY;
    }

    /**
     * Gets the base point.
     *
     * @return Returns the basePoint.
     */
    public Point getBasePoint() {
        return basePoint;
    }

    /**
     * Sets the base point.
     *
     * @param basePoint The basePoint to set.
     */
    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
    }

    /**
     * Gets the direction.
     *
     * @return Returns the direction.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Sets the direction.
     *
     * @param direction The direction to set.
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public double getLength() {
        return 0;
    }
}
