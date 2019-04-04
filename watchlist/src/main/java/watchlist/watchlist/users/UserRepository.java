package watchlist.watchlist.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * 
 * @author Daniela Simoes
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
