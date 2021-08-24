/*******************************************************************************************************
 *
 * BoundsFilter.java, in gama.ext.libs, is part of the source code of the
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


/**
 * The Class BoundsFilter.
 */
public class BoundsFilter extends AbstractPostProcessor {
    
    /** The Constant PROPERTY_X. */
    public final static String PROPERTY_X = "boundsfilter.x";
    
    /** The Constant PROPERTY_Y. */
    public final static String PROPERTY_Y = "boundsfilter.y";
    
    /** The Constant PROPERTY_WIDTH. */
    public final static String PROPERTY_WIDTH = "boundsfilter.width";
    
    /** The Constant PROPERTY_HEIGHT. */
    public final static String PROPERTY_HEIGHT = "boundsfilter.height";
    
    /** The Constant PROPERTY_PROCESS. */
    public final static String PROPERTY_PROCESS = "boundsfilter.process";

    public void process(DXFDocument doc, Map context) throws ProcessorException {
        if (this.properties.containsKey(PROPERTY_PROCESS) &&
                Boolean.valueOf((String) this.properties.get(PROPERTY_PROCESS))
                           .booleanValue()) {
            Bounds bounds = new Bounds();

            if (this.properties.containsKey(PROPERTY_X)) {
                bounds.setMinimumX(Double.parseDouble(
                        (String) this.properties.get(PROPERTY_X)));
            }

            if (this.properties.containsKey(PROPERTY_Y)) {
                bounds.setMinimumY(Double.parseDouble(
                        (String) this.properties.get(PROPERTY_Y)));
            }

            if (this.properties.containsKey(PROPERTY_WIDTH)) {
                bounds.setMaximumX(bounds.getMinimumX() +
                    Double.parseDouble(
                        (String) this.properties.get(PROPERTY_WIDTH)));
            }

            if (this.properties.containsKey(PROPERTY_WIDTH)) {
                bounds.setMaximumY(bounds.getMinimumY() +
                    Double.parseDouble(
                        (String) this.properties.get(PROPERTY_HEIGHT)));
            }

            // the bounds should be setup now
            // we remove all entities which are
            // not inside our bounds
            Iterator i = doc.getDXFLayerIterator();

            while (i.hasNext()) {
                DXFLayer layer = (DXFLayer) i.next();
                filterLayer(layer, bounds);
            }
        }
    }

    /**
     * Filter layer.
     *
     * @param layer the layer
     * @param bounds the bounds
     */
    protected void filterLayer(DXFLayer layer, Bounds bounds) {
        Iterator i = layer.getDXFEntityTypeIterator();

        while (i.hasNext()) {
            String type = (String) i.next();
            Iterator entities = layer.getDXFEntities(type).iterator();

            while (entities.hasNext()) {
                DXFEntity entity = (DXFEntity) entities.next();

                if (!bounds.enclose(entity.getBounds())) {
                    // the bounds not contains this entity
                    // we remove it
                    entities.remove();
                }
            }
        }
    }
}
