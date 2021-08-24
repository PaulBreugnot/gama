/*******************************************************************************************************
 *
 * PreferencesWiper.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.common.preferences;

import java.util.prefs.Preferences;

/**
 * The Class PreferencesWiper.
 */
public class PreferencesWiper { // NO_UCD (unused code)

	/**
  * The main method.
  *
  * @param args the arguments
  */
 public static void main(final String[] args) {
		try {
			final var store = Preferences.userRoot().node("gama");
			store.removeNode();
			System.out.println("All GAMA preferences have been erased.");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}