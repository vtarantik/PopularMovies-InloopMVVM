package com.example.vtarantik.favouritemovies.view;


import com.example.vtarantik.favouritemovies.entity.Movie;

import eu.inloop.viewmodel.IView;


/**
 * Created by strv on 03/02/2017.
 */

public interface IMoviesView  extends IView{

	void showEmpty();

	void showProgress();

	void showData();

	void onItemClick(Movie movie);

}
