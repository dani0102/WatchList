package watchlist.watchlist.tvshow;

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

/**
 * This class tests all REST endpoints from the {@link TvShowController}, using
 * mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WatchlistApplicationTests.class)
@WebMvcTest(TvShowController.class)
public class TvShowControllerTest {

	@InjectMocks
	private TvShowController tvShowController;

	private MockMvc mockMvc;

	@Mock
	private TvShowService tvShowService;

	private TvShow tvshow;
	private TvShow tvshowNoId;

	private ObjectMapper objectMapper;

	List<TvShow> tvshowList;

	@Before
	public void setup() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(tvShowController).build();

		tvshow = new TvShow(1L, "The Godess' blessing on this wonderful world", "Kono Subarashii no shukufuku wo",
				"Very funny story about a fighter-team", null, 2014, 2017, 25);
		tvshowNoId = new TvShow("The 100", "none", "100 years after a nuclear bomb, humans return to earth", null, 2016,
				2019, 45);

		tvshowList = new ArrayList<>();
		tvshowList.add(tvshow);
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsTvShow() throws JsonProcessingException, Exception {
		when(tvShowService.findById(tvshow.getTvshow_id())).thenReturn(tvshow);

		mockMvc.perform(MockMvcRequestBuilders.get("/tv-shows/{id}", tvshow.getTvshow_id())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(tvshow)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsTvShowList() throws JsonProcessingException, Exception {
		when(tvShowService.getAll()).thenReturn(tvshowList);

		mockMvc.perform(MockMvcRequestBuilders.get("/tv-shows")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(tvshowList)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenTvShow_returnsTvShow() throws JsonProcessingException, Exception {
		doNothing().when(tvShowService).createTvShow(tvshowNoId);

		mockMvc.perform(MockMvcRequestBuilders.post("/tv-shows").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tvshowNoId))).andExpect(status().isCreated())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(tvshowNoId)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void update_givenTvShow_returnsTvShow() throws JsonProcessingException, Exception {
		objectMapper = new ObjectMapper();

		String inputJson = objectMapper.writeValueAsString(tvshow);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/tv-shows/{id}", tvshow.getTvshow_id())
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void delete_givenTvShow_returnsNoValue() throws JsonProcessingException, Exception {

		mockMvc.perform(MockMvcRequestBuilders.delete("/tv-shows/{id}", tvshow.getTvshow_id())
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
