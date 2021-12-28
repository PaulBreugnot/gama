/*******************************************************************************************************
 *
 * ExperimentParameter.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.kernel.experiment;

import static java.lang.Double.compare;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.locationtech.jts.util.NumberUtil;

import gama.common.interfaces.IKeyword;
import gama.common.util.StringUtils;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.metamodel.shape.GamaPoint;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.Collector;
import gama.util.GamaColor;
import gama.util.GamaDate;
import gama.util.GamaDateInterval;
import gaml.compilation.ISymbol;
import gaml.compilation.Symbol;
import gaml.compilation.annotations.validator;
import gaml.descriptions.ExperimentDescription;
import gaml.descriptions.IDescription;
import gaml.descriptions.IExpressionDescription;
import gaml.descriptions.ModelDescription;
import gaml.descriptions.VariableDescription;
import gaml.expressions.ConstantExpression;
import gaml.expressions.IExpression;
import gaml.factories.DescriptionFactory;
import gaml.operators.Cast;
import gaml.operators.Dates;
import gaml.statements.ActionStatement;
import gaml.statements.IExecutable;
import gaml.statements.IStatement;
import gaml.types.GamaDateType;
import gaml.types.IType;
import gaml.types.Types;
import gaml.variables.IVariable;
import gaml.variables.Variable;

// TODO: Auto-generated Javadoc
/**
 * The Class ExperimentParameter.
 */
@facets (
		value = { @facet (
				name = IKeyword.NAME,
				type = IType.LABEL,
				optional = true,
				doc = @doc ("The message displayed in the interface")),
				@facet (
						name = IKeyword.TYPE,
						type = IType.TYPE_ID,
						optional = true,
						doc = @doc ("the variable type")),
				@facet (
						name = IKeyword.INIT,
						type = IType.NONE,
						optional = true,
						doc = @doc ("the init value")),
				@facet (
						name = IKeyword.MIN,
						type = IType.NONE,
						optional = true,
						doc = @doc ("the minimum value")),
				@facet (
						name = IKeyword.MAX,
						type = IType.NONE,
						optional = true,
						doc = @doc ("the maximum value")),
				@facet (
						name = IKeyword.CATEGORY,
						type = IType.LABEL,
						optional = true,
						doc = @doc ("a category label, used to group parameters in the interface")),
				@facet (
						name = IKeyword.VAR,
						type = IType.ID,
						optional = false,
						doc = @doc ("the name of the variable (that should be declared in global)")),
				@facet (
						name = IKeyword.UNIT,
						type = IType.LABEL,
						optional = true,
						doc = @doc ("the variable unit")),
				@facet (
						name = IKeyword.ON_CHANGE,
						type = IType.NONE,
						optional = true,
						doc = @doc (
								// AD deprecation temporarily removed as this facet is used internally now
								// deprecated = "Move the block of statements at the end of the parameter declaration
								// instead",
								value = "Provides a block of statements that will be executed whenever the value of the parameter changes")),
				@facet (
						name = IKeyword.ENABLES,
						type = IType.LIST,
						optional = true,
						doc = @doc ("a list of global variables whose parameter editors will be enabled when this parameter value is set to true (they are otherwise disabled)")),
				@facet (
						name = IKeyword.DISABLES,
						type = IType.LIST,
						optional = true,
						doc = @doc ("a list of global variables whose parameter editors will be disabled when this parameter value is set to true (they are otherwise enabled)")),
				@facet (
						name = "slider",
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Whether or not to display a slider for entering an int or float value. Default is true when max and min values are defined, false otherwise. "
								+ "If no max or min value is defined, setting this facet to true will have no effect")),
				@facet (
						name = "colors",
						type = IType.LIST,
						of = IType.COLOR,
						optional = true,
						doc = @doc ("The colors of the control in the UI. An empty list has no effects. Only used for sliders and switches so far. For sliders, "
								+ "3 colors will allow to specify the color of the left section, the thumb and the right section (in this order); 2 colors will "
								+ "define the left and right sections only (thumb will be dark green); 1 color will define the left section and the thumb. "
								+ "For switches, 2 colors will define the background for respectively the left 'true' and right 'false' sections. 1 color will define both backgrounds")),
				@facet (
						name = IKeyword.STEP,
						type = IType.FLOAT,
						optional = true,
						doc = @doc ("the increment step (mainly used in batch mode to express the variation step between simulation)")),
				@facet (
						name = IKeyword.AMONG,
						type = IType.LIST,
						optional = true,
						doc = @doc ("the list of possible values")) },
		omissible = IKeyword.NAME)
