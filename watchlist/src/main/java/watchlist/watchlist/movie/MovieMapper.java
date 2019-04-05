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

	/**
	 * @param movie
	 * @return
	 */
	MovieDTO toDTO(Movie movie);

	/**
	 * @param movies
	 * @return
	 */
	List<MovieDTO> toListDTO(List<Movie> movies);

	/**
	 * @param movieDTO
	 * @return
	 */
	Movie toEntity(MovieDTO movieDTO);

}
