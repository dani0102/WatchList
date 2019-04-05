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

	/**
	 * @param authority
	 * @return
	 */
	AuthorityDTO toDTO(Authority authority);
	
	/**
	 * @param authorities
	 * @return
	 */
	List<AuthorityDTO> toListDTO(List<Authority> authorities);
	
	/**
	 * @param authorityDTO
	 * @return
	 */
	Authority toEntity(AuthorityDTO authorityDTO);
}
