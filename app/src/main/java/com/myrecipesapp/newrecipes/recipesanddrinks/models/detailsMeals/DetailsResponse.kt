package com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals


import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)