package persistence.users;

import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;
import business.users.factory.UserFactory;

public interface UserDataAccess {

	// Users
	boolean existsUsername(String username);
	void writeUserToFile(String id, String fullName, String userName, String passwd, double balance);
	List<User> loadUsers();
	User loadUserForID(String id) throws UserException;
	User loadUserForUsername(String username) throws UserException;
	void updateUserBalance(String username, double balance);	
	
	// User Factory
	UserFactory getUserFactory();
	void setUserFactory(UserFactory userFactory);

}
