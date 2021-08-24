/*******************************************************************************************************
 *
 * DXFRayHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFRay;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFRayHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFRayHandler extends AbstractEntityHandler {
    
    /** The ray. */
    protected DXFRay ray;

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_RAY;
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
        return this.ray;
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
            this.ray.getBasePoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            this.ray.getBasePoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            this.ray.getBasePoint().setY(value.getDoubleValue());

            break;

        case END_X:
            this.ray.getDirection().setX(value.getDoubleValue());

            break;

        case END_Y:
            this.ray.getDirection().setY(value.getDoubleValue());

            break;

        case END_Z:
            this.ray.getDirection().setZ(value.getDoubleValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, ray);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.miethxml.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        this.ray = new DXFRay();
    }
}
