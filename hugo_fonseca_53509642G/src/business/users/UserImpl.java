package business.users;

public class UserImpl implements User {
	
	// Attributes
	private String id;
	private String fullname;
	private String username;
	private String password;
	private double balance;
	
	

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void setID(String id) {
		this.id = id;
	}

	@Override
	public String getFullName() {
		return fullname;
	}

	@Override
	public void setFullName(String fullName) {
		this.fullname = fullName;
	}

	@Override
	public String getUserName() {
		return username;
	}

	@Override
	public void setUserName(String username) {
		this.username = username;
	}

	@Override
	public String getPasswd() {
		return password;
	}

	@Override
	public void setPasswd(String passwd) {
		this.password = passwd;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
