/*******************************************************************************************************
 *
 * PrepareEnv.java, in msi.gama.documentation, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.9.0).
 *
 * (c) 2007-2022 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package msi.gama.doc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import msi.gama.precompiler.doc.utils.Constants;

/**
 * The Class PrepareEnv.
 */
public class PrepareEnv {

	/**
	 * 
	 * @param pluginFolder
	 *            the plugin folder in which tests will be created
	 */
	public static void prepareUnitTestGenerator(final File pluginFolder) {
		final File testsFolder = new File(pluginFolder + File.separator + Constants.TEST_PLUGIN_FOLDER);
		final File testsGenFolder = new File(pluginFolder + File.separator + Constants.TEST_PLUGIN_GEN_FOLDER);
		final File testsModelsFolder = new File(pluginFolder + File.separator + Constants.TEST_PLUGIN_GEN_MODELS);
		final File projectFile = new File(Constants.PROJECT_FILE);

		if (testsFolder.exists()) {
			if (testsGenFolder.exists()) {
				deleteDirectory(testsGenFolder);
			}
		} else {
			testsFolder.mkdir();
		}

		testsGenFolder.mkdir();
		try {

			Files.copy(Paths.get(projectFile.getAbsolutePath()),
					Paths.get(testsGenFolder.getAbsolutePath() + File.separator + ".project"),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testsModelsFolder.mkdir();
	}

	/**
	 * Prepare documentation.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void prepareDocumentation() throws IOException {
		// - Deletes every generated folders
		// - Creates every folders when they do not exist

		final File genFolder = new File(Constants.GEN_FOLDER);
		final File testFolder = new File(Constants.TEST_FOLDER);

		if (genFolder.exists()) {
			deleteDirectory(genFolder);
		}
		if (testFolder.exists()) {
			deleteDirectory(testFolder);
		}

		genFolder.mkdir();
		new File(Constants.JAVA2XML_FOLDER).mkdirs();
		new File(Constants.XML2WIKI_FOLDER).mkdirs();
		new File(Constants.PDF_FOLDER).mkdirs();
		new File(Constants.TEST_FOLDER).mkdirs();
		new File(Constants.TOC_GEN_FOLDER).mkdir();
		new File(Constants.XML_KEYWORD_GEN_FOLDER).mkdirs();
		new File(Constants.CATALOG_GEN_FOLDER).mkdir();
		new File(Constants.PRISM_GEN_FOLDER).mkdir();
	}

	/**
	 * Delete directory.
	 *
	 * @param path the path
	 * @return true, if successful
	 */
	static public boolean deleteDirectory(final File path) {
		if (path.exists()) {
			final File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return path.delete();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		prepareDocumentation();
	}
}
