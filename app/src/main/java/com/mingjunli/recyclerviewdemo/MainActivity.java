package com.mingjunli.recyclerviewdemo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AppInfo> mDataSet = new ArrayList<>();

    private RecyclerView mAppRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataSet();

        mAppRecyclerView = (RecyclerView) findViewById(R.id.apps);
        mAppRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppRecyclerAdapter adapter = new AppRecyclerAdapter(mDataSet);
        mAppRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.linear:
                mAppRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;

            case R.id.grid:
                mAppRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;

            case R.id.staggered_grid:
                mAppRecyclerView.setLayoutManager(
                        new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }

        return true;
    }

    private void initDataSet() {
        PackageManager pm = getPackageManager();
        List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
        for (PackageInfo packageInfo : packageInfos) {
            AppInfo appInfo = new AppInfo();
            appInfo.icon = packageInfo.applicationInfo.loadIcon(pm);
            appInfo.name = packageInfo.applicationInfo.loadLabel(pm);

            mDataSet.add(appInfo);
        }
    }
}
