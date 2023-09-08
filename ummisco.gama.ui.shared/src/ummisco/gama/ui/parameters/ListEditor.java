/*******************************************************************************************************
 *
 * ListEditor.java, in ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.9.3).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package ummisco.gama.ui.parameters;

import org.eclipse.jface.dialogs.IDialogConstants;

import msi.gama.kernel.experiment.IParameter;
import msi.gama.metamodel.agent.IAgent;
import msi.gama.util.IList;
import msi.gaml.types.IType;
import msi.gaml.types.Types;
import ummisco.gama.ui.interfaces.EditorListener;
import ummisco.gama.ui.utils.WorkbenchHelper;

/**
 * The Class ListEditor.
 */
public class ListEditor extends ExpressionBasedEditor<java.util.List<?>> {

	/**
	 * Instantiates a new list editor.
	 *
	 * @param scope
	 *            the scope
	 * @param agent
	 *            the agent
	 * @param param
	 *            the param
	 * @param l
	 *            the l
	 */
	ListEditor(final IAgent agent, final IParameter param, final EditorListener<java.util.List<?>> l) {
		super(agent, param, l);
	}

	@SuppressWarnings ("rawtypes")
	@Override
	public void applyEdit() {
		if (currentValue instanceof IList) {
			final ListEditorDialog d =
					new ListEditorDialog(WorkbenchHelper.getShell(), (IList) currentValue, param.getName());
			if (d.open() == IDialogConstants.OK_ID) { modifyAndDisplayValue(d.getList(ListEditor.this)); }
		}
	}

	@Override
	protected void updateToolbar() {
		super.updateToolbar();
		editorToolbar.enable(EDIT, currentValue instanceof IList);
	}

	@SuppressWarnings ({ "unchecked", "rawtypes" })
	@Override
	public IType getExpectedType() { return Types.LIST; }

	@Override
	protected int[] getToolItems() { return new int[] { EDIT, REVERT }; }

}
