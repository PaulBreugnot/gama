/*******************************************************************************************************
 *
 * msi.gaml.architecture.user.UserLastControlArchitecture.java, in plugin msi.gama.core,
 * is part of the source code of the GAMA modeling and simulation platform (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/SU & Partners
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

@skill (
		name = IKeyword.USER_LAST,
		concept = { IConcept.GUI, IConcept.ARCHITECTURE },
		doc = @doc ("A control architecture, based on FSM, where the user is being given control after states / reflexes of the agent are executed"))
// @vars({ @var(name = IKeyword.STATE, type = IType.STRING),
// @var(name = IKeyword.STATES, type = IType.LIST, constant = true) })
public class UserLastControlArchitecture extends UserControlArchitecture {

	@Override
	public Object executeOn(final IScope scope) throws GamaRuntimeException {
		executeReflexes(scope);
		return executeCurrentState(scope);
	}

	@Override
	public boolean init(final IScope scope) throws GamaRuntimeException {
		if (super.init(scope)) {
			if (initPanel != null) {
				scope.execute(initPanel);
			}
		} else {
			return false;
		}
		return true;
	}
}