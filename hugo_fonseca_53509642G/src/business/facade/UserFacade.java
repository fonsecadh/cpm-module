package business.facade;

import business.exceptions.users.UserException;
import business.player.Player;
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

	public boolean existsUsername(String username) {
		UserManager um = this.userManagerFactory.makeUserManager();
		return um.isUsernameAvailable(username);
	}

	public void signUpUser(String nationalID, String fullname, String username, String passwd) {
		UserManager um = this.userManagerFactory.makeUserManager();
		User user = this.userFactory.makeUser();
		user.setID(nationalID);
		user.setFullName(fullname);
		user.setUserName(username);
		user.setPasswd(passwd);
		user.setBalance(Player.getInstance().getInitialBalance());
		um.registerUser(user);
	}

}
