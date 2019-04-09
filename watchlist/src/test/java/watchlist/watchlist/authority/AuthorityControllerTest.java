package watchlist.watchlist.authority;

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
@WebMvcTest(controllers = AuthorityController.class, includeFilters = {
		@Filter(classes = {AuthorityMapper.class},
				type = FilterType.ASSIGNABLE_TYPE)
})
public class AuthorityControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AuthorityService authorityService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AuthorityMapper authorityMapper;
	
	private DataHolder<Authority> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Authority.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		when(authorityService.getAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				authorityMapper.toListDTO(dataHolder.asList())
		);
		
		
		
		mockMvc.perform(get("/authorities"))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}

}
