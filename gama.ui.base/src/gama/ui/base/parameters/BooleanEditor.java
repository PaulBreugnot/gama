/*********************************************************************************************
 *
 * 'BooleanEditor.java, in plugin gama.ui.base, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.controls.SwitchButton;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.resources.GamaColors;
import gama.ui.base.resources.IGamaColors;
import gaml.types.IType;
import gaml.types.Types;

public class BooleanEditor extends AbstractEditor<Boolean> {

	private SwitchButton button;

	BooleanEditor(final IScope scope, final EditorsGroup parent, final String title, final boolean value,
			final EditorListener<Boolean> whenModified) {
		super(scope, new InputParameter(title, value), whenModified);
		acceptNull = false;
		this.createControls(parent);
	}

	BooleanEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener<Boolean> l) {
		super(scope, agent, param, l);
		acceptNull = false;
	}

	@Override
	public void widgetSelected(final SelectionEvent se) {
		if (!internalModification) { modifyAndDisplayValue(button.getSelection()); }
	}

	@Override
	public Control createCustomParameterControl(final Composite comp) {
		final var colors = getParam().getColor(getScope());
		var left = IGamaColors.OK.color();
		var right = IGamaColors.ERROR.color();
		if (colors != null) {
			if (colors.size() == 1) {
				left = right = GamaColors.get(colors.get(0)).color();
			} else if (colors.size() >= 2) {
				left = GamaColors.get(colors.get(0)).color();
				right = GamaColors.get(colors.get(1)).color();
			}
		}
		button = new SwitchButton(comp, SWT.CHECK, left, right);
		button.addSelectionListener(this);
		return button;
	}

	@Override
	protected void displayParameterValue() {
		internalModification = true;
		button.setSelection(currentValue == null ? false : currentValue);
		internalModification = false;

	}

	@Override
	public IType<Boolean> getExpectedType() {
		return Types.BOOL;
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { REVERT };
	}

}
