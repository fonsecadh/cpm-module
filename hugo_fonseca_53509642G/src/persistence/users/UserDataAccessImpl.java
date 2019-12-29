package persistence.users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.exceptions.users.UserException;
import business.users.User;
import business.users.factory.UserFactory;

public class UserDataAccessImpl implements UserDataAccess {
	
	// Constants
	private static final String USER_FILENAME = "customers.dat";
	
	// Attributes
	private UserFactory userFactory;
	
	

	@Override
	public boolean existsUsername(String username) {
		String line;
		String[] userData = null;
		boolean found = false;

		try {
			BufferedReader file = new BufferedReader(new FileReader(USER_FILENAME));
			while (file.ready()) {
				line = file.readLine();
				userData = line.split("@");
				
				if (username.equals(userData[2])) {
					found = true;
				}
			}
			file.close();			
			if (found == true) {
				return true;
			}			
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		return false;
	}

	@Override
	public void writeUserToFile(String id, String fullName, String userName, String passwd, double balance) {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("files/" + USER_FILENAME + ".dat"));
			String line = id + "@" + fullName + "@" + userName + "@" + passwd + "@" + balance;
			file.write(line);
			file.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("The file could not be saved.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}		
	}

	@Override
	public List<User> loadUsers() {
		String line;
		String[] userData = null;
		User user = userFactory.makeUser();
		List<User> users = new ArrayList<User>();

		try {
			BufferedReader file = new BufferedReader(new FileReader(USER_FILENAME));
			while (file.ready()) {
				line = file.readLine();
				userData = line.split("@");
				
				user.setID(userData[0]);
				user.setFullName(userData[1]);
				user.setUserName(userData[2]);
				user.setPasswd(userData[3]);
				user.setBalance(Double.parseDouble(userData[4]));
				
				users.add(user);
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		
		return users;
	}

	@Override
	public User loadUserForID(String id) throws UserException {
		String line;
		String[] userData = null;
		User user = userFactory.makeUser();
		boolean found = false;

		try {
			BufferedReader file = new BufferedReader(new FileReader(USER_FILENAME));
			while (file.ready()) {
				line = file.readLine();
				userData = line.split("@");
				
				if (id.equals(userData[0])) {
					user.setID(userData[0]);
					user.setFullName(userData[1]);
					user.setUserName(userData[2]);
					user.setPasswd(userData[3]);
					user.setBalance(Double.parseDouble(userData[4]));	
					found = true;
				}
			}
			file.close();			
			if (found == true) {
				return user;
			}			
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		
		throw new UserException("There are no users with that ID");
	}

	@Override
	public User loadUserForUsername(String username) throws UserException {
		String line;
		String[] userData = null;
		User user = userFactory.makeUser();
		boolean found = false;

		try {
			BufferedReader file = new BufferedReader(new FileReader(USER_FILENAME));
			while (file.ready()) {
				line = file.readLine();
				userData = line.split("@");
				
				if (username.equals(userData[2])) {
					user.setID(userData[0]);
					user.setFullName(userData[1]);
					user.setUserName(userData[2]);
					user.setPasswd(userData[3]);
					user.setBalance(Double.parseDouble(userData[4]));	
					found = true;
				}
			}
			file.close();			
			if (found == true) {
				return user;
			}			
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
		
		throw new UserException("There are no users with that username");
	}

	@Override
	public UserFactory getUserFactory() {
		return userFactory;
	}

	@Override
	public void setUserFactory(UserFactory userFactory) {
		this.userFactory = userFactory;
	}	

}
