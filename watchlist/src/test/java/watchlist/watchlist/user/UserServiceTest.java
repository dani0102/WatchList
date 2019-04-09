package watchlist.watchlist.user;

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
import watchlist.watchlist.users.User;
import watchlist.watchlist.users.UserRepository;
import watchlist.watchlist.users.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	private DataHolder<User> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(User.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsUser() {
		var user = dataHolder.first();
		when(userRepository.findById(user.getUsers_id()))
				.thenReturn(Optional.of(user));
		
		assertThat(userService.getById(user.getUsers_id()))
			.isPresent()
			.contains(user);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(userService.getById(223L))
				.isEmpty();
	}
	
}