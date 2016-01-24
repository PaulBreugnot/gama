/*********************************************************************************************
 *
 *
 * 'ApplicationWorkbenchWindowAdvisor.java', in plugin 'msi.gama.application', is part of the source code of the
 * GAMA modeling and simulation platform.
 * (c) 2007-2014 UMI 209 UMMISCO IRD/UPMC & Partners
 *
 * Visit https://code.google.com/p/gama-platform/ for license information and developers contact.
 *
 *
 **********************************************************************************************/
package msi.gama.gui.swt;

import org.eclipse.ui.*;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.ide.application.IDEWorkbenchWindowAdvisor;
import msi.gama.gui.viewers.html.HtmlViewer;
import msi.gama.runtime.GAMA;

@SuppressWarnings("restriction")
public class ApplicationWorkbenchWindowAdvisor extends IDEWorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(final ApplicationWorkbenchAdvisor adv,
		final IWorkbenchWindowConfigurer configurer) {
		super(adv, configurer);
	}

	@Override
	public void preWindowOpen() {
		super.preWindowOpen();
		final IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// configurer.setInitialSize(new Point(700, 550));
		configurer.setShowFastViewBars(false);
		configurer.setShowMenuBar(true);
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowProgressIndicator(true);
		configurer.setShowPerspectiveBar(false);
		configurer.setTitle(GAMA.VERSION);
		// configurer.configureEditorAreaDropListener(new EditorAreaDropAdapter(configurer.getWindow()));

	}

	@Override
	public void postWindowCreate() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IPerspectiveDescriptor model = Workbench.getInstance().getPerspectiveRegistry()
			.findPerspectiveWithId("msi.gama.application.perspectives.ModelingPerspective");
		IPerspectiveDescriptor simul = Workbench.getInstance().getPerspectiveRegistry()
			.findPerspectiveWithId("msi.gama.application.perspectives.SimulationPerspective");
		if ( page == null ) { return; }
		System.out.println("Perspective: " + page.getPerspective().getId());
		// if ( page.isPageZoomed() ) {
		//
		// }
		if ( page.getPerspective().equals(simul) ) {
			System.out.println("Setting the perspective to modeling");
			page.setPerspective(model);
			System.out.println("Closing the simulation perspective and its views");
			page.closePerspective(simul, false, false);
			try {
				// page.setPerspective(model);
			} catch (Exception e) {
				System.out.println("Problem when restoring perspective: " + e.getMessage());
			}
			// if ( desc != null ) {
			// page.closePerspective(desc, saveParts, closePage);
			// // IViewReference[] views = page.getViewReferences();
			// // for ( IViewReference view : views ) {
			// // System.out.println("View " + view.getId());
			// // page.setPartState(view, IWorkbenchPage.STATE_RESTORED);
			// // }
			// }
		}

		window.getShell().setMaximized(true);
		RemoveUnwantedWizards.run();
		RemoveUnwantedActionSets.run();

	}

	@Override
	public void postWindowOpen() {
		HtmlViewer.openWelcomePage(true);
		RearrangeMenus.run();
		// This code below is necessary because it happens that if an editor is already opened when launching GAMA,
		// the keystrokes (like command-S) do not work on it until it has been deactivated and reactivated (at least on
		// MacOS X)
		// IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		// IEditorPart editor = page.getActiveEditor();
		// if ( editor != null ) {
		// IViewPart nav = page.findView("msi.gama.gui.view.GamaNavigator");
		// if ( nav != null ) {
		// page.activate(nav);
		// page.activate(editor);
		// }
		// }
	}

}
