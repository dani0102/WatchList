package watchlist.watchlist.movie;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import watchlist.watchlist.WatchlistApplicationTests;
import watchlist.watchlist.movie.Movie;
import watchlist.watchlist.movie.MovieController;
import watchlist.watchlist.movie.MovieService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WatchlistApplicationTests.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

	@InjectMocks
	private MovieController tvShowController;

	private MockMvc mockMvc;

	@Mock
	private MovieService tvShowService;

	private Movie movie;
	private Movie movieNoId;

	private ObjectMapper objectMapper;

	List<Movie> movieList;

	@Before
	public void setup() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(tvShowController).build();

		movie = new Movie(1L, "Titanic", "none", "The sinking of an old cruise ship", null, 2001, 180);
		movieNoId = new Movie("Lion King", "none", "A young Lions journey after the loss of his father, the king", null,
				2007, 107);

		movieList = new ArrayList<>();
		movieList.add(movie);
	}

	@Test
	public void getById_givenId_returnsMovie() throws JsonProcessingException, Exception {
		when(tvShowService.findById(movie.getMovie_id())).thenReturn(movie);

		mockMvc.perform(MockMvcRequestBuilders.get("/movies/{id}", movie.getMovie_id())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(movie)));
	}

	@Test
	public void getAll_returnsMovieList() throws JsonProcessingException, Exception {
		when(tvShowService.getAll()).thenReturn(movieList);

		mockMvc.perform(MockMvcRequestBuilders.get("/movies")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(movieList)));
	}

	@Test
	public void create_givenMovie_returnsMovie() throws JsonProcessingException, Exception {
		doNothing().when(tvShowService).createMovie(movieNoId);

		mockMvc.perform(MockMvcRequestBuilders.post("/movies").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(movieNoId))).andExpect(status().isCreated())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(movieNoId)));
	}

	@Test
	public void update_givenMovie_returnsMovie() throws JsonProcessingException, Exception {

		movie.setTitle("Lemon");

		objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(movie);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/movies/{id}", movie.getMovie_id())
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void delete_givenMovie_returnsNoValue() throws JsonProcessingException, Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/movies/{id}", movie.getMovie_id()).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}