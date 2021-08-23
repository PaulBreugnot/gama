package gama.ui.base.shared;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IApplicationControlProvider;

public class ApplicationUIControlFactory implements IApplicationControlProvider {

	@Override
	public IApplicationControl get() {
		return ApplicationControl.getInstance();
	}

}