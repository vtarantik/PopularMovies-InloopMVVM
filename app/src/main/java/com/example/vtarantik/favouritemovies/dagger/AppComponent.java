package com.example.vtarantik.favouritemovies.dagger;

import com.example.vtarantik.favouritemovies.viewmodel.MovieListViewModel;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by strv on 06/02/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

	void inject(MovieListViewModel moviesViewModel);
}
