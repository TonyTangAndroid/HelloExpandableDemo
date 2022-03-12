package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

public class Hour {

    private final String time;
    private final String temp;

    public Hour(String name, boolean isVegetarian) {
        time = name;
        temp = String.valueOf(isVegetarian);
    }

    public String getName() {
        return time;
    }

    public String isVegetarian() {
        return temp;
    }
}
