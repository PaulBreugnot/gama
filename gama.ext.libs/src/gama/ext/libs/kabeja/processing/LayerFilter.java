/*******************************************************************************************************
 *
 * LayerFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFLayer;


/**
 * The Class LayerFilter.
 */
public class LayerFilter extends AbstractPostProcessor {
    
    /** The Constant PROPERTY_REMOVE_LAYERS. */
    public final static String PROPERTY_REMOVE_LAYERS = "layers.remove";
    
    /** The Constant PROPERTY_MERGE_LAYERS. */
    public final static String PROPERTY_MERGE_LAYERS = "layers.merge";
    
    /** The Constant MERGED_LAYER_NAME. */
    public final static String MERGED_LAYER_NAME = "ALL";
    
    /** The merge. */
    protected boolean merge = false;
    
    /** The removable layers. */
    protected Set removableLayers = new HashSet();

    public void setProperties(Map properties) {
        super.setProperties(properties);

        if (properties.containsKey(PROPERTY_MERGE_LAYERS)) {
            this.merge = Boolean.valueOf((String) properties.get(
                        PROPERTY_MERGE_LAYERS)).booleanValue();
        }

        if (properties.containsKey(PROPERTY_REMOVE_LAYERS)) {
            this.removableLayers.clear();

            StringTokenizer st = new StringTokenizer((String) properties.get(
                        PROPERTY_REMOVE_LAYERS), "|");

            while (st.hasMoreTokens()) {
                this.removableLayers.add(st.nextToken());
            }
        }
    }

    public void process(DXFDocument doc, Map context) throws ProcessorException {
        DXFLayer mergeLayer = null;

        if (this.merge) {
            if (doc.containsDXFLayer(MERGED_LAYER_NAME)) {
                mergeLayer = doc.getDXFLayer(MERGED_LAYER_NAME);
            } else {
                mergeLayer = new DXFLayer();
                mergeLayer.setName(MERGED_LAYER_NAME);
                doc.addDXFLayer(mergeLayer);
            }
        }

        // iterate over all layers
        Iterator i = doc.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer layer = (DXFLayer) i.next();

            if (this.removableLayers.contains(layer.getName())) {
                i.remove();
            } else if (this.merge) {
                if (layer != mergeLayer) {
                    Iterator types = layer.getDXFEntityTypeIterator();

                    while (types.hasNext()) {
                        String type = (String) types.next();
                        Iterator entityIterator = layer.getDXFEntities(type)
                                                       .iterator();

                        while (entityIterator.hasNext()) {
                            DXFEntity e = (DXFEntity) entityIterator.next();
                            // we set all entities to the merged layer
                            // and remove them from the last layer
                            e.setLayerName(MERGED_LAYER_NAME);

                            // set again to the doc, which will
                            // place the entity on the right
                            // layer -> the LAYER = "ALL"
                            doc.addDXFEntity(e);
                            entityIterator.remove();
                        }
                    }

                    // remove the layer
                    i.remove();
                }
            }
        }
    }
}
