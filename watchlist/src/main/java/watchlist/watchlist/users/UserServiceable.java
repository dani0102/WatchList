package watchlist.watchlist.users;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Service
public interface UserServiceable extends UserDetailsService {

	/**
	 * @param id
	 * @return
	 */
	public Optional<User> getById(Long id);
	
	/**
	 * @return
	 */
	public List<User> getAll();
	
	/**
	 * @param user
	 */
	public void createUser(User user);
	
	/**
	 * @param id
	 * @param user
	 */
	public void updateUser(Long id, User user);
	
	/**
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	User findById(Long id);
	
	/**
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	User findByEmail(String name);
	
}
