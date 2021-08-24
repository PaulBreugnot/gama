/*******************************************************************************************************
 *
 * RunnableSource.java, in gama.ext.libs, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.ext.libs.osmosis;

/**
 * Extends the basic Source interface with the Runnable capability. Runnable is not applied to the Source interface
 * because tasks that act as filters do not require Runnable capability.
 *
 * @author Brett Henderson
 */
public interface RunnableSource extends Source, Runnable {
	// This interface combines Source and Runnable but doesn't introduce
	// methods of its own.
}
