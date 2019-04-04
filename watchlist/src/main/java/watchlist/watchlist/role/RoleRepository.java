package watchlist.watchlist.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Role.
 * 
 * @author Belinda Schuehle
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
