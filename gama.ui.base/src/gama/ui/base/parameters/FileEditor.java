/*******************************************************************************************************
 *
 * FileEditor.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.parameters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;

import gama.kernel.experiment.IParameter;
import gama.kernel.experiment.InputParameter;
import gama.metamodel.agent.IAgent;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gama.ui.base.controls.FlatButton;
import gama.ui.base.interfaces.EditorListener;
import gama.ui.base.resources.IGamaColors;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.file.GamaFolderFile;
import gama.util.file.IGamaFile;
import gaml.operators.Files;
import gaml.types.IType;
import gaml.types.Types;

/**
 * The Class FileEditor.
 */
@SuppressWarnings ({ "rawtypes", "unchecked" })
public class FileEditor extends AbstractEditor<IGamaFile> {

	/** The text box. */
	private FlatButton textBox;
	
	/** The is folder. */
	private final boolean isFolder;

	/**
	 * Instantiates a new file editor.
	 *
	 * @param scope the scope
	 * @param agent the agent
	 * @param param the param
	 * @param l the l
	 * @param isFolder the is folder
	 */
	FileEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener l,
			final boolean isFolder) {
		super(scope, agent, param, l);
		this.isFolder = isFolder;
	}

	/**
	 * Instantiates a new file editor.
	 *
	 * @param scope the scope
	 * @param parent the parent
	 * @param title the title
	 * @param value the value
	 * @param whenModified the when modified
	 * @param isFolder the is folder
	 */
	FileEditor(final IScope scope, final EditorsGroup parent, final String title, final String value,
			final EditorListener<IGamaFile> whenModified, final boolean isFolder) {
		// Convenience method
		super(scope, new InputParameter(title, value), whenModified);
		this.isFolder = isFolder;
		this.createControls(parent);
	}

	@Override
	public Control createCustomParameterControl(final Composite comp) {
		textBox = FlatButton.menu(comp, IGamaColors.NEUTRAL, "").light().small();
		textBox.setText("No " + (isFolder ? "folder" : "file"));
		textBox.addSelectionListener(this);
		return textBox;
	}

	@Override
	public void widgetSelected(final SelectionEvent e) {
		IGamaFile file = currentValue;
		String filter = file != null ? file.getPath(getScope()) : GAMA.getModel().getFilePath();
		if (isFolder) {
			final DirectoryDialog dialog = new DirectoryDialog(WorkbenchHelper.getDisplay().getActiveShell(), SWT.NULL);
			if (!(file instanceof GamaFolderFile)) { file = null; }
			dialog.setFilterPath(filter);
			dialog.setText("Choose a folder for parameter '" + param.getTitle() + "'");
			final String path = dialog.open();
			if (path != null) { file = Files.folderFile(getScope(), path, false); }
		} else {
			final FileDialog dialog = new FileDialog(WorkbenchHelper.getDisplay().getActiveShell(), SWT.NULL);
			dialog.setFileName(file != null ? file.getPath(getScope()) : GAMA.getModel().getFilePath());
			dialog.setText("Choose a file for parameter '" + param.getTitle() + "'");
			final String path = dialog.open();
			if (path != null) {
				file = Files.from(getScope(), path);

			}
		}
		modifyAndDisplayValue(file);
	}

	@Override
	protected void displayParameterValue() {
		internalModification = true;
		if (currentValue == null) {
			textBox.setText("No " + (isFolder ? "folder" : "file"));
		} else {
			final IGamaFile file = currentValue;
			String path;
			try {
				path = file.getPath(getScope());
			} catch (final GamaRuntimeException e) {
				path = file.getOriginalPath();
			}

			textBox.setToolTipText(path);
			textBox.setText(path);
		}
		internalModification = false;
	}

	@Override
	public IType getExpectedType() {
		return Types.FILE;
	}

	@Override
	protected void applyEdit() {
		widgetSelected(null);
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { EDIT, REVERT };
	}

}
