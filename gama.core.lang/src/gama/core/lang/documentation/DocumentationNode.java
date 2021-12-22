/*******************************************************************************************************
 *
 * DocumentationNode.java, in gama.core.lang, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.core.lang.documentation;

import java.io.IOException;

import gama.common.interfaces.IGamlDescription;

// TODO: Auto-generated Javadoc
/**
 * The Class DocumentationNode.
 */
public class DocumentationNode implements IGamlDescription {

	// public static byte[] compress(final String text) throws IOException {
	// final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	// try (final OutputStream out = new DeflaterOutputStream(baos, true);) {
	// out.write(text.getBytes("ISO-8859-1"));
	// }
	// return baos.toByteArray();
	// }
	//
	// public static String decompress(final byte[] bytes) throws IOException {
	// final InputStream in = new InflaterInputStream(new ByteArrayInputStream(bytes));
	// final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	// final byte[] buffer = new byte[8192];
	// int len;
	// while ((len = in.read(buffer)) > 0) {
	// baos.write(buffer, 0, len);
	// }
	// return new String(baos.toByteArray(), "ISO-8859-1");
	// }
	//
	// final byte[] title;
	// final byte[] doc;

	/** The title. */
	String title;

	/** The doc. */
	String doc;

	/**
	 * Instantiates a new documentation node.
	 *
	 * @param desc
	 *            the desc
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	DocumentationNode(final IGamlDescription desc) throws IOException {
		title = desc.getTitle();
		doc = desc.getDocumentation();
		final String plugin = desc.getDefiningPlugin();
		if (plugin != null) { doc += "\n<p/><i> [defined in " + plugin + "] </i>"; }
	}

	/**
	 * Method collectMetaInformation().
	 *
	 * @return the documentation
	 * @see msi.gama.common.interfaces.IGamlDescription#collectPlugins(java.util.Set)
	 */
	// @Override
	// public void collectMetaInformation(final GamlProperties meta) {}

	@Override
	public String getDocumentation() {
		return doc;
		// try {
		// return decompress(doc);
		// } catch (final IOException e) {
		// e.printStackTrace();
		// return "Error";
		// }
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return title;
		// try {
		// return decompress(title);
		// } catch (final IOException e) {
		// e.printStackTrace();
		// return "Error";
		// }
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() { return "Online documentation"; }

	/**
	 * Gets the defining plugin.
	 *
	 * @return the defining plugin
	 */
	@Override
	public String getDefiningPlugin() { return ""; }

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@Override
	public void setName(final String name) {
		// Nothing
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getTitle() + " - " + getDocumentation();
	}

	/**
	 * Method serialize().
	 *
	 * @param includingBuiltIn the including built in
	 * @return the string
	 * @see msi.gama.common.interfaces.IGamlable#serialize(boolean)
	 */
	@Override
	public String serialize(final boolean includingBuiltIn) {
		return toString();
	}

}