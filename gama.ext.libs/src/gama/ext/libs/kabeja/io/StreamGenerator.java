/*******************************************************************************************************
 *
 * StreamGenerator.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.io;

import java.io.OutputStream;
import java.util.Map;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 *
 * This interface describes a Generator, which will generate  output  the given stream.
 *<h3>Lifecycle</h3>
 *
 * <ol>
 * <li>setProperties</li>
 * <li>getSuffix()</li>
 * <li>getMimeType()</li>
 * <li>generate()</li>
 * </ol>
 *@author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface StreamGenerator {
    
    /**
     * Sets the properties.
     *
     * @param properties the new properties
     */
    public void setProperties(Map properties);

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
     * Output the generation result to the given stream.
     *
     * @param doc the @see DXFDocument to  output
     * @param out the out
     */
    public void generate(DXFDocument doc, OutputStream out);
}
