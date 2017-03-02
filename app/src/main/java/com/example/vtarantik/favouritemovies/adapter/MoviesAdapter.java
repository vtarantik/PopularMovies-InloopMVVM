package com.example.vtarantik.favouritemovies.adapter;

/**
 * Created by strv on 06/02/2017.
 */

import com.example.vtarantik.favouritemovies.R;
import com.example.vtarantik.favouritemovies.databinding.MovieRowBinding;
import com.example.vtarantik.favouritemovies.view.IMoviesView;
import com.example.vtarantik.favouritemovies.viewmodel.MovieListViewModel;


/**
 * This is an example of a data bound adapter use case where all items have the same type.
 * <p>
 * The parent class handles the item creation and this child class only implements the
 * bindItem to set values in a type checked way.
 */
public class MoviesAdapter extends SimpleDataBoundAdapter<MovieRowBinding> {

	public MoviesAdapter(IMoviesView view, MovieListViewModel viewModel) {
		super(R.layout.movie_row, view, viewModel.movies);
	}

}