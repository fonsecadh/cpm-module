package business.users.factory;

import business.users.User;
import business.users.UserImpl;

public class UserFactoryImpl implements UserFactory {

	@Override
	public User makeUser() {
		return new UserImpl();
	}

}
