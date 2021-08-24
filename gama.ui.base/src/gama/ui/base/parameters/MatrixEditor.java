/*********************************************************************************************
 *
 * 'MatrixEditor.java, in plugin gama.ui.base, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.jface.dialogs.IDialogConstants;

import gama.kernel.experiment.IParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.matrix.IMatrix;
import gaml.types.IType;
import gaml.types.Types;

public class MatrixEditor extends ExpressionBasedEditor<IMatrix<?>> {

	MatrixEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener<IMatrix<?>> l) {
		super(scope, agent, param, l);
	}

	@Override
	public void applyEdit() {

		final MatrixEditorDialog d = new MatrixEditorDialog(getScope(), WorkbenchHelper.getShell(), currentValue);
		if (d.open() == IDialogConstants.OK_ID) { modifyValue(d.getMatrix()); }

	}

	@Override
	protected void updateToolbar() {
		super.updateToolbar();
		editorToolbar.enable(EDIT, currentValue != null);
	}

	@SuppressWarnings ({ "unchecked", "rawtypes" })
	@Override
	public IType getExpectedType() {
		return Types.MATRIX;
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { EDIT, REVERT };
	}

}
