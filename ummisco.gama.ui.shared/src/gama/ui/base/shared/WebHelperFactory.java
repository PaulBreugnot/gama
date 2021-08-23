package gama.ui.base.shared;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.ui.base.interfaces.IWebHelper;
import gama.ui.base.utils.WebHelper;

public class WebHelperFactory extends AbstractServiceFactory {

	@Override
	public IWebHelper create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return WebHelper.getInstance();
	}

}
