package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerviewsample.R;

import java.util.Arrays;
import java.util.List;

/**
 * Sample Activity for the vertical linear RecyclerView sample.
 * Uses ButterKnife to inject view resources.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class WeatherActivity extends AppCompatActivity{

    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Hour hour1 = new Hour("01:00am", "32F");
        Hour hour2 = new Hour("02:00am", "33F");
        Hour hour3 = new Hour("03:00am", "30F");
        Hour hour4 = new Hour("04:00am", "40F");

        CurrentDay today = new CurrentDay("Today", Arrays.asList(hour1, hour2, hour3));
        CurrentDay tomorrow = new CurrentDay("Tomorrow", Arrays.asList(hour2,hour3));
        CurrentDay thirdDay = new CurrentDay("Wednesday", Arrays.asList(hour1, hour2, hour4));
        final List<CurrentDay> currentDays = Arrays.asList(today, tomorrow, thirdDay);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        weatherAdapter = new WeatherAdapter(this, currentDays);
        weatherAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @UiThread
            @Override
            public void onParentExpanded(int parentPosition) {
                CurrentDay expandedCurrentDay = currentDays.get(parentPosition);
                String toastMsg = getResources().getString(R.string.expanded, expandedCurrentDay.daytime());
                Toast.makeText(WeatherActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @UiThread
            @Override
            public void onParentCollapsed(int parentPosition) {
                CurrentDay collapsedCurrentDay = currentDays.get(parentPosition);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedCurrentDay.daytime());
                Toast.makeText(WeatherActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        recyclerView.setAdapter(weatherAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        weatherAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        weatherAdapter.onRestoreInstanceState(savedInstanceState);
    }
}
