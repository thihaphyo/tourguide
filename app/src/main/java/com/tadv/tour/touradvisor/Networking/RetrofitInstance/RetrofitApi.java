package com.tadv.tour.touradvisor.Networking.RetrofitInstance;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 3/17/18.
 */

public class RetrofitApi {

    public static Retrofit retrofit;
    private static final String BASE_URL ="http://192.168.100.52:8000/api/";


    public static Retrofit getApiInstance()
    {
        if(retrofit == null)
        {
          retrofit = new Retrofit.Builder()
                         .baseUrl(BASE_URL)
                         .addConverterFactory(GsonConverterFactory.create())
                         .build();

        }

        return retrofit;


    }
}
