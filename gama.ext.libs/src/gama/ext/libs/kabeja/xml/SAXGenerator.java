/*******************************************************************************************************
 *
 * SAXGenerator.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.xml;

import java.util.Map;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.processing.Configurable;


/**
 * This interface describes a generator component, which emit convert the
 * DXFDocument to SAX-Event.
 * <h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>generate(DXFDocument doc,ConentHandler handler)</li>
 * </ol>
 *
 * @author simon.mieth
 *
 */
public interface SAXGenerator extends Configurable {
    
    /**
     * Generate.
     *
     * @param doc the doc
     * @param handler the handler
     * @param context the context
     * @throws SAXException the SAX exception
     */
    public void generate(DXFDocument doc, ContentHandler handler, Map context)
        throws SAXException;
}
