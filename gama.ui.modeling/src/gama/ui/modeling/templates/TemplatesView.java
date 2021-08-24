/*******************************************************************************************************
 *
 * TemplatesView.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.templates;

import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.part.ViewPart;

/**
 * The Class TemplatesView.
 */
public class TemplatesView extends ViewPart {

	/**
	 * Instantiates a new templates view.
	 */
	public TemplatesView() {}

	@Override
	public void createPartControl(final Composite parent) {
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(parent.getShell(),
				"gama.core.lang.Gaml.templates", new String[] {}, null);
		PreferencePage selectedPage = (PreferencePage) dialog.getSelectedPage();
		selectedPage.createControl(parent);
	}

	@Override
	public void setFocus() {}

}
