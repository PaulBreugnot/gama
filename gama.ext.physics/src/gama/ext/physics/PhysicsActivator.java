/*******************************************************************************************************
 *
 * PhysicsActivator.java, in gama.ext.physics, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.physics;

import static gama.core.dev.utils.DEBUG.ERR;
import static gama.core.dev.utils.DEBUG.PAD;
import static gama.core.dev.utils.DEBUG.TIMER_WITH_EXCEPTIONS;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.jme3.system.JmeSystem;
import com.jme3.system.Platform;

import gama.core.dev.utils.DEBUG;

/**
 * The Class PhysicsActivator.
 */
public class PhysicsActivator implements BundleActivator {

	static {
		DEBUG.ON();
	}

	/** The Constant LOAD_NATIVE_BULLET_LIBRARY. */
	public static final boolean LOAD_NATIVE_BULLET_LIBRARY = true;
	
	/** The native bullet library loaded. */
	public static boolean NATIVE_BULLET_LIBRARY_LOADED = false;
	
	/** The Constant NATIVE_LIBRARY_LOCATION. */
	public static final String NATIVE_LIBRARY_LOCATION = "/lib/native/";
	
	/** The Constant MAC_NATIVE_LIBRARY_NAME. */
	public static final String MAC_NATIVE_LIBRARY_NAME = "libbulletjme.dylib";
	
	/** The Constant WIN_NATIVE_LIBRARY_NAME. */
	public static final String WIN_NATIVE_LIBRARY_NAME = "bulletjme.dll";
	
	/** The Constant LIN_NATIVE_LIBRARY_NAME. */
	public static final String LIN_NATIVE_LIBRARY_NAME = "libbulletjme.so";

	/** The bundle. */
	static Bundle bundle;

	@Override
	public void start(final BundleContext context) throws Exception {
		bundle = context.getBundle();
	}

	/**
	 * Load library.
	 *
	 * @return true, if successful
	 */
	public static boolean loadLibrary() {
		if (!NATIVE_BULLET_LIBRARY_LOADED && LOAD_NATIVE_BULLET_LIBRARY) {
			TIMER_WITH_EXCEPTIONS(PAD("> GAMA: native Bullet library", 45, ' ') + DEBUG.PAD(" loaded in", 15, '_'),
					() -> {
						try {
							Platform platform = JmeSystem.getPlatform();
							String name;
							switch (platform) {
								case Windows64:
									name = WIN_NATIVE_LIBRARY_NAME;
									break;
								case Linux64:
									name = LIN_NATIVE_LIBRARY_NAME;
									break;
								case MacOSX64:
									name = MAC_NATIVE_LIBRARY_NAME;
									break;
								default:
									throw new RuntimeException("Platform " + platform + " is not supported");
							}

							NativeUtils.loadLibraryFromJar(NATIVE_LIBRARY_LOCATION + name);
							NATIVE_BULLET_LIBRARY_LOADED = true;
						} catch (Throwable e) {
							ERR(">> Impossible to load Bullet native library from " + bundle.getSymbolicName()
									+ " because " + e.getMessage());
							ERR(">> GAMA will fall back to JBullet instead");
						}
					});
		}
		return NATIVE_BULLET_LIBRARY_LOADED;

	}

	@Override
	public void stop(final BundleContext context) throws Exception {}

}
