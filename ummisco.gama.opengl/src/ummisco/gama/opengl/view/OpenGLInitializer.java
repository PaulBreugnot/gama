/*******************************************************************************************************
 *
 * OpenGLInitializer.java, in ummisco.gama.opengl, is part of the source code of the GAMA modeling and simulation
 * platform (v.1.8.2).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package ummisco.gama.opengl.view;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import com.jogamp.common.util.JarUtil;
import com.jogamp.opengl.GLProfile;

import ummisco.gama.dev.utils.DEBUG;

/**
 * The Class OpenGLInitializer.
 */
public class OpenGLInitializer extends AbstractServiceFactory implements ummisco.gama.ui.interfaces.IOpenGLInitializer {

	static {
		DEBUG.ON();
	}

	/** The is initialized. */
	boolean isInitialized = false;

	@Override
	public void run() {
		// // Necessary to load the native libraries correctly (see
		// //
		// http://forum.jogamp.org/Return-of-the-quot-java-lang-UnsatisfiedLinkError-Can-t-load-library-System-Library-Frameworks-glueg-td4034549.html)
		DEBUG.TIMER(DEBUG.PAD("> GAMA: OpenGL", 45, ' ') + DEBUG.PAD(" loaded in", 15, '_'), () -> {
			if (!isInitialized) {

				JarUtil.setResolver(url -> {
					try {
						final URL urlUnescaped = FileLocator.resolve(url);
						return new URI(urlUnescaped.getProtocol(), urlUnescaped.getPath(), null).toURL();
					} catch (final IOException | URISyntaxException urisyntaxexception) {
						return url;
					}
				});
				isInitialized = true;
			}

			// Necessary to initialize very early because initializing it
			// while opening a Java2D view before leads to a deadlock
			try {
				GLProfile.initSingleton();
			} catch (Exception e1) {
				DEBUG.ERR("Impossible to initialize OpenGL", e1);
				return;
			}
			while (!GLProfile.isInitialized()) {
				try {
					Thread.sleep(100);
				} catch (final InterruptedException e) {
					DEBUG.ERR("Impossible to initialize OpenGL", e);
				}
			}
		});

	}

	@Override
	public boolean isDone() { return isInitialized; }

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
