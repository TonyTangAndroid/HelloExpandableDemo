package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerviewsample.R;

import java.util.List;

public class WeatherAdapter extends ExpandableRecyclerAdapter<CurrentDay, Hour, DayHolder, HourHolder> {


    private final LayoutInflater layoutInflater;

    public WeatherAdapter(Context context, @NonNull List<CurrentDay> currentDayList) {
        super(currentDayList);
        layoutInflater = LayoutInflater.from(context);
    }

    @UiThread
    @NonNull
    @Override
    public DayHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        return new DayHolder(layoutInflater.inflate(R.layout.item_day, parentViewGroup, false));
    }

    @UiThread
    @NonNull
    @Override
    public HourHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        return new HourHolder(layoutInflater.inflate(R.layout.ingredient_view, childViewGroup, false));
    }

    @UiThread
    @Override
    public void onBindParentViewHolder(@NonNull DayHolder dayHolder, int parentPosition, @NonNull CurrentDay currentDay) {
        dayHolder.bind(currentDay);
    }

    @UiThread
    @Override
    public void onBindChildViewHolder(@NonNull HourHolder hourHolder, int parentPosition, int childPosition, @NonNull Hour hour) {
        hourHolder.bind(hour);
    }
}
