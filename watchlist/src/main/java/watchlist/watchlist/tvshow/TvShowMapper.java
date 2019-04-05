package watchlist.watchlist.tvshow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity TvShow.
 * 
 * @author Belinda Schuehle
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TvShowMapper {

	/**
	 * @param tvShow
	 * @return
	 */
	TvShowDTO toDTO(TvShow tvShow);

	/**
	 * @param tvShow
	 * @return
	 */
	List<TvShowDTO> toListDTO(List<TvShow> tvShow);

	/**
	 * @param tvShowDTO
	 * @return
	 */
	TvShow toEntity(TvShowDTO tvShowDTO);

}
