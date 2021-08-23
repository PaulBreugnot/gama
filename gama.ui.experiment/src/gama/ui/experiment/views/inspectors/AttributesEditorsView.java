/*********************************************************************************************
 *
 * 'AttributesEditorsView.java, in plugin ummisco.gama.ui.experiment, is part of the source code of the GAMA modeling
 * and simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.experiment.views.inspectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;

import gama.ui.base.interfaces.IParameterEditor;
import gama.ui.base.parameters.AbstractEditor;
import gama.ui.base.parameters.EditorsGroup;
import gama.ui.base.views.ExpandableItemsView;
import gama.ui.experiment.parameters.EditorsList;

public abstract class AttributesEditorsView<T> extends ExpandableItemsView<T> {

	protected EditorsList<T> editors;

	@Override
	public String getItemDisplayName(final T obj, final String previousName) {
		if (editors == null) return "";
		return editors.getItemDisplayName(obj, previousName);
	}

	@SuppressWarnings ({ "rawtypes", "unchecked" })
	@Override
	protected Composite createItemContentsFor(final T data) {
		final Map<String, IParameterEditor<?>> parameters = editors.getCategories().get(data);
		final EditorsGroup compo = new EditorsGroup(getViewer());
		if (parameters != null) {
			final List<AbstractEditor> list = new ArrayList(parameters.values());
			Collections.sort(list);
			for (final AbstractEditor<?> gpParam : list) {
				gpParam.createControls(compo);
				if (!editors.isEnabled(gpParam)) { gpParam.setActive(false); }
			}
		}

		return compo;
	}

	@Override
	public void reset() {
		super.reset();
		editors = null;
	}

	@Override
	public void removeItem(final T obj) {
		if (editors == null) return;
		editors.removeItem(obj);
	}

	@Override
	public void pauseItem(final T obj) {
		if (editors == null) return;
		editors.pauseItem(obj);
	}

	@Override
	public void resumeItem(final T obj) {
		if (editors == null) return;
		editors.resumeItem(obj);
	}

	@Override
	public void focusItem(final T obj) {
		if (editors == null) return;
		editors.focusItem(obj);
	}

	@Override
	public List<T> getItems() {
		if (editors == null) return Collections.EMPTY_LIST;
		return editors.getItems();
	}

	@Override
	public void updateItemValues() {
		if (editors != null) { editors.updateItemValues(); }
	}

}
