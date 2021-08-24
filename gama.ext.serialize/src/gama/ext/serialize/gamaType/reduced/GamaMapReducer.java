/*******************************************************************************************************
 *
 * GamaMapReducer.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import gama.ext.serialize.gamaType.reference.ReferenceMap;
import gama.kernel.simulation.SimulationAgent;
import gama.runtime.IScope;
import gama.util.GamaMapFactory;
import gama.util.IMap;
import gama.util.IReference;
import gaml.types.IType;

/**
 * The Class GamaMapReducer.
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class GamaMapReducer {
	
	/** The keys type. */
	private final IType keysType;
	
	/** The data type. */
	private final IType dataType;
	
	/** The values map reducer. */
	// private ArrayList<GamaPair> values = new ArrayList<GamaPair>();
	private Map<Object, Object> valuesMapReducer = new HashMap();

	/**
	 * Instantiates a new gama map reducer.
	 *
	 * @param m the m
	 */
	public GamaMapReducer(final IMap m) {
		keysType = m.getGamlType().getKeyType();
		dataType = m.getGamlType().getContentType();
		m.forEach((k, v) -> valuesMapReducer.put(k, v));
	}

	/**
	 * Construct object.
	 *
	 * @param scope the scope
	 * @return the i map
	 */
	public IMap constructObject(final IScope scope) {

		boolean isReference = false;
		final Iterator ite = valuesMapReducer.entrySet().iterator();
		while (!isReference && ite.hasNext()) {
			final Entry e = (Entry) ite.next();
			isReference = IReference.isReference(e.getKey()) || IReference.isReference(e.getValue());
		}

		return isReference ? new ReferenceMap(this)
				: GamaMapFactory.create(scope, keysType, dataType, valuesMapReducer);

	}

	/**
	 * Unreference reducer.
	 *
	 * @param sim the sim
	 */
	public void unreferenceReducer(final SimulationAgent sim) {

		final HashMap<Object, Object> mapWithoutReferences = new HashMap<>();

		for (final Entry e : valuesMapReducer.entrySet()) {
			mapWithoutReferences.put(IReference.getObjectWithoutReference(e.getKey(), sim),
					IReference.getObjectWithoutReference(e.getValue(), sim));
		}

		valuesMapReducer = mapWithoutReferences;
	}

	/**
	 * Gets the keys type.
	 *
	 * @return the keys type
	 */
	public IType getKeysType() {
		return keysType;
	}

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	public IType getDataType() {
		return dataType;
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	public Map<Object, Object> getValues() {
		return valuesMapReducer;
	}

	/**
	 * Sets the values.
	 *
	 * @param m the new values
	 */
	public void setValues(final HashMap m) {
		valuesMapReducer = m;
	}
}
