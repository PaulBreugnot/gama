/*******************************************************************************************************
 *
 * SocialLinkType.java, in gama.ext.bdi, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.bdi;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.types.GamaType;
import gaml.types.IType;

/**
 * The Class SocialLinkType.
 */
@SuppressWarnings("unchecked")
@type(name = "social_link", id = SocialLinkType.id, wraps = { SocialLink.class }, concept = { IConcept.TYPE,
		IConcept.BDI })
@doc("represents a social link")
public class SocialLinkType extends GamaType<SocialLink> {

	/** The Constant id. */
	public final static int id = IType.AVAILABLE_TYPES + 546657;

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	@doc("cast an object into a social link, if it is an instance of a social link")
	public SocialLink cast(final IScope scope, final Object obj, final Object param, final boolean copy)
			throws GamaRuntimeException {
		if (obj instanceof SocialLink) {
			return (SocialLink) obj;
		}
		return null;
	}

	@Override
	public SocialLink getDefault() {
		return null;
	}

}
