/*******************************************************************************************************
 *
 * SAXSerializer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.xml;

import java.io.OutputStream;

import org.xml.sax.ContentHandler;

import gama.ext.libs.kabeja.processing.Configurable;


/**
 *This interface describes a Serializer, which will serialize the SAX-Events
 *to the given stream.
 *<h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>getSuffix()</li>
 * <li>getMimeType()</li>
 * <li>setOutput()</li>
 * <li>startDocument and all other methods from org.xml.sax.ContentHandler </li>
 * </ol>
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface SAXSerializer extends ContentHandler, Configurable {
    
    /**
     * Gets the suffix.
     *
     * @return the suffix
     */
    public String getSuffix();

    /**
     * Gets the mime type.
     *
     * @return the mime type
     */
    public String getMimeType();

    /**
     * Sets the output.
     *
     * @param out the new output
     */
    public void setOutput(OutputStream out);
}
