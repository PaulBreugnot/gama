/*******************************************************************************************************
 *
 * GamaViewPart.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.views;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;

import gama.common.ui.IGamaView;
import gama.core.dev.utils.DEBUG;
import gama.kernel.experiment.ExperimentAgent;
import gama.kernel.experiment.IExperimentPlan;
import gama.kernel.simulation.SimulationAgent;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.outputs.IDisplayOutput;
import gama.outputs.IOutputManager;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.ui.base.controls.ITooltipDisplayer;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gama.ui.base.toolbar.GamaToolbar2;
import gama.ui.base.toolbar.GamaToolbarFactory;
import gama.ui.base.toolbar.IToolbarDecoratedView;
import gama.ui.base.utils.WorkbenchHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class GamaViewPart.
 *
 * @author drogoul
 */
public abstract class GamaViewPart extends ViewPart
		implements DisposeListener, IGamaView, IToolbarDecoratedView, ITooltipDisplayer {

	static {
		DEBUG.ON();
	}

	/** The outputs. */
	public final List<IDisplayOutput> outputs = new ArrayList<>();

	/** The parent. */
	private Composite parent;

	/** The toolbar. */
	protected GamaToolbar2 toolbar;

	/** The update job. */
	private GamaUIJob updateJob;

	/** The toolbar updater. */
	private StateListener toolbarUpdater;

	/** The root composite. */
	private Composite rootComposite;

	/**
	 * The Enum UpdatePriority.
	 */
	public enum UpdatePriority {

		/** The high. */
		HIGH,
		/** The low. */
		LOW,
		/** The highest. */
		HIGHEST,
		/** The lowest. */
		LOWEST;
	}

	/**
	 * The Class GamaUIJob.
	 */
	public abstract class GamaUIJob extends UIJob {

		/**
		 * Instantiates a new gama UI job.
		 */
		public GamaUIJob() {
			super("Updating " + getPartName());
			final UpdatePriority p = jobPriority();
			switch (p) {
				case HIGHEST:
					setPriority(INTERACTIVE);
					break;
				case LOWEST:
					setPriority(DECORATE);
					break;
				case HIGH:
					setPriority(SHORT);
					break;
				case LOW:
					setPriority(LONG);
					break;
			}
		}

		/**
		 * Job priority.
		 *
		 * @return the update priority
		 */
		protected abstract UpdatePriority jobPriority();

		/**
		 * Run synchronized.
		 */
		public void runSynchronized() {
			WorkbenchHelper.run(() -> runInUIThread(null));
		}

	}

	/**
	 * Reset.
	 */
	@Override
	public void reset() {}

	/**
	 * Adds the state listener.
	 *
	 * @param listener
	 *            the listener
	 */
	@Override
	public void addStateListener(final StateListener listener) {
		toolbarUpdater = listener;
	}

	/**
	 * Update toolbar state.
	 */
	@Override
	public void updateToolbarState() {
		if (toolbarUpdater != null) { toolbarUpdater.updateToReflectState(); }
		// if (toolbar != null && toolbar.isVisible()) { toolbar.visuallyUpdate(); }
	}

	/**
	 * Show toolbar.
	 */
	@Override
	public void showToolbar() {
		if (toolbar != null) { toolbar.show(); }
	}

	/**
	 * Hide toolbar.
	 */
	@Override
	public void hideToolbar() {
		if (toolbar != null) { toolbar.hide(); }
	}

	/**
	 * Creates the tool items.
	 *
	 * @param tb
	 *            the tb
	 */
	@Override
	public void createToolItems(final GamaToolbar2 tb) {
		this.toolbar = tb;
	}

	/**
	 * Inits the.
	 *
	 * @param site
	 *            the site
	 * @throws PartInitException
	 *             the part init exception
	 */
	@Override
	public void init(final IViewSite site) throws PartInitException {
		super.init(site);
		OutputPartsManager.install();
		String s_id = site.getSecondaryId();
		if (s_id != null) {
			final int i = s_id.indexOf("@@@");
			if (i != -1) { s_id = s_id.substring(0, i); }
		}
		final String id = site.getId() + (s_id == null ? "" : s_id);
		IDisplayOutput out = null;

		final IExperimentPlan experiment = GAMA.getExperiment();

		if (experiment != null) {
			for (final IOutputManager manager : concat(
					transform(GAMA.getControllers(), each -> each.getExperiment().getActiveOutputManagers()))) {
				out = (IDisplayOutput) manager.getOutputWithId(id);
				if (out != null) { break; }
			}

			// hqngh in case of micro-model
			if (out == null) {
				final SimulationAgent sim = GAMA.getExperiment().getCurrentSimulation();
				if (sim != null) {
					final String[] stemp = id.split("#");
					if (stemp.length > 1) {
						final IPopulation<? extends IAgent> externPop =
								sim.getExternMicroPopulationFor(stemp[1] + "." + stemp[2]);
						if (externPop != null) {
							for (final IAgent expAgent : externPop) {
								final SimulationAgent spec = ((ExperimentAgent) expAgent).getSimulation();
								if (spec != null) {
									final IOutputManager manager = spec.getOutputManager();
									if (manager != null) { out = (IDisplayOutput) manager.getOutputWithId(s_id); }
								}
							}
						}
					}
				}
			}
		} else if (shouldBeClosedWhenNoExperiments()) {
			WorkbenchHelper.asyncRun(() -> {
				if (shouldBeClosedWhenNoExperiments()) { close(GAMA.getRuntimeScope()); }
			});

		}
		addOutput(out);
	}

	/**
	 * Can be redefined by subclasses that accept that their instances remain open when no experiment is running.
	 *
	 * @return true, if successful
	 */
	protected boolean shouldBeClosedWhenNoExperiments() {
		return true;
	}

	/**
	 * Contains point.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return true, if successful
	 */
	public boolean containsPoint(final int x, final int y) {
		final Point o = rootComposite.toDisplay(0, 0);
		final Point s = rootComposite.getSize();
		return new Rectangle(o.x, o.y, s.x, s.y).contains(x, y);
	}

	/**
	 * Creates the part control.
	 *
	 * @param composite
	 *            the composite
	 */
	@Override
	public void createPartControl(final Composite composite) {
		this.rootComposite = composite;
		composite.addDisposeListener(this);
		if (needsOutput() && getOutput() == null) return;
		this.setParentComposite(GamaToolbarFactory.createToolbars(this, composite));
		ownCreatePartControl(getParentComposite());
		// activateContext();
		// toggle.run();
	}

	/**
	 * Needs output.
	 *
	 * @return true, if successful
	 */
	protected boolean needsOutput() {
		return true;
	}

	/**
	 * Own create part control.
	 *
	 * @param parent
	 *            the parent
	 */
	public abstract void ownCreatePartControl(Composite parent);

	/**
	 * Gets the update job.
	 *
	 * @return the update job
	 */
	protected final GamaUIJob getUpdateJob() {
		if (updateJob == null) { updateJob = createUpdateJob(); }
		return updateJob;
	}

	/**
	 * Creates the update job.
	 *
	 * @return the gama UI job
	 */
	protected abstract GamaUIJob createUpdateJob();

	/**
	 * Update.
	 *
	 * @param output
	 *            the output
	 */
	@Override
	public void update(final IDisplayOutput output) {
		final GamaUIJob job = getUpdateJob();
		if (job != null) {
			if (output.isSynchronized()) {
				job.runSynchronized();
			} else {
				job.schedule();
			}
		}
	}

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	@Override
	public IDisplayOutput getOutput() {
		if (outputs.isEmpty()) return null;
		return outputs.get(0);
	}

	/**
	 * Adds the output.
	 *
	 * @param out
	 *            the out
	 */
	@Override
	public void addOutput(final IDisplayOutput out) {
		if (out == null) return;
		if (!outputs.contains(out)) {
			outputs.add(out);
		} else if (toolbar != null) {
			toolbar.wipe(SWT.LEFT, true);
			toolbar.wipe(SWT.RIGHT, true);
			GamaToolbarFactory.buildToolbar(GamaViewPart.this, toolbar);
		}

	}

	/**
	 * Sets the focus.
	 */
	@Override
	public void setFocus() {}

	/**
	 * Widget disposed.
	 *
	 * @param e
	 *            the e
	 */
	@Override
	public void widgetDisposed(final DisposeEvent e) {
		toolbar = null;
		outputs.clear();
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		// DEBUG.OUT("+++ Part " + this.getPartName() + " is being disposed");
		toolbarUpdater = null;
		WorkbenchHelper.run(super::dispose);

	}

	/**
	 * Needs to be redefined for views that use the left toolbar (so that they maintain their previous state) Method
	 * stopDisplayingTooltips().
	 *
	 * @see gama.ui.base.controls.ITooltipDisplayer#stopDisplayingTooltips()
	 */
	@Override
	public void stopDisplayingTooltips() {
		if (toolbar == null || toolbar.isDisposed()) return;
		if (toolbar.hasTooltip()) { toolbar.wipe(SWT.LEFT, false); }
	}

	/**
	 * Display tooltip.
	 *
	 * @param text
	 *            the text
	 * @param color
	 *            the color
	 */
	@Override
	public void displayTooltip(final String text, final GamaUIColor color) {
		if (toolbar == null || toolbar.isDisposed()) return;
		toolbar.tooltip(text, color, SWT.LEFT);
	}

	/**
	 * Close.
	 *
	 * @param scope
	 *            the scope
	 */
	@Override
	public void close(final IScope scope) {
		DEBUG.OUT("Closing " + this.getPartName());
		WorkbenchHelper.asyncRun(() -> {
			try {
				WorkbenchHelper.hideView(GamaViewPart.this);
			} catch (final Exception e) {}
		});

	}

	/**
	 * Removes the output.
	 *
	 * @param output
	 *            the output
	 */
	@Override
	public void removeOutput(final IDisplayOutput output) {
		outputs.remove(output);
		if (outputs.isEmpty()) { close(output.getScope()); }
	}

	/**
	 * Change part name with simulation.
	 *
	 * @param agent
	 *            the agent
	 */
	@Override
	public void changePartNameWithSimulation(final SimulationAgent agent) {
		final String old = getPartName();
		final int first = old.lastIndexOf('(');
		final int second = old.lastIndexOf(')');
		if (first == -1) {
			if (agent.getPopulation().size() > 1) { setPartName(old + " (" + agent.getName() + ")"); }
		} else {

			setPartName(overlay(old, agent.getName(), first + 1, second));
		}
	}

	/**
	 * Overlay.
	 *
	 * @param str
	 *            the str
	 * @param over
	 *            the over
	 * @param s
	 *            the s
	 * @param e
	 *            the e
	 * @return the string
	 */
	// To avoid a dependency towards apache.commons.lang
	private String overlay(final String str, final String over, final int s, final int e) {
		String overlay = over;
		int start = s;
		int end = e;
		if (str == null) return null;
		if (overlay == null) { overlay = ""; }
		final int len = str.length();
		if (start < 0) { start = 0; }
		if (start > len) { start = len; }
		if (end < 0) { end = 0; }
		if (end > len) { end = len; }
		if (start > end) {
			final int temp = start;
			start = end;
			end = temp;
		}
		return new StringBuilder(len + start - end + overlay.length() + 1).append(str.substring(0, start))
				.append(overlay).append(str.substring(end)).toString();
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	@Override
	public void setName(final String name) {
		super.setPartName(name);

	}

	/**
	 * Gets the parent composite.
	 *
	 * @return the parent composite
	 */
	public Composite getParentComposite() { return parent; }

	/**
	 * Sets the parent composite.
	 *
	 * @param parent
	 *            the new parent composite
	 */
	public void setParentComposite(final Composite parent) { this.parent = parent; }

}
