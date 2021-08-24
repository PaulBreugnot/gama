/*******************************************************************************************************
 *
 * AbstractModelLibraryRunner.java, in gama.core.headless, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.headless.batch;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.google.inject.Injector;

import gama.core.lang.validation.GamlModelBuilder;

/**
 * The Class AbstractModelLibraryRunner.
 */
public abstract class AbstractModelLibraryRunner {

	/**
	 * Creates the builder.
	 *
	 * @param injector the injector
	 * @return the gaml model builder
	 */
	protected GamlModelBuilder createBuilder(final Injector injector) {
		final GamlModelBuilder builder = new GamlModelBuilder(injector);
		return builder;
	}

	/**
	 * Checks if is model.
	 *
	 * @param url the url
	 * @return true, if is model
	 */
	protected boolean isModel(final URL url) {
		final String file = url.getFile();
		return file.endsWith(".gaml") || file.endsWith(".experiment");
	}

	/**
	 * Checks if is test.
	 *
	 * @param url the url
	 * @return true, if is test
	 */
	protected boolean isTest(final URL url) {
		return isModel(url) && url.toString().contains("tests");
	}

	/**
	 * Start.
	 *
	 * @param args the args
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public abstract int start(List<String> args) throws IOException;
}
