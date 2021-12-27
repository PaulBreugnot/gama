/*******************************************************************************************************
 *
 * TypeExpression.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
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

// TODO: Auto-generated Javadoc
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
	 * @param type
	 *            the type
	 */
	@SuppressWarnings ("rawtypes")
	public TypeExpression(final IType type) {
		this.type = type;
	}

	/**
	 * Value.
	 *
	 * @param scope the scope
	 * @return the i type
	 * @throws GamaRuntimeException the gama runtime exception
	 */
	@Override
	public IType<?> _value(final IScope scope) throws GamaRuntimeException {
		// Normally never evaluated
		return getDenotedType();
	}

	/**
	 * Gets the defining plugin.
	 *
	 * @return the defining plugin
	 */
	@Override
	public String getDefiningPlugin() { return type.getDefiningPlugin(); }

	/**
	 * Should be parenthesized.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean shouldBeParenthesized() {
		return false;
	}

	/**
	 * Checks if is const.
	 *
	 * @return true, if is const
	 */
	@Override
	public boolean isConst() { return type.canCastToConst(); }

	/**
	 * Serialize.
	 *
	 * @param includingBuiltIn the including built in
	 * @return the string
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		return type.serialize(includingBuiltIn);
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() { return type.getTitle(); }

	/**
	 * Method getDocumentation().
	 *
	 * @return the documentation
	 * @see gama.common.interfaces.IGamlDescription#getDocumentation()
	 */
	@Override
	public String getDocumentation() { return "Represents the data type " + type.getTitle(); }

	/**
	 * Gets the gaml type.
	 *
	 * @return the gaml type
	 */
	@Override
	public IType<?> getGamlType() { return Types.TYPE; }

	/**
	 * Gets the denoted type.
	 *
	 * @return the denoted type
	 */
	@Override
	public IType<?> getDenotedType() { return type; }

	/**
	 * Literal value.
	 *
	 * @return the string
	 */
	@Override
	public String literalValue() {
		return type.serialize(false);
	}

	/**
	 * Checks if is context independant.
	 *
	 * @return true, if is context independant
	 */
	@Override
	public boolean isContextIndependant() { return isConst(); }

}
