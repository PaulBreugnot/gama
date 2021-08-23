package gama.ui.base.shared;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.ui.base.interfaces.IIconProvider;
import gama.ui.base.resources.GamaIcons;

public class IconProviderFactory extends AbstractServiceFactory {

	public IconProviderFactory() {}

	@Override
	public IIconProvider create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return GamaIcons.getInstance();
	}

}
