package watchlist.watchlist.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
<<<<<<< HEAD:watchlist/src/main/java/watchlist/watchlist/user/User.java
	private long id;
=======
	private long users_id;
>>>>>>> e48c789... meh:watchlist/src/main/java/watchlist/watchlist/users/User.java
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private Date birthdate;
	
	@Column
	private String email;
	
	@Column
	private String username;

	@Column
	private String password;

	public User(String firstname, String lastname, Date birthdate, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
	}

<<<<<<< HEAD:watchlist/src/main/java/watchlist/watchlist/user/User.java
	public User(long id, String firstname, String lastname, Date birthdate, String email, String username,
			String password) {
		super();
		this.id = id;
=======
	public User(long users_id, String firstname, String lastname, Date birthdate, String email, String username,
			String password) {
		super();
		this.users_id = users_id;
>>>>>>> e48c789... meh:watchlist/src/main/java/watchlist/watchlist/users/User.java
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.username = username;
		this.password = password;
	}

<<<<<<< HEAD:watchlist/src/main/java/watchlist/watchlist/user/User.java
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
=======
	public long getUsers_id() {
		return users_id;
	}

	public void setUsers_id(long users_id) {
		this.users_id = users_id;
>>>>>>> e48c789... meh:watchlist/src/main/java/watchlist/watchlist/users/User.java
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
