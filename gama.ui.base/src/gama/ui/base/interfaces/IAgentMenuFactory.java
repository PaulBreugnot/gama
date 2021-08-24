/*******************************************************************************************************
 *
 * IAgentMenuFactory.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.interfaces;

import java.util.Collection;

import org.eclipse.swt.widgets.Menu;

import gama.metamodel.agent.IAgent;
import gama.ui.base.menus.MenuAction;

/**
 * A factory for creating IAgentMenu objects.
 */
public interface IAgentMenuFactory {

	/**
	 * Fill population sub menu.
	 *
	 * @param menu the menu
	 * @param species the species
	 * @param actions the actions
	 */
	void fillPopulationSubMenu(final Menu menu, final Collection<? extends IAgent> species,
			final MenuAction... actions);
}