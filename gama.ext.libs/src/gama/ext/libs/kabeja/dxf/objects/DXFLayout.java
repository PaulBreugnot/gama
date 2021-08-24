/*******************************************************************************************************
 *
 * DXFLayout.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

import gama.ext.libs.kabeja.dxf.Bounds;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.helpers.Vector;


/**
 * The Class DXFLayout.
 */
public class DXFLayout extends DXFPlotSettings {
    
    /** The limits. */
    protected Bounds limits = new Bounds();
    
    /** The insert point. */
    protected Point insertPoint = new Point();
    
    /** The extent. */
    protected Bounds extent = new Bounds();
    
    /** The origin UCS. */
    protected Point originUCS = new Point();
    
    /** The x axis UCS. */
    protected Vector xAxisUCS = new Vector(1.0, 0.0, 0.0);
    
    /** The y axis UCS. */
    protected Vector yAxisUCS = new Vector(0.0, 1.0, 0.0);
    
    /** The elevation. */
    protected double elevation;
    
    /** The tab order. */
    protected int tabOrder;
    
    /** The orthographic type of UCS. */
    protected int orthographicTypeOfUCS;
    
    /** The paper space block ID. */
    protected String paperSpaceBlockID;
    
    /** The last active viewport ID. */
    protected String lastActiveViewportID;
    
    /** The named UCSID. */
    protected String namedUCSID;
    
    /** The base UCSID. */
    protected String baseUCSID;

    /**
     * Gets the limits.
     *
     * @return the limits
     */
    public Bounds getLimits() {
        return limits;
    }

    /**
     * Sets the limits.
     *
     * @param limits the new limits
     */
    public void setLimits(Bounds limits) {
        this.limits = limits;
    }

    /**
     * Gets the insert point.
     *
     * @return the insert point
     */
    public Point getInsertPoint() {
        return insertPoint;
    }

    /**
     * Sets the insert point.
     *
     * @param insertPoint the new insert point
     */
    public void setInsertPoint(Point insertPoint) {
        this.insertPoint = insertPoint;
    }

    /**
     * Gets the extent.
     *
     * @return the extent
     */
    public Bounds getExtent() {
        return extent;
    }

    /**
     * Sets the extent.
     *
     * @param extent the new extent
     */
    public void setExtent(Bounds extent) {
        this.extent = extent;
    }

    /**
     * Gets the origin UCS.
     *
     * @return the origin UCS
     */
    public Point getOriginUCS() {
        return originUCS;
    }

    /**
     * Sets the origin UCS.
     *
     * @param originUCS the new origin UCS
     */
    public void setOriginUCS(Point originUCS) {
        this.originUCS = originUCS;
    }

    /**
     * Gets the x axis UCS.
     *
     * @return the x axis UCS
     */
    public Vector getXAxisUCS() {
        return xAxisUCS;
    }

    /**
     * Sets the x axis UCS.
     *
     * @param axisUCS the new x axis UCS
     */
    public void setXAxisUCS(Vector axisUCS) {
        xAxisUCS = axisUCS;
    }

    /**
     * Gets the y axis UCS.
     *
     * @return the y axis UCS
     */
    public Vector getYAxisUCS() {
        return yAxisUCS;
    }

    /**
     * Sets the y axis UCS.
     *
     * @param axisUCS the new y axis UCS
     */
    public void setYAxisUCS(Vector axisUCS) {
        yAxisUCS = axisUCS;
    }

    /**
     * Gets the elevation.
     *
     * @return the elevation
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * Sets the elevation.
     *
     * @param elevation the new elevation
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    /**
     * Gets the tab order.
     *
     * @return the tab order
     */
    public int getTabOrder() {
        return tabOrder;
    }

    /**
     * Sets the tab order.
     *
     * @param tabOrder the new tab order
     */
    public void setTabOrder(int tabOrder) {
        this.tabOrder = tabOrder;
    }

    /**
     * Gets the orthographic type of UCS.
     *
     * @return the orthographic type of UCS
     */
    public int getOrthographicTypeOfUCS() {
        return orthographicTypeOfUCS;
    }

    /**
     * Sets the orthographic type of UCS.
     *
     * @param orthographicTypeOfUCS the new orthographic type of UCS
     */
    public void setOrthographicTypeOfUCS(int orthographicTypeOfUCS) {
        this.orthographicTypeOfUCS = orthographicTypeOfUCS;
    }

    /**
     * Gets the paper space block ID.
     *
     * @return the paper space block ID
     */
    public String getPaperSpaceBlockID() {
        return paperSpaceBlockID;
    }

    /**
     * Sets the paper space block ID.
     *
     * @param paperSpaceBlockID the new paper space block ID
     */
    public void setPaperSpaceBlockID(String paperSpaceBlockID) {
        this.paperSpaceBlockID = paperSpaceBlockID;
    }

    /**
     * Gets the last active viewport ID.
     *
     * @return the last active viewport ID
     */
    public String getLastActiveViewportID() {
        return lastActiveViewportID;
    }

    /**
     * Sets the last active viewport ID.
     *
     * @param lastActiveViewportID the new last active viewport ID
     */
    public void setLastActiveViewportID(String lastActiveViewportID) {
        this.lastActiveViewportID = lastActiveViewportID;
    }

    /**
     * Gets the named UCSID.
     *
     * @return the named UCSID
     */
    public String getNamedUCSID() {
        return namedUCSID;
    }

    /**
     * Sets the named UCSID.
     *
     * @param namedUCSID the new named UCSID
     */
    public void setNamedUCSID(String namedUCSID) {
        this.namedUCSID = namedUCSID;
    }

    /**
     * Gets the base UCSID.
     *
     * @return the base UCSID
     */
    public String getBaseUCSID() {
        return baseUCSID;
    }

    /**
     * Sets the base UCSID.
     *
     * @param baseUCSID the new base UCSID
     */
    public void setBaseUCSID(String baseUCSID) {
        this.baseUCSID = baseUCSID;
    }
}
