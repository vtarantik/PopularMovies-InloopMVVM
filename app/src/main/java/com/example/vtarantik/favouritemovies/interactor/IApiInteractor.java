package com.example.vtarantik.favouritemovies.interactor;

import com.example.vtarantik.favouritemovies.entity.MovieResponse;

import rx.Observable;


/**
 * Created by strv on 06/02/2017.
 */

public interface IApiInteractor {
	public Observable<MovieResponse> getMovies();

}