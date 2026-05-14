package com.kennedy.letterboxd_api.movie;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
	private final MovieService movieService;
	// Spring
	@GetMapping
	public List<Movie> getAllMovies() {
	    return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable Long id) {
		return movieService.getMovie(id);
	}
	
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}
	
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		return movieService.updateMovie(id, movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
	}
	
	@GetMapping("/search/title")
	public List<Movie> searchByTitle(@RequestParam String query) {
		return movieService.searchByTitle(query);
	}
	
	@GetMapping("/search/director")
	public List<Movie> searchByDirector(@RequestParam String query) {
		return movieService.searchByDirector(query);
	}
	
	@GetMapping("/search/genre")
	public List<Movie> searchByGenre(@RequestParam String query) {
		return movieService.searchByGenre(query);
	}
	
}
