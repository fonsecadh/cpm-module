package persistence.users;

import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;

public class UserDataAccessImpl implements UserDataAccess {

	@Override
	public boolean existsUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeUserToFile(String id, String fullName, String userName, String passwd, double balance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUserForID(String id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUserForUsername(String username) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}	

}
