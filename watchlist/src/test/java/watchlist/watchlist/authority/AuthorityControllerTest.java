package watchlist.watchlist.authority;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import watchlist.watchlist.WatchlistApplicationTests;
import watchlist.watchlist.authority.Authority;
import watchlist.watchlist.authority.AuthorityController;
import watchlist.watchlist.authority.AuthorityService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WatchlistApplicationTests.class)
@WebMvcTest(AuthorityController.class)
public class AuthorityControllerTest {
	
	@InjectMocks
	private AuthorityController authorityController;

	
	private MockMvc mockMvc;
	
	@Mock
	private AuthorityService authorityService;
	
	private Authority authority;
	private Authority authorityNoId;
	
	List<Authority> authorityList;
	
	@Before
	public void setup() throws Exception{
		
		mockMvc = MockMvcBuilders.standaloneSetup(authorityController).build();
		
		authority = new Authority(1L, "read-update-create-delete");
		authorityNoId = new Authority("read-update-create");			
				
				
		authorityList = new ArrayList<>();
		authorityList.add(authority);
	}
	
	@Test
	public void getById_givenId_returnsAuthority() throws JsonProcessingException, Exception {
		when(authorityService.findById(authority.getAuthority_id())).thenReturn(authority);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/authorities/{id}", authority.getAuthority_id()))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(authority)));
	}
	
	@Test
	public void getAll_returnsAuthorityList() throws JsonProcessingException, Exception {
		when(authorityService.getAll()).thenReturn(authorityList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/authorities")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(authorityList)));
	}
	
	@Test
	public void create_givenAuthority_returnsAuthority() throws JsonProcessingException, Exception {
		doNothing().when(authorityService).createAuthority(authorityNoId);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/authorities").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(authorityNoId))).andExpect(status().isCreated());
	}

}