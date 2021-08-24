/*******************************************************************************************************
 *
 * Application.java, in gama.core.application, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.core.application;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.osgi.service.datalocation.Location;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IApplicationControlProvider;
import gama.core.application.bundles.GamaBundleLoader;
import gama.core.application.workspace.WorkspaceManager;
import gama.core.dev.utils.DEBUG;
import gama.runtime.concurrent.GamaExecutorService;
import gaml.operators.Dates;

/**
 * This class controls all aspects of the application's execution. AD Aug 2021. Now independent from the UI, controls
 * the lifecycle of GAMA.
 */
public class Application implements IApplication {

	/** The Constant UI. */
	private static final String UI = "ui";
	
	/** The Constant HEADLESS. */
	private static final String HEADLESS = "headless";
	{
		DEBUG.ON();
	}

	@Override
	public Object start(final IApplicationContext context) throws Exception {

		try {
			loadGamaCore();
			IApplicationControl ui = loadHeadlessOrUIControl();
			if ((ui == null) || !WorkspaceManager.checkWorkspace(ui)) return IApplication.EXIT_OK;
			return ui.mainLoop();
		} finally {
			final Location instanceLoc = Platform.getInstanceLocation();
			if (instanceLoc != null) { instanceLoc.release(); }
		}
	}

	/**
	 * Loads one of the UI extensions defined in the framework depending on the argument passed to the application.
	 *
	 * @return the i application control
	 * @throws CoreException the core exception
	 */
	private IApplicationControl loadHeadlessOrUIControl() throws CoreException {
		String[] args = Platform.getApplicationArgs();
		boolean isUI = true;
		for (String s : args) {
			if (("-" + HEADLESS).equals(s)) { isUI = false; }
		}
		Map<String, IConfigurationElement> providers = GamaBundleLoader.getApplicationControlImplementations();
		IConfigurationElement element = providers.get(isUI ? UI : HEADLESS);
		if (element == null) return null;
		IApplicationControlProvider provider = (IApplicationControlProvider) element.createExecutableExtension("class");
		if (provider == null) return null;
		return provider.get();
	}

	/**
	 * Load gama core.
	 */
	private void loadGamaCore() {
		try {
			GamaBundleLoader.preBuildContributions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GamaExecutorService.reset();
		Dates.initialize();
	}

	@Override
	public void stop() {}

}
