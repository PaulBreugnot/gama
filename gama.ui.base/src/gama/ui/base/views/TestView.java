/*******************************************************************************************************
 *
 * TestView.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.views;

import static gama.common.preferences.GamaPreferences.Runtime.FAILED_TESTS;
import static gama.common.preferences.GamaPreferences.Runtime.TESTS_SORTED;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;

import com.google.common.primitives.Ints;

import gama.common.interfaces.ItemList;
import gama.common.preferences.GamaPreferences;
import gama.common.ui.IGamaView;
import gama.common.ui.IGui;
import gama.runtime.GAMA;
import gama.ui.base.controls.ParameterExpandItem;
import gama.ui.base.parameters.AssertEditor;
import gama.ui.base.parameters.EditorsGroup;
import gama.ui.base.resources.GamaColors;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.toolbar.GamaToolbar2;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;
import gaml.statements.test.AbstractSummary;
import gaml.statements.test.CompoundSummary;
import gaml.statements.test.TestExperimentSummary;
import gaml.statements.test.TestState;

// TODO: Auto-generated Javadoc
/**
 * The Class TestView.
 */
public class TestView extends ExpandableItemsView<AbstractSummary<?>> implements IGamaView.Test {

	/** The Constant BY_ORDER. */
	static final Comparator<AbstractSummary<?>> BY_ORDER = (o1, o2) -> Ints.compare(o1.getIndex(), o2.getIndex());

	/** The Constant BY_SEVERITY. */
	static final Comparator<AbstractSummary<?>> BY_SEVERITY = (o1, o2) -> {
		final TestState s1 = o1.getState();
		final TestState s2 = o2.getState();
		if (s1 == s2) return BY_ORDER.compare(o1, o2);
		return s1.compareTo(s2);
	};

	/** The experiments. */
	public final List<AbstractSummary<?>> experiments = new ArrayList<>();

	/** The running all tests. */
	private boolean runningAllTests;

	/** The id. */
	public static String ID = IGui.TEST_VIEW_ID;

	/**
	 * Inits the.
	 *
	 * @param site the site
	 * @throws PartInitException the part init exception
	 */
	@Override
	public void init(final IViewSite site) throws PartInitException {
		super.init(site);
		// if (!SwtGui.ALL_TESTS_RUNNING) {
		experiments.clear();
		super.reset();
		// }
	}

	/**
	 * Are items closable.
	 *
	 * @return true, if successful
	 */
	@Override
	protected boolean areItemsClosable() {
		return false;
	}

	/**
	 * Resort tests.
	 */
	protected void resortTests() {
		final Comparator<AbstractSummary<?>> comp = TESTS_SORTED.getValue() ? BY_SEVERITY : BY_ORDER;
		experiments.sort(comp);
	}

	/**
	 * Start new test sequence.
	 *
	 * @param all the all
	 */
	@Override
	public void startNewTestSequence(final boolean all) {
		runningAllTests = all;
		experiments.clear();
		WorkbenchHelper.run(() -> {
			if (toolbar != null) {
				toolbar.status(null, "Run experiment to see the tests results", e -> {
					GAMA.startFrontmostExperiment();
				}, IGamaColors.BLUE, SWT.LEFT);
			}
		});
		super.reset();
	}

	/**
	 * Finish test sequence.
	 */
	@Override
	public void finishTestSequence() {
		super.reset();
		reset();
	}

	/**
	 * Adds the test result.
	 *
	 * @param summary the summary
	 */
	@Override
	public void addTestResult(final CompoundSummary<?, ?> summary) {
		if (summary instanceof TestExperimentSummary) {
			if (!experiments.contains(summary)) { experiments.add(summary); }
		} else {
			for (final AbstractSummary<?> s : summary.getSummaries().values()) {
				if (!experiments.contains(s)) { experiments.add(s); }
			}
		}
	}

