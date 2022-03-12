package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

public class Hour {

    private final String time;
    private final String temp;

    public Hour(String name, String temp) {
        time = name;
        this.temp = temp;
    }

    public String getName() {
        return time;
    }

    public String getTemp() {
        return temp;
    }
}
