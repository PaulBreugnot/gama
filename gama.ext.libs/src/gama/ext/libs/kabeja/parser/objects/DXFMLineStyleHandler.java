/*******************************************************************************************************
 *
 * DXFMLineStyleHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.objects;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.objects.DXFMLineStyle;
import gama.ext.libs.kabeja.dxf.objects.DXFMLineStyleElement;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFMLineStyleHandler.
 */
public class DXFMLineStyleHandler extends AbstractDXFObjectHandler {
    
    /** The Constant GROUPCODE_MLINE_STYLE_NAME. */
    public static final int GROUPCODE_MLINE_STYLE_NAME = 2;
    
    /** The Constant GROUPCODE_MLINE_STYLE_FLAGS. */
    public static final int GROUPCODE_MLINE_STYLE_FLAGS = 70;
    
    /** The Constant GROUPCODE_MLINE_STYLE_DESCRIPTION. */
    public static final int GROUPCODE_MLINE_STYLE_DESCRIPTION = 3;
    
    /** The Constant GROUPCODE_MLINE_STYLE_FILL_COLOR. */
    public static final int GROUPCODE_MLINE_STYLE_FILL_COLOR = 62;
    
    /** The Constant GROUPCODE_MLINE_STYLE_START_ANGLE. */
    public static final int GROUPCODE_MLINE_STYLE_START_ANGLE = 51;
    
    /** The Constant GROUPCODE_MLINE_STYLE_END_ANGLE. */
    public static final int GROUPCODE_MLINE_STYLE_END_ANGLE = 52;
    
    /** The Constant GROUPCODE_MLINE_STYLE_ELEMENT_COUNT. */
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_COUNT = 71;
    
    /** The Constant GROUPCODE_MLINE_STYLE_ELEMENT_OFFSET. */
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_OFFSET = 49;
    
    /** The Constant GROUPCODE_MLINE_STYLE_ELEMENT_COLOR. */
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_COLOR = 62;
    
    /** The Constant GROUPCODE_MLINE_STYLE_ELEMENT_LINE_STYLE. */
    public static final int GROUPCODE_MLINE_STYLE_ELEMENT_LINE_STYLE = 6;
    
    /** The style. */
    protected DXFMLineStyle style;
    
    /** The element. */
    protected DXFMLineStyleElement element;
    
    /** The process line element. */
    protected boolean processLineElement = false;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return this.style;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_MLINESTYLE;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_MLINE_STYLE_ELEMENT_OFFSET:
            this.element = new DXFMLineStyleElement();
            this.element.setOffset(value.getDoubleValue());
            this.style.addDXFMLineStyleElement(element);
            this.processLineElement = true;

            break;

        case GROUPCODE_MLINE_STYLE_ELEMENT_COLOR:

            if (this.processLineElement) {
                this.element.setLineColor(value.getIntegerValue());
            } else {
                this.style.setFillColor(value.getIntegerValue());
            }

            break;

        case GROUPCODE_MLINE_STYLE_ELEMENT_LINE_STYLE:
            this.element.setLineType(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_NAME:
            this.style.setName(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_DESCRIPTION:
            this.style.setDescrition(value.getValue());

            break;

        case GROUPCODE_MLINE_STYLE_START_ANGLE:
            this.style.setStartAngle(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_STYLE_END_ANGLE:
            this.style.setEndAngle(value.getDoubleValue());

            break;

        case GROUPCODE_MLINE_STYLE_FLAGS:
            this.style.setFlags(value.getIntegerValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.style);
        }
    }

    public void startObject() {
        this.style = new DXFMLineStyle();
        this.processLineElement = false;
    }
}
