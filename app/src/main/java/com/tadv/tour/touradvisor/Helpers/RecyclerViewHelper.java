package com.tadv.tour.touradvisor.Helpers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.tadv.tour.touradvisor.Adapters.HomeAdpater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/17/18.
 */

public class RecyclerViewHelper {

    public static LinearLayoutManager BuildLayoutMan(Context context, RecyclerView rv, boolean isFixed)
    {
        rv.setHasFixedSize(true);
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }

    public static void recyclerBuild(Context context, RecyclerView rv, RecyclerView.Adapter adapter, List arrayList){

        rv.setLayoutManager(BuildLayoutMan(context,rv,true));

        adapter = new HomeAdpater(context,arrayList);

        rv.setAdapter(adapter);


    }
}
