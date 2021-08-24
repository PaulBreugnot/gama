/*******************************************************************************************************
 *
 * SplinePoint.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;


/**
 * The Class SplinePoint.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class SplinePoint extends Point {
    
    /** The Constant TYPE_CONTROLPOINT. */
    public static final int TYPE_CONTROLPOINT = 0;
    
    /** The Constant TYPE_FITPOINT. */
    public static final int TYPE_FITPOINT = 1;
    
    /** The Constant TYPE_STARTTANGENT. */
    public static final int TYPE_STARTTANGENT = 2;
    
    /** The Constant TYPE_ENDTANGENT. */
    public static final int TYPE_ENDTANGENT = 3;
    
    /** The type. */
    protected int type = 0;

    /**
     * Checks if is control point.
     *
     * @return Returns the controlPoint.
     */
    public boolean isControlPoint() {
        return this.type == TYPE_CONTROLPOINT;
    }

    /**
     * Checks if is end tangent.
     *
     * @return Returns the endTangent.
     */
    public boolean isEndTangent() {
        return this.type == TYPE_ENDTANGENT;
    }

    /**
     * Checks if is fit point.
     *
     * @return Returns the fitPoint.
     */
    public boolean isFitPoint() {
        return this.type == TYPE_FITPOINT;
    }

    /**
     * Checks if is start tangent.
     *
     * @return Returns the startTangent.
     */
    public boolean isStartTangent() {
        return this.type == TYPE_STARTTANGENT;
    }

    /**
     * Sets the type of the point.
     *
     * @param type the new type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * gets the type of the point.
     *
     * @return the type
     */
    public int getType() {
        return this.type;
    }
}
