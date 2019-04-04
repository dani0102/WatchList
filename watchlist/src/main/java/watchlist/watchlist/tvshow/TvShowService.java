package watchlist.watchlist.tvshow;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity Tv-Show
 * 
 * @author Belinda Schuehle
 */
@Service
public class TvShowService implements TvShowServiceable {

	private TvShowRepository repository;
	
	@Autowired
	public TvShowService(TvShowRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<TvShow> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<TvShow> getAll() {
		return repository.findAll();
	}

	@Override
	public void createTvShow(TvShow tvShow) {
		this.repository.save(tvShow);
	}

	@Override
	public void updateTvShow(Long id, TvShow tvShowToUpdate) {
		var tvShow = getById(id);
		
			tvShow.get().setTitle(tvShowToUpdate.getTitle());
			tvShow.get().setAlias_title(tvShowToUpdate.getAlias_title());
			tvShow.get().setDescription(tvShowToUpdate.getDescription());
			tvShow.get().setPicture(tvShowToUpdate.getPicture());
			tvShow.get().setOutcome_year(tvShowToUpdate.getOutcome_year());
			tvShow.get().setEnd_year(tvShowToUpdate.getEnd_year());
			tvShow.get().setAverage_length(tvShowToUpdate.getAverage_length());
		
		repository.save(tvShow.get());
	}

	@Override
	public void deleteTvShow(TvShow tvShow) {
		repository.delete(tvShow);
	}
	
	

}
