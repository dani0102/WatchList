package watchlist.watchlist.tvshow;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity Tv-Show.
 * 
 * @author Belinda Schuehle
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TvShowMapper {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
	TvShowDTO toDTO(TvShow tvShow);
=======
	TvShow toDTO(TvShow tvShow);
>>>>>>> Stashed changes
=======
	TvShow toDTO(TvShow tvShow);
>>>>>>> Stashed changes

	List<TvShowDTO> toListDTO(List<TvShow> tvShow);

	TvShow toEntity(TvShowDTO tvShowDTO);

}