	/**
	 * Adds the item.
	 *
	 * @param experiment the experiment
	 * @return true, if successful
	 */
	@Override
	public boolean addItem(final AbstractSummary<?> experiment) {
		final boolean onlyFailed = GamaPreferences.Runtime.FAILED_TESTS.getValue();
		ParameterExpandItem item = getViewer() == null ? null : getViewer().getItem(experiment);
		if (item != null) { item.dispose(); }
		if (onlyFailed) {
			final TestState state = experiment.getState();
			if (state != TestState.FAILED && state != TestState.ABORTED) return false;
		}
		item = createItem(getParentComposite(), experiment, !runningAllTests,
				GamaColors.get(getItemDisplayColor(experiment)));
		return true;
	}

	/**
	 * Own create part control.
	 *
	 * @param view the view
	 */
	@Override
	public void ownCreatePartControl(final Composite view) {
		// view.setBackground(IGamaColors.WHITE.color());
	}

	/**
	 * Creates the item.
	 *
	 * @param parent the parent
	 * @param data the data
	 * @param expanded the expanded
	 * @param color the color
	 * @return the parameter expand item
	 */
	// Experimental: creates a deferred item
	@Override
	protected ParameterExpandItem createItem(final Composite parent, final AbstractSummary<?> data,
			final boolean expanded, final GamaUIColor color) {
		createViewer(parent);
		if (getViewer() == null) return null;
		final EditorsGroup control = createItemContentsFor(data);
		ParameterExpandItem item;
		if (expanded) {
			createEditors(control, data);
			item = createItem(parent, data, control, expanded, color);
		} else {
			item = createItem(parent, data, control, expanded, color);
			item.onExpand(() -> createEditors(control, data));
		}
		return item;
	}

	/**
	 * Creates the item contents for.
	 *
	 * @param experiment the experiment
	 * @return the editors group
	 */
	@Override
	protected EditorsGroup createItemContentsFor(final AbstractSummary<?> experiment) {
		final EditorsGroup compo = new EditorsGroup(getViewer());
		compo.setBackground(getViewer().getBackground());
		return compo;
	}

	/**
	 * Creates the editors.
	 *
	 * @param compo
	 *            the compo
	 * @param test
	 *            the test
	 */
	public void createEditors(final EditorsGroup compo, final AbstractSummary<?> test) {
		Map<String, ? extends AbstractSummary<?>> assertions = test.getSummaries();
		for (final Map.Entry<String, ? extends AbstractSummary<?>> assertion : assertions.entrySet()) {
			final AbstractSummary<?> summary = assertion.getValue();
			final String name = assertion.getKey();
			createEditor(compo, test, summary, name);
			if (summary instanceof CompoundSummary) {
				assertions = summary.getSummaries();
				for (final Map.Entry<String, ? extends AbstractSummary<?>> aa : assertions.entrySet()) {
					createEditor(compo, test, aa.getValue(), aa.getKey());
				}
			}
		}
	}

	/**
	 * Creates the editor.
	 *
	 * @param compo
	 *            the compo
	 * @param globalTest
	 *            the global test
	 * @param subTest
	 *            the sub test
	 * @param name
	 *            the name
	 */
	public void createEditor(final EditorsGroup compo, final AbstractSummary<?> globalTest,
			final AbstractSummary<?> subTest, final String name) {
		if (GamaPreferences.Runtime.FAILED_TESTS.getValue()) {
			final TestState state = subTest.getState();
			if (state != TestState.FAILED && state != TestState.ABORTED) return;
		}
		final AssertEditor ed = new AssertEditor(GAMA.getRuntimeScope(), subTest);
		ed.createControls(compo);
	}

