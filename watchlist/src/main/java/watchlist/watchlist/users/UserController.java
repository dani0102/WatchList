package watchlist.watchlist.users;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * 
 * @author Daniela Simoes
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private UserServiceable service;
	private UserMapper mapper;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public UserController(UserServiceable service, UserMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	/**
	 * @return
	 */
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<UserDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * @param user
	 * @return
	 */
	@PostMapping({"", "/"})
	public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
		this.service.createUser(user);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	/**
	 * @param id
	 * @param user
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
		this.service.updateUser(id, user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var user = this.service.getById(id);
		this.service.deleteUser(user.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
