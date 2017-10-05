package cop4331;


import java.io.Serializable;
/**
 * 
 * @author Jevon Harriott
 *
 */
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * create a User Constructor
	 */
	public User(String username,String password,String type){
		this.username=username;
		this.password=password;	
		this.typeOfUser=type;
	}
	/**
	 * get the username
	 * @return username is the user name
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * get the user password
	 * @return password is the user password
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * get the user type
	 * @return the type
	 */
	public String getTypeOfUser() {
		return typeOfUser;
	}

	private String username;
	private String password;
	private String typeOfUser;
}
