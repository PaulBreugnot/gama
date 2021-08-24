/*******************************************************************************************************
 *
 * DXFVPort.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFVPort.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFVPort {
    
    /** The name. */
    private String name = "";
    
    /** The lower left corner. */
    private Point lowerLeftCorner = new Point();
    
    /** The upper right corner. */
    private Point upperRightCorner = new Point();
    
    /** The center point. */
    private Point centerPoint = new Point();
    
    /** The snap base point. */
    private Point snapBasePoint = new Point();
    
    /** The grid spacing point. */
    private Point gridSpacingPoint = new Point();
    
    /** The view direction point. */
    private Point viewDirectionPoint = new Point();
    
    /** The view target point. */
    private Point viewTargetPoint = new Point();
    
    /** The height. */
    private double height;
    
    /** The width. */
    private double width;
    
    /** The ratio. */
    private double ratio;
    
    /** The lens length. */
    private double lensLength;
    
    /** The front clipping plane. */
    private double frontClippingPlane;
    
    /** The back clipping plane. */
    private double backClippingPlane;
    
    /** The rotation angle. */
    private double rotationAngle;
    
    /** The view twist angle. */
    private double viewTwistAngle;
    
    /** The circle zoom. */
    private double circleZoom;
    
    /** The fast zoom. */
    private double fastZoom;
    
    /** The snap. */
    private boolean snap;
    
    /** The grid. */
    private boolean grid;
    
    /** The active. */
    private boolean active = false;

    /**
     * Gets the back clipping plane.
     *
     * @return Returns the backClippingPlane.
     */
    public double getBackClippingPlane() {
        return backClippingPlane;
    }

    /**
     * Sets the back clipping plane.
     *
     * @param backClippingPlane The backClippingPlane to set.
     */
    public void setBackClippingPlane(double backClippingPlane) {
        this.backClippingPlane = backClippingPlane;
    }

    /**
     * Gets the center point.
     *
     * @return Returns the centerPoint.
     */
    public Point getCenterPoint() {
        return centerPoint;
    }

    /**
     * Sets the center point.
     *
     * @param centerPoint The centerPoint to set.
     */
    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    /**
     * Gets the circle zoom.
     *
     * @return Returns the circleZoom.
     */
    public double getCircleZoom() {
        return circleZoom;
    }

    /**
     * Sets the circle zoom.
     *
     * @param circleZoom The circleZoom to set.
     */
    public void setCircleZoom(double circleZoom) {
        this.circleZoom = circleZoom;
    }

    /**
     * Gets the fast zoom.
     *
     * @return Returns the fastZoom.
     */
    public double getFastZoom() {
        return fastZoom;
    }

    /**
     * Sets the fast zoom.
     *
     * @param fastZoom The fastZoom to set.
     */
    public void setFastZoom(double fastZoom) {
        this.fastZoom = fastZoom;
    }

    /**
     * Gets the front clipping plane.
     *
     * @return Returns the frontClippingPlane.
     */
    public double getFrontClippingPlane() {
        return frontClippingPlane;
    }

    /**
     * Sets the front clipping plane.
     *
     * @param frontClippingPlane The frontClippingPlane to set.
     */
    public void setFrontClippingPlane(double frontClippingPlane) {
        this.frontClippingPlane = frontClippingPlane;
    }

    /**
     * Checks if is grid.
     *
     * @return Returns the grid.
     */
    public boolean isGrid() {
        return grid;
    }

    /**
     * Sets the grid.
     *
     * @param grid The grid to set.
     */
    public void setGrid(boolean grid) {
        this.grid = grid;
    }

    /**
     * Gets the grid spacing point.
     *
     * @return Returns the gridSpacingPoint.
     */
    public Point getGridSpacingPoint() {
        return gridSpacingPoint;
    }

    /**
     * Sets the grid spacing point.
     *
     * @param gridSpacingPoint The gridSpacingPoint to set.
     */
    public void setGridSpacingPoint(Point gridSpacingPoint) {
        this.gridSpacingPoint = gridSpacingPoint;
    }

    /**
     * Gets the height.
     *
     * @return Returns the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height.
     *
     * @param height The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the lens length.
     *
     * @return Returns the lensLength.
     */
    public double getLensLength() {
        return lensLength;
    }

    /**
     * Sets the lens length.
     *
     * @param lensLength The lensLength to set.
     */
    public void setLensLength(double lensLength) {
        this.lensLength = lensLength;
    }

    /**
     * Gets the lower left corner.
     *
     * @return Returns the lowerLeftCorner.
     */
    public Point getLowerLeftCorner() {
        return lowerLeftCorner;
    }

    /**
     * Sets the lower left corner.
     *
     * @param lowerLeftCorner The lowerLeftCorner to set.
     */
    public void setLowerLeftCorner(Point lowerLeftCorner) {
        this.lowerLeftCorner = lowerLeftCorner;
    }

    /**
     * Gets the name.
     *
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the aspect ratio.
     *
     * @return Returns the ratio.
     */
    public double getAspectRatio() {
        return ratio;
    }

    /**
     * Sets the aspect ratio.
     *
     * @param ratio The ratio to set.
     */
    public void setAspectRatio(double ratio) {
        this.ratio = ratio;
    }

    /**
     * Gets the rotation angle.
     *
     * @return Returns the rotationAngle.
     */
    public double getRotationAngle() {
        return rotationAngle;
    }

    /**
     * Sets the rotation angle.
     *
     * @param rotationAngle The rotationAngle to set.
     */
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }

    /**
     * Checks if is snap.
     *
     * @return Returns the snap.
     */
    public boolean isSnap() {
        return snap;
    }

    /**
     * Sets the snap.
     *
     * @param snap The snap to set.
     */
    public void setSnap(boolean snap) {
        this.snap = snap;
    }

    /**
     * Gets the snap base point.
     *
     * @return Returns the snapBasePoint.
     */
    public Point getSnapBasePoint() {
        return snapBasePoint;
    }

    /**
     * Sets the snap base point.
     *
     * @param snapBasePoint The snapBasePoint to set.
     */
    public void setSnapBasePoint(Point snapBasePoint) {
        this.snapBasePoint = snapBasePoint;
    }

    /**
     * Gets the upper right corner.
     *
     * @return Returns the upperRightCorner.
     */
    public Point getUpperRightCorner() {
        return upperRightCorner;
    }

    /**
     * Sets the upper right corner.
     *
     * @param upperRightCorner The upperRightCorner to set.
     */
    public void setUpperRightCorner(Point upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
    }

    /**
     * Gets the view direction point.
     *
     * @return Returns the viewDirectionPoint.
     */
    public Point getViewDirectionPoint() {
        return viewDirectionPoint;
    }

    /**
     * Sets the view direction point.
     *
     * @param viewDirectionPoint The viewDirectionPoint to set.
     */
    public void setViewDirectionPoint(Point viewDirectionPoint) {
        this.viewDirectionPoint = viewDirectionPoint;
    }

    /**
     * Gets the view target point.
     *
     * @return Returns the viewTargetPoint.
     */
    public Point getViewTargetPoint() {
        return viewTargetPoint;
    }

    /**
     * Sets the view target point.
     *
     * @param viewTargetPoint The viewTargetPoint to set.
     */
    public void setViewTargetPoint(Point viewTargetPoint) {
        this.viewTargetPoint = viewTargetPoint;
    }

    /**
     * Gets the view twist angle.
     *
     * @return Returns the viewTwistAngle.
     */
    public double getViewTwistAngle() {
        return viewTwistAngle;
    }

    /**
     * Sets the view twist angle.
     *
     * @param viewTwistAngle The viewTwistAngle to set.
     */
    public void setViewTwistAngle(double viewTwistAngle) {
        this.viewTwistAngle = viewTwistAngle;
    }

    /**
     * Checks if is active.
     *
     * @return Returns the active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active.
     *
     * @param active The active to set.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width.
     *
     * @param width the new width
     */
    public void setWidth(double width) {
        this.width = width;
    }
}
