package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import androidx.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerviewsample.R;

public class HourHolder extends ChildViewHolder {

    private final TextView tv_hour;
    private final TextView tv_temp;

    public HourHolder(@NonNull View itemView) {
        super(itemView);
        tv_hour = itemView.findViewById(R.id.tv_hour);
        tv_temp = itemView.findViewById(R.id.tv_temp);
    }

    public void bind(@NonNull Hour hour) {
        tv_hour.setText(hour.getName());
        tv_temp.setText(hour.getTemp());
    }
}
