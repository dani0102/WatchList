package watchlist.watchlist.authority;

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
 * This class holds all REST endpoints targeted towards the entity Authority.
 * 
 * @author Belinda Schuehle
 *
 */
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

	private AuthorityServiceable service;
	private AuthorityMapper mapper;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public AuthorityController(AuthorityServiceable service, AuthorityMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	/**
	 * @return
	 */
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<AuthorityDTO>> getAll() {
		var result = service.getAll();
		var toReturn = mapper.toListDTO(result);
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping({"/{id}"})
	public @ResponseBody ResponseEntity<AuthorityDTO> getById(@PathVariable long id){
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * @param authority
	 * @return
	 */
	@PostMapping({"", "/"})
	public ResponseEntity<?> createAuthority(@RequestBody @Valid Authority authority){
		this.service.createAuthority(authority);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
