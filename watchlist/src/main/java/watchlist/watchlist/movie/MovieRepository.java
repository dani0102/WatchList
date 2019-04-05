package watchlist.watchlist.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Movie.
 * 
 * @author Belinda Stifani
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
