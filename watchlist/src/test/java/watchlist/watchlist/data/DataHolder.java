package watchlist.watchlist.data;

import java.util.List;

/**
 * @author Belinda Stifani
 *
 * @param <T>
 */
public class DataHolder<T> {

	static <T> DataHolder<T> of(T first, T second, T third) {
		return new DataHolder<>(first, second, third);
	}

	private List<T> data;

	/**
	 * @param first
	 * @param second
	 * @param third
	 */
	private DataHolder(T first, T second, T third) {
		this.data = List.of(first, second, third);
	}

	/**
	 * @return first item
	 */
	public T first() {
		return data.get(0);
	}

	/**
	 * @return second item
	 */
	public T second() {
		return data.get(1);
	}

	/**
	 * @return third item
	 */
	public T third() {
		return data.get(2);
	}

	/**
	 * @return dataList
	 */
	public List<T> asList() {
		return data;
	}
}
