/*******************************************************************************************************
 *
 * ExpandableItemsView.java, in gama.ui.base, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.base.views;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import gama.common.interfaces.ItemList;
import gama.ui.base.controls.ParameterExpandBar;
import gama.ui.base.controls.ParameterExpandItem;
import gama.ui.base.resources.GamaColors.GamaUIColor;
import gama.ui.base.toolbar.IToolbarDecoratedView;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpandableItemsView.
 *
 * @param <T>
 *            the generic type
 */
public abstract class ExpandableItemsView<T> extends GamaViewPart
		implements ItemList<T>, IToolbarDecoratedView.Expandable {

	/** The viewer. */
	private ParameterExpandBar viewer;

	/** The is open. */
	protected boolean isOpen = true;

	/**
	 * Gets the viewer.
	 *
	 * @return the viewer
	 */
	public ParameterExpandBar getViewer() { return viewer; }

	/**
	 * Creates the viewer.
	 *
	 * @param parent
	 *            the parent
	 */
	public void createViewer(final Composite parent) {
		if (parent == null) return;
		if (viewer == null) {
			viewer = new ParameterExpandBar(parent, SWT.V_SCROLL, areItemsClosable(), areItemsPausable(), false, false,
					this);
			final Object layout = parent.getLayout();
			if (layout instanceof GridLayout) {
				final var data = new GridData(SWT.FILL, SWT.FILL, true, true);
				viewer.setLayoutData(data);
			}
			// viewer.setBackground(!ThemeHelper.isDark() ? IGamaColors.WHITE.color() : IGamaColors.DARK_GRAY.darker());
			// viewer.computeSize(parent.getSize().x, SWT.DEFAULT);
			viewer.setSpacing(8);
		}
	}

	/**
	 * Are items closable.
	 *
	 * @return true, if successful
	 */
	protected boolean areItemsClosable() {
		return false;
	}

	/**
	 * Are items pausable.
	 *
	 * @return true, if successful
	 */
	protected boolean areItemsPausable() {
		return false;
	}

	/**
	 * Creates the item.
	 *
	 * @param parent
	 *            the parent
	 * @param data
	 *            the data
	 * @param control
	 *            the control
	 * @param expanded
	 *            the expanded
	 * @param color
	 *            the color
	 * @return the parameter expand item
	 */
	protected ParameterExpandItem createItem(final Composite parent, final T data, final Composite control,
			final boolean expanded, final GamaUIColor color) {
		return createItem(parent, getItemDisplayName(data, null), data, control, expanded, color);
	}

	/**
	 * Creates the item.
	 *
	 * @param parent
	 *            the parent
	 * @param name
	 *            the name
	 * @param data
	 *            the data
	 * @param control
	 *            the control
	 * @param bar
	 *            the bar
	 * @param expanded
	 *            the expanded
	 * @param color
	 *            the color
	 * @return the parameter expand item
	 */
	protected ParameterExpandItem createItem(final Composite parent, final String name, final T data,
			final Composite control, final ParameterExpandBar bar, final boolean expanded, final GamaUIColor color) {
		final var item = buildConcreteItem(bar, data, color);
		if (name != null) { item.setText(name); }
		control.pack(true);
		control.layout();
		item.setControl(control);
		item.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item.setExpanded(expanded);
		parent.layout(true, true);
		return item;
	}

	/**
	 * Builds the concrete item.
	 *
	 * @param bar
	 *            the bar
	 * @param data
	 *            the data
	 * @param color
	 *            the color
	 * @return the parameter expand item
	 */
	protected ParameterExpandItem buildConcreteItem(final ParameterExpandBar bar, final T data,
			final GamaUIColor color) {
		return new ParameterExpandItem(bar, data, SWT.None, color);
	}

	/**
	 * Creates the item.
	 *
	 * @param parent
	 *            the parent
	 * @param name
	 *            the name
	 * @param data
	 *            the data
	 * @param control
	 *            the control
	 * @param expanded
	 *            the expanded
	 * @param color
	 *            the color
	 * @return the parameter expand item
	 */
	protected ParameterExpandItem createItem(final Composite parent, final String name, final T data,
			final Composite control, final boolean expanded, final GamaUIColor color) {
		createViewer(parent);
		if (viewer == null) return null;
		return createItem(parent, name, data, control, viewer, expanded, color);
	}

	/**
	 * Creates the item.
	 *
	 * @param parent
	 *            the parent
	 * @param data
	 *            the data
	 * @param expanded
	 *            the expanded
	 * @param color
	 *            the color
	 * @return the parameter expand item
	 */
	protected ParameterExpandItem createItem(final Composite parent, final T data, final boolean expanded,
			final GamaUIColor color) {
		createViewer(parent);
		if (viewer == null) return null;
		final var control = createItemContentsFor(data);
		if (control == null) return null;
		return createItem(parent, data, control, expanded, color);
	}

	/**
	 * Creates the item contents for.
	 *
	 * @param data
	 *            the data
	 * @return the composite
	 */
	protected abstract Composite createItemContentsFor(T data);

	/**
	 * Dispose viewer.
	 */
	protected void disposeViewer() {
		try {
			if (viewer != null) {
				WorkbenchHelper.run(() -> viewer.dispose());
				viewer = null;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Widget disposed.
	 *
	 * @param e the e
	 */
	@Override
	public void widgetDisposed(final DisposeEvent e) {
		reset();
		isOpen = false;
		super.widgetDisposed(e);
	}

	/**
	 * Reset.
	 */
	@Override
	public void reset() {
		disposeViewer();
	}

	/**
	 * Sets the focus.
	 */
	@Override
	public void setFocus() {
		if (viewer != null) { viewer.setFocus(); }
	}

	/**
	 * Removes the item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void removeItem(final T obj) {}

	/**
	 * Pause item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void pauseItem(final T obj) {}

	/**
	 * Resume item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void resumeItem(final T obj) {}

	/**
	 * Focus item.
	 *
	 * @param obj the obj
	 */
	@Override
	public void focusItem(final T obj) {}

	/**
	 * Make item visible.
	 *
	 * @param obj the obj
	 * @param b the b
	 */
	@Override
	public void makeItemVisible(final T obj, final boolean b) {}

	/**
	 * Make item selectable.
	 *
	 * @param obj the obj
	 * @param b the b
	 */
	@Override
	public void makeItemSelectable(final T obj, final boolean b) {}

	/**
	 * Gets the item display name.
	 *
	 * @param obj the obj
	 * @param previousName the previous name
	 * @return the item display name
	 */
	@Override
	public String getItemDisplayName(final T obj, final String previousName) {
		return null;
	}

	/**
	 * Gets the item display color.
	 *
	 * @param o the o
	 * @return the item display color
	 */
	@Override
	public GamaColor getItemDisplayColor(final T o) {
		return null;
	}

	/**
	 * Display items.
	 */
	public void displayItems() {
		final var items = getItems();
		for (final T obj : items) {
			addItem(obj);
		}
	}

	/**
	 * Creates the update job.
	 *
	 * @return the gama UI job
	 */
	@Override
	protected GamaUIJob createUpdateJob() {
		return new GamaUIJob() {

			@Override
			protected UpdatePriority jobPriority() {
				return UpdatePriority.LOW;
			}

			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				if (!isOpen) return Status.CANCEL_STATUS;
				if (getViewer() != null && !getViewer().isDisposed()) {
					getViewer().updateItemNames();
					getViewer().updateItemColors();
					updateItemValues();
				}
				return Status.OK_STATUS;
			}
		};
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	@Override
	public abstract List<T> getItems();

	/**
	 * Update item values.
	 */
	@Override
	public abstract void updateItemValues();

	/**
	 * Collapse all.
	 */
	@Override
	public void collapseAll() {
		for (final ParameterExpandItem p : getViewer().getItems()) {
			p.setExpanded(false);
		}
	}

	/**
	 * Expand all.
	 */
	@Override
	public void expandAll() {
		for (final ParameterExpandItem p : getViewer().getItems()) {
			p.setExpanded(true);
		}
	}

}
