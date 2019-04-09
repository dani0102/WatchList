package watchlist.watchlist.tvshow;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import watchlist.watchlist.data.DataGenerators;
import watchlist.watchlist.data.DataHolder;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TvShowController.class, includeFilters = {
		@Filter(classes = {TvShowMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class TvShowControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TvShowService tvShowService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private TvShowMapper tvShowMapper;
	
	private DataHolder<TvShow> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(TvShow.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		when(tvShowService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				tvShowMapper.toListDTO(dataHolder.asList())
		);
		
		mockMvc.perform(get("/tv-shows"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}

}
