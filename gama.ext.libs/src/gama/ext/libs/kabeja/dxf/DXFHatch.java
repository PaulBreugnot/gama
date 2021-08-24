/*******************************************************************************************************
 *
 * DXFHatch.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.helpers.HatchBoundaryLoop;
import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class DXFHatch.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFHatch extends DXFEntity {
    
    /** The name. */
    private String name = "";
    
    /** The solid. */
    private boolean solid = false;
    
    /** The associativity flag. */
    private int associativityFlag = 0;
    
    /** The boundary path count. */
    private int boundaryPathCount = 0;
    
    /** The hatch style. */
    private int hatchStyle = 0;
    
    /** The pattern type. */
    private int patternType = 0;
    
    /** The pattern angle. */
    private double patternAngle = 0.0;
    
    /** The pattern scale spacing. */
    private double patternScaleSpacing = 1.0;
    
    /** The boundary annotation. */
    private boolean boundaryAnnotation = false;
    
    /** The pattern double. */
    private boolean patternDouble = false;
    
    /** The defination lines count. */
    private int definationLinesCount = 0;
    
    /** The pixel size. */
    private double pixelSize = 0.0;
    
    /** The seed point count. */
    private int seedPointCount = 0;
    
    /** The offset vector. */
    private double offsetVector = 0.0;
    
    /** The degenerate boundary path count. */
    private int degenerateBoundaryPathCount = 0;
    
    /** The gradient hatch. */
    private boolean gradientHatch = false;
    
    /** The elevation point. */
    private Point elevationPoint = new Point();
    
    /** The boundaries. */
    private List boundaries = new ArrayList();
    
    /** The patterns. */
    private List patterns = new ArrayList();
    
    /** The pattern ID. */
    private String patternID = "";
    
    /** The pattern scale. */
    private double patternScale;

    /**
     * Instantiates a new DXF hatch.
     */
    public DXFHatch() {
    }

    /**
     * Gets the associativity flag.
     *
     * @return Returns the associativityFlag.
     */
    public int getAssociativityFlag() {
        return associativityFlag;
    }

    /**
     * Sets the associativity flag.
     *
     * @param associativityFlag            The associativityFlag to set.
     */
    public void setAssociativityFlag(int associativityFlag) {
        this.associativityFlag = associativityFlag;
    }

    /**
     * Checks if is boundary annotation.
     *
     * @return Returns the boundaryAnnotation.
     */
    public boolean isBoundaryAnnotation() {
        return boundaryAnnotation;
    }

    /**
     * Sets the boundary annotation.
     *
     * @param boundaryAnnotation            The boundaryAnnotation to set.
     */
    public void setBoundaryAnnotation(boolean boundaryAnnotation) {
        this.boundaryAnnotation = boundaryAnnotation;
    }

    /**
     * Gets the boundary path count.
     *
     * @return Returns the boundaryPathCount.
     */
    public int getBoundaryPathCount() {
        return boundaryPathCount;
    }

    /**
     * Sets the boundary path count.
     *
     * @param boundaryPathCount            The boundaryPathCount to set.
     */
    public void setBoundaryPathCount(int boundaryPathCount) {
        this.boundaryPathCount = boundaryPathCount;
    }

    /**
     * Gets the defination lines count.
     *
     * @return Returns the definationLinesCount.
     */
    public int getDefinationLinesCount() {
        return definationLinesCount;
    }

    /**
     * Sets the defination lines count.
     *
     * @param definationLinesCount            The definationLinesCount to set.
     */
    public void setDefinationLinesCount(int definationLinesCount) {
        this.definationLinesCount = definationLinesCount;
    }

    /**
     * Gets the degenerate boundary path count.
     *
     * @return Returns the degenerateBoundaryPathCount.
     */
    public int getDegenerateBoundaryPathCount() {
        return degenerateBoundaryPathCount;
    }

    /**
     * Sets the degenerate boundary path count.
     *
     * @param degenerateBoundaryPathCount            The degenerateBoundaryPathCount to set.
     */
    public void setDegenerateBoundaryPathCount(int degenerateBoundaryPathCount) {
        this.degenerateBoundaryPathCount = degenerateBoundaryPathCount;
    }

    /**
     * Checks if is gradient hatch.
     *
     * @return Returns the gradientHatch.
     */
    public boolean isGradientHatch() {
        return gradientHatch;
    }

    /**
     * Sets the gradient hatch.
     *
     * @param gradientHatch            The gradientHatch to set.
     */
    public void setGradientHatch(boolean gradientHatch) {
        this.gradientHatch = gradientHatch;
    }

    /**
     * Gets the hatch style.
     *
     * @return Returns the hatchStyle.
     */
    public int getHatchStyle() {
        return hatchStyle;
    }

    /**
     * Sets the hatch style.
     *
     * @param hatchStyle            The hatchStyle to set.
     */
    public void setHatchStyle(int hatchStyle) {
        this.hatchStyle = hatchStyle;
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
     * Gets the offset vector.
     *
     * @return Returns the offsetVector.
     */
    public double getOffsetVector() {
        return offsetVector;
    }

    /**
     * Sets the offset vector.
     *
     * @param offsetVector            The offsetVector to set.
     */
    public void setOffsetVector(double offsetVector) {
        this.offsetVector = offsetVector;
    }

    /**
     * Gets the pattern angle.
     *
     * @return Returns the patternAngle.
     */
    public double getPatternAngle() {
        return patternAngle;
    }

    /**
     * Sets the pattern angle.
     *
     * @param patternAngle            The patternAngle to set.
     */
    public void setPatternAngle(double patternAngle) {
        this.patternAngle = patternAngle;
    }

    /**
     * Checks if is pattern double.
     *
     * @return Returns the patternDouble.
     */
    public boolean isPatternDouble() {
        return patternDouble;
    }

    /**
     * Sets the pattern double.
     *
     * @param patternDouble            The patternDouble to set.
     */
    public void setPatternDouble(boolean patternDouble) {
        this.patternDouble = patternDouble;
    }

    /**
     * Gets the pattern scale spacing.
     *
     * @return Returns the patternScaleSpacing.
     */
    public double getPatternScaleSpacing() {
        return patternScaleSpacing;
    }

    /**
     * Sets the pattern scale spacing.
     *
     * @param patternScaleSpacing            The patternScaleSpacing to set.
     */
    public void setPatternScaleSpacing(double patternScaleSpacing) {
        this.patternScaleSpacing = patternScaleSpacing;
    }

    /**
     * Gets the pattern type.
     *
     * @return Returns the patternType.
     */
    public int getPatternType() {
        return patternType;
    }

    /**
     * Sets the pattern type.
     *
     * @param patternType            The patternType to set.
     */
    public void setPatternType(int patternType) {
        this.patternType = patternType;
    }

    /**
     * Gets the pixel size.
     *
     * @return Returns the pixelSize.
     */
    public double getPixelSize() {
        return pixelSize;
    }

    /**
     * Sets the pixel size.
     *
     * @param pixelSize            The pixelSize to set.
     */
    public void setPixelSize(double pixelSize) {
        this.pixelSize = pixelSize;
    }

    /**
     * Gets the seed point count.
     *
     * @return Returns the seedPointCount.
     */
    public int getSeedPointCount() {
        return seedPointCount;
    }

    /**
     * Sets the seed point count.
     *
     * @param seedPointCount            The seedPointCount to set.
     */
    public void setSeedPointCount(int seedPointCount) {
        this.seedPointCount = seedPointCount;
    }

    /**
     * Checks if is solid.
     *
     * @return Returns the solid.
     */
    public boolean isSolid() {
        return this.flags == 1;
    }

    /**
     * Sets the solid.
     *
     * @param solid            The solid to set.
     */
    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    /**
     * Adds the boundary loop.
     *
     * @param loop the loop
     */
    public void addBoundaryLoop(HatchBoundaryLoop loop) {
        this.boundaries.add(loop);
    }

    /**
     * Gets the boundary loops.
     *
     * @return the boundary loops
     */
    public Iterator getBoundaryLoops() {
        return this.boundaries.iterator();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        Iterator i = this.boundaries.iterator();

        while (i.hasNext()) {
            HatchBoundaryLoop loop = (HatchBoundaryLoop) i.next();
            Bounds b = loop.getBounds();

            if (b.isValid()) {
                bounds.addToBounds(b);
            }
        }

        return bounds;
    }

    /**
     * Gets the elevation point.
     *
     * @return Returns the elevationPoint.
     */
    public Point getElevationPoint() {
        return elevationPoint;
    }

    /**
     * Sets the elevation point.
     *
     * @param elevationPoint            The elevationPoint to set.
     */
    public void setElevationPoint(Point elevationPoint) {
        this.elevationPoint = elevationPoint;
    }

    public String getType() {
        return DXFConstants.ENTITY_TYPE_HATCH;
    }

    /**
     * Gets the DXF hatch pattern ID.
     *
     * @return Returns the ID of the pattern (also called pattern name).
     */
    public String getDXFHatchPatternID() {
        return this.patternID;
    }

    /**
     * Sets the DXF hatch pattern ID.
     *
     * @param patternID            The patternID to set.
     */
    public void setDXFHatchPatternID(String patternID) {
        this.patternID = patternID;
    }

    public double getLength() {
        return 0;
    }

    /**
     * Gets the pattern scale.
     *
     * @return the pattern scale
     */
    public double getPatternScale() {
        return patternScale;
    }

    /**
     * Sets the pattern scale.
     *
     * @param patternScale the new pattern scale
     */
    public void setPatternScale(double patternScale) {
        this.patternScale = patternScale;
    }
}
