/*******************************************************************************************************
 *
 * GamaAgentType.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.types;

import gama.metamodel.agent.IAgent;
import gama.metamodel.shape.GamaPoint;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.SpeciesDescription;
import gaml.species.ISpecies;

// TODO: Auto-generated Javadoc
/**
 * The type used to represent an agent of a species. Should be used by the species for all the operations relative to
 * casting, etc.
 *
 * Written by drogoul Modified on 1 ao�t 2010
 *
 * @todo Description
 *
 */
@SuppressWarnings ("unchecked")
public class GamaAgentType extends GamaType<IAgent> {

	/** The species. */
	SpeciesDescription species;

	/**
	 * Instantiates a new gama agent type.
	 *
	 * @param species
	 *            the species
	 * @param name
	 *            the name
	 * @param speciesId
	 *            the species id
	 * @param base
	 *            the base
	 */
	public GamaAgentType(final SpeciesDescription species, final String name, final int speciesId,
			final Class<IAgent> base) {
		this.species = species;
		this.name = name;
		id = speciesId;
		support = base;
		// supports = new Class[] { base };
		if (species != null) { setDefiningPlugin(species.getDefiningPlugin()); }
	}

	/**
	 * Checks if is assignable from.
	 *
	 * @param t the t
	 * @return true, if is assignable from
	 */
	@Override
	public boolean isAssignableFrom(final IType<?> t) {
		final boolean assignable = super.isAssignableFrom(t);
		// Hack to circumvent issue #1999. Should be better handled by
		// letting type managers of comodels inherit from the type managers
		// of imported models.
		if (!assignable && t.isAgentType() && t.getSpecies() == getSpecies()) return true;
		return assignable;
	}

	/**
	 * Gets the defining plugin.
	 *
	 * @return the defining plugin
	 */
	@Override
	public String getDefiningPlugin() { return species.getDefiningPlugin(); }

	/**
	 * Cast.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @param param the param
	 * @param copy the copy
	 * @return the i agent
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public IAgent cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj == null || scope == null || scope.getModel() == null) return null;
		ISpecies species = (ISpecies) param;
		if (species == null) { species = scope.getModel().getSpecies(this.species.getName()); }
		if (species == null) return (IAgent) Types.AGENT.cast(scope, obj, param, copy);
		if (obj instanceof IAgent) return ((IAgent) obj).isInstanceOf(species, false) ? (IAgent) obj : null;
		if (obj instanceof Integer) return scope.getAgent().getPopulationFor(species).getAgent((Integer) obj);
		if (obj instanceof GamaPoint)
			return scope.getAgent().getPopulationFor(species).getAgent(scope, (GamaPoint) obj);
		return null;
	}

	/**
	 * Gets the default.
	 *
	 * @return the default
	 */
	@Override
	public IAgent getDefault() { return null; }

	/**
	 * Checks if is agent type.
	 *
	 * @return true, if is agent type
	 */
	@Override
	public boolean isAgentType() { return true; }

	/**
	 * Gets the species name.
	 *
	 * @return the species name
	 */
	@Override
	public String getSpeciesName() { return name; }

	/**
	 * Gets the species.
	 *
	 * @return the species
	 */
	@Override
	public SpeciesDescription getSpecies() { return species; }

	/**
	 * Can cast to const.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean canCastToConst() {
		return false;
	}

	/**
	 * Can be type of.
	 *
	 * @param scope the scope
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean canBeTypeOf(final IScope scope, final Object obj) {
		final boolean b = super.canBeTypeOf(scope, obj);
		if (b) return true;
		if (obj instanceof IAgent) {
			final ISpecies s = scope.getModel().getSpecies(getSpeciesName());
			return ((IAgent) obj).isInstanceOf(s, false);
		}
		return false;
	}

	/**
	 * Gets the support name.
	 *
	 * @return the support name
	 */
	@Override
	public String getSupportName() { return ", type of agents instances of species " + species.getName(); }

	/**
	 * Gets the key type.
	 *
	 * @return the key type
	 */
	@Override
	public IType<String> getKeyType() { return Types.STRING; }

	/**
	 * Checks if is fixed length.
	 *
	 * @return true, if is fixed length
	 */
	@Override
	public boolean isFixedLength() { return false; }

	/**
	 * Checks if is drawable.
	 *
	 * @return true, if is drawable
	 */
	@Override
	public boolean isDrawable() { return true; }

}
