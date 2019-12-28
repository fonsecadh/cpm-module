package persistence.users;

import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;

public interface UserDataAccess {

	boolean existsUsername(String username);
	void writeUserToFile(String id, String fullName, String userName, String passwd, double balance);
	List<User> loadUsers();
	User loadUserForID(String id) throws UserException;
	User loadUserForUsername(String username) throws UserException;

}
