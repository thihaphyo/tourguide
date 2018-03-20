package com.tadv.tour.touradvisor.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tadv.tour.touradvisor.Helpers.FragramentHelper;
import com.tadv.tour.touradvisor.R;


/**
 * Created by root on 3/18/18.
 */

public class BeachFragment extends Fragment {

    public BeachFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return FragramentHelper.CreateView(inflater, R.layout.fragment_beach_trips,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getContext().getString(R.string.string_chaungthar)));
        tabLayout.addTab(tabLayout.newTab().setText(getContext().getString(R.string.string_ngapali)));
        tabLayout.addTab(tabLayout.newTab().setText(getContext().getString(R.string.string_ngwesaung)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
}
