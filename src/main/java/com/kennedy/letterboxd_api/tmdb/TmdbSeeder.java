package com.kennedy.letterboxd_api.tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kennedy.letterboxd_api.movie.Movie;
import com.kennedy.letterboxd_api.movie.MovieRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TmdbSeeder implements CommandLineRunner {
	private final MovieRepository movieRepository;
	private final RestTemplate restTemplate;
	@Value("${tmdb.api.key}")
	private String apiKey;
	@Override
    public void run(String... args) throws Exception {
		String url = String.format("https://api.themoviedb.org/3/movie/popular?api_key=%s&page=1", apiKey);
		TmdbMovieResponse response = restTemplate.getForObject(url,TmdbMovieResponse.class);
		for (TmdbMovie tmdbMovie : response.getResults()) {
			Movie movie = new Movie();
			movie.setTitle(tmdbMovie.getTitle());
			movie.setLanguage(tmdbMovie.getOriginalLanguage());
			movie.setPosterUrl(tmdbMovie.getPosterPath());
			movie.setReleaseYear(Integer.parseInt(tmdbMovie.getReleaseDate().substring(0, 4)));
			movie.setRating(tmdbMovie.getVoteAverage());
			movie.setDirector("Unknown");
			movie.setGenre("Unknown");
			movie.setRuntime(0);
			movieRepository.save(movie);	
		}
    }
}
