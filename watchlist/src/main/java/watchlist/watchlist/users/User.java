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
 * This class is the entity Users.
 * 
 * @author Daniela Simoes
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

	/**
	 * @return
	 */
	public long getUsers_id() {
		return users_id;
	}

	/**
	 * @param users_id
	 */
	public void setUsers_id(long users_id) {
		this.users_id = users_id;
	}

	/**
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
