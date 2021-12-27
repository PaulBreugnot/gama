/*
 * 
 */
package gama.ui.base.utils;

import org.eclipse.swt.internal.DPIUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DPIHelper.
 */
public class DPIHelper {

	/**
	 * Checks if is hi DPI.
	 *
	 * @return true, if is hi DPI
	 */
	public static boolean isHiDPI() { return isHiDPI; }

	/**
	 * Gets the device zoom.
	 *
	 * @return the device zoom
	 */
	public static int getDeviceZoom() { return DPIUtil.getDeviceZoom(); }

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
	 * @param v
	 *            the v
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
	 * @param v
	 *            the v
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

	/** The is hi DPI. */
	private static boolean isHiDPI = DPIUtil.getDeviceZoom() > 100;

}