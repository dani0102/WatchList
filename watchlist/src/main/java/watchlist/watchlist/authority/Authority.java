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
	@Column(name = "authority_id")
	private long authority_id;

	@Column
	@NotBlank
	private String name;

	public Authority() {
	}

	public Authority(String name) {
		this.name = name;
	}

	public long getId() {
		return authority_id;
	}

	public void setId(long authority_id) {
		this.authority_id = authority_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
