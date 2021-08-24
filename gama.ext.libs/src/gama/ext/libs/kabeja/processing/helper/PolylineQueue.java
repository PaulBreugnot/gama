/*******************************************************************************************************
 *
 * PolylineQueue.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.DXFArc;
import gama.ext.libs.kabeja.dxf.DXFConstants;
import gama.ext.libs.kabeja.dxf.DXFEntity;
import gama.ext.libs.kabeja.dxf.DXFLayer;
import gama.ext.libs.kabeja.dxf.DXFLine;
import gama.ext.libs.kabeja.dxf.DXFPolyline;
import gama.ext.libs.kabeja.dxf.DXFVertex;
import gama.ext.libs.kabeja.dxf.helpers.DXFUtils;
import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class PolylineQueue.
 */
public class PolylineQueue {
    
    /** The elements. */
    private List elements = new ArrayList();
    
    /** The start point. */
    private Point startPoint;
    
    /** The end point. */
    private Point endPoint;
    
    /** The radius. */
    private double radius = DXFConstants.POINT_CONNECTION_RADIUS;

    /**
     * Instantiates a new polyline queue.
     *
     * @param e the e
     * @param start the start
     * @param end the end
     * @param radius the radius
     */
    public PolylineQueue(DXFEntity e, Point start, Point end, double radius) {
        this.elements.add(e);
        this.startPoint = start;
        this.endPoint = end;
        this.radius = radius;
    }

    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * connect a DXF entity if possible.
     *
     * @param e the e
     * @param start the start
     * @param end the end
     * @return true if the entity could be connected, otherwise false
     */
    public boolean connectDXFEntity(DXFEntity e, Point start, Point end) {
        if (DXFUtils.equals(this.startPoint, end, radius)) {
            this.startPoint = start;
            this.elements.add(0, e);

            return true;
        } else if (DXFUtils.equals(this.endPoint, start, radius)) {
            this.endPoint = end;
            this.elements.add(e);

            return true;
        } else if (DXFUtils.equals(this.startPoint, start, radius)) {
            // we need to reverse then the entity
            this.startPoint = end;
            reverse(e);
            this.elements.add(0, e);

            return true;
        } else if (DXFUtils.equals(this.endPoint, end, radius)) {
            // we need to reverse then the entity
            this.endPoint = start;
            reverse(e);
            this.elements.add(e);

            return true;
        }

        return false;
    }

    /**
     * Gets the start point.
     *
     * @return the start point
     */
    public Point getStartPoint() {
        return this.startPoint;
    }

    /**
     * Gets the end point.
     *
     * @return the end point
     */
    public Point getEndPoint() {
        return this.endPoint;
    }

    /**
     * Gets the element iterator.
     *
     * @return the element iterator
     */
    public Iterator getElementIterator() {
        return this.elements.iterator();
    }

    /**
     * Connect.
     *
     * @param queue the queue
     * @return true, if successful
     */
    public boolean connect(PolylineQueue queue) {
        if (DXFUtils.equals(queue.getStartPoint(), this.endPoint, radius)) {
            // add to the end
            add(queue);

            return true;
        } else if (DXFUtils.equals(queue.getEndPoint(), this.startPoint, radius)) {
            // insert before
            insertBefore(queue);

            return true;
        } else if (DXFUtils.equals(queue.getStartPoint(), this.startPoint,
                    radius)) {
            queue.reverse();
            insertBefore(queue);

            return true;
        } else if (DXFUtils.equals(queue.getEndPoint(), this.endPoint, radius)) {
            queue.reverse();
            add(queue);

            return true;
        }

        return false;
    }

