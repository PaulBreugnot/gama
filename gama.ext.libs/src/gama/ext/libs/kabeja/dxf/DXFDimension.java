/*******************************************************************************************************
 *
 * DXFDimension.java, in gama.ext.libs, is part of the source code of the
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
 * The Class DXFDimension.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth </a>
 */
public class DXFDimension extends DXFEntity {
    
    /** The type linear. */
    protected final int TYPE_LINEAR = 0;
    
    /** The type alignment. */
    protected final int TYPE_ALIGNMENT = 1;
    
    /** The type 4point. */
    protected final int TYPE_4POINT = 2;
    
    /** The type diameter. */
    protected final int TYPE_DIAMETER = 3;
    
    /** The type radial. */
    protected final int TYPE_RADIAL = 4;
    
    /** The type 3point angle. */
    protected final int TYPE_3POINT_ANGLE = 5;
    
    /** The type coordinates. */
    protected final int TYPE_COORDINATES = 6;
    
    /** The dim type. */
    protected int dimType;
    
    /** The reference point. */
    protected Point referencePoint = new Point();
    
    /** The text point. */
    protected Point textPoint = new Point();
    
    /** The insert point. */
    protected Point insertPoint = new Point();
    
    /** The reference point 3. */
    protected Point referencePoint3 = new Point();
    
    /** The reference point 4. */
    protected Point referencePoint4 = new Point();
    
    /** The reference point 5. */
    protected Point referencePoint5 = new Point();
    
    /** The reference point 6. */
    protected Point referencePoint6 = new Point();
    
    /** The attechment location. */
    protected int attechmentLocation;
    
    /** The exact text line spacing. */
    protected boolean exactTextLineSpacing = false;
    
    /** The rotate. */
    protected double rotate = 0;
    
    /** The horizontal direction. */
    protected double horizontalDirection = 0;
    
    /** The dimension style. */
    protected String dimensionStyle = "";
    
    /** The dimension text. */
    protected String dimensionText = "";
    
    /** The dimension block. */
    protected String dimensionBlock = "";
    
    /** The dimension area. */
    protected int dimensionArea = 0;
    
    /** The text rotation. */
    protected double textRotation = 0.0;
    
    /** The dimension rotation. */
    protected double dimensionRotation = 0.0;
    
    /** The inclination help line. */
    protected double inclinationHelpLine = 0.0;
    
    /** The leading line length. */
    protected double leadingLineLength = 0.0;
    
    /** The horizontal align. */
    protected double horizontalAlign = 0.0;

    /**
     * Instantiates a new DXF dimension.
     */
    public DXFDimension() {
    }

    /**
     * Gets the attechment location.
     *
     * @return Returns the attechmentLocation.
     */
    public int getAttechmentLocation() {
        return attechmentLocation;
    }

    /**
     * Sets the attechment location.
     *
     * @param attechmentLocation            The attechmentLocation to set.
     */
    public void setAttechmentLocation(int attechmentLocation) {
        this.attechmentLocation = attechmentLocation;
    }

    /**
     * Gets the dimension style ID.
     *
     * @return Returns the dimensionStyle.
     */
    public String getDimensionStyleID() {
        return dimensionStyle;
    }

    /**
     * Sets the dimension style ID.
     *
     * @param dimensionStyle            The dimensionStyle to set.
     */
    public void setDimensionStyleID(String dimensionStyle) {
        this.dimensionStyle = dimensionStyle;
    }

    /**
     * Checks if is exact text line spacing.
     *
     * @return Returns the exactTextLineSpacing.
     */
    public boolean isExactTextLineSpacing() {
        return exactTextLineSpacing;
    }

    /**
     * Sets the exact text line spacing.
     *
     * @param exactTextLineSpacing            The exactTextLineSpacing to set.
     */
    public void setExactTextLineSpacing(boolean exactTextLineSpacing) {
        this.exactTextLineSpacing = exactTextLineSpacing;
    }

    /**
     * Gets the horizontal direction.
     *
     * @return Returns the horizontalDirection.
     */
    public double getHorizontalDirection() {
        return horizontalDirection;
    }

    /**
     * Sets the horizontal direction.
     *
     * @param horizontalDirection            The horizontalDirection to set.
     */
    public void setHorizontalDirection(double horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
    }

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
     * Gets the reference point.
     *
     * @return Returns the referencePoint.
     */
    public Point getReferencePoint() {
        return referencePoint;
    }

    /**
     * Sets the reference point.
     *
     * @param referencePoint            The referencePoint to set.
     */
    public void setReferencePoint(Point referencePoint) {
        this.referencePoint = referencePoint;
    }

    /**
     * Gets the reference point 3.
     *
     * @return Returns the referencePoint3.
     */
    public Point getReferencePoint3() {
        return referencePoint3;
    }

    /**
     * Sets the reference point 3.
     *
     * @param referencePoint3            The referencePoint3 to set.
     */
    public void setReferencePoint3(Point referencePoint3) {
        this.referencePoint3 = referencePoint3;
    }

    /**
     * Gets the reference point 4.
     *
     * @return Returns the referencePoint4.
     */
    public Point getReferencePoint4() {
        return referencePoint4;
    }

    /**
     * Sets the reference point 4.
     *
     * @param referencePoint4            The referencePoint4 to set.
     */
    public void setReferencePoint4(Point referencePoint4) {
        this.referencePoint4 = referencePoint4;
    }

    /**
     * Gets the reference point 5.
     *
     * @return Returns the referencePoint5.
     */
    public Point getReferencePoint5() {
        return referencePoint5;
    }

    /**
     * Sets the reference point 5.
     *
     * @param referencePoint5            The referencePoint5 to set.
     */
    public void setReferencePoint5(Point referencePoint5) {
        this.referencePoint5 = referencePoint5;
    }

