/*******************************************************************************************************
 *
 * ConvertToPDF.java, in msi.gama.documentation, is part of the source code of the
 * GAMA modeling and simulation platform (v.1.9.1).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package msi.gama.doc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import msi.gama.precompiler.doc.utils.Constants;
import msi.gama.precompiler.doc.utils.OSUtils;

/**
 * The Class ConvertToPDF.
 */
public class ConvertToPDF {

	/**
	 * Gets the command line.
	 *
	 * @return the command line
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getCommandLine() throws ParserConfigurationException, SAXException, IOException {
		FileInputStream in;
		final Properties prop2 = new Properties();
		try {
			in = new FileInputStream(Constants.PANDOC_FOLDER + File.separator + "param.properties");
			prop2.load(in);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		final TOCManager toc = new TOCManager(Constants.TOC_FILE);
		toc.createPartFiles();
//		toc.createSubpartFiles();
		final String files = toc.getTocFilesString();

		final File template = new File(Constants.PANDOC_FOLDER + File.separator + "mytemplate.tex");
		final File pdfFile = new File(Constants.DOCGAMA_PDF);

		String command = Constants.CMD_PANDOC + " --template=" + template.getAbsolutePath() + " --pdf-engine="
				+ Constants.CMD_PDFLATEX + " --listings --toc";
		command = command + " " + files;
		for (final Object s : prop2.keySet()) {
			command = command + " " + "--variable " + s + "=" + prop2.getProperty(s.toString());
		}
		command = command + " -o " + pdfFile.getAbsolutePath();

		System.out.println("Command " + command);

		return command;

	}

	/**
	 * Convert mac os.
	 */
	public static void convertMacOs() {
		System.out.println("Start of convert for MacOS");
		String line;
		try {
			final String[] env = { Constants.PATH };

			final Process p = Runtime.getRuntime().exec(getCommandLine(), env, new File(Constants.WIKI_FOLDER));

			try (BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
					BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));) {
				while ((line = bri.readLine()) != null) {
					System.out.println(line);
				}
				bri.close();
				while ((line = bre.readLine()) != null) {
					System.out.println(line);
				}
				bre.close();
				p.waitFor();
				System.out.println("PDF generated.");
			}
		} catch (final Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * Convert windows.
	 */
	public static void convertWindows() {
		System.out.println("Start of convert for Windows");

		String line;
		try {
			// String[] env = { Constants.PATH };

			// build file .bat
			final File batFile = new File("batFile.bat");
			Files.deleteIfExists(batFile.toPath());
			if (batFile.createNewFile() == false) {
				System.err.println("Impossible to create the batFile...");
				return;
			}
			final List<String> lines = Arrays.asList("cd " + Constants.WIKI_FOLDER + " && " + getCommandLine());
			final Path file = Paths.get("batFile.bat");
			Files.write(file, lines, Charset.forName("UTF-8"));

			// run the bat file
			final Process p = Runtime.getRuntime().exec("cmd /c start batFile.bat && exit");

			try (final BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
					final BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));) {
				while ((line = bri.readLine()) != null) {
					System.out.println(line);
				}
				while ((line = bre.readLine()) != null) {
					System.out.println(line);
				}
				p.waitFor();
				System.out.println("PDF generated.");
			}
		} catch (final Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * Convert.
	 */
	public static void convert() {
		if (OSUtils.isWindows()) {
			convertWindows();
		} else if (OSUtils.isMacOS()) {
			convertMacOs();
		} else {
			throw new RuntimeException("This OS is not managed yet.");
		}

	}

	/**
	 * The main method.
	 *
	 * @param argc the arguments
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(final String[] argc) throws ParserConfigurationException, SAXException, IOException {

		convert();

	}
}
