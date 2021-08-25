/*******************************************************************************************************
 *
 * ActivatorHelper.java, in gama.ui.modeling, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.modeling;

import static org.eclipse.jface.preference.PreferenceConverter.getColor;
import static org.eclipse.jface.preference.PreferenceConverter.setValue;
import static org.eclipse.jface.resource.JFaceResources.TEXT_FONT;

import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import gama.common.preferences.GamaPreferences;
import gama.core.lang.GamlRuntimeModule;
import gama.ui.base.utils.GamlReferenceSearch;
import gama.ui.modeling.editor.GamlEditorBindings;
import gama.ui.modeling.reference.OperatorsReferenceMenu;
import gama.util.GamaColor;
import gama.util.GamaFont;

/**
 * The class ActivatorHelper.
 *
 * @author drogoul
 * @since 26 août 2021
 *
 */
public class ActivatorHelper {

	/**
	 * Gets the default background.
	 *
	 * @return the default background
	 */
	private static GamaColor getDefaultBackground() {
		EditorsPlugin.getDefault().getPreferenceStore()
				.setValue(AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT, false);
		final RGB rgb = getColor(EditorsPlugin.getDefault().getPreferenceStore(),
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
	 * Early startup.
	 */
	public static void initializeOnActivation() {
		GamaPreferences.Modeling.EDITOR_BASE_FONT.init(ActivatorHelper::getDefaultFontData).onChange(font -> {
			try {
				final FontData newValue = new FontData(font.getName(), font.getSize(), font.getStyle());
				setValue(EditorsPlugin.getDefault().getPreferenceStore(), TEXT_FONT, newValue);
			} catch (final Exception e) {}
		});
		GamaPreferences.Modeling.EDITOR_BACKGROUND_COLOR.init(ActivatorHelper::getDefaultBackground).onChange(c -> {
			final RGB rgb = new RGB(c.getRed(), c.getGreen(), c.getBlue());
			PreferenceConverter.setValue(EditorsPlugin.getDefault().getPreferenceStore(),
					AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND, rgb);
			GamaPreferences.Modeling.OPERATORS_MENU_SORT
					.onChange(newValue -> OperatorsReferenceMenu.byName = "Name".equals(newValue));
		});
		GamlRuntimeModule.staticInitialize();
		GamlEditorBindings.install();
		GamlReferenceSearch.install();

	}
}
