package persistence.users;

import java.util.List;

import business.users.User;

public interface UserDataAccess {

	boolean existsUsername(String username);
	void writeUserToFile(String id, String fullName, String userName, String passwd, double balance);
	List<User> loadUsers();
	User loadUser(String id);

}
