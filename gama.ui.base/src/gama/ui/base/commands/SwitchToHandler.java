/*
 * 
 */
package gama.ui.base.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

// TODO: Auto-generated Javadoc
/**
 * The Class PerspectiveSwitchLock. Ancestor of the "perspective switch" commands, synchronized on the shared static
 * variable isRunning
 */
public abstract class SwitchToHandler extends AbstractHandler {

	/** The is locked. */
	private static boolean isRunning;

	/**
	 * Execute.
	 *
	 * @param event the event
	 * @return the object
	 * @throws ExecutionException the execution exception
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		if (isRunning) return false;
		try {
			isRunning = true;
			execute();
		} finally {
			isRunning = false;
		}
		return true;
	}

	/**
	 * Execute.
	 */
	protected abstract void execute();

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() { return super.isEnabled() && !isRunning; }

}