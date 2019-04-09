package watchlist.watchlist.data;

import watchlist.watchlist.movie.Movie;

public class MovieDataGenerator implements DataGeneratable<Movie>{

	
	public MovieDataGenerator() {
	}
	
	@Override
	public DataHolder<Movie> generate() {
		
		return DataHolder.of(
				new Movie(0L, "Lion King", "none", "A young Lions journey after the loss of his father, the king", null, 2007, 107),
				new Movie(1L, "Titanic", "none", "The sinking of an old cruise ship", null, 2001, 180),
				new Movie(2L, "Your Name", "Kimi no nawa", "A girl and a Boy switch bodies through time", null, 2015, 90)
				);
	}

}