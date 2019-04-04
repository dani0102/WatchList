package watchlist.watchlist.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceable {

	private UserRepository repository;
	
	@Override
	public Optional<User> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public void createUser(User user) {
		repository.save(user);
	}

	@Override
	public void updateUser(Long id, User body) {
		var user = getById(id);

		
		repository.save(body);
	}

	@Override
	public void deleteUser(User user) {
		repository.delete(user);
	}
	
	

}
