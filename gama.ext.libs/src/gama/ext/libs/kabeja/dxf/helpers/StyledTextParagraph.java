/*******************************************************************************************************
 *
 * StyledTextParagraph.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;


/**
 * The Class StyledTextParagraph.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class StyledTextParagraph {
    
    /** The Constant VERTICAL_ALIGNMENT_TOP. */
    public static final int VERTICAL_ALIGNMENT_TOP = 2;
    
    /** The Constant VERTICAL_ALIGNMENT_BASELINE. */
    public static final int VERTICAL_ALIGNMENT_BASELINE = 1;
    
    /** The Constant VERTICAL_ALIGNMENT_BOTTOM. */
    public static final int VERTICAL_ALIGNMENT_BOTTOM = 0;
    
    /** The Constant VERTICAL_ALIGNMENT_CENTER. */
    public static final int VERTICAL_ALIGNMENT_CENTER = 4;
    
    /** The italic. */
    private boolean italic = false;
    
    /** The bold. */
    private boolean bold = false;
    
    /** The underline. */
    private boolean underline = false;
    
    /** The overline. */
    private boolean overline = false;
    
    /** The font height. */
    private double fontHeight = 0.0;
    
    /** The font. */
    private String font = "";
    
    /** The text. */
    private StringBuffer text = new StringBuffer();
    
    /** The width. */
    private double width = 0.0;
    
    /** The obliqui angle. */
    private double obliquiAngle = 0.0;
    
    /** The characterspace. */
    private double characterspace = 0.0;
    
    /** The line index. */
    private int lineIndex = 0;
    
    /** The newline. */
    private boolean newline = false;
    
    /** The font file. */
    private String fontFile = "";
    
    /** The alignment. */
    private int alignment = 1;
    
    /** The insert point. */
    private Point insertPoint = new Point();

    /**
     * Gets the insert point.
     *
     * @return Returns the insertPoint.
     */
    public Point getInsertPoint() {
        return insertPoint;
    }

    /**
     * Sets the insert point.
     *
     * @param insertPoint            The insertPoint to set.
     */
    public void setInsertPoint(Point insertPoint) {
        this.insertPoint = insertPoint;
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
     * Gets the characterspace.
     *
     * @return Returns the characterspace.
     */
    public double getCharacterspace() {
        return characterspace;
    }

    /**
     * Sets the characterspace.
     *
     * @param characterspace            The characterspace to set.
     */
    public void setCharacterspace(double characterspace) {
        this.characterspace = characterspace;
    }

    /**
     * Gets the valign.
     *
     * @return Returns the alignment.
     */
    public int getValign() {
        return alignment;
    }

    /**
     * Sets the valign.
     *
     * @param alignment            The alignment to set.
     */
    public void setValign(int alignment) {
        this.alignment = alignment;
    }

    /**
     * Checks if is bold.
     *
     * @return Returns the bold.
     */
    public boolean isBold() {
        return bold;
    }

    /**
     * Sets the bold.
     *
     * @param bold            The bold to set.
     */
    public void setBold(boolean bold) {
        this.bold = bold;
    }

    /**
     * Gets the font.
     *
     * @return Returns the font.
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets the font.
     *
     * @param font            The font to set.
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * Gets the font height.
     *
     * @return Returns the height.
     */
    public double getFontHeight() {
        return fontHeight;
    }

    /**
     * Sets the font height.
     *
     * @param height            The height to set.
     */
    public void setFontHeight(double height) {
        this.fontHeight = height;
    }

    /**
     * Checks if is italic.
     *
     * @return Returns the italic.
     */
    public boolean isItalic() {
        return italic;
    }

    /**
     * Sets the italic.
     *
     * @param italic            The italic to set.
     */
    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    /**
     * Gets the obliqui angle.
     *
     * @return Returns the obliquiAngle.
     */
    public double getObliquiAngle() {
        return obliquiAngle;
    }

    /**
     * Sets the obliqui angle.
     *
     * @param obliquiAngle            The obliquiAngle to set.
     */
    public void setObliquiAngle(double obliquiAngle) {
        this.obliquiAngle = obliquiAngle;
    }

    /**
     * Checks if is overline.
     *
     * @return Returns the overline.
     */
    public boolean isOverline() {
        return overline;
    }

    /**
     * Sets the overline.
     *
     * @param overline            The overline to set.
     */
    public void setOverline(boolean overline) {
        this.overline = overline;
    }

    /**
     * Gets the text.
     *
     * @return Returns the text.
     */
    public String getText() {
        return text.toString();
    }

    /**
     * Sets the text.
     *
     * @param text            The text to set.
     */
    public void setText(String text) {
        this.text.delete(0, text.length());
        this.text.append(text);
    }

    /**
     * Checks if is underline.
     *
     * @return Returns the underline.
     */
    public boolean isUnderline() {
        return underline;
    }

    /**
     * Sets the underline.
     *
     * @param underline            The underline to set.
     */
    public void setUnderline(boolean underline) {
        this.underline = underline;
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
     * Gets the line index.
     *
     * @return Returns the linecount.
     */
    public int getLineIndex() {
        return lineIndex;
    }

    /**
     * Sets the line index.
     *
     * @param linecount            The linecount to set.
     */
    public void setLineIndex(int linecount) {
        this.lineIndex = linecount;
    }

    /**
     * Checks if is newline.
     *
     * @return Returns the newline.
     */
    public boolean isNewline() {
        return newline;
    }

    /**
     * Sets the newline.
     *
     * @param newline            The newline to set.
     */
    public void setNewline(boolean newline) {
        this.newline = newline;
    }

    /**
     * Append.
     *
     * @param text the text
     */
    public void append(String text) {
        this.text.append(text);
    }

    /**
     * Append.
     *
     * @param c the c
     */
    public void append(char c) {
        this.text.append(c);
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public int getLength() {
        return text.length();
    }
}
