/*******************************************************************************************************
 *
 * DXF3DFace.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import gama.ext.libs.kabeja.math.MathUtils;


/**
 * The Class DXF3DFace.
 *
 * @author simon
 */
public class DXF3DFace extends DXFSolid {
    public String getType() {
        return DXFConstants.ENTITY_TYPE_3DFACE;
    }

    public double getLength() {
        double length = 0.0;
        int flag = this.getFlags();

        if ((flag & 1) == 0) {
            length += MathUtils.distance(this.getPoint1(), this.getPoint2());
        }

        if ((flag & 2) == 0) {
            length += MathUtils.distance(this.getPoint2(), this.getPoint3());
        }

        if ((flag & 4) == 0) {
            length += MathUtils.distance(this.getPoint3(), this.getPoint4());
        }

        if ((flag & 8) == 0) {
            length += MathUtils.distance(this.getPoint4(), this.getPoint1());
        }

        return length;
    }
}