	/**
	 * Creates the tool items.
	 *
	 * @param tb the tb
	 */
	@SuppressWarnings ("synthetic-access")
	@Override
	public void createToolItems(final GamaToolbar2 tb) {
		super.createToolItems(tb);
		TESTS_SORTED.removeChangeListeners();
		FAILED_TESTS.removeChangeListeners();
		final ToolItem t = tb.check(GamaIcons.create("test.sort2").getCode(), "Sort by severity",
				"When checked, sort the tests by their decreasing state severity (i.e. errored > failed > warning > passed > not run). Otherwise they are sorted by their order of execution.",
				e -> {
					TESTS_SORTED.set(!TESTS_SORTED.getValue());
					TestView.super.reset();
					reset();
				}, SWT.RIGHT);
		t.setSelection(TESTS_SORTED.getValue());
		TESTS_SORTED.onChange(v -> t.setSelection(v));

		final ToolItem t2 = tb.check(GamaIcons.create("test.filter2").getCode(), "Filter tests",
				"When checked, show only errored and failed tests and assertions", e -> {
					FAILED_TESTS.set(!FAILED_TESTS.getValue());
					TestView.super.reset();
					reset();
				}, SWT.RIGHT);
		t2.setSelection(FAILED_TESTS.getValue());
		FAILED_TESTS.onChange(v -> t2.setSelection(v));

	}

	/**
	 * Sets the focus.
	 */
	@Override
	public void setFocus() {}

	/**
	 * Removes the item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void removeItem(final AbstractSummary<?> obj) {}

	/**
	 * Pause item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void pauseItem(final AbstractSummary<?> obj) {}

	/**
	 * Resume item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void resumeItem(final AbstractSummary<?> obj) {}

	/**
	 * Gets the item display name.
	 *
	 * @param obj the obj
	 * @param previousName the previous name
	 * @return the item display name
	 */
	@Override
	public String getItemDisplayName(final AbstractSummary<?> obj, final String previousName) {
		final StringBuilder sb = new StringBuilder(300);
		final String name = obj.getTitle();
		sb.append(obj.getState()).append(ItemList.SEPARATION_CODE).append(name).append(" ");
		return sb.toString();
	}

	/**
	 * Should be closed when no experiments.
	 *
	 * @return true, if successful
	 */
	@Override
	protected boolean shouldBeClosedWhenNoExperiments() {
		return !runningAllTests;
	}

	/**
	 * Gets the item display color.
	 *
	 * @param t the t
	 * @return the item display color
	 */
	@Override
	public GamaColor getItemDisplayColor(final AbstractSummary<?> t) {
		return t.getColor();
	}

	/**
	 * Focus item.
	 *
	 * @param data the data
	 */
	@Override
	public void focusItem(final AbstractSummary<?> data) {}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	@Override
	public List<AbstractSummary<?>> getItems() { return experiments; }

	/**
	 * Update item values.
	 */
	@Override
	public void updateItemValues() {}

	/**
	 * Reset.
	 */
	@Override
	public void reset() {
		WorkbenchHelper.run(() -> {
			if (!getParentComposite().isDisposed()) {
				resortTests();
				displayItems();
				getParentComposite().layout(true, false);
				if (toolbar != null) {
					toolbar.status(null, new CompoundSummary<>(experiments).getStringSummary(), null, IGamaColors.BLUE,
							SWT.LEFT);
				}
			}
		});

	}

	/**
	 * Method handleMenu().
	 *
	 * @param item the item
	 * @param x the x
	 * @param y the y
	 * @return the map
	 * @see gama.common.interfaces.ItemList#handleMenu(java.lang.Object)
	 */
	@Override
	public Map<String, Runnable> handleMenu(final AbstractSummary<?> item, final int x, final int y) {
		final Map<String, Runnable> result = new HashMap<>();
		result.put("Copy summary to clipboard", () -> {
			WorkbenchHelper.copy(item.toString());
		});
		result.put("Show in editor", () -> GAMA.getGui().editModel(null, item.getURI()));
		return result;
	}

	/**
	 * Needs output.
	 *
	 * @return true, if successful
	 */
	@Override
	protected boolean needsOutput() {
		return false;
	}

	/**
	 * Display progress.
	 *
	 * @param number the number
	 * @param total the total
	 */
	@Override
	public void displayProgress(final int number, final int total) {
		WorkbenchHelper.asyncRun(() -> {
			if (toolbar != null) {
				toolbar.status(null, "Executing test models: " + number + " on " + total, null, IGamaColors.NEUTRAL,
						SWT.LEFT);
			}
		});

	}

}
