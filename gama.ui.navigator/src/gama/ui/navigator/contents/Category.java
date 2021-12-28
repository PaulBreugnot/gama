/*******************************************************************************************************
 *
 * Category.java, in gama.ui.navigator, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import gama.common.util.FileUtils;
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
public class Category extends VirtualContent<WrappedFile> {

	/** The file names. */
	final Collection<String> fileNames;

	/**
	 * Instantiates a new category.
	 *
	 * @param root
	 *            the root
	 * @param object
	 *            the object
	 * @param name
	 *            the name
	 */
	public Category(final WrappedFile root, final Collection<String> object, final String name) {
		super(root, name);
		fileNames = object;
	}

	/**
	 * Method hasChildren().
	 *
	 * @return true, if successful
	 * @see gama.ui.navigator.contents.VirtualContent#hasChildren()
	 */
	@Override
	public boolean hasChildren() {
		return !fileNames.isEmpty();
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
		if (fileNames.isEmpty()) return EMPTY;
		final List<LinkedFile> files = new ArrayList<>();
		final var file = getParent().getResource();
		final var filePath = file.getFullPath().toString();
		final var uri = URI.createURI(filePath, false);
		for (final String fn : fileNames) {
			final var s = URI.decode(fn);
			if (s.startsWith("http")) { continue; }
			final var newFile = FileUtils.getFile(s, uri, true);
			if (newFile != null) {
				final var proxy = new LinkedFile(this, newFile, s);
				files.add(proxy);
			}
		}
		return files.toArray();
	}

	/**
	 * Method getImage().
	 *
	 * @return the image
	 * @see gama.ui.navigator.contents.VirtualContent#getImage()
	 */
	@Override
	public Image getImage() { return GamaIcons.create("gaml/_" + getName().toLowerCase()).image(); }

	/**
	 * Method getColor().
	 *
	 * @param sb the sb
	 * @return the suffix
	 * @see gama.ui.navigator.contents.VirtualContent#getColor()
	 */
	// @Override
	// public Color getColor() {
	// return ThemeHelper.isDark() ? IGamaColors.WHITE.color() : IGamaColors.BLACK.color();
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
	public String getStatusMessage() { return "Virtual Folder"; }

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
