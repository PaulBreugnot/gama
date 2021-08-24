/*******************************************************************************************************
 *
 * DXFPlotSettings.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

import gama.ext.libs.kabeja.dxf.Bounds;
import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class DXFPlotSettings.
 */
public class DXFPlotSettings extends DXFObject {
    
    /** The name. */
    protected String name = "";
    
    /** The config name. */
    protected String configName = "";
    
    /** The canonical media name. */
    protected String canonicalMediaName = "";
    
    /** The plot view name. */
    protected String plotViewName = "";
    
    /** The current stylesheet. */
    protected String currentStylesheet = "";

    /** The margins stored [top,right,bottom,left]. */
    protected double[] margin = new double[4];
    
    /** The plot origin. */
    protected Point plotOrigin = new Point();
    
    /** The paper width. */
    protected double paperWidth;
    
    /** The paper height. */
    protected double paperHeight;
    
    /** The paper units. */
    protected int paperUnits = 0;
    
    /** The flags. */
    protected int flags = 0;
    
    /** The plot type. */
    protected int plotType = 0;
    
    /** The plot rotation. */
    protected int plotRotation = 0;
    
    /** The window to plot. */
    protected Bounds windowToPlot = new Bounds();
    
    /** The custom scale numerator. */
    protected double customScaleNumerator = 1.0;
    
    /** The custom scale denominator. */
    protected double customScaleDenominator = 1.0;

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_PLOTSETTINGS;
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
     * Gets the config name.
     *
     * @return the config name
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * Sets the config name.
     *
     * @param configName the new config name
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * Gets the canonical media name.
     *
     * @return the canonical media name
     */
    public String getCanonicalMediaName() {
        return canonicalMediaName;
    }

    /**
     * Sets the canonical media name.
     *
     * @param canonicalMediaName the new canonical media name
     */
    public void setCanonicalMediaName(String canonicalMediaName) {
        this.canonicalMediaName = canonicalMediaName;
    }

    /**
     * Gets the plot view name.
     *
     * @return the plot view name
     */
    public String getPlotViewName() {
        return plotViewName;
    }

    /**
     * Sets the plot view name.
     *
     * @param plotViewName the new plot view name
     */
    public void setPlotViewName(String plotViewName) {
        this.plotViewName = plotViewName;
    }

    /**
     * Gets the current stylesheet.
     *
     * @return the current stylesheet
     */
    public String getCurrentStylesheet() {
        return currentStylesheet;
    }

    /**
     * Sets the current stylesheet.
     *
     * @param currentStylesheet the new current stylesheet
     */
    public void setCurrentStylesheet(String currentStylesheet) {
        this.currentStylesheet = currentStylesheet;
    }

    /**
     * Gets the margin.
     *
     * @return the margin
     */
    public double[] getMargin() {
        return margin;
    }

    /**
     * Sets the margin.
     *
     * @param margin the new margin
     */
    public void setMargin(double[] margin) {
        this.margin = margin;
    }

    /**
     * Gets the plot origin.
     *
     * @return the plot origin
     */
    public Point getPlotOrigin() {
        return plotOrigin;
    }

    /**
     * Sets the plot origin.
     *
     * @param plotOrigin the new plot origin
     */
    public void setPlotOrigin(Point plotOrigin) {
        this.plotOrigin = plotOrigin;
    }

    /**
     * Gets the paper width.
     *
     * @return the paper width
     */
    public double getPaperWidth() {
        return paperWidth;
    }

    /**
     * Sets the paper width.
     *
     * @param paperWidth the new paper width
     */
    public void setPaperWidth(double paperWidth) {
        this.paperWidth = paperWidth;
    }

    /**
     * Gets the paper height.
     *
     * @return the paper height
     */
    public double getPaperHeight() {
        return paperHeight;
    }

    /**
     * Sets the paper height.
     *
     * @param paperHeight the new paper height
     */
    public void setPaperHeight(double paperHeight) {
        this.paperHeight = paperHeight;
    }

    /**
     * Gets the paper unit.
     *
     * @return the paper unit
     */
    public int getPaperUnit() {
        return paperUnits;
    }

    /**
     * Sets the paper unit.
     *
     * @param paperUnits the new paper unit
     */
    public void setPaperUnit(int paperUnits) {
        this.paperUnits = paperUnits;
    }

    /**
     * Gets the flags.
     *
     * @return the flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Sets the flags.
     *
     * @param flags the new flags
     */
    public void setFlags(int flags) {
        this.flags = flags;
    }

    /**
     * Gets the plot type.
     *
     * @return the plot type
     */
    public int getPlotType() {
        return plotType;
    }

    /**
     * Sets the plot type.
     *
     * @param plotType the new plot type
     */
    public void setPlotType(int plotType) {
        this.plotType = plotType;
    }

    /**
     * Gets the plot rotation.
     *
     * @return the plot rotation
     */
    public int getPlotRotation() {
        return plotRotation;
    }

    /**
     * Sets the plot rotation.
     *
     * @param plotRotation the new plot rotation
     */
    public void setPlotRotation(int plotRotation) {
        this.plotRotation = plotRotation;
    }

    /**
     * Gets the window to plot.
     *
     * @return the window to plot
     */
    public Bounds getWindowToPlot() {
        return windowToPlot;
    }

    /**
     * Sets the window to plot.
     *
     * @param windowToPlot the new window to plot
     */
    public void setWindowToPlot(Bounds windowToPlot) {
        this.windowToPlot = windowToPlot;
    }

    /**
     * Gets the custom scale numerator.
     *
     * @return the custom scale numerator
     */
    public double getCustomScaleNumerator() {
        return customScaleNumerator;
    }

    /**
     * Sets the custom scale numerator.
     *
     * @param customScaleNumerator the new custom scale numerator
     */
    public void setCustomScaleNumerator(double customScaleNumerator) {
        this.customScaleNumerator = customScaleNumerator;
    }

    /**
     * Gets the custom scale denominator.
     *
     * @return the custom scale denominator
     */
    public double getCustomScaleDenominator() {
        return customScaleDenominator;
    }

    /**
     * Sets the custom scale denominator.
     *
     * @param customScaleDenominator the new custom scale denominator
     */
    public void setCustomScaleDenominator(double customScaleDenominator) {
        this.customScaleDenominator = customScaleDenominator;
    }

    /**
     * Gets the custom scale.
     *
     * @return the custom scale
     */
    public double getCustomScale() {
        return this.customScaleNumerator / this.customScaleDenominator;
    }
}
