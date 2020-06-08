package com.myrecipesapp.newrecipes.recipesanddrinks.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.Drink
import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.DrinksResponse
import com.myrecipesapp.newrecipes.repo.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrdinaryDrinksViewModel(application: Application) : AndroidViewModel(application) {

    val ordinaryDrinksMutableLiveData: MutableLiveData<List<Drink>> = MutableLiveData()

    fun getOrdinarydrk() {
        Repo.getDrinksOrdinary().enqueue(object : Callback<DrinksResponse> {
            override fun onFailure(call: Call<DrinksResponse>, t: Throwable) {
                Log.e("Drinks Ordinary View Model", t.message!!)
            }

            override fun onResponse(
                call: Call<DrinksResponse>,
                response: Response<DrinksResponse>
            ) {
                if (response.isSuccessful) {
                    ordinaryDrinksMutableLiveData.value = response.body()!!.drinks
                    Log.d(
                        "Drinks Ordinary ViewModel is ok",
                        ordinaryDrinksMutableLiveData.value!![0].strDrink
                    )
                }

            }

        })
    }

}