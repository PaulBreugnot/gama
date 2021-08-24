/*******************************************************************************************************
 *
 * DXFVertex.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.math.TransformContext;


/**
 * The Class DXFVertex.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFVertex extends DXFPoint {
    
    /** The start width. */
    private double startWidth = 0.0;
    
    /** The end width. */
    private double endWidth = 0.0;
    
    /** The bulge. */
    private double bulge = 0;
    
    /** The poly face mesh vertex 0. */
    private int polyFaceMeshVertex0;
    
    /** The poly face mesh vertex 1. */
    private int polyFaceMeshVertex1;
    
    /** The poly face mesh vertex 2. */
    private int polyFaceMeshVertex2;
    
    /** The poly face mesh vertex 3. */
    private int polyFaceMeshVertex3;

    /**
     * Instantiates a new DXF vertex.
     */
    public DXFVertex() {
        super();
    }

    /**
     * Instantiates a new DXF vertex.
     *
     * @param p the p
     */
    public DXFVertex(Point p) {
        super(p);
    }

    /**
     * Gets the end width.
     *
     * @return Returns the endWidth.
     */
    public double getEndWidth() {
        return endWidth;
    }

    /**
     * Sets the end width.
     *
     * @param endWidth            The endWidth to set.
     */
    public void setEndWidth(double endWidth) {
        this.endWidth = endWidth;
    }

    /**
     * Gets the start width.
     *
     * @return Returns the startWidth.
     */
    public double getStartWidth() {
        return startWidth;
    }

    /**
     * Sets the start width.
     *
     * @param startWidth            The startWidth to set.
     */
    public void setStartWidth(double startWidth) {
        this.startWidth = startWidth;
    }

    /**
     * To SAX.
     *
     * @param handler the handler
     * @param svgContext the svg context
     * @param entity the entity
     * @param transformContext the transform context
     * @throws SAXException the SAX exception
     */
    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.dxf.DXFEntity#toSAX(org.xml.sax.ContentHandler)
     */
    public void toSAX(ContentHandler handler, Map svgContext, DXFEntity entity,
        TransformContext transformContext) throws SAXException {
    }

    public Bounds getBounds() {
        return super.getBounds();
    }

    /**
     * Gets the bulge.
     *
     * @return Returns the bulge.
     */
    public double getBulge() {
        return bulge;
    }

    /**
     * Sets the bulge.
     *
     * @param bulge            The bulge to set.
     */
    public void setBulge(double bulge) {
        this.bulge = bulge;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_VERTEX;
    }

    /**
     * Checks if is constant width.
     *
     * @return true, if is constant width
     */
    public boolean isConstantWidth() {
        return endWidth == startWidth;
    }

    /**
     * Checks if is curve fit vertex.
     *
     * @return true, if is curve fit vertex
     */
    public boolean isCurveFitVertex() {
        return (this.flags & 1) == 1;
    }

    /**
     * Checks if is tagent used.
     *
     * @return true, if is tagent used
     */
    public boolean isTagentUsed() {
        return (this.flags & 2) == 2;
    }

    /**
     * Checks if is 2 D spline control vertex.
     *
     * @return true, if is 2 D spline control vertex
     */
    public boolean is2DSplineControlVertex() {
        return (this.flags & 16) == 16;
    }

    /**
     * Checks if is 2 D spline approximation vertex.
     *
     * @return true, if is 2 D spline approximation vertex
     */
    public boolean is2DSplineApproximationVertex() {
        return (this.flags & 8) == 8;
    }

    /**
     * Checks if is poly face mesh vertex.
     *
     * @return true, if is poly face mesh vertex
     */
    public boolean isPolyFaceMeshVertex() {
        //bit 7 and 8 are set
        return (((this.flags & 64) == 64) && ((this.flags & 128) == 128));
    }

    /**
     * Checks if is face record.
     *
     * @return true, if is face record
     */
    public boolean isFaceRecord() {
        return this.flags == 128;
    }

    /**
     * Checks if is mesh approximation vertex.
     *
     * @return true, if is mesh approximation vertex
     */
    public boolean isMeshApproximationVertex() {
        return ((this.flags & 64) == 64) && ((this.flags & 8) == 8);
    }

    /**
     * Gets the poly face mesh vertex 0.
     *
     * @return Returns the polyFaceMeshVertex0.
     */
    public int getPolyFaceMeshVertex0() {
        return Math.abs(polyFaceMeshVertex0);
    }

    /**
     * Sets the poly face mesh vertex 0.
     *
     * @param polyFaceMeshVertex0 The polyFaceMeshVertex0 to set.
     */
    public void setPolyFaceMeshVertex0(int polyFaceMeshVertex0) {
        this.polyFaceMeshVertex0 = polyFaceMeshVertex0;
    }

    /**
     * Gets the poly face mesh vertex 1.
     *
     * @return Returns the polyFaceMeshVertex1.
     */
    public int getPolyFaceMeshVertex1() {
        return Math.abs(polyFaceMeshVertex1);
    }

    /**
     * Sets the poly face mesh vertex 1.
     *
     * @param polyFaceMeshVertex1 The polyFaceMeshVertex1 to set.
     */
    public void setPolyFaceMeshVertex1(int polyFaceMeshVertex1) {
        this.polyFaceMeshVertex1 = polyFaceMeshVertex1;
    }

    /**
     * Gets the poly face mesh vertex 2.
     *
     * @return Returns the polyFaceMeshVertex2.
     */
    public int getPolyFaceMeshVertex2() {
        return Math.abs(polyFaceMeshVertex2);
    }

    /**
     * Sets the poly face mesh vertex 2.
     *
     * @param polyFaceMeshVertex2 The polyFaceMeshVertex2 to set.
     */
    public void setPolyFaceMeshVertex2(int polyFaceMeshVertex2) {
        this.polyFaceMeshVertex2 = polyFaceMeshVertex2;
    }

    /**
     * Gets the poly face mesh vertex 3.
     *
     * @return Returns the polyFaceMeshVertex3.
     */
    public int getPolyFaceMeshVertex3() {
        return Math.abs(polyFaceMeshVertex3);
    }

    /**
     * Sets the poly face mesh vertex 3.
     *
     * @param polyFaceMeshVertex3 The polyFaceMeshVertex3 to set.
     */
    public void setPolyFaceMeshVertex3(int polyFaceMeshVertex3) {
        this.polyFaceMeshVertex3 = polyFaceMeshVertex3;
    }

    /**
     * Checks if is poly face edge 0 visible.
     *
     * @return true, if is poly face edge 0 visible
     */
    public boolean isPolyFaceEdge0Visible() {
        return this.polyFaceMeshVertex0 > 0;
    }

    /**
     * Checks if is poly face edge 1 visible.
     *
     * @return true, if is poly face edge 1 visible
     */
    public boolean isPolyFaceEdge1Visible() {
        return this.polyFaceMeshVertex1 > 0;
    }

    /**
     * Checks if is poly face edge 2 visible.
     *
     * @return true, if is poly face edge 2 visible
     */
    public boolean isPolyFaceEdge2Visible() {
        return this.polyFaceMeshVertex2 > 0;
    }

    /**
     * Checks if is poly face edge 3 visible.
     *
     * @return true, if is poly face edge 3 visible
     */
    public boolean isPolyFaceEdge3Visible() {
        return this.polyFaceMeshVertex3 > 0;
    }
}
