/*******************************************************************************************************
 *
 * DXFImage.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.dxf.objects.DXFImageDefObject;


/**
 * The Class DXFImage.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFImage extends DXFEntity {
    
    /** The insert point. */
    protected Point insertPoint = new Point();
    
    /** The vector V. */
    protected Point vectorV = new Point();
    
    /** The vector U. */
    protected Point vectorU = new Point();
    
    /** The image size along U. */
    protected double imageSizeAlongU;
    
    /** The image size along V. */
    protected double imageSizeAlongV;
    
    /** The image def ID. */
    protected String imageDefID = "";
    
    /** The brightness. */
    protected double brightness;
    
    /** The contrast. */
    protected double contrast;
    
    /** The fade. */
    protected double fade;
    
    /** The clip boundary. */
    protected ArrayList clipBoundary = new ArrayList();
    
    /** The clipping. */
    protected boolean clipping = false;
    
    /** The rectangular clipping. */
    protected boolean rectangularClipping = false;
    
    /** The polygonal clipping. */
    protected boolean polygonalClipping = false;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFEntity#getBounds()
     */
    public Bounds getBounds() {
        Bounds b = new Bounds();
        DXFImageDefObject imageDef = (DXFImageDefObject) this.doc.getDXFObjectByID(this.getImageDefObjectID());

        if (imageDef != null) {
            b.addToBounds(this.insertPoint);
            b.addToBounds(insertPoint.getX() + imageSizeAlongU,
                insertPoint.getY() + imageSizeAlongV, this.insertPoint.getZ());
        } else {
            b.setValid(false);
        }

        return b;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_IMAGE;
    }

    /**
     * Gets the insert point.
     *
     * @return the insert point
     */
    public Point getInsertPoint() {
        return insertPoint;
    }

    /**
     * Sets the insert point.
     *
     * @param p the new insert point
     */
    public void setInsertPoint(Point p) {
        this.insertPoint = p;
    }

    /**
     * Sets the image def object ID.
     *
     * @param id the new image def object ID
     */
    public void setImageDefObjectID(String id) {
        this.imageDefID = id;
    }

    /**
     * Gets the image def object ID.
     *
     * @return the image def object ID
     */
    public String getImageDefObjectID() {
        return this.imageDefID;
    }

    /**
     * Gets the image size along U.
     *
     * @return Returns the imageSizeAlongU.
     */
    public double getImageSizeAlongU() {
        return imageSizeAlongU;
    }

    /**
     * Sets the image size along U.
     *
     * @param imageSizeAlongU            The imageSizeAlongU to set.
     */
    public void setImageSizeAlongU(double imageSizeAlongU) {
        this.imageSizeAlongU = imageSizeAlongU;
    }

    /**
     * Gets the image size along V.
     *
     * @return Returns the imageSizeAlongV.
     */
    public double getImageSizeAlongV() {
        return imageSizeAlongV;
    }

    /**
     * Sets the image size along V.
     *
     * @param imageSizeAlongV            The imageSizeAlongV to set.
     */
    public void setImageSizeAlongV(double imageSizeAlongV) {
        this.imageSizeAlongV = imageSizeAlongV;
    }

    /**
     * Gets the vector U.
     *
     * @return Returns the vectorU.
     */
    public Point getVectorU() {
        return vectorU;
    }

    /**
     * Sets the vector U.
     *
     * @param vectorU            The vectorU to set.
     */
    public void setVectorU(Point vectorU) {
        this.vectorU = vectorU;
    }

    /**
     * Gets the vector V.
     *
     * @return Returns the vectorV.
     */
    public Point getVectorV() {
        return vectorV;
    }

    /**
     * Sets the vector V.
     *
     * @param vectorV            The vectorV to set.
     */
    public void setVectorV(Point vectorV) {
        this.vectorV = vectorV;
    }

    /**
     * Gets the brightness.
     *
     * @return Returns the brightness.
     */
    public double getBrightness() {
        return brightness;
    }

    /**
     * Sets the brightness.
     *
     * @param brightness            The brightness to set.
     */
    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    /**
     * Checks if is clipping.
     *
     * @return Returns the clipping.
     */
    public boolean isClipping() {
        return clipping;
    }

    /**
     * Sets the clipping.
     *
     * @param clipping            The clipping to set.
     */
    public void setClipping(boolean clipping) {
        this.clipping = clipping;
    }

    /**
     * Gets the contrast.
     *
     * @return Returns the contrast.
     */
    public double getContrast() {
        return contrast;
    }

    /**
     * Sets the contrast.
     *
     * @param contrast            The contrast to set.
     */
    public void setContrast(double contrast) {
        this.contrast = contrast;
    }

    /**
     * Gets the fade.
     *
     * @return Returns the fade.
     */
    public double getFade() {
        return fade;
    }

    /**
     * Sets the fade.
     *
     * @param fade            The fade to set.
     */
    public void setFade(double fade) {
        this.fade = fade;
    }

    /**
     * Gets the clip boundary.
     *
     * @return Returns the clipBoundary.
     */
    public ArrayList getClipBoundary() {
        return clipBoundary;
    }

    /**
     * Adds the clipping point.
     *
     * @param p the p
     */
    public void addClippingPoint(Point p) {
        clipBoundary.add(p);
    }

    /**
     * Checks if is polygonal clipping.
     *
     * @return Returns the polygonalClipping.
     */
    public boolean isPolygonalClipping() {
        return polygonalClipping;
    }

    /**
     * Sets the polygonal clipping.
     *
     * @param polygonalClipping            The polygonalClipping to set.
     */
    public void setPolygonalClipping(boolean polygonalClipping) {
        this.polygonalClipping = polygonalClipping;
        this.rectangularClipping = !polygonalClipping;
    }

    /**
     * Checks if is rectangular clipping.
     *
     * @return Returns the rectangularClipping.
     */
    public boolean isRectangularClipping() {
        return rectangularClipping;
    }

    /**
     * Sets the rectangular clipping.
     *
     * @param rectangularClipping            The rectangularClipping to set.
     */
    public void setRectangularClipping(boolean rectangularClipping) {
        this.rectangularClipping = rectangularClipping;
        this.polygonalClipping = !rectangularClipping;
    }

    public double getLength() {
        return 0;
    }
}
