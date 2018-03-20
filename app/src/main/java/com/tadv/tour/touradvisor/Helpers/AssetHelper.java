package com.tadv.tour.touradvisor.Helpers;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by root on 3/17/18.
 */

public class AssetHelper {

    public static Typeface Load(AssetManager assetManager,String fontName){

       return  Typeface.createFromAsset(assetManager, fontName);
    }
}
