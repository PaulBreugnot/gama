/*******************************************************************************************************
 *
 * DXFLayer.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;


/**
 * The Class DXFLayer.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFLayer {
    
    /** The entities. */
    private Hashtable entities = new Hashtable();
    
    /** The name. */
    private String name = "";
    
    /** The color. */
    private int color = 7;
    
    /** The doc. */
    private DXFDocument doc;
    
    /** The ltype. */
    private String ltype = "";
    
    /** The flags. */
    private int flags = 0;
    
    /** The line weight. */
    private int lineWeight = 0;
    
    /** The plot style. */
    private String plotStyle = "";

    /**
     * Instantiates a new DXF layer.
     */
    public DXFLayer() {
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
     * Adds the DXF entity.
     *
     * @param entity the entity
     */
    public void addDXFEntity(DXFEntity entity) {
        entity.setDXFDocument(this.doc);

        if (entities.containsKey(entity.getType())) {
            ((ArrayList) entities.get(entity.getType())).add(entity);
        } else {
            ArrayList list = new ArrayList();

            list.add(entity);
            entities.put(entity.getType(), list);
        }
    }

    /**
     * Removes the DXF entity.
     *
     * @param entity the entity
     */
    public void removeDXFEntity(DXFEntity entity) {
        if (entities.containsKey(entity.getType())) {
            ArrayList list = (ArrayList) entities.get(entity.getType());
            list.remove(entity);

            if (list.isEmpty()) {
                entities.remove(entity.getType());
            }
        }
    }

    /**
     * Sets the DXF document.
     *
     * @param doc the new DXF document
     */
    public void setDXFDocument(DXFDocument doc) {
        this.doc = doc;
    }

    /**
     * Gets the DXF document.
     *
     * @return the DXF document
     */
    public DXFDocument getDXFDocument() {
        return this.doc;
    }

    /**
     * Gets the bounds.
     *
     * @return the bounds
     */
    public Bounds getBounds() {
        Bounds bounds = new Bounds();
        Enumeration e = entities.elements();

        while (e.hasMoreElements()) {
            ArrayList list = (ArrayList) e.nextElement();

            Iterator i = list.iterator();

            while (i.hasNext()) {
                DXFEntity entity = (DXFEntity) i.next();
                Bounds b = entity.getBounds();

                if (b.isValid()) {
                    bounds.addToBounds(b);
                }
            }
        }

        return bounds;
    }

    /**
     * Get the bounds for the given filter flag. If true the bounds contains only
     * entity bounds which are on model space. Else returns the bounds which contains the entity bounds which are on
     * paperspace.
     *
     * @param onModelspace the on modelspace
     * @return the bounds
     */
    public Bounds getBounds(boolean onModelspace) {
        Bounds bounds = new Bounds();

        Enumeration e = entities.elements();

        while (e.hasMoreElements()) {
            ArrayList list = (ArrayList) e.nextElement();

            Iterator i = list.iterator();

            while (i.hasNext()) {
                DXFEntity entity = (DXFEntity) i.next();

                if ((onModelspace && entity.isModelSpace()) ||
                        (!onModelspace && !entity.isModelSpace())) {
                    Bounds b = entity.getBounds();

                    if (b.getMaximumX() == Double.NaN) {
                        System.out.println("NANA=" + entity);
                    }

                    if (b.isValid()) {
                        bounds.addToBounds(b);
                    }
                }
            }
        }

        return bounds;
    }

    /**
     * Returns the list of the DXFenetities of the Type or null.
     *
     * @param type the type
     * @return List or null
     */
    public List getDXFEntities(String type) {
        if (entities.containsKey(type)) {
            return (ArrayList) entities.get(type);
        }

        return null;
    }

    /**
     * Checks for DXF entities.
     *
     * @param type the type
     * @return true, if successful
     */
    public boolean hasDXFEntities(String type) {
        return entities.containsKey(type);
    }

    /**
     * Gets the DXF entity type iterator.
     *
     * @return a iterator over all entity types of this layer
     */
    public Iterator getDXFEntityTypeIterator() {
        return entities.keySet().iterator();
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
        Iterator i = this.entities.values().iterator();

        while (i.hasNext()) {
            Iterator entityIterator = ((List) i.next()).iterator();

            while (entityIterator.hasNext()) {
                DXFEntity e = (DXFEntity) entityIterator.next();

                if (e.getID().equals(id)) {
                    return e;
                }
            }
        }

        return entity;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public int getColor() {
        return this.color;
    }

    /**
     * Sets the color.
     *
     * @param color the new color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Sets the line type.
     *
     * @param ltype the new line type
     */
    public void setLineType(String ltype) {
        this.ltype = ltype;
    }

    /**
     * Gets the line type.
     *
     * @return the line type
     */
    public String getLineType() {
        return ltype;
    }

    /**
     * Gets the flags.
     *
     * @return Returns the flags.
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Sets the flags.
     *
     * @param flags            The flags to set.
     */
    public void setFlags(int flags) {
        this.flags = flags;
    }

    /**
     * Checks if is visible.
     *
     * @return true, if is visible
     */
    public boolean isVisible() {
        return color >= 0;
    }

    /**
     * Checks if is frozen.
     *
     * @return true, if is frozen
     */
    public boolean isFrozen() {
        return ((this.flags & 1) == 1);
    }

    /**
     * Gets the line weight.
     *
     * @return the line weight
     */
    public int getLineWeight() {
        return lineWeight;
    }

    /**
     * Sets the line weight.
     *
     * @param lineWeight the new line weight
     */
    public void setLineWeight(int lineWeight) {
        this.lineWeight = lineWeight;
    }

    /**
     * Gets the plot style.
     *
     * @return the plot style
     */
    public String getPlotStyle() {
        return plotStyle;
    }

    /**
     * Sets the plot style.
     *
     * @param plotStyle the new plot style
     */
    public void setPlotStyle(String plotStyle) {
        this.plotStyle = plotStyle;
    }
}
