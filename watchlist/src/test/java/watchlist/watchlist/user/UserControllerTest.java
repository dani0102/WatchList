package watchlist.watchlist.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import watchlist.watchlist.users.User;
import watchlist.watchlist.users.UserController;
import watchlist.watchlist.users.UserService;

/**
 * This class tests all REST endpoints from the {@link UserController}, using
 * mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WatchlistApplicationTests.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	private User user;
	private User userNoId;

	private Calendar calendarOne;
	private Calendar calendarTwo;

	private Date dateOne;
	private Date dateTwo;

	private ObjectMapper objectMapper;

	List<User> userList;

	@Before
	public void setup() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		calendarOne = new GregorianCalendar(2001, 4, 16);
		calendarTwo = new GregorianCalendar(1997, 10, 23);
		dateOne = calendarOne.getTime();
		dateTwo = calendarTwo.getTime();

		user = new User(1L, "Belinda", "Schuehle", dateOne, "beli.schuehle@gmail.com", "dabi0102", "dabi0102password");
		userNoId = new User("Belinda", "Stifani", dateTwo, "belinda.stifani@gmail.com", "bruce0102",
				"bruce0102password", null);

		userList = new ArrayList<>();
		userList.add(user);
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsUser() throws JsonProcessingException, Exception {
		when(userService.findById(user.getUsers_id())).thenReturn(user);

		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", user.getUsers_id())).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(user)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsUserList() throws JsonProcessingException, Exception {
		when(userService.getAll()).thenReturn(userList);

		mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().json(new ObjectMapper().writeValueAsString(userList)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenUser_returnsUser() throws JsonProcessingException, Exception {
		doNothing().when(userService).createUser(userNoId);

		mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(userNoId))).andExpect(status().isCreated())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(userNoId)));
	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void update_givenUser_returnsUser() throws JsonProcessingException, Exception {
		objectMapper = new ObjectMapper();

		String inputJson = objectMapper.writeValueAsString(user);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/users/{id}", user.getUsers_id())
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	/**
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void delete_givenUser_returnsNoValue() throws JsonProcessingException, Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/users/{id}", user.getUsers_id()).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}