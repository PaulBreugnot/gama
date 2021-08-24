/*******************************************************************************************************
 *
 * StringEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import java.util.List;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class StringEditor.
 */
public class StringEditor extends ExpressionBasedEditor<String> {

	/**
	 * Instantiates a new string editor.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param param the param
	 * @param l the l
	 */
	StringEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener<String> l) {
		super(scope, agent, param, l);
	}

	/**
	 * Instantiates a new string editor.
	 *
	 * @param scope the scope
	 * @param parent the parent
	 * @param title the title
	 * @param value the value
	 * @param whenModified the when modified
	 */
	StringEditor(final IScope scope, final EditorsGroup parent, final String title, final Object value,
			final EditorListener<String> whenModified) {
		super(scope, new InputParameter(title, value), whenModified);
		this.createControls(parent);
	}

	/**
	 * Instantiates a new string editor.
	 *
	 * @param scope the scope
	 * @param parent the parent
	 * @param title the title
	 * @param value the value
	 * @param among the among
	 * @param whenModified the when modified
	 */
	StringEditor(final IScope scope, final EditorsGroup parent, final String title, final String value,
			final List<String> among, final EditorListener<String> whenModified) {
		super(scope, new InputParameter(title, value, Types.STRING, among), whenModified);
		this.createControls(parent);
	}

	@Override
	public IType<String> getExpectedType() {
		return Types.STRING;
	}

}
