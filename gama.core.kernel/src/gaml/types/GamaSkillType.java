/*******************************************************************************************************
 *
 * GamaSkillType.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gaml.types;

import gama.common.interfaces.IKeyword;
import gama.common.interfaces.ISkill;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.compilation.kernel.GamaSkillRegistry;

/**
 * The type used for representing species objects (since they can be manipulated in a model)
 * 
 * Written by drogoul Modified on 1 ao�t 2010.
 *
 * @todo Description
 */
@SuppressWarnings ("unchecked")
@type (
		name = IKeyword.SKILL,
		id = IType.SKILL,
		wraps = { ISkill.class },
		kind = ISymbolKind.Variable.REGULAR,
		concept = { IConcept.TYPE, IConcept.SKILL },
		doc = @doc ("Meta-type of the skills present in the GAML language"))
public class GamaSkillType extends GamaType<ISkill> {

	@Override
	public ISkill cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj instanceof ISkill) { return (ISkill) obj; }
		if (obj instanceof String) { return GamaSkillRegistry.INSTANCE.getSkillInstanceFor((String) obj); }
		return null;
	}

	@Override
	public ISkill getDefault() {
		return null;
	}

	@Override
	public boolean canCastToConst() {
		return true;
	}

}
