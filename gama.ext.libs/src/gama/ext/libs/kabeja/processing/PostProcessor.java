/*******************************************************************************************************
 *
 * PostProcessor.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.Map;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 * This interface describes a PostPorcessor, which will work direct with
 * parsed CAD data.
 *
 * <h2>Lifecycle</h2>
 * <ol>
 *   <li>setProperties()</li>
 *   <li>process()</li>
 *
 * </ol>
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 *
 */
public interface PostProcessor extends Configurable {
    
    /**
     * Postprocess the given DXFDocument.
     *
     * @param doc the doc
     * @param context the context
     * @throws ProcessorException the processor exception
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException;
}
