package watchlist.watchlist.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity Movie.
 * 
 * @author Belinda Stifani
 */
@Service
public class MovieService implements MovieServiceable {

	private MovieRepository repository;
	
	@Autowired
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Movie> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<Movie> getAll() {
		return repository.findAll();
	}

	@Override
	public void createMovie(Movie movie) {
		this.repository.save(movie);
	}

	@Override
	public void updateMovie(Long id, Movie movieToUpdate) {
		var movie = getById(id);
		
			movie.get().setTitle(movieToUpdate.getTitle());
			movie.get().setAlias_title(movieToUpdate.getAlias_title());
			movie.get().setDescription(movieToUpdate.getDescription());
			movie.get().setPicture(movieToUpdate.getPicture());
			movie.get().setOutcome_year(movieToUpdate.getOutcome_year());
			movie.get().setLength(movieToUpdate.getLength());
		
		repository.save(movie.get());
	}

	@Override
	public void deleteMovie(Movie movie) {
		repository.delete(movie);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Movie findById(Long id) {
		Optional<Movie> entity = repository.findById(id);
		return entity.get();
	}


}
