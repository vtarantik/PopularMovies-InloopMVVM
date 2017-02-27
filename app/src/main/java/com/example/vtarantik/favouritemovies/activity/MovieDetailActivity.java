package com.example.vtarantik.favouritemovies.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.vtarantik.favouritemovies.R;
import com.example.vtarantik.favouritemovies.entity.Movie;

import eu.inloop.viewmodel.base.ViewModelBaseEmptyActivity;


/**
 * Created by strv on 13/02/2017.
 */

public class MovieDetailActivity extends ViewModelBaseEmptyActivity {
	public static final String EXTRA_MOVIE = "movie";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_detail);
	}

	public static Intent newIntent(Context context, Movie movie){
		Intent intent = new Intent(context,MovieDetailActivity.class);
		intent.putExtra(EXTRA_MOVIE,movie);

		return intent;
	}
}
