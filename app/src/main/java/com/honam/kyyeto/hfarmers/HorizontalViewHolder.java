package com.honam.kyyeto.hfarmers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HorizontalViewHolder extends RecyclerView.ViewHolder {

    public ImageView icon;
    public TextView description;

    public HorizontalViewHolder(View itemView) {
        super(itemView);

        icon = (ImageView) itemView.findViewById(R.id.horizon_icon);
        description = (TextView) itemView.findViewById(R.id.horizon_description);

    }
}
