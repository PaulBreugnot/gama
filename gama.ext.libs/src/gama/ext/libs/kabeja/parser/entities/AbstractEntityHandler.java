/*******************************************************************************************************
 *
 * AbstractEntityHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.entities;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class AbstractEntityHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth </a>
 */
public abstract class AbstractEntityHandler implements DXFEntityHandler {
    
    /** The Constant ELEMENT_REFERENCE. */
    public final static int ELEMENT_REFERENCE = 5;
    
    /** The Constant GROUPCODE_START_X. */
    public final static int GROUPCODE_START_X = 10;
    
    /** The Constant GROUPCODE_START_Y. */
    public final static int GROUPCODE_START_Y = 20;
    
    /** The Constant GROUPCODE_START_Z. */
    public final static int GROUPCODE_START_Z = 30;
    
    /** The Constant END_X. */
    public final static int END_X = 11;
    
    /** The Constant END_Y. */
    public final static int END_Y = 21;
    
    /** The Constant END_Z. */
    public final static int END_Z = 31;
    
    /** The Constant LAYER_NAME. */
    public final static int LAYER_NAME = 8;
    
    /** The Constant TRANSPARENCY. */
    public final static int TRANSPARENCY = 440;
    
    /** The Constant COLOR_CODE. */
    public final static int COLOR_CODE = 62;
    
    /** The Constant COLORNAME. */
    public final static int COLORNAME = 430;
    
    /** The Constant COLOR_24BIT. */
    public final static int COLOR_24BIT = 420;
    
    /** The Constant COLOR_TRANSPARENCY. */
    public final static int COLOR_TRANSPARENCY = 440;
    
    /** The Constant FLAGS. */
    public final static int FLAGS = 70;
    
    /** The Constant EXTRUSION_X. */
    public final static int EXTRUSION_X = 210;
    
    /** The Constant EXTRUSION_Y. */
    public final static int EXTRUSION_Y = 220;
    
    /** The Constant EXTRUSION_Z. */
    public final static int EXTRUSION_Z = 230;
    
    /** The Constant VISIBILITY. */
    public final static int VISIBILITY = 60;
    
    /** The Constant LINE_TYPE. */
    public final static int LINE_TYPE = 6;
    
    /** The Constant LINE_TYPE_SCALE. */
    public final static int LINE_TYPE_SCALE = 48;
    
    /** The Constant LINE_WEIGHT. */
    public final static int LINE_WEIGHT = 370;
    
    /** The Constant GROUPCODE_THICKNESS. */
    public final static int GROUPCODE_THICKNESS = 39;
    
    /** The Constant GROUPCODE_STYLENAME. */
    public final static int GROUPCODE_STYLENAME = 3;
    
    /** The Constant GROUPCODE_TEXT. */
    public final static int GROUPCODE_TEXT = 1;
    
    /** The Constant GROUPCODE_ROTATION_ANGLE. */
    public final static int GROUPCODE_ROTATION_ANGLE = 50;
    
    /** The Constant GROUPCODE_MODELSPACE. */
    public final static int GROUPCODE_MODELSPACE = 67;
    
    /** The doc. */
    protected DXFDocument doc;

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#setDXFDocument(org.dxf2svg.xml.DXFDocument)
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /**
     * Parses the common property.
     *
     * @param groupCode the group code
     * @param value the value
     * @param entity the entity
     */
    protected void parseCommonProperty(int groupCode, DXFValue value,
        DXFEntity entity) {
        switch (groupCode) {
        case ELEMENT_REFERENCE:
            entity.setID(value.getValue());

            break;

        case LAYER_NAME:
            entity.setLayerName(value.getValue());

            break;

        case FLAGS:
            entity.setFlags(value.getIntegerValue());

            break;

        case VISIBILITY:
            entity.setVisibile(!value.getBooleanValue());

            break;

        case LINE_TYPE:
            entity.setLineType(value.getValue());

            break;

        case LINE_TYPE_SCALE:
            entity.setLinetypeScaleFactor(value.getDoubleValue());

            break;

        case COLOR_CODE:
            entity.setColor(value.getIntegerValue());

            break;

        case EXTRUSION_X:
            entity.setExtrusionX(value.getDoubleValue());

            break;

        case EXTRUSION_Y:
            entity.setExtrusionY(value.getDoubleValue());

            break;

        case EXTRUSION_Z:
            entity.setExtrusionZ(value.getDoubleValue());

            break;

        case COLOR_24BIT:
            break;

        case COLOR_TRANSPARENCY:
            break;

        case LINE_WEIGHT:
            entity.setLineWeight(value.getIntegerValue());

            break;

        case GROUPCODE_THICKNESS:
            entity.setThickness(value.getDoubleValue());

            break;

        case GROUPCODE_MODELSPACE:
            entity.setModelSpace(value.getBooleanValue());

            break;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.dxf2svg.parser.entities.EntityHandler#getEntityName()
     */
    public abstract String getDXFEntityName();

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.Handler#releaseDXFDocument()
     */
    public void releaseDXFDocument() {
        this.doc = null;
    }
}
