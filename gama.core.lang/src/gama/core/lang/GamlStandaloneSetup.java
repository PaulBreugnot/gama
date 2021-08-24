/*******************************************************************************************************
 *
 * GamlStandaloneSetup.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/

package gama.core.lang;

import com.google.inject.Injector;

import msi.gama.lang.gaml.GamlStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without equinox extension registry.
 */
public class GamlStandaloneSetup extends GamlStandaloneSetupGenerated {

	/**
	 * Do setup.
	 *
	 * @return the injector
	 */
	public static Injector doSetup() {
		return new GamlStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
	}
}
