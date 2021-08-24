/*******************************************************************************************************
 *
 * AbstractSAXGenerator.java, in gama.ext.libs, is part of the source code of the
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
import gama.ext.libs.kabeja.processing.AbstractConfigurable;


/**
 * The Class AbstractSAXGenerator.
 */
public abstract class AbstractSAXGenerator extends AbstractConfigurable
    implements SAXGenerator {
    
    /** The doc. */
    protected DXFDocument doc;
    
    /** The handler. */
    protected ContentHandler handler;
    
    /** The context. */
    protected Map context;

    public void generate(DXFDocument doc, ContentHandler handler, Map context)
        throws SAXException {
        this.doc = doc;
        this.handler = handler;
        this.context = context;
        this.generate();
    }

    /**
     * This method has to be overwritten by any subclass. At this point the
     * XMLGenerator is setup (properties, ContentHandler and DXFDocument) and
     * should emit the XML content to the ContentHandler.
     *
     * @throws SAXException the SAX exception
     */
    protected abstract void generate() throws SAXException;
}