@symbol (
		name = { IKeyword.PARAMETER },
		kind = ISymbolKind.PARAMETER,
		with_sequence = true,

		concept = { IConcept.EXPERIMENT, IConcept.PARAMETER })
@inside (
		kinds = { ISymbolKind.EXPERIMENT })
@validator (Variable.VarValidator.class)
@doc (
		value = "The parameter statement specifies which global attributes (i) will change through the successive simulations (in batch experiments), (ii) can be modified by user via the interface (in gui experiments). In GUI experiments, parameters are displayed depending on their type.",
		usages = { @usage (
				value = "In gui experiment, the general syntax is the following:",
				examples = { @example (
						value = "parameter title var: global_var category: cat;",
						isExecutable = false) }),
				@usage (
						value = "In batch experiment, the two following syntaxes can be used to describe the possible values of a parameter:",
						examples = { @example (
								value = "parameter 'Value of toto:' var: toto among: [1, 3, 7, 15, 100]; ",
								isExecutable = false),
								@example (
										value = "parameter 'Value of titi:' var: titi min: 1 max: 100 step: 2; ",
										isExecutable = false) }), })
@SuppressWarnings ({ "rawtypes" })
public class ExperimentParameter extends Symbol implements IParameter.Batch {

	/** The undefined. */
	static Object UNDEFINED = new Object();

	/** The value. */
	private Object value = UNDEFINED;

	/** The max value. */
	Object minValue, maxValue;

	/** The step value. */
	Object stepValue;

	/** The among value. */
	private List amongValue;

	/** The enables. */
	final private String[] disables, enables;

	/** The unit label. */
	String varName, title, category, unitLabel;

	/** The type. */
	IType type = Types.NO_TYPE;

	/** The is editable. */
	boolean isEditable;

	/** The can be null. */
	boolean canBeNull;

	/** The is defined. */
	boolean isDefined = true;

	/** The is experiment. */
	// if true, means the target of the parameter is a variable defined in experiment
	boolean isExperiment = false;

	/** The on change. */
	final IExpression init, among, min, max, step, slider, onChange;

	/** The listeners. */
	final List<ParameterChangeListener> listeners = new ArrayList<>();

	/** The action. */
	ActionStatement action;

	/**
	 * Instantiates a new experiment parameter.
	 *
	 * @param sd
	 *            the sd
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	public ExperimentParameter(final IDescription sd) throws GamaRuntimeException {
		super(sd);
		final VariableDescription desc = (VariableDescription) sd;
		setName(desc.getLitteral(IKeyword.VAR));
		type = desc.getGamlType();
		title = sd.getName();
		unitLabel = getLiteral(IKeyword.UNIT);

		min = getFacet(IKeyword.MIN);
		final IScope runtimeScope = GAMA.getRuntimeScope();
		if (min != null && min.isConst()) { getMinValue(runtimeScope); }
		max = getFacet(IKeyword.MAX);
		if (max != null && max.isConst()) { getMaxValue(runtimeScope); }
		step = getFacet(IKeyword.STEP);
		if (step != null && step.isConst()) { getStepValue(runtimeScope); }
		among = getFacet(IKeyword.AMONG);
		if (among != null && among.isConst()) { getAmongValue(runtimeScope); }
		onChange = getFacet(IKeyword.ON_CHANGE);
		if (onChange != null) {
			listeners.add((scope, v) -> {
				final IExecutable on_changer =
						scope.getAgent().getSpecies().getAction(Cast.asString(scope, onChange.value(scope)));
				scope.getExperiment().executeAction(on_changer);
			});

		}
		slider = getFacet("slider");
		final IExpressionDescription d = type.equals(Types.BOOL) ? getDescription().getFacet(IKeyword.DISABLES) : null;
		final IExpressionDescription e = type.equals(Types.BOOL) ? getDescription().getFacet(IKeyword.ENABLES) : null;
		disables = d != null ? d.getStrings(getDescription(), false).toArray(new String[0]) : EMPTY_STRINGS;
		enables = e != null ? e.getStrings(getDescription(), false).toArray(new String[0]) : EMPTY_STRINGS;
		final VariableDescription targetedGlobalVar = findTargetedVar(sd);
		init = hasFacet(IKeyword.INIT) ? getFacet(IKeyword.INIT) : targetedGlobalVar.getFacetExpr(IKeyword.INIT);
		isEditable = !targetedGlobalVar.isNotModifiable();
		isExperiment = targetedGlobalVar.isDefinedInExperiment();

		setCategory(desc.getLitteral(IKeyword.CATEGORY));
	}

	/**
	 * Find targeted var.
	 *
	 * @param parameterDescription
	 *            the parameter description
	 * @return the variable description
	 */
	private VariableDescription findTargetedVar(final IDescription parameterDescription) {
		// We look first in the model to make sure that built-in parameters (like seed) are correctly retrieved
		final ModelDescription wd = parameterDescription.getModelDescription();
		VariableDescription targetedGlobalVar = wd.getAttribute(varName);
		if (targetedGlobalVar == null) {
			final ExperimentDescription ed = (ExperimentDescription) parameterDescription.getEnclosingDescription();
			targetedGlobalVar = ed.getAttribute(varName);
			isExperiment = true;
		}
		return targetedGlobalVar;
	}

