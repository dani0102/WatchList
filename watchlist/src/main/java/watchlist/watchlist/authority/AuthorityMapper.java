package watchlist.watchlist.authority;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity Authority.
 * 
 * @author Belinda Schuehle
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper {

	AuthorityDTO toDTO(Authority authority);
	
	List<AuthorityDTO> toListDTO(List<Authority> authorities);
	
	Authority toEntity(AuthorityDTO authority);
}
