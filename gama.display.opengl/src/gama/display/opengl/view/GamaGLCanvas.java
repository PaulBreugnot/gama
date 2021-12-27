/*
 *
 */
package gama.display.opengl.view;

/*******************************************************************************************************
 *
 * GamaGLCanvas.java, in ummisco.gama.opengl, is part of the source code of the GAMA modeling and simulation platform
 * (v.1.8.2).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.jogamp.common.util.locks.RecursiveLock;
import com.jogamp.nativewindow.NativeSurface;
import com.jogamp.newt.Window;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.newt.swt.NewtCanvasSWT;
import com.jogamp.opengl.FPSCounter;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAnimatorControl;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLCapabilitiesImmutable;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLDrawable;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLRunnable;
import com.jogamp.opengl.swt.GLCanvas;

import gama.core.dev.utils.FLAGS;
import gama.display.opengl.renderer.IOpenGLRenderer;
import gama.runtime.PlatformHelper;
import gama.ui.bindings.IDelegateEventsToParent;

// TODO: Auto-generated Javadoc
/**
 * The Class GamaGLCanvas.
 */
public class GamaGLCanvas extends Composite implements GLAutoDrawable, IDelegateEventsToParent {

	/** The canvas. */
	final Control canvas;

	/** The drawable. */
	final GLAutoDrawable drawable;

	/** The detached. */
	protected boolean detached = false;

	/**
	 * Instantiates a new gama GL canvas.
	 *
	 * @param parent
	 *            the parent
	 * @param renderer
	 *            the renderer
	 */
	public GamaGLCanvas(final Composite parent, final IOpenGLRenderer renderer) {
		super(parent, SWT.NONE);
		parent.setLayout(new FillLayout());
		this.setLayout(new FillLayout());
		final GLCapabilities cap = defineCapabilities();
		if (FLAGS.USE_NATIVE_OPENGL_WINDOW) {
			drawable = GLWindow.create(cap);
			canvas = new NewtCanvasSWT(this, SWT.NONE, (Window) drawable);
			addControlListener(new ControlAdapter() {
				@Override
				public void controlResized(final ControlEvent e) {
					/* Detached views have not title! */
					if (PlatformHelper.isMac()) {
						boolean isDetached = parent.getShell().getText().length() == 0;
						if (isDetached) {
							if (!detached) {
								// DEBUG.OUT("detach");
								reparentWindow();
								detached = true;
							}

						} else if (detached) {
							// DEBUG.OUT("attach");
							reparentWindow();
							detached = false;
						}
					}
				}
			});
		} else {
			canvas = new GLCanvas(this, SWT.NONE, cap, null);
			drawable = (GLAutoDrawable) canvas;
		}
		drawable.setAutoSwapBufferMode(true);
		drawable.addGLEventListener(renderer);
		GLAnimatorControl animator = defineAnimator();
		renderer.setCanvas(this);
		addDisposeListener(e -> new Thread(() -> {
			animator.stop();
		}).start());
	}

	/**
	 * Define animator.
	 *
	 * @return the GL animator control
	 */
	private GLAnimatorControl defineAnimator() {
		GLAnimatorControl animator =
				FLAGS.USE_OLD_ANIMATOR ? new SingleThreadGLAnimator(drawable) : new MultithreadGLAnimator(drawable);
		animator.setUpdateFPSFrames(FPSCounter.DEFAULT_FRAMES_PER_INTERVAL, null);
		return animator;
	}

	/**
	 * Define capabilities.
	 *
	 * @return the GL capabilities
	 * @throws GLException
	 *             the GL exception
	 */
	private GLCapabilities defineCapabilities() throws GLException {
		final GLProfile profile = GLProfile.getDefault();
		final GLCapabilities cap = new GLCapabilities(profile);
		cap.setDepthBits(24);
		cap.setDoubleBuffered(true);
		cap.setHardwareAccelerated(true);
		cap.setSampleBuffers(true);
		cap.setAlphaBits(8);
		cap.setNumSamples(8);
		return cap;
	}

	/**
	 * Sets the realized.
	 *
	 * @param realized
	 *            the new realized
	 */
	@Override
	public void setRealized(final boolean realized) {
		drawable.setRealized(realized);
	}

	/**
	 * Checks if is realized.
	 *
	 * @return true, if is realized
	 */
	@Override
	public boolean isRealized() { return drawable.isRealized(); }

	/**
	 * Gets the surface width.
	 *
	 * @return the surface width
	 */
	@Override
	public int getSurfaceWidth() { return drawable.getSurfaceWidth(); }

	/**
	 * Gets the surface height.
	 *
	 * @return the surface height
	 */
	@Override
	public int getSurfaceHeight() { return drawable.getSurfaceHeight(); }

	/**
	 * Checks if is GL oriented.
	 *
	 * @return true, if is GL oriented
	 */
	@Override
	public boolean isGLOriented() { return drawable.isGLOriented(); }

