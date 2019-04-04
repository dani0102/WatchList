package watchlist.watchlist.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * 
 * @author Daniela Simões
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
