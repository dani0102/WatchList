package watchlist.watchlist.role;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Role.
 * 
 * @author Belinda Schuehle
 */
@Service
public interface RoleServiceable {

	/**
	 * @param id
	 * @return
	 */
	public Optional<Role> getById(Long id);
	
	/**
	 * @return
	 */
	public List<Role> getAll();
	
	/**
	 * @param role
	 */
	public void createRole(Role role);
	
	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	Role findById(Long id);
}