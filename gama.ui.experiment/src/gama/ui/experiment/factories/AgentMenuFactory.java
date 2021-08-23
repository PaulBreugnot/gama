/*********************************************************************************************
 *
 * 'AgentMenuFactory.java, in plugin ummisco.gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform.
 * (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 * 
 *
 **********************************************************************************************/
package gama.ui.experiment.factories;

import java.util.Collection;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.metamodel.agent.IAgent;
import gama.ui.base.menus.MenuAction;
import gama.ui.experiment.menus.AgentsMenu;

public class AgentMenuFactory extends AbstractServiceFactory implements gama.ui.base.interfaces.IAgentMenuFactory {

	@Override
	public void fillPopulationSubMenu(final Menu menu, final Collection<? extends IAgent> species,
			final MenuAction... actions) {
		AgentsMenu.fillPopulationSubMenu(menu, species, actions);

	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
