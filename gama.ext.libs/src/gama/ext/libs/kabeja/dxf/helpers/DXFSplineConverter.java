/*******************************************************************************************************
 *
 * DXFSplineConverter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import java.util.ArrayList;
import java.util.Iterator;

import gama.ext.libs.kabeja.dxf.DXFPolyline;
import gama.ext.libs.kabeja.dxf.DXFSpline;
import gama.ext.libs.kabeja.dxf.DXFVertex;
import gama.ext.libs.kabeja.math.NURBS;
import gama.ext.libs.kabeja.math.NURBSFixedNTELSPointIterator;


/**
 * The Class DXFSplineConverter.
 */
public class DXFSplineConverter {
    
    /**
     * To DXF polyline.
     *
     * @param spline the spline
     * @return the DXF polyline
     */
    public static DXFPolyline toDXFPolyline(DXFSpline spline) {
        DXFPolyline p = new DXFPolyline();
        p.setDXFDocument(spline.getDXFDocument());

        if ((spline.getDegree() > 0) && (spline.getKnots().length > 0)) {
            Iterator pi = new NURBSFixedNTELSPointIterator(toNurbs(spline), 30);

            while (pi.hasNext()) {
                p.addVertex(new DXFVertex((Point) pi.next()));
            }
        } else {
            // the curve is the controlpoint polygon
            Iterator i = spline.getSplinePointIterator();

            while (i.hasNext()) {
                SplinePoint sp = (SplinePoint) i.next();

                if (sp.isControlPoint()) {
                    p.addVertex(new DXFVertex(sp));
                }
            }
        }

        if (spline.isClosed()) {
            p.setFlags(1);
        }

        return p;
    }

    /**
     * To nurbs.
     *
     * @param spline the spline
     * @return the nurbs
     */
    public static NURBS toNurbs(DXFSpline spline) {
        Iterator i = spline.getSplinePointIterator();
        ArrayList list = new ArrayList();

        while (i.hasNext()) {
            SplinePoint sp = (SplinePoint) i.next();

            if (sp.isControlPoint()) {
                list.add(sp);
            }
        }

        NURBS n = new NURBS((Point[]) list.toArray(new Point[list.size()]),
                spline.getKnots(), spline.getWeights(), spline.getDegree());
        n.setClosed(spline.isClosed());

        return n;
    }
}
