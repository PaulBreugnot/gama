/*******************************************************************************************************
 *
 * Tags.java, in gama.ui.navigator, is part of the source code of the GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import java.util.Collection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import gama.ui.base.resources.GamaColors.GamaUIColor;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaColors;

// TODO: Auto-generated Javadoc
/**
 * Class ImportFolder.
 *
 * @author drogoul
 * @since 5 févr. 2015
 *
 */
public class Tags extends VirtualContent<WrappedFile> {

	/** The tags. */
	final Collection<String> tags;

	/**
	 * Instantiates a new tags.
	 *
	 * @param root
	 *            the root
	 * @param object
	 *            the object
	 * @param name
	 *            the name
	 */
	public Tags(final WrappedFile root, final Collection<String> object, final String name) {
		super(root, name);
		tags = object;
	}

	/**
	 * Method hasChildren().
	 *
	 * @return true, if successful
	 * @see gama.ui.navigator.contents.VirtualContent#hasChildren()
	 */
	@Override
	public boolean hasChildren() {
		return !tags.isEmpty();
	}

	// @Override
	// public Font getFont() {
	// return GamaFonts.getSmallFont(); // by default
	// }

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	@Override
	public WrappedFile getParent() { return super.getParent(); }

	/**
	 * Method getNavigatorChildren().
	 *
	 * @return the navigator children
	 * @see gama.ui.navigator.contents.VirtualContent#getNavigatorChildren()
	 */
	@Override
	public Object[] getNavigatorChildren() {
		if (tags.isEmpty()) return EMPTY;
		return tags.stream().map(each -> new Tag(this, each)).toArray();
	}

	/**
	 * Method getImage().
	 *
	 * @return the image
	 * @see gama.ui.navigator.contents.VirtualContent#getImage()
	 */
	@Override
	public Image getImage() { return GamaIcons.create("gaml/_attributes").image(); }

	/**
	 * Method getColor().
	 *
	 * @param sb the sb
	 * @return the suffix
	 * @see gama.ui.navigator.contents.VirtualContent#getColor()
	 */
	// @Override
	// public Color getColor() {
	// return ThemeHelper.isDark() ? GamaColors.system(SWT.COLOR_WHITE) : GamaColors.system(SWT.COLOR_BLACK);
	//
	// }

	@Override
	public void getSuffix(final StringBuilder sb) {}

	/**
	 * Find max problem severity.
	 *
	 * @return the int
	 */
	@Override
	public int findMaxProblemSeverity() {
		return 0;
	}

	/**
	 * Gets the overlay.
	 *
	 * @return the overlay
	 */
	@Override
	public ImageDescriptor getOverlay() { return null; }

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public VirtualContentType getType() { return VirtualContentType.CATEGORY; }

	/**
	 * Gets the status message.
	 *
	 * @return the status message
	 */
	@Override
	public String getStatusMessage() { return "Tags"; }

	/**
	 * Gets the status color.
	 *
	 * @return the status color
	 */
	@Override
	public GamaUIColor getStatusColor() { return IGamaColors.GRAY_LABEL; }

	/**
	 * Gets the status image.
	 *
	 * @return the status image
	 */
	@Override
	public Image getStatusImage() { return getImage(); }

}
