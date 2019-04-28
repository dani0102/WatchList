package watchlist.watchlist.authority;

import java.util.List;

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

/**
 * This class holds all REST endpoints targeted towards the entity Authority.
 * 
 * @author Belinda Schuehle
 *
 */
@RestController
@RequestMapping("/authorities")
@Api(
		value = "AuthorityController"
	)
public class AuthorityController {

	private AuthorityServiceable service;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public AuthorityController(AuthorityServiceable service) {
		this.service = service;
	}
	
	/**
	 * This method returns all Authorities
	 *
	 * @return ResponseEntity with all existing Authorities
	 */
	@ApiOperation(
		value = "This endpoint returns all Authorities",
		response = Authority.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<List<Authority>> getAll() {
		List<Authority> authorities = this.service.getAll();
		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested Authority
	 *
	 * @param  id Id of the requested Authority
	 * @return    ResponseEntity with the Authority that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested Authority",
		response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested Authority",
			required = true
		) }
	)
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<Authority> getById(@PathVariable Long id){
		Authority authority = this.service.findById(id);
		
			return new ResponseEntity<>(authority, HttpStatus.OK);
	}
	
	/**
	 * This method creates an Authority
	 *
	 * @return ResponseEntity with the Authority that was created
	 */
	@ApiOperation(
		value = "This endpoint creates an Authority",
		response = Authority.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The Authority to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createAuthority(@RequestBody @Valid Authority authority){
		this.service.createAuthority(authority);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
