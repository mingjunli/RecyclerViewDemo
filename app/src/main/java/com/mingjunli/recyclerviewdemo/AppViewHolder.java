package com.mingjunli.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mingjun on 16/6/22.
 */
public class AppViewHolder extends RecyclerView.ViewHolder {

    public ImageView mAppIcon;
    public TextView mAppName;

    public AppViewHolder(View itemView) {
        super(itemView);

        mAppIcon = (ImageView) itemView.findViewById(R.id.app_icon);
        mAppName = (TextView) itemView.findViewById(R.id.app_name);
    }
}