	/**
	 * Swap buffers.
	 *
	 * @throws GLException
	 *             the GL exception
	 */
	@Override
	public void swapBuffers() throws GLException {
		drawable.swapBuffers();
	}

	/**
	 * Gets the chosen GL capabilities.
	 *
	 * @return the chosen GL capabilities
	 */
	@Override
	public GLCapabilitiesImmutable getChosenGLCapabilities() { return drawable.getChosenGLCapabilities(); }

	/**
	 * Gets the requested GL capabilities.
	 *
	 * @return the requested GL capabilities
	 */
	@Override
	public GLCapabilitiesImmutable getRequestedGLCapabilities() { return drawable.getRequestedGLCapabilities(); }

	/**
	 * Gets the GL profile.
	 *
	 * @return the GL profile
	 */
	@Override
	public GLProfile getGLProfile() { return drawable.getGLProfile(); }

	/**
	 * Gets the native surface.
	 *
	 * @return the native surface
	 */
	@Override
	public NativeSurface getNativeSurface() { return drawable.getNativeSurface(); }

	/**
	 * Gets the handle.
	 *
	 * @return the handle
	 */
	@Override
	public long getHandle() { return drawable.getHandle(); }

	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 */
	@Override
	public GLDrawableFactory getFactory() { return drawable.getFactory(); }

	/**
	 * Gets the delegated drawable.
	 *
	 * @return the delegated drawable
	 */
	@Override
	public GLDrawable getDelegatedDrawable() { return drawable.getDelegatedDrawable(); }

	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	@Override
	public GLContext getContext() { return drawable.getContext(); }

	/**
	 * Sets the context.
	 *
	 * @param newCtx
	 *            the new ctx
	 * @param destroyPrevCtx
	 *            the destroy prev ctx
	 * @return the GL context
	 */
	@Override
	public GLContext setContext(final GLContext newCtx, final boolean destroyPrevCtx) {
		return drawable.setContext(newCtx, destroyPrevCtx);
	}

	/**
	 * Adds the GL event listener.
	 *
	 * @param listener
	 *            the listener
	 */
	@Override
	public void addGLEventListener(final GLEventListener listener) {
		drawable.addGLEventListener(listener);
	}

	/**
	 * Adds the GL event listener.
	 *
	 * @param index
	 *            the index
	 * @param listener
	 *            the listener
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public void addGLEventListener(final int index, final GLEventListener listener) throws IndexOutOfBoundsException {
		drawable.addGLEventListener(index, listener);
	}

	/**
	 * Gets the GL event listener count.
	 *
	 * @return the GL event listener count
	 */
	@Override
	public int getGLEventListenerCount() { return drawable.getGLEventListenerCount(); }

	/**
	 * Are all GL event listener initialized.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean areAllGLEventListenerInitialized() {
		return drawable.areAllGLEventListenerInitialized();
	}

	/**
	 * Gets the GL event listener.
	 *
	 * @param index
	 *            the index
	 * @return the GL event listener
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public GLEventListener getGLEventListener(final int index) throws IndexOutOfBoundsException {
		return drawable.getGLEventListener(index);
	}

	/**
	 * Gets the GL event listener init state.
	 *
	 * @param listener
	 *            the listener
	 * @return the GL event listener init state
	 */
	@Override
	public boolean getGLEventListenerInitState(final GLEventListener listener) {
		return drawable.getGLEventListenerInitState(listener);
	}

	/**
	 * Sets the GL event listener init state.
	 *
	 * @param listener
	 *            the listener
	 * @param initialized
	 *            the initialized
	 */
	@Override
	public void setGLEventListenerInitState(final GLEventListener listener, final boolean initialized) {
		drawable.setGLEventListenerInitState(listener, initialized);
	}

	/**
	 * Dispose GL event listener.
	 *
	 * @param listener
	 *            the listener
	 * @param remove
	 *            the remove
	 * @return the GL event listener
	 */
	@Override
	public GLEventListener disposeGLEventListener(final GLEventListener listener, final boolean remove) {
		return drawable.disposeGLEventListener(listener, remove);
	}

	/**
	 * Removes the GL event listener.
	 *
	 * @param listener
	 *            the listener
	 * @return the GL event listener
	 */
	@Override
	public GLEventListener removeGLEventListener(final GLEventListener listener) {
		return drawable.removeGLEventListener(listener);
	}

	/**
	 * Sets the animator.
	 *
	 * @param animatorControl
	 *            the new animator
	 * @throws GLException
	 *             the GL exception
	 */
	@Override
	public void setAnimator(final GLAnimatorControl animatorControl) throws GLException {
		drawable.setAnimator(animatorControl);
	}

	/**
	 * Gets the animator.
	 *
	 * @return the animator
	 */
	@Override
	public GLAnimatorControl getAnimator() { return drawable.getAnimator(); }

