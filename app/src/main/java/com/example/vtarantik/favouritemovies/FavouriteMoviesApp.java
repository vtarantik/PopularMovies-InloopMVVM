package com.example.vtarantik.favouritemovies;

import android.app.Application;

import com.example.vtarantik.favouritemovies.dagger.AppComponent;
import com.example.vtarantik.favouritemovies.dagger.AppModule;
import com.example.vtarantik.favouritemovies.dagger.DaggerAppComponent;
import com.example.vtarantik.favouritemovies.dagger.InteractorsModule;


/**
 * Created by strv on 03/02/2017.
 */

public class FavouriteMoviesApp extends Application {
	public static final String TAG = FavouriteMoviesApp.class.getName();

	private static AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		// Initialize Dagger
		appComponent = DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.build();
	}

	public static AppComponent getAppComponent() {
		return appComponent;
	}
}
