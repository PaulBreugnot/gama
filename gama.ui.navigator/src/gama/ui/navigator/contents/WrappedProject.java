/*******************************************************************************************************
 *
 * WrappedProject.java, in gama.ui.navigator, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.ui.navigator.contents;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;
import org.eclipse.swt.graphics.Image;

import gama.runtime.GAMA;
import gama.ui.base.resources.GamaIcons;
import gama.ui.base.resources.IGamaIcons;
import gaml.statements.test.AbstractSummary;
import gaml.statements.test.CompoundSummary;

// TODO: Auto-generated Javadoc
/**
 * The Class WrappedProject.
 */
public class WrappedProject extends WrappedContainer<IProject> implements IAdaptable {

	/** The plugin. */
	private String plugin;

	/** The is test. */
	final boolean isTest;

	/**
	 * Instantiates a new wrapped project.
	 *
	 * @param parent
	 *            the parent
	 * @param wrapped
	 *            the wrapped
	 */
	public WrappedProject(final TopLevelFolder parent, final IProject wrapped) {
		super(parent, wrapped);
		isTest = parent instanceof TestModelsFolder;
	}

	/**
	 * Can be decorated.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean canBeDecorated() {
		return true;
	}

	/**
	 * Checks if is open.
	 *
	 * @return true, if is open
	 */
	@Override
	public boolean isOpen() { return super.isOpen() && getResource().isOpen(); }

	/**
	 * Handle double click.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean handleDoubleClick() {
		if (!isOpen()) {
			try {
				getResource().open(null);
			} catch (final CoreException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	/**
	 * Gets the navigator children.
	 *
	 * @return the navigator children
	 */
	@Override
	public Object[] getNavigatorChildren() { return isOpen() ? super.getNavigatorChildren() : EMPTY; }

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public Image getImage() { return GamaIcons.create(IGamaIcons.FOLDER_PROJECT).image(); }

	// @Override
	// public Color getColor() {
	// return ThemeHelper.isDark() ? IGamaColors.VERY_LIGHT_GRAY.color() : IGamaColors.GRAY_LABEL.color();
	// }
	//
	// @Override
	// public Font getFont() {
	// return GamaFonts.getNavigHeaderFont();
	// }

	/**
 * Gets the suffix.
 *
 * @param sb the sb
 * @return the suffix
 */
@Override
	public void getSuffix(final StringBuilder sb) {
		if (!isOpen()) {
			sb.append("closed");
			return;
		}

		if (getPlugin() != null && !getPlugin().isEmpty()) { sb.append(getPlugin()).append(", "); }
		if (isTestProject()) {
			getTestSuffix(sb);
		} else {
			super.getSuffix(sb);
		}
	}

	/**
	 * Gets the test suffix.
	 *
	 * @param sb
	 *            the sb
	 * @return the test suffix
	 */
	private void getTestSuffix(final StringBuilder sb) {
		final var emfURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(URI.encode(getName()), false);
		final var result = getSuffixOfTestSummary(emfURI);
		if (result.isEmpty()) {
			super.getSuffix(sb);
		} else {
			sb.append(result);
		}
	}

	/**
	 * Gets the suffix of test summary.
	 *
	 * @param uri
	 *            the uri
	 * @return the suffix of test summary
	 */
	public String getSuffixOfTestSummary(final org.eclipse.emf.common.util.URI uri) {
		final CompoundSummary<?, ?> summary = getManager().getTestsSummary();
		if (summary == null) return "";
		final List<AbstractSummary<?>> list = new ArrayList<>();
		summary.getSubSummariesBelongingTo(uri, list);
		final CompoundSummary<?, ?> result = new CompoundSummary<>(list);
		return result.getStringSummary();
	}

	/**
	 * Checks if is test project.
	 *
	 * @return true, if is test project
	 */
	private boolean isTestProject() { return isTest; }

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Override
	public VirtualContentType getType() { return VirtualContentType.PROJECT; }

	/**
	 * Gets the plugin.
	 *
	 * @return the plugin
	 */
	String getPlugin() {
		if (plugin == null) {
			final var data = GAMA.getGui().getMetaDataProvider().getMetaData(getResource(), false, false);
			if (data != null) {
				setPlugin(data.getSuffix());
			} else {
				setPlugin("");
			}
		}
		return plugin;
	}

	/**
	 * Sets the plugin.
	 *
	 * @param plugin
	 *            the new plugin
	 */
	void setPlugin(final String plugin) { this.plugin = plugin; }

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	@Override
	public WrappedProject getProject() { return this; }

}
