/*******************************************************************************************************
 *
 * NewExperimentWizardPage.java, in gama.ui.navigator, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.navigator.wizards;

import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

// TODO: Auto-generated Javadoc
/**
 * The "New" wizard page allows setting the container for the new file as well as the file name. The page will only
 * accept file name without the extension OR with the extension that matches the expected one.
 */

public class NewExperimentWizardPage extends AbstractNewModelWizardPage {

	/** The model chooser. */
	Text modelChooser;

	/** The type of experiment. */
	String typeOfExperiment = AbstractNewModelWizard.GUI;

	/**
	 * Instantiates a new new experiment wizard page.
	 *
	 * @param selection
	 *            the selection
	 */
	public NewExperimentWizardPage(final ISelection selection) {
		super(selection);
		setTitle("Experiment file");
		setDescription("This wizard creates a new experiment file.");
	}

	/**
	 * Creates the control.
	 *
	 * @param parent the parent
	 */
	@Override
	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		createContainerSection(container);
		createLabel(container, "Model to experiment on:");
		final Composite rightSection = new Composite(container, SWT.NONE);
		applyGridData(rightSection, 2);
		final GridLayout layout = new GridLayout(2, false);
		rightSection.setLayout(layout);

		modelChooser = new Text(rightSection, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		modelChooser.setBackground(rightSection.getBackground());
		applyGridData(modelChooser, 1);
		modelChooser.addModifyListener(e -> dialogChanged());
		final Button button = new Button(rightSection, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				handleBrowse();
			}
		});
		createFileNameSection(container);
		createAuthorSection(container);
		createNameSection(container);
		/* Need to add empty label so the next two controls are pushed to the next line in the grid. */
		createLabel(container, "&Type of Experiment:");

		final Composite middleComposite = new Composite(container, SWT.NULL);
		final FillLayout fillLayout = new FillLayout();
		middleComposite.setLayout(fillLayout);
		applyGridData(middleComposite, 2);
		Arrays.asList(AbstractNewModelWizard.GUI, AbstractNewModelWizard.HEADLESS).forEach(s -> {
			final Button b = new Button(middleComposite, SWT.RADIO);
			b.setText(s);
			if (s.equals(AbstractNewModelWizard.GUI)) { b.setSelection(true); }
			b.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(final SelectionEvent e) {
					typeOfExperiment = ((Button) e.widget).getText();
					updateStatus(null);
					dialogChanged();
					setDescription(typeOfExperiment.equals(AbstractNewModelWizard.GUI)
							? "Creates a new experiment with a graphical user interface"
							: "Creates a new experiment intended to be used in headless runs");

				}

			});
		});

		/* Finished adding the custom control */
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Initialize.
	 */
	@Override
	protected void initialize() {
		super.initialize();
		modelChooser.setText("");
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	String getType() { return typeOfExperiment; }

	/** The dialog. */
	private FilteredResourcesSelectionDialog dialog;

	/**
	 * Uses the standard container selection dialog to choose the new value for the container field.
	 */
	void handleBrowse() {
		final IContainer p = ResourcesPlugin.getWorkspace().getRoot();
		dialog = new FilteredResourcesSelectionDialog(getShell(), false, p, IResource.FILE);
		dialog.setInitialPattern("*.gaml");
		dialog.setTitle("Choose a gaml model in project " + p.getName());
		if (dialog.open() == Window.OK) {
			final Object[] result = dialog.getResult();
			if (result.length == 1) {
				final IResource res = (IResource) result[0];
				modelChooser.setText(res.getFullPath().toString());
			}
		}
	}

	/**
	 * Gets the experimented model path.
	 *
	 * @return the experimented model path
	 */
	public String getExperimentedModelPath() { return modelChooser.getText(); }

	/**
	 * Gets the extension.
	 *
	 * @return the extension
	 */
	@Override
	public String getExtension() { return ".experiment"; }

	/**
	 * Gaml type.
	 *
	 * @return the string
	 */
	@Override
	public String gamlType() {
		return "Experiment";
	}

	/**
	 * Gets the template type.
	 *
	 * @return the template type
	 */
	@Override
	public String getTemplateType() { return AbstractNewModelWizard.EXPERIMENT; }

	/**
	 * Gets the template path.
	 *
	 * @return the template path
	 */
	@Override
	public String getTemplatePath() { return AbstractNewModelWizard.TEMPLATES.get(getTemplateType()); }

	/**
	 * Creates the doc.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean createDoc() {
		return false;
	}

}