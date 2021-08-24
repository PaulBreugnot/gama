/*******************************************************************************************************
 *
 * DXF3DFaceHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXF3DFace;
import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class DXF3DFaceHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXF3DFaceHandler extends DXFSolidHandler {
    
    /** The entity name. */
    protected String ENTITY_NAME = "TRACE";

    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_3DFACE;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        solid = new DXF3DFace();
    }
}
