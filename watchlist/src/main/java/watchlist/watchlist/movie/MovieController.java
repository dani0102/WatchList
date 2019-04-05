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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * This class holds REST endpoints targeted towards the entity Movie.
 * 
 * @author Belinda Stifani
 */
@RestController
@RequestMapping("/movies")
@Api(
		value = "MovieController"
	)
public class MovieController {

	private MovieServiceable service;
	private MovieMapper mapper;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public MovieController(MovieServiceable service, MovieMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	/**
	 * This method returns all Movies
	 *
	 * @return ResponseEntity with all existing Movies
	 */
	@ApiOperation(
		value = "This endpoint returns all Movies",
		response = Movie.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<MovieDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested Movie
	 *
	 * @param  id Id of the requested Movie
	 * @return    ResponseEntity with the Movie that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested Movie",
		response = Movie.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested Movie",
			required = true
		) }
	)
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
	
	/**
	 * This method creates a Movie
	 *
	 * @return ResponseEntity with the Movie that was created
	 */
	@ApiOperation(
		value = "This endpoint creates a Movie",
		response = Movie.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The Movie to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createMovie(@RequestBody @Valid Movie movie) {
		this.service.createMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested Movie
	 *
	 * @param  id   Id of the Movie that should get updated
	 * @param  Movie movie entity to which the requested Movie should get updated to
	 * @return      ResponseEntity with the updated Movie
	 */
	@ApiOperation(
		value = "This endpoint updates the requested Movie",
		response = Movie.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The Movie to be updated",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody Movie movie) {
		this.service.updateMovie(id, movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested Movie
	 *
	 * @param  id Id of the Movie that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested Movie",
		response = Movie.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested Movie",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var movie = this.service.getById(id);
		this.service.deleteMovie(movie.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
