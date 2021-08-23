/*********************************************************************************************
 *
 * 'PauseSoundStatement.java, in plugin ummisco.gaml.extensions.sound, is part of the source code of the GAMA modeling
 * and simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ext.audio;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.ext.audio.PauseSoundStatement.PauseSoundValidator;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.IDescriptionValidator;
import gaml.compilation.ISymbol;
import gaml.compilation.annotations.validator;
import gaml.descriptions.IDescription;
import gaml.statements.AbstractStatementSequence;

@symbol (
		name = IKeyword.PAUSE_SOUND,
		kind = ISymbolKind.SEQUENCE_STATEMENT,
		with_sequence = true,
		concept = { IConcept.SOUND })
@doc ("Allows to pause the sound output")
@inside (
		kinds = { ISymbolKind.BEHAVIOR, ISymbolKind.SEQUENCE_STATEMENT, ISymbolKind.LAYER, ISymbolKind.OUTPUT })
@validator (PauseSoundValidator.class)
public class PauseSoundStatement extends AbstractStatementSequence {

	public static class PauseSoundValidator implements IDescriptionValidator<IDescription> {

		/**
		 * Method validate()
		 *
		 * @see gaml.compilation.IDescriptionValidator#validate(gaml.descriptions.IDescription)
		 */
		@Override
		public void validate(final IDescription cd) {
			// what to validate?
		}
	}

	private AbstractStatementSequence sequence = null;

	public PauseSoundStatement(final IDescription desc) {
		super(desc);
	}

	@Override
	public void setChildren(final Iterable<? extends ISymbol> com) {
		sequence = new AbstractStatementSequence(description);
		sequence.setName("commands of " + getName());
		sequence.setChildren(com);
	}

	@Override
	public Object privateExecuteIn(final IScope scope) throws GamaRuntimeException {

		final IAgent currentAgent = scope.getAgent();

		final GamaSoundPlayer soundPlayer = SoundPlayerBroker.getInstance().getSoundPlayer(currentAgent);
		soundPlayer.pause(scope);

		if (sequence != null) { scope.execute(sequence, currentAgent, null); }

		return null;
	}
}
