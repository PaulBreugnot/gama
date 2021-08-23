package gama.ui.navigator.contents;

import gama.runtime.GAMA;
import gaml.compilation.ast.ISyntacticElement;

public class WrappedExperimentContent extends WrappedSyntacticContent {

	public WrappedExperimentContent(final WrappedGamaFile file, final ISyntacticElement e) {
		super(file, e, GAMA.getGui().getGamlLabelProvider().getText(e));
	}

	@Override
	public WrappedGamaFile getFile() {
		return (WrappedGamaFile) getParent();
	}

	@Override
	public boolean hasChildren() {
		return true;
	}

	@Override
	public boolean handleDoubleClick() {
		GAMA.getGui().runModel(getParent(), element.getName());
		return true;
	}
}