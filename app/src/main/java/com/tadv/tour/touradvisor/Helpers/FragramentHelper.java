package com.tadv.tour.touradvisor.Helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 3/17/18.
 */

public class FragramentHelper {

    public static View CreateView(LayoutInflater layoutInflater, int layout_id, ViewGroup viewGroup, boolean attach){

        return layoutInflater.inflate(layout_id, viewGroup, false);
    }
}
