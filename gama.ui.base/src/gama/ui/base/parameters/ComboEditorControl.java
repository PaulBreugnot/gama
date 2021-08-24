/*******************************************************************************************************
 *
 * ComboEditorControl.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import static gama.common.util.StringUtils.toGaml;
import static gama.ui.base.resources.IGamaColors.BLACK;
import static gama.ui.base.resources.IGamaColors.VERY_LIGHT_GRAY;
import static gama.ui.base.utils.ThemeHelper.isDark;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import gama.common.util.StringUtils;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class ComboEditorControl.
 */
public class ComboEditorControl extends EditorControl<Combo> {

	/** The possible values. */
	final List possibleValues;

	/**
	 * Instantiates a new combo editor control.
	 *
	 * @param editor the editor
	 * @param parent the parent
	 * @param expectedType the expected type
	 * @param possibleValues the possible values
	 */
	ComboEditorControl(final AbstractEditor editor, final Composite parent, final IType expectedType,
			final List possibleValues) {
		super(editor, new Combo(parent, SWT.READ_ONLY | SWT.DROP_DOWN));
		this.possibleValues = possibleValues;
		final var valuesAsString = new String[possibleValues.size()];
		for (var i = 0; i < possibleValues.size(); i++) {
			if (expectedType == Types.STRING) {
				valuesAsString[i] = StringUtils.toJavaString(toGaml(possibleValues.get(i), false));
			} else {
				valuesAsString[i] = toGaml(possibleValues.get(i), false);
			}
		}
		setForeground(isDark() ? VERY_LIGHT_GRAY.color() : BLACK.color());
		// force text color, see #2601
		control.setItems(valuesAsString);
		control.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent me) {
				editor.modifyValue(possibleValues.get(control.getSelectionIndex()));
				editor.updateToolbar();
			}
		});
		control.pack();
	}

	@Override
	public void displayParameterValue() {
		if (control.isDisposed()) return;
		Object val = editor.getCurrentValue();
		control.select(possibleValues.indexOf(val));
	}

}
