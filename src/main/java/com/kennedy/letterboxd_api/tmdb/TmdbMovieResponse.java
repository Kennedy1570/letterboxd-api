package com.kennedy.letterboxd_api.tmdb;

import java.util.List;

import lombok.Data;

@Data
public class TmdbMovieResponse {
	private List<TmdbMovie> results;
}
