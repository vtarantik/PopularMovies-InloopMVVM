package com.example.vtarantik.favouritemovies.utility;

import android.content.Context;
import android.util.AttributeSet;

import cz.kinst.jakub.view.SimpleStatefulLayout;


/**
 * Created by strv on 02/03/2017.
 */

public class LCEStatefulLayout extends SimpleStatefulLayout {
	public LCEStatefulLayout(Context context) {
		super(context);
	}


	public LCEStatefulLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	public LCEStatefulLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}


	@Override
	public void clearStates() {
		//Do nothing here to preserve the original states
	}
}
