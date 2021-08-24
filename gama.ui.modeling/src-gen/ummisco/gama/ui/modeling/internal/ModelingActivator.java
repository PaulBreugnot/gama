/*******************************************************************************************************
 *
 * ModelingActivator.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package ummisco.gama.ui.modeling.internal;

import static org.eclipse.jface.preference.PreferenceConverter.setValue;
import static org.eclipse.jface.resource.JFaceResources.TEXT_FONT;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;

import gama.common.preferences.GamaPreferences;
import gama.core.dev.utils.DEBUG;
import gama.core.lang.GamlRuntimeModule;
import gama.ui.base.utils.GamlReferenceSearch;
import gama.ui.modeling.GamlUiModule;
import gama.ui.modeling.editor.GamlEditorBindings;
import gama.ui.modeling.reference.OperatorsReferenceMenu;
import gama.util.GamaColor;
import gama.util.GamaFont;

/**
 * This class was generated. Customizations should only happen in a newly introduced subclass.
 */
public class ModelingActivator extends AbstractUIPlugin {

	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "gama.ui.modeling";
	
	/** The Constant MSI_GAMA_LANG_GAML_GAML. */
	public static final String MSI_GAMA_LANG_GAML_GAML = "msi.gama.lang.gaml.Gaml";

	/** The instance. */
	private static ModelingActivator INSTANCE;

	/** The injectors. */
	private final Map<String, Injector> injectors =
			Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
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
	 * @param language the language
	 * @return the injector
	 */
	public Injector getInjector(final String language) {
		// synchronized (injectors) {
		Injector injector = injectors.get(language);
		if (injector == null) { injectors.put(language, injector = createInjector(language)); }
		return injector;
		// }
	}

	/**
	 * Creates the injector.
	 *
	 * @param language the language
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
			DEBUG.OUT("Failed to create injector for " + language);
			DEBUG.OUT(e.getMessage());
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}

	/**
	 * Gets the runtime module.
	 *
	 * @param grammar the grammar
	 * @return the runtime module
	 */
	protected com.google.inject.Module getRuntimeModule(final String grammar) {
		if (MSI_GAMA_LANG_GAML_GAML.equals(grammar)) return new GamlRuntimeModule();
		throw new IllegalArgumentException(grammar);
	}

	/**
	 * Gets the ui module.
	 *
	 * @param grammar the grammar
	 * @return the ui module
	 */
	protected com.google.inject.Module getUiModule(final String grammar) {
		if (MSI_GAMA_LANG_GAML_GAML.equals(grammar)) return new GamlUiModule(this);
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

	// ==== ADDITION BEYOND THIS POINT

	/**
	 * Gets the default background.
	 *
	 * @return the default background
	 */
	private static GamaColor getDefaultBackground() {
		EditorsPlugin.getDefault().getPreferenceStore()
				.setValue(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT, false);
		final RGB rgb = PreferenceConverter.getColor(EditorsPlugin.getDefault().getPreferenceStore(),
				AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND);
		return new GamaColor(rgb.red, rgb.green, rgb.blue);
	}

	/**
	 * Gets the default font data.
	 *
	 * @return the default font data
	 */
	public static GamaFont getDefaultFontData() {
		final FontData fd = PreferenceConverter.getFontData(EditorsPlugin.getDefault().getPreferenceStore(), TEXT_FONT);
		return new GamaFont(fd.getName(), fd.getStyle(), fd.getHeight());
	}

	/**
	 * Initialize.
	 */
	public void initialize() {
		GamaPreferences.Modeling.EDITOR_BASE_FONT.init(ModelingActivator::getDefaultFontData).onChange(font -> {
			try {
				final FontData newValue = new FontData(font.getName(), font.getSize(), font.getStyle());
				setValue(EditorsPlugin.getDefault().getPreferenceStore(), TEXT_FONT, newValue);
			} catch (final Exception e) {}
		});
		GamaPreferences.Modeling.EDITOR_BACKGROUND_COLOR.init(ModelingActivator::getDefaultBackground).onChange(c -> {
			final RGB rgb = new RGB(c.getRed(), c.getGreen(), c.getBlue());
			PreferenceConverter.setValue(EditorsPlugin.getDefault().getPreferenceStore(),
					AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND, rgb);
			GamaPreferences.Modeling.OPERATORS_MENU_SORT
					.onChange(newValue -> OperatorsReferenceMenu.byName = "Name".equals(newValue));
		});
		// GamlRuntimeModule.staticInitialize(); Done in the activator now
		GamlEditorBindings.install();
		GamlReferenceSearch.install();

	}

}
