package com.myrecipesapp.newrecipes.interfaces

import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal

interface OnItemClickListener {
    fun<T> onItemClicked(mealName: T)
}