/*********************************************************************************************
 *
 * 'PopulationEditor.java, in plugin ummisco.gama.ui.shared, is part of the source code of the GAMA modeling and
 * simulation platform. (v. 1.8.1)
 *
 * (c) 2007-2020 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://github.com/gama-platform/gama for license information and developers contact.
 *
 *
 **********************************************************************************************/
package gama.ui.base.parameters;

import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import gama.kernel.experiment.IParameter;
import gama.metamodel.agent.IAgent;
import gama.metamodel.population.IPopulation;
import gama.outputs.ValuedDisplayOutputFactory;
import gama.runtime.IScope;
import gama.ui.base.interfaces.EditorListener;
import gama.util.IContainer;
import gaml.species.ISpecies;

@SuppressWarnings ({ "rawtypes", "unchecked" })
public class PopulationEditor extends AbstractEditor<IContainer> {

	Text populationDisplayer;

	PopulationEditor(final IScope scope, final IAgent agent, final IParameter param, final EditorListener l) {
		super(scope, agent, param, l);
	}

	@Override
	public Control createCustomParameterControl(final Composite compo) {
		populationDisplayer = new Text(compo, SWT.READ_ONLY);
		populationDisplayer.setEnabled(false);
		final GridData data = new GridData(GridData.FILL, GridData.CENTER, true, false);
		populationDisplayer.setLayoutData(data);
		return populationDisplayer;
	}

	@Override
	protected void displayParameterValue() {
		internalModification = true;
		final String s = currentValue instanceof IPopulation ? ((IPopulation) currentValue).getName()
				: currentValue == null ? "nil" : currentValue instanceof ISpecies
						? currentValue.getGamlType().toString() : currentValue.serialize(true);
		populationDisplayer.setText(s);
		populationDisplayer.setToolTipText(s);
		internalModification = false;
	}

	@Override
	protected void applyBrowse() {
		if (currentValue instanceof Collection) { ValuedDisplayOutputFactory.browse((Collection) currentValue); }
	}

	@Override
	protected int[] getToolItems() {
		return new int[] { BROWSE };
	}

}
