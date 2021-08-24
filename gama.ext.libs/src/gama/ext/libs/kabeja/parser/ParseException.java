/*******************************************************************************************************
 *
 * ParseException.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;


/**
 * The Class ParseException.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class ParseException extends Exception {
    
    /**
     * Instantiates a new parses the exception.
     *
     * @param s the s
     */
    public ParseException(String s) {
        super(s);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param s the s
     * @param e the e
     */
    public ParseException(String s, Exception e) {
        super(s, e);
    }

    /**
     * Instantiates a new parses the exception.
     *
     * @param e the e
     */
    public ParseException(Exception e) {
        super(e);
    }
}
