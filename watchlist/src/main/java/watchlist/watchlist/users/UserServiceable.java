package watchlist.watchlist.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Service
public interface UserServiceable {

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
	
}
