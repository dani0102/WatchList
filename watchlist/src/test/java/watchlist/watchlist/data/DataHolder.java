package watchlist.watchlist.data;

import java.util.List;

public class DataHolder<T> {

	static <T> DataHolder<T> of (T first, T second, T third) {
		return new DataHolder<>(first, second, third);
	}
	
	private List<T> data;
	
	private DataHolder(T first, T second, T third) {
		this.data = List.of(first, second, third);
	}
	
	public T first() {
		return data.get(0);
	}
	
	public T second() {
		return data.get(1);
	}
	
	public T third() {
		return data.get(2);
	}
	
	public List<T> asList() {
		return data;
	}
}
