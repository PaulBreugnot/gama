/*******************************************************************************************************
 *
 * GamlLinkWithEditorOutlineContribution.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.outline.actions.LinkWithEditorOutlineContribution;

import gama.ui.base.resources.GamaIcons;

/**
 * The class GamlLinkWithEditorOutlineContribution.
 * 
 * @author drogoul
 * @since 24 nov. 2014
 * 
 */
public class GamlLinkWithEditorOutlineContribution extends LinkWithEditorOutlineContribution {

	/**
	 * Instantiates a new gaml link with editor outline contribution.
	 */
	public GamlLinkWithEditorOutlineContribution() {}

	@Override
	protected void configureAction(final Action action) {
		super.configureAction(action);
		action.setImageDescriptor(GamaIcons.create("navigator/navigator.link2").descriptor());
	}

}
