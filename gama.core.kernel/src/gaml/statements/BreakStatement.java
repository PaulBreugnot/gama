/*******************************************************************************************************
 *
 * msi.gaml.statements.BreakStatement.java, in plugin msi.gama.core, is part of the source code of the GAMA modeling and
 * simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gaml.statements;

import gama.common.interfaces.IGamlIssue;
import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.annotations.serializer;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.descriptions.StatementDescription;
import gaml.descriptions.StatementWithChildrenDescription;
import gaml.descriptions.SymbolDescription;
import gaml.descriptions.SymbolSerializer;
import gaml.statements.BreakStatement.BreakSerializer;
import gaml.statements.BreakStatement.BreakValidator;

/**
 * The class BreakCommand.
 *
 * @author drogoul
 * @since 22 avr. 2012
 *
 */
@symbol (
		name = IKeyword.BREAK,
		kind = ISymbolKind.SINGLE_STATEMENT,
		with_sequence = false,
		concept = { IConcept.LOOP })
@inside (
		kinds = ISymbolKind.SEQUENCE_STATEMENT)
@doc (
		value = "`" + IKeyword.BREAK + "` allows to interrupt the current sequence of statements.")
@validator (BreakValidator.class)
@serializer (BreakSerializer.class)
public class BreakStatement extends AbstractStatement {

	public static class BreakSerializer extends SymbolSerializer<StatementDescription> {

		@Override
		protected void serialize(final SymbolDescription desc, final StringBuilder sb, final boolean includingBuiltIn) {
			sb.append(BREAK).append(";");
		}
	}

	public static class BreakValidator implements IDescriptionValidator<StatementDescription> {

		/**
		 * Method validate()
		 *
		 * @see gaml.compilation.IDescriptionValidator#validate(gaml.descriptions.IDescription)
		 */
		@Override
		public void validate(final StatementDescription description) {
			IDescription superDesc = description.getEnclosingDescription();
			while (superDesc instanceof StatementWithChildrenDescription) {
				if (((StatementWithChildrenDescription) superDesc).isBreakable()) { return; }
				superDesc = superDesc.getEnclosingDescription();
			}
			description.error("'break' must be used in the context of a loop, a switch or an ask statement",
					IGamlIssue.WRONG_CONTEXT);
		}
	}

	/**
	 * @param desc
	 */
	public BreakStatement(final IDescription desc) {
		super(desc);
	}

	/**
	 * @see msi.gaml.commands.AbstractCommand#privateExecuteIn(gama.runtime.IScope)
	 */
	@Override
	protected Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		scope.interruptLoop();
		return null; // How to return the last object ??
	}

}
