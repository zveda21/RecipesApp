package com.myrecipesapp.newrecipes.repo


import com.myrecipesapp.newrecipes.client.ApiClient
import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.DrinksResponse
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.Response
import com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals.DetailsResponse
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.MealsResponse
import retrofit2.Call

object Repo {
    fun getCategoryRecipes(): Call<Response> = ApiClient.apiClientInstance.getRecipesCategories()
    fun getSearchCategory(searchName: String): Call<MealsResponse> =
        ApiClient.apiClientInstance.getSearchCategoriesName(searchName)
    fun getIngridientMeals(mealsId:String):Call<DetailsResponse> = ApiClient.apiClientInstance.getDetailsMeals(mealsId)

    fun getDrinksOrdinary(): Call<DrinksResponse> = ApiClient.apidrinkInstance.getOrdinaryDrink()
}