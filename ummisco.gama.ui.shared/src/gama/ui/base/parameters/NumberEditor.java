/*********************************************************************************************
 *
 * 'NumberEditor.java, in plugin ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.resources.GamaIcons;

public abstract class NumberEditor<T extends Comparable> extends ExpressionBasedEditor<T> {

	static final String UNDEFINED_LABEL = "-- Undefined --";

	public NumberEditor(final IScope scope, final IParameter param, final boolean canBeNull) {
		super(scope, param);
		acceptNull = canBeNull;
	}

	public NumberEditor(final IScope scope, final InputParameter supportParameter, final EditorListener<T> whenModified,
			final boolean canBeNull) {
		super(scope, supportParameter, whenModified);
		acceptNull = canBeNull;
	}

	public NumberEditor(final IScope scope, final IAgent a, final IParameter p, final EditorListener<T> l,
			final boolean canBeNull) {
		super(scope, a, p, l);
		acceptNull = canBeNull;
	}

	@Override
	public Control createCustomParameterControl(final Composite composite) throws GamaRuntimeException {
		normalizeValues();
		return super.createCustomParameterControl(composite);
	}

	protected abstract Number normalizeValues() throws GamaRuntimeException;

	@Override
	protected void updateToolbar() {
		super.updateToolbar();
		final Label t = editorToolbar.getItem(DEFINE);
		if (t == null || t.isDisposed()) return;
		if (param.isDefined()) {
			t.setToolTipText("Set the parameter to undefined");
			t.setImage(GamaIcons.create("small.undefine").image());
			editorControl.setActive(true);
		} else {
			t.setToolTipText("Define the parameter (currently undefined)");
			t.setImage(GamaIcons.create("small.define").image());
			editorControl.setActive(false);
		}
	}

	@Override
	protected void applyDefine() {
		if (param.isDefined()) {
			param.setDefined(false);
			internalModification = true;
			editorControl.setText(UNDEFINED_LABEL);
			internalModification = false;
			modifyValue(null);
		} else {
			param.setDefined(true);
			internalModification = true;
			expression.modifyValue();
			internalModification = false;
		}
		updateToolbar();
	}

	@Override
	protected int[] getToolItems() {
		if (acceptNull) return new int[] { DEFINE, PLUS, MINUS, REVERT };
		return new int[] { PLUS, MINUS, REVERT };
	}
}
