package com.tadv.tour.touradvisor.Networking.NetworkInterfaces;

import com.tadv.tour.touradvisor.Models.BeachTabItems;
import com.tadv.tour.touradvisor.Models.SliderUrl;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Z3US on 3/20/18.
 */

public interface BeachInterface {

    @GET("GetBeachTabs")
    Call<List<BeachTabItems>> getTabs();

    @GET("GetSliderUrl")
    Call<List<SliderUrl>> getSlider( @Query("beach_name") String beach_name);
}
