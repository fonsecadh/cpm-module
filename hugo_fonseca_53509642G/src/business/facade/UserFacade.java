package business.facade;

import business.exceptions.users.UserException;
import business.users.User;
import business.users.factory.UserFactory;
import business.users.factory.UserFactoryImpl;
import business.users.factory.UserManagerFactory;
import business.users.factory.UserManagerFactoryImpl;
import business.users.managers.UserManager;

public class UserFacade {
	
	// Attributes
	private UserFactory userFactory = new UserFactoryImpl();
	private UserManagerFactory userManagerFactory = new UserManagerFactoryImpl();	
	

	public boolean validateUserCredentials(String username, String passwd) throws UserException {
		UserManager um = this.userManagerFactory.makeUserManager();
		return um.correctLogInInfo(username, passwd);
	}

	public User loadUser(String username) throws UserException {
		UserManager um = this.userManagerFactory.makeUserManager();
		return um.loadUserForUsername(username);
	}

}
