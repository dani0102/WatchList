package watchlist.watchlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class WatchlistController {
	
	@GetMapping(path = "/movies")
	public String showMovies(){
		return "movies";
	}
}

