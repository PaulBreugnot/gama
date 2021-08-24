/*******************************************************************************************************
 *
 * PlatformHelper.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
/*******************************************************************************
 * Copyright (c) 2007-2008 SAS Institute Inc., ILOG S.A. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: SAS Institute Inc. - initial API and implementation ILOG S.A. - initial API and implementation IBM
 * Corporation - Java/SWT versioning code (from org.eclipse.swt.internal.Library)
 *******************************************************************************/
package gama.ui.base.utils;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.internal.DPIUtil;

/**
 * The Class PlatformHelper.
 */
public class PlatformHelper {

	/** The platform string. */
	private static String platformString = SWT.getPlatform();
	
	/** The is windows. */
	private static boolean isWindows = "win32".equals(platformString);
	
	/** The is mac. */
	private static boolean isMac = "cocoa".equals(platformString) || "carbon".equals(platformString);
	
	/** The is linux. */
	private static boolean isLinux = "gtk".equals(platformString);
	
	/** The is hi DPI. */
	private static boolean isHiDPI = DPIUtil.getDeviceZoom() > 100;

	/** The is developer. */
	private static Boolean isDeveloper;

	/**
	 * Instantiates a new platform helper.
	 */
	private PlatformHelper() {}

	/**
	 * Checks if is hi DPI.
	 *
	 * @return true, if is hi DPI
	 */
	public static boolean isHiDPI() {
		return isHiDPI;
	}

	/**
	 * Checks if is windows.
	 *
	 * @return true, if is windows
	 */
	public static boolean isWindows() {
		return isWindows;
	}

	/**
	 * Checks if is linux.
	 *
	 * @return true, if is linux
	 */
	public static boolean isLinux() {
		return isLinux;
	}

	/**
	 * Checks if is mac.
	 *
	 * @return true, if is mac
	 */
	public static boolean isMac() {
		return isMac;
	}

	/**
	 * Checks if is developer.
	 *
	 * @return true, if is developer
	 */
	public static boolean isDeveloper() { // NO_UCD (unused code)
		if (isDeveloper == null) {
			isDeveloper = Platform.getInstallLocation() == null
					|| Platform.getInstallLocation().getURL().getPath().contains("org.eclipse.pde.core");
		}
		return isDeveloper;
	}

	/**
	 * Gets the device zoom.
	 *
	 * @return the device zoom
	 */
	public static int getDeviceZoom() {
		return DPIUtil.getDeviceZoom();
	}

	/**
	 * Returns SWT auto scaled-up value {@code v}, compatible with {@link DPIUtil#autoScaleUp(int)}
	 * <p>
	 * We need to keep track of SWT's implementation in this regard!
	 * </p>.
	 *
	 * @param v the v
	 * @return the int
	 */
	public static int autoScaleUp(final int v) {
		// Temp !
		// if (true) return v;
		final int deviceZoom = DPIUtil.getDeviceZoom();
		if (100 == deviceZoom || DPIUtil.useCairoAutoScale()) return v;
		final float scaleFactor = deviceZoom / 100f;
		return Math.round(v * scaleFactor);
	}

	/**
	 * Auto scale up.
	 *
	 * @param v the v
	 * @return the double
	 */
	public static double autoScaleUp(final double v) {
		final int deviceZoom = DPIUtil.getDeviceZoom();
		if (100 == deviceZoom || DPIUtil.useCairoAutoScale()) return v;
		final double scaleFactor = deviceZoom / 100d;
		return v * scaleFactor;
	}

	/**
	 * Returns SWT auto scaled-down value {@code v}, compatible with {@link DPIUtil#autoScaleDown(int)}
	 * <p>
	 * We need to keep track of SWT's implementation in this regard!
	 * </p>.
	 *
	 * @param v the v
	 * @return the int
	 */
	public static int autoScaleDown(final int v) {
		// Temp !
		// if (true) return v;
		final int deviceZoom = DPIUtil.getDeviceZoom();
		if (100 == deviceZoom || DPIUtil.useCairoAutoScale()) return v;
		final float scaleFactor = deviceZoom / 100f;
		return Math.round(v / scaleFactor);
	}

	/**
	 * Auto scale down.
	 *
	 * @param v the v
	 * @return the double
	 */
	public static double autoScaleDown(final double v) {
		// Temp !
		// if (true) return v;
		final int deviceZoom = DPIUtil.getDeviceZoom();
		if (100 == deviceZoom || DPIUtil.useCairoAutoScale()) return v;
		final double scaleFactor = deviceZoom / 100d;
		return v / scaleFactor;
	}

	/** The JAVA version. */
	public static final int JAVA_VERSION; // NO_UCD (unused code)
	static {
		JAVA_VERSION = parseVersion(System.getProperty("java.version")); //$NON-NLS-1$
	}

	/**
	 * Parses the version.
	 *
	 * @param version the version
	 * @return the int
	 */
	static int parseVersion(final String version) {
		if (version == null) return 0;
		int major = 0, minor = 0, micro = 0;
		final int length = version.length();
		int index = 0, start = 0;
		while (index < length && Character.isDigit(version.charAt(index))) {
			index++;
		}
		try {
			if (start < length) { major = Integer.parseInt(version.substring(start, index)); }
		} catch (final NumberFormatException e) {}
		start = ++index;
		while (index < length && Character.isDigit(version.charAt(index))) {
			index++;
		}
		try {
			if (start < length) { minor = Integer.parseInt(version.substring(start, index)); }
		} catch (final NumberFormatException e) {}
		start = ++index;
		while (index < length && Character.isDigit(version.charAt(index))) {
			index++;
		}
		try {
			if (start < length) { micro = Integer.parseInt(version.substring(start, index)); }
		} catch (final NumberFormatException e) {}
		return javaVersion(major, minor, micro);
	}

	/**
	 * Returns the Java version number as an integer.
	 *
	 * @param major the major
	 * @param minor the minor
	 * @param micro the micro
	 * @return the version
	 */
	public static int javaVersion(final int major, final int minor, final int micro) {
		return (major << 16) + (minor << 8) + micro;
	}

}
