/*******************************************************************************************************
 *
 * DXF3DSolidHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXF3DSolid;
import gama.ext.libs.kabeja.dxf.DXFConstants;


/**
 * The Class DXF3DSolidHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXF3DSolidHandler extends DXFRegionHandler {
    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.AbstractEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        // TODO Auto-generated method stub
        return DXFConstants.ENTITY_TYPE_3DSOLID;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        region = new DXF3DSolid();
    }
}
