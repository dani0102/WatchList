package watchlist.watchlist.data;

import watchlist.watchlist.tvshow.TvShow;

/**
 * This class generates data used for the TvShow-Service test
 * 
 * @author Belinda Schühle
 *
 */
public class TvShowDataGenerator implements DataGeneratable<TvShow> {

	public TvShowDataGenerator() {
	}

	@Override
	public DataHolder<TvShow> generate() {

		return DataHolder.of(
				new TvShow(0L, "The Godess' blessing on this wonderful world", "Kono Subarashii no shukufuku wo",
						"Very funny story about a fighter-team", null, 2014, 2017, 25),
				new TvShow(1L, "The 100", "none", "100 years after a nuclear bomb, humans return to earth", null, 2016,
						2019, 45),
				new TvShow(2L, "Game of Thrones", "none", "War about a sword-throne", null, 2008, 2019, 60));
	}

}