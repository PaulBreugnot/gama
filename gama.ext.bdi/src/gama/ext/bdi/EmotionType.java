/*******************************************************************************************************
 *
 * EmotionType.java, in gama.ext.bdi, is part of the source code of the
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
 * The Class EmotionType.
 */
@SuppressWarnings("unchecked")
@type(name = "emotion", id = EmotionType.id, wraps = { Emotion.class }, concept = { IConcept.TYPE, IConcept.BDI })
@doc("represents the type emotion")
public class EmotionType extends GamaType<Emotion> {

	/** The Constant id. */
	public final static int id = IType.AVAILABLE_TYPES + 546656;

	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	@doc("cast an object instance of emotion as an emotion")
	public Emotion cast(final IScope scope, final Object obj, final Object val, final boolean copy)
			throws GamaRuntimeException {
		if (obj instanceof Emotion) {
			return (Emotion) obj;
		}
		return null;
	}

	@Override
	public Emotion getDefault() {
		// TODO Auto-generated method stub
		return null;
	}

}
