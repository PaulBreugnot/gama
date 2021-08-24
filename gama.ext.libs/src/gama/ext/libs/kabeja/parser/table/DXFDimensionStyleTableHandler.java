/*******************************************************************************************************
 *
 * DXFDimensionStyleTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFDimensionStyle;
import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.entities.AbstractEntityHandler;


/**
 * The Class DXFDimensionStyleTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFDimensionStyleTableHandler extends AbstractTableHandler {
    
    /** The Constant GROUPCODE_NAME. */
    public final static int GROUPCODE_NAME = 2;
    
    /** The style. */
    private DXFDimensionStyle style;
    
    /** The key. */
    private String key = "DIMSTYLE";

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFDimensionStyle(style);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        return key;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case AbstractEntityHandler.FLAGS:
            style.setFlags(value.getIntegerValue());

            break;

        case GROUPCODE_NAME:
            style.setName(value.getValue());

            break;

        default:
            style.setProperty("" + groupCode, value.getValue());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        style = new DXFDimensionStyle();
    }
}
