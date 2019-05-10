package watchlist.watchlist.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * This method finds a User with a given email
	 *
	 * @param  email Descriptive name of User
	 * @return      Returns requested User with given descriptive email of User
	 */
	User findByEmail(String email);
	
	/**
	 * This method finds a User with a given username
	 *
	 * @param  username Descriptive name of User
	 * @return      Returns requested User with given descriptive username of User
	 */
	User findByUsername(String username);

}
