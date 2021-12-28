/*******************************************************************************************************
 *
 * ShowErrors.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.commands;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import gama.common.preferences.GamaPreferences;
import gama.runtime.GAMA;
import gama.ui.base.utils.ViewsHelper;
import gama.ui.experiment.views.ErrorView;

// TODO: Auto-generated Javadoc
/**
 * The Class ShowErrors.
 */
public class ShowErrors extends AbstractHandler implements IElementUpdater {

	/**
	 * Execute.
	 *
	 * @param event the event
	 * @return the object
	 * @throws ExecutionException the execution exception
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		GamaPreferences.Runtime.CORE_SHOW_ERRORS.set(!GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue());
		final ICommandService service =
				HandlerUtil.getActiveWorkbenchWindowChecked(event).getService(ICommandService.class);
		service.refreshElements(event.getCommand().getId(), null);
		if (GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue()) {
			GAMA.getGui().showView(null, ErrorView.ID, null, IWorkbenchPage.VIEW_VISIBLE);
		} else {
			ViewsHelper.hideView(ErrorView.ID);
		}
		return null;
	}

	/**
	 * Update element.
	 *
	 * @param element the element
	 * @param parameters the parameters
	 */
	@Override
	public void updateElement(final UIElement element, final Map parameters) {
		element.setChecked(GamaPreferences.Runtime.CORE_SHOW_ERRORS.getValue());
	}

}
