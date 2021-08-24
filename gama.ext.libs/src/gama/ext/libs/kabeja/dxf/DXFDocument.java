/*******************************************************************************************************
 *
 * DXFDocument.java, in gama.ext.libs, is part of the source code of the
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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import gama.ext.libs.kabeja.dxf.objects.DXFDictionary;
import gama.ext.libs.kabeja.dxf.objects.DXFObject;


/**
 * The Class DXFDocument.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFDocument {
    
    /** The property encoding. */
    public static String PROPERTY_ENCODING = "encoding";
    
    /** The Constant DEFAULT_MARGIN. */
    public static final double DEFAULT_MARGIN = 5;
    
    /** The layers. */
    private Hashtable layers = new Hashtable();
    
    /** The blocks. */
    private Hashtable blocks = new Hashtable();
    
    /** The line types. */
    private HashMap lineTypes = new HashMap();
    
    /** The dimension styles. */
    private HashMap dimensionStyles = new HashMap();
    
    /** The text styles. */
    private HashMap textStyles = new HashMap();

    /** The ucs. */
    // the user coordinate systems
    private Hashtable ucs = new Hashtable();
    
    /** The properties. */
    private Hashtable properties = new Hashtable();
    
    /** The viewports. */
    private List viewports = new ArrayList();
    
    /** The bounds. */
    private Bounds bounds = new Bounds();
    
    /** The margin. */
    private double margin;
    
    /** The header. */
    private DXFHeader header = new DXFHeader();
    
    /** The objects. */
    private HashMap objects = new HashMap();
    
    /** The patterns. */
    private HashMap patterns = new HashMap();
    
    /** The views. */
    private List views = new ArrayList();
    
    /** The root dictionary. */
    private DXFDictionary rootDictionary = new DXFDictionary();

    /**
     * Instantiates a new DXF document.
     */
    public DXFDocument() {
        // the defalut layer
        DXFLayer defaultLayer = new DXFLayer();
        defaultLayer.setDXFDocument(this);
        defaultLayer.setName(DXFConstants.DEFAULT_LAYER);
        this.layers.put(DXFConstants.DEFAULT_LAYER, defaultLayer);

        // setup the margin
        this.margin = DEFAULT_MARGIN;

        // setup the root Dictionary
        this.rootDictionary = new DXFDictionary();
        this.rootDictionary.setDXFDocument(this);
    }

    /**
     * Adds the DXF layer.
     *
     * @param layer the layer
     */
    public void addDXFLayer(DXFLayer layer) {
        layer.setDXFDocument(this);
        layers.put(layer.getName(), layer);
    }

    /**
     *
     * Returns the specified layer.
     *
     * @param key
     *            The layer id
     * @return the layer or if not found the default layer (layer "0")
     */
    public DXFLayer getDXFLayer(String key) {
        if (this.layers.containsKey(key)) {
            return (DXFLayer) layers.get(key);
        }

        // retun the default layer
        if (this.layers.containsKey(DXFConstants.DEFAULT_LAYER)) {
            return (DXFLayer) layers.get(DXFConstants.DEFAULT_LAYER);
        } else {
            DXFLayer layer = new DXFLayer();
            layer.setName(DXFConstants.DEFAULT_LAYER);
            this.addDXFLayer(layer);

            return layer;
        }
    }

    /**
     * Returns true if the document contains the specified layer.
     *
     * @param layerName
     *            the layer name
     * @return true - if the document contains the layer, otherwise false
     */
    public boolean containsDXFLayer(String layerName) {
        return this.layers.containsKey(layerName);
    }

    /**
     * Gets the DXF layer iterator.
     *
     * @return the iterator over all DXFLayer of this document
     */
    public Iterator getDXFLayerIterator() {
        return layers.values().iterator();
    }

    /**
     * Adds the DXF line type.
     *
     * @param ltype the ltype
     */
    public void addDXFLineType(DXFLineType ltype) {
        lineTypes.put(ltype.getName(), ltype);
    }

    /**
     * Gets the DXF line type.
     *
     * @param name the name
     * @return the DXF line type
     */
    public DXFLineType getDXFLineType(String name) {
        return (DXFLineType) lineTypes.get(name);
    }

    /**
     * Gets the DXF line type iterator.
     *
     * @return the iterator over all DXFLineTypes
     */
    public Iterator getDXFLineTypeIterator() {
        return lineTypes.values().iterator();
    }

    /**
     * Adds the DXF entity.
     *
     * @param entity the entity
     */
    public void addDXFEntity(DXFEntity entity) {
        entity.setDXFDocument(this);

        DXFLayer layer = this.getDXFLayer(entity.getLayerName());
        layer.addDXFEntity(entity);
    }

    /**
     * Adds the DXF block.
     *
     * @param block the block
     */
    public void addDXFBlock(DXFBlock block) {
        block.setDXFDocument(this);
        this.blocks.put(block.getName(), block);
    }

    /**
     * Gets the DXF block.
     *
     * @param name the name
     * @return the DXF block
     */
    public DXFBlock getDXFBlock(String name) {
        return (DXFBlock) blocks.get(name);
    }

    /**
     * Gets the DXF block iterator.
     *
     * @return the iterator over all DXFBlocks
     */
    public Iterator getDXFBlockIterator() {
        return blocks.values().iterator();
    }

    /**
     * Sets the property.
     *
     * @param key the key
     * @param value the value
     */
    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        if (properties.contains(key)) {
            return (String) properties.get(key);
        }

        return null;
    }

    /**
     * Checks for property.
     *
     * @param key the key
     * @return true, if successful
     */
    public boolean hasProperty(String key) {
        return this.properties.containsKey(key);
    }

    /**
     * Returns the bounds of this document.
     *
     * @return the bounds
     */
    public Bounds getBounds() {
        this.bounds = new Bounds();

        Enumeration e = this.layers.elements();

        while (e.hasMoreElements()) {
            DXFLayer layer = (DXFLayer) e.nextElement();

            if (!layer.isFrozen()) {
                Bounds b = layer.getBounds();

                if (b.isValid()) {
                    this.bounds.addToBounds(b);
                }
            }
        }

        return bounds;
    }

    /**
     * Returns the bounds of this document.
     *
     * @param onModelspace the on modelspace
     * @return the bounds
     */
    public Bounds getBounds(boolean onModelspace) {
        Bounds bounds = new Bounds();

        Enumeration e = this.layers.elements();

        while (e.hasMoreElements()) {
            DXFLayer layer = (DXFLayer) e.nextElement();

            if (!layer.isFrozen()) {
                Bounds b = layer.getBounds(onModelspace);

                if (b.isValid()) {
                    bounds.addToBounds(b);
                }
            }
        }

        return bounds;
    }

    /**
     * Gets the height.
     *
     * @return the height
     * @deprecated use getBounds().getHeight() instead
     */
    public double getHeight() {
        return this.bounds.getHeight();
    }

    /**
     * Gets the width.
     *
     * @return the width
     * @deprecated use getBounds().getWidth() instead
     */
    public double getWidth() {
        return this.bounds.getWidth();
    }

    /**
     * Gets the DXF header.
     *
     * @return the DXF header
     */
    public DXFHeader getDXFHeader() {
        return this.header;
    }

    /**
     * Sets the DXF header.
     *
     * @param header the new DXF header
     */
    public void setDXFHeader(DXFHeader header) {
        this.header = header;
    }

    /**
     * Adds the DXF dimension style.
     *
     * @param style the style
     */
    public void addDXFDimensionStyle(DXFDimensionStyle style) {
        this.dimensionStyles.put(style.getName(), style);
    }

    /**
     * Gets the DXF dimension style.
     *
     * @param name the name
     * @return the DXF dimension style
     */
    public DXFDimensionStyle getDXFDimensionStyle(String name) {
        return (DXFDimensionStyle) this.dimensionStyles.get(name);
    }

    /**
     * Gets the DXF dimension style iterator.
     *
     * @return the DXF dimension style iterator
     */
    public Iterator getDXFDimensionStyleIterator() {
        return this.dimensionStyles.values().iterator();
    }

    /**
     * Adds the DX style.
     *
     * @param style the style
     */
    public void addDXStyle(DXFStyle style) {
        this.textStyles.put(style.getName(), style);
    }

    /**
     * Gets the DXF style.
     *
     * @param name the name
     * @return the DXF style
     */
    public DXFStyle getDXFStyle(String name) {
        return (DXFStyle) this.textStyles.get(name);
    }

    /**
     * Gets the DXF style iterator.
     *
     * @return the DXF style iterator
     */
    public Iterator getDXFStyleIterator() {
        return this.textStyles.values().iterator();
    }

    /**
     * Removes the DXF layer.
     *
     * @param id the id
     */
    public void removeDXFLayer(String id) {
        this.layers.remove(id);
    }

    /**
     * Adds the DXF viewport.
     *
     * @param viewport the viewport
     */
    public void addDXFViewport(DXFViewport viewport) {
        this.viewports.add(viewport);
    }

    /**
     * Gets the DXF viewport iterator.
     *
     * @return the DXF viewport iterator
     */
    public Iterator getDXFViewportIterator() {
        return this.viewports.iterator();
    }

    /**
     * Removes the DXF viewport.
     *
     * @param viewport the viewport
     */
    public void removeDXFViewport(DXFViewport viewport) {
        this.viewports.remove(viewport);
    }

    /**
     * Removes the DXF viewport.
     *
     * @param index the index
     */
    public void removeDXFViewport(int index) {
        this.viewports.remove(index);
    }

    /**
     * Adds the DXF view.
     *
     * @param view the view
     */
    public void addDXFView(DXFView view) {
        this.views.add(view);
    }

    /**
     * Gets the DXF view iterator.
     *
     * @return the DXF view iterator
     */
    public Iterator getDXFViewIterator() {
        return this.views.iterator();
    }

    /**
     * Adds the DXF object.
     *
     * @param obj the obj
     */
    public void addDXFObject(DXFObject obj) {
        // look if the object goes in a dictionary
        DXFDictionary d = this.rootDictionary.getDXFDictionaryForID(obj.getID());

        if (d != null) {
            d.putDXFObject(obj);
        } else {
            // is not bound to a dictionary
            HashMap type = null;

            if (this.objects.containsKey(obj.getObjectType())) {
                type = (HashMap) objects.get(obj.getObjectType());
            } else {
                type = new HashMap();
                this.objects.put(obj.getObjectType(), type);
            }

            type.put(obj.getID(), obj);
        }
    }

    /**
     * Returns the root dictionary.
     *
     * @return the root DXFDictionray
     */
    public DXFDictionary getRootDXFDictionary() {
        return this.rootDictionary;
    }

    /**
     * Sets the root DXF dictionary.
     *
     * @param root the new root DXF dictionary
     */
    public void setRootDXFDictionary(DXFDictionary root) {
        this.rootDictionary = root;
    }

    /**
     * Gets the DXF objects by type.
     *
     * @param type the type
     * @return the DXF objects by type
     */
    public List getDXFObjectsByType(String type) {
        HashMap objecttypes = (HashMap) this.objects.get(type);
        List list = new ArrayList(objecttypes.values());

        return list;
    }

    /**
     * Gets the DXF object by ID.
     *
     * @param id the id
     * @return the object
     */
    public DXFObject getDXFObjectByID(String id) {
        Iterator i = this.objects.values().iterator();

        while (i.hasNext()) {
            HashMap map = (HashMap) i.next();
            Object obj;

            if ((obj = map.get(id)) != null) {
                return (DXFObject) obj;
            }
        }

        // Nothing found --> search in the dictionaries
        return this.rootDictionary.getDXFObjectByID(id);
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
        Iterator i = this.getDXFLayerIterator();

        while (i.hasNext()) {
            DXFLayer layer = (DXFLayer) i.next();

            if ((entity = layer.getDXFEntityByID(id)) != null) {
                return entity;
            }
        }

        i = this.getDXFBlockIterator();

        while (i.hasNext()) {
            DXFBlock block = (DXFBlock) i.next();

            if ((entity = block.getDXFEntityByID(id)) != null) {
                return entity;
            }
        }

        return entity;
    }

    /**
     * Adds a DXFHatchPattern to the document.
     *
     * @param pattern the pattern
     */
    public void addDXFHatchPattern(DXFHatchPattern pattern) {
        this.patterns.put(pattern.getID(), pattern);
    }

    /**
     * Gets the DXF hatch pattern iterator.
     *
     * @return java.util.Iterator over all DXFHatchPattern of the document
     */
    public Iterator getDXFHatchPatternIterator() {
        return this.patterns.values().iterator();
    }

    /**
     * Gets the DXF hatch pattern.
     *
     * @param id the id
     * @return the DXFHatchPattern or null
     */
    public DXFHatchPattern getDXFHatchPattern(String id) {
        return (DXFHatchPattern) this.patterns.get(id);
    }
}
