/*******************************************************************************************************
 *
 * AssertEditor.java, in gama.ui.base, is part of the source code of the
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.controls.FlatButton;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.resources.GamaColors;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gaml.statements.test.AbstractSummary;
import gaml.statements.test.AssertionSummary;
import gaml.statements.test.TestState;

/**
 * The Class AssertEditor.
 */
public class AssertEditor extends AbstractStatementEditor<AbstractSummary<?>> {

	/**
	 * Instantiates a new assert editor.
	 *
	 * @param scope the scope
	 * @param command the command
	 */
	public AssertEditor(final IScope scope, final AbstractSummary<?> command) {
		super(scope, command, (EditorListener<Object>) null);
		isSubParameter = command instanceof AssertionSummary;
		name = command.getTitle();
	}

	@Override
	protected Control createCustomParameterControl(final Composite composite) throws GamaRuntimeException {
		textBox = FlatButton.button(composite, getColor(), getText());
		textBox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				GAMA.getGui().editModel(null, getStatement().getURI());
			}
		});
		return textBox;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	private GamaUIColor getColor() {
		GamaUIColor color = GamaColors.get(getStatement().getColor());
		if (color == null) { color = IGamaColors.NEUTRAL; }
		return color;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	private String getText() {
		final AbstractSummary<?> summary = getStatement();
		if (summary instanceof AssertionSummary && getStatement().getState() == TestState.ABORTED)
			return getStatement().getState().toString() + ": " + ((AssertionSummary) getStatement()).getError() + "  ";
		return getStatement().getState().toString() + "  ";
	}

}
