/*******************************************************************************************************
 *
 * NamespaceFilterHandler.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.ext.libs.kml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * The Class NamespaceFilterHandler.
 */
final class NamespaceFilterHandler
    implements ContentHandler
{

    /** The Constant KML_20. */
    private final static String KML_20 = "http://earth.google.com/kml/2.0";
    
    /** The Constant KML_21. */
    private final static String KML_21 = "http://earth.google.com/kml/2.1";
    
    /** The Constant KML_22. */
    private final static String KML_22 = "http://www.opengis.net/kml/2.2";
    
    /** The content handler. */
    private ContentHandler contentHandler;

    /**
     * Instantiates a new namespace filter handler.
     *
     * @param contentHandler the content handler
     */
    public NamespaceFilterHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    public void startElement(String uri, String localName, String qName, Attributes atts)
        throws SAXException
    {
        if (uri.equals(KML_20)||uri.equals(KML_21)) {
            contentHandler.startElement(KML_22, localName, qName, atts);
        } else {
            contentHandler.startElement(uri, localName, qName, atts);
        }
    }

    public void characters(char[] ch, int start, int length)
        throws SAXException
    {
        contentHandler.characters(ch, start, length);
    }

    public void endDocument()
        throws SAXException
    {
        contentHandler.endDocument();
    }

    public void endElement(String uri, String localName, String qName)
        throws SAXException
    {
        contentHandler.endElement(uri, localName, qName);
    }

    public void endPrefixMapping(String prefix)
        throws SAXException
    {
        contentHandler.endPrefixMapping(prefix);
    }

    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException
    {
        contentHandler.ignorableWhitespace(ch, start, length);
    }

    public void processingInstruction(String target, String data)
        throws SAXException
    {
        contentHandler.processingInstruction(target, data);
    }

    public void setDocumentLocator(Locator locator) {
        contentHandler.setDocumentLocator(locator);
    }

    public void skippedEntity(String name)
        throws SAXException
    {
        contentHandler.skippedEntity(name);
    }

    public void startDocument()
        throws SAXException
    {
        contentHandler.startDocument();
    }

    public void startPrefixMapping(String prefix, String uri)
        throws SAXException
    {
        contentHandler.startPrefixMapping(prefix, uri);
    }

}
