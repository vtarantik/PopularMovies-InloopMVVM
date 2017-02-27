package com.example.vtarantik.favouritemovies.interactor;

import com.example.vtarantik.favouritemovies.BuildConfig;
import com.example.vtarantik.favouritemovies.entity.MovieResponse;
import com.example.vtarantik.favouritemovies.rest.ApiDescription;

import rx.Observable;


/**
 * Created by strv on 06/02/2017.
 */

public class ApiInteractor implements IApiInteractor{
	public static final String TAG = ApiInteractor.class.getName();
	private final ApiDescription apiDescription;

	public ApiInteractor(ApiDescription apiDescription) {
		this.apiDescription = apiDescription;
	}

	@Override
	public Observable<MovieResponse> getMovies() {
		return this.apiDescription.getPopularMovies(BuildConfig.API_KEY);
	}

}
