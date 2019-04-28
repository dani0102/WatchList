package watchlist.watchlist.data;

import watchlist.watchlist.role.Role;

/**
 * This class generates data used for the Role-Service test
 * 
 * @author Belinda Schühle
 *
 */
public class RoleDataGenerator implements DataGeneratable<Role> {

	public RoleDataGenerator() {
	}

	@Override
	public DataHolder<Role> generate() {

		return DataHolder.of(
				new Role(0L, "user"), 
				new Role(1L, "admin"), 
				new Role(2L, "nobody"));
	}

}