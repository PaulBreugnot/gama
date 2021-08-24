/*******************************************************************************************************
 *
 * PostProcessManager.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import gama.ext.libs.kabeja.dxf.DXFDocument;


/**
 * The Class PostProcessManager.
 *
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class PostProcessManager {
    
    /** The processors. */
    private ArrayList processors = new ArrayList();

    /**
     * Adds the post processor.
     *
     * @param pp the pp
     */
    public void addPostProcessor(PostProcessor pp) {
        processors.add(pp);
    }

    /**
     * Adds the post processor.
     *
     * @param classname the classname
     */
    public void addPostProcessor(String classname) {
        try {
            PostProcessor pp = (PostProcessor) this.getClass().getClassLoader()
                                                   .loadClass(classname)
                                                   .newInstance();
            addPostProcessor(pp);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Process.
     *
     * @param doc the doc
     * @param context the context
     * @throws ProcessorException the processor exception
     */
    public void process(DXFDocument doc, Map context) throws ProcessorException {
        Iterator i = processors.iterator();

        while (i.hasNext()) {
            PostProcessor pp = (PostProcessor) i.next();
            pp.process(doc, context);
        }
    }
}
