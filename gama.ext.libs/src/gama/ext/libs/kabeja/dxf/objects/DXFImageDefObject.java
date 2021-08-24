/*******************************************************************************************************
 *
 * DXFImageDefObject.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.objects;

import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class DXFImageDefObject.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFImageDefObject extends DXFObject {
    
    /** The filename. */
    protected String filename;

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.dxf.objects.DXFObject#getObjectType()
     */
    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_IMAGEDEF;
    }

    /**
     * Gets the filename.
     *
     * @return Returns the filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the filename.
     *
     * @param filename The filename to set.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
