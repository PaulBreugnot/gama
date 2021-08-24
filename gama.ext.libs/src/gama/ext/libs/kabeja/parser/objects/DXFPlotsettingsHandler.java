/*******************************************************************************************************
 *
 * DXFPlotsettingsHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.dxf.objects.DXFPlotSettings;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFPlotsettingsHandler.
 */
public class DXFPlotsettingsHandler extends AbstractDXFObjectHandler {
    
    /** The Constant GROUPCODE_NAME. */
    public final static int GROUPCODE_NAME = 1;
    
    /** The Constant GROUPCODE_PLOT_CONFIGURATION_FILE. */
    public final static int GROUPCODE_PLOT_CONFIGURATION_FILE = 2;
    
    /** The Constant GROUPCODE_PAPER_SIZE. */
    public final static int GROUPCODE_PAPER_SIZE = 4;
    
    /** The Constant GROUPCODE_PLOT_VIEW_NAME. */
    public final static int GROUPCODE_PLOT_VIEW_NAME = 6;
    
    /** The Constant GROUPCODE_MARGIN_LEFT. */
    public final static int GROUPCODE_MARGIN_LEFT = 40;
    
    /** The Constant GROUPCODE_MARGIN_BOTTOM. */
    public final static int GROUPCODE_MARGIN_BOTTOM = 41;
    
    /** The Constant GROUPCODE_MARGIN_RIGHT. */
    public final static int GROUPCODE_MARGIN_RIGHT = 42;
    
    /** The Constant GROUPCODE_MARGIN_TOP. */
    public final static int GROUPCODE_MARGIN_TOP = 43;
    
    /** The Constant GROUPCODE_PLOT_PAPER_WIDTH. */
    public final static int GROUPCODE_PLOT_PAPER_WIDTH = 44;
    
    /** The Constant GROUPCODE_PLOT_PAPER_HEIGHT. */
    public final static int GROUPCODE_PLOT_PAPER_HEIGHT = 45;
    
    /** The Constant GROUPCODE_ORIGIN_X. */
    public final static int GROUPCODE_ORIGIN_X = 46;
    
    /** The Constant GROUPCODE_ORIGIN_Y. */
    public final static int GROUPCODE_ORIGIN_Y = 47;
    
    /** The Constant GROUPCODE_PLOT_WINDOW_MIN_X. */
    public final static int GROUPCODE_PLOT_WINDOW_MIN_X = 48;
    
    /** The Constant GROUPCODE_PLOT_WINDOWS_MIN_Y. */
    public final static int GROUPCODE_PLOT_WINDOWS_MIN_Y = 49;
    
    /** The Constant GROUPCODE_PLOT_WINDOW_MAX_X. */
    public final static int GROUPCODE_PLOT_WINDOW_MAX_X = 140;
    
    /** The Constant GROUPCODE_PLOT_WINDOWS_MAX_Y. */
    public final static int GROUPCODE_PLOT_WINDOWS_MAX_Y = 141;
    
    /** The Constant GROUPCODE_CUSTOM_SCALE_NUMERATOR. */
    public final static int GROUPCODE_CUSTOM_SCALE_NUMERATOR = 142;
    
    /** The Constant GROUPCODE_CUSTOM_SCALE_DEOMINATOR. */
    public final static int GROUPCODE_CUSTOM_SCALE_DEOMINATOR = 143;
    
    /** The Constant GROUPCODE_PAPER_UNITS. */
    public final static int GROUPCODE_PAPER_UNITS = 72;
    
    /** The Constant GROUPCODE_PLOT_ROTATION. */
    public final static int GROUPCODE_PLOT_ROTATION = 73;
    
    /** The Constant GROUPCODE_PLOT_TYPE. */
    public final static int GROUPCODE_PLOT_TYPE = 74;
    
    /** The Constant GROUPCODE_CURRENT_STYLESHEET. */
    public final static int GROUPCODE_CURRENT_STYLESHEET = 7;
    
    /** The Constant GROUPCODE_STANDARD_SCALE_TYPE. */
    public final static int GROUPCODE_STANDARD_SCALE_TYPE = 75;
    
    /** The plot settings. */
    protected DXFPlotSettings plotSettings;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return this.plotSettings;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_PLOTSETTINGS;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        double[] m;

        switch (groupCode) {
        case GROUPCODE_CURRENT_STYLESHEET:
            this.plotSettings.setCurrentStylesheet(value.getValue());

            break;

        case GROUPCODE_CUSTOM_SCALE_DEOMINATOR:
            this.plotSettings.setCustomScaleDenominator(value.getDoubleValue());

            break;

        case GROUPCODE_CUSTOM_SCALE_NUMERATOR:
            this.plotSettings.setCustomScaleNumerator(value.getDoubleValue());

            break;

        case GROUPCODE_MARGIN_BOTTOM:
            m = this.plotSettings.getMargin();
            m[2] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_LEFT:
            m = this.plotSettings.getMargin();
            m[3] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_RIGHT:
            m = this.plotSettings.getMargin();
            m[1] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_TOP:
            m = this.plotSettings.getMargin();
            m[0] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_ORIGIN_X:
            this.plotSettings.getPlotOrigin().setX(value.getDoubleValue());

            break;

        case GROUPCODE_ORIGIN_Y:
            this.plotSettings.getPlotOrigin().setY(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            this.plotSettings.setName(value.getValue());

            break;

        case GROUPCODE_PAPER_SIZE:

            //this.plotSettings.
            break;

        case GROUPCODE_PAPER_UNITS:
            this.plotSettings.setPaperUnit(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_CONFIGURATION_FILE:
            break;

        case GROUPCODE_PLOT_PAPER_HEIGHT:
            this.plotSettings.setPaperHeight(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_PAPER_WIDTH:
            this.plotSettings.setPaperWidth(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_ROTATION:
            this.plotSettings.setPlotRotation(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_TYPE:
            this.plotSettings.setPlotType(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_VIEW_NAME:
            this.plotSettings.setPlotViewName(value.getValue());

            break;

        case GROUPCODE_PLOT_WINDOW_MAX_X:
            this.plotSettings.getWindowToPlot()
                             .setMaximumX(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOW_MIN_X:
            this.plotSettings.getWindowToPlot()
                             .setMinimumX(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOWS_MAX_Y:
            this.plotSettings.getWindowToPlot()
                             .setMaximumY(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOWS_MIN_Y:
            this.plotSettings.getWindowToPlot()
                             .setMinimumY(value.getDoubleValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.plotSettings);
        }
    }

    public void startObject() {
        this.plotSettings = new DXFPlotSettings();
    }
}
