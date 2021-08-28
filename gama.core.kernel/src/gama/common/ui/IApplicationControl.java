/*******************************************************************************************************
 *
 * IApplicationControl.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.common.ui;

/**
 * The Interface IApplicationControl.
 */
public interface IApplicationControl {

	/**
	 * This is where the main UI of the application is created when a graphical interface is invoked: Display,
	 * workbench...and this is where the main loop of the UI is held as well. In a headless environment, this class
	 * plays the role of the main controller (i.e. the application is alive while this control has not returned from
	 * mainLoop())
	 *
	 * @return either EXIT_OK or EXIT_RESTART (constants in IApplication)
	 */
	int mainLoop();

	/**
	 * Asks the UI/control to close. Optionnaly, if message is not null, it can be displayed if error is true or a
	 * confirmation can be asked if it is false.
	 *
	 * @param error
	 *            the error
	 * @param message
	 *            the message
	 */
	void close(boolean error, String message);

	/**
	 * Returns the user interface available for this version of IApplicationControl. This IGui instance will become the
	 * de factor UI for all GAMA
	 *
	 * @return the gui
	 */

	IGui getGui();

	/**
	 * Provide a startup progress listener to plug into GAMA. Default does nothing
	 *
	 * @return the startup progress listener or null
	 */
	default IStartupProgress provideStartupProgress() {
		return new IStartupProgress.Null();
	}
}