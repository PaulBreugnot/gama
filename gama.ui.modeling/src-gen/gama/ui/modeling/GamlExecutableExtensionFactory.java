/*******************************************************************************************************
 *
 * GamlExecutableExtensionFactory.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import ummisco.gama.ui.modeling.internal.ModelingActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class GamlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(ModelingActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		ModelingActivator activator = ModelingActivator.getInstance();
		return activator != null ? activator.getInjector(ModelingActivator.MSI_GAMA_LANG_GAML_GAML) : null;
	}

}
