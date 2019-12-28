package business.users.managers;

import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;
import persistence.users.UserDataAccess;
import persistence.users.UserDataAccessImpl;

public class UserManagerImpl implements UserManager {
	
	// Attributes
	private UserDataAccess uda;
	
	
	
	// Constructor
	public UserManagerImpl() {
		this.uda = new UserDataAccessImpl();
	}	
	

	@Override
	public boolean isUsernameAvailable(String username) {
		if (uda.existsUsername(username) == false) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doPasswdMatch(String passwd1, String passwd2) {
		return passwd1.equals(passwd2) ? true : false;
	}

	@Override
	public boolean correctLogInInfo(String username, String passwd) throws UserException {
		User user = loadUserForUsername(username);
		return user.getPasswd().equals(passwd) ? true : false;
	}

	@Override
	public void registerUser(User user) {
		uda.writeUserToFile(user.getID(), user.getFullName(), 
				user.getUserName(), user.getPasswd(), user.getBalance());
	}

	@Override
	public List<User> loadUsers() {
		return uda.loadUsers();
	}


	@Override
	public User loadUserForID(String id) throws UserException {
		return uda.loadUserForID(id);
	}


	@Override
	public User loadUserForUsername(String username) throws UserException {
		return uda.loadUserForUsername(username);
	}

}
