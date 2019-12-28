package business.users.managers;

import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;

public interface UserManager {
	
	// Input validation
	boolean isUsernameAvailable(String username);
	boolean doPasswdMatch(String passwd1, String passwd2);
	boolean correctLogInInfo(String username, String passwd) throws UserException;
	
	// Users
	void registerUser(User user);
	List<User> loadUsers();
	User loadUserForID(String id) throws UserException;
	User loadUserForUsername(String username) throws UserException;

}
