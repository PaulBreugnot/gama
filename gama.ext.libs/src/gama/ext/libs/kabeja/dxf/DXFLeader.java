/*******************************************************************************************************
 *
 * DXFLeader.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class DXFLeader.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFLeader extends DXFEntity {
    
    /** The style name. */
    protected String styleName = "";
    
    /** The arrow head size. */
    protected double arrowHeadSize = 0.0;
    
    /** The text gap. */
    protected double textGap;
    
    /** The scale factor. */
    protected double scaleFactor;
    
    /** The text width. */
    protected double textWidth;
    
    /** The text height. */
    protected double textHeight;
    
    /** The coordinates. */
    protected List coordinates = new ArrayList();
    
    /** The path type. */
    protected int pathType = 0;
    
    /** The creation type. */
    protected int creationType = 0;
    
    /** The hookline directon. */
    protected int hooklineDirecton = 0;
    
    /** The hookline. */
    protected boolean hookline = false;
    
    /** The horizontal direction. */
    protected Point horizontalDirection = new Point();
    
    /** The last offset text. */
    protected Point lastOffsetText = new Point();
    
    /** The last offset insertion. */
    protected Point lastOffsetInsertion = new Point();
    
    /** The arrow enabled. */
    protected boolean arrowEnabled = false;
    
    /** The text ID. */
    protected String textID = "";

    /**
     * Gets the text ID.
     *
     * @return Returns the textID.
     */
    public String getTextID() {
        return textID;
    }

    /**
     * Sets the text ID.
     *
     * @param textID            The textID to set.
     */
    public void setTextID(String textID) {
        this.textID = textID;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        bounds.setValid(false);

        return bounds;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_LEADER;
    }

    /**
     * Gets the arrow head size.
     *
     * @return Returns the arrowHeadSize.
     */
    public double getArrowHeadSize() {
        return arrowHeadSize;
    }

    /**
     * Sets the arrow head size.
     *
     * @param arrowHeadSize            The arrowHeadSize to set.
     */
    public void setArrowHeadSize(double arrowHeadSize) {
        this.arrowHeadSize = arrowHeadSize;
    }

    /**
     * Gets the creation type.
     *
     * @return Returns the creationType.
     */
    public int getCreationType() {
        return creationType;
    }

    /**
     * Sets the creation type.
     *
     * @param creationType            The creationType to set.
     */
    public void setCreationType(int creationType) {
        this.creationType = creationType;
    }

    /**
     * Checks if is hookline.
     *
     * @return Returns the hookline.
     */
    public boolean isHookline() {
        return hookline;
    }

    /**
     * Sets the hookline.
     *
     * @param hookline            The hookline to set.
     */
    public void setHookline(boolean hookline) {
        this.hookline = hookline;
    }

    /**
     * Gets the hookline directon.
     *
     * @return Returns the hooklineDirecton.
     */
    public int getHooklineDirecton() {
        return hooklineDirecton;
    }

    /**
     * Sets the hookline directon.
     *
     * @param hooklineDirecton            The hooklineDirecton to set.
     */
    public void setHooklineDirecton(int hooklineDirecton) {
        this.hooklineDirecton = hooklineDirecton;
    }

    /**
     * Gets the horizontal direction.
     *
     * @return Returns the horizontalDirection.
     */
    public Point getHorizontalDirection() {
        return horizontalDirection;
    }

    /**
     * Sets the horizontal direction.
     *
     * @param horizontalDirection            The horizontalDirection to set.
     */
    public void setHorizontalDirection(Point horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
    }

    /**
     * Gets the last offset insertion.
     *
     * @return Returns the lastOffsetInsertion.
     */
    public Point getLastOffsetInsertion() {
        return lastOffsetInsertion;
    }

    /**
     * Sets the last offset insertion.
     *
     * @param lastOffsetInsertion            The lastOffsetInsertion to set.
     */
    public void setLastOffsetInsertion(Point lastOffsetInsertion) {
        this.lastOffsetInsertion = lastOffsetInsertion;
    }

    /**
     * Gets the last offset text.
     *
     * @return Returns the lastOffsetText.
     */
    public Point getLastOffsetText() {
        return lastOffsetText;
    }

    /**
     * Sets the last offset text.
     *
     * @param lastOffsetText            The lastOffsetText to set.
     */
    public void setLastOffsetText(Point lastOffsetText) {
        this.lastOffsetText = lastOffsetText;
    }

    /**
     * Gets the path type.
     *
     * @return Returns the pathType.
     */
    public int getPathType() {
        return pathType;
    }

    /**
     * Sets the path type.
     *
     * @param pathType            The pathType to set.
     */
    public void setPathType(int pathType) {
        this.pathType = pathType;
    }

    /**
     * Gets the scale factor.
     *
     * @return Returns the scaleFactor.
     */
    public double getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Sets the scale factor.
     *
     * @param scaleFactor            The scaleFactor to set.
     */
    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    /**
     * Gets the style name ID.
     *
     * @return Returns the styleName.
     */
    public String getStyleNameID() {
        return styleName;
    }

    /**
     * Sets the style name ID.
     *
     * @param styleName            The styleName to set.
     */
    public void setStyleNameID(String styleName) {
        this.styleName = styleName;
    }

    /**
     * Gets the text gap.
     *
     * @return Returns the textGap.
     */
    public double getTextGap() {
        return textGap;
    }

    /**
     * Sets the text gap.
     *
     * @param textGap            The textGap to set.
     */
    public void setTextGap(double textGap) {
        this.textGap = textGap;
    }

    /**
     * Gets the text height.
     *
     * @return Returns the textHeight.
     */
    public double getTextHeight() {
        return textHeight;
    }

    /**
     * Sets the text height.
     *
     * @param textHeight            The textHeight to set.
     */
    public void setTextHeight(double textHeight) {
        this.textHeight = textHeight;
    }

    /**
     * Gets the text width.
     *
     * @return Returns the textWidth.
     */
    public double getTextWidth() {
        return textWidth;
    }

    /**
     * Sets the text width.
     *
     * @param textWidth            The textWidth to set.
     */
    public void setTextWidth(double textWidth) {
        this.textWidth = textWidth;
    }

    /**
     * Adds the coordinate.
     *
     * @param vertex the vertex
     */
    public void addCoordinate(Point vertex) {
        coordinates.add(vertex);
    }

    /**
     * Gets the coordinate count.
     *
     * @return the coordinate count
     */
    public int getCoordinateCount() {
        return this.coordinates.size();
    }

    /**
     * Gets the coordinate at.
     *
     * @param index the index
     * @return the coordinate at
     */
    public Point getCoordinateAt(int index) {
        return (Point) this.coordinates.get(index);
    }

    /**
     * Gets the coordinate iterator.
     *
     * @return the coordinate iterator
     */
    public Iterator getCoordinateIterator() {
        return this.coordinates.iterator();
    }

    /**
     * Checks if is arrow enabled.
     *
     * @return Returns the arrowEnabled.
     */
    public boolean isArrowEnabled() {
        return arrowEnabled;
    }

    /**
     * Sets the arrow enabled.
     *
     * @param arrowEnabled            The arrowEnabled to set.
     */
    public void setArrowEnabled(boolean arrowEnabled) {
        this.arrowEnabled = arrowEnabled;
    }

    /**
     * Checks if is spline path.
     *
     * @return true, if is spline path
     */
    public boolean isSplinePath() {
        return this.pathType == 1;
    }

    public double getLength() {
        // TODO Auto-generated method stub
        return 0;
    }
}
