/*******************************************************************************************************
 *
 * ProcessingListener.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing.event;

import gama.ext.libs.kabeja.processing.ProcessingManager;


/**
 * The listener interface for receiving processing events.
 * The class that is interested in processing a processing
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addProcessingListener<code> method. When
 * the processing event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ProcessingEvent
 */
public interface ProcessingListener {
    
    /**
     * Start processig.
     *
     * @param e the e
     */
    public void startProcessig(ProcessingEvent e);

    /**
     * End processing.
     *
     * @param e the e
     */
    public void endProcessing(ProcessingEvent e);

    /**
     * Configuration changed.
     *
     * @param mangager the mangager
     */
    public void configurationChanged(ProcessingManager mangager);
}
