/*********************************************************************************************
 *
 * 'StringEditor.java, in plugin ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import java.util.List;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;
import gaml.types.IType;
import gaml.types.Types;

public class StringEditor extends ExpressionBasedEditor<String> {

	StringEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener<String> l) {
		super(scope, agent, param, l);
	}

	StringEditor(final IScope scope, final EditorsGroup parent, final String title, final Object value,
			final EditorListener<String> whenModified) {
		super(scope, new InputParameter(title, value), whenModified);
		this.createControls(parent);
	}

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
