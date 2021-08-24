/*******************************************************************************************************
 *
 * HatchBoundaryLoop.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.Bounds;
import gama.ext.libs.kabeja.dxf.DXFEntity;


/**
 * The Class HatchBoundaryLoop.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class HatchBoundaryLoop {
    
    /** The edges. */
    private List edges = new ArrayList();
    
    /** The outermost. */
    private boolean outermost = true;

    /**
     * Checks if is outermost.
     *
     * @return Returns the outermost.
     */
    public boolean isOutermost() {
        return outermost;
    }

    /**
     * Sets the outermost.
     *
     * @param outermost            The outermost to set.
     */
    public void setOutermost(boolean outermost) {
        this.outermost = outermost;
    }

    /**
     * Gets the boundary edges iterator.
     *
     * @return the boundary edges iterator
     */
    public Iterator getBoundaryEdgesIterator() {
        return edges.iterator();
    }

    /**
     * Adds the boundary edge.
     *
     * @param edge the edge
     */
    public void addBoundaryEdge(DXFEntity edge) {
        edges.add(edge);
    }

    /**
     * Gets the bounds.
     *
     * @return the bounds
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();

        // System.out.println("edges="+edges.size());
        if (edges.size() > 0) {
            Iterator i = edges.iterator();

            while (i.hasNext()) {
                DXFEntity entity = (DXFEntity) i.next();
                Bounds b = entity.getBounds();

                if (b.isValid()) {
                    bounds.addToBounds(b);
                }
            }

            return bounds;
        } else {
            bounds.setValid(false);

            return bounds;
        }
    }

    /**
     * Gets the edge count.
     *
     * @return the edge count
     */
    public int getEdgeCount() {
        return this.edges.size();
    }
}
