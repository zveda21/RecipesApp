package com.myrecipesapp.newrecipes.recipesanddrinks.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myrecipesapp.newrecipes.recipesanddrinks.db.AppDataBase
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.Response
import com.myrecipesapp.newrecipes.repo.Repo
import retrofit2.Call
import retrofit2.Callback
import com.myrecipesapp.newrecipes.recipesanddrinks.models.categories.CategoriesItem as CategoriesItem

class ShowRecipesViewModel(application: Application) : AndroidViewModel(application) {
    val recipesMutableLiveData: MutableLiveData<List<CategoriesItem>> = MutableLiveData()
    private val db = AppDataBase.getInstance(application)
    private val showProgress: MutableLiveData<Boolean> = MutableLiveData()
    private val onErrorInet: MutableLiveData<Boolean> = MutableLiveData()

    fun getCategories() {
        showProgress.value = true
        Repo.getCategoryRecipes().enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("Error-Not data ", t.message!!)
                showProgress.value = false
                onErrorInet.value = true

            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {

                if (response.isSuccessful) {
                    showProgress.value = false
                    recipesMutableLiveData.value = response.body()?.categories
//                            db.categoriesDao().insert(recipesmutableLiveData.value)
//                         Log.d("DB -insert",db.toString())
//                            val categories = db.categoriesDao().loadCategories()
//
//                            for(category in categories!!){
//                                println(category)
//                            }
                    Log.d(
                        "MyViewModel",
                        "data = ${recipesMutableLiveData.value!![0].strCategoryDescription}"
                    )
                    onErrorInet.value = false

                }

            }

        })
    }

    fun getProgressState(): MutableLiveData<Boolean> {
        return showProgress
    }

    fun getError(): MutableLiveData<Boolean> {
        return onErrorInet
    }


//    fun getRecipesItem(recipesName:String):LiveData<Meals>{
//        Repo.getSearchCategory(recipesName).enqueue(object :Callback<Meal>{
//            override fun onFailure(call: Call<Meal>, t: Throwable) {
//                Log.e("Error-Not data ", t.message!!)
//            }
//
//            override fun onResponse(call: Call<Meal>, response: retrofit2.Response<Meal>) {
//             if (response.isSuccessful){
//
//             }
//            }
//
//        })
//    }

}