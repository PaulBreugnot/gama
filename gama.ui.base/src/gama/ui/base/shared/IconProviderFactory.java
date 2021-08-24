/*******************************************************************************************************
 *
 * IconProviderFactory.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.shared;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.ui.base.interfaces.IIconProvider;
import gama.ui.base.resources.GamaIcons;

/**
 * A factory for creating IconProvider objects.
 */
public class IconProviderFactory extends AbstractServiceFactory {

	/**
	 * Instantiates a new icon provider factory.
	 */
	public IconProviderFactory() {}

	@Override
	public IIconProvider create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return GamaIcons.getInstance();
	}

}
