package com.tadv.tour.touradvisor.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tadv.tour.touradvisor.Adapters.HomeAdpater;
import com.tadv.tour.touradvisor.Helpers.FragramentHelper;
import com.tadv.tour.touradvisor.Helpers.ProgressDialogHelper;
import com.tadv.tour.touradvisor.Helpers.RecyclerViewHelper;
import com.tadv.tour.touradvisor.Models.DashboardItems;
import com.tadv.tour.touradvisor.Networking.NetworkInterfaces.HomeInterface;
import com.tadv.tour.touradvisor.Networking.RetrofitInstance.RetrofitApi;
import com.tadv.tour.touradvisor.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 3/17/18.
 */

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdpater homeAdpater;
    private List<DashboardItems> dashboardItemsArrayList = new ArrayList<>();
    private MaterialDialog progressDoalog;
    protected ProgressDialogHelper progressDialogHelper;

    public HomeFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return FragramentHelper.CreateView(inflater,R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvHome);

        progressDialogHelper = new ProgressDialogHelper();
        progressDoalog = progressDialogHelper.ShowLoading(progressDoalog,getContext());



        HomeInterface service = RetrofitApi.getApiInstance().create(HomeInterface.class);
        Call<List<DashboardItems>> listCall = service.getDashboardItems();

        listCall.enqueue(new Callback<List<DashboardItems>>() {
            @Override
            public void onResponse(Call<List<DashboardItems>> call, Response<List<DashboardItems>> response) {

                progressDoalog.dismiss();
                dashboardItemsArrayList = response.body();
                Log.d("Response",call.request()+"");
                Log.d("RES",dashboardItemsArrayList.get(0).menu_name+"");
                RecyclerViewHelper.recyclerBuild(getContext(),recyclerView,homeAdpater,dashboardItemsArrayList);
            }

            @Override
            public void onFailure(Call<List<DashboardItems>> call, Throwable t) {
                progressDoalog.dismiss();
                t.printStackTrace();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
