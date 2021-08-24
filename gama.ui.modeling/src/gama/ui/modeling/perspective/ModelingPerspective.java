/*******************************************************************************************************
 *
 * ModelingPerspective.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import gama.common.ui.IGui;

/**
 * The Class ModelingPerspective.
 */
public class ModelingPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(final IPageLayout layout) {
		layout.addShowViewShortcut(IGui.INTERACTIVE_CONSOLE_VIEW_ID);
		layout.setEditorAreaVisible(true);
	}
}
