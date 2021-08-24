/*******************************************************************************************************
 *
 * CreateExperimentSelectionListener.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.editor.toolbar;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

import gama.ui.base.menus.GamaMenu;
import gama.ui.base.toolbar.Selector;
import gama.ui.modeling.editor.GamlEditor;

/**
 * The class CreateExperimentSelectionListener.
 *
 * @author drogoul
 * @since 27 août 2016
 *
 */

@SuppressWarnings ("deprecation")
public class CreateExperimentSelectionListener implements Selector {

	/** The editor. */
	GamlEditor editor;
	
	/** The control. */
	Control control;

	/**
	 * Instantiates a new creates the experiment selection listener.
	 *
	 * @param editor the editor
	 * @param toolbar the toolbar
	 */
	public CreateExperimentSelectionListener(final GamlEditor editor, final Control toolbar) {
		this.editor = editor;
		this.control = toolbar;
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(final SelectionEvent e) {

		final GamaMenu menu = new GamaMenu() {

			@Override
			protected void fillMenu() {
				final String[] paths = { "Experiment.Gui.1", "Experiment.Batch.2", "Experiment.Batch.1" };
				for (final String path : paths) {
					final Template t = editor.getTemplateStore().getTemplateData(path).getTemplate();
					action(t.getDescription(), new SelectionAdapter() {

						@Override
						public void widgetSelected(final SelectionEvent e) {
							editor.applyTemplateAtTheEnd(t);
						}

					});
				}

			}
		};
		menu.open(control, e, 32);

	}

}
