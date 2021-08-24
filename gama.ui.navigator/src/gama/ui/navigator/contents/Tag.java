/*******************************************************************************************************
 *
 * Tag.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import gama.ui.base.resources.GamaColors;
import gama.ui.base.utils.ThemeHelper;

/**
 * Class LinkedFile.
 *
 * @author drogoul
 * @since 5 févr. 2015
 *
 */
public class Tag extends VirtualContent<Tags> {

	/**
	 * Instantiates a new tag.
	 *
	 * @param root the root
	 * @param wrapped the wrapped
	 */
	public Tag(final Tags root, final String wrapped) {
		super(root, wrapped);
	}

	/**
	 * Method hasChildren()
	 *
	 * @see gama.ui.navigator.contents.VirtualContent#hasChildren()
	 */
	@Override
	public boolean hasChildren() {
		return false;
	}

	// @Override
	// public Font getFont() {
	// return GamaFonts.getNavigLinkFont(); // by default
	// }

	/**
	 * Method getNavigatorChildren()
	 *
	 * @see gama.ui.navigator.contents.VirtualContent#getNavigatorChildren()
	 */
	@Override
	public Object[] getNavigatorChildren() {
		return EMPTY;
	}

	/**
	 * Method getImage()
	 *
	 * @see gama.ui.navigator.contents.VirtualContent#getImage()
	 */
	@Override
	public Image getImage() {
		return null;
	}

	/**
	 * Method getColor()
	 *
	 * @see gama.ui.navigator.contents.VirtualContent#getColor()
	 */
	@Override
	public Color getColor() {
		return ThemeHelper.isDark() ? GamaColors.system(SWT.COLOR_WHITE) : GamaColors.system(SWT.COLOR_BLACK);
	}

	@Override
	public boolean handleDoubleClick() {
		return true;
	}

	@Override
	public int findMaxProblemSeverity() {
		return 0;
	}

	@Override
	public void getSuffix(final StringBuilder sb) {
		// sb.append(suffix);
	}

	@Override
	public ImageDescriptor getOverlay() {
		return null;
	}

	@Override
	public VirtualContentType getType() {
		return VirtualContentType.CATEGORY;
	}

}
