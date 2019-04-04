package watchlist.watchlist.authority;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/authorities")
public class AuthorityController {

	private AuthorityServiceable service;
	private AuthorityMapper mapper;
	
	@Autowired
	public AuthorityController(AuthorityServiceable service, AuthorityMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<AuthorityDTO>> getAll() {
		var result = service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
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
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createFachrichtung(@RequestBody @Valid AuthorityDTO valueToAdd){
		var toCreate = mapper.toEntity(valueToAdd);
		service.createFachrichtung(toCreate);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
