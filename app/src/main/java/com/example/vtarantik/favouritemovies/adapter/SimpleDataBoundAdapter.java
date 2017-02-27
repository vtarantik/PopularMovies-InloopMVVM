package com.example.vtarantik.favouritemovies.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;


import com.example.vtarantik.favouritemovies.BR;

import java.util.List;

import eu.inloop.viewmodel.IView;


/**
 * Created by strv on 08/02/2017.
 */

abstract public class SimpleDataBoundAdapter<T extends ViewDataBinding> extends BaseDataBoundAdapter<T> {

	@LayoutRes private int mLayoutId;
	private IView mView;
	private ObservableArrayList<?> mItems;


	public SimpleDataBoundAdapter(@LayoutRes int layoutId, IView view, ObservableArrayList<?> items) {
		mLayoutId = layoutId;
		mView = view;
		mItems = items;
	}


	@Override
	protected void bindItem(DataBoundViewHolder<T> holder, int position, List<Object> payloads) {
		holder.binding.setVariable(BR.view,mView);
		holder.binding.setVariable(BR.data,mItems.get(position));
	}


	@Override
	public int getItemLayoutId(int position) {
		return mLayoutId;
	}


	@Override
	public int getItemCount() {
		return mItems.size();
	}
}
