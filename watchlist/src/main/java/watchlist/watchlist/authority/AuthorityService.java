package watchlist.watchlist.authority;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity Authority.
 * 
 * @author Belinda Schuehle
 *
 */
@Service
public class AuthorityService implements AuthorityServiceable{

	private AuthorityRepository repository;
	
	/**
	 * @param repository
	 */
	@Autowired
	public AuthorityService(AuthorityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Authority> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Authority> getAll() {
		return repository.findAll();
	}

	@Override
	public void createAuthority(Authority authority) {
		repository.save(authority);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Authority findById(Long id) {
		Optional<Authority> entity = repository.findById(id);
		return entity.get();
	}

}
