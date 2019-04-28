package watchlist.watchlist.movie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import watchlist.watchlist.data.DataGenerators;
import watchlist.watchlist.data.DataHolder;

/**
 * This class tests all data access related methods from the
 * {@link MovieService}, using mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

	@InjectMocks
	private MovieService movieService;

	@Mock
	private MovieRepository movieRepository;

	private DataHolder<Movie> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Movie.class).generate();
	}

	@Test
	public void findById_idExists_returnsMovie() {
		var movie = dataHolder.first();
		when(movieRepository.findById(movie.getMovie_id())).thenReturn(Optional.of(movie));

		assertThat(movieService.getById(movie.getMovie_id())).isPresent().contains(movie);
	}

	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(movieService.getById(223L)).isEmpty();
	}

}