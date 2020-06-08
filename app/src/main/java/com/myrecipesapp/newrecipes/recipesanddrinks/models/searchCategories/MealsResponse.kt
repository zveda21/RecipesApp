package com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories


import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)