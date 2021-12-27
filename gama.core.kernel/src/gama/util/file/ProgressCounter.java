/*******************************************************************************************************
 *
 * ProgressCounter.java, in gama.core.kernel, is part of the source code of the GAMA modeling and simulation platform
 * (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 *
 ********************************************************************************************************/
package gama.util.file;

import javax.imageio.ImageReader;
import javax.imageio.event.IIOReadProgressListener;

import org.geotools.util.SimpleInternationalString;
import org.opengis.util.InternationalString;
import org.opengis.util.ProgressListener;

import gama.common.ui.IStatusDisplayer;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgressCounter.
 */
class ProgressCounter implements ProgressListener, IIOReadProgressListener {

	/** The scope. */
	final IScope scope;

	/** The name. */
	final String name;

	/** The progress. */
	float progress;

	/**
	 * Instantiates a new progress counter.
	 *
	 * @param scope
	 *            the scope
	 * @param name
	 *            the name
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
	IStatusDisplayer getDisplayer() { return scope.getGui().getStatus(scope); }

	/**
	 * Complete.
	 */
	@Override
	public void complete() {
		getDisplayer().setSubStatusCompletion(1d);
	}

	/**
	 * Dispose.
	 */
	@Override
	public void dispose() {
		getDisplayer().endSubStatus(name.toString());
	}

	/**
	 * Exception occurred.
	 *
	 * @param arg0
	 *            the arg 0
	 */
	@Override
	public void exceptionOccurred(final Throwable arg0) {
		GAMA.reportAndThrowIfNeeded(scope, GamaRuntimeException.create(arg0, scope), true);
	}

	/**
	 * Gets the progress.
	 *
	 * @return the progress
	 */
	@Override
	public float getProgress() { return progress; }

	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	@Override
	public InternationalString getTask() { return new SimpleInternationalString(name); }

	/**
	 * Checks if is canceled.
	 *
	 * @return true, if is canceled
	 */
	@Override
	public boolean isCanceled() { return scope.interrupted(); }

	/**
	 * Progress.
	 *
	 * @param p
	 *            the p
	 */
	@Override
	public void progress(final float p) {
		progress = p;
		getDisplayer().setSubStatusCompletion(progress);
	}

	/**
	 * Sets the canceled.
	 *
	 * @param cancel
	 *            the new canceled
	 */
	@Override
	public void setCanceled(final boolean cancel) {
		getDisplayer().endSubStatus(name.toString());
	}

	/**
	 * Sets the task.
	 *
	 * @param n
	 *            the new task
	 */
	@Override
	public void setTask(final InternationalString n) {}

	/**
	 * Started.
	 */
	@Override
	public void started() {
		getDisplayer().beginSubStatus(name.toString());
	}

	/**
	 * Warning occurred.
	 *
	 * @param source
	 *            the source
	 * @param location
	 *            the location
	 * @param warning
	 *            the warning
	 */
	@Override
	public void warningOccurred(final String source, final String location, final String warning) {
		GAMA.reportAndThrowIfNeeded(scope, GamaRuntimeException.warning(warning, scope), false);
	}

	/**
	 * Sequence started.
	 *
	 * @param source the source
	 * @param minIndex the min index
	 */
	@Override
	public void sequenceStarted(final ImageReader source, final int minIndex) {}

	/**
	 * Sequence complete.
	 *
	 * @param source the source
	 */
	@Override
	public void sequenceComplete(final ImageReader source) {}

	/**
	 * Image started.
	 *
	 * @param source the source
	 * @param imageIndex the image index
	 */
	@Override
	public void imageStarted(final ImageReader source, final int imageIndex) {
		getDisplayer().beginSubStatus(name.toString());
	}

	/**
	 * Image progress.
	 *
	 * @param source the source
	 * @param percentageDone the percentage done
	 */
	@Override
	public void imageProgress(final ImageReader source, final float percentageDone) {
		progress(percentageDone);
	}

	/**
	 * Image complete.
	 *
	 * @param source the source
	 */
	@Override
	public void imageComplete(final ImageReader source) {
		getDisplayer().setSubStatusCompletion(1d);
		getDisplayer().endSubStatus(name.toString());
	}

	/**
	 * Thumbnail started.
	 *
	 * @param source the source
	 * @param imageIndex the image index
	 * @param thumbnailIndex the thumbnail index
	 */
	@Override
	public void thumbnailStarted(final ImageReader source, final int imageIndex, final int thumbnailIndex) {}

	/**
	 * Thumbnail progress.
	 *
	 * @param source the source
	 * @param percentageDone the percentage done
	 */
	@Override
	public void thumbnailProgress(final ImageReader source, final float percentageDone) {}

	/**
	 * Thumbnail complete.
	 *
	 * @param source the source
	 */
	@Override
	public void thumbnailComplete(final ImageReader source) {}

	/**
	 * Read aborted.
	 *
	 * @param source the source
	 */
	@Override
	public void readAborted(final ImageReader source) {
		getDisplayer().endSubStatus(name.toString());
	}

}