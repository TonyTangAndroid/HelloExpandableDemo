package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import android.content.Intent;
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
public class VerticalLinearRecyclerViewSampleActivity extends AppCompatActivity{

    private RecipeAdapter mAdapter;

    @NonNull
    public static Intent newIntent(Context context) {
        return new Intent(context, VerticalLinearRecyclerViewSampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sample);

        Hour beef = new Hour("beef", false);
        Hour cheese = new Hour("cheese", true);
        Hour salsa = new Hour("salsa", true);
        Hour tortilla = new Hour("tortilla", true);
        Hour ketchup = new Hour("ketchup", true);
        Hour bun = new Hour("bun", true);

        CurrentDay taco = new CurrentDay("taco", Arrays.asList(beef, cheese, salsa, tortilla));
        CurrentDay quesadilla = new CurrentDay("quesadilla", Arrays.asList(cheese, tortilla));
        CurrentDay burger = new CurrentDay("burger", Arrays.asList(beef, cheese, ketchup, bun));
        final List<CurrentDay> currentDays = Arrays.asList(taco, quesadilla, burger);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new RecipeAdapter(this, currentDays);
        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @UiThread
            @Override
            public void onParentExpanded(int parentPosition) {
                CurrentDay expandedCurrentDay = currentDays.get(parentPosition);

                String toastMsg = getResources().getString(R.string.expanded, expandedCurrentDay.getName());
                Toast.makeText(VerticalLinearRecyclerViewSampleActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @UiThread
            @Override
            public void onParentCollapsed(int parentPosition) {
                CurrentDay collapsedCurrentDay = currentDays.get(parentPosition);

                String toastMsg = getResources().getString(R.string.collapsed, collapsedCurrentDay.getName());
                Toast.makeText(VerticalLinearRecyclerViewSampleActivity.this,
                        toastMsg,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }
}
