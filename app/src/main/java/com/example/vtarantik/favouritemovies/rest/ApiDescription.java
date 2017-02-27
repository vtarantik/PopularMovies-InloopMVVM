package com.example.vtarantik.favouritemovies.rest;


import com.example.vtarantik.favouritemovies.entity.MovieResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by strv on 02/02/2017.
 */

public interface ApiDescription {
	String API_ENDPOINT = "https://api.themoviedb.org/";

	@GET("/3/movie/popular")
	Observable<MovieResponse> getPopularMovies(
			@Query("api_key") String apiKey
	);

}
