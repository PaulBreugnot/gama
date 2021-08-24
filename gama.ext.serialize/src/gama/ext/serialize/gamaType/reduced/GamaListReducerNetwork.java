/*******************************************************************************************************
 *
 * GamaListReducerNetwork.java, in gama.ext.serialize, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.runtime.IScope;
import gama.util.GamaListFactory;
import gama.util.IList;
import gaml.types.Types;

/**
 * The Class GamaListReducerNetwork.
 */
@SuppressWarnings ({ "rawtypes" })
public class GamaListReducerNetwork extends GamaListReducer {

	/**
	 * Instantiates a new gama list reducer network.
	 *
	 * @param l the l
	 */
	public GamaListReducerNetwork(final IList l) {
		super(l);
	}

	@Override
	public IList constructObject(final IScope scope) {
		// System.out.println("read "+contentTypeListReducer+ " "+valuesListReducer );
		// scope.getAgent().getPopulationFor(speciesName)
		// (microSpeciesName)getMicroSpecies(contentTypeListReducer);
		return GamaListFactory.create(scope, Types.NO_TYPE, this.getValuesListReducer());
	}
}
