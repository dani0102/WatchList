package watchlist.watchlist.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Service
public class UserService implements UserServiceable {

	private UserRepository repository;
	
	/**
	 * @param repository
	 */
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
	public void updateUser(Long id, User body) {
		var user = getById(id);

		try {
			user.get().setFirstname(body.getFirstname());
			user.get().setLastName(body.getLastname());
			user.get().setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(body.getBirthdate())));
			user.get().setEmail(body.getEmail());
			user.get().setUsername(body.getUsername());
			user.get().setPassword(body.getPassword());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		repository.save(user.get());
	}

	@Override
	public void deleteUser(User user) {
		repository.delete(user);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(Long id) {
		Optional<User> entity = repository.findById(id);
		return entity.get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
User user = findByEmail(username);
		
		if (user == null) { throw new UsernameNotFoundException("User could not be found"); }
		return new UserDetailsImpl(user);
	}

	@Override
	public User findByEmail(String name) {
		User user = repository.findByEmail(name);
		return user;
	}
	
}
