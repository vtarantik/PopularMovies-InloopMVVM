package com.example.vtarantik.favouritemovies.viewmodel;

import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.vtarantik.favouritemovies.activity.MovieDetailActivity;
import com.example.vtarantik.favouritemovies.entity.Movie;
import com.example.vtarantik.favouritemovies.view.IMovieDetailView;

import eu.inloop.viewmodel.AbstractViewModel;


/**
 * Created by strv on 13/02/2017.
 */

public class MovieDetailViewModel extends AbstractViewModel<IMovieDetailView>{
	private static final String TAG  = MovieDetailViewModel.class.getSimpleName();

	public final ObservableField<Movie> movie = new ObservableField<>();

	@Override
	public void onBindView(@NonNull IMovieDetailView view) {
		super.onBindView(view);

		handleExtras(view.getExtras());
	}


	private void handleExtras(Bundle extras)
	{
		if(extras != null)
		{
			movie.set(extras.getParcelable(MovieDetailActivity.EXTRA_MOVIE));
		}
	}
}
