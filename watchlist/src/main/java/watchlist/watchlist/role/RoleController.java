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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import watchlist.watchlist.movie.Movie;

/**
 * This class holds all REST endpoints targeted towards the entity Role.
 * 
 * @author Belinda Schuehle
 *
 */
@RestController
@RequestMapping("/roles")
@Api(
		value = "RoleController"
	)
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
	 * This method returns all Roles
	 *
	 * @return ResponseEntity with all existing Roles
	 */
	@ApiOperation(
		value = "This endpoint returns all Roles",
		response = Role.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<RoleDTO>> getAll() {
		var result = service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested Role
	 *
	 * @param  id Id of the requested Role
	 * @return    ResponseEntity with the Role that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested Role",
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested Role",
			required = true
		) }
	)
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<RoleDTO> getById(@PathVariable long id){
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * This method creates a Role
	 *
	 * @return ResponseEntity with the Role that was created
	 */
	@ApiOperation(
		value = "This endpoint creates a Role",
		response = Role.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The Role to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createRole(@RequestBody @Valid Role role){
		this.service.createRole(role);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