    /**
     * Creates the DXF polyline.
     *
     * @param layer the layer
     */
    public void createDXFPolyline(DXFLayer layer) {
        // create the polyline and remove the entity
        DXFPolyline pline = new DXFPolyline();
        DXFVertex first = new DXFVertex(this.startPoint);
        pline.addVertex(first);

        Iterator i = this.elements.iterator();

        while (i.hasNext()) {
            DXFEntity e = (DXFEntity) i.next();

            if (DXFConstants.ENTITY_TYPE_LINE.equals(e.getType())) {
                DXFLine line = (DXFLine) e;
                first = new DXFVertex(line.getEndPoint());
                pline.addVertex(first);
            } else if (DXFConstants.ENTITY_TYPE_POLYLINE.equals(e.getType()) ||
                    DXFConstants.ENTITY_TYPE_LWPOLYLINE.equals(e.getType())) {
                DXFPolyline pl = (DXFPolyline) e;
                double bulge = pl.getVertex(0).getBulge();

                if (bulge != 0.0) {
                    first.setBulge(bulge);
                }

                for (int x = 1; x < pl.getVertexCount(); x++) {
                    first = pl.getVertex(x);
                    pline.addVertex(first);
                }
            } else if (DXFConstants.ENTITY_TYPE_ARC.equals(e.getType())) {
                DXFArc arc = (DXFArc) e;

                if (arc.getTotalAngle() > 0.0) {
                    double h = arc.getRadius() * (1 -
                        Math.cos(Math.toRadians(arc.getTotalAngle() / 2)));
                    double chordLength = arc.getChordLength();

                    if (DXFUtils.equals(arc.getStartPoint(), first.getPoint(),
                                radius)) {
                        // the last point is our start point,
                        // which is always set
                        // we have to calculate the bulge
                        first.setBulge((2 * h) / chordLength);
                        first = new DXFVertex(arc.getEndPoint());
                        pline.addVertex(first);
                    } else {
                        // reverse the arc, we change the start/end points
                        // and set the bulge to >0
                        first.setBulge(-1.0 * ((2 * h) / chordLength));

                        first = new DXFVertex(arc.getStartPoint());
                        pline.addVertex(first);
                    }
                }
            }

            // remove from layer
            layer.removeDXFEntity(e);
        }

        // add the new polyline to the layer
        pline.setLayerName(layer.getName());
        layer.addDXFEntity(pline);
    }

    /**
     * Reverse.
     *
     * @param entity the entity
     */
    protected void reverse(DXFEntity entity) {
        if (DXFConstants.ENTITY_TYPE_LINE.equals(entity.getType())) {
            DXFUtils.reverseDXFLine((DXFLine) entity);
        } else if (DXFConstants.ENTITY_TYPE_POLYLINE.equals(entity.getType()) ||
                DXFConstants.ENTITY_TYPE_LWPOLYLINE.equals(entity.getType())) {
            DXFUtils.reverseDXFPolyline((DXFPolyline) entity);
        } else if (DXFConstants.ENTITY_TYPE_ARC.equals(entity.getType())) {
            // we cannot reverse a DXF ARC
        }
    }

    /**
     * Reverse.
     */
    protected void reverse() {
        Point p = this.endPoint;
        this.endPoint = this.startPoint;
        this.startPoint = p;

        // reverse the list and all entities
        int last = this.elements.size() - 1;

        for (int i = 0; i < (last + 1); i++) {
            DXFEntity first = (DXFEntity) this.elements.get(i);
            this.reverse(first);

            if (i < last) {
                DXFEntity e = (DXFEntity) this.elements.set(last, first);
                this.reverse(e);
                this.elements.set(i, e);
                last--;
            }
        }
    }

    /**
     * Insert the PolylineQueue before the first element.
     *
     * @param queue the queue
     */
    public void insertBefore(PolylineQueue queue) {
        this.startPoint = queue.getStartPoint();

        Iterator i = queue.getElementIterator();
        int x = 0;

        while (i.hasNext()) {
            DXFEntity e = (DXFEntity) i.next();
            this.elements.add(x, e);
            x++;
        }
    }

    /**
     * Adds the queue to the end.
     *
     * @param queue the queue
     */
    public void add(PolylineQueue queue) {
        this.endPoint = queue.getEndPoint();

        Iterator i = queue.getElementIterator();

        while (i.hasNext()) {
            DXFEntity e = (DXFEntity) i.next();
            this.elements.add(e);
        }
    }
}
