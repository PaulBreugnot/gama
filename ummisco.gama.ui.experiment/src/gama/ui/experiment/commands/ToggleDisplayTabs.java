package gama.ui.experiment.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import gama.ui.base.utils.PerspectiveHelper;
import gama.ui.base.utils.PerspectiveHelper.SimulationPerspectiveDescriptor;

public class ToggleDisplayTabs extends AbstractHandler {

	// NOT YET READY FOR PRIME TIME
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final SimulationPerspectiveDescriptor sd = PerspectiveHelper.getActiveSimulationPerspective();
		if (sd != null) {
			sd.keepTabs(!sd.keepTabs());
		}
		ArrangeDisplayViews
				.execute(new LayoutTreeConverter().convertCurrentLayout(ArrangeDisplayViews.listDisplayViews()));
		return this;
	}

}
