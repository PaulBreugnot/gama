/*******************************************************************************************************
 *
 * HandlerManager.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser;


/**
 * The Interface HandlerManager.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public interface HandlerManager extends Handler {
    
    /**
     * Adds the handler.
     *
     * @param handler the handler
     */
    public void addHandler(Handler handler);
}
