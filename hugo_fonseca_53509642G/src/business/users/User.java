package business.users;

public interface User {
	
	// National ID
	String getID();
	void setID(String id);
	
	// Full name
	String getFullName();
	void setFullName(String fullName);
	
	// User name
	String getUserName();
	void setUserName(String username);
	
	// Password
	String getPasswd();
	void setPasswd(String passwd);
	
	// Balance
	double getBalance();
	void setBalance(double balance);

}
