/*******************************************************************************************************
 *
 * InputParameter.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
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

// TODO: Auto-generated Javadoc
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
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	public InputParameter(final String name, final Object value) {
		this(name, value, GamaType.of(value));
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param type
	 *            the type
	 */
	public InputParameter(final String name, final Object value, final IType type) {
		this(name, value, type, null);
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param type
	 *            the type
	 * @param among
	 *            the among
	 */
	public InputParameter(final String name, final Object value, final IType type, final List among) {
		super(name, type.id());
		this.value = value;
		this.among = among;
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 */
	public InputParameter(final String name, final Object value, final Comparable min, final Comparable max) {
		this(name, value);
		this.min = min;
		this.max = max;
		clamps();
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 * @param step
	 *            the step
	 */
	public InputParameter(final String name, final Object value, final Comparable min, final Comparable max,
			final Comparable step) {
		this(name, value);
		this.min = min;
		this.max = max;
		clamps();
		this.step = step;
	}

	/**
	 * Instantiates a new input parameter.
	 *
	 * @param name
	 *            the name
	 * @param unit
	 *            the unit
	 * @param value
	 *            the value
	 * @param min
	 *            the min
	 * @param max
	 *            the max
	 * @param step
	 *            the step
	 */
	public InputParameter(final String name, final String unit, final Object value, final Comparable min,
			final Comparable max, final Comparable step) {
		this(name, value, min, max);
		unitLabel = unit;
		this.step = step;
	}

	/**
	 * Clamp value.
	 */
	private void clamps() {
		if (min.compareTo(max) > 0) { min = max; }
		if (min.compareTo(value) > 0) {
			value = min;
		} else if (max.compareTo(value) < 0) { value = max; }
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() { return title; }

	/**
	 * Sets the value.
	 *
	 * @param scope the scope
	 * @param value the value
	 */
	@Override
	public void setValue(final IScope scope, final Object value) {
		this.value = value;
	}

	/**
	 * Gets the min value.
	 *
	 * @param scope the scope
	 * @return the min value
	 */
	@Override
	public Comparable getMinValue(final IScope scope) {
		return min;
	}

	/**
	 * Gets the max value.
	 *
	 * @param scope the scope
	 * @return the max value
	 */
	@Override
	public Comparable getMaxValue(final IScope scope) {
		return max;
	}

	/**
	 * Gets the among value.
	 *
	 * @param scope the scope
	 * @return the among value
	 */
	@Override
	public List getAmongValue(final IScope scope) {
		return among;
	}

	/**
	 * Gets the step value.
	 *
	 * @param scope the scope
	 * @return the step value
	 */
	@Override
	public Comparable getStepValue(final IScope scope) {
		return step;
	}

	/**
	 * Value.
	 *
	 * @return the object
	 */
	@Override
	public Object value() {
		return value;
	}

	/**
	 * Value.
	 *
	 * @param scope the scope
	 * @return the object
	 */
	@Override
	public Object value(final IScope scope) {
		return value;
	}

	/**
	 * Checks if is editable.
	 *
	 * @return true, if is editable
	 */
	@Override
	public boolean isEditable() { return true; }

	/**
	 * Gets the color.
	 *
	 * @param scope the scope
	 * @return the color
	 */
	@Override
	public List<GamaColor> getColor(final IScope scope) {
		return null;
	}

	/**
	 * Accepts slider.
	 *
	 * @param scope the scope
	 * @return true, if successful
	 */
	@Override
	public boolean acceptsSlider(final IScope scope) {
		return true;
	}

}
