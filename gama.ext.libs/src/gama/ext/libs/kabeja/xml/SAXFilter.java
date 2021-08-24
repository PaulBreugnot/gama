/*******************************************************************************************************
 *
 * SAXFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.xml;

import org.xml.sax.ContentHandler;

import gama.ext.libs.kabeja.processing.Configurable;


/**
 * A SAXFilter consumes SAX events and passes SAX event to the next
 * org.xml.sax.ContentHandler.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface SAXFilter extends ContentHandler, Configurable {
    
    /**
     * Sets the content handler.
     *
     * @param handler the new content handler
     */
    public void setContentHandler(ContentHandler handler);
}
