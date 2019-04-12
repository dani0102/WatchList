package watchlist.watchlist.role;

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
 * {@link RoleService}, using mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

	@InjectMocks
	private RoleService roleService;

	@Mock
	private RoleRepository roleRepository;

	private DataHolder<Role> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Role.class).generate();
	}

	@Test
	public void findById_idExists_returnsRole() {
		var role = dataHolder.first();
		when(roleRepository.findById(role.getRole_id())).thenReturn(Optional.of(role));

		assertThat(roleService.getById(role.getRole_id())).isPresent().contains(role);
	}

	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(roleService.getById(223L)).isEmpty();
	}

}