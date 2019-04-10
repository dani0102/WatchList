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

	/**
	 * @param id
	 * @return
	 */
	public Optional<Movie> getById(Long id);
	
	/**
	 * @return
	 */
	public List<Movie> getAll();
	
	/**
	 * @param movie
	 */
	public void createMovie(Movie movie);
	
	/**
	 * @param movie
	 */
	public void deleteMovie(Movie movie);
	
	/**
	 * @param id
	 * @param movie
	 */
	public void updateMovie(Long id, Movie movie);
	
	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	Movie findById(Long id);
	
}