/*******************************************************************************************************
 *
 * FilterExample.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.dxf.filter;

import java.util.HashMap;
import java.util.Map;

import gama.ext.libs.kabeja.dxf.DXFDocument;
import gama.ext.libs.kabeja.parser.DXFParser;
import gama.ext.libs.kabeja.parser.ParserBuilder;


/**
 * The Class FilterExample.
 */
public class FilterExample {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            DXFParser parser = (DXFParser) ParserBuilder.createDefaultParser();

            //test 
            DXFStreamFilter filter = new DXFStreamLayerFilter();
            Map p = new HashMap();
            p.put("layers.include", args[0]);
            filter.setProperties(p);
            parser.addDXFStreamFilter(filter);
            parser.parse(args[1]);

            DXFDocument doc = parser.getDocument();

            //do something with the doc
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
