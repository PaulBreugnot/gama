/*******************************************************************************************************
 *
 * ConsoleDisplayerFactory.java, in gama.ui.experiment, is part of the source code of the GAMA modeling and simulation
 * platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.experiment.factories;

import java.util.ConcurrentModificationException;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import gama.common.ui.IConsoleDisplayer;
import gama.common.ui.IGamaView;
import gama.common.ui.IGamaView.Console;
import gama.common.ui.IGui;
import gama.kernel.experiment.ITopLevelAgent;
import gama.runtime.GAMA;
import gama.ui.base.utils.ViewsHelper;
import gama.ui.base.utils.WorkbenchHelper;
import gama.util.GamaColor;
import gaml.operators.Strings;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ConsoleDisplayer objects.
 */
public class ConsoleDisplayerFactory extends AbstractServiceFactory {

	/** The displayer. */
	IConsoleDisplayer displayer = new ConsoleDisplayer();

	/**
	 * The Class ConsoleDisplayer.
	 */
	static class ConsoleDisplayer implements IConsoleDisplayer {

		/** The console buffer. */
		private final StringBuilder consoleBuffer = new StringBuilder(2000);

		/**
		 * Debug console.
		 *
		 * @param cycle
		 *            the cycle
		 * @param msg
		 *            the msg
		 * @param root
		 *            the root
		 */
		@Override
		public void debugConsole(final int cycle, final String msg, final ITopLevelAgent root) {
			this.debugConsole(cycle, msg, root, null);
		}

		/**
		 * Debug console.
		 *
		 * @param cycle
		 *            the cycle
		 * @param msg
		 *            the msg
		 * @param root
		 *            the root
		 * @param color
		 *            the color
		 */
		@Override
		public void debugConsole(final int cycle, final String msg, final ITopLevelAgent root, final GamaColor color) {
			writeToConsole("(cycle : " + cycle + ") " + msg + Strings.LN, root, color);
		}

		/**
		 * Inform console.
		 *
		 * @param msg
		 *            the msg
		 * @param root
		 *            the root
		 */
		@Override
		public void informConsole(final String msg, final ITopLevelAgent root) {
			this.informConsole(msg, root, null);
		}

		/**
		 * Inform console.
		 *
		 * @param msg
		 *            the msg
		 * @param root
		 *            the root
		 * @param color
		 *            the color
		 */
		@Override
		public void informConsole(final String msg, final ITopLevelAgent root, final GamaColor color) {
			writeToConsole(msg + Strings.LN, root, color);
		}

		/**
		 * Write to console.
		 *
		 * @param msg
		 *            the msg
		 * @param root
		 *            the root
		 * @param color
		 *            the color
		 */
		private void writeToConsole(final String msg, final ITopLevelAgent root, final GamaColor color) {
			IGamaView.Console console = null;
			try {
				console = (Console) ViewsHelper.findView(IGui.CONSOLE_VIEW_ID, null, true);
			} catch (final ConcurrentModificationException e) {
				// See Issue #2812. With concurrent views opening, the view might be impossible to find
				// e.printStackTrace();
			}
			if (console != null) {
				console.append(msg, root, color);
			} else {
				consoleBuffer.append(msg);
			}
		}

		/**
		 * Erase console.
		 *
		 * @param setToNull
		 *            the set to null
		 */
		@Override
		public void eraseConsole(final boolean setToNull) {
			final IGamaView console = (IGamaView) ViewsHelper.findView(IGui.CONSOLE_VIEW_ID, null, false);
			if (console != null) { WorkbenchHelper.run(() -> console.reset()); }
			consoleBuffer.setLength(0);
		}

		/**
		 * Show console view.
		 *
		 * @param agent
		 *            the agent
		 */
		@Override
		public void showConsoleView(final ITopLevelAgent agent) {
			final IGamaView.Console icv = (Console) GAMA.getGui().showView(null, IGui.INTERACTIVE_CONSOLE_VIEW_ID, null,
					IWorkbenchPage.VIEW_VISIBLE);
			if (icv != null) { icv.append(null, agent, null); }
			final IGamaView.Console console =
					(Console) GAMA.getGui().showView(null, IGui.CONSOLE_VIEW_ID, null, IWorkbenchPage.VIEW_VISIBLE);
			if (consoleBuffer.length() > 0 && console != null) {
				console.append(consoleBuffer.toString(), agent, null);
				consoleBuffer.setLength(0);
			}

		}
	}

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
		return displayer;
	}

}
