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

	RoleDTO toDTO(Role role);
	
	List<RoleDTO> toListDTO(List<Role> roles);
	
	Role toEntity(RoleDTO role);
}
