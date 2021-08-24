/*********************************************************************************************
 *
 * 'ExpressionBasedEditor.java, in plugin gama.ui.base, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import gama.kernel.experiment.IParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;

/**
 * Class ExpressionBasedEditor.
 *
 * @author drogoul
 * @since 30 nov. 2014
 *
 */
public class ExpressionBasedEditor<T> extends AbstractEditor<T> {

	protected ExpressionControl expression;

	public ExpressionBasedEditor(final IScope scope, final IParameter variable) {
		super(scope, null, variable, null);
	}

	public ExpressionBasedEditor(final IScope scope, final IParameter variable, final EditorListener<T> l) {
		super(scope, variable, l);
	}

	public ExpressionBasedEditor(final IScope scope, final IAgent a, final IParameter variable,
			final EditorListener<T> l) {
		super(scope, a, variable, l);
	}

	// In case the editor allows to edit the expression, should it be evaluated
	// ?
	protected boolean evaluateExpression() {
		return true;
	}

	@Override
	public Control createCustomParameterControl(final Composite compo) {
		expression = new ExpressionControl(getScope(), compo, this, getAgent(), this.getExpectedType(),
				SWT.NONE | SWT.FLAT, evaluateExpression());
		return expression.getControl();
	}

	@Override
	protected void displayParameterValue() {
		internalModification = true;
		expression.displayValue(currentValue);
		internalModification = false;
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { REVERT };
	}

}
