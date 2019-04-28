package watchlist.watchlist.data;

/**
 * @author Belinda Stifani
 *
 * @param <T>
 */
public interface DataGeneratable<T> {
	DataHolder<T> generate();
}
