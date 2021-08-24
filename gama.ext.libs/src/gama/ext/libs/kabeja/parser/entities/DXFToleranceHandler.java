/*******************************************************************************************************
 *
 * DXFToleranceHandler.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.dxf.DXFTolerance;
import gama.ext.libs.kabeja.parser.DXFValue;


/**
 * The Class DXFToleranceHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFToleranceHandler extends AbstractEntityHandler {
    
    /** The Constant GROUPCODE_X_AXIS_DIRECTOPN_X. */
    public final static int GROUPCODE_X_AXIS_DIRECTOPN_X = 11;
    
    /** The Constant GROUPCODE_X_AXIS_DIRECTOPN_Y. */
    public final static int GROUPCODE_X_AXIS_DIRECTOPN_Y = 21;
    
    /** The Constant GROUPCODE_X_AXIS_DIRECTOPN_Z. */
    public final static int GROUPCODE_X_AXIS_DIRECTOPN_Z = 31;
    
    /** The tolerance. */
    protected DXFTolerance tolerance;

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntityName()
     */
    public String getDXFEntityName() {
        return DXFConstants.ENTITY_TYPE_TOLERANCE;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#endDXFEntity()
     */
    public void endDXFEntity() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#getDXFEntity()
     */
    public DXFEntity getDXFEntity() {
        return tolerance;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#isFollowSequence()
     */
    public boolean isFollowSequence() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#parseGroup(int,
     *      org.kabeja.parser.DXFValue)
     */
    public void parseGroup(int groupCode, DXFValue value) {
        switch (groupCode) {
        case GROUPCODE_START_X:
            tolerance.getInsertionPoint().setX(value.getDoubleValue());

            break;

        case GROUPCODE_START_Y:
            tolerance.getInsertionPoint().setY(value.getDoubleValue());

            break;

        case GROUPCODE_START_Z:
            tolerance.getInsertionPoint().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_X_AXIS_DIRECTOPN_X:
            tolerance.getXaxisDirection().setX(value.getDoubleValue());

            break;

        case GROUPCODE_X_AXIS_DIRECTOPN_Y:
            tolerance.getXaxisDirection().setY(value.getDoubleValue());

            break;

        case GROUPCODE_X_AXIS_DIRECTOPN_Z:
            tolerance.getXaxisDirection().setZ(value.getDoubleValue());

            break;

        case GROUPCODE_TEXT:
            tolerance.setText(value.getValue());

            break;

        case GROUPCODE_STYLENAME:
            tolerance.setStyleID(value.getValue());

            break;

        default:
            super.parseCommonProperty(groupCode, value, tolerance);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.parser.entities.DXFEntityHandler#startDXFEntity()
     */
    public void startDXFEntity() {
        tolerance = new DXFTolerance();
    }
}
