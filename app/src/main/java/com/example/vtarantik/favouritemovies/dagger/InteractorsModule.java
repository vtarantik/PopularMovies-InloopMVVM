package com.example.vtarantik.favouritemovies.dagger;

import com.example.vtarantik.favouritemovies.interactor.ApiInteractorFactory;
import com.example.vtarantik.favouritemovies.interactor.IApiInteractor;
import com.example.vtarantik.favouritemovies.rest.ApiDescription;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by vtarantik on 10.1.2017.
 * Interactor modules providing the needs necessary for interaction with the API
 */

@Module(
		includes = {ServiceModule.class}
)
public class InteractorsModule {
	public static final String TAG = InteractorsModule.class.getName();

	@Provides
	@Singleton
	public IApiInteractor provideApiInteractor(ApiDescription apiDescription) {
		return ApiInteractorFactory.provideApiInteractor(apiDescription);
	}
}
