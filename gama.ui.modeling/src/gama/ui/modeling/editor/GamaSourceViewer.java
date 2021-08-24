/*******************************************************************************************************
 *
 * GamaSourceViewer.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.editor;

import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

/**
 * The class GamaSourceViewer.
 *
 * @author drogoul
 * @since 12 août 2016
 *
 */
public class GamaSourceViewer extends XtextSourceViewer {

	/** The is overview visible. */
	private boolean isOverviewVisible;

	/**
	 * Instantiates a new gama source viewer.
	 *
	 * @param parent the parent
	 * @param ruler the ruler
	 * @param overviewRuler the overview ruler
	 * @param showsAnnotationOverview the shows annotation overview
	 * @param styles the styles
	 */
	public GamaSourceViewer(final Composite parent, final IVerticalRuler ruler, final IOverviewRuler overviewRuler,
			final boolean showsAnnotationOverview, final int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		isOverviewVisible = showsAnnotationOverview && overviewRuler != null;
	}

	@Override
	public void showAnnotationsOverview(final boolean show) {
		super.showAnnotationsOverview(show);
		isOverviewVisible = show;
	}

	/**
	 * Checks if is overview visible.
	 *
	 * @return true, if is overview visible
	 */
	public boolean isOverviewVisible() {
		return isOverviewVisible;
	}

}
