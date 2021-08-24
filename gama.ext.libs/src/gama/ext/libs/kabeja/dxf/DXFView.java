/*******************************************************************************************************
 *
 * DXFView.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFView.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFView {
    
    /** The center point. */
    private Point centerPoint = new Point();
    
    /** The height. */
    private double height = 0.0;
    
    /** The width. */
    private double width = 0.0;
    
    /** The name. */
    private String name = "";
    
    /** The view direction. */
    private Vector viewDirection = new Vector();
    
    /** The target. */
    private Point target = new Point();
    
    /** The lens length. */
    private double lensLength = 0.0;
    
    /** The front clipping. */
    private double frontClipping = 0.0;
    
    /** The back clipping. */
    private double backClipping = 0.0;
    
    /** The twist angle. */
    private double twistAngle = 0.0;
    
    /** The render mode. */
    private int renderMode = 0;
    
    /** The ucs origin. */
    private Vector ucsOrigin = new Vector();
    
    /** The ucs X axis. */
    private Vector ucsXAxis = new Vector();
    
    /** The ucs Y axis. */
    private Vector ucsYAxis = new Vector();
    
    /** The ucs type. */
    private int ucsType = 0;
    
    /** The ucs elevation. */
    private double ucsElevation = 0.0;
    
    /** The use UCS. */
    private boolean useUCS = false;

    /**
     * Gets the back clipping.
     *
     * @return Returns the backClipping.
     */
    public double getBackClipping() {
        return backClipping;
    }

    /**
     * Sets the back clipping.
     *
     * @param backClipping            The backClipping to set.
     */
    public void setBackClipping(double backClipping) {
        this.backClipping = backClipping;
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
     * @param centerPoint            The centerPoint to set.
     */
    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    /**
     * Gets the front clipping.
     *
     * @return Returns the frontClipping.
     */
    public double getFrontClipping() {
        return frontClipping;
    }

    /**
     * Sets the front clipping.
     *
     * @param frontClipping            The frontClipping to set.
     */
    public void setFrontClipping(double frontClipping) {
        this.frontClipping = frontClipping;
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
     * @param height            The height to set.
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
     * @param lensLength            The lensLength to set.
     */
    public void setLensLength(double lensLength) {
        this.lensLength = lensLength;
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
     * @param name            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the render mode.
     *
     * @return Returns the renderMode.
     */
    public int getRenderMode() {
        return renderMode;
    }

    /**
     * Sets the render mode.
     *
     * @param renderMode            The renderMode to set.
     */
    public void setRenderMode(int renderMode) {
        this.renderMode = renderMode;
    }

    /**
     * Gets the target.
     *
     * @return Returns the target.
     */
    public Point getTarget() {
        return target;
    }

    /**
     * Sets the target.
     *
     * @param target            The target to set.
     */
    public void setTarget(Point target) {
        this.target = target;
    }

    /**
     * Gets the twist angle.
     *
     * @return Returns the twistAngle.
     */
    public double getTwistAngle() {
        return twistAngle;
    }

    /**
     * Sets the twist angle.
     *
     * @param twistAngle            The twistAngle to set.
     */
    public void setTwistAngle(double twistAngle) {
        this.twistAngle = twistAngle;
    }

    /**
     * Gets the ucs elevation.
     *
     * @return Returns the ucsElevation.
     */
    public double getUcsElevation() {
        return ucsElevation;
    }

    /**
     * Sets the ucs elevation.
     *
     * @param ucsElevation            The ucsElevation to set.
     */
    public void setUcsElevation(double ucsElevation) {
        this.ucsElevation = ucsElevation;
    }

    /**
     * Gets the ucs origin.
     *
     * @return Returns the ucsOrigin.
     */
    public Vector getUcsOrigin() {
        return ucsOrigin;
    }

    /**
     * Sets the ucs origin.
     *
     * @param ucsOrigin            The ucsOrigin to set.
     */
    public void setUcsOrigin(Vector ucsOrigin) {
        this.ucsOrigin = ucsOrigin;
    }

    /**
     * Gets the ucs type.
     *
     * @return Returns the ucsType.
     */
    public int getUcsType() {
        return ucsType;
    }

    /**
     * Sets the ucs type.
     *
     * @param ucsType            The ucsType to set.
     */
    public void setUcsType(int ucsType) {
        this.ucsType = ucsType;
    }

    /**
     * Gets the ucs X axis.
     *
     * @return Returns the ucsXAxis.
     */
    public Vector getUcsXAxis() {
        return ucsXAxis;
    }

    /**
     * Sets the ucs X axis.
     *
     * @param ucsXAxis            The ucsXAxis to set.
     */
    public void setUcsXAxis(Vector ucsXAxis) {
        this.ucsXAxis = ucsXAxis;
    }

    /**
     * Gets the ucs Y axis.
     *
     * @return Returns the ucsYAxis.
     */
    public Vector getUcsYAxis() {
        return ucsYAxis;
    }

    /**
     * Sets the ucs Y axis.
     *
     * @param ucsYAxis            The ucsYAxis to set.
     */
    public void setUcsYAxis(Vector ucsYAxis) {
        this.ucsYAxis = ucsYAxis;
    }

    /**
     * Gets the view direction.
     *
     * @return Returns the viewDirection.
     */
    public Vector getViewDirection() {
        return viewDirection;
    }

    /**
     * Sets the view direction.
     *
     * @param viewDirection            The viewDirection to set.
     */
    public void setViewDirection(Vector viewDirection) {
        this.viewDirection = viewDirection;
    }

    /**
     * Gets the width.
     *
     * @return Returns the width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width.
     *
     * @param width            The width to set.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Checks if is use UCS.
     *
     * @return Returns the useUCS.
     */
    public boolean isUseUCS() {
        return useUCS;
    }

    /**
     * Sets the use UCS.
     *
     * @param useUCS The useUCS to set.
     */
    public void setUseUCS(boolean useUCS) {
        this.useUCS = useUCS;
    }
}
