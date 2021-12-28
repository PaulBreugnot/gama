/*******************************************************************************************************
 *
 * WrappedFile.java, in gama.ui.navigator, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import static gama.ui.navigator.metadata.FileMetaDataProvider.SHAPEFILE_CT_ID;
import static gama.ui.navigator.metadata.FileMetaDataProvider.SHAPEFILE_SUPPORT_CT_ID;
import static gama.ui.navigator.metadata.FileMetaDataProvider.getContentTypeId;
import static gama.ui.navigator.metadata.FileMetaDataProvider.isSupport;
import static gama.ui.navigator.metadata.FileMetaDataProvider.shapeFileSupportedBy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;

import gama.core.application.bundles.GamaBundleLoader;
import gama.runtime.GAMA;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.utils.PreferencesHelper;
import gama.ui.navigator.NavigatorContentProvider;
import gama.util.file.IGamaFileMetaData;

// TODO: Auto-generated Javadoc
/**
 * The Class WrappedFile.
 */
public class WrappedFile extends WrappedResource<WrappedResource<?, ?>, IFile> {

	/** The file parent. */
	WrappedFile fileParent;

	/** The is shape file. */
	boolean isShapeFile;

	/** The is shape file support. */
	boolean isShapeFileSupport;

	/** The image. */
	Image image;

	/**
	 * Instantiates a new wrapped file.
	 *
	 * @param root
	 *            the root
	 * @param wrapped
	 *            the wrapped
	 */
	public WrappedFile(final WrappedContainer<?> root, final IFile wrapped) {
		super(root, wrapped);
		computeFileType();
		computeFileParent();
	}

	/**
	 * Compute file image.
	 */
	protected void computeFileImage() {
		final IFile f = getResource();
		if (GamaBundleLoader.HANDLED_FILE_EXTENSIONS.contains(f.getFileExtension())) {
			if (isShapeFileSupport) {
				image = GamaIcons.create("navigator/file.shapesupport2").image();
			} else {
				image = DEFAULT_LABEL_PROVIDER.getImage(f);
			}
		} else {
			image = GamaIcons.create("navigator/file.text2").image();
		}

	}

	/**
	 * Compute file type.
	 */
	protected void computeFileType() {
		final IFile f = getResource();
		isShapeFile = SHAPEFILE_CT_ID.equals(getContentTypeId(f));
		isShapeFileSupport = SHAPEFILE_SUPPORT_CT_ID.equals(getContentTypeId(f));
	}

	/**
	 * Compute file parent.
	 */
	private void computeFileParent() {
		if (isShapeFileSupport) {
			final IResource shape = shapeFileSupportedBy(getResource());
			if (shape != null) { fileParent = (WrappedFile) getManager().findWrappedInstanceOf(shape); }
		}
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	@Override
	public WrappedResource<?, ?> getParent() {
		if (fileParent != null) return fileParent;
		return super.getParent();
	}

	/**
	 * Can be decorated.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean canBeDecorated() {
		return false;
	}

	/**
	 * Checks for children.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean hasChildren() {
		return isShapeFile;
	}

	/**
	 * Gets the navigator children.
	 *
	 * @return the navigator children
	 */
	@Override
	public Object[] getNavigatorChildren() {
		if (NavigatorContentProvider.FILE_CHILDREN_ENABLED && (isGamaFile() || isShapeFile)) return getFileChildren();
		return EMPTY;
	}

	/**
	 * Gets the file children.
	 *
	 * @return the file children
	 */
	public Object[] getFileChildren() {
		final IFile p = getResource();
		try {
			final IContainer folder = p.getParent();
			final List<WrappedFile> sub = new ArrayList<>();
			for (final IResource r : folder.members()) {
				if (r instanceof IFile && isSupport(p, (IFile) r)) {
					sub.add((WrappedFile) getManager().findWrappedInstanceOf(r));
				}
			}
			return sub.toArray();
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return VirtualContent.EMPTY;
	}
	//
	// @Override
	// public Font getFont() {
	// return GamaFonts.getNavigFileFont();
	// }

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public Image getImage() {
		if (image == null) { computeFileImage(); }
		return image;
	}

	// @Override
	// public Color getColor() {
	// return null;
	// }

	/**
 * Gets the suffix.
 *
 * @param sb the sb
 * @return the suffix
 */
@Override
	public void getSuffix(final StringBuilder sb) {
		if (PreferencesHelper.NAVIGATOR_METADATA.getValue()) {
			final IGamaFileMetaData data = GAMA.getGui().getMetaDataProvider().getMetaData(getResource(), false, true);
			if (data != null) { data.appendSuffix(sb); }
		}
	}

	/**
	 * Count models.
	 *
	 * @return the int
	 */
	@Override
	public int countModels() {
		return 0;
	}

	/**
	 * Checks if is gama file.
	 *
	 * @return true, if is gama file
	 */
	public boolean isGamaFile() { return false; }

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public VirtualContentType getType() { return VirtualContentType.FILE; }

}
