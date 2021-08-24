/*******************************************************************************************************
 *
 * DXFVariable.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.dxf;

import java.util.Hashtable;
import java.util.Iterator;


/**
 * The Class DXFVariable.
 *
 * @author <a href="mailto:simon.mieth@gmx.de>Simon Mieth</a>
 */
public class DXFVariable {
    
    /** The values. */
    private Hashtable values = new Hashtable();
    
    /** The name. */
    private String name = "";

    /**
     * Instantiates a new DXF variable.
     *
     * @param name the name
     */
    public DXFVariable(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value.
     *
     * @param name the name
     * @return the value
     */
    public String getValue(String name) {
        return (String) values.get(name);
    }

    /**
     * Gets the integer value.
     *
     * @param name the name
     * @return the integer value
     */
    public int getIntegerValue(String name) {
        return Integer.parseInt((String) values.get(name));
    }

    /**
     * Gets the double value.
     *
     * @param name the name
     * @return the double value
     */
    public double getDoubleValue(String name) {
        return Double.parseDouble((String) values.get(name));
    }

    /**
     * Sets the value.
     *
     * @param name the name
     * @param value the value
     */
    public void setValue(String name, String value) {
        values.put(name, value);
    }

    /**
     * Gets the value key iterator.
     *
     * @return a iterator over all keys of this DXFValue
     */
    public Iterator getValueKeyIterator() {
        return values.keySet().iterator();
    }
}
