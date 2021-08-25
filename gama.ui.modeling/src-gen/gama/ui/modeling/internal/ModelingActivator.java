/*******************************************************************************************************
 *
 * ModelingActivator.java, in gama.ui.modeling, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.modeling.internal;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

import gama.core.lang.GamlRuntimeModule;
import gama.core.lang.ui.GamlUiModule;
import gama.ui.modeling.ActivatorHelper;

/**
 * This class was generated. Customizations should only happen in a newly introduced subclass.
 */
public class ModelingActivator extends AbstractUIPlugin {

	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "gama.ui.modeling";

	/** The Constant GAMA_CORE_LANG_GAML. */
	public static final String GAMA_CORE_LANG_GAML = "gama.core.lang.Gaml";

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ModelingActivator.class);

	/** The instance. */
	private static ModelingActivator INSTANCE;

	/** The injectors. */
	private final Map<String, Injector> injectors =
			Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		ActivatorHelper.initializeOnActivation();
		INSTANCE = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}

	/**
	 * Gets the single instance of ModelingActivator.
	 *
	 * @return single instance of ModelingActivator
	 */
	public static ModelingActivator getInstance() {
		return INSTANCE;
	}

	/**
	 * Gets the injector.
	 *
	 * @param language
	 *            the language
	 * @return the injector
	 */
	public Injector getInjector(final String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) { injectors.put(language, injector = createInjector(language)); }
			return injector;
		}
	}

	/**
	 * Creates the injector.
	 *
	 * @param language
	 *            the language
	 * @return the injector
	 */
	protected Injector createInjector(final String language) {
		try {
			com.google.inject.Module runtimeModule = getRuntimeModule(language);
			com.google.inject.Module sharedStateModule = getSharedStateModule();
			com.google.inject.Module uiModule = getUiModule(language);
			com.google.inject.Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}

	/**
	 * Gets the runtime module.
	 *
	 * @param grammar
	 *            the grammar
	 * @return the runtime module
	 */
	protected com.google.inject.Module getRuntimeModule(final String grammar) {
		if (GAMA_CORE_LANG_GAML.equals(grammar)) return new GamlRuntimeModule();
		throw new IllegalArgumentException(grammar);
	}

	/**
	 * Gets the ui module.
	 *
	 * @param grammar
	 *            the grammar
	 * @return the ui module
	 */
	protected com.google.inject.Module getUiModule(final String grammar) {
		if (GAMA_CORE_LANG_GAML.equals(grammar)) return new GamlUiModule(this);
		throw new IllegalArgumentException(grammar);
	}

	/**
	 * Gets the shared state module.
	 *
	 * @return the shared state module
	 */
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}

}
