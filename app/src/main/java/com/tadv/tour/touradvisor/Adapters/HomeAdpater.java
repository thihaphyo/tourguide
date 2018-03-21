package com.tadv.tour.touradvisor.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.tadv.tour.touradvisor.Activities.BeachActivity;
import com.tadv.tour.touradvisor.CustomListeners.CardClickListener;
import com.tadv.tour.touradvisor.Models.DashboardItems;
import com.tadv.tour.touradvisor.R;
import com.tadv.tour.touradvisor.ViewHolders.HomeRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/17/18.
 */

public class HomeAdpater extends RecyclerView.Adapter<HomeRecyclerViewHolder> {


    private List<DashboardItems> dashboardItemsArrayList;
    private Context c;
    private CardClickListener cardClickListener;

    public HomeAdpater(Context c,List<DashboardItems> dashboardItemsArrayList){

        this.c = c;
        this.dashboardItemsArrayList = dashboardItemsArrayList;
    }

    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.card_home,parent,false);

        HomeRecyclerViewHolder viewHolder = new HomeRecyclerViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewHolder holder, int position) {

        DashboardItems dashboardItems = dashboardItemsArrayList.get(position);

        holder.txtItemName.setText(dashboardItems.menu_name);
        String url = dashboardItems.menu_image_url;
        Picasso.get()
                .load(url)
                .resize(80, 80)
                .centerCrop()
                .into(holder.imageView);

        holder.setCardclickListener(new CardClickListener() {
            @Override
            public void onClick(int position) {
                switch (position){
                    case 0:
                        Intent i = new Intent(c,BeachActivity.class);
                        c.startActivity(i);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return dashboardItemsArrayList.size();
    }
}
