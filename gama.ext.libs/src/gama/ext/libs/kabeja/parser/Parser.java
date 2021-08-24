/*******************************************************************************************************
 *
 * Parser.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;

import java.io.InputStream;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 * This interface describes a Parser, which will parse a specific
 * format and create a DXFDocument from this data.
 * <h2>Lifecycle</h2>
 * <ol>
 *   <li>supportedExtension()</li>
 *   <li>parse(...)</li>
 *   <li>getDXFDocument()</li>
 * </ol>
 *
 * <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface Parser extends Handler {
	
	
	/**
	 * Parse the given file.
	 *
	 * @param file the file to parse
	 * @throws ParseException the parse exception
	 */
	
    public abstract void parse(String file) throws ParseException;

    /**
     * Parse the given file with the specific encoding.
     *
     * @param file the file
     * @param encoding the encoding
     * @throws ParseException the parse exception
     */
    
    
    public abstract void parse(String file, String encoding)
        throws ParseException;

    
    
    /**
     * Parse the given inputstream.
     *
     * @param input the input
     * @param encoding the encoding
     * @throws ParseException the parse exception
     */
    public abstract void parse(InputStream input, String encoding)
        throws ParseException;
    
    /**
     * Gets the parsed DXFDocument after parsing.
     * @return the parsed @see org.kabeja.dxf.DXFDocument after parsing. 
     */

    public abstract DXFDocument getDocument();
    
    /**
     * Supported extension.
     *
     * @param extension the extension
     * @return true, if successful
     */

    public abstract boolean supportedExtension(String extension);

    /**
     * Gets the name of the parser.
     *
     * @return the name
     */
    public abstract String getName();
}
