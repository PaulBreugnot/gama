package gama.common.ui;

public interface IApplicationControl {

	/**
	 * This is where the main UI of the application is created when a graphical interface is invoked: Display,
	 * workbench...and this is where the main loop of the UI is held as well. In a headless environment, this class
	 * plays the role of the main controller (i.e. the application is alive while this control has not returned from
	 * mainLoop())
	 *
	 * @param arguments
	 *            the arguments passed to the application
	 * @return either EXIT_OK or EXIT_RESTART (constants in IApplication)
	 */
	int mainLoop();

	/**
	 * Asks the UI/control to close. Optionnaly, if message is not null, it can be displayed if error is true or a
	 * confirmation can be asked if it is false.
	 *
	 * @param app
	 * @param error
	 * @param message
	 */
	void close(boolean error, String message);

	/**
	 * Returns the user interface available for this version of IApplicationControl. This IGui instance will become the
	 * de factor UI for all GAMA
	 */

	IGui getGui();
}