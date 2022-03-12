package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerviewsample.R;

import java.util.List;

public class WeatherAdapter extends ExpandableRecyclerAdapter<CurrentDay, Hour, RecipeViewHolder, IngredientViewHolder> {


    private final LayoutInflater layoutInflater;

    public WeatherAdapter(Context context, @NonNull List<CurrentDay> currentDayList) {
        super(currentDayList);
        layoutInflater = LayoutInflater.from(context);
    }

    @UiThread
    @NonNull
    @Override
    public RecipeViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        return new RecipeViewHolder(layoutInflater.inflate(R.layout.item_day, parentViewGroup, false));
    }

    @UiThread
    @NonNull
    @Override
    public IngredientViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        return new IngredientViewHolder(layoutInflater.inflate(R.layout.ingredient_view, childViewGroup, false));
    }

    @UiThread
    @Override
    public void onBindParentViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int parentPosition, @NonNull CurrentDay currentDay) {
        recipeViewHolder.bind(currentDay);
    }

    @UiThread
    @Override
    public void onBindChildViewHolder(@NonNull IngredientViewHolder ingredientViewHolder, int parentPosition, int childPosition, @NonNull Hour hour) {
        ingredientViewHolder.bind(hour);
    }
}
