package com.tadv.tour.touradvisor.Networking.NetworkInterfaces;



import com.tadv.tour.touradvisor.Models.DashboardItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 3/17/18.
 */

public interface HomeInterface {

    @GET("GetHomeMenu")
    Call<List<DashboardItems>> getDashboardItems();
}
