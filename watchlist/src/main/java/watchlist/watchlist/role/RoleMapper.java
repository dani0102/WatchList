package watchlist.watchlist.role;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity Role.
 * 
 * @author Belinda Schuehle
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

	/**
	 * @param role
	 * @return
	 */
	RoleDTO toDTO(Role role);
	
	/**
	 * @param roles
	 * @return
	 */
	List<RoleDTO> toListDTO(List<Role> roles);
	
	/**
	 * @param role
	 * @return
	 */
	Role toEntity(RoleDTO role);
}