    /**
     * Gets the reference point 6.
     *
     * @return Returns the referencePoint6.
     */
    public Point getReferencePoint6() {
        return referencePoint6;
    }

    /**
     * Sets the reference point 6.
     *
     * @param referencePoint6            The referencePoint6 to set.
     */
    public void setReferencePoint6(Point referencePoint6) {
        this.referencePoint6 = referencePoint6;
    }

    /**
     * Gets the rotate.
     *
     * @return Returns the rotate.
     */
    public double getRotate() {
        return rotate;
    }

    /**
     * Sets the rotate.
     *
     * @param rotate            The rotate to set.
     */
    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    /**
     * Gets the text point.
     *
     * @return Returns the textPoint.
     */
    public Point getTextPoint() {
        return textPoint;
    }

    /**
     * Sets the text point.
     *
     * @param textPoint            The textPoint to set.
     */
    public void setTextPoint(Point textPoint) {
        this.textPoint = textPoint;
    }

    /**
     * Gets the dimension type.
     *
     * @return Returns the type.
     */
    public int getDimensionType() {
        return dimType;
    }

    /**
     * Sets the dimension type.
     *
     * @param type            The type to set.
     */
    public void setDimensionType(int type) {
        this.dimType = type;
    }

    /**
     * Gets the dimension rotation.
     *
     * @return the dimension rotation
     */
    public double getDimensionRotation() {
        return dimensionRotation;
    }

    /**
     * Sets the dimension rotation.
     *
     * @param dimensionRotation the new dimension rotation
     */
    public void setDimensionRotation(double dimensionRotation) {
        this.dimensionRotation = dimensionRotation;
    }

    /**
     * Gets the dimension text.
     *
     * @return the dimension text
     */
    public String getDimensionText() {
        return dimensionText;
    }

    /**
     * Sets the dimension text.
     *
     * @param dimensionText the new dimension text
     */
    public void setDimensionText(String dimensionText) {
        this.dimensionText = dimensionText;
    }

    /**
     * Gets the horizontal align.
     *
     * @return the horizontal align
     */
    public double getHorizontalAlign() {
        return horizontalAlign;
    }

    /**
     * Sets the horizontal align.
     *
     * @param horizontalAlign the new horizontal align
     */
    public void setHorizontalAlign(double horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    /**
     * Gets the inclination help line.
     *
     * @return the inclination help line
     */
    public double getInclinationHelpLine() {
        return inclinationHelpLine;
    }

    /**
     * Sets the inclination help line.
     *
     * @param inclinationHelpLine the new inclination help line
     */
    public void setInclinationHelpLine(double inclinationHelpLine) {
        this.inclinationHelpLine = inclinationHelpLine;
    }

    /**
     * Gets the leading line length.
     *
     * @return the leading line length
     */
    public double getLeadingLineLength() {
        return leadingLineLength;
    }

    /**
     * Sets the leading line length.
     *
     * @param leadingLineLength the new leading line length
     */
    public void setLeadingLineLength(double leadingLineLength) {
        this.leadingLineLength = leadingLineLength;
    }

    /**
     * Gets the text rotation.
     *
     * @return the text rotation
     */
    public double getTextRotation() {
        return textRotation;
    }

    /**
     * Sets the text rotation.
     *
     * @param textRotation the new text rotation
     */
    public void setTextRotation(double textRotation) {
        this.textRotation = textRotation;
    }

    /**
     * Gets the dimension block.
     *
     * @return the dimension block
     */
    public String getDimensionBlock() {
        return dimensionBlock;
    }

    /**
     * Sets the dimension block.
     *
     * @param dimensionBlock the new dimension block
     */
    public void setDimensionBlock(String dimensionBlock) {
        this.dimensionBlock = dimensionBlock;
    }

    /**
     * Gets the dimension area.
     *
     * @return the dimension area
     */
    public int getDimensionArea() {
        return dimensionArea;
    }

    /**
     * Sets the dimension area.
     *
     * @param dimensionArea the new dimension area
     */
    public void setDimensionArea(int dimensionArea) {
        this.dimensionArea = dimensionArea;
    }

    public Bounds getBounds() {
        // TODO add real bounds
        Bounds bounds = new Bounds();

        if (this.doc.getDXFBlock(this.dimensionBlock) != null) {
            DXFBlock block = doc.getDXFBlock(this.getDimensionBlock());
            Bounds b = block.getBounds();
            Point refPoint = block.getReferencePoint();

            if (b.isValid()) {
                // Translate to origin
                bounds.setMaximumX((b.getMaximumX() - refPoint.getX()));
                bounds.setMinimumX((b.getMinimumX() - refPoint.getX()));
                bounds.setMaximumY((b.getMaximumY() - refPoint.getY()));
                bounds.setMinimumY((b.getMinimumY() - refPoint.getY()));

                // translate to the InsertPoint
                bounds.setMaximumX(bounds.getMaximumX() +
                    this.insertPoint.getX());
                bounds.setMinimumX(bounds.getMinimumX() +
                    this.insertPoint.getX());
                bounds.setMaximumY(bounds.getMaximumY() +
                    this.insertPoint.getY());
                bounds.setMinimumY(bounds.getMinimumY() +
                    this.insertPoint.getY());
                ;
            }
        } else {
            bounds.setValid(false);
        }

        return bounds;
    }

    /**
     * Gets the DXF dimension style.
     *
     * @return the DXF dimension style
     */
    public DXFDimensionStyle getDXFDimensionStyle() {
        return doc.getDXFDimensionStyle(getDimensionStyleID());
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_DIMENSION;
    }

    public double getLength() {
        return 0;
    }
}
