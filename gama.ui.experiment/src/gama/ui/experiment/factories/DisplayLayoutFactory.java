/*******************************************************************************************************
 *
 * DisplayLayoutFactory.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.factories;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.ui.base.interfaces.IDisplayLayoutManager;
import gama.ui.base.utils.WorkbenchHelper;
import gama.ui.experiment.commands.ArrangeDisplayViews;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DisplayLayout objects.
 */
public class DisplayLayoutFactory extends AbstractServiceFactory implements IDisplayLayoutManager {

	/**
	 * Creates the.
	 *
	 * @param serviceInterface
	 *            the service interface
	 * @param parentLocator
	 *            the parent locator
	 * @param locator
	 *            the locator
	 * @return the object
	 */
	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

	/**
	 * Apply layout.
	 *
	 * @param layout
	 *            the layout
	 */
	@Override
	public void applyLayout(final Object layout) {
		// On macOS, the simple use of 'asyncRun' prevents java2D views to be displayed in mixed environments (e.g. "3
		// simulations" in Ant Foraging).
		WorkbenchHelper.runInUI("Arranging views", 0, m -> {
			// WorkbenchHelper.asyncRun( () -> {
			ArrangeDisplayViews.execute(layout);
		});
	}

}
