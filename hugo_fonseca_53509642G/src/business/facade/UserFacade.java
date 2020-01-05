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
	private UserManager um;

	public UserFacade() {
		this.um = this.userManagerFactory.makeUserManager();
	}

	public boolean validateUserCredentials(String username, String passwd) throws UserException {
		return um.correctLogInInfo(username, passwd);
	}

	public User loadUser(String username) throws UserException {
		return um.loadUserForUsername(username);
	}

	public boolean isUsernameAvailable(String username) {
		return um.isUsernameAvailable(username);
	}

	public void signUpUser(String nationalID, String fullname, String username, String passwd) {
		User user = this.userFactory.makeUser();
		user.setID(nationalID);
		user.setFullName(fullname);
		user.setUserName(username);
		user.setPasswd(passwd);
		user.setBalance(Player.getInstance().getInitialBalance());
		um.registerUser(user);
	}

	public void logOutUser(User user) {
		um.updateUserBalance(user.getUserName(), user.getBalance());
	}

}
