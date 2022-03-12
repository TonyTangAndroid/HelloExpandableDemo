package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

public class Hour {

    private String mName;
    private boolean mIsVegetarian;

    public Hour(String name, boolean isVegetarian) {
        mName = name;
        mIsVegetarian = isVegetarian;
    }

    public String getName() {
        return mName;
    }

    public boolean isVegetarian() {
        return mIsVegetarian;
    }
}
