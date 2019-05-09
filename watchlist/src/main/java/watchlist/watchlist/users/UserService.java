package watchlist.watchlist.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import watchlist.watchlist.role.Role;

/**
 * This class implements all data access related methods targeted towards the
 * entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Service
public class UserService implements UserServiceable {

	@Autowired
    private UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
	public User findByEmail(String name) {
		User user = repository.findByEmail(name);
		return user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByUsername(String name) {
		User user = ((UserRepository) repository).findByUsername(name);
		return user;
	}

	 @Override
		    @Transactional(readOnly = true)
		    public UserDetails loadUserByUsername(String username) {
		        User user = repository.findByUsername(username);
		        if (user == null) throw new UsernameNotFoundException(username);
	
		        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		        for (Role role : user.getRoles()){
		            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		        }
	
		        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
		    }
	
}
