/*******************************************************************************************************
 *
 * FixedValueEditorControl.java, in gama.ui.base, is part of the source code of the
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class FixedValueEditorControl.
 */
public class FixedValueEditorControl extends EditorControl<CLabel> {

	/**
	 * Constructor for building a read-only value control.
	 *
	 * @param editor the editor
	 * @param parent the parent
	 */
	FixedValueEditorControl(final AbstractEditor editor, final Composite parent) {
		super(editor, new CLabel(parent, SWT.READ_ONLY));
		setForeground(isDark() ? VERY_LIGHT_GRAY.color() : BLACK.color());
		// force text color, see #2601
	}

	@Override
	public void setText(final String s) {
		if (control.isDisposed()) return;
		control.setText(s);
	}

	@Override
	public void displayParameterValue() {
		Object val = editor.getCurrentValue();
		setText(val instanceof String ? (String) val : toGaml(val, false));
	}

}
