package watchlist.watchlist.users;

import java.util.Date;

/**
 * 
 * 
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

	public long getUsers_id() {
		return users_id;
	}

	public void setUsers_id(long users_id) {
		this.users_id = users_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
