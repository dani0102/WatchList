package watchlist.watchlist.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity Role.
 * 
 * @author Belinda Schuehle
 *
 */
@Service
public class RoleService implements RoleServiceable{

	private RoleRepository repository;
	
	@Autowired
	public RoleService(RoleRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Role> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Role> getAll() {
		return repository.findAll();
	}

	@Override
	public void createFachrichtung(Role role) {
		repository.save(role);
	}

}
