/*******************************************************************************************************
 *
 * ColorEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import java.awt.Color;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MenuItem;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.controls.FlatButton;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.menus.GamaColorMenu;
import gama.ui.base.menus.GamaColorMenu.IColorRunnable;
import gama.ui.base.resources.GamaColors;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gama.util.GamaColor;
import gaml.types.GamaColorType;
import gaml.types.Types;

/**
 * The Class ColorEditor.
 */
public class ColorEditor extends AbstractEditor<Color> {

	/** The runnable. */
	final IColorRunnable runnable = (r, g, b) -> modifyAndDisplayValue(new GamaColor(r, g, b, 255));

	/** The listener. */
	final SelectionListener listener = new SelectionAdapter() {

		@Override
		public void widgetDefaultSelected(final SelectionEvent e) {
			widgetSelected(e);
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			final MenuItem i = (MenuItem) e.widget;
			final String color = i.getText().replace("#", "");
			final GamaColor c = GamaColor.colors.get(color);
			if (c == null) return;
			modifyAndDisplayValue(c);
		}

	};

	/** The edit. */
	private FlatButton edit;

	/**
	 * Instantiates a new color editor.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param param the param
	 * @param l the l
	 */
	ColorEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener<Color> l) {
		super(scope, agent, param, l);
	}

	/**
	 * Instantiates a new color editor.
	 *
	 * @param scope the scope
	 * @param parent the parent
	 * @param title the title
	 * @param value the value
	 * @param whenModified the when modified
	 */
	ColorEditor(final IScope scope, final EditorsGroup parent, final String title, final Object value,
			final EditorListener<java.awt.Color> whenModified) {
		super(scope, new InputParameter(title, value), whenModified);
		this.createControls(parent);
	}

	@Override
	public void widgetSelected(final SelectionEvent event) {
		new GamaColorMenu(null).open(edit, event, listener, runnable);
	}

	@Override
	public Control createCustomParameterControl(final Composite compo) {
		edit = FlatButton.menu(compo, IGamaColors.WHITE, "").light().small();
		edit.addSelectionListener(this);
		displayParameterValue();
		return edit;
	}

	@Override
	protected void displayParameterValue() {
		internalModification = true;
		final GamaUIColor color =
				GamaColors.get(currentValue == null ? GamaColor.getInt(0) : (java.awt.Color) currentValue);
		edit.setText(color.toString());
		edit.setColor(color);
		internalModification = false;
	}

	@Override
	public GamaColorType getExpectedType() {
		return Types.COLOR;
	}

	@Override
	protected void applyEdit() {
		final java.awt.Color color = currentValue;
		final RGB rgb = new RGB(color.getRed(), color.getGreen(), color.getBlue());
		GamaColorMenu.openView(runnable, rgb);
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { EDIT, REVERT };
	}

}
