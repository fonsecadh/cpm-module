package business.users.managers;

import java.util.List;

import business.users.User;
import persistence.users.UserDataAccess;

public class UserManagerImpl implements UserManager {
	
	// Attributes
	private UserDataAccess uda;	
	
	

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
	public void registerUser(User user) {
		uda.writeUserToFile(user.getID(), user.getFullName(), 
				user.getUserName(), user.getPasswd(), user.getBalance());
	}

	@Override
	public List<User> loadUsers() {
		return uda.loadUsers();
	}

	@Override
	public User loadUser(String id) {
		return uda.loadUser(id);
	}

}
