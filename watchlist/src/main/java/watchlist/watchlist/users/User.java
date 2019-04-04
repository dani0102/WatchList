package watchlist.watchlist.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 
 * 
 * 
 * @author Daniela Sim�es
 *
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long users_id;
	
	@Column
	@NotBlank
	private String firstname;
	
	@Column
	@NotBlank
	private String lastname;
	
	@Column
	//@NotBlank
	private Date birthdate;
	
	@Column(unique =  true)
	@NotBlank
	private String email;
	
	@Column(unique = true)
	@NotBlank
	private String username;

	@Column
	@NotBlank
	private String password;

	public User() {
		super();
	}
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param email
	 * @param username
	 * @param password
	 */
	public User(String firstname, String lastname, Date birthdate, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	/**
	 * @param users_id
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param email
	 * @param username
	 * @param password
	 */
	public User(long users_id, String firstname, String lastname, Date birthdate, String email, String username,
			String password) {
		super();
		this.users_id = users_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
	}

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

	public void setLastName(String lastname) {
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
