package watchlist.watchlist.tvshow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Tv-Show.
 * 
 * @author Belinda Schuehle
 */
@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long>{

}
