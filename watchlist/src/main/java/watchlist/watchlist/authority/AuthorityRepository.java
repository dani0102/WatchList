package watchlist.watchlist.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Authority.
 * 
 * @author Belinda Schuehle
 *
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
