/*******************************************************************************************************
 *
 * DXFLineType.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;


/**
 * The Class DXFLineType.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFLineType {
    
    /** The name. */
    private String name = "";
    
    /** The descritpion. */
    private String descritpion = "";
    
    /** The total pattern length. */
    private double totalPatternLength = 0.0;
    
    /** The pattern. */
    private double[] pattern;
    
    /** The element count. */
    private int elementCount = 0;
    
    /** The offset X. */
    private int[] offsetX;
    
    /** The offset Y. */
    private int[] offsetY;
    
    /** The alignment. */
    private int alignment;
    
    /** The scale. */
    protected double scale = 1.0;

    /**
     * Gets the descritpion.
     *
     * @return the descritpion
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * Sets the descritpion.
     *
     * @param descritpion the new descritpion
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    /**
     * Gets the segment count.
     *
     * @return the segment count
     */
    public int getSegmentCount() {
        return elementCount;
    }

    /**
     * Sets the segment count.
     *
     * @param elementCount the new segment count
     */
    public void setSegmentCount(int elementCount) {
        this.elementCount = elementCount;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the pattern.
     *
     * @return the pattern
     */
    public double[] getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern.
     *
     * @param pattern the new pattern
     */
    public void setPattern(double[] pattern) {
        this.pattern = pattern;
    }

    /**
     * Gets the pattern length.
     *
     * @return the pattern length
     */
    public double getPatternLength() {
        return totalPatternLength;
    }

    /**
     * Sets the pattern length.
     *
     * @param patternLength the new pattern length
     */
    public void setPatternLength(double patternLength) {
        this.totalPatternLength = patternLength;
    }

    /**
     * Gets the alignment.
     *
     * @return Returns the alignment.
     */
    public int getAlignment() {
        return alignment;
    }

    /**
     * Sets the alignment.
     *
     * @param alignment            The alignment to set.
     */
    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    /**
     * Gets the scale.
     *
     * @return Returns the scale.
     */
    public double getScale() {
        return scale;
    }

    /**
     * Sets the scale.
     *
     * @param scale The scale to set.
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    /**
     * Checks if is scale to fit.
     *
     * @return true, if is scale to fit
     */
    public boolean isScaleToFit() {
        if (alignment == 83) {
            return true;
        }

        return false;
    }
}
