package com.myrecipesapp.newrecipes.client

import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.DrinksResponse
import retrofit2.Call
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.Response
import com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals.DetailsResponse
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesandDriksApis {

    @GET("api/json/v1/1/categories.php")
    fun getRecipesCategories(): Call<Response>
    @GET("api/json/v1/1/filter.php?c=Ordinary_Drink")
    fun getOrdinaryDrink():Call<DrinksResponse>
    @GET("api/json/v1/1/filter.php")
    fun getSearchCategoriesName(@Query("c") searchName:String): Call<MealsResponse>
    @GET("api/json/v1/1/lookup.php?")
    fun  getDetailsMeals(@Query("i") idMeals :String):Call<DetailsResponse>

}