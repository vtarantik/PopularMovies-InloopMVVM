package com.example.vtarantik.favouritemovies.interactor;

import com.example.vtarantik.favouritemovies.rest.ApiDescription;


/**
 * Created by strv on 06/02/2017.
 */

public class ApiInteractorFactory {
	public static final String TAG = ApiInteractorFactory.class.getName();

	private ApiInteractorFactory() {
	}

	public static IApiInteractor provideApiInteractor(ApiDescription apiDescription) {
		return new ApiInteractor(apiDescription);
	}
}
