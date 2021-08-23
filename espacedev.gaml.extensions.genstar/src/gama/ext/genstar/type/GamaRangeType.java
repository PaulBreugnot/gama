package gama.ext.genstar.type;

import java.util.Arrays;

import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.type;
import gama.metamodel.shape.GamaPoint;
import gama.runtime.IScope;
import gama.util.GamaList;
import gama.util.GamaPair;
import gaml.operators.Cast;
import gaml.types.GamaType;
import gaml.types.IType;

@type(name = "gen_range", id = GamaRangeType.id, wraps = { GamaRange.class }, concept = { IConcept.TYPE }, doc = @doc("The range type defined in the genstar plugin"))
public class GamaRangeType extends GamaType<GamaRange>{
	public static final int id = IType.AVAILABLE_TYPES + 3524246;

	@Override
	public boolean canCastToConst() {
		return true;
	}


	@Override
	@SuppressWarnings({ "rawtypes"})	
	@doc("Cast a point (i.e. from x to y), a pair (i.e. from key to value), "
			+ "a list (i.e. from list[0] to list[1]) or a string into a GamaRange "
			+ "(i.e. spliting using \"->\", \":\", \";\", \"|\" or \" \")")
	public GamaRange cast(IScope scope, Object obj, Object param, boolean copy) {
		if (obj instanceof GamaRange) return (GamaRange) obj;
		if (obj instanceof GamaPoint) {
			GamaPoint p = (GamaPoint) obj;
			return new GamaRange(p.x,p.y);
		}
		if (obj instanceof GamaPair) {
			GamaPair p = (GamaPair) obj;
			return new GamaRange(Cast.asFloat(scope, p.key),Cast.asFloat(scope, p.value));
		}
		if (obj instanceof GamaList) {
			GamaList list = (GamaList) obj;
			if (list.size() == 2) {
				return new GamaRange(Cast.asFloat(scope, list.get(0)),Cast.asFloat(scope, list.get(1)));
			} 
			return null;
		}
		if (obj instanceof String) {
			for (String spliter : Arrays.asList("->",":",";","|"," ")) {
				String[] list = ((String) obj).split(spliter);
				if (list.length == 2) {
					return new GamaRange(Cast.asFloat(scope, list[0]),Cast.asFloat(scope, list[1]));
				}
			}
			return null;
		}
		return null;
	}

	@Override
	public GamaRange getDefault() {
		return null;
	}

}
