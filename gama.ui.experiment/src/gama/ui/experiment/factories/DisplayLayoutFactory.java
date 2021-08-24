/*******************************************************************************************************
 *
 * DisplayLayoutFactory.java, in gama.ui.experiment, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
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

/**
 * A factory for creating DisplayLayout objects.
 */
public class DisplayLayoutFactory extends AbstractServiceFactory implements IDisplayLayoutManager {

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

	@Override
	public void applyLayout(final Object layout) {
		// WorkbenchHelper.run(() -> {
		//
		// });

		WorkbenchHelper.runInUI("Arranging views", 0, (m) -> {
			// WorkbenchHelper.getPage().setEditorAreaVisible(showEditors);
			// if (showConsoles != null && !showConsoles) {
			// WorkbenchHelper.hideView(IGui.CONSOLE_VIEW_ID);
			// WorkbenchHelper.hideView(IGui.INTERACTIVE_CONSOLE_VIEW_ID);
			// }
			// if (showParameters != null && !showParameters) {
			// WorkbenchHelper.hideView(IGui.PARAMETER_VIEW_ID);
			// }
			// if (showNavigator != null && !showNavigator) {
			// WorkbenchHelper.hideView(IGui.NAVIGATOR_VIEW_ID);
			// }
			// if (showControls != null) {
			// WorkbenchHelper.getWindow().setCoolBarVisible(showControls);
			// }
			// if (keepTray != null) {
			// PerspectiveHelper.showBottomTray(WorkbenchHelper.getWindow(), keepTray);
			// }
			//
			// final SimulationPerspectiveDescriptor sd = PerspectiveHelper.getActiveSimulationPerspective();
			// if (sd != null) {
			// sd.keepTabs(keepTabs);
			// sd.keepToolbars(keepToolbars);
			// sd.keepControls(showControls);
			// sd.keepTray(keepTray);
			// }
			ArrangeDisplayViews.execute(layout);
		});

	}

}
