package com.tadv.tour.touradvisor.CustomUI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.tadv.tour.touradvisor.Helpers.AssetHelper;


/**
 * Created by root on 3/17/18.
 */

public class AdvisorTextView extends AppCompatTextView {
    public AdvisorTextView(Context context) {
        super(context);
        init();
    }

    public AdvisorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AdvisorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        Typeface tf = AssetHelper.Load(getContext().getAssets(),"myanmar2.ttf");
        setTypeface(tf ,1);

    }
}
