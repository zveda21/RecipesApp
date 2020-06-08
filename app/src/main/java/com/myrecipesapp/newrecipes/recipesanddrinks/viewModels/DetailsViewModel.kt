package com.myrecipesapp.newrecipes.recipesanddrinks.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals.DetailsResponse
import com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals.Meal
import com.myrecipesapp.newrecipes.repo.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel(application: Application):AndroidViewModel(application) {

  val detailsLiveData:MutableLiveData<List<Meal>> = MutableLiveData()

    fun getDetails(idMeal:String){
        Repo.getIngridientMeals(idMeal).enqueue(object :Callback<DetailsResponse>{
            override fun onFailure(call: Call<DetailsResponse>, t: Throwable) {
                Log.e("Request Error",t.message!!)
            }

            override fun onResponse(
                call: Call<DetailsResponse>,
                response: Response<DetailsResponse>
            ) {
                if (response.isSuccessful){
                    detailsLiveData.value = response.body()?.meals
                    Log.d("Meals data***", detailsLiveData.value!![0].strMeal)
                }
            }

        })
    }
}