/*******************************************************************************************************
 *
 * GamaPairReducer.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.ext.serialize.gamaType.reference.ReferencePair;
import gama.kernel.simulation.SimulationAgent;
import gama.util.GamaPair;
import gama.util.IReference;
import gaml.types.IType;

/**
 * The Class GamaPairReducer.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class GamaPairReducer {
	
	/** The key pair type. */
	private final IType keyPairType;
	
	/** The data pair type. */
	private final IType dataPairType;
	
	/** The key. */
	private Object key;
	
	/** The value. */
	private Object value;

	/**
	 * Instantiates a new gama pair reducer.
	 *
	 * @param m the m
	 */
	public GamaPairReducer(final GamaPair m) {
		keyPairType = m.getGamlType().getKeyType();
		dataPairType = m.getGamlType().getContentType();
		key = m.getKey();
		value = m.getValue();
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Gets the key type.
	 *
	 * @return the key type
	 */
	public IType getKeyType() {
		return keyPairType;
	}

	/**
	 * Gets the value type.
	 *
	 * @return the value type
	 */
	public IType getValueType() {
		return dataPairType;
	}

	/**
	 * Sets the key.
	 *
	 * @param k the new key
	 */
	public void setKey(final Object k) {
		key = k;
	}

	/**
	 * Sets the value.
	 *
	 * @param v the new value
	 */
	public void setValue(final Object v) {
		value = v;
	}

	/**
	 * Construct object.
	 *
	 * @return the gama pair
	 */
	public GamaPair constructObject() {
		final boolean isReference = IReference.isReference(key) || IReference.isReference(value);

		return isReference ? new ReferencePair(this) : new GamaPair(key, value, keyPairType, dataPairType);

		// return new GamaPair(key, value, keyPairType, dataPairType);
	}

	/**
	 * Unreference reducer.
	 *
	 * @param sim the sim
	 */
	public void unreferenceReducer(final SimulationAgent sim) {
		key = IReference.getObjectWithoutReference(key, sim);
		value = IReference.getObjectWithoutReference(value, sim);
	}
}
