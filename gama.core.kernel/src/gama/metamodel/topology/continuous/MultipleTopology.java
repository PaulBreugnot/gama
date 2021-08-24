/*******************************************************************************************************
 *
 * MultipleTopology.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.metamodel.topology.continuous;

import gama.common.interfaces.IKeyword;
import gama.metamodel.shape.IShape;
import gama.metamodel.topology.ITopology;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.IContainer;
import gaml.types.GamaGeometryType;

/**
 * The class GamaMultipleTopology.
 * 
 * @author drogoul
 * @since 30 nov. 2011
 * 
 */
public class MultipleTopology extends ContinuousTopology {

	/**
	 * Instantiates a new multiple topology.
	 *
	 * @param scope the scope
	 * @param places the places
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	public MultipleTopology(final IScope scope, final IContainer<?, IShape> places) throws GamaRuntimeException {
		// For the moment, use the geometric envelope in order to simplify the "environment".
		super(scope, GamaGeometryType.geometriesToGeometry(scope, places).getGeometricEnvelope());
		this.places = places;
	}

	@Override
	protected boolean canCreateAgents() {
		return true;
	}

	/**
	 * @see msi.gama.interfaces.IValue#stringValue()
	 */
	@Override
	public String stringValue(final IScope scope) throws GamaRuntimeException {
		return "Multiple topology in " + environment.toString();
	}

	/**
	 * @see msi.gama.environment.AbstractTopology#_toGaml()
	 */
	@Override
	protected String _toGaml(final boolean includingBuiltIn) {
		return IKeyword.TOPOLOGY + "(" + places.serialize(includingBuiltIn) + ")";
	}

	/**
	 * @see msi.gama.environment.AbstractTopology#_copy()
	 */
	@Override
	protected ITopology _copy(final IScope scope) {
		return new MultipleTopology(scope, places/* , isTorus */);
	}

}
