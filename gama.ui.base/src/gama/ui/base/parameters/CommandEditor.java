/*******************************************************************************************************
 *
 * CommandEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.controls.FlatButton;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.interfaces.EditorListener.Command;
import gama.ui.base.resources.GamaColors;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gaml.statements.UserCommandStatement;

/**
 * The Class CommandEditor.
 */
public class CommandEditor extends AbstractStatementEditor<UserCommandStatement> {

	/**
	 * Instantiates a new command editor.
	 *
	 * @param scope the scope
	 * @param command the command
	 * @param l the l
	 */
	public CommandEditor(final IScope scope, final UserCommandStatement command, final EditorListener.Command l) {
		super(scope, command, l);
	}

	@Override
	protected EditorListener.Command getListener() {
		return (Command) super.getListener();
	}

	@Override
	protected Control createCustomParameterControl(final Composite composite) throws GamaRuntimeException {
		GamaUIColor color = GamaColors.get(getStatement().getColor(getScope()));
		if (color == null) { color = IGamaColors.NEUTRAL; }
		textBox = FlatButton.button(composite, color, "");
		textBox.setText(getStatement().getName() + "  ");
		textBox.addSelectionListener(getListener());
		return textBox;

	}

}
