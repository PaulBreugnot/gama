/*******************************************************************************************************
 *
 * WrappedLink.java, in gama.ui.navigator, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import static gama.common.util.FileUtils.SEPARATOR;
import static gama.common.util.FileUtils.URL_SEPARATOR_REPLACEMENT;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;

import gama.ui.base.utils.WorkbenchHelper;

/**
 * The Class WrappedLink.
 */
public class WrappedLink extends WrappedFile {

	/** The is web. */
	final boolean isWeb;

	/**
	 * Instantiates a new wrapped link.
	 *
	 * @param root the root
	 * @param wrapped the wrapped
	 */
	public WrappedLink(final WrappedContainer<?> root, final IFile wrapped) {
		super(root, wrapped);
		isWeb = getResource().getLocation().toString().contains(URL_SEPARATOR_REPLACEMENT);
	}

	// @Override
	// public Font getFont() {
	// return GamaFonts.getNavigLinkFont();
	// }

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public boolean handleDoubleClick() {
		if (!getManager().validateLocation(getResource())) {
			MessageDialog.openError(WorkbenchHelper.getShell(), "Unknown file",
					"The file at location '" + getResource().getLocation() + " does not exist");
			return true;
		}
		return false;

	}

	@Override
	public int findMaxProblemSeverity() {
		if (!getManager().validateLocation(getResource())) return isWeb ? WEBLINK_BROKEN : LINK_BROKEN;
		return isWeb ? WEBLINK_OK : LINK_OK;
	}

	@Override
	public boolean canBeDecorated() {
		return true;
	}

	@Override
	public void getSuffix(final StringBuilder sb) {
		super.getSuffix(sb);

		if (sb.length() > 0) { sb.append(" - "); }
		sb.append(reconstructTargetName());

	}

	/**
	 * Reconstruct target name.
	 *
	 * @return the string
	 */
	String reconstructTargetName() {
		// if the file points to an internet address
		String loc = getResource().getLocation().toString();
		if (isWeb) {
			loc = loc.substring(loc.lastIndexOf(SEPARATOR) + 1).replace(URL_SEPARATOR_REPLACEMENT, SEPARATOR);
		}
		return loc;
	}

}
