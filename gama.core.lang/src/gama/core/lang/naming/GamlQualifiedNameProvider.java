/*******************************************************************************************************
 *
 * GamlQualifiedNameProvider.java, in gama.core.lang, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.core.lang.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import gama.common.interfaces.IKeyword;
import gama.core.lang.gaml.ArgumentPair;
import gama.core.lang.gaml.GamlDefinition;
import gama.core.lang.gaml.Model;
import gama.core.lang.gaml.S_Reflex;
import gama.core.lang.gaml.speciesOrGridDisplayStatement;
import gama.core.lang.gaml.util.GamlSwitch;
import gaml.descriptions.ModelDescription;

/**
 * GAML Qualified Name provider.
 *
 */
public class GamlQualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {

	/** The Constant NULL. */
	private final static String NULL = "";

	/** The Constant SWITCH. */
	private final static GamlSwitch<String> SWITCH = new GamlSwitch<>() {

		@Override
		public String caseS_Reflex(final S_Reflex s) {
			if (IKeyword.ASPECT.equals(s.getKey())) return s.getName();
			return NULL;
		}

		@Override
		public String casespeciesOrGridDisplayStatement(final speciesOrGridDisplayStatement s) {
			return NULL;
		}

		@Override
		public String caseModel(final Model o) {
			return o.getName() + ModelDescription.MODEL_SUFFIX;
		}

		@Override
		public String defaultCase(final EObject e) {
			return NULL;
		}

		@Override
		public String caseGamlDefinition(final GamlDefinition object) {
			return object.getName();
		}

		@Override
		public String caseArgumentPair(final ArgumentPair object) {
			return object.getOp();
		}

	};

	@Override
	public QualifiedName getFullyQualifiedName(final EObject input) {
		final String string = SWITCH.doSwitch(input);
		if (string == null || NULL.equals(string)) return null;
		return QualifiedName.create(string);
	}

}