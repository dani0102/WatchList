package watchlist.watchlist.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * This class is the entity Authority.
 * 
 * @author Belinda Schuehle
 */
@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long authority_id;

	@Column
	@NotBlank
	private String name;
	

	public Authority() {
		super();
	}

	/**
	 * @param name
	 */
	public Authority(@NotBlank String name) {
		super();
		this.name = name;
	}
	

	/**
	 * @param authority_id
	 * @param name
	 */
	public Authority(long authority_id, @NotBlank String name) {
		super();
		this.authority_id = authority_id;
		this.name = name;
	}

	/**
	 * @return the authority_id
	 */
	public long getAuthority_id() {
		return authority_id;
	}

	/**
	 * @param authority_id the authority_id to set
	 */
	public void setAuthority_id(long authority_id) {
		this.authority_id = authority_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
