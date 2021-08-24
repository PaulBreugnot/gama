/*******************************************************************************************************
 *
 * DXFTextHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFText;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFTextHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFTextHandler extends AbstractEntityHandler {
    
    /** The Constant TEXT_VALUE. */
    public static final int TEXT_VALUE = 1;
    
    /** The Constant TEXT_HEIGHT. */
    public static final int TEXT_HEIGHT = 40;
    
    /** The Constant TEXT_SCALEX. */
    public static final int TEXT_SCALEX = 41;
    
    /** The Constant TEXT_GENERATION_FLAG. */
    public static final int TEXT_GENERATION_FLAG = 71;
    
    /** The Constant TEXT_ALIGN. */
    public static final int TEXT_ALIGN = 72;
    
    /** The Constant TEXT_VALIGN. */
    public static final int TEXT_VALIGN = 73;
    
    /** The Constant TEXT_ALIGN_X. */
    public static final int TEXT_ALIGN_X = 11;
    
    /** The Constant TEXT_ALIGN_Y. */
    public static final int TEXT_ALIGN_Y = 21;
    
    /** The Constant TEXT_ALIGN_Z. */
    public static final int TEXT_ALIGN_Z = 31;
    
    /** The Constant TEXT_STYLE. */
    public static final int TEXT_STYLE = 7;
    
    /** The Constant TEXT_OBLIQUEANGLE. */
    public static final int TEXT_OBLIQUEANGLE = 51;
    
    /** The Constant TEXT_ROTATION. */
    public static final int TEXT_ROTATION = 50;
    
    /** The text. */
    protected DXFText text;
    
    /** The content. */
    protected String content;

    /**
     * Instantiates a new DXF text handler.
     */
    public DXFTextHandler() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#endParsing()
     */
    public void endDXFEntity() {
        text.setText(this.content);
        this.content = "";
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntity()
     */
    public DXFEntity getDXFEntity() {
        return text;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_TEXT;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#parseGroup(int,
     *      org.dxf2svg.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case TEXT_VALUE:
            //we set the content after the
            //parsing is finished, so the
            //DXFParser will get all infos
            this.content = value.getValue();

            break;

        case TEXT_ALIGN:
            text.setAlign(value.getIntegerValue());

            break;

        case TEXT_VALIGN:
            text.setValign(value.getIntegerValue());

            break;

        case GROUPCODE_START_X:
            text.setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            text.setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            text.setZ(value.getDoubleValue());

            break;

        case TEXT_ALIGN_X:
            text.setAlignX(value.getDoubleValue());
            text.setAlignmentPoint(true);

            break;

        case TEXT_ALIGN_Y:
            text.setAlignY(value.getDoubleValue());
            text.setAlignmentPoint(true);

            break;

        case TEXT_ALIGN_Z:
            text.setAlignZ(value.getDoubleValue());
            text.setAlignmentPoint(true);

            break;

        case TEXT_HEIGHT:
            text.setHeight(value.getDoubleValue());

            break;

        case TEXT_GENERATION_FLAG:

            switch (value.getIntegerValue()) {
            case 2:
                text.setBackward(true);

                break;

            case 4:
                text.setUpsideDown(true);

                break;
            }

            break;

        case TEXT_STYLE:
            text.setTextStyle(value.getValue());

            break;

        case TEXT_ROTATION:
            text.setRotation(value.getDoubleValue());

            break;

        case TEXT_SCALEX:
            text.setScaleX(value.getDoubleValue());

            break;

        case TEXT_OBLIQUEANGLE:
            text.setObliqueAngle(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, text);

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        text = new DXFText();
        text.setDXFDocument(this.doc);
    }
}
