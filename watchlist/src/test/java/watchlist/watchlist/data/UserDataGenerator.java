package watchlist.watchlist.data;

import java.util.Date;

import watchlist.watchlist.users.User;

public class UserDataGenerator implements DataGeneratable<User>{

	
	public UserDataGenerator() {
	}
	
	@Override
	public DataHolder<User> generate() {
		
		return DataHolder.of(
				new User(0L, "Daniela", "Simoes", new Date(2001, 6, 16), "danielamsimoes01@gmail.com", "test0102", "test0102password"),
				new User(1L, "Belinda", "Stifani", new Date(1997, 10, 23), "belinda.stifani@gmail.com", "bruce0102", "bruce0102password"),
				new User(2L, "Belinda", "Schuehle", new Date(2001, 4, 16), "beli.schuehle@gmail.com", "dabi0102", "dabi0102password")
				);
	}

}