package watchlist.watchlist.users;

import javax.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserServiceable service;
	private UserMapper mapper;
	
	@Autowired
	public UserController(UserServiceable service, UserMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<UserDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
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
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
		this.service.createUser(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody /*Map<String, String>*/User body){
//		this.service.updateUser(id, body);
//		
//		//		this.service.updateUser(id, body.get("firstname"), body.get("lastname"),
////								body.get("birthdate"), body.get("email"), 
////								body.get("username"), body.get("password"));
////		
//		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody User body) {
		this.service.updateUser(body);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
}
