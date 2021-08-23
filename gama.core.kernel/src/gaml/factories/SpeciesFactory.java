/*******************************************************************************************************
 *
 * msi.gaml.factories.SpeciesFactory.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.factories;

import static gama.core.dev.annotations.ISymbolKind.SPECIES;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import gama.core.dev.annotations.GamlAnnotations.factory;
import gaml.compilation.IAgentConstructor;
import gaml.descriptions.IDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.descriptions.SymbolProto;
import gaml.descriptions.TypeDescription;
import gaml.statements.Facets;

/**
 * SpeciesFactory.
 *
 * @author drogoul 25 oct. 07
 */

@factory (
		handles = { SPECIES })
@SuppressWarnings ({ "rawtypes" })
public class SpeciesFactory extends SymbolFactory {

	public SpeciesFactory(final int... handles) {
		super(handles);
	}

	@Override
	protected TypeDescription buildDescription(final String keyword, final Facets facets, final EObject element,
			final Iterable<IDescription> children, final IDescription sd, final SymbolProto proto) {
		return new SpeciesDescription(keyword, null, (SpeciesDescription) sd, null, children, element, facets);
	}

	public SpeciesDescription createBuiltInSpeciesDescription(final String name, final Class clazz,
			final SpeciesDescription superDesc, final SpeciesDescription parent, final IAgentConstructor helper,
			final Set<String> skills, final Facets userSkills, final String plugin) {
		DescriptionFactory.addSpeciesNameAsType(name);
		return new SpeciesDescription(name, clazz, superDesc, parent, helper, skills, userSkills, plugin);
	}

}
