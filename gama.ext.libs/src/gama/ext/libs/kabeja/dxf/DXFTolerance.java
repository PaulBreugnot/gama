/*******************************************************************************************************
 *
 * DXFTolerance.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFTolerance.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFTolerance extends DXFEntity {
    
    /** The insertion point. */
    protected Point insertionPoint = new Point();
    
    /** The style name ID. */
    protected String styleNameID = "";
    
    /** The text. */
    protected String text;
    
    /** The xaxis direction. */
    protected Vector xaxisDirection = new Vector();

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    /* (non-Javadoc)
     * @see org.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        // TODO Auto-generated method stub
        return DXFConstants.ENTITY_TYPE_TOLERANCE;
    }

    /**
     * Gets the insertion point.
     *
     * @return Returns the insertionPoint.
     */
    public Point getInsertionPoint() {
        return insertionPoint;
    }

    /**
     * Sets the insertion point.
     *
     * @param insertionPoint The insertionPoint to set.
     */
    public void setInsertionPoint(Point insertionPoint) {
        this.insertionPoint = insertionPoint;
    }

    /**
     * Gets the style ID.
     *
     * @return Returns the styleID.
     */
    public String getStyleID() {
        return styleNameID;
    }

    /**
     * Sets the style ID.
     *
     * @param styleNameID The styleID to set.
     */
    public void setStyleID(String styleNameID) {
        this.styleNameID = styleNameID;
    }

    /**
     * Gets the text.
     *
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the xaxis direction.
     *
     * @return Returns the xaxisDirection.
     */
    public Vector getXaxisDirection() {
        return xaxisDirection;
    }

    /**
     * Sets the xaxis direction.
     *
     * @param xaxisDirection The xaxisDirection to set.
     */
    public void setXaxisDirection(Vector xaxisDirection) {
        this.xaxisDirection = xaxisDirection;
    }

    public double getLength() {
        return 0;
    }
}
