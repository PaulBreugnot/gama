package gama.ext.genstar.type;

import java.util.Random;

import core.util.random.GenstarRandom;
import gama.common.interfaces.IValue;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.getter;
import gama.core.dev.annotations.GamlAnnotations.variable;
import gama.core.dev.annotations.GamlAnnotations.vars;
import gama.runtime.IScope;
import gaml.types.IType;

@vars({ 
	@variable(name = "min_value", type = IType.FLOAT, doc = 	@doc("The lower bound of the range.")),
	@variable(name = "max_value", type = IType.FLOAT, doc = @doc("The upper bound of the range."))
	})
public class GamaRange implements IValue{

	Number min; 
	Number max;
	
	public GamaRange(Number min, Number max) {
		this.min = min;
		this.max = max;
	}

	@getter("min_value")
	public Number getMin() {
		return min.doubleValue();
	}

	@getter("max_value")
	public Number getMax() {
		return max.doubleValue();
	}
	
	@Override
	public String serialize(boolean includingBuiltIn) {
		return min +"->" +max;
	}

	@Override
	public String stringValue(IScope scope) {
		return serialize(true);
	}
	
	public String toString()  {
		return serialize(true);
	}

	@Override
	public IValue copy(IScope scope) {
		return new GamaRange(min, max);
	}
	
	@SuppressWarnings("rawtypes")
	public Object cast(IScope scope, IType type) {
		if(type == null) { return this; }
		
		if(type.id() == IType.INT) {
			return intValue();
		} 
		if(type.id() == IType.FLOAT) {
			return floatValue();
		}
		if(type.id() == IType.STRING) {
			return stringValue(scope);
		}
		return this;
	}

	// TODO : à raffiner ... 
	private double floatValue() {
		Random random = GenstarRandom.getInstance();
		return (max.doubleValue() - min.doubleValue() + 1) * random.nextDouble() + min.doubleValue();
	}

	private int intValue() {
		return (int) floatValue();
	}
}
