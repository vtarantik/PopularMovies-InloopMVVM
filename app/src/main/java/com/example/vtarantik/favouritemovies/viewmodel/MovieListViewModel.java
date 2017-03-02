package com.example.vtarantik.favouritemovies.viewmodel;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.vtarantik.favouritemovies.FavouriteMoviesApp;
import com.example.vtarantik.favouritemovies.R;
import com.example.vtarantik.favouritemovies.databinding.CustomGenericBinding;
import com.example.vtarantik.favouritemovies.entity.Movie;
import com.example.vtarantik.favouritemovies.interactor.IApiInteractor;
import com.example.vtarantik.favouritemovies.utility.LCEStatefulLayout;
import com.example.vtarantik.favouritemovies.view.IMoviesView;

import java.util.List;

import javax.inject.Inject;

import cz.kinst.jakub.view.SimpleStatefulLayout;
import cz.kinst.jakub.view.StatefulLayout;
import eu.inloop.viewmodel.AbstractViewModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by strv on 03/02/2017.
 */

public class MovieListViewModel extends AbstractViewModel<IMoviesView> {
	private static final String TAG = MovieListViewModel.class.getSimpleName();

	public final ObservableArrayList<Movie> movies = new ObservableArrayList<>();

	public SimpleStatefulLayout.StateController stateController;

	@Inject
	IApiInteractor mIApiInteractor;


	@Override
	public void onCreate(@Nullable Bundle arguments, @Nullable Bundle savedInstanceState) {
		FavouriteMoviesApp.getAppComponent().inject(this);

		super.onCreate(arguments, savedInstanceState);

		stateController = LCEStatefulLayout.StateController.create()
				.build();
	}


	@Override
	public void onStart() {
		Log.d(TAG, "onStart");
		if(movies.isEmpty()) {

			getPopularMoviesList();
		}
	}


	@Override
	public void onBindView(@NonNull IMoviesView view) {
		Log.d(TAG, "onBindView");
		super.onBindView(view);
	}


	public void getPopularMoviesList() {

		stateController.setState(LCEStatefulLayout.State.PROGRESS);

		mIApiInteractor.getMovies()
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(movieResponse -> {

					if(movieResponse.getMovies() != null && !movieResponse.getMovies().isEmpty()) {
						stateController.setState(LCEStatefulLayout.State.CONTENT);
						updateData(movieResponse.getMovies());
					} else {
						stateController.setState(LCEStatefulLayout.State.EMPTY);
						if(getView() != null) {
							getView().showEmpty();
						}
					}

				}, throwable -> {
					onError();
				});
	}


	private void onError() {
		Log.d(TAG, "onError");

		if(getView() != null) {
			getView().showEmpty();
		}
	}


	private void updateData(List<Movie> newMovies) {
		Log.d(TAG, "updateData: " + getView());
		movies.clear();
		movies.addAll(newMovies);
		if(getView() != null) {
			getView().showData();
		}
	}


}
