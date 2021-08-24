/*******************************************************************************************************
 *
 * DXFMLineHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFMLine;
import gama.ext.libs.kabeja.dxf.helpers.DXFMLineSegment;
import gama.ext.libs.kabeja.dxf.helpers.DXFMLineSegmentElement;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFMLineHandler.
 */
public class DXFMLineHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_MLINE_STYLENAME. */
    public final static int GROUPCODE_MLINE_STYLENAME = 2;
    
    /** The Constant GROUPCODE_MLINE_STYLE_ID. */
    public final static int GROUPCODE_MLINE_STYLE_ID = 340;
    
    /** The Constant GROUPCODE_MLINE_SCALE_FACTOR. */
    public final static int GROUPCODE_MLINE_SCALE_FACTOR = 40;
    
    /** The Constant GROUPCODE_MLINE_JUSTIFICATION. */
    public final static int GROUPCODE_MLINE_JUSTIFICATION = 70;
    
    /** The Constant GROUPCODE_MLINE_FLAGS. */
    public final static int GROUPCODE_MLINE_FLAGS = 71;
    
    /** The Constant GROUPCODE_MLINE_NUMBER_OF_VERTICES. */
    public final static int GROUPCODE_MLINE_NUMBER_OF_VERTICES = 72;
    
    /** The Constant GROUPCODE_MLINE_NUMBER_OF_LINESTYLEELEMENTS. */
    public final static int GROUPCODE_MLINE_NUMBER_OF_LINESTYLEELEMENTS = 73;
    
    /** The Constant GROUPCODE_MLINE_VERTEX_X. */
    public final static int GROUPCODE_MLINE_VERTEX_X = 11;
    
    /** The Constant GROUPCODE_MLINE_VERTEX_Y. */
    public final static int GROUPCODE_MLINE_VERTEX_Y = 21;
    
    /** The Constant GROUPCODE_MLINE_VERTEX_Z. */
    public final static int GROUPCODE_MLINE_VERTEX_Z = 31;
    
    /** The Constant GROUPCODE_MLINE_DIRECTION_X. */
    public final static int GROUPCODE_MLINE_DIRECTION_X = 12;
    
    /** The Constant GROUPCODE_MLINE_DIRECTION_Y. */
    public final static int GROUPCODE_MLINE_DIRECTION_Y = 22;
    
    /** The Constant GROUPCODE_MLINE_DIRECTION_Z. */
    public final static int GROUPCODE_MLINE_DIRECTION_Z = 32;
    
    /** The Constant GROUPCODE_MLINE_MITER_DIRECTION_X. */
    public final static int GROUPCODE_MLINE_MITER_DIRECTION_X = 13;
    
    /** The Constant GROUPCODE_MLINE_MITER_DIRECTION_Y. */
    public final static int GROUPCODE_MLINE_MITER_DIRECTION_Y = 23;
    
    /** The Constant GROUPCODE_MLINE_MITER_DIRECTION_Z. */
    public final static int GROUPCODE_MLINE_MITER_DIRECTION_Z = 33;
    
    /** The Constant GROUPCODE_MLINE_ELEMENT_PARAMETER_COUNT. */
    public final static int GROUPCODE_MLINE_ELEMENT_PARAMETER_COUNT = 74;
    
    /** The Constant GROUPCODE_MLINE_ELEMENT_PARAMETER. */
    public final static int GROUPCODE_MLINE_ELEMENT_PARAMETER = 41;
    
    /** The Constant GROUPCODE_MLINE_FILL_PARAMETER_COUNT. */
    public final static int GROUPCODE_MLINE_FILL_PARAMETER_COUNT = 75;
    
    /** The Constant GROUPCODE_MLINE_FILL_PARAMETER. */
    public final static int GROUPCODE_MLINE_FILL_PARAMETER = 42;
    
    /** The m line. */
    protected DXFMLine mLine;
    
    /** The seg. */
    protected DXFMLineSegment seg;
    
    /** The el. */
    protected DXFMLineSegmentElement el;
    
    /** The index. */
    protected int index = 0;

    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_MLINE;
    }

    public void endDXFEntity() {
    }

    public DXFEntity getDXFEntity() {
        return this.mLine;
    }

    public boolean isFollowSequence() {
        return false;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_MLINE_VERTEX_X:
            this.seg = new DXFMLineSegment();
            this.mLine.addDXFMLineSegement(this.seg);
            this.seg.getStartPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_VERTEX_Y:
            this.seg.getStartPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_VERTEX_Z:
            this.seg.getStartPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_DIRECTION_X:
            this.seg.getDirection().setX(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_DIRECTION_Y:
            this.seg.getDirection().setY(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_DIRECTION_Z:
            this.seg.getDirection().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_MITER_DIRECTION_X:
            this.seg.getMiterDirection().setX(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_MITER_DIRECTION_Y:
            this.seg.getMiterDirection().setY(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_MITER_DIRECTION_Z:
            this.seg.getMiterDirection().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_ELEMENT_PARAMETER:
            this.el.setLengthParameter(index, value.getDoubleValue());
            this.index++;

            break;

        case GROUPCODE_MLINE_ELEMENT_PARAMETER_COUNT:
            this.el = new DXFMLineSegmentElement();
            this.seg.addDXFMLineSegmentElement(el);
            this.el.setLengthParameters(new double[value.getIntegerValue()]);
            this.index = 0;

            break;

        case GROUPCODE_MLINE_FILL_PARAMETER:
            this.el.setFillParameter(index, value.getDoubleValue());
            this.index++;

            break;

        case GROUPCODE_MLINE_FILL_PARAMETER_COUNT:
            this.el.setFillParameters(new double[value.getIntegerValue()]);
            this.index = 0;

            break;

        case GROUPCODE_START_X:
            this.mLine.getStartPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            this.mLine.getStartPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            this.mLine.getStartPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_FLAGS:
            this.mLine.setFlags(value.getIntegerValue());

            break;

        case GROUPCODE_MLINE_JUSTIFICATION:
            this.mLine.setJustification(value.getIntegerValue());

            break;

        case GROUPCODE_MLINE_NUMBER_OF_LINESTYLEELEMENTS:
            this.mLine.setLineCount(value.getIntegerValue());

            break;

        case GROUPCODE_MLINE_SCALE_FACTOR:
            this.mLine.setScale(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_STYLENAME:
            this.mLine.setMLineStyleName(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_ID:
            this.mLine.setMLineStyleID(value.getValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, this.mLine);
        }
    }

    public void startDXFEntity() {
        this.mLine = new DXFMLine();
    }
}
