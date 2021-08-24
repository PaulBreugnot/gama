/*******************************************************************************************************
 *
 * DXFLWPolyline.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;


/**
 * The Class DXFLWPolyline.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFLWPolyline extends DXFPolyline {
    
    /** The constantwidth. */
    private double constantwidth = 0.0;
    
    /** The elevation. */
    private double elevation = 0.0;

    /**
     * Instantiates a new DXFLW polyline.
     */
    public DXFLWPolyline() {
    }

    /**
     * Sets the constant width.
     *
     * @param width the new constant width
     */
    public void setConstantWidth(double width) {
        this.constantwidth = width;
    }

    /**
     * Gets the contstant width.
     *
     * @return the contstant width
     */
    public double getContstantWidth() {
        return this.constantwidth;
    }

    /**
     * Gets the elevation.
     *
     * @return Returns the elevation.
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * Sets the elevation.
     *
     * @param elevation            The elevation to set.
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.DXFEntity#getType()
     */
    public String getType() {
        return DXFConstants.ENTITY_TYPE_LWPOLYLINE;
    }
}
