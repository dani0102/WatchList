package watchlist.watchlist.users;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import watchlist.watchlist.role.Role;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_role",
		joinColumns = @JoinColumn(name = "users_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;

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
	 * @param roles
	 */
	public User(@NotBlank String firstname, @NotBlank String lastname, Date birthdate, @NotBlank String email,
			@NotBlank String username, @NotBlank String password, Set<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}



	/**
	 * @param users_id
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param email
	 * @param username
	 * @param password
	 * @param roles
	 */
	public User(long users_id, @NotBlank String firstname, @NotBlank String lastname, Date birthdate,
			@NotBlank String email, @NotBlank String username, @NotBlank String password, Set<Role> roles) {
		super();
		this.users_id = users_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
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
	public User(long users_id, @NotBlank String firstname, @NotBlank String lastname, Date birthdate, @NotBlank String email,
			@NotBlank String username, @NotBlank String password) {
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



	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
