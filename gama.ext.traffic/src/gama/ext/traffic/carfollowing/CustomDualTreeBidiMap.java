/*******************************************************************************************************
 *
 * CustomDualTreeBidiMap.java, in gama.ext.traffic, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.traffic.carfollowing;

import java.util.Comparator;
import java.util.Map;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * The Class CustomDualTreeBidiMap.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class CustomDualTreeBidiMap<K, V> extends DualTreeBidiMap<K, V> {
	
	/**
	 * Instantiates a new custom dual tree bidi map.
	 *
	 * @param normalMap the normal map
	 * @param reverseMap the reverse map
	 * @param inverseBidiMap the inverse bidi map
	 */
	protected CustomDualTreeBidiMap(Map<K, V> normalMap, Map<V, K> reverseMap, BidiMap<V, K> inverseBidiMap) {
        super(normalMap, reverseMap, inverseBidiMap);
    }

    /**
     * Instantiates a new custom dual tree bidi map.
     *
     * @param keyComparator the key comparator
     * @param valueComparator the value comparator
     */
    public CustomDualTreeBidiMap(Comparator<? super K> keyComparator, Comparator<? super V> valueComparator) {
        super(keyComparator, valueComparator);
    }

    protected CustomDualTreeBidiMap<V, K> createBidiMap(Map<V, K> normalMap, Map<K, V> reverseMap, BidiMap<K, V> inverseMap) {
        return new CustomDualTreeBidiMap(normalMap, reverseMap, inverseMap);
    }

    /**
     * The original method in DualTreeBidiMap does not work correctly when
     * the key is not present in the map.
     */
    @Override
    public K nextKey(K key) {
        if (containsKey(key) || size() == 0) {
            return super.nextKey(key);
        } else {
            K last = lastKey();
            if (comparator().compare(key, last) > 0) {
                return null;
            } else {
                K next = super.nextKey(key);
                return next == null ? last : previousKey(next);
            }
        }
    }
}
