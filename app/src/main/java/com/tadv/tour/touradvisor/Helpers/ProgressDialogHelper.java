package com.tadv.tour.touradvisor.Helpers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tadv.tour.touradvisor.R;


/**
 * Created by root on 3/18/18.
 */

public class ProgressDialogHelper {

    public MaterialDialog ShowLoading(MaterialDialog progressDialog, Context context)
    {
        return  new MaterialDialog.Builder(context)
                .title(R.string.progress_dialog)
                .content(R.string.please_wait)
                .titleColor(context.getResources().getColor(R.color.colorPrimaryDark))
                .itemsColor(context.getResources().getColor(R.color.colorPrimary))
                .progress(true, 0)
                .contentColor(context.getResources().getColor(R.color.textColor))
                .show();
    }
}