	/**
	 * Instantiates a new experiment parameter.
	 *
	 * @param scope
	 *            the scope
	 * @param p
	 *            the p
	 */
	public ExperimentParameter(final IScope scope, final IParameter p) {
		this(scope, p, p.getTitle(), p.getCategory(), p.getAmongValue(scope), false);
	}

	/**
	 * Instantiates a new experiment parameter.
	 *
	 * @param scope
	 *            the scope
	 * @param p
	 *            the p
	 * @param title
	 *            the title
	 * @param category
	 *            the category
	 * @param among
	 *            the among
	 * @param canBeNull
	 *            the can be null
	 */
	public ExperimentParameter(final IScope scope, final IParameter p, final String title, final String category,
			final List among, final boolean canBeNull) {
		this(scope, p, title, category, null, among, canBeNull);
	}

	/**
	 * Instantiates a new experiment parameter.
	 *
	 * @param scope
	 *            the scope
	 * @param p
	 *            the p
	 * @param title
	 *            the title
	 * @param category
	 *            the category
	 * @param unit
	 *            the unit
	 * @param among
	 *            the among
	 * @param canBeNull
	 *            the can be null
	 */
	public ExperimentParameter(final IScope scope, final IParameter p, final String title, final String category,
			final String unit, final List among, final boolean canBeNull) {
		super(null);
		this.slider = null;
		this.title = title;
		disables = EMPTY_STRINGS;
		enables = EMPTY_STRINGS;
		this.canBeNull = canBeNull;
		// this.order = p.getDefinitionOrder();
		this.amongValue = among;
		if (among != null) {
			this.among = new ConstantExpression(among);
		} else {
			this.among = null;
		}
		this.minValue = p.getMinValue(scope);
		if (minValue != null) {
			this.min = new ConstantExpression(minValue);
		} else {
			min = null;
		}
		this.maxValue = p.getMaxValue(scope);
		if (maxValue != null) {
			this.max = new ConstantExpression(maxValue);
		} else {
			max = null;
		}
		this.stepValue = p.getStepValue(scope);
		if (stepValue != null) {
			this.step = new ConstantExpression(stepValue);
		} else {
			step = null;
		}
		onChange = null;
		setName(p.getName());
		setCategory(category);
		setType(p.getType());
		if (p instanceof IVariable && getType().getGamlType().id() == IType.FILE) {
			init = ((IVariable) p).getFacet(IKeyword.INIT);
		} else {
			init = null;
			setValue(scope, p.getInitialValue(scope));
		}
		setEditable(p.isEditable());
		this.isExperiment = p.isDefinedInExperiment();
	}

	/**
	 * Sets the name.
	 *
	 * @param name2
	 *            the new name
	 */
	@Override
	public void setName(final String name2) {
		varName = name2;
		if (title == null) { title = name2; }
	}

