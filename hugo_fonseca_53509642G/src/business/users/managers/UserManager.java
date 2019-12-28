package business.users.managers;

import java.util.List;

import business.users.User;

public interface UserManager {
	
	// Input validation
	boolean isUsernameAvailable(String username);
	boolean doPasswdMatch(String passwd1, String passwd2);
	
	// Users
	void registerUser(User user);
	List<User> loadUsers();
	User loadUser(String id);

}
