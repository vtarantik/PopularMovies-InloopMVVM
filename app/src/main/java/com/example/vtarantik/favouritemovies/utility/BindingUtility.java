package com.example.vtarantik.favouritemovies.utility;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.*;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * Created by strv on 03/02/2017.
 */

public final class BindingUtility {

	private static final String POSTER_PATH = "http://image.tmdb.org/t/p/w185";

	public enum RecyclerLayout
	{
		LINEAR_VERTICAL
	}


	public enum RecyclerDecoration
	{
		LINEAR_DIVIDER
	}


	@BindingAdapter({"bind:imageUrl"})
	public static void loadImage(ImageView view, String url) {
		Picasso.with(view.getContext())
				.load(POSTER_PATH+url)
				.transform(new CircleTransform())
				.into(view);
	}


	@BindingAdapter({"bind:posterUrl"})
	public static void loadPoster(ImageView view, String url){
		Picasso.with(view.getContext())
				.load(POSTER_PATH+url)
				.fit().centerCrop()
				.into(view);

	}

	@BindingAdapter({"recyclerLayout"})
	public static void setRecyclerLayout(RecyclerView recyclerView, RecyclerLayout recyclerLayout)
	{
		RecyclerView.LayoutManager layoutManager;

		if(recyclerLayout == RecyclerLayout.LINEAR_VERTICAL)
		{
			LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
			linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
			layoutManager = linearLayoutManager;
		}
		else
		{
			throw new IllegalArgumentException();
		}

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
	}


	@BindingAdapter({"recyclerDecoration"})
	public static void setRecyclerDecoration(RecyclerView recyclerView, RecyclerDecoration recyclerDecoration)
	{
		RecyclerView.ItemDecoration itemDecoration;

		if(recyclerDecoration == RecyclerDecoration.LINEAR_DIVIDER)
		{
			itemDecoration = new DividerItemDecoration(recyclerView.getContext());
		}
		else
		{
			throw new IllegalArgumentException();
		}

		recyclerView.addItemDecoration(itemDecoration);
	}
}
