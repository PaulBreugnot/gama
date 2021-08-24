/*******************************************************************************************************
 *
 * ConsoleSerializer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.xml;

import java.io.OutputStream;


/**
 * The Class ConsoleSerializer.
 *
 * @author simon
 */
public class ConsoleSerializer extends SAXPrettyOutputter {
    /* (non-Javadoc)
     * @see org.kabeja.xml.SAXSerializer#setOutput(java.io.OutputStream)
     */
    public void setOutput(OutputStream out) {
        //switch output to console
        super.setOutput(System.out);
    }
}
