package Backend;

import java.io.Serializable;


public class AdminAccount implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String username;
	String password;
	
	public AdminAccount(String user, String pass)
	{
		username = user;
		password = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return username + " " + password;
	}

}
