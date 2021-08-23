/*********************************************************************************************
 *
 * 'FloatEditor.java, in plugin ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and simulation
 * platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.interfaces.EditorListener;
import gaml.operators.Cast;
import gaml.types.IType;
import gaml.types.Types;

public class FloatEditor extends NumberEditor<Double> {

	FloatEditor(final IScope scope, final IAgent agent, final IParameter param, final boolean canBeNull,
			final EditorListener<Double> l) {
		super(scope, agent, param, l, canBeNull);
	}

	FloatEditor(final IScope scope, final EditorsGroup parent, final String title, final Double value, final Double min,
			final Double max, final Double step, final boolean canBeNull, final EditorListener<Double> whenModified) {
		// Convenience method
		super(scope, new InputParameter(title, value, min, max, step), whenModified, canBeNull);
		if (step != null) { stepValue = step; }
		this.createControls(parent);
	}

	@Override
	protected Double defaultStepValue() {
		return 0.1d;
	}

	@Override
	protected boolean modifyValue(final Object val) throws GamaRuntimeException {
		Double i = Cast.asFloat(getScope(), val);
		if (acceptNull && val == null) {
			i = null;
		} else {
			if (getMinValue() != null && i < Cast.asFloat(getScope(), getMinValue()))
				throw GamaRuntimeException.error("Value " + i + " should be greater than " + getMinValue(), getScope());
			if (getMaxValue() != null && i > Cast.asFloat(getScope(), getMaxValue()))
				throw GamaRuntimeException.error("Value " + i + " should be smaller than " + maxValue, getScope());
		}
		return super.modifyValue(i);

	}

	@Override
	protected Double normalizeValues() throws GamaRuntimeException {
		final Double valueToConsider = getOriginalValue() == null ? 0.0 : Cast.asFloat(getScope(), getOriginalValue());
		currentValue = getOriginalValue() == null ? null : valueToConsider;
		minValue = getMinValue() == null ? null : Cast.asFloat(getScope(), getMinValue());
		maxValue = maxValue == null ? null : Cast.asFloat(getScope(), getMaxValue());
		return valueToConsider;
	}

	@Override
	public IType<Double> getExpectedType() {
		return Types.FLOAT;
	}

	@Override
	protected Double applyPlus() {
		if (currentValue == null) return 0.0;
		final Double i = currentValue;
		return i + stepValue.doubleValue();
	}

	@Override
	protected Double applyMinus() {
		if (currentValue == null) return 0.0;
		final Double i = currentValue;
		return i - stepValue.doubleValue();
	}

	@Override
	protected void updateToolbar() {
		super.updateToolbar();
		editorToolbar.enable(PLUS,
				param.isDefined() && (getMaxValue() == null || applyPlus() < Cast.asFloat(getScope(), getMaxValue())));
		editorToolbar.enable(MINUS,
				param.isDefined() && (getMinValue() == null || applyMinus() > Cast.asFloat(getScope(), getMinValue())));
	}
}
