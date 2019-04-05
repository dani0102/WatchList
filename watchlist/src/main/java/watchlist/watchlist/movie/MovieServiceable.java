package watchlist.watchlist.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This interface holds all data access related methods targeted towards the
 * entity Movie.
 * 
 * @author Belinda Stifani
 */
@Service
public interface MovieServiceable {

	public Optional<Movie> getById(Long id);
	
	public List<Movie> getAll();
	
	public void createMovie(Movie movie);
	
	public void deleteMovie(Movie movie);
	
	public void updateMovie(Long id, Movie movie);
	
}