/*******************************************************************************************************
 *
 * OpenGLInitializer.java, in gama.display.opengl, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.opengl.view;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

import com.jogamp.common.util.JarUtil;
import com.jogamp.opengl.GLProfile;

import gama.core.dev.utils.DEBUG;

/**
 * The Class OpenGLInitializer.
 */
public class OpenGLInitializer extends AbstractServiceFactory implements gama.ui.base.interfaces.IOpenGLInitializer {

	/** The is initialized. */
	boolean isInitialized = false;

	@Override
	public void run() {
		// // Necessary to load the native libraries correctly (see
		// //
		// http://forum.jogamp.org/Return-of-the-quot-java-lang-UnsatisfiedLinkError-Can-t-load-library-System-Library-Frameworks-glueg-td4034549.html)

		if (!isInitialized) {
			JarUtil.setResolver(url -> {
				try {
					final URL urlUnescaped = FileLocator.resolve(url);
					final URL urlEscaped = new URI(urlUnescaped.getProtocol(), urlUnescaped.getPath(), null).toURL();
					return urlEscaped;
				} catch (final IOException ioexception) {
					return url;
				} catch (final URISyntaxException urisyntaxexception) {
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

	}

	@Override
	public boolean isDone() {
		return isInitialized;
	}

	@Override
	public Object create(final Class serviceInterface, final IServiceLocator parentLocator,
			final IServiceLocator locator) {
		return this;
	}

}
