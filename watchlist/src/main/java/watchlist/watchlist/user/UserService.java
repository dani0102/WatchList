package watchlist.watchlist.user;

import java.util.Date;
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
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void updateUser(Long id, String firstname, String lastname, Date birthdate, String email, String username,
			String password) {
		var user = getById(id);
		user.get().setFirstname(firstname);
		user.get().setLastName(lastname);
		user.get().setBirthdate(birthdate);
		user.get().setEmail(email);
		user.get().setUsername(username);
		user.get().setPassword(password);
	}

}
