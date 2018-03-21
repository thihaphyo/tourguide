package com.tadv.tour.touradvisor.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tadv.tour.touradvisor.Helpers.FragramentHelper;
import com.tadv.tour.touradvisor.Helpers.ProgressDialogHelper;
import com.tadv.tour.touradvisor.Models.DashboardItems;
import com.tadv.tour.touradvisor.Models.SliderUrl;
import com.tadv.tour.touradvisor.Networking.NetworkInterfaces.BeachInterface;
import com.tadv.tour.touradvisor.Networking.NetworkInterfaces.HomeInterface;
import com.tadv.tour.touradvisor.Networking.RetrofitInstance.RetrofitApi;
import com.tadv.tour.touradvisor.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by Z3US on 3/21/18.
 */

public class CFragment extends Fragment {

    private BannerSlider bannerSlider;
    private RecyclerView recyclerView;
    List<Banner> banners=new ArrayList<>();
    List<SliderUrl> sliderUrlList = new ArrayList<>();
    private MaterialDialog progressDoalog;
    protected ProgressDialogHelper progressDialogHelper;

    public CFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragramentHelper.CreateView(inflater, R.layout.fragment_chaungthar,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bannerSlider = view.findViewById(R.id.bannerSlider);

        progressDialogHelper = new ProgressDialogHelper();
        progressDoalog = progressDialogHelper.ShowLoading(progressDoalog,getContext());

        BeachInterface service = RetrofitApi.getApiInstance().create(BeachInterface.class);
        Call<List<SliderUrl>> listCall = service.getSlider("chaung_thar");

        listCall.enqueue(new Callback<List<SliderUrl>>() {
            @Override
            public void onResponse(Call<List<SliderUrl>> call, Response<List<SliderUrl>> response) {

                progressDoalog.dismiss();
                sliderUrlList = response.body();
                Log.d("Request",call.request()+"");
                Log.d("RES",response.body().get(0).getSlider_url()+"");
            }

            @Override
            public void onFailure(Call<List<SliderUrl>> call, Throwable t) {

                progressDoalog.dismiss();
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