	/**
	 * Sets the exclusive context thread.
	 *
	 * @param t
	 *            the t
	 * @return the thread
	 * @throws GLException
	 *             the GL exception
	 */
	@Override
	public Thread setExclusiveContextThread(final Thread t) throws GLException {
		return drawable.setExclusiveContextThread(t);
	}

	/**
	 * Gets the exclusive context thread.
	 *
	 * @return the exclusive context thread
	 */
	@Override
	public Thread getExclusiveContextThread() { return drawable.getExclusiveContextThread(); }

	/**
	 * Invoke.
	 *
	 * @param wait
	 *            the wait
	 * @param glRunnable
	 *            the gl runnable
	 * @return true, if successful
	 * @throws IllegalStateException
	 *             the illegal state exception
	 */
	@Override
	public boolean invoke(final boolean wait, final GLRunnable glRunnable) throws IllegalStateException {
		return drawable.invoke(wait, glRunnable);
	}

	/**
	 * Invoke.
	 *
	 * @param wait
	 *            the wait
	 * @param glRunnables
	 *            the gl runnables
	 * @return true, if successful
	 * @throws IllegalStateException
	 *             the illegal state exception
	 */
	@Override
	public boolean invoke(final boolean wait, final List<GLRunnable> glRunnables) throws IllegalStateException {
		return drawable.invoke(wait, glRunnables);
	}

	/**
	 * Flush GL runnables.
	 */
	@Override
	public void flushGLRunnables() {
		drawable.flushGLRunnables();
	}

	/**
	 * Destroy.
	 */
	@Override
	public void destroy() {
		drawable.destroy();
	}

	/**
	 * Display.
	 */
	@Override
	public void display() {
		drawable.display();
	}

	/**
	 * Sets the auto swap buffer mode.
	 *
	 * @param enable
	 *            the new auto swap buffer mode
	 */
	@Override
	public void setAutoSwapBufferMode(final boolean enable) {
		drawable.setAutoSwapBufferMode(enable);
	}

	/**
	 * Gets the auto swap buffer mode.
	 *
	 * @return the auto swap buffer mode
	 */
	@Override
	public boolean getAutoSwapBufferMode() { return drawable.getAutoSwapBufferMode(); }

	/**
	 * Sets the context creation flags.
	 *
	 * @param flags
	 *            the new context creation flags
	 */
	@Override
	public void setContextCreationFlags(final int flags) {
		drawable.setContextCreationFlags(flags);
	}

	/**
	 * Gets the context creation flags.
	 *
	 * @return the context creation flags
	 */
	@Override
	public int getContextCreationFlags() { return drawable.getContextCreationFlags(); }

	/**
	 * Creates the context.
	 *
	 * @param shareWith
	 *            the share with
	 * @return the GL context
	 */
	@Override
	public GLContext createContext(final GLContext shareWith) {
		return drawable.createContext(shareWith);
	}

	/**
	 * Gets the gl.
	 *
	 * @return the gl
	 */
	@Override
	public GL getGL() { return drawable.getGL(); }

	/**
	 * Sets the GL.
	 *
	 * @param gl
	 *            the gl
	 * @return the gl
	 */
	@Override
	public GL setGL(final GL gl) {
		return drawable.setGL(gl);
	}

	/**
	 * Gets the upstream widget.
	 *
	 * @return the upstream widget
	 */
	@Override
	public Object getUpstreamWidget() { return drawable.getUpstreamWidget(); }

	/**
	 * Gets the upstream lock.
	 *
	 * @return the upstream lock
	 */
	@Override
	public RecursiveLock getUpstreamLock() { return drawable.getUpstreamLock(); }

	/**
	 * Checks if is thread GL capable.
	 *
	 * @return true, if is thread GL capable
	 */
	@Override
	public boolean isThreadGLCapable() { return drawable.isThreadGLCapable(); }

	/**
	 * Gets the NEWT window.
	 *
	 * @return the NEWT window
	 */
	public Window getNEWTWindow() {
		if (FLAGS.USE_NATIVE_OPENGL_WINDOW) return (Window) drawable;
		return null;
	}

	/**
	 * Reparent window.
	 */
	public void reparentWindow() {
		if (!FLAGS.USE_NATIVE_OPENGL_WINDOW) return;
		Window w = (Window) drawable;
		w.setVisible(false);
		w.setFullscreen(true);
		w.setFullscreen(false);
		w.setVisible(true);
	}

	/**
	 * Sets the window visible.
	 *
	 * @param b
	 *            the new window visible
	 */
	public void setWindowVisible(final boolean b) {
		if (!FLAGS.USE_NATIVE_OPENGL_WINDOW) return;
		Window w = (Window) drawable;
		w.setVisible(b);
	}

	/**
	 * Sets the focus.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean setFocus() {
		return canvas.setFocus();
	}

}