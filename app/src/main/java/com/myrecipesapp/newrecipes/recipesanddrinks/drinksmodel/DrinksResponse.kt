package com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel


import com.google.gson.annotations.SerializedName

data class DrinksResponse(
    @SerializedName("drinks")
    val drinks: List<Drink>
)