/*******************************************************************************************************
 *
 * DXFImageHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFImage;
import gama.ext.libs.kabeja.dxf.helpers.Point;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFImageHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFImageHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_IMAGEDEF_HARDREFERENCE. */
    public final static int GROUPCODE_IMAGEDEF_HARDREFERENCE = 340;
    
    /** The Constant GROUPCODE_VECTOR_U_X. */
    public final static int GROUPCODE_VECTOR_U_X = 11;
    
    /** The Constant GROUPCODE_VECTOR_U_Y. */
    public final static int GROUPCODE_VECTOR_U_Y = 21;
    
    /** The Constant GROUPCODE_VECTOR_U_Z. */
    public final static int GROUPCODE_VECTOR_U_Z = 31;
    
    /** The Constant GROUPCODE_VECTOR_V_X. */
    public final static int GROUPCODE_VECTOR_V_X = 12;
    
    /** The Constant GROUPCODE_VECTOR_V_Y. */
    public final static int GROUPCODE_VECTOR_V_Y = 22;
    
    /** The Constant GROUPCODE_VECTOR_V_Z. */
    public final static int GROUPCODE_VECTOR_V_Z = 32;
    
    /** The Constant GROUPCODE_IAMGESIZE_U. */
    public final static int GROUPCODE_IAMGESIZE_U = 13;
    
    /** The Constant GROUPCODE_IAMGESIZE_V. */
    public final static int GROUPCODE_IAMGESIZE_V = 23;
    
    /** The Constant GROUPCODE_DISPLAY_PROPERTY. */
    public final static int GROUPCODE_DISPLAY_PROPERTY = 70;
    
    /** The Constant GROUPCODE_BRIGHTNESS. */
    public final static int GROUPCODE_BRIGHTNESS = 281;
    
    /** The Constant GROUPCODE_CONTRAST. */
    public final static int GROUPCODE_CONTRAST = 282;
    
    /** The Constant GROUPCODE_FADE. */
    public final static int GROUPCODE_FADE = 283;
    
    /** The Constant GROUPCODE_NUMBER_CLIP_BOUNDARY. */
    public final static int GROUPCODE_NUMBER_CLIP_BOUNDARY = 91;
    
    /** The Constant GROUPCODE_CLIP_BOUNDARY_X. */
    public final static int GROUPCODE_CLIP_BOUNDARY_X = 14;
    
    /** The Constant GROUPCODE_CLIP_BOUNDARY_Y. */
    public final static int GROUPCODE_CLIP_BOUNDARY_Y = 24;
    
    /** The Constant GROUPCODE_CLIP_BOUNDARY_TYPE. */
    public final static int GROUPCODE_CLIP_BOUNDARY_TYPE = 71;
    
    /** The Constant GROUPCODE_CLIPPING_STATE. */
    public final static int GROUPCODE_CLIPPING_STATE = 280;
    
    /** The image. */
    protected DXFImage image;
    
    /** The clipping point. */
    protected Point clippingPoint;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_IMAGE;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        // TODO Auto-generated method stub
        return image;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      de.miethxml.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            image.getInsertPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            image.getInsertPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            image.getInsertPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_IMAGEDEF_HARDREFERENCE:
            image.setImageDefObjectID(value.getValue());

            break;

        case GROUPCODE_VECTOR_U_X:
            image.getVectorU().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VECTOR_U_Y:
            image.getVectorU().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VECTOR_U_Z:
            image.getVectorU().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_VECTOR_V_X:
            image.getVectorV().setX(value.getDoubleValue());

            break;

        case GROUPCODE_VECTOR_V_Y:
            image.getVectorV().setY(value.getDoubleValue());

            break;

        case GROUPCODE_VECTOR_V_Z:
            image.getVectorV().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_IAMGESIZE_U:
            image.setImageSizeAlongU(value.getDoubleValue());

            break;

        case GROUPCODE_IAMGESIZE_V:
            image.setImageSizeAlongV(value.getDoubleValue());

            break;

        case GROUPCODE_CLIPPING_STATE:
            image.setClipping(value.getBooleanValue());

            break;

        case GROUPCODE_CLIP_BOUNDARY_X:
            clippingPoint = new Point();
            clippingPoint.setX(value.getDoubleValue());
            image.addClippingPoint(clippingPoint);

            break;

        case GROUPCODE_CLIP_BOUNDARY_Y:
            clippingPoint.setY(value.getDoubleValue());

            break;

        case GROUPCODE_BRIGHTNESS:
            image.setBrightness(value.getDoubleValue());

            break;

        case GROUPCODE_CONTRAST:
            image.setContrast(value.getDoubleValue());

            break;

        case GROUPCODE_FADE:
            image.setFade(value.getDoubleValue());

            break;

        case GROUPCODE_CLIP_BOUNDARY_TYPE:

            if (value.getIntegerValue() == 1) {
                image.setRectangularClipping(true);
            } else if (value.getIntegerValue() == 2) {
                image.setPolygonalClipping(true);
            }

            break;

        default:
            super.parseCommonProperty(groupCode, value, image);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        image = new DXFImage();
        image.setDXFDocument(doc);
    }
}
