package watchlist.watchlist.data;

import watchlist.watchlist.authority.Authority;
import watchlist.watchlist.movie.Movie;
//import watchlist.watchlist.role.Role;
import watchlist.watchlist.tvshow.TvShow;
import watchlist.watchlist.users.User;

public class DataGenerators {

	public static <T> DataGeneratable<T> forClass(Class<T> clazz) {
		return new DataGenerators().build(clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> DataGeneratable<T> build(Class<T> clazz) {
		DataGeneratable<?> gen = null;

		if (TvShow.class.isAssignableFrom(clazz)) {
			gen = tvshowGen();
		} else if (User.class.isAssignableFrom(clazz)) {
			gen = userGen();
		} else if (Movie.class.isAssignableFrom(clazz)) {
			gen = movieGen();
		} else if (Authority.class.isAssignableFrom(clazz)) {
			gen = authorityGen();
		} 
//		else if (Role.class.isAssignableFrom(clazz)) {
//			gen = roleGen();
//		} 
		else {
			throw new RuntimeException();
		}

		return (DataGeneratable<T>) gen;
	}

	private TvShowDataGenerator tvshowGen() {
		return new TvShowDataGenerator();
	}

	private AuthorityDataGenerator authorityGen() {
		return new AuthorityDataGenerator();
	}

// TODO: Fix RoleDataGenerator
//	private RoleDataGenerator roleGen() {
//		return new RoleDataGenerator(authorityGen());
//	}

	private UserDataGenerator userGen() {
		return new UserDataGenerator();
	}

	private MovieDataGenerator movieGen() {
		return new MovieDataGenerator();
	}
}