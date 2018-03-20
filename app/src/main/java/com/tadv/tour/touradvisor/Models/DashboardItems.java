package com.tadv.tour.touradvisor.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 3/17/18.
 */

public class DashboardItems {
    @Expose
    @SerializedName("menu_image_url")
    public String menu_image_url;
    @Expose
    @SerializedName("menu_name")
    public String menu_name;
    @Expose
    @SerializedName("menu_id")
    public int menu_id;
    @Expose
    @SerializedName("idx")
    public int idx;


    public String getMenu_image_url() {
        return menu_image_url;
    }

    public void setMenu_image_url(String menu_image_url) {
        this.menu_image_url = menu_image_url;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
