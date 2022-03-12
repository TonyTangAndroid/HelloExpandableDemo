package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerviewsample.R;

public class DayHolder extends ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;

    @NonNull
    private final ImageView iv_expand;
    private final TextView tv_current_day;

    public DayHolder(@NonNull View itemView) {
        super(itemView);
        tv_current_day = itemView.findViewById(R.id.tv_current_day);
        iv_expand = itemView.findViewById(R.id.iv_expand);
    }

    public void bind(@NonNull CurrentDay currentDay) {
        tv_current_day.setText(currentDay.daytime());
    }

    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (expanded) {
            iv_expand.setRotation(ROTATED_POSITION);
        } else {
            iv_expand.setRotation(INITIAL_POSITION);
        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        RotateAnimation rotateAnimation;
        if (expanded) { // rotate clockwise
             rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        } else { // rotate counterclockwise
            rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        }

        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        iv_expand.startAnimation(rotateAnimation);
    }
}
