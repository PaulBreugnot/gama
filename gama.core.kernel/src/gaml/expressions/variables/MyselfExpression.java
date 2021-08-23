package gaml.expressions.variables;

import gama.common.interfaces.IKeyword;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.types.IType;

public class MyselfExpression extends TempVariableExpression {

	public MyselfExpression(final IType<?> type, final IDescription definitionDescription) {
		super(IKeyword.MYSELF, type, definitionDescription);
	}

	@Override
	public IExpression resolveAgainst(final IScope scope) {
		return this;
	}

	@Override
	public void setVal(final IScope scope, final Object v, final boolean create) throws GamaRuntimeException {}

	@Override
	public String getTitle() {
		return "pseudo variable " + getName() + " of type " + getGamlType().getTitle();
	}

	@Override
	public String getDocumentation() {
		final IDescription desc = getDefinitionDescription();
		return "pseudo variable " + getName() + " of type " + getGamlType().getTitle()
				+ (desc == null ? "<br>Built In" : "<br>Defined in " + desc.getTitle());
	}

}