/*******************************************************************************************************
 *
 * TypeExpression.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.expressions.types;

import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.expressions.AbstractExpression;
import gaml.types.IType;
import gaml.types.Types;

/**
 * Class TypeExpression.
 *
 * @author drogoul
 * @since 7 sept. 2013
 *
 */
public class TypeExpression extends AbstractExpression {

	/**
	 * Instantiates a new type expression.
	 *
	 * @param type the type
	 */
	@SuppressWarnings ("rawtypes")
	public TypeExpression(final IType type) {
		this.type = type;
	}

	@Override
	public IType<?> _value(final IScope scope) throws GamaRuntimeException {
		// Normally never evaluated
		return getDenotedType();
	}

	@Override
	public String getDefiningPlugin() {
		return type.getDefiningPlugin();
	}

	@Override
	public boolean shouldBeParenthesized() {
		return false;
	}

	@Override
	public boolean isConst() {
		return type.canCastToConst();
	}

	@Override
	public String serialize(final boolean includingBuiltIn) {
		return type.serialize(includingBuiltIn);
	}

	@Override
	public String getTitle() {
		return type.getTitle();
	}

	/**
	 * Method getDocumentation()
	 *
	 * @see gama.common.interfaces.IGamlDescription#getDocumentation()
	 */
	@Override
	public String getDocumentation() {
		return "Represents the data type " + type.getTitle();
	}

	@Override
	public IType<?> getGamlType() {
		return Types.TYPE;
	}

	@Override
	public IType<?> getDenotedType() {
		return type;
	}

	@Override
	public String literalValue() {
		return type.serialize(false);
	}

	@Override
	public boolean isContextIndependant() {
		return false;
	}

}
