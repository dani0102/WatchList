package watchlist.watchlist.tvshow;

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

@RunWith(MockitoJUnitRunner.class)
public class TvShowServiceTest {

	@InjectMocks
	private TvShowService tvShowService;
	
	@Mock
	private TvShowRepository tvShowRepository;
	
	private DataHolder<TvShow> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(TvShow.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsTvShow() {
		var tvShow = dataHolder.first();
		when(tvShowRepository.findById(tvShow.getTvshow_id()))
				.thenReturn(Optional.of(tvShow));
		
		assertThat(tvShowService.getById(tvShow.getTvshow_id()))
			.isPresent()
			.contains(tvShow);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(tvShowService.getById(223L))
				.isEmpty();
	}
	
}