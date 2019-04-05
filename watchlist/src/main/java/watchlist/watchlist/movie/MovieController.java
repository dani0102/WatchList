package watchlist.watchlist.movie;

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
 * This class holds REST endpoints targeted towards the entity Movie
 * 
 * @author Belinda Stifani
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

	private MovieServiceable service;
	private MovieMapper mapper;
	
	@Autowired
	public MovieController(MovieServiceable service, MovieMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<MovieDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createMovie(@RequestBody @Valid Movie movie) {
		this.service.createMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody Movie movie) {
		this.service.updateMovie(id, movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var movie = this.service.getById(id);
		this.service.deleteMovie(movie.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
