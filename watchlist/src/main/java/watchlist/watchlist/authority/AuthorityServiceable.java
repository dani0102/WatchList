package watchlist.watchlist.authority;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Authority.
 * 
 * @author Belinda Schuehle
 */
@Service
public interface AuthorityServiceable {

	/**
	 * @param id
	 * @return
	 */
	public Optional<Authority> getById(Long id);
	
	/**
	 * @return
	 */
	public List<Authority> getAll();
	
	/**
	 * @param authority
	 */
	public void createAuthority(Authority authority);
	
	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	Authority findById(Long id);
	
}
