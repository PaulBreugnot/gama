/*******************************************************************************************************
 *
 * DXFHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.dxf;

import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.ParseException;


/**
 * The Interface DXFHandler.
 */
public interface DXFHandler {
    
    /**
     * Parses the group.
     *
     * @param groupCode the group code
     * @param value the value
     * @throws ParseException the parse exception
     */
    public void parseGroup(int groupCode, DXFValue value)
        throws ParseException;
}
