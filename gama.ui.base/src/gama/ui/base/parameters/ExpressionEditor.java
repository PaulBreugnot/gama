/*******************************************************************************************************
 *
 * ExpressionEditor.java, in gama.ui.base, is part of the source code of the
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
import gama.ui.base.interfaces.EditorListener;
import gaml.expressions.IExpression;
import gaml.types.IType;

/**
 * The Class ExpressionEditor.
 */
public class ExpressionEditor extends GenericEditor<IExpression> {

	/** The expression text. */
	private String expressionText;

	/**
	 * Instantiates a new expression editor.
	 *
	 * @param scope the scope
	 * @param parent the parent
	 * @param title the title
	 * @param value the value
	 * @param whenModified the when modified
	 * @param expectedType the expected type
	 */
	ExpressionEditor(final IScope scope, final EditorsGroup parent, final String title, final IExpression value,
			final EditorListener<IExpression> whenModified, final IType<?> expectedType) {
		super(scope, parent, title, value, whenModified);
		this.expectedType = expectedType;
	}

	@Override
	public Control createCustomParameterControl(final Composite comp) {
		expressionText = currentValue.serialize(true);
		return super.createCustomParameterControl(comp);
	}

	@Override
	protected void displayParameterValue() {
		editorControl.setText(expressionText);
	}

	@Override
	public IExpression retrieveValueOfParameter() {
		return (IExpression) param.value(getScope());
	}

	@Override
	public boolean evaluateExpression() {
		return false;
	}

	/**
	 * Sets the editor text no popup.
	 *
	 * @param s the new editor text no popup
	 */
	public void setEditorTextNoPopup(final String s) {
		internalModification = true;
		editorControl.setText(s);
		internalModification = false;
	}

}
