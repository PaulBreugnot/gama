/*********************************************************************************************
 *
 * 'GamaListReducer.java, in plugin ummisco.gama.serialize, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ext.serialize.gamaType.reduced;

import gama.runtime.IScope;
import gama.util.GamaListFactory;
import gama.util.IList;
import gaml.types.Types;

@SuppressWarnings ({ "rawtypes" })
public class GamaListReducerNetwork extends GamaListReducer {

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
