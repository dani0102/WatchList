package watchlist.watchlist.data;

import watchlist.watchlist.authority.Authority;
import watchlist.watchlist.role.Role;
import java.util.Set;

public class RoleDataGenerator implements DataGeneratable<Role>{

	private AuthorityDataGenerator authorityGenerator;
	
	public RoleDataGenerator(AuthorityDataGenerator authorityGenerator) {
		this.authorityGenerator = authorityGenerator;
	}
	
	@Override
	public DataHolder<Role> generate() {
		
		// TODO: this will for sure not work.. at all. 
		Set<Authority> authorities = (Set<Authority>) authorityGenerator.generate();
		
		return DataHolder.of(
				new Role(0L, "user", authorities),				
				new Role(1L, "admin", authorities),
				new Role(2L, "nobody", authorities)
				);
	}

}