package watchlist.watchlist.tvshow;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Tv-Show.
 * 
 * @author Belinda Schuehle
 */
@Service
public interface TvShowServiceable {

	public Optional<TvShow> getById(Long id);
	
	public List<TvShow> getAll();
	
	public void createTvShow(TvShow tvShow);
	
	public void deleteTvShow(Long id);
	
	public void updateTvShow(TvShow tvShow);
	
}
