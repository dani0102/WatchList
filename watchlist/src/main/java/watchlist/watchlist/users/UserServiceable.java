package watchlist.watchlist.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * 
 * @author Daniela Simoes
 *
 */
@Service
public interface UserServiceable {

	public Optional<User> getById(Long id);
	
	public List<User> getAll();
	
	public void createUser(User user);
	
	public void updateUser(Long id, User user);
	
	public void deleteUser(User user);
	
}
