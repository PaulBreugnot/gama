/*******************************************************************************************************
 *
 * DXFObject.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 * The Class DXFObject.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public abstract class DXFObject {
    
    /** The doc. */
    protected DXFDocument doc;
    
    /** The soft ID. */
    protected String softID;
    
    /** The hard ID. */
    protected String hardID;
    
    /** The handle ID. */
    protected String handleID;

    /**
     * Gets the soft pointer ID.
     *
     * @return the soft pointer ID
     */
    public String getSoftPointerID() {
        return softID;
    }

    /**
     * Sets the soft pointer ID.
     *
     * @param id the new soft pointer ID
     */
    public void setSoftPointerID(String id) {
        this.softID = id;
    }

    /**
     * Gets the hard owner ID.
     *
     * @return the hard owner ID
     */
    public String getHardOwnerID() {
        return hardID;
    }

    /**
     * Sets the hard owner ID.
     *
     * @param id the new hard owner ID
     */
    public void setHardOwnerID(String id) {
        this.hardID = id;
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
     * Gets the object type.
     *
     * @return the object type
     */
    public abstract String getObjectType();

    /**
     * Gets the id.
     *
     * @return Returns the handleID.
     */
    public String getID() {
        return handleID;
    }

    /**
     * Sets the id.
     *
     * @param handleID The handleID to set.
     */
    public void setID(String handleID) {
        this.handleID = handleID;
    }
}
