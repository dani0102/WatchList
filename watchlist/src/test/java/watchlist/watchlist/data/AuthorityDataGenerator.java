package watchlist.watchlist.data;

import watchlist.watchlist.authority.Authority;

public class AuthorityDataGenerator implements DataGeneratable<Authority>{

	
	public AuthorityDataGenerator() {
	}
	
	@Override
	public DataHolder<Authority> generate() {
		
		return DataHolder.of(
				new Authority(0L, "read-update-create"),				
				new Authority(1L, "read-update-create-delete"),
				new Authority(2L, "nobody-only")
				);
	}

}