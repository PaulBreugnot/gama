/*********************************************************************************************
 *
 * 'MetaDataServiceFactory.java, in plugin ummisco.gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ui.navigator;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.ui.navigator.metadata.FileMetaDataProvider;
import gama.util.file.IFileMetaDataProvider;

public class MetaDataServiceFactory extends AbstractServiceFactory {

	public MetaDataServiceFactory() {
	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		if (IFileMetaDataProvider.class.equals(serviceInterface))
			return FileMetaDataProvider.getInstance();
		return null;
	}

}
