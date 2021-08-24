/*******************************************************************************************************
 *
 * DXFLineTypeTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFLineType;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFLineTypeTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFLineTypeTableHandler extends AbstractTableHandler {
    
    /** The Constant TABLE_KEY. */
    public final static String TABLE_KEY = "LTYPE";
    
    /** The Constant GROUPCODE_LTYPE_NAME. */
    public final static int GROUPCODE_LTYPE_NAME = 2;
    
    /** The Constant GROUPCODE_LTYPE_DESCRIPTION. */
    public final static int GROUPCODE_LTYPE_DESCRIPTION = 3;
    
    /** The Constant GROUPCODE_LTYPE_ALIGNMENT. */
    public final static int GROUPCODE_LTYPE_ALIGNMENT = 72;
    
    /** The Constant GROUPCODE_LTYPE_SEGMENT. */
    public final static int GROUPCODE_LTYPE_SEGMENT = 49;
    
    /** The Constant GROUPCODE_LTYPE_LENGTH. */
    public final static int GROUPCODE_LTYPE_LENGTH = 40;
    
    /** The Constant GROUPCODE_LTYPE_SEGMENT_COUNT. */
    public final static int GROUPCODE_LTYPE_SEGMENT_COUNT = 73;
    
    /** The Constant GROUPCODE_LTYPE_SCALE. */
    public final static int GROUPCODE_LTYPE_SCALE = 46;
    
    /** The ltype. */
    private DXFLineType ltype;
    
    /** The segment count. */
    private int segmentCount = 0;
    
    /** The pattern. */
    private double[] pattern;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#endParsing()
     */
    public void endParsing() {
        ltype.setPattern(pattern);
        doc.addDXFLineType(ltype);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#getTableKey()
     */
    public String getTableKey() {
        // TODO Auto-generated method stub
        return TABLE_KEY;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_LTYPE_NAME:
            ltype.setName(value.getValue());

            break;

        case GROUPCODE_LTYPE_DESCRIPTION:
            ltype.setDescritpion(value.getValue());

            break;

        case GROUPCODE_LTYPE_SEGMENT_COUNT:

            int count = value.getIntegerValue();
            pattern = new double[count];
            segmentCount = 0;

            break;

        case GROUPCODE_LTYPE_SEGMENT:
            pattern[segmentCount] = value.getDoubleValue();
            segmentCount++;

            break;

        case GROUPCODE_LTYPE_LENGTH:
            ltype.setPatternLength(value.getDoubleValue());

            break;

        case GROUPCODE_LTYPE_ALIGNMENT:
            ltype.setAlignment(value.getIntegerValue());

            break;

        case GROUPCODE_LTYPE_SCALE:
            ltype.setScale(value.getDoubleValue());

            break;

        default:
            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.table.DXFTableHandler#startParsing()
     */
    public void startParsing() {
        ltype = new DXFLineType();
        segmentCount = 0;
        pattern = null;
    }
}