	/**
	 * Gets the color.
	 *
	 * @param scope
	 *            the scope
	 * @return the color
	 */
	@Override
	public List<GamaColor> getColor(final IScope scope) {
		final IExpression exp = getFacet("colors");
		return exp == null ? null
				: (List<GamaColor>) Types.LIST.cast(scope, exp.value(scope), null, Types.INT, Types.COLOR, false);
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		super.dispose();
		listeners.clear();
	}

	/**
	 * Sets the type.
	 *
	 * @param iType
	 *            the new type
	 */
	private void setType(final IType iType) { type = iType; }

	/**
	 * Checks if is editable.
	 *
	 * @return true, if is editable
	 */
	@Override
	public boolean isEditable() { return isEditable; }

	/**
	 * Checks if is defined.
	 *
	 * @return true, if is defined
	 */
	@Override
	public boolean isDefined() { return isDefined; }

	/**
	 * Sets the defined.
	 *
	 * @param defined
	 *            the new defined
	 */
	@Override
	public void setDefined(final boolean defined) { isDefined = defined; }

	/**
	 * Sets the editable.
	 *
	 * @param editable
	 *            the new editable
	 */
	@Override
	public void setEditable(final boolean editable) { isEditable = editable; }

	/**
	 * Adds the changed listener.
	 *
	 * @param listener
	 *            the listener
	 */
	@Override
	public void addChangedListener(final ParameterChangeListener listener) {
		if (!listeners.contains(listener)) { listeners.add(listener); }
	}

	/**
	 * Verify min.
	 *
	 * @param newValue
	 *            the new value
	 * @return the object
	 */
	private Object verifyMin(final Object newValue) {
		if (minValue instanceof Number && newValue instanceof Number
				&& compare(((Number) minValue).doubleValue(), ((Number) newValue).doubleValue()) > 0
				|| minValue instanceof Comparable && newValue instanceof Comparable
						&& ((Comparable) minValue).compareTo(newValue) > 0)
			return minValue;
		return newValue;
	}

	/**
	 * Verify max.
	 *
	 * @param newValue
	 *            the new value
	 * @return the object
	 */
	private Object verifyMax(final Object newValue) {
		if (maxValue instanceof Number && newValue instanceof Number
				&& compare(((Number) maxValue).doubleValue(), ((Number) newValue).doubleValue()) < 0
				|| maxValue instanceof Comparable && newValue instanceof Comparable
						&& ((Comparable) maxValue).compareTo(newValue) < 0)
			return maxValue;
		return newValue;
	}

	/**
	 * Sets the and verify value.
	 *
	 * @param scope
	 *            the scope
	 * @param val
	 *            the val
	 */
	public void setAndVerifyValue(final IScope scope, final Object val) {
		Object newValue = verifyMin(verifyMax(val));
		newValue = filterWithAmong(scope, newValue);
		if (value != UNDEFINED) {
			for (final ParameterChangeListener listener : listeners) {
				listener.changed(scope, newValue);
			}
		}
		value = newValue;
	}

	/**
	 * Filter with among.
	 *
	 * @param scope
	 *            the scope
	 * @param newValue
	 *            the new value
	 * @return the object
	 */
	private Object filterWithAmong(final IScope scope, final Object newValue) {
		getAmongValue(scope);
		if (amongValue == null || amongValue.isEmpty()) return newValue;
		if (Types.FLOAT.equals(this.getType())) {
			final double newDouble = Cast.asFloat(scope, newValue);
			for (final Object o : amongValue) {
				final Double d = Cast.asFloat(scope, o);
				final Double tolerance = 0.0000001d;
				if (NumberUtil.equalsWithTolerance(d, newDouble, tolerance)) return d;
			}

		} else if (amongValue.contains(newValue)) return newValue;
		return amongValue.get(0);
	}

	/**
	 * Sets the value.
	 *
	 * @param scope
	 *            the scope
	 * @param val
	 *            the val
	 */
	@Override
	public void setValue(final IScope scope, final Object val) {
		if (val == UNDEFINED) {
			getAmongValue(scope);
			if (amongValue != null) {
				value = amongValue.get(scope.getRandom().between(0, amongValue.size() - 1));
			} else if (type.id() == IType.INT || type.id() == IType.FLOAT || type.id() == IType.POINT
					|| type.id() == IType.DATE) {
				value = drawRandomValue(scope);
			} else if (type.id() == IType.BOOL) {
				value = scope.getRandom().between(1, 100) > 50;
			} else {
				value = null;
			}
			return;
		}
		setAndVerifyValue(scope, val);
	}

