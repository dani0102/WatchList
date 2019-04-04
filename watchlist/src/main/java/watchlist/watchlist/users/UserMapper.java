package watchlist.watchlist.users;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserDTO toDTO(User user);
	
	List<UserDTO> toListDTO(List<User> user);
	
	User toEntity(UserDTO user);
	
}
