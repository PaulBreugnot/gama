package gama.ext.bdi;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.types.GamaType;
import gaml.types.IType;

@type(name = "Sanction", id = SanctionType.id, wraps = { Sanction.class }, concept = { IConcept.TYPE, IConcept.BDI })
@doc("represents a sanction")
public class SanctionType extends GamaType<Sanction>{
//
	public final static int id = IType.AVAILABLE_TYPES + 546661;
	
	@Override
	public boolean canCastToConst() {
		return true;
	}

	@Override
	@doc("cast an object as a sanction, if it is an instance of a sanction")
	public Sanction cast(IScope scope, Object obj, Object param, boolean copy) throws GamaRuntimeException {
		if (obj instanceof Sanction) {
			return (Sanction) obj;
		}
		return null;
	}

	@Override
	public Sanction getDefault() {
		return null;
	}

}
