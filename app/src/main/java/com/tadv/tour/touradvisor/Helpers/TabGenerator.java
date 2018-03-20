package com.tadv.tour.touradvisor.Helpers;

import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tadv.tour.touradvisor.Models.BeachTabItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/20/18.
 */

public class TabGenerator {

    private final String TAG =this.getClass().toString();

    public void Generate(TabLayout tabLayout, TextView tab,List<BeachTabItems> lstTabs){

        try{
            for(int i =0; i< lstTabs.size(); i++)
            {
                tabLayout.addTab(tabLayout.newTab());
                tab.setText(lstTabs.get(i).getTab_name());
                tabLayout.getTabAt(i).setCustomView(tab);

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
            Log.d(TAG,ex.toString());
        }

    }
}
