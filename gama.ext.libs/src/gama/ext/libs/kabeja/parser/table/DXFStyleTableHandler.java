/*******************************************************************************************************
 *
 * DXFStyleTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFStyle;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFStyleTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFStyleTableHandler extends AbstractTableHandler {
    
    /** The table key. */
    public static String TABLE_KEY = "STYLE";
    
    /** The Constant GROUPCODE_NAME. */
    public final static int GROUPCODE_NAME = 2;
    
    /** The Constant GROUPCODE_TEXT_HEIGHT. */
    public final static int GROUPCODE_TEXT_HEIGHT = 40;
    
    /** The Constant GROUPCODE_WIDTH_FACTOR. */
    public final static int GROUPCODE_WIDTH_FACTOR = 41;
    
    /** The Constant GROUPCODE_OBLIQUE_ANGLE. */
    public final static int GROUPCODE_OBLIQUE_ANGLE = 50;
    
    /** The Constant GROUPCODE_TEXT_GENERATION_FLAG. */
    public final static int GROUPCODE_TEXT_GENERATION_FLAG = 71;
    
    /** The Constant GROUPCODE_FLAGS. */
    public final static int GROUPCODE_FLAGS = 70;
    
    /** The Constant GROUPCODE_LAST_HEIGHT. */
    public final static int GROUPCODE_LAST_HEIGHT = 42;
    
    /** The Constant GROUPCODE_FONT_FILE. */
    public final static int GROUPCODE_FONT_FILE = 3;
    
    /** The Constant GROUPCODE_BIG_FONT_FILE. */
    public final static int GROUPCODE_BIG_FONT_FILE = 4;
    
    /** The style. */
    private DXFStyle style;

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXStyle(style);
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        // TODO Auto-generated method stub
        return TABLE_KEY;
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int, de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_NAME:
            style.setName(value.getValue());

            break;

        case GROUPCODE_TEXT_HEIGHT:
            style.setTextHeight(value.getDoubleValue());

            break;

        case GROUPCODE_WIDTH_FACTOR:
            style.setWidthFactor(value.getDoubleValue());

            break;

        case GROUPCODE_OBLIQUE_ANGLE:
            style.setObliqueAngle(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT_GENERATION_FLAG:
            style.setTextGenerationFlag(value.getIntegerValue());

            break;

        case GROUPCODE_LAST_HEIGHT:
            style.setLastHeight(value.getDoubleValue());

            break;

        case GROUPCODE_FONT_FILE:
            style.setFontFile(value.getValue());

            break;

        case GROUPCODE_BIG_FONT_FILE:
            style.setBigFontFile(value.getValue());

            break;

        case GROUPCODE_FLAGS:
            style.setFlags(value.getIntegerValue());

            break;
        }
    }

    /* (non-Javadoc)
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        style = new DXFStyle();
    }
}
