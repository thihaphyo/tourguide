package com.tadv.tour.touradvisor.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Z3US on 3/21/18.
 */

public class SliderUrl {


    @Expose
    @SerializedName("slider_url")
    private String slider_url;


    public String getSlider_url() {
        return slider_url;
    }

    public void setSlider_url(String slider_url) {
        this.slider_url = slider_url;
    }
}
