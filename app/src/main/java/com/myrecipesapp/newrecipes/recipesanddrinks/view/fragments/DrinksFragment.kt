package com.myrecipesapp.newrecipes.recipesanddrinks.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.myrecipesapp.newrecipes.R
import com.myrecipesapp.newrecipes.adapters.CategoriesShowAdapter
import com.myrecipesapp.newrecipes.adapters.FragmentsViewPagerAdapter
import com.myrecipesapp.newrecipes.adapters.OrdinaryDrinksAdapter
import com.myrecipesapp.newrecipes.animationController.ZoomOutPageTransformer
import com.myrecipesapp.newrecipes.recipesanddrinks.drinksmodel.Drink
import com.myrecipesapp.newrecipes.recipesanddrinks.viewModels.OrdinaryDrinksViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_drinks.*
import kotlinx.android.synthetic.main.fragment_recipes_show.*


class DrinksFragment : Fragment() {

    private lateinit var  ordinaryDrinksViewModel : OrdinaryDrinksViewModel
    private  var  ordinaryDrinks :MutableList<Drink> = mutableListOf()
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_drinks, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showOrdinaryDrinks()
        ordinaryDrinksViewModel = ViewModelProviders.of(this).get(OrdinaryDrinksViewModel::class.java)
        ordinaryDrinksViewModel.ordinaryDrinksMutableLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("ViewFragmentModelDrinks-",it.toString())
            (ordinaryDrinksrecycler.adapter as OrdinaryDrinksAdapter).setItemDriks(it)
        })
        ordinaryDrinksViewModel.getOrdinarydrk()

    }
    private fun showOrdinaryDrinks(){
        ordinaryDrinksrecycler.layoutManager = GridLayoutManager(activity,2)
        ordinaryDrinksrecycler.adapter = OrdinaryDrinksAdapter(ordinaryDrinks)

    }



}
