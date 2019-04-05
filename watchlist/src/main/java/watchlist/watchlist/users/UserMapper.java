package watchlist.watchlist.users;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * This interface defines all the mappings of the entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	/**
	 * @param user
	 * @return
	 */
	UserDTO toDTO(User user);
	
	/**
	 * @param user
	 * @return
	 */
	List<UserDTO> toListDTO(List<User> user);
	
	/**
	 * @param user
	 * @return
	 */
	User toEntity(UserDTO user);
	
}
