/*******************************************************************************************************
 *
 * DXFStyle.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;


/**
 * The Class DXFStyle.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFStyle {
    
    /** The name. */
    private String name = "";
    
    /** The font file. */
    private String fontFile = "";
    
    /** The big font file. */
    private String bigFontFile = "";
    
    /** The text height. */
    private double textHeight = 0.0;
    
    /** The width factor. */
    private double widthFactor = 1.0;
    
    /** The oblique angle. */
    private double obliqueAngle = 0.0;
    
    /** The text generation flag. */
    private int textGenerationFlag = 0;
    
    /** The flags. */
    private int flags = 0;
    
    /** The last height. */
    private double lastHeight = 0.0;

    /**
     * Gets the big font file.
     *
     * @return Returns the bigFontFile.
     */
    public String getBigFontFile() {
        return bigFontFile;
    }

    /**
     * Sets the big font file.
     *
     * @param bigFontFile            The bigFontFile to set.
     */
    public void setBigFontFile(String bigFontFile) {
        this.bigFontFile = bigFontFile;
    }

    /**
     * Gets the font file.
     *
     * @return Returns the fontFile.
     */
    public String getFontFile() {
        return fontFile;
    }

    /**
     * Sets the font file.
     *
     * @param fontFile            The fontFile to set.
     */
    public void setFontFile(String fontFile) {
        this.fontFile = fontFile;
    }

    /**
     * Gets the last height.
     *
     * @return Returns the lastHeight.
     */
    public double getLastHeight() {
        return lastHeight;
    }

    /**
     * Sets the last height.
     *
     * @param lastHeight            The lastHeight to set.
     */
    public void setLastHeight(double lastHeight) {
        this.lastHeight = lastHeight;
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
     * Gets the oblique angle.
     *
     * @return Returns the obliqueAngle.
     */
    public double getObliqueAngle() {
        return obliqueAngle;
    }

    /**
     * Sets the oblique angle.
     *
     * @param obliqueAngle            The obliqueAngle to set.
     */
    public void setObliqueAngle(double obliqueAngle) {
        this.obliqueAngle = obliqueAngle;
    }

    /**
     * Gets the text generation flag.
     *
     * @return Returns the textGenerationFlag.
     */
    public int getTextGenerationFlag() {
        return textGenerationFlag;
    }

    /**
     * Sets the text generation flag.
     *
     * @param textGenerationFlag            The textGenerationFlag to set.
     */
    public void setTextGenerationFlag(int textGenerationFlag) {
        this.textGenerationFlag = textGenerationFlag;
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
     * Gets the width factor.
     *
     * @return Returns the widthFactor.
     */
    public double getWidthFactor() {
        return widthFactor;
    }

    /**
     * Sets the width factor.
     *
     * @param widthFactor            The widthFactor to set.
     */
    public void setWidthFactor(double widthFactor) {
        this.widthFactor = widthFactor;
    }

    /**
     * Gets the flags.
     *
     * @return Returns the flags.
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Sets the flags.
     *
     * @param flags            The flags to set.
     */
    public void setFlags(int flags) {
        this.flags = flags;
    }

    /**
     * Checks if is backward.
     *
     * @return true, if is backward
     */
    public boolean isBackward() {
        return this.textGenerationFlag == 2;
    }

    /**
     * Sets the backward.
     *
     * @param b the new backward
     */
    public void setBackward(boolean b) {
        if (b) {
            this.textGenerationFlag = 2;
        } else {
            this.textGenerationFlag = 0;
        }
    }

    /**
     * Checks if is upside down.
     *
     * @return true, if is upside down
     */
    public boolean isUpsideDown() {
        return this.textGenerationFlag == 4;
    }

    /**
     * Sets the upside down.
     *
     * @param b the new upside down
     */
    public void setUpsideDown(boolean b) {
        if (b) {
            this.textGenerationFlag = 4;
        } else {
            this.textGenerationFlag = 0;
        }
    }
}
