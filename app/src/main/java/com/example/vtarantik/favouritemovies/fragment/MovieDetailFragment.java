package com.example.vtarantik.favouritemovies.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vtarantik.favouritemovies.R;
import com.example.vtarantik.favouritemovies.databinding.FragmentMovieDetailBinding;
import com.example.vtarantik.favouritemovies.view.IMovieDetailView;
import com.example.vtarantik.favouritemovies.viewmodel.MovieDetailViewModel;
import com.example.vtarantik.favouritemovies.BR;

import eu.inloop.viewmodel.binding.ViewModelBaseBindingFragment;
import eu.inloop.viewmodel.binding.ViewModelBindingConfig;


/**
 * Created by strv on 13/02/2017.
 */

public class MovieDetailFragment extends ViewModelBaseBindingFragment<IMovieDetailView,MovieDetailViewModel,FragmentMovieDetailBinding> implements IMovieDetailView{
	private FragmentMovieDetailBinding binding;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		 super.onCreateView(inflater, container, savedInstanceState);

		binding = setupBinding(inflater);

		return binding.getRoot();
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setModelView(this);
	}


	@Nullable
	@Override
	public Class<MovieDetailViewModel> getViewModelClass() {
		return MovieDetailViewModel.class;
	}


	@Nullable
	@Override
	public ViewModelBindingConfig getViewModelBindingConfig() {
		return new ViewModelBindingConfig(R.layout.fragment_movie_detail, getActivity());
	}

	@Override
	public Bundle getExtras() {
		return getActivity().getIntent().getExtras();
	}


	private FragmentMovieDetailBinding setupBinding(LayoutInflater inflater){
		FragmentMovieDetailBinding bindingToReturn = FragmentMovieDetailBinding.inflate(inflater);
		bindingToReturn.setVariable(BR.view, this);
		bindingToReturn.setVariable(BR.viewModel, getViewModel());
		return bindingToReturn;
	}
}
