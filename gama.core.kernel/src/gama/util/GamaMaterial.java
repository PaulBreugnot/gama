/*******************************************************************************************************
 *
 * GamaMaterial.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util;

import java.util.Map;

import gama.common.interfaces.IKeyword;
import gama.common.interfaces.IValue;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.runtime.IScope;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class GamaMaterial.
 *
 * @author mazarsju
 */
@vars ({ @variable (
		name = IKeyword.DAMPER,
		type = IType.FLOAT,
		doc = { @doc ("Returns the shine damper component of the material") }),
		@variable (
				name = IKeyword.REFLECTIVITY,
				type = IType.FLOAT,
				doc = { @doc ("Returns the reflectivity of the material (between 0 and 1)") }) })
public class GamaMaterial implements IValue {

	/** The damper. */
	private final double damper;
	
	/** The reflectivity. */
	private final double reflectivity;

	/** The Constant materials. */
	public final static Map<String, GamaMaterial> materials = GamaMapFactory.createUnordered();

	static {
		final GamaMaterial steel = new NamedGamaMaterial("steelMaterial", 5, 1);
		materials.put("steelMaterial", steel);
		// int_materials.put(steel.getMatId(), steel);

		final GamaMaterial gum = new NamedGamaMaterial("gumMaterial", 1, 0);
		materials.put("gumMaterial", gum);
		// int_materials.put(gum.getMatId(), gum);
	}

	// /** The steel material. */
	// @constant(value = "steelMaterial", category = { }, concept = { }, doc = {
	// @doc("TODO") })
	// public final static GamaMaterial steelMaterial = new GamaMaterial(5,1);
	// /** The gum material. */
	// @constant(value = "gumMaterial", category = { }, concept = { }, doc = {
	// @doc("TODO") })
	// public final static GamaMaterial gumMaterial = new GamaMaterial(1,0);

	/**
	 * The Class NamedGamaMaterial.
	 */
	public static class NamedGamaMaterial extends GamaMaterial {

		/** The name. */
		final String name;

		/**
		 * Instantiates a new named gama material.
		 *
		 * @param n the n
		 * @param damper the damper
		 * @param reflectivity the reflectivity
		 */
		NamedGamaMaterial(final String n, final float damper, final float reflectivity) {
			// c must be of length 4.
			super(damper, reflectivity);
			name = n;
		}

		@Override
		public String toString() {
			return "material[" + name + "]";
		}

		@Override
		public String serialize(final boolean includingBuiltIn) {
			return "°" + name;
		}

		@Override
		public String stringValue(final IScope scope) {
			return name;
		}

	}

	/**
	 * Instantiates a new gama material.
	 *
	 * @param damper2 the damper 2
	 * @param reflectivity2 the reflectivity 2
	 */
	public GamaMaterial(final double damper2, final double reflectivity2) {
		this.damper = damper2;
		this.reflectivity = reflectivity2;
	}

	/**
	 * Instantiates a new gama material.
	 *
	 * @param material the material
	 */
	public GamaMaterial(final GamaMaterial material) {
		this.damper = material.getDamper();
		this.reflectivity = material.getReflectivity();
	}

	/**
	 * Gets the damper.
	 *
	 * @return the damper
	 */
	public double getDamper() {
		return damper;
	}

	/**
	 * Gets the reflectivity.
	 *
	 * @return the reflectivity
	 */
	public double getReflectivity() {
		return reflectivity;
	}

	@Override
	public String toString() {
		return serialize(true);
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return "material (" + getDamper() + ", " + getReflectivity() + ")";
	}

	@Override
	public String stringValue(final IScope scope) {
		return "material (damper value : " + getDamper() + ", reflectivity value : " + getReflectivity() + ")";
	}

	/**
	 * Reflectivity.
	 *
	 * @return the double
	 */
	@getter (IKeyword.REFLECTIVITY)
	public Double reflectivity() {
		return reflectivity;
	}

	/**
	 * Damper.
	 *
	 * @return the double
	 */
	@getter (IKeyword.DAMPER)
	public Double damper() {
		return damper;
	}

	@Override
	public GamaMaterial copy(final IScope scope) {
		return new GamaMaterial(this);
	}

	/**
	 * Method getType()
	 *
	 * @see gama.common.interfaces.ITyped#getGamlType()
	 */
	@Override
	public IType<?> getGamlType() {
		return Types.MATERIAL;
	}

}
