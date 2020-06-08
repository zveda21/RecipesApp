package com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("strDrink")
    val strDrink: String,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,
    @SerializedName("idDrink")
    val idDrink: String
)