package com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.adapters.MealsCategoriesAdapter
import com.myrecipesapp.newrecipes.interfaces.OnItemClickListener
import com.myrecipesapp.newrecipes.recipesanddrinks.models.searchCategories.Meal
import com.myrecipesapp.newrecipes.recipesanddrinks.viewModels.MealsCategoriesViewModel
import kotlinx.android.synthetic.main.fragment_categories_meals.*


class CategoriesMealsFragment : Fragment() , OnItemClickListener {
    private val detailsFragment = DetailsFragment()
    private lateinit var mealsCategoriesViewModel: MealsCategoriesViewModel
    private var mealCategoriesList: MutableList<Meal> = mutableListOf()
    private lateinit var  mess :String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories_meals, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val  bundle = this.arguments
        if (bundle!=null){
            mess = bundle.getString("mealName").toString()
            Log.e("Name ****", mess)
        } else{
            Log.d("Nulll**",mess)
        }
        showMealsCategories()

        mealsCategoriesViewModel = ViewModelProviders.of(this).get(MealsCategoriesViewModel::class.java)
        mealsCategoriesViewModel.mealsCategoriesLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Meals data--", it.toString())
            (mealsCategoriesRecyclerView.adapter as MealsCategoriesAdapter).setItems(it)
        })
       mealsCategoriesViewModel.getMealsCategories(mess)
    }

    fun showMealsCategories() {
        mealsCategoriesRecyclerView.layoutManager = LinearLayoutManager(activity)
        mealsCategoriesRecyclerView.adapter = MealsCategoriesAdapter(mealCategoriesList,this)
    }

    override fun <T> onItemClicked(mealName: T) {
        if (mealName is Meal) {
            Log.d("CategoryName -- +", mealName.idMeal)
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val fragmentBundle :Bundle = Bundle()
            fragmentBundle.putString("mealName",mealName.idMeal)
            detailsFragment.arguments = fragmentBundle
            Log.d("Name**",mealName.idMeal)
            transaction?.replace(R.id.frame_fragment, detailsFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }




}
