/*******************************************************************************************************
 *
 * msi.gaml.factories.PlatformFactory.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.factories;

import static gama.core.dev.annotations.ISymbolKind.PLATFORM;

import java.util.Set;

import gama.core.dev.annotations.GamlAnnotations.factory;
import gaml.compilation.IAgentConstructor;
import gaml.descriptions.PlatformSpeciesDescription;
import gaml.descriptions.SpeciesDescription;
import gaml.statements.Facets;

@factory (
		handles = { PLATFORM })
public class PlatformFactory extends SpeciesFactory {

	public PlatformFactory(final int... handles) {
		super(handles);
	}

	@Override
	public SpeciesDescription createBuiltInSpeciesDescription(final String name, final Class clazz,
			final SpeciesDescription superDesc, final SpeciesDescription parent, final IAgentConstructor helper,
			final Set<String> skills, final Facets userSkills, final String plugin) {
		DescriptionFactory.addSpeciesNameAsType(name);
		return new PlatformSpeciesDescription(name, clazz, superDesc, parent, helper, skills, userSkills, plugin);
	}

}
