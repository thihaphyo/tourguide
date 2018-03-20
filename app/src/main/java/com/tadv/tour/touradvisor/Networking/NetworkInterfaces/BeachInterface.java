package com.tadv.tour.touradvisor.Networking.NetworkInterfaces;

import com.tadv.tour.touradvisor.Models.BeachTabItems;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Z3US on 3/20/18.
 */

public interface BeachInterface {

    @GET("GetBeachTabs")
    Call<List<BeachTabItems>> getTabs();
}
