package watchlist.watchlist.users;

import java.util.Date;

/**
 * This class is the DTO for the entity Users.
 * 
 * @author Daniela Simoes
 *
 */
public class UserDTO {

	private long users_id;
	
	private String firstname;
	
	private String lastname;
	
	private Date birthdate;
	
	private String email;
	
	private String username;
	
	private String password;

	/**
	 * @return the users_id
	 */
	public long getUsers_id() {
		return users_id;
	}

	/**
	 * @param users_id the users_id to set
	 */
	public void setUsers_id(long users_id) {
		this.users_id = users_id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
