/*******************************************************************************************************
 *
 * GamlReconciler.java, in gama.ui.modeling, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.modeling.highlight;

import org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;

import com.google.inject.Inject;

/**
 * The class GamlReconciler.
 *
 * @author drogoul
 * @since 7 mai 2016
 *
 */
public class GamlReconciler extends XtextReconciler {


	/**
	 * Instantiates a new gaml reconciler.
	 *
	 * @param strategy the strategy
	 */
	@Inject
	public GamlReconciler(final XtextDocumentReconcileStrategy strategy) {
		super(strategy);
		setDelay(800);
	}



}
