/*******************************************************************************************************
 *
 * DXFTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.Handler;


/**
 * The Interface DXFTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface DXFTableHandler extends Handler {
    
    /**
     * Gets the table key.
     *
     * @return the table key
     */
    public String getTableKey();

    public void setDXFDocument(DXFDocument doc);

    /**
     * Start parsing.
     */
    public void startParsing();

    /**
     * Parses the group.
     *
     * @param groupCode the group code
     * @param value the value
     */
    public void parseGroup(int groupCode, DXFValue value);

    /**
     * End parsing.
     */
    public void endParsing();
}
