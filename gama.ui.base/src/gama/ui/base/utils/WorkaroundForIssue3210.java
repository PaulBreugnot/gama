/*
 *
 */
package gama.ui.base.utils;

import org.eclipse.swt.internal.Library;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.internal.CoolBarToTrimManager;

import gama.common.ui.IGamaView;
import gama.runtime.PlatformHelper;
import gama.ui.base.toolbar.GamaToolbarFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkaroundForIssue3210.
 */
public class WorkaroundForIssue3210 {

	/**
	 * Run.
	 *
	 * @param cm
	 *            the cm
	 */
	public static void run(final CoolBarToTrimManager cm) {
		// Workaround for issue #3210. Only visible on macOS so far and for specific version of Eclipse (all the ones <
		// 2021-09)
		if (PlatformHelper.isMac() && Library.SWT_VERSION < 4946) {
			ToolBar tb = findToolBar(cm.getTopTrim().getWidget());
			GamaToolbarFactory.visuallyUpdate(tb);
			for (IViewPart p : WorkbenchHelper.getPage().getViews()) {
				if (p instanceof IGamaView) { ((IGamaView) p).updateToolbarState(); }
			}
		}
	}

	/**
	 * Find tool bar.
	 *
	 * @param top
	 *            the top
	 * @return the tool bar
	 */
	static ToolBar findToolBar(final Object top) {
		if (!(top instanceof Composite)) return null;
		if (top instanceof ToolBar) return (ToolBar) top;
		for (Control c : ((Composite) top).getChildren()) {
			if (c.isDisposed()) { continue; }
			ToolBar result = findToolBar(c);
			if (result != null) return result;
		}
		return null;
	}
}