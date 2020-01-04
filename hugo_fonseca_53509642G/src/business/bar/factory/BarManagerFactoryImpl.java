package business.bar.factory;

import business.bar.managers.BarManager;
import business.bar.managers.BarManagerImpl;

public class BarManagerFactoryImpl implements BarManagerFactory {

	@Override
	public BarManager makeBarManager() {
		return new BarManagerImpl();
	}

}
