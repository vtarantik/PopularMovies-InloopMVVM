package com.example.vtarantik.favouritemovies.dagger;

import android.app.Application;
import android.view.LayoutInflater;

import com.example.vtarantik.favouritemovies.FavouriteMoviesApp;
import com.example.vtarantik.favouritemovies.entity.Movie;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by strv on 06/02/2017.
 */

@Module(
		includes = {
				InteractorsModule.class
		}
)
public class AppModule {
	public static final String TAG = AppModule.class.getName();

	private final FavouriteMoviesApp app;

	public AppModule(FavouriteMoviesApp app) {
		this.app = app;
	}

	@Provides
	@Singleton
	public Application provideApplication() {
		return app;
	}

	@Provides
	@Singleton
	LayoutInflater provideLayoutInflater() {
		return LayoutInflater.from(app);
	}

	@Provides
	@Singleton
	Movie provideMovie(){
		return new Movie();
	}

}