	/**
	 * Reinit randomly.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void reinitRandomly(final IScope scope) {
		setValue(scope, UNDEFINED);
	}

	/**
	 * Try to init.
	 *
	 * @param scope
	 *            the scope
	 */
	public void tryToInit(final IScope scope) {
		if (value != UNDEFINED || init == null) return;
		setValue(scope, init.value(scope));

	}

	/**
	 * Draw random value.
	 *
	 * @param scope
	 *            the scope
	 * @return the comparable
	 */
	private Comparable drawRandomValue(final IScope scope) {
		switch (type.id()) {
			case IType.INT:
				final int iMin = minValue == null ? Integer.MIN_VALUE : Cast.asInt(scope, minValue);
				final int iMax = maxValue == null ? Integer.MAX_VALUE : Cast.asInt(scope, maxValue);
				final int iStep = stepValue == null ? 1 : Cast.asInt(scope, stepValue);
				return scope.getRandom().between(iMin, iMax, iStep);
			case IType.POINT:
				final GamaPoint pStep = stepValue == null ? new GamaPoint(1, 1, 1) : Cast.asPoint(scope, stepValue);
				final GamaPoint pMin =
						minValue == null ? new GamaPoint(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)
								: Cast.asPoint(scope, minValue);
				final GamaPoint pMax =
						maxValue == null ? new GamaPoint(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)
								: Cast.asPoint(scope, maxValue);
				return scope.getRandom().between(pMin, pMax, pStep);
			case IType.DATE:
				final double dStep =
						stepValue == null ? Dates.DATES_TIME_STEP.getValue() : Cast.asFloat(scope, stepValue);
				final GamaDate dMin =
						minValue == null ? GamaDate.of(LocalDateTime.now()).minus(Integer.MAX_VALUE, ChronoUnit.SECONDS)
								: GamaDateType.staticCast(scope, minValue, null, false);
				final GamaDate dMax =
						maxValue == null ? GamaDate.of(LocalDateTime.now()).plus(Integer.MAX_VALUE, ChronoUnit.SECONDS)
								: GamaDateType.staticCast(scope, maxValue, null, false);
				return new GamaDateInterval(dMin, dMax, Duration.of((long) dStep, ChronoUnit.SECONDS)).anyValue(scope);
			default:
				final double fStep = stepValue == null ? 1.0 : Cast.asFloat(scope, stepValue);
				final double fMin = minValue == null ? Double.MIN_VALUE : Cast.asFloat(scope, minValue);
				final double fMax = maxValue == null ? Double.MAX_VALUE : Cast.asFloat(scope, maxValue);
				return scope.getRandom().between(fMin, fMax, fStep);
		}
	}

	/**
	 * Neighbor values.
	 *
	 * @param scope
	 *            the scope
	 * @return the sets the
	 * @throws GamaRuntimeException
	 *             the gama runtime exception
	 */
	@Override
	// AD TODO Will not work with points and dates for the moment

