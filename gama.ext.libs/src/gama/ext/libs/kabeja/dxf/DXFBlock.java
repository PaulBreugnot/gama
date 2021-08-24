/*******************************************************************************************************
 *
 * DXFBlock.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;
import java.util.Iterator;

import gama.ext.libs.kabeja.dxf.helpers.Point;


/**
 * The Class DXFBlock.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFBlock {
    
    /** The type. */
    public static String TYPE = "BLOCK";
    
    /** The reference point. */
    private Point referencePoint;
    
    /** The layer ID. */
    private String layerID = DXFConstants.DEFAULT_LAYER;
    
    /** The name. */
    private String name = "";
    
    /** The description. */
    private String description = "";
    
    /** The entities. */
    private ArrayList entities;
    
    /** The doc. */
    private DXFDocument doc;

    /**
     * Instantiates a new DXF block.
     */
    public DXFBlock() {
        super();

        this.entities = new ArrayList();
        this.referencePoint = new Point();
    }

    /**
     * Gets the bounds.
     *
     * @return the bounds
     */
    public Bounds getBounds() {
        // first set the own point
        Bounds bounds = new Bounds();
        Iterator i = entities.iterator();

        if (i.hasNext()) {
            while (i.hasNext()) {
                DXFEntity entity = (DXFEntity) i.next();
                Bounds b = entity.getBounds();

                if (b.isValid()) {
                    bounds.addToBounds(b);
                }
            }
        } else {
            bounds.setValid(false);
        }

        return bounds;
    }

    /**
     * Gets the description.
     *
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description            The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the reference point.
     *
     * @return Returns the p.
     */
    public Point getReferencePoint() {
        return referencePoint;
    }

    /**
     * Sets the reference point.
     *
     * @param p            The p to set.
     */
    public void setReferencePoint(Point p) {
        this.referencePoint = p;
    }

    /**
     * Adds the DXF entity.
     *
     * @param entity the entity
     */
    public void addDXFEntity(DXFEntity entity) {
        entities.add(entity);
    }

    /**
     * Gets the DXF entities iterator.
     *
     * @return a iterator over all entities of this block
     */
    public Iterator getDXFEntitiesIterator() {
        return entities.iterator();
    }

    /**
     * Gets the layer ID.
     *
     * @return Returns the layerID.
     */
    public String getLayerID() {
        return layerID;
    }

    /**
     * Sets the layer ID.
     *
     * @param layerID            The layerID to set.
     */
    public void setLayerID(String layerID) {
        this.layerID = layerID;
    }

    /**
     * Gets the name.
     *
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the DXF document.
     *
     * @param doc            The doc to set.
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;

        Iterator i = entities.iterator();

        while (i.hasNext()) {
            DXFEntity entity = (DXFEntity) i.next();
            entity.setDXFDocument(doc);
        }
    }

    /**
     * Gets the DXF document.
     *
     * @return the parent document
     */
    public DXFDocument getDXFDocument() {
        return this.doc;
    }

    /**
     * Gets the length.
     *
     * @return the length
     */
    public double getLength() {
        double length = 0;
        Iterator i = entities.iterator();

        while (i.hasNext()) {
            DXFEntity entity = (DXFEntity) i.next();
            length += entity.getLength();
        }

        return length;
    }

    /**
     * Gets the.
     *
     * @param id            of the
     * @return the
     * @see DXFEntity with the specified ID.
     * @see DXFEntity
     * @see DXFEntity with the specified ID or null if there is no
     * @see DXFEntity with the specified ID
     */
    public DXFEntity getDXFEntityByID(String id) {
        DXFEntity entity = null;
        Iterator i = this.entities.iterator();

        while (i.hasNext()) {
            DXFEntity e = (DXFEntity) i.next();

            if (e.getID().equals(id)) {
                return e;
            }
        }

        return entity;
    }
}
