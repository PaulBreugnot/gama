/*******************************************************************************************************
 *
 * ReflexStatement.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.architecture.reflex;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.IDescriptionValidator.ValidNameValidator;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.operators.Cast;
import gaml.statements.AbstractStatementSequence;
import gaml.types.IType;

/**
 * The Class ReflexStatement.
 */
@symbol (
		name = { IKeyword.REFLEX, IKeyword.INIT, IKeyword.ABORT },
		kind = ISymbolKind.BEHAVIOR,
		with_sequence = true,
		unique_name = true,
		concept = { IConcept.BEHAVIOR, IConcept.SCHEDULER })
@inside (
		kinds = { ISymbolKind.SPECIES, ISymbolKind.EXPERIMENT, ISymbolKind.MODEL })
@facets (
		value = { @facet (
				name = IKeyword.WHEN,
				type = IType.BOOL,
				optional = true,
				doc = @doc ("an expression that evaluates a boolean, the condition to fulfill in order to execute the statements embedded in the reflex.")),
				@facet (
						name = IKeyword.NAME,
						type = IType.ID,
						optional = true,
						doc = @doc ("the identifier of the reflex")) },
		omissible = IKeyword.NAME)
@validator (ValidNameValidator.class)
@doc (
		value = "Reflexes are sequences of statements that can be executed by the agent. Reflexes prefixed by the 'reflex' keyword are executed continuously. Reflexes prefixed by 'init' are executed only immediately after the agent has been created. Reflexes prefixed by 'abort' just before the agent is killed. If a facet when: is defined, a reflex is executed only if the boolean expression evaluates to true.",
		usages = { @usage (
				value = "Example:",
				examples = { @example (
						value = "reflex my_reflex when: flip (0.5){ 		//Only executed when flip returns true",
						isExecutable = false),
						@example (
								value = "    write \"Executing the unconditional reflex\";",
								isExecutable = false),
						@example (
								value = "}",
								isExecutable = false) }) })
public class ReflexStatement extends AbstractStatementSequence {

	/** The when. */
	private final IExpression when;

	/**
	 * Instantiates a new reflex statement.
	 *
	 * @param desc the desc
	 */
	public ReflexStatement(final IDescription desc) {
		super(desc);
		when = getFacet(IKeyword.WHEN);
		if (hasFacet(IKeyword.NAME)) {
			setName(getLiteral(IKeyword.NAME));
		}
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {
		return when == null || Cast.asBool(scope, when.value(scope)) ? super.privateExecuteIn(scope) : null;
	}

}
