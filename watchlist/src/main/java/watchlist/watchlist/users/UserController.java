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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds REST endpoints targeted towards the entity Users.
 * 
 * @author Daniela Simoes
 *
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "UserController"
	)
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
	 * This method returns all Users
	 *
	 * @return ResponseEntity with all existing Users
	 */
	@ApiOperation(
		value = "This endpoint returns all Users",
		response = User.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<UserDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested User
	 *
	 * @param  id Id of the requested User
	 * @return    ResponseEntity with the User that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested User",
			required = true
		) }
	)
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
	 * This method creates a User
	 *
	 * @return ResponseEntity with the User that was created
	 */
	@ApiOperation(
		value = "This endpoint creates a User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The User to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
		this.service.createUser(user);
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested User
	 *
	 * @param  id   Id of the User that should get updated
	 * @param  User user entity to which the requested User should get updated to
	 * @return      ResponseEntity with the updated User
	 */
	@ApiOperation(
		value = "This endpoint updates the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The User to be updated",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
		this.service.updateUser(id, user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested User
	 *
	 * @param  id Id of the User that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested User",
		response = User.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested User",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var user = this.service.getById(id);
		this.service.deleteUser(user.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
