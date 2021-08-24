/*******************************************************************************************************
 *
 * ProcessorException.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;


/**
 * The Class ProcessorException.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class ProcessorException extends Exception {
    
    /**
     * Instantiates a new processor exception.
     */
    public ProcessorException() {
    }

    /**
     * Instantiates a new processor exception.
     *
     * @param e the e
     */
    public ProcessorException(Exception e) {
        super(e);
    }

    /**
     * Instantiates a new processor exception.
     *
     * @param msg the msg
     */
    public ProcessorException(String msg) {
        super(msg);
    }
}
