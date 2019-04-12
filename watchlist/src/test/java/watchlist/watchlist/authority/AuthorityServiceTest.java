package watchlist.watchlist.authority;

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
 * {@link AuthorityService}, using mocks
 * 
 * @author Belinda Schuehle
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorityServiceTest {

	@InjectMocks
	private AuthorityService authorityService;

	@Mock
	private AuthorityRepository authorityRepository;

	private DataHolder<Authority> dataHolder;

	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Authority.class).generate();
	}

	@Test
	public void findById_idExists_returnsAuthority() {
		var authority = dataHolder.first();
		when(authorityRepository.findById(authority.getAuthority_id())).thenReturn(Optional.of(authority));

		assertThat(authorityService.getById(authority.getAuthority_id())).isPresent().contains(authority);
	}

	@Test
	public void findById_idDoesNotExist_returnsNothing() {
		assertThat(authorityService.getById(223L)).isEmpty();
	}

}