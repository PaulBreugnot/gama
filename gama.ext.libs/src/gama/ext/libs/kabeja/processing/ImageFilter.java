/*******************************************************************************************************
 *
 * ImageFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.dxf.DXFImage;
import gama.ext.libs.kabeja.dxf.DXFLayer;
import gama.ext.libs.kabeja.dxf.objects.DXFImageDefObject;


/**
 * The Class ImageFilter.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class ImageFilter extends AbstractPostProcessor {
    /*
     * (non-Javadoc)
     *
     * @see org.kabeja.tools.PostProcessor#process(org.kabeja.dxf.DXFDocument,
     *      java.util.Map)
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException {
        Iterator i = doc.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer l = (DXFLayer) i.next();

            if (l.hasDXFEntities(DXFConstants.ENTITY_TYPE_IMAGE)) {
                Iterator in = l.getDXFEntities(DXFConstants.ENTITY_TYPE_IMAGE)
                               .iterator();

                while (in.hasNext()) {
                    DXFImage img = (DXFImage) in.next();
                    String imgDef = img.getImageDefObjectID();
                    DXFImageDefObject def = (DXFImageDefObject) doc.getDXFObjectByID(imgDef);
                    File f = new File(def.getFilename());

                    if (!f.exists()) {
                        in.remove();
                    }
                }
            }
        }
    }
}
