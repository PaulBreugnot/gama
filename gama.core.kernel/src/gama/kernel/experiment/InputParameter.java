/*******************************************************************************************************
 *
 * InputParameter.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.kernel.experiment;

import java.util.List;

import gama.runtime.IScope;
import gama.util.GamaColor;
import gaml.types.GamaType;
import gaml.types.IType;

/**
 * The Class InputParameter.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class InputParameter extends ParameterAdapter {

	/** The value. */
	private Object value;
	
	/** The among. */
	private final List among;
	
	/** The max. */
	private Comparable min, max;
	
	/** The step. */
	private Comparable step;

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param value the value
	 */
	public InputParameter(final String name, final Object value) {
		this(name, value, GamaType.of(value));
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param value the value
	 * @param type the type
	 */
	public InputParameter(final String name, final Object value, final IType type) {
		this(name, value, type, null);
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param value the value
	 * @param type the type
	 * @param among the among
	 */
	public InputParameter(final String name, final Object value, final IType type, final List among) {
		super(name, type.id());
		this.value = value;
		this.among = among;
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param value the value
	 * @param min the min
	 * @param max the max
	 */
	public InputParameter(final String name, final Object value, final Comparable min, final Comparable max) {
		this(name, value);
		this.min = min;
		this.max = max;
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param value the value
	 * @param min the min
	 * @param max the max
	 * @param step the step
	 */
	public InputParameter(final String name, final Object value, final Comparable min, final Comparable max,
			final Comparable step) {
		this(name, value);
		this.min = min;
		this.max = max;
		this.step = step;
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name the name
	 * @param unit the unit
	 * @param value the value
	 * @param min the min
	 * @param max the max
	 * @param step the step
	 */
	public InputParameter(final String name, final String unit, final Object value, final Comparable min,
			final Comparable max, final Comparable step) {
		this(name, value, min, max);
		unitLabel = unit;
		this.step = step;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setValue(final IScope scope, final Object value) {
		this.value = value;
	}

	@Override
	public Comparable getMinValue(final IScope scope) {
		return min;
	}

	@Override
	public Comparable getMaxValue(final IScope scope) {
		return max;
	}

	@Override
	public List getAmongValue(final IScope scope) {
		return among;
	}

	@Override
	public Comparable getStepValue(final IScope scope) {
		return step;
	}

	@Override
	public Object value() {
		return value;
	}

	@Override
	public Object value(final IScope scope) {
		return value;
	}

	@Override
	public boolean isEditable() {
		return true;
	}

	@Override
	public List<GamaColor> getColor(final IScope scope) {
		return null;
	}

	@Override
	public boolean acceptsSlider(final IScope scope) {
		return true;
	}

}
