package com.tadv.tour.touradvisor.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Z3US on 3/20/18.
 */

public class BeachTabItems {



    @Expose
    @SerializedName("tab_name")
    public String tab_name;


    public String getTab_name() {
        return tab_name;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

}
