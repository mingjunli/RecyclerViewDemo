package com.mingjunli.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mingjun on 16/6/22.
 */
public class AppRecyclerAdapter extends RecyclerView.Adapter<AppViewHolder> {

    private List<AppInfo> mAppList;

    public AppRecyclerAdapter(List<AppInfo> data){
        mAppList = data;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_card_view, parent, false);
        return new AppViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        AppInfo appInfo = mAppList.get(position);
        holder.mAppName.setText(appInfo.name);
        holder.mAppIcon.setImageDrawable(appInfo.icon);
    }

    @Override
    public int getItemCount() {
        return mAppList != null ? mAppList.size() : 0;
    }
}
