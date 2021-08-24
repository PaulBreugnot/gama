/*******************************************************************************************************
 *
 * DXFMLineSegmentElement.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

/**
 * The Class DXFMLineSegmentElement.
 */
public class DXFMLineSegmentElement {
    
    /** The length parameters. */
    protected double[] lengthParameters;
    
    /** The fill parameters. */
    protected double[] fillParameters;

    /**
     * Gets the length parameters.
     *
     * @return the length parameters
     */
    public double[] getLengthParameters() {
        return lengthParameters;
    }

    /**
     * Sets the length parameters.
     *
     * @param lengthParameters the new length parameters
     */
    public void setLengthParameters(double[] lengthParameters) {
        this.lengthParameters = lengthParameters;
    }

    /**
     * Sets the length parameter.
     *
     * @param index the index
     * @param v the v
     */
    public void setLengthParameter(int index, double v) {
        this.lengthParameters[index] = v;
    }

    /**
     * Gets the fill parameters.
     *
     * @return the fill parameters
     */
    public double[] getFillParameters() {
        return fillParameters;
    }

    /**
     * Sets the fill parameters.
     *
     * @param fillParameters the new fill parameters
     */
    public void setFillParameters(double[] fillParameters) {
        this.fillParameters = fillParameters;
    }

    /**
     * Sets the fill parameter.
     *
     * @param index the index
     * @param v the v
     */
    public void setFillParameter(int index, double v) {
        this.fillParameters[index] = v;
    }
}
