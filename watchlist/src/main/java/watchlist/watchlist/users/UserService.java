package watchlist.watchlist.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceable {

	private UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
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
		this.repository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void updateUser(User body) {

		
		repository.save(body);
	}
	
	

}
