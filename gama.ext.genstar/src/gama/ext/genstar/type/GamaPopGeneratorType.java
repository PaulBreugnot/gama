/*
 *
 */
package gama.ext.genstar.type;

import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.runtime.IScope;
import gaml.types.GamaType;

// TODO: Auto-generated Javadoc
/**
 * The Class GamaPopGeneratorType.
 */
@type (
		name = "gen_population_generator",
		id = 938373948,
		wraps = { GamaPopGenerator.class },
		kind = ISymbolKind.Variable.REGULAR,
		concept = { IConcept.TYPE },
		doc = { @doc ("Represents a population generator that can be used to create agents") })
public class GamaPopGeneratorType extends GamaType<GamaPopGenerator> {

	/**
	 * Can cast to const.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean canCastToConst() {
		return true;
	}

	/**
	 * Inits the.
	 */
	public void init() {
		this.init(104, 938373948, "population_generator", GamaPopGenerator.class);
	}

	/**
	 * Cast.
	 *
	 * @param scope
	 *            the scope
	 * @param obj
	 *            the obj
	 * @param param
	 *            the param
	 * @param copy
	 *            the copy
	 * @return the gama pop generator
	 */
	@Override
	@doc ("Cast any gaml variable into a GamaPopGenerator used in generation process")
	public GamaPopGenerator cast(final IScope scope, final Object obj, final Object param, final boolean copy) {
		if (obj instanceof GamaPopGenerator) return (GamaPopGenerator) obj;
		return new GamaPopGenerator();
	}

	/**
	 * Gets the default.
	 *
	 * @return the default
	 */
	@Override
	public GamaPopGenerator getDefault() { return null; }

}