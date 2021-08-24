/*******************************************************************************************************
 *
 * DXFObjectHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.Handler;


/**
 * The Interface DXFObjectHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface DXFObjectHandler extends Handler {
    
    /**
     * Gets the object type.
     *
     * @return the object type
     */
    public String getObjectType();

    /**
     * Start object.
     */
    public void startObject();

    /**
     * Parses the group.
     *
     * @param groupCode the group code
     * @param value the value
     */
    public void parseGroup(int groupCode, DXFValue value);

    /**
     * End object.
     */
    public void endObject();

    /**
     * Gets the DXF object.
     *
     * @return the DXF object
     */
    public DXFObject getDXFObject();
}
