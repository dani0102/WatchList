package watchlist.watchlist.user;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UserServiceable {

	public Optional<User> getById(Long id);
	
	public List<User> getAll();
	
	public void createUser(User user);
	
	public void deleteUser(Long id);
	
	public void updateUser(Long id, String firstname, String lastname, String birthdate, String email, String username, String password);
	
}
