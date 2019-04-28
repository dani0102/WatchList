package watchlist.watchlist.role;

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

/**
 * This class tests all REST endpoints from the {@link RoleController}, using
 * mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WatchlistApplicationTests.class)
@WebMvcTest(RoleController.class)
public class RoleControllerTest {

	@InjectMocks
	private RoleController roleController;

	private MockMvc mockMvc;

	@Mock
	private RoleService roleService;

	private Role role;
	private Role roleNoId;

	List<Role> roleList;

	@Before
	public void setup() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();

		role = new Role(1L, "user");
		roleNoId = new Role("read-update-create");

		roleList = new ArrayList<>();
		roleList.add(role);
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsRole() throws JsonProcessingException, Exception {
		when(roleService.findById(role.getRole_id())).thenReturn(role);

		mockMvc.perform(MockMvcRequestBuilders.get("/roles/{id}", role.getRole_id())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(role)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsRoleList() throws JsonProcessingException, Exception {
		when(roleService.getAll()).thenReturn(roleList);

		mockMvc.perform(MockMvcRequestBuilders.get("/roles")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(roleList)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenRole_returnsRole() throws JsonProcessingException, Exception {
		doNothing().when(roleService).createRole(roleNoId);

		mockMvc.perform(MockMvcRequestBuilders.post("/roles").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(roleNoId))).andExpect(status().isCreated());
	}

}