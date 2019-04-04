package watchlist.watchlist.authority;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Authority.
 * 
 * @author Belinda Schuehle
 */
@Service
public interface AuthorityServiceable {

	public Optional<Authority> getById(Long id);
	
	public List<Authority> getAll();
	
	public void createFachrichtung(Authority authority);
	
}
