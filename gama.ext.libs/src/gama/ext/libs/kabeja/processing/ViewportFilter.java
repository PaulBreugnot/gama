/*******************************************************************************************************
 *
 * ViewportFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.Iterator;
import java.util.Map;

import gama.ext.libs.kabeja.dxf.Bounds;
import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFLayer;
import gama.ext.libs.kabeja.dxf.DXFViewport;


/**
 * The Class ViewportFilter.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class ViewportFilter extends AbstractPostProcessor {
    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.tools.PostProcessor#process(org.kabeja.dxf.DXFDocument,
     *      java.util.Map)
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException {
        DXFViewport viewport = null;
        Iterator i = doc.getDXFViewportIterator();

        boolean found = false;

        while (i.hasNext() && !found) {
            DXFViewport v = (DXFViewport) i.next();

            if (v.isActive()) {
                viewport = v;
                found = true;
            }
        }

        if (viewport != null) {
            double h = viewport.getHeight() / 2;
            double w = (viewport.getHeight() * viewport.getAspectRatio()) / 2;
            Bounds b = new Bounds();

            // the upper right corner
            b.addToBounds(viewport.getCenterPoint().getX() + w,
                viewport.getCenterPoint().getY() + h,
                viewport.getCenterPoint().getZ());

            // the lower left corner
            b.addToBounds(viewport.getCenterPoint().getX() - w,
                viewport.getCenterPoint().getY() - h,
                viewport.getCenterPoint().getZ());
            filterEntities(b, doc);
        }
    }

    /**
     * Filter entities.
     *
     * @param b the b
     * @param doc the doc
     */
    protected void filterEntities(Bounds b, DXFDocument doc) {
        Iterator i = doc.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer l = (DXFLayer) i.next();
            Iterator ti = l.getDXFEntityTypeIterator();

            while (ti.hasNext()) {
                String type = (String) ti.next();
                Iterator ei = l.getDXFEntities(type).iterator();

                while (ei.hasNext()) {
                    DXFEntity entity = (DXFEntity) ei.next();
                    Bounds currentBounds = entity.getBounds();

                    if (!b.contains(currentBounds)) {
                        ei.remove();
                    }
                }
            }
        }
    }

    /* (non-Javadoc)
         * @see org.kabeja.tools.PostProcessor#setProperties(java.util.Map)
         */
    public void setProperties(Map properties) {
        // TODO Auto-generated method stub
    }
}