	public Set<Object> neighborValues(final IScope scope) throws GamaRuntimeException {
		try (Collector.AsSet<Object> neighborValues = Collector.getSet()) {
			if (getAmongValue(scope) != null && !getAmongValue(scope).isEmpty()) {
				final int index = getAmongValue(scope).indexOf(this.value(scope));
				if (index > 0) { neighborValues.add(getAmongValue(scope).get(index - 1)); }
				if (index < getAmongValue(scope).size() - 1) {
					neighborValues.add(getAmongValue(scope).get(index + 1));
				}
				return neighborValues.items();
			}
			switch (type.id()) {
				case IType.INT:
					final int iMin = minValue == null ? Integer.MIN_VALUE : Cast.asInt(scope, minValue);
					final int iMax = maxValue == null ? Integer.MAX_VALUE : Cast.asInt(scope, maxValue);
					final int iStep = stepValue == null ? 1 : Cast.asInt(scope, stepValue);
					final int iVal = Cast.asInt(scope, value(scope));
					if (iVal >= iMin + iStep) { neighborValues.add(iVal - iStep); }
					if (iVal <= iMax - iStep) { neighborValues.add(iVal + iStep); }
					break;
				case IType.POINT:
					final GamaPoint pStep = stepValue == null ? new GamaPoint(1, 1, 1) : Cast.asPoint(scope, stepValue);
					final GamaPoint pMin =
							minValue == null ? new GamaPoint(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)
									: Cast.asPoint(scope, minValue);
					final GamaPoint pMax =
							maxValue == null ? new GamaPoint(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)
									: Cast.asPoint(scope, maxValue);
					final GamaPoint pVal = Cast.asPoint(scope, value(scope));
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							for (int k = -1; k <= 1; k++) {
								if (i == 0 && j == 0 && k == 0) { continue; }
								double x = pVal.x + i * pStep.x;
								double y = pVal.y + j * pStep.y;
								double z = pVal.z + k * pStep.z;
								int reset = 0;
								if (x < pMin.x || x > pMax.x) {
									x = pVal.x;
									reset++;
								}
								if (y < pMin.y || y > pMax.y) {
									y = pVal.y;
									reset++;
								}
								if (z < pMin.z || z > pMax.z) {
									z = pVal.z;
									reset++;
								}
								if (reset < 3) { neighborValues.add(new GamaPoint(x, y, z)); }
							}
						}
					}
					break;
				case IType.DATE:
					final double dStep =
							stepValue == null ? Dates.DATES_TIME_STEP.getValue() : Cast.asFloat(scope, stepValue);
					final GamaDate dMin = minValue == null
							? GamaDate.of(LocalDateTime.now()).minus(Integer.MAX_VALUE, ChronoUnit.SECONDS)
							: GamaDateType.staticCast(scope, minValue, null, false);
					final GamaDate dMax = maxValue == null
							? GamaDate.of(LocalDateTime.now()).plus(Integer.MAX_VALUE, ChronoUnit.SECONDS)
							: GamaDateType.staticCast(scope, maxValue, null, false);
					Duration dd = Duration.of((long) dStep, ChronoUnit.SECONDS);
					final GamaDate dVal = GamaDateType.staticCast(scope, value(scope), null, false);
					if (dVal.isGreaterThan(dMin.plus(dd), false)) { neighborValues.add(dVal.minus(dd)); }
					if (dVal.isSmallerThan(dMax.minus(dd), false)) { neighborValues.add(dVal.plus(dd)); }
					break;
				default:
					final double fStep = stepValue == null ? 1.0 : Cast.asFloat(scope, stepValue);
					final double fMin = minValue == null ? Double.MIN_VALUE : Cast.asFloat(scope, minValue);
					final double fMax = maxValue == null ? Double.MAX_VALUE : Cast.asFloat(scope, maxValue);
					final double fVal = Cast.asFloat(scope, value(scope));
					final double removeZ = Math.max(100000.0, 1.0 / fStep);
					if (fVal >= fMin + fStep) {
						final double valLow = Math.round((fVal - fStep) * removeZ) / removeZ;
						neighborValues.add(valLow);
					}
					if (fVal <= fMax - fStep) {
						final double valHigh = Math.round((fVal + fStep) * removeZ) / removeZ;
						neighborValues.add(valHigh);
					}
			}

