/*******************************************************************************************************
 *
 * DXFStreamLayerFilter.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.parser.dxf.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import gama.ext.libs.kabeja.parser.DXFValue;
import gama.ext.libs.kabeja.parser.ParseException;


/**
 * The Class DXFStreamLayerFilter.
 */
public class DXFStreamLayerFilter extends DXFStreamEntityFilter {
    
    /** The Constant PROPERTY_LAYERS_EXCLUDE. */
    public final static String PROPERTY_LAYERS_EXCLUDE = "layers.exclude";
    
    /** The Constant PROPERTY_LAYERS_INCLUDE. */
    public final static String PROPERTY_LAYERS_INCLUDE = "layers.include";
    
    /** The Constant LAYER_NAME. */
    public final static int LAYER_NAME = 8;
    
    /** The parse values. */
    protected List parseValues = new ArrayList();
    
    /** The exclude. */
    protected Set exclude = new HashSet();
    
    /** The include. */
    protected Set include = new HashSet();
    
    /** The layer. */
    protected String layer = "";
    
    /** The find layer. */
    boolean findLayer = true;

    public void setProperties(Map properties) {
        if (properties.containsKey(PROPERTY_LAYERS_INCLUDE)) {
            this.include.clear();

            StringTokenizer st = new StringTokenizer((String) properties.get(
                        PROPERTY_LAYERS_INCLUDE), "|");

            while (st.hasMoreTokens()) {
                String layer = st.nextToken();

                this.include.add(layer);
            }
        }

        if (properties.containsKey(PROPERTY_LAYERS_EXCLUDE)) {
            this.exclude.clear();

            StringTokenizer st = new StringTokenizer((String) properties.get(
                        PROPERTY_LAYERS_EXCLUDE), "|");

            while (st.hasMoreTokens()) {
                this.exclude.add(st.nextToken());
            }
        }
    }

    protected void endEntity() throws ParseException {
        if (include.contains(this.layer)) {
            this.outputEntity();
        } else if (!exclude.contains(this.layer)) {
            this.outputEntity();
        }
    }

    /**
     * Output entity.
     *
     * @throws ParseException the parse exception
     */
    protected void outputEntity() throws ParseException {
        // give the complete entity to the next handler
        for (int i = 0; i < this.parseValues.size(); i++) {
            ParseValue v = (ParseValue) this.parseValues.get(i);
            this.handler.parseGroup(v.getGroupCode(), v.getDXFValue());
        }
    }

    protected void startEntity(String type) throws ParseException {
        this.parseValues.clear();
        this.findLayer = true;
    }

    protected void parseEntity(int groupCode, DXFValue value)
        throws ParseException {
        if (this.findLayer && (groupCode == LAYER_NAME)) {
            this.layer = value.getValue();
            this.findLayer = false;
        }

        //parse values to buffer
        ParseValue v = new ParseValue(groupCode, value);
        this.parseValues.add(v);
    }

    /**
     * The Class ParseValue.
     */
    private class ParseValue {
        
        /** The group code. */
        int groupCode;
        
        /** The value. */
        DXFValue value;

        /**
         * Instantiates a new parses the value.
         *
         * @param groupCode the group code
         * @param value the value
         */
        public ParseValue(int groupCode, DXFValue value) {
            this.groupCode = groupCode;
            this.value = value;
        }

        /**
         * Gets the group code.
         *
         * @return the group code
         */
        public int getGroupCode() {
            return this.groupCode;
        }

        /**
         * Gets the DXF value.
         *
         * @return the DXF value
         */
        public DXFValue getDXFValue() {
            return this.value;
        }
    }
}
