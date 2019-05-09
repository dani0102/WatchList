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
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	User findByEmail(String name);
	
	/**
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	User findByUsername(String name);

}
