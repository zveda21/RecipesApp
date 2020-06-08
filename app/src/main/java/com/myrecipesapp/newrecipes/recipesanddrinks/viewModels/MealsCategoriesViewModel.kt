package com.myrecipesapp.newrecipes.recipesanddrinks.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.MealsResponse
import com.myrecipesapp.newrecipes.repo.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsCategoriesViewModel(application: Application) : AndroidViewModel (application){
    val mealsCategoriesLiveData:MutableLiveData<List<Meal>> = MutableLiveData()

    fun getMealsCategories(messageName:String){
        Repo.getSearchCategory(messageName).enqueue(object :Callback<MealsResponse>{
            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                Log.e("Failure data", t.message!!)
            }
            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
              if (response.isSuccessful){
                  mealsCategoriesLiveData.value = response.body()?.meals
                  Log.d("MyViewModel", "data = ${ mealsCategoriesLiveData.value!![0].strMeal}")
              }
            }

        })

    }
}