			return neighborValues.items();
		}

	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() { return title; }

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() { return varName; }

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	@Override
	public String getCategory() { return category == null ? IParameter.Batch.super.getCategory() : category; }

	/**
	 * Sets the category.
	 *
	 * @param cat
	 *            the new category
	 */
	@Override
	public void setCategory(final String cat) { category = cat; }

	/**
	 * Value.
	 *
	 * @param scope
	 *            the scope
	 * @return the object
	 */
	@Override
	public Object value(final IScope scope) {
		return getValue(scope);
	}

	/**
	 * Value.
	 *
	 * @return the object
	 */
	@Override
	public Object value() {
		return GAMA.run(this::getValue);

	}

	/**
	 * Gets the initial value.
	 *
	 * @param scope
	 *            the scope
	 * @return the initial value
	 */
	@Override
	public Object getInitialValue(final IScope scope) {
		return getValue(scope);
	}

	/**
	 * Gets the min value.
	 *
	 * @param scope
	 *            the scope
	 * @return the min value
	 */
	@Override
	public Comparable getMinValue(final IScope scope) {
		if (minValue == null && min != null) { minValue = min.value(scope); }
		return (Comparable) minValue;
	}

	/**
	 * Gets the max value.
	 *
	 * @param scope
	 *            the scope
	 * @return the max value
	 */
	@Override
	public Comparable getMaxValue(final IScope scope) {
		if (maxValue == null && max != null) { maxValue = max.value(scope); }
		return (Comparable) maxValue;
	}

	/**
	 * Gets the among value.
	 *
	 * @param scope
	 *            the scope
	 * @return the among value
	 */
	@Override
	public List getAmongValue(final IScope scope) {
		if (amongValue == null && among != null) { amongValue = Cast.asList(scope, among.value(scope)); }
		return amongValue;
	}

	/**
	 * Gets the step value.
	 *
	 * @param scope
	 *            the scope
	 * @return the step value
	 */
	@Override
	public Comparable getStepValue(final IScope scope) {
		if (stepValue == null && step != null) { stepValue = step.value(scope); }
		return (Comparable) stepValue;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public IType getType() { return type; }

	/**
	 * Serialize.
	 *
	 * @param includingBuiltIn
	 *            the including built in
	 * @return the string
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		return GAMA.run(scope -> StringUtils.toGaml(getValue(scope), includingBuiltIn));

	}

	/**
	 * Sets the children.
	 *
	 * @param commands
	 *            the new children
	 */
	@Override
	public void setChildren(final Iterable<? extends ISymbol> commands) {
		final List<IStatement> statements = new ArrayList<>();
		for (final ISymbol c : commands) {
			if (c instanceof IStatement) { statements.add((IStatement) c); }
		}
		if (!statements.isEmpty()) {
			final IDescription d =
					DescriptionFactory.create(IKeyword.ACTION, getDescription(), IKeyword.NAME, "inline");
			action = new ActionStatement(d);
			action.setChildren(statements);
			listeners.add((scope, v) -> {
				scope.getExperiment().executeAction(action);
			});
		}
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Parameter '" + title + "' targets var " + varName;
	}

	/**
	 * Can be null.
	 *
	 * @return true, if successful
	 */
	public boolean canBeNull() {
		return canBeNull;
	}

	/**
	 * Can be explored.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean canBeExplored() {
		return among != null || min != null && max != null && step != null;
	}

	/**
	 * Gets the unit label.
	 *
	 * @param scope
	 *            the scope
	 * @return the unit label
	 */
	@Override
	public String getUnitLabel(final IScope scope) {
		if (unitLabel == null && canBeExplored()) return computeExplorableLabel(scope);
		return unitLabel;
	}

	/**
	 * Compute explorable label.
	 *
	 * @param scope
	 *            the scope
	 * @return the string
	 */
	private String computeExplorableLabel(final IScope scope) {
		final List l = getAmongValue(scope);
		if (l != null) return "among " + l;
		return "between " + getMinValue(scope) + " and " + getMaxValue(scope) + " every " + getStepValue(scope);
	}

	/**
	 * Sets the unit label.
	 *
	 * @param label
	 *            the new unit label
	 */
	@Override
	public void setUnitLabel(final String label) { unitLabel = label; }

	/**
	 * Gets the value.
	 *
	 * @param scope
	 *            the scope
	 * @return the value
	 */
	Object getValue(final IScope scope) {
		tryToInit(scope);
		return value;
	}

	/**
	 * Accepts slider.
	 *
	 * @param scope
	 *            the scope
	 * @return true, if successful
	 */
	@Override
	public boolean acceptsSlider(final IScope scope) {
		if (slider == null) return true;
		return Cast.asBool(scope, slider.value(scope));
	}

	/**
	 * Gets the enablement.
	 *
	 * @return the enablement
	 */
	@Override
	public String[] getEnablement() { return this.enables; }

	/**
	 * Gets the disablement.
	 *
	 * @return the disablement
	 */
	@Override
	public String[] getDisablement() { return this.disables; }

	/**
	 * Checks if is defined in experiment.
	 *
	 * @return true, if is defined in experiment
	 */
	@Override
	public boolean isDefinedInExperiment() { return isExperiment; }

}
