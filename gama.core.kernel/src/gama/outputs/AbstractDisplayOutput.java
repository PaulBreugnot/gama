/*******************************************************************************************************
 *
 * AbstractDisplayOutput.java, in gama.core.kernel, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2021 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.outputs;

import gama.common.interfaces.IKeyword;
import gama.common.ui.IGamaView;
import gama.runtime.GAMA;
import gama.runtime.IScope;
import gama.runtime.exceptions.GamaRuntimeException;
import gaml.descriptions.IDescription;

/**
 * The Class AbstractDisplayOutput.
 *
 * @author drogoul
 */
public abstract class AbstractDisplayOutput extends AbstractOutput implements IDisplayOutput {

	/** The virtual. */
	final boolean virtual;

	/**
	 * Instantiates a new abstract display output.
	 *
	 * @param desc the desc
	 */
	public AbstractDisplayOutput(final IDescription desc) {
		super(desc);
		virtual = IKeyword.TRUE.equals(getLiteral(IKeyword.VIRTUAL, null));
	}

	/** The disposed. */
	protected boolean disposed = false;
	
	/** The synchro. */
	protected boolean synchro = false;
	
	/** The in init phase. */
	protected boolean inInitPhase = true;
	
	/** The view. */
	protected IGamaView view;

	/** The opener. */
	final Runnable opener = () -> {
		view = getScope().getGui().showView(getScope(), getViewId(), isUnique() ? null : getName(), 1); // IWorkbenchPage.VIEW_ACTIVATE
		if (view == null) return;
		view.addOutput(AbstractDisplayOutput.this);
	};

	@Override
	public boolean isVirtual() {
		return virtual;
	}

	@Override
	public void open() {
		super.open();
		GAMA.getGui().run("Opening " + getName(), opener, shouldOpenAsynchronously());
	}

	/**
	 * Should open asynchronously.
	 *
	 * @return true, if successful
	 */
	public boolean shouldOpenAsynchronously() {
		return true;
	}

	@Override
	public boolean init(final IScope scope) throws GamaRuntimeException {
		super.init(scope);
		return true;
	}

	@Override
	public void dispose() {
		if (disposed) return;
		disposed = true;
		if (view != null) {
			view.removeOutput(this);
			view = null;
		}
		if (getScope() != null) { GAMA.releaseScope(getScope()); }
	}

	@Override
	public void update() throws GamaRuntimeException {
		if (view != null) { view.update(this); }
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public boolean isSynchronized() {
		return synchro;
	}

	@Override
	public void setSynchronized(final boolean sync) {
		synchro = sync;
		if (view != null) { view.updateToolbarState(); }
	}

	@Override
	public void setPaused(final boolean pause) {
		super.setPaused(pause);
		if (view != null) { view.updateToolbarState(); }
	}

	@Override
	public IGamaView getView() {
		return view;
	}

	@Override
	public String getId() {
		final String cName = this.getDescription().getModelDescription().getAlias();
		if (cName != null && !"".equals(cName) && !getName().contains("#"))
			return isUnique() ? getViewId() : getViewId() + getName() + "#" + cName;
		return isUnique() ? getViewId() : getViewId() + getName();
	}

	@Override
	public boolean isInInitPhase() {
		return inInitPhase;
	}

	@Override
	public void setInInitPhase(final boolean state) {
		inInitPhase = state;
	}
}
