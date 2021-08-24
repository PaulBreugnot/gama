/*******************************************************************************************************
 *
 * AgentEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import gama.kernel.experiment.IParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.interfaces.IAgentMenuFactory;
import gama.ui.base.menus.MenuAction;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaIcons;
import gama.ui.base.utils.WorkbenchHelper;
import gaml.types.IType;

/**
 * The Class AgentEditor.
 */
@SuppressWarnings ({ "unchecked", "rawtypes" })
public class AgentEditor extends ExpressionBasedEditor {

	/** The species. */
	String species;

	/**
	 * Instantiates a new agent editor.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param param the param
	 * @param l the l
	 */
	AgentEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener l) {
		super(scope, agent, param, l);
		species = param.getType().toString();
	}

	@Override
	public void applyChange() {
		Shell shell = editorToolbar.getItem(CHANGE).getParent().getShell();
		final Menu old = shell.getMenu();
		shell.setMenu(null);
		if (old != null) { old.dispose(); }
		// FIXME Not adapted to multiple scales !

		final MenuAction action = new MenuAction(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				final MenuItem mi = (MenuItem) e.widget;
				final IAgent a = (IAgent) mi.getData("agent");
				if (a != null && !a.dead()) { modifyAndDisplayValue(a); }
			}

		}, GamaIcons.create(IGamaIcons.MENU_AGENT).image(), "Choose");

		final Menu dropMenu = new Menu(shell);
		final IAgent a = (IAgent) (currentValue instanceof IAgent ? currentValue : null);
		if (a != null) {
			final IAgentMenuFactory factory = WorkbenchHelper.getService(IAgentMenuFactory.class);
			if (factory != null) {
				factory.fillPopulationSubMenu(dropMenu, a.getScope().getSimulation().getMicroPopulation(species), null,
						action);
			}
		}
		final Rectangle rect = editorToolbar.getItem(CHANGE).getBounds();
		final Point pt = editorToolbar.getItem(CHANGE).getParent().toDisplay(new Point(rect.x, rect.y));
		dropMenu.setLocation(pt.x, pt.y + rect.height);
		dropMenu.setVisible(true);

	}

	@Override
	public IType getExpectedType() {
		return getScope().getType(species);
	}

	/**
	 * Method getToolItems()
	 *
	 * @see gama.ui.base.parameters.AbstractEditor#getToolItems()
	 */
	@Override
	protected int[] getToolItems() {
		return new int[] { INSPECT, CHANGE, REVERT };
	}

	@Override
	protected void applyInspect() {
		if (currentValue instanceof IAgent) {
			final IAgent a = (IAgent) currentValue;
			if (!a.dead()) { getScope().getGui().setSelectedAgent(a); }
		}

	}

}
