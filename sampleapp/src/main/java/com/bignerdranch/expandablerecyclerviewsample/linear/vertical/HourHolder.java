package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import androidx.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerviewsample.R;

public class HourHolder extends ChildViewHolder {

    private final TextView tv_hour;

    public HourHolder(@NonNull View itemView) {
        super(itemView);
        tv_hour = itemView.findViewById(R.id.tv_hour);
    }

    public void bind(@NonNull Hour hour) {
        tv_hour.setText(hour.getName());
    }
}
