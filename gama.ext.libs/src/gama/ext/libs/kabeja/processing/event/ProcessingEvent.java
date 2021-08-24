/*******************************************************************************************************
 *
 * ProcessingEvent.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing.event;

import gama.ext.libs.kabeja.processing.ProcessPipeline;


/**
 * The Class ProcessingEvent.
 */
public class ProcessingEvent {
    
    /** The pipeline. */
    protected ProcessPipeline pipeline;

    /**
     * Gets the process pipeline.
     *
     * @return the process pipeline
     */
    public ProcessPipeline getProcessPipeline() {
        return this.pipeline;
    }
}
