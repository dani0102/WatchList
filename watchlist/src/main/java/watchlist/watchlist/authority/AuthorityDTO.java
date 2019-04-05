package watchlist.watchlist.authority;

/**
 * This class is the DTO for the entity Authority.
 * 
 * @author Belinda Schuehle
 */
public class AuthorityDTO {
	
	private Long authority_id;

	private String name;

	/**
	 * @return the authority_id
	 */
	public Long getAuthority_id() {
		return authority_id;
	}

	/**
	 * @param authority_id the authority_id to set
	 */
	public void setAuthority_id(Long authority_id) {
		this.authority_id = authority_id;
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
	
}
