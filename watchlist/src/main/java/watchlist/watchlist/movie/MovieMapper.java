package watchlist.watchlist.movie;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity Movie.
 * 
 * @author Belinda Stifani
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {

	MovieDTO toDTO(Movie movie);

	List<MovieDTO> toListDTO(List<Movie> movie);

	Movie toEntity(MovieDTO movieDTO);

}
