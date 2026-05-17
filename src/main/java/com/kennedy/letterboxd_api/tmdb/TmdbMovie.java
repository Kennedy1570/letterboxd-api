package com.kennedy.letterboxd_api.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class TmdbMovie {
	private String title;
	private String overview;
	@JsonProperty("release_date")
	private String releaseDate;
	@JsonProperty("original_language")
	private String originalLanguage;
	@JsonProperty("vote_average")
	private double voteAverage;
	@JsonProperty("poster_path")
	private String posterPath;
	
}
