/*******************************************************************************************************
 *
 * WorkaroundForIssue2745.java, in gama.display.java2d, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.display.java2d;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import gama.core.dev.utils.DEBUG;
import gama.runtime.PlatformHelper;
import gama.ui.base.utils.WorkbenchHelper;

/**
 * The Class WorkaroundForIssue2745.
 */
public class WorkaroundForIssue2745 {

	static {
		DEBUG.OFF();
	}

	/**
	 * Install on.
	 *
	 * @param view the view
	 */
	public static void installOn(final AWTDisplayView view) {
		// Only installs on macOS
		if (!PlatformHelper.isMac()) { return; }
		final IPartListener2 pl = new IPartListener2() {

			void forceLayout() {
				final Control c = view.controlToSetFullScreen();
				if (c == null || c.getParent() == null) { return; }
				c.setVisible(false);
				c.getParent().layout(true, true);
				c.setVisible(true);
			}

			@Override
			public void partActivated(final IWorkbenchPartReference partRef) {
				if (partRef.getPart(false).equals(view)) {
					DEBUG.OUT("Part becomes activated ");
					forceLayout();
				}

			}

			@Override
			public void partClosed(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// // DEBUG.OUT("Part becomes closed ");
				// }
			}

			@Override
			public void partDeactivated(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// // DEBUG.OUT("Part becomes deactivated ");
				// }
			}

			@Override
			public void partOpened(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// DEBUG.OUT("Part becomes opened ");
				// }
			}

			@Override
			public void partBroughtToTop(final IWorkbenchPartReference part) {
				// if (part.getPart(false).equals(view)) {
				// DEBUG.OUT("Part becomes brought to top ");
				// // view.forceLayout();
				// }
			}

			@Override
			public void partHidden(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// // DEBUG.OUT("Part becomes hidden ");
				// }
			}

			@Override
			public void partVisible(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// DEBUG.OUT("Part becomes visible ");
				// }
			}

			@Override
			public void partInputChanged(final IWorkbenchPartReference partRef) {
				// if (partRef.getPart(false).equals(view)) {
				// // DEBUG.OUT("Part has its input changed ");
				// }
			}
		};
		WorkbenchHelper.getPage().addPartListener(pl);

	}

}
