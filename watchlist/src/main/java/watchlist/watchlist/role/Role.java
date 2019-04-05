package watchlist.watchlist.role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import watchlist.watchlist.authority.Authority;

/**
 * This class is the entity Role.
 * 
 * @author Belinda Schuehle
 */
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long role_id;

	@Column
	@NotBlank
	private String name;

	@ManyToMany
	@JoinTable(
		name = "authority_role",
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "authority_id")
	)
	private Set<Authority> authorities;
	
	public Role() {
	}

	/**
	 * @param name
	 */
	public Role(String name) {
		this.name = name;
	}

	/**
	 * @param role_id
	 * @param name
	 * @param authorities
	 */
	public Role(long role_id, @NotBlank String name, Set<Authority> authorities) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.authorities = authorities;
	}

	/**
	 * @return
	 */
	public long getId() {
		return role_id;
	}

	/**
	 * @param role_id
	 */
	public void setId(long role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 */
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}
