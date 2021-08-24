/*******************************************************************************************************
 *
 * UserFirstControlArchitecture.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.architecture.user;

import gama.common.interfaces.IKeyword;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.skill;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

// @vars({ @var(name = IKeyword.STATE, type = IType.STRING),
/**
 * The Class UserFirstControlArchitecture.
 */
// @var(name = IKeyword.STATES, type = IType.LIST, constant = true) })
@skill (
		name = IKeyword.USER_FIRST,
		concept = { IConcept.GUI, IConcept.ARCHITECTURE },
		doc = @doc ("A control architecture, based on FSM, where the user is being given control before states / reflexes of the agent are executed"))
public class UserFirstControlArchitecture extends UserControlArchitecture {

	@Override
	public Object executeOn(final IScope scope) throws GamaRuntimeException {
		executeCurrentState(scope);
		return executeReflexes(scope);
	}

	@Override
	public boolean init(final IScope scope) throws GamaRuntimeException {
		if (initPanel != null) {
			scope.execute(initPanel);
		}
		return super.init(scope);
	}
}