package watchlist.watchlist.role;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import watchlist.watchlist.authority.AuthorityDTO;

/**
 * This class is the DTO for the entity Role.
 * 
 * @author Belinda Schuehle
 */
public class RoleDTO {
	
	private Long role_id;

	@NotBlank
	private String name;
	
	@NotNull
	private Set<AuthorityDTO> authorities;
	
	/**
	 * @return the role_id
	 */
	public Long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Long role_id) {
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
	public Set<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 */
	public void setAuthorities(Set<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}

	
}
