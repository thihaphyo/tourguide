package com.tadv.tour.touradvisor.Helpers;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.tadv.tour.touradvisor.Activities.BeachActivity;
import com.tadv.tour.touradvisor.Models.BeachTabItems;
import com.tadv.tour.touradvisor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/20/18.
 */

public class TabGenerator {

    private final String TAG =this.getClass().toString();

    public void Generate(TabLayout tabLayout, Context context, List<BeachTabItems> lstTabs){

        try{

            for(int z =0 ; z < lstTabs.size(); z++)
            {
                tabLayout.addTab(tabLayout.newTab());
                TextView tabOne = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab,null);
                tabOne.setText(lstTabs.get(z).getTab_name());
                tabLayout.getTabAt(z).setCustomView(tabOne);

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d(TAG,ex.toString());
        }

    }
}
