package watchlist.watchlist.tvshow;

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
import watchlist.watchlist.movie.Movie;

/**
 * This class holds REST endpoints targeted towards the entity TvShow.
 * 
 * @author Belinda Schuehle
 */
@RestController
@RequestMapping("/tv-shows")
@Api(
		value = "TvShowController"
	)
public class TvShowController {

	private TvShowServiceable service;
	private TvShowMapper mapper;
	
	/**
	 * @param service
	 * @param mapper
	 */
	@Autowired
	public TvShowController(TvShowServiceable service, TvShowMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}
	
	/**
	 * This method returns all TvShows
	 *
	 * @return ResponseEntity with all existing TvShows
	 */
	@ApiOperation(
		value = "This endpoint returns all TvShows",
		response = TvShow.class
	)
	@GetMapping({"", "/"})
	public @ResponseBody ResponseEntity<Iterable<TvShowDTO>> getAll() {
		var result = this.service.getAll();
		var toReturn = mapper.toListDTO(result);
		
		return new ResponseEntity<>(toReturn, HttpStatus.OK);
	}
	
	/**
	 * This method returns the requested TvShow
	 *
	 * @param  id Id of the requested TvShow
	 * @return    ResponseEntity with the TvShow that was requested
	 */
	@ApiOperation(
		value = "This endpoint returns the requested TvShow",
		response = TvShow.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested TvShow",
			required = true
		) }
	)
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
	
	/**
	 * This method creates a TvShow
	 *
	 * @return ResponseEntity with the TvShow that was created
	 */
	@ApiOperation(
		value = "This endpoint creates a TvShow",
		response = TvShow.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The TvShow to be created",
			required = true
		) }
	)
	@PostMapping({"", "/"})
	public ResponseEntity<?> createTvShow(@RequestBody @Valid TvShow tvShow) {
		this.service.createTvShow(tvShow);
		return new ResponseEntity<>(tvShow, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested TvShow
	 *
	 * @param  id   Id of the TvShow that should get updated
	 * @param  TvShow tvShow entity to which the requested TvShow should get updated to
	 * @return      ResponseEntity with the updated TvShow
	 */
	@ApiOperation(
		value = "This endpoint updates the requested TvShow",
		response = TvShow.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "The TvShow to be updated",
			required = true
		) }
	)
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody TvShow tvShow) {
		this.service.updateTvShow(id, tvShow);
		return new ResponseEntity<>(tvShow, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested TvShow
	 *
	 * @param  id Id of the TvShow that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
		value = "This endpoint deletes the requested TvShow",
		response = TvShow.class
	)
	@ApiImplicitParams(
		{ @ApiImplicitParam(
			value = "Id of requested TvShow",
			required = true
		) }
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		var tvShow = this.service.getById(id);
		this.service.deleteTvShow(tvShow.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
