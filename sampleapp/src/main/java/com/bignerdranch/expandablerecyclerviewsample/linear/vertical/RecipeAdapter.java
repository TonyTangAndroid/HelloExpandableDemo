package com.bignerdranch.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerviewsample.R;

import java.util.List;

public class RecipeAdapter extends ExpandableRecyclerAdapter<CurrentDay, Hour, RecipeViewHolder, IngredientViewHolder> {

    private static final int PARENT_VEGETARIAN = 0;
    private static final int PARENT_NORMAL = 1;
    private static final int CHILD_VEGETARIAN = 2;
    private static final int CHILD_NORMAL = 3;

    private LayoutInflater mInflater;
    private List<CurrentDay> mCurrentDayList;

    public RecipeAdapter(Context context, @NonNull List<CurrentDay> currentDayList) {
        super(currentDayList);
        mCurrentDayList = currentDayList;
        mInflater = LayoutInflater.from(context);
    }

    @UiThread
    @NonNull
    @Override
    public RecipeViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View recipeView;
        switch (viewType) {
            default:
            case PARENT_NORMAL:
                recipeView = mInflater.inflate(R.layout.recipe_view, parentViewGroup, false);
                break;
            case PARENT_VEGETARIAN:
                recipeView = mInflater.inflate(R.layout.vegetarian_recipe_view, parentViewGroup, false);
                break;
        }
        return new RecipeViewHolder(recipeView);
    }

    @UiThread
    @NonNull
    @Override
    public IngredientViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View ingredientView;
        switch (viewType) {
            default:
            case CHILD_NORMAL:
                ingredientView = mInflater.inflate(R.layout.ingredient_view, childViewGroup, false);
                break;
            case CHILD_VEGETARIAN:
                ingredientView = mInflater.inflate(R.layout.vegetarian_ingredient_view, childViewGroup, false);
                break;
        }
        return new IngredientViewHolder(ingredientView);
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

    @Override
    public int getParentViewType(int parentPosition) {
        if (mCurrentDayList.get(parentPosition).isVegetarian()) {
            return PARENT_VEGETARIAN;
        } else {
            return PARENT_NORMAL;
        }
    }

    @Override
    public int getChildViewType(int parentPosition, int childPosition) {
        Hour hour = mCurrentDayList.get(parentPosition).getIngredient(childPosition);
        if (hour.isVegetarian()) {
            return CHILD_VEGETARIAN;
        } else {
            return CHILD_NORMAL;
        }
    }

    @Override
    public boolean isParentViewType(int viewType) {
        return viewType == PARENT_VEGETARIAN || viewType == PARENT_NORMAL;
    }

}
