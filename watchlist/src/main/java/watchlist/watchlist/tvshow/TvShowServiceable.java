package watchlist.watchlist.tvshow;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity TvShow.
 * 
 * @author Belinda Schuehle
 */
@Service
public interface TvShowServiceable {

	/**
	 * @param id
	 * @return
	 */
	public Optional<TvShow> getById(Long id);
	
	/**
	 * @return
	 */
	public List<TvShow> getAll();
	
	/**
	 * @param tvShow
	 */
	public void createTvShow(TvShow tvShow);
	
	/**
	 * @param tvShow
	 */
	public void deleteTvShow(TvShow tvShow);
	
	/**
	 * @param id
	 * @param tvShow
	 */
	public void updateTvShow(Long id, TvShow tvShow);
	
	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	TvShow findById(Long id);
	
}
