/*******************************************************************************************************
 *
 * MenuAction.java, in gama.ui.base, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.base.menus;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;

/**
 * The Class MenuAction.
 */
public class MenuAction {

	/** The listener. */
	public SelectionListener listener;
	
	/** The image. */
	public Image image;
	
	/** The text. */
	public String text;

	/**
	 * Instantiates a new menu action.
	 *
	 * @param listener the listener
	 * @param image the image
	 * @param text the text
	 */
	public MenuAction(final SelectionListener listener, final Image image, final String text) {
		super();
		this.listener = listener;
		this.image = image;
		this.text = text;
	}

}