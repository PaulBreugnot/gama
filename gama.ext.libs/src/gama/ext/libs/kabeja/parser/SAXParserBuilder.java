/*******************************************************************************************************
 *
 * SAXParserBuilder.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


/**
 * Build a Parser from XML stream with the following format:
 *
 * <pre>
 *
 *  &lt;?xml version=&quot;1.0&quot;encoding=&quot;utf-8&quot; ?&gt;
 *
 *  &lt;parser class=&quot;org.kabeja.parser.DXFParser&quot; xmlns=&quot;http://kabeja.org/parser/1.0&quot;&gt;
 *    &lt;handler class=&quot;org.kabeja.parser.DXFHeaderSectionHandler&quot;/&gt;
 *    &lt;handler class=&quot;org.kabeja.parser.DXFTableSectionHandler&quot;&gt;
 *      &lt;handlers&gt;
 *                    &lt;handler class=&quot;org.kabeja.parser.table.DXFLayerTableHandler&quot;/&gt;
 *      &lt;/handlers&gt;
 *    &lt;/handler&gt;
 *
 *    &lt;!--+
 *        | The block and the entities handler use the same sub handlers.
 *        | If you have create a parser for an entity add the parser in
 *        | both sections.
 *        +--&gt;
 *
 *    &lt;handler class=&quot;org.kabeja.parser.DXFBlocksSectionHandler&quot;&gt;
 *            &lt;handlers&gt;
 *              &lt;handler class=&quot;org.kabeja.parser.entities.DXFArcHandler&quot;/&gt;
 *              &lt;handler class=&quot;org.kabeja.parser.entities.DXFCircleHandler&quot;/&gt;
 *            &lt;/handlers&gt;
 *    &lt;/handler&gt;
 *
 *
 *    &lt;handler class=&quot;org.kabeja.parser.DXFEntitiesSectionHandler&quot;&gt;
 *            &lt;handlers&gt;
 *                    &lt;handler class=&quot;org.kabeja.parser.entities.DXFArcHandler&quot;/&gt;
 *                    &lt;handler class=&quot;org.kabeja.parser.entities.DXFCircleHandler&quot;/&gt;
 *            &lt;handler class=&quot;org.kabeja.parser.entities.DXFEllipseHandler&quot;/&gt;
 *               &lt;/handlers&gt;
 *    &lt;/handler&gt;
 *   &lt;/parser&gt;
 *
 * </pre>
 *
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public class SAXParserBuilder implements ContentHandler {
    
    /** The element parser. */
    public static String ELEMENT_PARSER = "parser";
    
    /** The element handler. */
    public static String ELEMENT_HANDLER = "handler";
    
    /** The element handlers. */
    public static String ELEMENT_HANDLERS = "handlers";
    
    /** The attribute class. */
    public static String ATTRIBUTE_CLASS = "class";
    
    /** The attribute extensions. */
    public static String ATTRIBUTE_EXTENSIONS = "extensions";
    
    /** The xmlns kabeja parser. */
    public static String XMLNS_KABEJA_PARSER = "http://kabeja.org/parser/1.0";
    
    /** The parser. */
    private Parser parser;
    
    /** The stack. */
    private Stack stack = new Stack();
    
    /** The current handler manager. */
    private HandlerManager currentHandlerManager;
    
    /** The handler. */
    private Handler handler;

    /**
     * Instantiates a new SAX parser builder.
     */
    public SAXParserBuilder() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#characters(char[], int, int)
     */
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#endDocument()
     */
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#endElement(java.lang.String,
     *      java.lang.String, java.lang.String)
     */
    public void endElement(String namespaceURI, String localName, String qName)
        throws SAXException {
        if (localName.equals(ELEMENT_HANDLERS) &&
                namespaceURI.equals(XMLNS_KABEJA_PARSER)) {
            currentHandlerManager = (HandlerManager) stack.pop();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String)
     */
    public void endPrefixMapping(String prefix) throws SAXException {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#ignorableWhitespace(char[], int, int)
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#processingInstruction(java.lang.String,
     *      java.lang.String)
     */
    public void processingInstruction(String target, String data)
        throws SAXException {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#setDocumentLocator(org.xml.sax.Locator)
     */
    public void setDocumentLocator(Locator locator) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#skippedEntity(java.lang.String)
     */
    public void skippedEntity(String name) throws SAXException {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#startDocument()
     */
    public void startDocument() throws SAXException {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#startElement(java.lang.String,
     *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    public void startElement(String namespaceURI, String localName,
        String qName, Attributes atts) throws SAXException {
        if (namespaceURI.equals(XMLNS_KABEJA_PARSER)) {
            if (localName.equals(ELEMENT_HANDLER)) {
                String clazz = atts.getValue(ATTRIBUTE_CLASS);

                try {
                    // load the class and add to the currentHandlerManager
                    Class c = this.getClass().getClassLoader().loadClass(clazz);
                    handler = (Handler) c.newInstance();
                    currentHandlerManager.addHandler(handler);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (localName.equals(ELEMENT_HANDLERS)) {
                stack.add(currentHandlerManager);
                currentHandlerManager = (HandlerManager) handler;
            } else if (localName.equals(ELEMENT_PARSER)) {
                String clazz = atts.getValue(ATTRIBUTE_CLASS);

                try {
                    // load the class and add to the currentHandlerManager
                    Class c = this.getClass().getClassLoader().loadClass(clazz);
                    this.parser = (Parser) c.newInstance();

                    if (this.parser instanceof HandlerManager) {
                        this.currentHandlerManager = (HandlerManager) this.parser;
                    }

                    this.stack = new Stack();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.ContentHandler#startPrefixMapping(java.lang.String,
     *      java.lang.String)
     */
    public void startPrefixMapping(String prefix, String uri)
        throws SAXException {
        // TODO Auto-generated method stub
    }

    /**
     * Gets the parser.
     *
     * @return the parser
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Builds the from stream.
     *
     * @param in            the InputStream
     * @return The DXFParser build from the XML description
     */
    public static Parser buildFromStream(InputStream in) {
        SAXParserBuilder builder = new SAXParserBuilder();

        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setFeature("http://apache.org/xml/features/xinclude", true);
            parser.setContentHandler(builder);
            parser.parse(new InputSource(in));
        } catch (SAXException e) {
            System.err.println(e.getMessage());
        } catch (IOException ioe) {
        }

        return builder.getParser();
    }
}
