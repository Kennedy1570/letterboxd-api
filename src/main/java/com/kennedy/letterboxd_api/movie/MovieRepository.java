package com.kennedy.letterboxd_api.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	//find title ignore case sensitivity
	List<Movie> findByTitleContainingIgnoreCase(String title);
	//find director ignore case sensitivity
	List<Movie> findByDirectorContainingIgnoreCase(String director);
	//find Genre ignore case sensitivity
	List<Movie> findByGenreContainingIgnoreCase(String genre);
}
