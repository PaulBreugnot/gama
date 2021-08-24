/*******************************************************************************************************
 *
 * DXFMLineStyleElementDistanceComparator.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import java.util.Comparator;

import gama.ext.libs.kabeja.dxf.objects.DXFMLineStyleElement;


/**
 * The Class DXFMLineStyleElementDistanceComparator.
 */
public class DXFMLineStyleElementDistanceComparator implements Comparator {
    public int compare(Object arg0, Object arg1) {
        DXFMLineStyleElement el1 = (DXFMLineStyleElement) arg0;
        DXFMLineStyleElement el2 = (DXFMLineStyleElement) arg1;

        if (el1.getOffset() > el2.getOffset()) {
            return 1;
        } else if (el1.getOffset() < el2.getOffset()) {
            return -1;
        }

        return 0;
    }
}
