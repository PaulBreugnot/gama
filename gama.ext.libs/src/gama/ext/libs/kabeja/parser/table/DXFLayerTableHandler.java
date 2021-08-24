/*******************************************************************************************************
 *
 * DXFLayerTableHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.table;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFLayer;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFLayerTableHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFLayerTableHandler extends AbstractTableHandler {
    
    /** The Constant TABLE_KEY. */
    public final static String TABLE_KEY = "LAYER";
    
    /** The Constant GROUPCODE_LAYER_NAME. */
    public final static int GROUPCODE_LAYER_NAME = 2;
    
    /** The Constant GROUPCODE_LAYER_LINETYPE. */
    public final static int GROUPCODE_LAYER_LINETYPE = 6;
    
    /** The Constant GROUPCODE_LAYER_COLORNUMBER. */
    public final static int GROUPCODE_LAYER_COLORNUMBER = 62;
    
    /** The Constant GROUPCODE_LAYER_PLOTTINGFLAG. */
    public final static int GROUPCODE_LAYER_PLOTTINGFLAG = 290;
    
    /** The Constant GROUPCODE_LAYER_LINEWEIGHT. */
    public final static int GROUPCODE_LAYER_LINEWEIGHT = 370;
    
    /** The Constant GROUPCODE_LAYER_PLOTSTYLENAME. */
    public final static int GROUPCODE_LAYER_PLOTSTYLENAME = 390;
    
    /** The layer. */
    private DXFLayer layer;

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#getTableKey()
     */
    public String getTableKey() {
        return TABLE_KEY;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#parseGroup(int,
     *      java.lang.String)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_LAYER_NAME:
            layer.setName(value.getValue());

            break;

        case GROUPCODE_LAYER_COLORNUMBER:
            layer.setColor(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_LINETYPE:
            layer.setLineType(value.getValue());

            break;

        case DXFConstants.GROUPCODE_STANDARD_FLAGS:
            layer.setFlags(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_LINEWEIGHT:
            layer.setLineWeight(value.getIntegerValue());

            break;

        case GROUPCODE_LAYER_PLOTSTYLENAME:
            layer.setPlotStyle(value.getValue());

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#endParsing()
     */
    public void endParsing() {
        doc.addDXFLayer(layer);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.table.TableHandler#startParsing()
     */
    public void startParsing() {
        layer = new DXFLayer();
        layer.setDXFDocument(doc);
    }
}
