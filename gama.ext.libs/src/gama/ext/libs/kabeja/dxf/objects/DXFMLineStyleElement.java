/*******************************************************************************************************
 *
 * DXFMLineStyleElement.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

/**
 * The Class DXFMLineStyleElement.
 */
public class DXFMLineStyleElement {
    
    /** The line color. */
    protected int lineColor = 0;
    
    /** The line type. */
    protected String lineType = "BYLAYER";
    
    /** The offset. */
    protected double offset;

    /**
     * Gets the line color.
     *
     * @return the line color
     */
    public int getLineColor() {
        return lineColor;
    }

    /**
     * Sets the line color.
     *
     * @param lineColor the new line color
     */
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Gets the line type.
     *
     * @return the line type
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * Sets the line type.
     *
     * @param lineStyle the new line type
     */
    public void setLineType(String lineStyle) {
        this.lineType = lineStyle;
    }

    /**
     * Gets the offset.
     *
     * @return the offset
     */
    public double getOffset() {
        return offset;
    }

    /**
     * Sets the offset.
     *
     * @param offset the new offset
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }
}
