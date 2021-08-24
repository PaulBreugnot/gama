/*******************************************************************************************************
 *
 * MergeMap.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.kabeja.processing.helper;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 * The Class MergeMap.
 */
public class MergeMap implements Map {
    
    /** The base. */
    private Map base;
    
    /** The override. */
    private Map override;

    /**
     * Instantiates a new merge map.
     *
     * @param base the base
     * @param override the override
     */
    public MergeMap(Map base, Map override) {
        this.base = base;
        this.override = override;
    }

    public void clear() {
    }

    public boolean containsKey(Object key) {
        if (this.override.containsKey(key)) {
            return true;
        } else {
            return this.base.containsKey(key);
        }
    }

    public boolean containsValue(Object value) {
        if (this.override.containsValue(value)) {
            return true;
        } else {
            return this.base.containsValue(value);
        }
    }

    public Set entrySet() {
        return null;
    }

    public Object get(Object key) {
        Object obj = this.override.get(key);

        if (obj == null) {
            obj = this.base.get(key);
        }

        return obj;
    }

    public boolean isEmpty() {
        if (this.override.isEmpty()) {
            return true;
        } else {
            return this.base.isEmpty();
        }
    }

    public Set keySet() {
        return null;
    }

    public Object put(Object arg0, Object arg1) {
        return null;
    }

    public void putAll(Map arg0) {
    }

    public Object remove(Object key) {
        return null;
    }

    public int size() {
        return this.base.size();
    }

    public Collection values() {
        return null;
    }
}
