package watchlist.watchlist.role;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class is the DTO for the entity Role.
 * 
 * @author Belinda Schuehle
 */
public class RoleDTO {

	@NotBlank
	private String name;
	
	@NotNull
	private Set<AuthorityDTO> authorities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AuthorityDTO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityDTO> authorities) {
		this.authorities = authorities;
	}
}
