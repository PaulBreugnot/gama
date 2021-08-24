/*******************************************************************************************************
 *
 * ProgressCounter.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.util.file;

import org.geotools.util.SimpleInternationalString;
import org.opengis.util.InternationalString;
import org.opengis.util.ProgressListener;

import gama.common.ui.IStatusDisplayer;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

/**
 * The Class ProgressCounter.
 */
class ProgressCounter implements ProgressListener {

	/** The scope. */
	final IScope scope;
	
	/** The name. */
	final String name;
	
	/** The progress. */
	float progress;

	/**
	 * Instantiates a new progress counter.
	 *
	 * @param scope the scope
	 * @param name the name
	 */
	ProgressCounter(final IScope scope, final String name) {
		this.scope = scope;
		this.name = name;
	}

	/**
	 * Gets the displayer.
	 *
	 * @return the displayer
	 */
	IStatusDisplayer getDisplayer() {
		return scope.getGui().getStatus(scope);
	}

	@Override
	public void complete() {
		getDisplayer().setSubStatusCompletion(1d);
	}

	@Override
	public void dispose() {
		getDisplayer().endSubStatus(name.toString());
	}

	@Override
	public void exceptionOccurred(final Throwable arg0) {
		GAMA.reportAndThrowIfNeeded(scope, GamaRuntimeException.create(arg0, scope), true);
	}

	@Override
	public float getProgress() {
		return progress;
	}

	@Override
	public InternationalString getTask() {
		return new SimpleInternationalString(name);
	}

	@Override
	public boolean isCanceled() {
		return scope.interrupted();
	}

	@Override
	public void progress(final float p) {
		progress = p;
		getDisplayer().setSubStatusCompletion(progress);
	}

	@Override
	public void setCanceled(final boolean cancel) {
		getDisplayer().endSubStatus(name.toString());
	}

	@Override
	public void setTask(final InternationalString n) {}

	@Override
	public void started() {
		getDisplayer().beginSubStatus(name.toString());
	}

	@Override
	public void warningOccurred(final String source, final String location, final String warning) {
		GAMA.reportAndThrowIfNeeded(scope, GamaRuntimeException.warning(warning, scope), false);
	}

}