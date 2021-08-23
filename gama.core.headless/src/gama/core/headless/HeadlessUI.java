package gama.core.headless;

import gama.common.ui.IApplicationControl;
import gama.common.ui.IApplicationControlProvider;

public class HeadlessUI implements IApplicationControlProvider {

	public HeadlessUI() {}

	@Override
	public IApplicationControl get() {
		return null;
	}

}
