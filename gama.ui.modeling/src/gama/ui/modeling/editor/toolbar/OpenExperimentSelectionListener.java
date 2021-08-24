/*******************************************************************************************************
 *
 * OpenExperimentSelectionListener.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.editor.toolbar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.SelectionEvent;

import gama.common.preferences.GamaPreferences;
import gama.runtime.GAMA;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.controls.FlatButton;
import gama.ui.base.interfaces.IModelRunner;
import gama.ui.base.utils.WorkbenchHelper;
import gama.ui.modeling.editor.GamlEditor;
import gama.ui.modeling.editor.GamlEditorState;
import gama.ui.base.toolbar.Selector;

/**
 * The class CreateExperimentSelectionListener.
 *
 * @author drogoul
 * @since 27 août 2016
 *
 */
public class OpenExperimentSelectionListener implements Selector {

	/** The editor. */
	GamlEditor editor;
	
	/** The state. */
	GamlEditorState state;
	
	/** The runner. */
	final IModelRunner runner;

	/**
	 *  
	 *
	 * @param editor the editor
	 * @param state the state
	 * @param runner the runner
	 */
	public OpenExperimentSelectionListener(final GamlEditor editor, final GamlEditorState state,
			final IModelRunner runner) {
		this.editor = editor;
		this.state = state;
		this.runner = runner;
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(final SelectionEvent e) {

		// final IGui gui = GAMA.getRegularGui();
		// We refuse to run if there is no XtextGui available.
		editor.doSave(null);
		if (GamaPreferences.Modeling.EDITOR_SAVE.getValue()) {
			WorkbenchHelper.getPage().saveAllEditors(GamaPreferences.Modeling.EDITOR_SAVE_ASK.getValue());
		}
		String name = (String) ((FlatButton) e.widget).getData("exp");
		final int i = state.abbreviations.indexOf(name);
		if (i == -1) { return; }
		name = state.experiments.get(i);
		runner.runModel(editor.getDocument(), name);

	}

	/**
	 * Goto editor.
	 *
	 * @param exception the exception
	 */
	void gotoEditor(final GamaRuntimeException exception) {
		final EObject o = exception.getEditorContext();
		if (o != null) {
			WorkbenchHelper.asyncRun(() -> GAMA.getGui().editModel(null, o));
		}

	}

}
