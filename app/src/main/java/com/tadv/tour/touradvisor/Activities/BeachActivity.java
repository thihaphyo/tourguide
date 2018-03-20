package com.tadv.tour.touradvisor.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.tadv.tour.touradvisor.Helpers.ProgressDialogHelper;
import com.tadv.tour.touradvisor.Helpers.TabGenerator;
import com.tadv.tour.touradvisor.Models.BeachTabItems;
import com.tadv.tour.touradvisor.Networking.NetworkInterfaces.BeachInterface;
import com.tadv.tour.touradvisor.Networking.RetrofitInstance.RetrofitApi;
import com.tadv.tour.touradvisor.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Z3US on 3/20/18.
 */

public class BeachActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MaterialDialog progressDoalog;
    protected ProgressDialogHelper progressDialogHelper;
    private List<BeachTabItems> beachTabItemsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);

        progressDialogHelper = new ProgressDialogHelper();
        progressDoalog = progressDialogHelper.ShowLoading(progressDoalog,BeachActivity.this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        BeachInterface service = RetrofitApi.getApiInstance().create(BeachInterface.class);
        Call<List<BeachTabItems>> listCall = service.getTabs();

        listCall.enqueue(new Callback<List<BeachTabItems>>() {
            @Override
            public void onResponse(Call<List<BeachTabItems>> call, Response<List<BeachTabItems>> response) {
                progressDoalog.dismiss();
                beachTabItemsArrayList = response.body();

                Log.d("Response",call.request()+"");

            }

            @Override
            public void onFailure(Call<List<BeachTabItems>> call, Throwable t) {

                progressDoalog.dismiss();

                Log.d("Error",t.getMessage());

                t.printStackTrace();

            }
        });

        TextView tab = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);

        TabGenerator tabGenerator = new TabGenerator();
        tabGenerator.Generate(tabLayout,tab,beachTabItemsArrayList);

    }

}