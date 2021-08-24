/*******************************************************************************************************
 *
 * IDisplaySynchronizer.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.ui;

/**
 * A simple object that can synchronize the 3 threads in charge of the drawing of the displays: simulation thread
 * (simulation-view update mechanism), update thread, and rendering thread.
 *
 * @author drogoul
 */
public interface IDisplaySynchronizer {
	
	/**
	 * Allows any object calling this method to release the thread waiting for the scene to be rendered (called by the
	 * rendering processes or when this surface is disposed).
	 */
	void signalRenderingIsFinished();

	/**
	 * Makes any thread calling this method wait until either the scene is rendered or the surface is disposed.
	 */
	void waitForRenderingToBeFinished();

	/**
	 * Allows any object calling this method to release the thread waiting for the view to be updated.
	 */
	void authorizeViewUpdate();

	/**
	 * Makes any thread calling this method wait until can be updated.
	 */
	void waitForViewUpdateAuthorisation();

	/**
	 * Wait for surface to be realized.
	 */
	void waitForSurfaceToBeRealized();

	/**
	 * Signal surface is realized.
	 */
	void signalSurfaceIsRealized();

}
