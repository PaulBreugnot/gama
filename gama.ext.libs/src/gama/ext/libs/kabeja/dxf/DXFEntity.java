/*******************************************************************************************************
 *
 * DXFEntity.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;


/**
 * The Class DXFEntity.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public abstract class DXFEntity {
    
    /** The doc. */
    protected DXFDocument doc;
    
    /** The id. */
    protected String id = "";
    
    /** The layer ID. */
    protected String layerID = "";
    
    /** The visibile. */
    protected boolean visibile = true;
    
    /** The line type. */
    protected String lineType = "";
    
    /** The flags. */
    protected int flags = 0;
    
    /** The block. */
    protected boolean block = false;
    
    /** The linetype scale factor. */
    protected double linetypeScaleFactor = 1.0;
    
    /** The color. */
    protected int color = 0;
    
    /** The color RGB. */
    protected byte[] colorRGB;
    
    /** The line weight. */
    protected int lineWeight;
    
    /** The transparency. */
    protected double transparency;
    
    /** The thickness. */
    protected double thickness = 0.0;
    
    /** The extrusion. */
    protected DXFExtrusion extrusion = new DXFExtrusion();

    /**
     * From the DXF Specs default all entities are in model space.
     */
    protected boolean modelSpace = true;

    /**
     * Instantiates a new DXF entity.
     */
    public DXFEntity() {
    }

    /**
     * Sets the DXF document.
     *
     * @param doc the new DXF document
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /**
     * Gets the DXF document.
     *
     * @return the DXF document
     */
    public DXFDocument getDXFDocument() {
        return this.doc;
    }

    /**
     * Gives the name of the layer, which containts the entity.
     * @return the name of the layer
     */
    public String getLayerName() {
        return this.layerID;
    }

    /**
     * Set the name of the layer, which containts the entity.
     *
     * @param id the new layer name
     * @return the name of the layer
     */
    public void setLayerName(String id) {
        this.layerID = id;
    }

    //    public abstract void toSAX(ContentHandler handler, Map svgContext)
    /**
     * Gets the bounds.
     *
     * @return the bounds
     */
    //        throws SAXException;
    public abstract Bounds getBounds();

    /**
     * Gets the line type.
     *
     * @return Returns the lineType.
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * Sets the line type.
     *
     * @param lineType            The lineType to set.
     */
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    /**
     * Checks if is visibile.
     *
     * @return Returns the visibile.
     */
    public boolean isVisibile() {
        return visibile;
    }

    /**
     * Sets the visibile.
     *
     * @param visibile            The visibile to set.
     */
    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
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
     * Sets the block entity.
     *
     * @param b the new block entity
     */
    public void setBlockEntity(boolean b) {
        this.block = b;
    }

    /**
     * Checks if is block entity.
     *
     * @return true, if is block entity
     */
    public boolean isBlockEntity() {
        return block;
    }

    /**
     * Sets the extrusion.
     *
     * @param extrusion the new extrusion
     */
    public void setExtrusion(DXFExtrusion extrusion) {
        this.extrusion = extrusion;
    }

    /**
     * Gets the extrusion.
     *
     * @return the extrusion
     */
    public DXFExtrusion getExtrusion() {
        return extrusion;
    }

    /**
     * Gets the linetype scale factor.
     *
     * @return the linetype scale factor
     */
    public double getLinetypeScaleFactor() {
        return linetypeScaleFactor;
    }

    /**
     * Sets the linetype scale factor.
     *
     * @param linetypeScaleFactor the new linetype scale factor
     */
    public void setLinetypeScaleFactor(double linetypeScaleFactor) {
        this.linetypeScaleFactor = linetypeScaleFactor;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets the color.
     *
     * @param color the new color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Gets the color RGB.
     *
     * @return the color RGB
     */
    public byte[] getColorRGB() {
        return colorRGB;
    }

    /**
     * Sets the color RGB.
     *
     * @param colorRGB the new color RGB
     */
    public void setColorRGB(byte[] colorRGB) {
        this.colorRGB = colorRGB;
    }

    /**
     * Gets the line weight.
     *
     * @return the line weight
     */
    public int getLineWeight() {
        return lineWeight;
    }

    /**
     * Sets the line weight.
     *
     * @param lineWeight the new line weight
     */
    public void setLineWeight(int lineWeight) {
        this.lineWeight = lineWeight;
    }

    /**
     * Gets the transparency.
     *
     * @return the transparency
     */
    public double getTransparency() {
        return transparency;
    }

    /**
     * Sets the transparency.
     *
     * @param transparency the new transparency
     */
    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the extrusion X.
     *
     * @param x the new extrusion X
     */
    public void setExtrusionX(double x) {
        extrusion.setX(x);
    }

    /**
     * Sets the extrusion Y.
     *
     * @param y the new extrusion Y
     */
    public void setExtrusionY(double y) {
        extrusion.setY(y);
    }

    /**
     * Sets the extrusion Z.
     *
     * @param z the new extrusion Z
     */
    public void setExtrusionZ(double z) {
        extrusion.setZ(z);
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public abstract String getType();

    /**
     * The thickness reflects the height of the entity.
     *
     *
     * @return Returns the thickness.
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Sets the thickness.
     *
     * @param thickness            The thickness /height of the entity to set.
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    /**
     * Checks if is omit line type.
     *
     * @return true, if is omit line type
     */
    public boolean isOmitLineType() {
        return false;
    }

    /**
     * Checks if is model space.
     *
     * @return Returns the modelSpace.
     */
    public boolean isModelSpace() {
        return modelSpace;
    }

    /**
     * Sets the model space.
     *
     * @param modelSpace The modelSpace to set.
     */
    public void setModelSpace(boolean modelSpace) {
        this.modelSpace = modelSpace;
    }

    /**
     * Returns the length of the entity or 0 if the entity has no length.
     *
     * @return the length
     */
    public abstract double getLength();
}
