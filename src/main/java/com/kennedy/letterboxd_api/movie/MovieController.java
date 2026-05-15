package com.kennedy.letterboxd_api.movie;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Movie>> getAllMovies() {
	    List<Movie> allMovies = movieService.getAllMovies();
		return ResponseEntity.status(200).body(allMovies);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
		Movie gottenMovie = movieService.getMovie(id);
		return ResponseEntity.status(200).body(gottenMovie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		Movie created = movieService.createMovie(movie);
		return ResponseEntity.status(201).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		Movie updated = movieService.updateMovie(id, movie);
		return ResponseEntity.status(200).body(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search/title")
	public ResponseEntity<List<Movie>> searchByTitle(@RequestParam String query) {
		List<Movie> title = movieService.searchByTitle(query);
		return ResponseEntity.status(200).body(title);
	}
	
	@GetMapping("/search/director")
	public ResponseEntity<List<Movie>> searchByDirector(@RequestParam String query) {
		List<Movie> director = movieService.searchByDirector(query);
		return ResponseEntity.status(200).body(director);
	}
	
	@GetMapping("/search/genre")
	public ResponseEntity<List<Movie>> searchByGenre(@RequestParam String query) {
		List<Movie> genre = movieService.searchByGenre(query);
		return ResponseEntity.status(200).body(genre);
	}
	
}
