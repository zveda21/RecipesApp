package com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.api.load

import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.recipesanddrinks.models.detailsMeals.Meal
import com.myrecipesapp.newrecipes.recipesanddrinks.viewModels.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var detailsViewModel: DetailsViewModel
    private var detailList: MutableList<Meal> = mutableListOf()
    private lateinit var idMessage: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            idMessage = bundle.getString("mealName").toString()
            Log.e("Name ****", idMessage)
        } else {
            Log.d("Nulll**", idMessage)
        }

        detailsViewModel =ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        detailsViewModel.detailsLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Details data--", it.toString())
            showViewData(it[0])
            ingredientName.text = it[0].strIngredient1+"\n"+ it[0].strIngredient2+"\n"+ it[0].strIngredient3+"\n"+ it[0].strIngredient4+"\n"+ it[0].strIngredient5+"\n"+ it[0].strIngredient6+"\n"+ it[0].strIngredient7+"\n"+ it[0].strIngredient8+"\n"+ it[0].strIngredient9+"\n"+ it[0].strIngredient10+"\n"+ it[0].strIngredient11+"\n"+ it[0].strIngredient12+"\n"+ it[0].strIngredient13+"\n"+ it[0].strIngredient14+"\n"+ it[0].strIngredient15+"\n"+ it[0].strIngredient16+"\n"+ it[0].strIngredient17+"\n"+ it[0].strIngredient18+"\n"+ it[0].strIngredient19+ it[0].strIngredient20
            ingredientWeight.text = it[0].strMeasure1+"\n"+it[0].strMeasure2+"\n"+it[0].strMeasure3+"\n"+it[0].strMeasure4+"\n"+it[0].strMeasure5+"\n"+it[0].strMeasure6+"\n"+it[0].strMeasure7 +"\n"+it[0].strMeasure8+"\n"+it[0].strMeasure9+"\n"+it[0].strMeasure10+"\n"+it[0].strMeasure11+"\n"+it[0].strMeasure12+"\n"+it[0].strMeasure13+"\n"+it[0].strMeasure14+"\n"+it[0].strMeasure15+"\n"+it[0].strMeasure16+"\n"+it[0].strMeasure17+"\n"+it[0].strMeasure18+"\n"+it[0].strMeasure19+"\n"+it[0].strMeasure20

        })
        Log.d("ID--",idMessage)
        detailsViewModel.getDetails(idMessage)

    }
    fun showViewData(detail : Meal){
        foodImage.load(Uri.parse(detail.strMealThumb))
        foodName.text = detail.strMeal
        categoryName.text = detail.strCategory
        countryName.text = detail.strArea
        instructionText.text = detail.strInstructions
        val url = detail.strYoutube
        watchOnYoutube(url)

    }
    fun watchOnYoutube(url:String){
        watchOnYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.google.android.youtube");
            startActivity(intent)
        }
    }


}
