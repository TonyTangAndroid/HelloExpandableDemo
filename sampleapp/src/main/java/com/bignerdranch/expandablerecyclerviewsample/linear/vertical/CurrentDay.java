package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class CurrentDay implements Parent<Hour> {

    private final String daytime;
    private final List<Hour> hourList;

    public CurrentDay(String name, List<Hour> hours) {
        daytime = name;
        hourList = hours;
    }

    public String daytime() {
        return daytime;
    }

    @Override
    public List<Hour> getChildList() {
        return hourList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public Hour getHour(int position) {
        return hourList.get(position);
    }

}
