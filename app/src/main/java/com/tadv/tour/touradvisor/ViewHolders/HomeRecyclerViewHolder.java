package com.tadv.tour.touradvisor.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.tadv.tour.touradvisor.CustomListeners.CardClickListener;
import com.tadv.tour.touradvisor.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by root on 3/17/18.
 */

public class HomeRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public CircleImageView imageView;
    public TextView txtItemName;
    public CardClickListener cardClickListener;


    public HomeRecyclerViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imgItem);
        txtItemName = itemView.findViewById(R.id.txtItemName);

        itemView.setOnClickListener(this);

    }


    public void setCardclickListener(CardClickListener cardclickListener){
        this.cardClickListener = cardclickListener;
    }


    @Override
    public void onClick(View view) {
        this.cardClickListener.onClick(getAdapterPosition());
    }
}
