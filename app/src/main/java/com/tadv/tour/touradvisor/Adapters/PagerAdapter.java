package com.tadv.tour.touradvisor.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tadv.tour.touradvisor.Fragments.CFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Z3US on 3/21/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> tileList = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

      return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment,String title)
    {
        fragmentList.add(fragment);
        tileList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tileList.get(position);
    }
}
