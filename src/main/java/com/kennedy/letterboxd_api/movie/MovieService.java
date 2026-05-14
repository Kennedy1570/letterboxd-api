package com.kennedy.letterboxd_api.movie;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieRepository movieRepository;
	
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	public Movie getMovie(Long id) {
		return movieRepository.findById(id).orElseThrow(()-> new RuntimeException ("Movie does not exist"));
	}
	
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	public List<Movie> searchByTitle(String title) {
		return movieRepository.findByTitleContainingIgnoreCase(title);
	}
	public List<Movie> searchByDirector(String director) {
		return movieRepository.findByDirectorContainingIgnoreCase(director);
	}
	public List<Movie> searchByGenre(String genre) {
		return movieRepository.findByGenreContainingIgnoreCase(genre);
	}
	public Movie updateMovie(Long id, Movie updatedMovie) {
		Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie does not exist"));
		existingMovie.setTitle(updatedMovie.getTitle());
		existingMovie.setDirector(updatedMovie.getDirector());
		existingMovie.setGenre(updatedMovie.getGenre());
		existingMovie.setLanguage(updatedMovie.getLanguage());
		existingMovie.setPosterUrl(updatedMovie.getPosterUrl());
		existingMovie.setRuntime(updatedMovie.getRuntime());
		existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
		existingMovie.setRating(updatedMovie.getRating());
		
		return movieRepository.save(existingMovie);
	}
}
