package watchlist.watchlist.role;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class holds all REST endpoints targeted towards the entity Role.
 * 
 * @author Belinda Schuehle
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	private RoleServiceable service;
	private RoleMapper mapper;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public RoleController(RoleServiceable service, RoleMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	/**
	 * @return
	 */
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<RoleDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<RoleDTO> getById(@PathVariable Long id){
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * @param role
	 * @return
	 */
	@PostMapping({"", "/"})
	public ResponseEntity<?> createRole(@RequestBody @Valid Role role){
		this.service.createRole(role);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
