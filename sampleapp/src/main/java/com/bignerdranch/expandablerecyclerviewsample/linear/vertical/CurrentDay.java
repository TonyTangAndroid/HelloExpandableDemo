package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class CurrentDay implements Parent<Hour> {

    private String mName;
    private List<Hour> mHours;

    public CurrentDay(String name, List<Hour> hours) {
        mName = name;
        mHours = hours;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<Hour> getChildList() {
        return mHours;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public Hour getIngredient(int position) {
        return mHours.get(position);
    }

    public boolean isVegetarian() {
        for (Hour hour : mHours) {
            if (!hour.isVegetarian()) {
                return false;
            }
        }
        return true;
    }
}
