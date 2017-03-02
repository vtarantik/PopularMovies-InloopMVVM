package com.example.vtarantik.favouritemovies.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.vtarantik.favouritemovies.R;
import com.example.vtarantik.favouritemovies.activity.MovieDetailActivity;
import com.example.vtarantik.favouritemovies.adapter.MoviesAdapter;
import com.example.vtarantik.favouritemovies.databinding.CustomGenericBinding;
import com.example.vtarantik.favouritemovies.databinding.FragmentMovieListBinding;
import com.example.vtarantik.favouritemovies.entity.Movie;
import com.example.vtarantik.favouritemovies.view.IMoviesView;
import com.example.vtarantik.favouritemovies.viewmodel.MovieListViewModel;

import cz.kinst.jakub.view.StatefulLayout;
import eu.inloop.viewmodel.binding.ViewModelBaseBindingFragment;
import eu.inloop.viewmodel.binding.ViewModelBindingConfig;


/**
 * Created by strv on 03/02/2017.
 */

public class MovieListFragment extends ViewModelBaseBindingFragment<IMoviesView, MovieListViewModel, FragmentMovieListBinding> implements IMoviesView {
	private static final String TAG = MovieListFragment.class.getSimpleName();

//	public static final String STATE_1 = "state_1";
//	public static final String STATE_2 = "state_2";
//	public static final String STATE_3 = "state_3";

	private MoviesAdapter mMoviesAdapter;

//	private StatefulLayout.StateController mStateController;


	public MovieListFragment() {

	}


	@Nullable
	@Override
	public Class<MovieListViewModel> getViewModelClass() {
		return MovieListViewModel.class;
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//
//		CustomGenericBinding state1 = CustomGenericBinding.inflate(getActivity().getLayoutInflater());
//		state1.setContent("State 1");
//		CustomGenericBinding state2 = CustomGenericBinding.inflate(getActivity().getLayoutInflater());
//		state2.setContent("State 2");
//		CustomGenericBinding state3 = CustomGenericBinding.inflate(getActivity().getLayoutInflater());
//		state3.setContent("State 3");
//
//		mStateController = StatefulLayout.StateController.create()
//				.withState(STATE_1, state1.getRoot())
//				.withState(STATE_2, state2.getRoot())
//				.withState(STATE_3, state3.getRoot())
//				.build();
//		getBinding().setStateController(mStateController);

	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated");

		setModelView(this);

//		mStateController.setState(StatefulLayout.State.CONTENT);

	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");

		getBinding().executePendingBindings();

		setupAdapter();
	}


	@Nullable
	@Override
	public ViewModelBindingConfig getViewModelBindingConfig() {
		return new ViewModelBindingConfig(R.layout.fragment_movie_list, getActivity());
	}


	@Override
	public void showEmpty() {

	}


	@Override
	public void showProgress() {

	}

//
//	@Override
//	public void showProgress() {
//		mStateController.setState(STATE_2);
//	}


	@Override
	public void showData() {
//		mStateController.setState(StatefulLayout.State.CONTENT);
		mMoviesAdapter.notifyDataSetChanged();
	}


	@Override
	public void onItemClick(Movie movie) {
		startMovieDetailActivity(movie);
	}


	private void setupAdapter() {
		Log.d(TAG,"setupAdapter");
		if(mMoviesAdapter == null) {
			mMoviesAdapter = new MoviesAdapter(this, getViewModel());
			getBinding().movieList.setAdapter(mMoviesAdapter);
		}
	}


	private void startMovieDetailActivity(Movie movie){
		Intent intent = MovieDetailActivity.newIntent(getActivity(),movie);
		startActivity(intent);
	}
}
