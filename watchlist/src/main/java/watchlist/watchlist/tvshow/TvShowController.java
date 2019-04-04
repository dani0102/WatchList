package watchlist.watchlist.tvshow;

<<<<<<< Updated upstream
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

=======
>>>>>>> Stashed changes
/**
 * This class holds REST endpoints targeted towards the entity tv-shows
 * 
 * @author Belinda Schuehle
 */
<<<<<<< Updated upstream
@RestController
@RequestMapping("/tv-shows")
public class TvShowController {

	private TvShowServiceable service;
	private TvShowMapper mapper;
	
	@Autowired
	public TvShowController(TvShowServiceable service, TvShowMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<TvShowDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<TvShowDTO> getById(@PathVariable Long id) {
		var result = this.service.getById(id);
		var toReturn = mapper.toDTO(result.get());
		
		if(result.isPresent()) {
			return new ResponseEntity<>(toReturn, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping({"", "/"})
	public ResponseEntity<?> createTvShow(@RequestBody @Valid TvShow tvShow) {
		this.service.createTvShow(tvShow);
		return new ResponseEntity<>(tvShow, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody TvShow tvShow) {
		this.service.updateTvShow(id, tvShow);
		return new ResponseEntity<>(tvShow, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var tvShow = this.service.getById(id);
		this.service.deleteTvShow(tvShow.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
=======

public class TvShowController {

>>>>>>> Stashed changes
}
