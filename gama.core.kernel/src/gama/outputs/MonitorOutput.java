/*******************************************************************************************************
 *
 * MonitorOutput.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import gama.common.interfaces.IKeyword;
import gama.common.interfaces.ItemList;
import gama.common.ui.IGui;
import gama.common.util.FileUtils;
import gama.core.dev.annotations.IConcept;
import gama.core.dev.annotations.ISymbolKind;
import gama.core.dev.annotations.GamlAnnotations.doc;
import gama.core.dev.annotations.GamlAnnotations.example;
import gama.core.dev.annotations.GamlAnnotations.facet;
import gama.core.dev.annotations.GamlAnnotations.facets;
import gama.core.dev.annotations.GamlAnnotations.inside;
import gama.core.dev.annotations.GamlAnnotations.symbol;
import gama.core.dev.annotations.GamlAnnotations.usage;
import gama.kernel.experiment.ITopLevelAgent;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.util.GamaColor;
import gama.util.GamaListFactory;
import gama.util.file.csv.CsvWriter;
import gaml.descriptions.IDescription;
import gaml.expressions.IExpression;
import gaml.factories.DescriptionFactory;
import gaml.operators.Cast;
import gaml.operators.Files;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class MonitorOutput.
 *
 * @author drogoul
 */
@symbol (
		name = IKeyword.MONITOR,
		kind = ISymbolKind.OUTPUT,
		with_sequence = false,
		concept = { IConcept.MONITOR })
@facets (
		value = { @facet (
				name = IKeyword.NAME,
				type = IType.LABEL,
				optional = false,
				doc = @doc ("identifier of the monitor")),
				@facet (
						name = IKeyword.REFRESH_EVERY,
						type = IType.INT,
						optional = true,
						doc = @doc (
								value = "Allows to refresh the monitor every n time steps (default is 1)",
								deprecated = "Use refresh: every(n) instead")),
				@facet (
						name = IKeyword.COLOR,
						type = IType.COLOR,
						optional = true,
						doc = @doc ("Indicates the (possibly dynamic) color of this output (default is a light gray)")),
				@facet (
						name = IKeyword.REFRESH,
						type = IType.BOOL,
						optional = true,
						doc = @doc ("Indicates the condition under which this output should be refreshed (default is true)")),
				@facet (
						name = IKeyword.VALUE,
						type = IType.NONE,
						optional = false,
						doc = @doc ("expression that will be evaluated to be displayed in the monitor")) },
		omissible = IKeyword.NAME)
@inside (
		symbols = { IKeyword.OUTPUT, IKeyword.PERMANENT })
@doc (
		value = "A monitor allows to follow the value of an arbitrary expression in GAML.",
		usages = { @usage (
				value = "An example of use is:",
				examples = @example (
						value = "monitor \"nb preys\" value: length(prey as list) refresh_every: 5;  ",
						isExecutable = false)) })
public class MonitorOutput extends AbstractValuedDisplayOutput {
	
	/** The monitor folder. */
	private static String monitorFolder = "monitors";
	
	/** The color expression. */
	protected IExpression colorExpression = null;
	
	/** The color. */
	protected GamaColor color = null;
	
	/** The constant color. */
	protected GamaColor constantColor = null;
	
	/** The history. */
	protected List<Object> history;

	/**
	 * Instantiates a new monitor output.
	 *
	 * @param desc the desc
	 */
	public MonitorOutput(final IDescription desc) {
		super(desc);
		setColor(getFacet(IKeyword.COLOR));

	}

	/**
	 * Sets the color.
	 *
	 * @param facet the new color
	 */
	private void setColor(final IExpression facet) {
		colorExpression = facet;
		if (facet != null && facet.isConst()) {
			constantColor = Types.COLOR.cast(null, facet.getConstValue(), null, false);
		}
	}

	/**
	 * Instantiates a new monitor output.
	 *
	 * @param scope the scope
	 * @param name the name
	 * @param expr the expr
	 */
	public MonitorOutput(final IScope scope, final String name, final String expr) {
		super(DescriptionFactory.create(IKeyword.MONITOR, IKeyword.VALUE, expr, IKeyword.NAME,
				name == null ? expr : name));
		setScope(scope.copy("in monitor '" + expr + "'"));
		setNewExpressionText(expr);
		if (getScope().init(this).passed()) {
			getScope().getSimulation().addOutput(this);
			setPaused(false);
			open();
		}
	}

	@Override
	public String getViewId() {
		return IGui.MONITOR_VIEW_ID;
	}

	@Override
	public String getId() {
		return getViewId() + ":" + getName();
	}

	@Override
	public boolean init(final IScope scope) {
		super.init(scope);
		if (colorExpression == null) {
			final ITopLevelAgent sim = scope.getRoot();
			if (sim != null) { constantColor = sim.getColor(); }
		}
		return true;
	}

	@Override
	public boolean step(final IScope scope) {
		getScope().setCurrentSymbol(this);
		if (getScope().interrupted()) return false;
		if (getValue() != null) {
			try {
				lastValue = getValue().value(getScope());
				if (history != null) { history.add(lastValue); }
			} catch (final GamaRuntimeException e) {
				lastValue = ItemList.ERROR_CODE + e.getMessage();
			}
		} else {
			lastValue = null;
		}
		if (constantColor == null && colorExpression != null) {
			color = Cast.asColor(scope, colorExpression.value(scope));
		}
		return true;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public GamaColor getColor() {
		return constantColor == null ? color : constantColor;
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	@Override
	public String getName() {
		String result = super.getName();
		if (result == null) { result = getExpressionText(); }
		return result;
	}

	@Override
	protected void setValue(final IExpression value) {
		if (history != null) {
			history.clear();
			history = null;
		}
		super.setValue(value);
		if (value != null) {
			final IType<?> t = value.getGamlType();
			if (t.isNumber() || t.isContainer() && t.getContentType().isNumber()) {
				history = GamaListFactory.create(t);
			}
		}
	}

	/**
	 * Save history.
	 */
	public void saveHistory() {
		if (getScope() == null || history == null || history.isEmpty()) return;
		Files.newFolder(getScope(), monitorFolder);
		String file =
				monitorFolder + "/" + "monitor_" + getName() + "_cycle_" + getScope().getClock().getCycle() + ".csv";
		file = FileUtils.constructAbsoluteFilePath(getScope(), file, false);
		try (final BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				final CsvWriter w = new CsvWriter(bw, CsvWriter.Letters.COMMA)) {
			for (final Object o : history) {
				String[] strings = null;
				if (o instanceof Number) {
					strings = new String[] { o.toString() };
				} else if (o instanceof List) {
					final List<?> l = (List<?>) o;
					strings = new String[l.size()];
					for (int i = 0; i < strings.length; i++) {
						strings[i] = l.get(i).toString();
					}
				}
				w.writeRecord(strings);
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
