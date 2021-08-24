/*******************************************************************************************************
 *
 * DXFMTextHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFMText;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFMTextHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFMTextHandler extends AbstractEntityHandler {
    
    /** The Constant ENTITY_NAME. */
    public static final String ENTITY_NAME = "MTEXT";
    
    /** The Constant TEXT_VALUE_END. */
    public static final int TEXT_VALUE_END = 1;
    
    /** The Constant TEXT_VALUE. */
    public static final int TEXT_VALUE = 3;
    
    /** The Constant TEXT_HEIGHT. */
    public static final int TEXT_HEIGHT = 40;
    
    /** The Constant TEXT_REF_WIDTH. */
    public static final int TEXT_REF_WIDTH = 41;
    
    /** The Constant TEXT_REF_HEIGHT. */
    public static final int TEXT_REF_HEIGHT = 43;
    
    /** The Constant TEXT_DRAWING_DIRECTION_FLAG. */
    public static final int TEXT_DRAWING_DIRECTION_FLAG = 72;
    
    /** The Constant TEXT_ATTACHMENT_POINT. */
    public static final int TEXT_ATTACHMENT_POINT = 71;
    
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
    
    /** The mtext. */
    private DXFMText mtext;
    
    /** The buf. */
    private StringBuffer buf = new StringBuffer();
    
    /** The insert. */
    private int insert = 0;

    /**
     * Instantiates a new DXFM text handler.
     */
    public DXFMTextHandler() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#endParsing()
     */
    public void endDXFEntity() {
        mtext.setText(buf.toString());
        buf.delete(0, buf.length());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntity()
     */
    public DXFEntity getDXFEntity() {
        return mtext;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public String getDXFEntityName() {
        return ENTITY_NAME;
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

            String part = value.getValue();
            buf.insert(insert, part);
            insert += part.length();

            break;

        case TEXT_VALUE_END:
            buf.insert(insert, value.getValue());

            break;

        case TEXT_ATTACHMENT_POINT:
            mtext.setAttachmentPoint(value.getIntegerValue());

            break;

        case GROUPCODE_START_X:
            mtext.setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            mtext.setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            mtext.setZ(value.getDoubleValue());

            break;

        case TEXT_ALIGN_X:
            mtext.setAlignX(value.getDoubleValue());
            mtext.setRotation(0.0);

            break;

        case TEXT_ALIGN_Y:
            mtext.setAlignY(value.getDoubleValue());
            mtext.setRotation(0.0);

            break;

        case TEXT_ALIGN_Z:
            mtext.setAlignZ(value.getDoubleValue());
            mtext.setRotation(0.0);

            break;

        case TEXT_HEIGHT:
            mtext.setHeight(value.getDoubleValue());

            break;

        case TEXT_DRAWING_DIRECTION_FLAG:

            switch (value.getIntegerValue()) {
            case 2:
                mtext.setBackward(true);

                break;

            case 4:
                mtext.setUpsideDown(true);

                break;
            }

            break;

        case TEXT_STYLE:
            mtext.setTextStyle(value.getValue());

            break;

        case TEXT_ROTATION:
            mtext.setRotation(value.getDoubleValue());

            break;

        case TEXT_REF_WIDTH:
            mtext.setReferenceWidth(value.getDoubleValue());

            break;

        case TEXT_REF_HEIGHT:
            mtext.setReferenceHeight(value.getDoubleValue());

            break;

        case TEXT_OBLIQUEANGLE:
            mtext.setObliqueAngle(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, mtext);

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#startParsing()
     */
    public void startDXFEntity() {
        mtext = new DXFMText();
        insert = 0;
    }
}
