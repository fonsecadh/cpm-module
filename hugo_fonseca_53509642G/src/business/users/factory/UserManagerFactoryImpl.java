package business.users.factory;

import business.users.managers.UserManager;
import business.users.managers.UserManagerImpl;

public class UserManagerFactoryImpl implements UserManagerFactory {

	@Override
	public UserManager makeUserManager() {
		return new UserManagerImpl();
	}

}
