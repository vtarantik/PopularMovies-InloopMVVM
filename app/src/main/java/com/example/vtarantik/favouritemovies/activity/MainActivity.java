package com.example.vtarantik.favouritemovies.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.vtarantik.favouritemovies.R;

import eu.inloop.viewmodel.base.ViewModelBaseEmptyActivity;


/**
 * Created by strv on 03/02/2017.
 */

public class MainActivity extends ViewModelBaseEmptyActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);



	}

}
