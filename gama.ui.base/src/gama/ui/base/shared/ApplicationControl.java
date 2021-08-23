package gama.ui.base.shared;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IGui;
import gama.ui.base.workbench.GamaWorkbenchAdvisor;

// @Component (
// immediate = true)
public class ApplicationControl implements IApplicationControl {
	private static ApplicationControl INSTANCE;

	public static IApplicationControl getInstance() {
		if (INSTANCE == null) { INSTANCE = new ApplicationControl(); }
		return INSTANCE;
	}

	final Display display;

	public ApplicationControl() {
		Display.setAppName("Gama Platform");
		Display.setAppVersion("1.8.2");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
			if (e instanceof OutOfMemoryError) {
				close(false, "GAMA is out of memory and will likely crash. Do you want to close now ?");
				e.printStackTrace();
			}

		});
		display = PlatformUI.createDisplay();
	}

	/**
	 * This is where the main UI of the application is created: Display, workbench...and this is where the main loop of
	 * the UI is held
	 *
	 * @return either EXIT_OK or EXIT_RESTART (constants in Application)
	 */
	@Override
	public int mainLoop() {

		try {
			final int returnCode = PlatformUI.createAndRunWorkbench(display, new GamaWorkbenchAdvisor());
			return returnCode == PlatformUI.RETURN_RESTART ? IApplication.EXIT_RESTART : IApplication.EXIT_OK;
		} finally {
			if (!display.isDisposed()) { display.dispose(); }
		}
	}

	/**
	 * Asks the UI to close. Optionnaly, if message is not null, it can be displayed if error is true or a confirmation
	 * can be asked if it is false.
	 *
	 * @param app
	 * @param error
	 * @param message
	 */
	@Override
	public void close(final boolean error, final String message) {
		if (message != null) {
			if (error) {
				getGui().error(message);
			} else if (!getGui().confirm("Closing GAMA", message)) {}
		}
	}

	@Override
	public IGui getGui() {
		return SwtGui.getInstance();
	}

}
